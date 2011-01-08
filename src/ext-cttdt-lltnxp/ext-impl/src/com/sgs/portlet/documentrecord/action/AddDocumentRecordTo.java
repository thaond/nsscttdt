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
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;
import com.sgs.portlet.document.receipt.PmlEdmDocumentRecordToCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;

public class AddDocumentRecordTo extends PortletAction {

	private static Log _log = LogFactory.getLog(AddDocumentRecordTo.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res)throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			try {

				if (cmd.equals(Constants.DELETE)) {
//					boolean delete = deleteDocumentRecordSo(req);
//					redirect += "&delete=".concat(String.valueOf(delete));
					deleteDocumentRecordSo(req);
				}  else if (cmd.equals(Constants.UPDATE)) {
					updateDocumentRecordSo(req);
					
				}   else if (cmd.equals("ADD_SO_CVDEN")) {
					addDocumentRecord(req);
				}
				if (Validator.isNotNull(cmd)) {
					String documentRecordToURL = ParamUtil.getString(
							req, "documentRecordToURL");
					sendRedirect(req, res, documentRecordToURL);
				}
			} catch (Exception e) {
				if (e instanceof NoSuchPmlEdmDocumentRecordToException ||
						e instanceof PrincipalException) {

					SessionErrors.add(req, e.getClass().getName());
					setForward(req, "portlet.sgs.documentrecord.error");
				}
				else if (e instanceof PmlEdmDocumentRecordToCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
				}
				else {
					throw e;
				}
			}
			
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String tabCVDens = ParamUtil.getString(req, "tabCVDens"); 
		String tabs = ParamUtil.getString(req, "tabs"); 
		String redirect = ParamUtil.getString(req, "redirect");
		String typeAgen = ParamUtil.getString(req, "typeAgen");
		String currentRecord = ParamUtil.getString(req, "currentRecord");//YENLT UPDATE 21/04/2010
		
		req.setAttribute("tabCVDens", tabCVDens);
		req.setAttribute("tabs", tabs);
		req.setAttribute("redirect", redirect);
		req.setAttribute("typeAgen", typeAgen);
		req.setAttribute("currentRecord", currentRecord);//YENLT UPDATE 21/04/2010
		
		List<Agency> agencyList = new ArrayList<Agency>();
		List<Department> departmentList = new ArrayList<Department>();
		List<PmlEdmDocumentRecordType> listDocumentRecordType = new ArrayList<PmlEdmDocumentRecordType>();
		List<PmlEdmDocumentRecordTo> listDocumentRecordTo = new ArrayList<PmlEdmDocumentRecordTo>();
		
