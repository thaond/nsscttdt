package com.sgs.portlet.documentrecord.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.persistence.AgencyUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;
import com.sgs.portlet.document.send.PmlEdmBookDocumentSendCanNotDeleteException;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;

public class AddDocumentRecordSend extends PortletAction {
	private static Log _log = LogFactory.getLog(AddDocumentRecordSend.class);	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res)throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD);
		try {
			if (cmd.equals(Constants.DELETE)) {
//					boolean delete = deleteBookRecordSo(req);
//					redirect += "&delete=".concat(String.valueOf(delete));
				 deleteBookRecordSo(req);
			}  else if (cmd.equals(Constants.UPDATE)) {
				updateBookRecordSo(req);
				
			} else if (cmd.equals("ADD_SO_CVDI")) {
				addBookRecord(req);
			} 
			if (Validator.isNotNull(cmd)) {
				String bookRecordURL = ParamUtil.getString(
						req, "bookRecordURL");
				sendRedirect(req, res, bookRecordURL);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmBookDocumentSendException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.documentrecord.error");
			}
			else if (e instanceof PmlEdmBookDocumentSendCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
			
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)throws Exception {
		String tabCVDi = ParamUtil.getString(req, "tabCVDi"); 
		String tabs = ParamUtil.getString(req, "tabs"); 
		String redirect = ParamUtil.getString(req, "redirect");
		String typeAgen = ParamUtil.getString(req, "typeAgenCVDi");
		String currentRecord = ParamUtil.getString(req, "currentRecord");//YENLT UPDATE 21/04/2010
		
		req.setAttribute("tabCVDi", tabCVDi);
		req.setAttribute("tabs", tabs);
		req.setAttribute("redirect", redirect);
		req.setAttribute("typeAgenCVDi", typeAgen);
		req.setAttribute("currentRecord", currentRecord);//YENLT UPDATE 21/04/2010
		
		List<Agency> agencyList = new ArrayList<Agency>();
		List<Department> departmentList = new ArrayList<Department>();
		List<PmlEdmDocumentRecordType> listDocumentRecordType = new ArrayList<PmlEdmDocumentRecordType>();
		List<PmlEdmBookDocumentSend> listBookDocumentSend = new ArrayList<PmlEdmBookDocumentSend>();
		
		try {
			agencyList = AgencyUtil.findAll();
			departmentList = DepartmentUtil.findAll();
			listDocumentRecordType = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch(SystemException e){
			
		}
		
		req.setAttribute("agencyList", agencyList);
		req.setAttribute("departmentList", departmentList);
		req.setAttribute("listDocumentRecordType", listDocumentRecordType);
		req.setAttribute("listBookDocumentSend", listBookDocumentSend);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// available
		}
		else {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			
			if (cmd.equals(Constants.EDIT)) {
				editBookRecord(req);
				return mapping.findForward("portlet.sgs.documentrecord.socongvandi_edit");
				
			} else if (cmd.equals(Constants.ADD)) {
				//createBookRecord(req);
				return mapping.findForward("portlet.sgs.documentrecord.socongvandi_add");
			} else if (cmd.equals("CHOICE")) {
				getListBookRecordExit(req);
				return mapping.findForward("portlet.sgs.documentrecord.socongvandi_add");
			}
			return mapping.findForward("portlet.sgs.documentrecord.view");
		}
	}
	
	public void getListBookRecordExit(RenderRequest req) {
		String agencyId = ParamUtil.getString(req, "agencyId");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String typeAgenCVDi = ParamUtil.getString(req, "typeAgenCVDi");
		String yearInUse = ParamUtil.getString(req, "yearInUse");
		
		List<PmlEdmBookDocumentSend> listBookDocumentSend = new ArrayList<PmlEdmBookDocumentSend>();
		
		try {
			if ( "agency".equals(typeAgenCVDi)) {
				listBookDocumentSend = PmlEdmBookDocumentSendUtil.findByYearInUse_AgencyId(yearInUse, agencyId);
			} else if ( "department".equals(typeAgenCVDi)) {
				listBookDocumentSend = PmlEdmBookDocumentSendUtil.findByYearInUse_DepartmentsId(yearInUse, departmentId);
			}
		} catch( Exception e) {
			
		}
		
		req.setAttribute("agencyId", agencyId);
		req.setAttribute("departmentId", departmentId);
		req.setAttribute("listBookDocumentSend", listBookDocumentSend);
	}
	
	public void addBookRecord(ActionRequest req) {
		
		String typeAgenCVDi = ParamUtil.getString(req, "typeAgenCVDi");
		Date dateCreate = ParamUtil.getDate(req, "dateCreate", new SimpleDateFormat("dd/MM/yyyy"), new Date());
		long currentRecord = ParamUtil.getLong(req, "currentRecord");
		String yearInUse = ParamUtil.getString(req, "yearInUse");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String agencyId = ParamUtil.getString(req, "agencyId");
		int[] listChecked = ParamUtil.getIntegerValues(req, "documentRecordTypes", new int[]{});
		
		PmlEdmBookDocumentSend bookDocumentSend = null;
		List<PmlEdmBookDocumentSend> listCurrentExit = new ArrayList<PmlEdmBookDocumentSend>();
		
		if ("agency".equals(typeAgenCVDi)) {
			try {
				listCurrentExit = PmlEdmBookDocumentSendUtil.findByYearInUse_AgencyId(yearInUse,agencyId);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} else if ("department".equals(typeAgenCVDi)) {
			try {
				listCurrentExit = PmlEdmBookDocumentSendUtil.findByYearInUse_DepartmentsId(yearInUse, departmentId);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}
		
		if ( listCurrentExit.size() != 0) {
			for (int j=0; j<listCurrentExit.size(); j++) {
				// vu update 20110121 xoa di neu so van ban da ton tai
				for(int i=0; i <listChecked.length; i++){
					if(listCurrentExit.get(j).getDocumentRecordTypeId() == listChecked[i] &&
								listCurrentExit.get(j).getCurrentRecord()== currentRecord){
						try {
							PmlEdmBookDocumentSendLocalServiceUtil.deletePmlEdmBookDocumentSend(listCurrentExit.get(j));
						} catch (SystemException e) {
							e.printStackTrace();
						}
					}
				} 
				// end vu update 20110121
				
		}
		}
		
		for ( int i=0; i <listChecked.length; i++) {
			bookDocumentSend = new PmlEdmBookDocumentSendImpl();
			try {
				bookDocumentSend.setBookDocumentSendId(CounterUtil.increment());
				bookDocumentSend.setDateCreated(dateCreate);
				bookDocumentSend.setCurrentRecord(currentRecord);
				bookDocumentSend.setDocumentRecordTypeId(listChecked[i]);
				bookDocumentSend.setYearInUse(yearInUse);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if ("agency".equals(typeAgenCVDi)) {
				//set isagency = 1
				bookDocumentSend.setAgencyId(agencyId);
				bookDocumentSend.setIsAgency("1");
			} else if ("department".equals(typeAgenCVDi)) {
				//set isagency = 0
				bookDocumentSend.setDepartmentsId(departmentId);
				bookDocumentSend.setIsAgency("0");
			}
			
			try {
				PmlEdmBookDocumentSendLocalServiceUtil.addPmlEdmBookDocumentSend(bookDocumentSend);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteBookRecordSo(ActionRequest req) throws Exception {
		long bookRecordSendId = ParamUtil.getLong(req, "bookRecordSendId");
		PmlEdmBookDocumentSendLocalServiceUtil.removePmlEdmPrivilegeLevel(bookRecordSendId);
	}
	
	
	public void editBookRecord(RenderRequest req) {
		String typeAgenCVDi = ParamUtil.getString(req, "typeAgenCVDi");
		long bookRecordSendId = ParamUtil.getLong(req, "bookRecordSendId");
		
		PmlEdmBookDocumentSend bookRecordSend = null;
		PmlEdmDocumentRecordType documentRecordType = null;
		Agency agency = null;
		Department department = null;
		
		String documentRecordTypeName = "";
		String agencyName = "";
		String departmentName = "";
		try {
			bookRecordSend = PmlEdmBookDocumentSendLocalServiceUtil.getPmlEdmBookDocumentSend(bookRecordSendId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= bookRecordSend) {
			try {
				documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(bookRecordSend.getDocumentRecordTypeId());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			if ("agency".equals(typeAgenCVDi)) {
				try {
					agency = AgencyUtil.fetchByPrimaryKey(bookRecordSend.getAgencyId());
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
				if ( null!= agency) {
					agencyName = agency.getAgencyName();
				}
			} else if ("department".equals(typeAgenCVDi)) {
				try {
					department = DepartmentUtil.fetchByPrimaryKey(bookRecordSend.getDepartmentsId());
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
				if ( null!= department) {
					departmentName = department.getDepartmentsName();
					
				}
			}
			
			if ( null!= documentRecordType) {
				documentRecordTypeName = documentRecordType.getDocumentRecordTypeName();
			}
			
			req.setAttribute("bookRecordSend", bookRecordSend);
			req.setAttribute("documentRecordTypeName", documentRecordTypeName);
			req.setAttribute("agencyName", agencyName);
			req.setAttribute("departmentName", departmentName);
		}
		
	}
	
	public void updateBookRecordSo(ActionRequest req) {
		long bookRecordSendId = ParamUtil.getLong(req, "bookRecordSendId");
		long currentRecord = ParamUtil.getLong(req, "currentRecord");
		
		PmlEdmBookDocumentSend bookRecordSend = null;
		try {
			bookRecordSend = PmlEdmBookDocumentSendLocalServiceUtil.getPmlEdmBookDocumentSend(bookRecordSendId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= bookRecordSend) {
			bookRecordSend.setCurrentRecord(currentRecord);
			
			try {
				PmlEdmBookDocumentSendLocalServiceUtil.updatePmlEdmBookDocumentSend(bookRecordSend);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editBookRecordPB(RenderRequest req) {
		long bookRecordSendId = ParamUtil.getLong(req, "bookRecordSendId");		
		PmlEdmBookDocumentSend bookRecordSend = null;
		PmlEdmDocumentRecordType documentRecordType = null;
		Department department = null;
		String documentRecordTypeName = "";
		String departmentName = "";
		try {
			bookRecordSend = PmlEdmBookDocumentSendLocalServiceUtil.getPmlEdmBookDocumentSend(bookRecordSendId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= bookRecordSend) {
			try {
				documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(bookRecordSend.getDocumentRecordTypeId());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			try {
				department = DepartmentUtil.fetchByPrimaryKey(bookRecordSend.getDepartmentsId());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			if ( null!= department) {
				departmentName = department.getDepartmentsName();
			
			}
			if ( null!= documentRecordType) {
				documentRecordTypeName = documentRecordType.getDocumentRecordTypeName();
			}
			req.setAttribute("documentRecordTypeName", documentRecordTypeName);
			req.setAttribute("departmentName", departmentName);
			req.setAttribute("bookRecordSend", bookRecordSend);
		}
		
	}
	
}
