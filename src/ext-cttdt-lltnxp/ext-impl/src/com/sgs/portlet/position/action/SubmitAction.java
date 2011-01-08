
package com.sgs.portlet.position.action;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SubmitAction extends Action {

	public ActionForward execute(
		ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) {

		ActionForward forward = mapping.findForward("submitForm");

		if (isTokenValid(request)) {

			System.out.println("1--------------)");
			resetToken(request);
		}
		else {
			System.out.println("2------------");
			System.out.println("Duplicate Submission of the form");

		}
		return forward;
	}
}