		try {
			agencyList = AgencyUtil.findAll();
			departmentList = DepartmentUtil.findAll();
			listDocumentRecordType = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch( SystemException e) {
			
		}
		
		req.setAttribute("agencyList", agencyList);
		req.setAttribute("departmentList", departmentList);
		req.setAttribute("listDocumentRecordType", listDocumentRecordType);
		req.setAttribute("listDocumentRecordTo", listDocumentRecordTo);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// available
		}
		else {
			
			if (cmd.equals(Constants.EDIT)) {
				editDocumentRecordSo(req);
				return mapping.findForward("portlet.sgs.documentrecord.socongvanden_edit");
				
			} else if (cmd.equals(Constants.ADD)) {
				return mapping.findForward("portlet.sgs.documentrecord.socongvanden_add");
			}  else if (cmd.equals("CHOICE")) {
				getListDocumentRecordExit(req);
				return mapping.findForward("portlet.sgs.documentrecord.socongvanden_add");
			}
			
			return mapping.findForward("portlet.sgs.documentrecord.view");
		}
	}
	
	public void getListDocumentRecordExit(RenderRequest req) {
		String agencyId = ParamUtil.getString(req, "agencyId");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String typeAgen = ParamUtil.getString(req, "typeAgen");
		String yearInUse = ParamUtil.getString(req, "yearInUse");
		
		List<PmlEdmDocumentRecordTo> listDocumentRecordTo = new ArrayList<PmlEdmDocumentRecordTo>();
		
		try {
			if ( "agency".equals(typeAgen)) {
				listDocumentRecordTo = PmlEdmDocumentRecordToUtil.findByYearInUse_AgencyId(yearInUse, agencyId);
			} else if ( "department".equals(typeAgen)) {
				listDocumentRecordTo = PmlEdmDocumentRecordToUtil.findByYearInUse_DepartmentsId(yearInUse, departmentId);
			}
		} catch( SystemException e) {
			
		}
		
		req.setAttribute("agencyId", agencyId);
		req.setAttribute("departmentId", departmentId);
		req.setAttribute("listDocumentRecordTo", listDocumentRecordTo);
	}
	
	public void addDocumentRecord(ActionRequest req) {
		
		String typeAgen = ParamUtil.getString(req, "typeAgen");
		Date dateCreate = ParamUtil.getDate(req, "dateCreate", new SimpleDateFormat("dd/MM/yyyy"), new Date());
		long currentRecord = ParamUtil.getLong(req, "currentRecord");
		String yearInUse = ParamUtil.getString(req, "yearInUse");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String agencyId = ParamUtil.getString(req, "agencyId");
		int[] listChecked = ParamUtil.getIntegerValues(req, "documentRecordTypes", new int[]{});
		
		PmlEdmDocumentRecordTo documentRecordTo = null;
		List<PmlEdmDocumentRecordTo> listCurrentExit = new ArrayList<PmlEdmDocumentRecordTo>();
		
		if ("agency".equals(typeAgen)) {
			try {
				listCurrentExit = PmlEdmDocumentRecordToUtil.findByYearInUse_AgencyId(yearInUse,agencyId);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} else if ("department".equals(typeAgen)) {
			try {
				listCurrentExit = PmlEdmDocumentRecordToUtil.findByYearInUse_DepartmentsId(yearInUse, departmentId);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}
		
		if ( listCurrentExit.size() != 0) {
			for (int j=0; j<listCurrentExit.size(); j++) {
				try {
					PmlEdmDocumentRecordToLocalServiceUtil.deletePmlEdmDocumentRecordTo(listCurrentExit.get(j));
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		for ( int i=0; i <listChecked.length; i++) {
			
			documentRecordTo = new PmlEdmDocumentRecordToImpl();
			try {
				documentRecordTo.setDocumentRecordToId(CounterUtil.increment());
				documentRecordTo.setDateCreate(dateCreate);
				documentRecordTo.setCurrentRecord(currentRecord);
				documentRecordTo.setDocumentRecordTypeId(listChecked[i]);
				documentRecordTo.setYearInUse(yearInUse);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if ("agency".equals(typeAgen)) {
				//set isagency = 1
				documentRecordTo.setAgencyId(agencyId);
				documentRecordTo.setIsAgency("1");
			} else if ("department".equals(typeAgen)) {
				//set isagency = 0
				documentRecordTo.setDepartmentsId(departmentId);
				documentRecordTo.setIsAgency("0");
			}
			
			try {
				PmlEdmDocumentRecordToLocalServiceUtil.addPmlEdmDocumentRecordTo(documentRecordTo);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void deleteDocumentRecordSo(ActionRequest req) throws Exception {
		long documentRecordToId = ParamUtil.getLong(req, "documentRecordToId");
		PmlEdmDocumentRecordToLocalServiceUtil.removePmlEdmPrivilegeLevel(documentRecordToId);
	}
	
	
	public void editDocumentRecordSo(RenderRequest req) {
		String typeAgen = ParamUtil.getString(req, "typeAgen");
		long documentRecordToId = ParamUtil.getLong(req, "documentRecordToId");
		
		PmlEdmDocumentRecordTo documentRecordTo = null;
		PmlEdmDocumentRecordType documentRecordType = null;
		Agency agency = null;
		Department department = null;
		
		String documentRecordTypeName = "";
		String agencyName = "";
		String departmentName = "";
		try {
			documentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getPmlEdmDocumentRecordTo(documentRecordToId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= documentRecordTo) {
			try {
				documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(documentRecordTo.getDocumentRecordTypeId());
			} catch (SystemException e) {
				_log.error(e);
				_log.error("NO GET PmlEdmDocumentRecordType ");
			}
			
			if ("agency".equals(typeAgen)) {
				try {
					agency = AgencyUtil.fetchByPrimaryKey(documentRecordTo.getAgencyId());
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
				if ( null!= agency) {
					agencyName = agency.getAgencyName();
				}
			} else if ("department".equals(typeAgen)) {
				try {
					department = DepartmentUtil.fetchByPrimaryKey(documentRecordTo.getDepartmentsId());
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
			
			req.setAttribute("documentRecord", documentRecordTo);
			req.setAttribute("documentRecordTypeName", documentRecordTypeName);
			req.setAttribute("agencyName", agencyName);
			req.setAttribute("departmentName", departmentName);
		}
		
	}
	
	public void updateDocumentRecordSo(ActionRequest req) {
		long documentRecordToId = ParamUtil.getLong(req, "documentRecordToId");
		long currentRecord = ParamUtil.getLong(req, "currentRecord");
		
		PmlEdmDocumentRecordTo documentRecordTo = null;
		try {
			documentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getPmlEdmDocumentRecordTo(documentRecordToId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= documentRecordTo) {
			documentRecordTo.setCurrentRecord(currentRecord);
			
			try {
				PmlEdmDocumentRecordToLocalServiceUtil.updatePmlEdmDocumentRecordTo(documentRecordTo);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editDocumentRecordPB(RenderRequest req) {
		long documentRecordToId = ParamUtil.getLong(req, "documentRecordToId");
		PmlEdmDocumentRecordTo documentRecordTo = null;
		PmlEdmDocumentRecordType documentRecordType = null;
		Department department = null;
		String documentRecordTypeName = "";
		String departmentName = "";
		try {
			documentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getPmlEdmDocumentRecordTo(documentRecordToId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( null!= documentRecordTo) {
			try {
				documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(documentRecordTo.getDocumentRecordTypeId());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			try {
				department = DepartmentUtil.fetchByPrimaryKey(documentRecordTo.getDepartmentsId());
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
			req.setAttribute("documentRecord", documentRecordTo);
		}
		
	}
	
}
