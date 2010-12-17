package com.nss.portlet.phone_book.action;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/phone_book/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if(cmd.equals(Constants.ADD)){
				addContactBook(req);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals("DETAIL")){
				detailContactBook(req,res);
			}else if(cmd.equals(Constants.EDIT)){
				editContactBook(req);
			}else if(cmd.equals(Constants.UPDATE)){
				updateContactBook(req, res);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals(Constants.DELETE)){
				deleteContactBook(req, res, redirect);
			}else if(cmd.equals(Constants.LOCK)){
				updateActiveContactBook(req,res);
				sendRedirect(req, res, redirect);
			}
		}
	}

	public void addContactBook(ActionRequest req) {
		String code = ParamUtil.getString(req, "contactBookCode");
		String name = ParamUtil.getString(req, "contactBookName");
		String description = ParamUtil.getString(req, "contactBookDescription");
		boolean active = ParamUtil.getBoolean(req, "contactBookActive");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				long contactBookId = CounterLocalServiceUtil.increment();
				ContactBook contactBook = ContactBookLocalServiceUtil
						.createContactBook(contactBookId);
				contactBook.setContactBookCode(code);
				contactBook.setContactBookName(name);
				contactBook.setContactDescription(description);
				contactBook.setUserid(userId);
				contactBook.setCompanyid(companyId);
				if(active){
					contactBook.setContactActive(true);
				}else{
					contactBook.setContactActive(false);
				}
				ContactBookLocalServiceUtil.addContactBook(companyId, contactBook);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void detailContactBook(ActionRequest req,ActionResponse res) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		ContactBook contactBook = null;
		try {
			contactBook = ContactBookLocalServiceUtil.getContactBook(contactBookId);
			req.setAttribute("contactBook", contactBook);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD detailContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void editContactBook(ActionRequest req) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		ContactBook contactBook = null;
		try {
			contactBook = ContactBookLocalServiceUtil.getContactBook(contactBookId);
			req.setAttribute("contactBook", contactBook);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}
	

	public void updateContactBook(ActionRequest req, ActionResponse res) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		String code = ParamUtil.getString(req, "contactBookCode");
		String name = ParamUtil.getString(req, "contactBookName");
		String description = ParamUtil.getString(req, "contactBookDescription");
		boolean active = ParamUtil.getBoolean(req, "contactBookActive");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		ContactBook contactBook = null;
		try {
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				contactBook = ContactBookLocalServiceUtil.getContactBook(contactBookId);
				contactBook.setContactBookCode(code);
				contactBook.setContactBookName(name);
				contactBook.setContactDescription(description);
				if(active){
					contactBook.setContactActive(true);
				}else{
					contactBook.setContactActive(false);
				}
				ContactBookLocalServiceUtil.updateContactBook(companyId, contactBook);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}

	public void deleteContactBook(ActionRequest req, ActionResponse res, String redirect) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		try {
			if(userId != 0){
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				List<DetailBook> detailBooks = ContactBookLocalServiceUtil.getDetailBooks(contactBookId);
				if(detailBooks.size() == 0){
					ContactBookLocalServiceUtil.deleteContactBook(companyId, contactBookId);
					sendRedirect(req, res, redirect);
				}else{
					req.setAttribute("NotDeleteContact", "NotDeleteContact");
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}
	

	public void updateActiveContactBook(ActionRequest req,ActionResponse res) {
		long contactBookId = ParamUtil.getLong(req, "contactBookId");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		ContactBook contactBook = null;
		try {
			if(userId != 0){
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				contactBook = ContactBookLocalServiceUtil.getContactBook(contactBookId);
				if(contactBook.getContactActive() == true){
					contactBook.setContactActive(false);
					ContactBookLocalServiceUtil.updateContactBook(companyId, contactBook);
				}else if(contactBook.getContactActive() == false){
					contactBook.setContactActive(true);
					ContactBookLocalServiceUtil.updateContactBook(companyId, contactBook);
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateActiveContactBook OF "
					+ ViewAction.class + " " + e.getMessage());
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
			return mapping.findForward("portlet.nss.phone_book.view");
		}
	}

}
