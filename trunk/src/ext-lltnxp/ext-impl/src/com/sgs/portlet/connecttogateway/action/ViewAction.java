
package com.sgs.portlet.connecttogateway.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway;

public class ViewAction extends PortletAction {

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	@Override
	protected boolean isCheckMethodOnProcessAction() {

		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	@Override
	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		// get param tu file config
		PortletPreferences prefs = req.getPreferences();
		String portletResource = ParamUtil.getString(req, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			prefs =
				PortletPreferencesFactoryUtil.getPortletSetup(
					req, portletResource);
		}

		// save variable into configuration

		boolean flagRunThread =
			ParamUtil.getBoolean(req, "flagRunThread", true);
		boolean flagStopThread =
			ParamUtil.getBoolean(req, "flagStopThread", false);
		boolean flagRunTimer = ParamUtil.getBoolean(req, "flagRunTimer", true);
		boolean flagStopTimer =
			ParamUtil.getBoolean(req, "flagStopTimer", false);

		boolean flagRunThreadEOrg =
			ParamUtil.getBoolean(req, "flagRunThreadEOrg", true);
		boolean flagStopThreadEOrg =
			ParamUtil.getBoolean(req, "flagStopThreadEOrg", false);
		boolean flagRunTimerEOrg =
			ParamUtil.getBoolean(req, "flagRunTimerEOrg", true);
		boolean flagStopTimerEOrg =
			ParamUtil.getBoolean(req, "flagStopTimerEOrg", false);

		prefs.setValue("flagRunThread", String.valueOf(flagRunThread));
		prefs.setValue("flagStopThread", String.valueOf(flagStopThread));
		prefs.setValue("flagRunTimer", String.valueOf(flagRunTimer));
		prefs.setValue("flagStopTimer", String.valueOf(flagStopTimer));
		prefs.setValue("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
		prefs.setValue("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
		prefs.setValue("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
		prefs.setValue("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
		prefs.store();

		String edmsGatewayUrl =
			GetterUtil.getString(prefs.getValue("edmsGatewayUrl", ""));
		String edmsGatewayUserName =
			GetterUtil.getString(prefs.getValue("edmsGatewayUserName", ""));
		String edmsGatewayPassword =
			GetterUtil.getString(prefs.getValue("edmsGatewayPassword", ""));
		long timerDelay =
			GetterUtil.getLong(prefs.getValue("timerDelay", "30000"));
		long timerDelayOrg =
			GetterUtil.getLong(prefs.getValue("timerDelayOrg", "30000"));
		String edmsGatewayStatusNew =
			GetterUtil.getString(prefs.getValue("edmsGatewayStatusNew", "NEW"));
		String edmsGatewayStatusRecieve =
			GetterUtil.getString(prefs.getValue("edmsGatewayStatusRecieve", ""));
		String edmsGatewayFromDate =
			GetterUtil.getString(prefs.getValue("edmsGatewayFromDate", ""));
		String edmsGatewayToDate =
			GetterUtil.getString(prefs.getValue("edmsGatewayToDate", ""));
		String edmsGatewaySubCompany =
			GetterUtil.getString(prefs.getValue("edmsGatewaySubCompany", ""));

		// set value for connecttion object
		DocumentEdmsGateway.DEG.setEdmsGatewayUrl(edmsGatewayUrl);
		DocumentEdmsGateway.DEG.setEdmsGatewayUserName(edmsGatewayUserName);
		DocumentEdmsGateway.DEG.setEdmsGatewayPassword(edmsGatewayPassword);
		DocumentEdmsGateway.DEG.setTimerDelay(timerDelay);
		DocumentEdmsGateway.DEG.setTimerDelayOrg(timerDelayOrg);
		DocumentEdmsGateway.DEG.setEdmsGatewayStatusNew(edmsGatewayStatusNew);
		DocumentEdmsGateway.DEG.setEdmsGatewayStatusRecive(edmsGatewayStatusRecieve);
		DocumentEdmsGateway.DEG.setEdmsGatewayFromDate(edmsGatewayFromDate);
		DocumentEdmsGateway.DEG.setEdmsGatewayToDate(edmsGatewayToDate);
		DocumentEdmsGateway.DEG.setEdmsGatewaySubCompany(edmsGatewaySubCompany);
		DocumentEdmsGateway.DEG.setParamForConnectionDocument(DocumentEdmsGateway.DEG);

		String action = ParamUtil.getString(req, "action", "");

		String pathFileServer =
			getServlet().getServletContext().getRealPath("/") + "upload";
		if (action.equals(ConnectionToGatewayContant.CREATETHREADDOC)) {
			DocumentEdmsGateway.DEG.downloadDocumentReceiptsFromGateWayThread(
				DocumentEdmsGateway.DEG, pathFileServer);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTHREADDOC)) {
			DocumentEdmsGateway.DEG.closeDownloadDocumentReceiptsFromGateWayThread(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.CREATETIMERDOC)) {
			DocumentEdmsGateway.DEG.downloadDocumentReceiptsFromGateWayTimer(
				DocumentEdmsGateway.DEG, pathFileServer);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTIMERDOC)) {
			DocumentEdmsGateway.DEG.closeDownloadDocumentReceiptsFromGateWayTimer();

		}
		else if (action.equals(ConnectionToGatewayContant.CREATETHREADEORG)) {
			DocumentEdmsGateway.DEG.downloadExternalOrganizationFromGateWayThread(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTHREADEORG)) {
			DocumentEdmsGateway.DEG.closeDownloadExternalOrganizationFromGateWayThread(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.CREATETIMEREORG)) {
			DocumentEdmsGateway.DEG.downloadExternalOrganizationFromGateWayTimer(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTIMEREORG)) {
			DocumentEdmsGateway.DEG.closeDownloadExternalOrganizationFromGateWayTimer();

		}
		else if (action.equals(ConnectionToGatewayContant.CREATETHREADSENDMAIL)) {
			DocumentEdmsGateway.DEG.createThreadSendMail(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTHREADSENDMAIL)) {
			DocumentEdmsGateway.DEG.closeTheardSendMail(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.CREATETIMERSENDMAIL)) {
			DocumentEdmsGateway.DEG.createTimerSendMail(DocumentEdmsGateway.DEG);
		}
		else if (action.equals(ConnectionToGatewayContant.STOPTIMERSENDMAIL)) {
			DocumentEdmsGateway.DEG.closeTimerSendMail();
		}

	}

	@Override
	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			return mapping.findForward("portlet.sgs.connecttogateway.view");
		}
	}

}
