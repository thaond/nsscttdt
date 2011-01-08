package com.sgs.portlet.issuingplace.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;
import com.sgs.portlet.pmlissuingplace.PmlEdmIssuingPlaceCanNotDeleteException;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;

public class ViewAction extends PortletAction {

	// Yenlt update 06/02/2010
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, Constants.CMD, "");
		try {
			if (Constants.ADD.equals(action)) {
				addIssuingPlace(req);
			} else if (Constants.UPDATE.equals(action)) {
				updateIssuingPlace(req);
			} else if (Constants.DELETE.equals(action)) {
				deleteIssuingPlace(req);
			}
			if (Validator.isNotNull(action)) {
				String pmlIssuingPlaceURL = ParamUtil.getString(
						req, "pmlIssuingPlaceURL");
				sendRedirect(req, res, pmlIssuingPlaceURL);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmIssuingPlaceException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.issuingplace.error");
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
		String redirect = ParamUtil.getString(req, "redirect");

		req.setAttribute("redirect", redirect);

		return mapping.findForward("portlet.sgs.issuingplace.view");
	}

	private void updateIssuingPlace(ActionRequest req) {
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId", "");
		String issuingPlaceName = ParamUtil.getString(req, "issuingName_"
				+ issuingPlaceId);
		String issuingPlaceNote = ParamUtil.getString(req, "issuingNote_"
				+ issuingPlaceId);

		try {
			PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil
					.getPmlEdmIssuingPlace(issuingPlaceId);

			issuingPlace.setIssuingPlaceName(issuingPlaceName);
			issuingPlace.setNote(issuingPlaceNote);

			PmlEdmIssuingPlaceLocalServiceUtil
					.updatePmlEdmIssuingPlace(issuingPlace);
		} catch (Exception e) {
			_log.error("NO UPDATE PMLEDMISSUINGPLACE");
			_log.error(e);
		}
	}
	protected void deleteIssuingPlace(ActionRequest req) throws Exception {
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
		
		PmlEdmIssuingPlaceLocalServiceUtil.removePmlEdmIssuingPlace(issuingPlaceId);
	}

	private void addIssuingPlace(PortletRequest req) {
		String issuingPlaceName = ParamUtil.getString(req, "issuingName");
		String issuingPlaceNote = ParamUtil.getString(req, "issuingNote");
		try {
			String issuingPlaceId = IdTemplateServiceUtil.generatedId(PmlEdmIssuingPlace.class);
			PmlEdmIssuingPlace edmIssuingPlace = new PmlEdmIssuingPlaceImpl();
			edmIssuingPlace.setIssuingPlaceId(issuingPlaceId);
			edmIssuingPlace.setIssuingPlaceCode(issuingPlaceId);
			edmIssuingPlace.setIssuingPlaceName(issuingPlaceName);
			edmIssuingPlace.setNote(issuingPlaceNote);
			PmlEdmIssuingPlaceLocalServiceUtil.addPmlEdmIssuingPlace(edmIssuingPlace);
		} catch (Exception e) {
			_log.error("NO ADD PMLEDMISSUINGPLACE");
			_log.error(e);
		}
	}
}
