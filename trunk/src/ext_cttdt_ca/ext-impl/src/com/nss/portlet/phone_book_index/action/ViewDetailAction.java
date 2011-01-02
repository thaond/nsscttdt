package com.nss.portlet.phone_book_index.action;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil;

public class ViewDetailAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewDetailAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/phone_book_index/view_detail");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if(cmd.equals(Constants.ADD)){
				addDetailBook(req);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals("DETAIL")){
				detailDetailBook(req);
			}else if(cmd.equals(Constants.EDIT)){
				editDetailBook(req);
			}else if(cmd.equals(Constants.UPDATE)){
				updateDetailBook(req, res);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals(Constants.DELETE)){
				deleteDetailBook(req);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals(Constants.LOCK)){
				updateActiveDetailBook(req);
				sendRedirect(req, res, redirect);
			}
		}
	}

	public void addDetailBook(ActionRequest req) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		String code = ParamUtil.getString(req, "detailBookCode");
		String name = ParamUtil.getString(req, "detailBookName");
		String description = ParamUtil.getString(req, "detailBookDescription");
		String zip = ParamUtil.getString(req, "detailBookZip");
		String internal = ParamUtil.getString(req, "detailBookInternal");
		String home = ParamUtil.getString(req, "detailBookHome");
		String mobile = ParamUtil.getString(req, "detailBookMobile");
		String email = ParamUtil.getString(req, "detailBookEmail");
		boolean active = ParamUtil.getBoolean(req, "detailBookActive");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				long detailBookId = CounterLocalServiceUtil.increment();
				DetailBook detailBook = DetailBookLocalServiceUtil.createDetailBook(detailBookId);
				detailBook.setContactBookId(contactBookId);
				detailBook.setDetailBookCode(code);
				detailBook.setDetailBookName(name);
				detailBook.setDetailDescription(description);
				detailBook.setZip(zip);
				detailBook.setInternal(internal);
				detailBook.setHome(home);
				detailBook.setMobile(mobile);
				detailBook.setEmail(email);
				detailBook.setUserid(userId);
				detailBook.setCompanyid(companyId);
				if(active){
					detailBook.setDetailActive(true);
				}else{
					detailBook.setDetailActive(false);
				}
				DetailBookLocalServiceUtil.addDetailBook(companyId, detailBook);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addDetailBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}
	
	public void detailDetailBook(ActionRequest req) {
		long detailBookId = ParamUtil.getLong(req, "detailBookId");
		DetailBook detailBook = null;
		try {
			detailBook = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
			req.setAttribute("detailBook", detailBook);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD detailDetailBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}
	
	public void editDetailBook(ActionRequest req) {
		long detailBookId = ParamUtil.getLong(req, "detailBookId");
		DetailBook detailBook = null;
		try {
			detailBook = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
			req.setAttribute("detailBook", detailBook);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editDetailBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}
	

	public void updateDetailBook(ActionRequest req, ActionResponse res) {
		long detailBookId = ParamUtil.getLong(req, "detailBookId");
		String code = ParamUtil.getString(req, "detailBookCode");
		String name = ParamUtil.getString(req, "detailBookName");
		String description = ParamUtil.getString(req, "detailBookDescription");
		String zip = ParamUtil.getString(req, "detailBookZip");
		String internal = ParamUtil.getString(req, "detailBookInternal");
		String home = ParamUtil.getString(req, "detailBookHome");
		String mobile = ParamUtil.getString(req, "detailBookMobile");
		String email = ParamUtil.getString(req, "detailBookEmail");
		boolean active = ParamUtil.getBoolean(req, "detailBookActive");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		DetailBook detailBook = null;
		try {
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				detailBook = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
				detailBook.setDetailBookCode(code);
				detailBook.setDetailBookName(name);
				detailBook.setDetailDescription(description);
				detailBook.setZip(zip);
				detailBook.setInternal(internal);
				detailBook.setHome(home);
				detailBook.setMobile(mobile);
				detailBook.setEmail(email);
				
				if(active){
					detailBook.setDetailActive(true);
				}else{
					detailBook.setDetailActive(false);
				}
				DetailBookLocalServiceUtil.updateDetailBook(companyId, detailBook);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateDetailBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}

	public void deleteDetailBook(ActionRequest req) {
		long detailBookId = ParamUtil.getLong(req, "detailBookId");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		try {
			if(userId != 0){
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				DetailBookLocalServiceUtil.deleteDetailBook(companyId, detailBookId);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteContactBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}
	

	public void updateActiveDetailBook(ActionRequest req) {
		long detailBookId = ParamUtil.getLong(req, "detailBookId");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		DetailBook detailBook = null;
		try {
			if(userId != 0){
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				detailBook = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
				if(detailBook.getDetailActive() == true){
					detailBook.setDetailActive(false);
					DetailBookLocalServiceUtil.updateDetailBook(companyId, detailBook);
				}else if(detailBook.getDetailActive() == false){
					detailBook.setDetailActive(true);
					DetailBookLocalServiceUtil.updateDetailBook(companyId, detailBook);
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateActiveDetailBook OF " + ViewDetailAction.class + " " + e.getMessage());
		}
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		} else {
			return mapping.findForward("portlet.nss.phone_book_index.view_detail");
		}
	}
}
