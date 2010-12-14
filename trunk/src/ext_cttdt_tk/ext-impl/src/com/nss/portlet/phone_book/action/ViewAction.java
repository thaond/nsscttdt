package com.nss.portlet.phone_book.action;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, "cmd");
		if(cmd.equals("add")){
			String code = ParamUtil.getString(req, "contactBookCode");
			String name = ParamUtil.getString(req, "contactBookName");
			String description = ParamUtil.getString(req, "contactBookDescription");
			String active = ParamUtil.getString(req, "contactBookActive");
			System.out.println("active " + active);

			long userId = 0;
			long companyId = 0;

			try {
				userId = PortalUtil.getUserId(req);
				if (userId != 0) {
					User user = UserLocalServiceUtil.getUser(userId);
					companyId = user.getCompanyId();
				}

				long contactBookId = CounterLocalServiceUtil.increment();
				ContactBook contactBook = ContactBookLocalServiceUtil
						.createContactBook(contactBookId);
				contactBook.setContactBookCode(code);
				contactBook.setContactBookName(name);
				contactBook.setContactDescription(description);
				contactBook.setUserid(userId);
				contactBook.setCompanyid(companyId);
				ContactBookLocalServiceUtil.addContactBook(contactBook);
			} catch (Exception e) {
				_log.error("ERROR ADD IN METHOD PROCESSACTION OF "
						+ ViewAction.class + " " + e.getMessage());
			}
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
