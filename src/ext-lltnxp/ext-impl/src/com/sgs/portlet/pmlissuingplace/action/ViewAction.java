package com.sgs.portlet.pmlissuingplace.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;
import com.sgs.portlet.pmlissuingplace.PmlEdmIssuingPlaceCanNotDeleteException;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		String cmd = ParamUtil.getString(req, "cmd");
		try {
			if(Validator.isNull(cmd) == false) {
				boolean messageFlag = true;
				if(cmd.equals("add_process")) {
					messageFlag = addProcess(req);
				} else if(cmd.equals("edit_process")) {
					messageFlag = editProcess(req);
				}
				req.setAttribute("messageFlag", messageFlag);
			}
			
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmIssuingPlaceException ||
					e instanceof PrincipalException) {

					SessionErrors.add(req, e.getClass().getName());

					setForward(req, "portlet.sgs.pml_tinh_chat.error");
				}
				else if (e instanceof PmlEdmIssuingPlaceCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
				}
				else {
					throw e;
				}
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				/*
				 * kiem tra, chuan bi du lieu hien thi o cac trang list, edit, delete
				 * va set bien messageFlag la ket qua thuc hien cac chuc nang edit, delete
				 * 			- true	: thuc hien thanh cong
				 * 			- flase	: co loi xay ra
				 */
				String page = ParamUtil.getString(req, "page");
				if(Validator.isNull(page) == false) {
					boolean messageFlag = true;
					if(page.equals("edit")) { // edit page
						messageFlag = edit(req);
					} 
//					else if(page.equals("delete")) { // delete page
//						messageFlag = delete(req);
//					}
					req.setAttribute("messageFlag", messageFlag);
				} else { // list
					
					/*
					 * kiem tra nguoi dung co su dung chuc nang tim kiem khong?
					 */
					boolean searchFlag = false; // default: khong su dung
					int filter = 0; // tim kiem tat ca
					String key = ""; // tu khoa tim kiem
					if(Validator.isNull(ParamUtil.getString(req, "searchFlag")) == false) { // neu nguoi dung su dung chuc nang tim kiem
						searchFlag = true; // dat lai trang thai co
						filter = ParamUtil.getInteger(req, "filter"); // lay bo loc
						req.setAttribute("filter", filter);
						key = ParamUtil.getString(req, "key"); // lay tu khoa
					} 
					
					/*
					 * Phan trang 
					 */
					
					// get current page
					int _page = 1;
					if(req.getParameter("_page") != null) _page = ParamUtil.getInteger(req, "_page");
					
					// get total item of page
					int limit = 20; // default
					//if(req.getParameter("limit") != null) limit = Integer.parseInt(req.getParameter("limit"));
					
					// get total rows, total pages
					int totalRows = searchFlag == false ? PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSendsCount() : getIssuingPlaceList(searchFlag, key, filter).size();
					int totalPages = totalRows / limit;
					totalPages = totalRows % limit == 0 ? totalPages : totalPages + 1;
					
					int start = (_page - 1) * limit;
					int end = _page * limit;
					List<PmlEdmIssuingPlace> issuingPlaceList = getIssuingPlaceList(searchFlag, key, filter, start, end);
					req.setAttribute("attIssuingPlaceList", issuingPlaceList);
					req.setAttribute("currentPage", _page);
					req.setAttribute("totalPages", totalPages);
					req.setAttribute("totalOfItems", totalRows);
				}
				return mapping.findForward("portlet.sgs.pmlissuingplace.view");
			}
	}
	
	/**
	 * lay danh sach IssuingPlace
	 * 
	 * @param searchFlag:
	 * 		true - su dung chuc nang tim kiem
	 * 		false - khong su dung (lay tat ca danh sach)	
	 * @param key: tu khoa tim kiem
	 * @param filter: loc theo thuoc tinh
	 * 
	 * @return List
	 */
	private List<PmlEdmIssuingPlace> getIssuingPlaceList(boolean searchFlag, String key, int filter) throws Exception {

		List<PmlEdmIssuingPlace> issuingPlaceList = new ArrayList<PmlEdmIssuingPlace>();
		if(searchFlag == true && key != null) {
			switch(filter) {
			case 1:
				issuingPlaceList = PmlEdmIssuingPlaceUtil.findByIssuingPlaceName("%" + key + "%");
				break;
			default:
				issuingPlaceList = PmlEdmIssuingPlaceUtil.findByIssuingPlaceName("%" + key + "%");
				break;
			}
		} else {
			issuingPlaceList = PmlEdmIssuingPlaceUtil.findAll();
		}
		return issuingPlaceList;
	}
	
	/**
	 * lay danh sach IssuingPlace
	 * 
	 * @param searchFlag:
	 * 		true - su dung chuc nang tim kiem
	 * 		false - khong su dung (lay tat ca danh sach)	
	 * @param key: tu khoa tim kiem
	 * @param filter: loc theo thuoc tinh
	 * @param start: dong bat dau 
	 * @param end: dong ket thuc
	 * 
	 * @return List
	 */
	private List<PmlEdmIssuingPlace> getIssuingPlaceList(boolean searchFlag, String key, int filter, int start, int end) throws Exception {

		List<PmlEdmIssuingPlace> issuingPlaceList = new ArrayList<PmlEdmIssuingPlace>();
		if(searchFlag == true && key != null) {
			switch(filter) {
			case 1:
				issuingPlaceList = PmlEdmIssuingPlaceUtil.findByIssuingPlaceName("%" + key + "%", start, end);
				break;
			default:
				issuingPlaceList = PmlEdmIssuingPlaceUtil.findByIssuingPlaceName ("%" + key + "%", start, end);
				break;
			}
		} else {
			issuingPlaceList = PmlEdmIssuingPlaceUtil.findAll(start, end);
		}
		return issuingPlaceList;
	}
	
	/**
	 * 
	 */
	private boolean addProcess(ActionRequest req) throws Exception {

		boolean messageFlag = true;
		try {
			PmlEdmIssuingPlace issuingPlace = new PmlEdmIssuingPlaceImpl();
			issuingPlace.setIssuingPlaceId(CounterUtil.increment() + "");
			issuingPlace.setIssuingPlaceName(ParamUtil.getString(req, "issuingPlaceName"));
			issuingPlace.setAddress(ParamUtil.getString(req, "address"));
			issuingPlace.setEmail(ParamUtil.getString(req, "email"));
			issuingPlace.setTablePhone(ParamUtil.getString(req, "telephone"));
			issuingPlace.setHandPhone(ParamUtil.getString(req, "mobile"));
			issuingPlace.setActive(1 + "");
			issuingPlace.setNote(ParamUtil.getString(req, "description"));
			PmlEdmIssuingPlaceLocalServiceUtil.addPmlEdmIssuingPlace(issuingPlace);
		} catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}

	/**
	 * 
	 */
	private boolean edit(RenderRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
			req.setAttribute("attIssuingPlace", PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(issuingPlaceId));
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	
	/**
	 * 
	 */
	private boolean editProcess(ActionRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			PmlEdmIssuingPlace issuingPlace = new PmlEdmIssuingPlaceImpl();
			issuingPlace.setIssuingPlaceId(ParamUtil.getString(req, "issuingPlaceId"));
			issuingPlace.setIssuingPlaceName(ParamUtil.getString(req, "issuingPlaceName"));
			issuingPlace.setAddress(ParamUtil.getString(req, "address"));
			issuingPlace.setEmail(ParamUtil.getString(req, "email"));
			issuingPlace.setTablePhone(ParamUtil.getString(req, "telephone"));
			issuingPlace.setHandPhone(ParamUtil.getString(req, "mobile"));
			issuingPlace.setActive(ParamUtil.getInteger(req, "active") +  "");
			issuingPlace.setNote(ParamUtil.getString(req, "description"));
			
			PmlEdmIssuingPlaceLocalServiceUtil.updatePmlEdmIssuingPlace(issuingPlace);
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	
	/**
	 * 
	 */
	/*
	private boolean delete(RenderRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
			PmlEdmIssuingPlaceLocalServiceUtil.deletePmlEdmIssuingPlace(issuingPlaceId);
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	*/
	protected void delete(RenderRequest req) throws Exception {
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
		String a = "true";
		if (a.equals("false")) {
			PmlEdmIssuingPlaceLocalServiceUtil.deletePmlEdmIssuingPlace(issuingPlaceId);
		}
	}

}
