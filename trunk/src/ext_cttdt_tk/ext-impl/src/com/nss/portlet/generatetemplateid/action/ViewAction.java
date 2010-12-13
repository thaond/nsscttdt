package com.nss.portlet.generatetemplateid.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (!Validator.isNull(cmd)) {
			if ( (cmd.equals(Constants.UPDATE)) ||(cmd.equals(Constants.ADD)) ) {
				updateIdTemplate(req, res);
			} else if (cmd.equals(Constants.DELETE)) {
				deleteIdTemplate(req, res);
			} 
		}
		
	}

	/**
	 * This method to delete a selected template
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	private void deleteIdTemplate(ActionRequest req, ActionResponse res) throws Exception {
		long templateId = ParamUtil.getLong(req, "templateId");
		
		IdGenerated idGenerated = null;
		try {
			idGenerated = IdGeneratedLocalServiceUtil.getIdGenerated(templateId);
		} catch (Exception e) {
			
		}
		
		if (idGenerated != null) {
			req.setAttribute("delete", false);
		}
		
		else {
			IdTemplateLocalServiceUtil.deleteIdTemplate(templateId);
			req.setAttribute("delete", true);
		}
		
	}

	/**
	 * To update a selected id template if exist or add a new id template
	 * @param req
	 * @param res
	 * @throws Exception 
	 */
	private void updateIdTemplate(ActionRequest req, ActionResponse res) throws Exception {
		long templateId = ParamUtil.getLong(req, "templateId", 0);
		String format = ParamUtil.getString(req, "format");
		String startNumber = ParamUtil.getString(req, "startNumber");
		String description = ParamUtil.getString(req, "description");
		IdTemplate idTemplate = null;
		if (templateId == 0) {
			templateId = CounterLocalServiceUtil.increment();
			idTemplate = IdTemplateLocalServiceUtil.createIdTemplate(templateId);
			
		}
		else {
			idTemplate = IdTemplateLocalServiceUtil.getIdTemplate(templateId);
		}
		idTemplate.setFormat(format);
		idTemplate.setStartNumber(startNumber);
		idTemplate.setDescription(description);
		IdTemplateLocalServiceUtil.updateIdTemplate(idTemplate);
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.generatetemplateid.view");
			}
	}

}
