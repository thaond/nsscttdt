package com.sgs.portlet.pmllevelsend.action;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		String cmd = ParamUtil.getString(req, "cmd");
		if(Validator.isNull(cmd) == false) {
			boolean messageFlag = true;
			if(cmd.equals("add_process")) {
				messageFlag = addProcess(req);
			} else if(cmd.equals("edit_process")) {
				messageFlag = editProcess(req);
			}
			req.setAttribute("messageFlag", messageFlag);
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
					} else if(page.equals("delete")) { // delete page
						messageFlag = delete(req);
					}
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
					int totalRows = searchFlag == false ? PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSendsCount() : getLevelSendList(searchFlag, key, filter).size();
					int totalPages = totalRows / limit;
					totalPages = totalRows % limit == 0 ? totalPages : totalPages + 1;
					
					int start = (_page - 1) * limit;
					int end = _page * limit;
					List<PmlEdmLevelSend> levelSendList = getLevelSendList(searchFlag, key, filter, start, end);
					req.setAttribute("attLevelSendList", levelSendList);
					req.setAttribute("currentPage", _page);
					req.setAttribute("totalPages", totalPages);
					req.setAttribute("totalOfItems", totalRows);
				}
				return mapping.findForward("portlet.sgs.pmllevelsend.view");
			}
	}
	
	/**
	 * lay danh sach LevelSend
	 * 
	 * @param searchFlag:
	 * 		true - su dung chuc nang tim kiem
	 * 		false - khong su dung (lay tat ca danh sach)	
	 * @param key: tu khoa tim kiem
	 * @param filter: loc theo thuoc tinh
	 * 
	 * @return List
	 */
	private List<PmlEdmLevelSend> getLevelSendList(boolean searchFlag, String key, int filter) throws Exception {

		List<PmlEdmLevelSend> levelSendList = new ArrayList<PmlEdmLevelSend>();
		if(searchFlag == true && key != null) {
			switch(filter) {
			case 1:
				levelSendList = PmlEdmLevelSendUtil.findByLevelSendName("%" + key + "%");
				break;
			default:
				levelSendList = PmlEdmLevelSendUtil.findByLevelSendName("%" + key + "%");
				break;
			}
		} else {
			levelSendList = PmlEdmLevelSendUtil.findAll();
		}
		return levelSendList;
	}
	
	/**
	 * lay danh sach LevelSend
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
	private List<PmlEdmLevelSend> getLevelSendList(boolean searchFlag, String key, int filter, int start, int end) throws Exception {

		List<PmlEdmLevelSend> levelSendList = new ArrayList<PmlEdmLevelSend>();
		if(searchFlag == true && key != null) {
			switch(filter) {
			case 1:
				levelSendList = PmlEdmLevelSendUtil.findByLevelSendName("%" + key + "%", start, end);
				break;
			default:
				levelSendList = PmlEdmLevelSendUtil.findByLevelSendName("%" + key + "%", start, end);
				break;
			}
		} else {
			levelSendList = PmlEdmLevelSendUtil.findAll();
		}
		return levelSendList;
	}
	
	/*
	 * 
	 */
	private boolean addProcess(ActionRequest req) throws Exception {

		boolean messageFlag = true;
		try {
			PmlEdmLevelSend levelSend = new PmlEdmLevelSendImpl();
			levelSend.setLevelSendId(Integer.parseInt(CounterUtil.increment() + ""));
			levelSend.setLevelSendName(ParamUtil.getString(req, "levelSendName"));
			PmlEdmLevelSendLocalServiceUtil.addPmlEdmLevelSend(levelSend);
		} catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}

	/*
	 * 
	 */
	private boolean edit(RenderRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			int levelSendId = ParamUtil.getInteger(req, "levelSendId");
			req.setAttribute("attLevelSend", PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSend(levelSendId));
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	
	/*
	 * 
	 */
	private boolean editProcess(ActionRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			PmlEdmLevelSend levelSend = new PmlEdmLevelSendImpl();
			levelSend.setLevelSendId(ParamUtil.getInteger(req, "levelSendId"));
			levelSend.setLevelSendName(ParamUtil.getString(req, "levelSendName"));
			PmlEdmLevelSendLocalServiceUtil.updatePmlEdmLevelSend(levelSend);
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	
	/*
	 * 
	 */
	private boolean delete(RenderRequest req) throws Exception {
		
		boolean messageFlag = true;
		try {
			int levelSendId = ParamUtil.getInteger(req, "levelSendId");
			PmlEdmLevelSendLocalServiceUtil.deletePmlEdmLevelSend(levelSendId);
		}catch(Exception e) {
			messageFlag = false;
		}
		return messageFlag;
	}
	
}
