package com.nss.portlet.position.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.position.PositionCanNotDeleteException;
import com.nss.portlet.position.PositionCodeSameCodeException;
import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.service.PositionLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if(Constants.ADD.equals(cmd)) {
				createPosition(req, res);
			}
			else if (Constants.DELETE.equals(cmd)) {
				deletePosition(req, res);
			}
			else if (Constants.UPDATE.equals(cmd)) {
				updatePosition(req, res);
			}
			else if (Constants.LOCK.equals(cmd)) {
				updateActivePosition(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(req, "redirect");
				sendRedirect(req, res, redirect);
			}
		} catch (Exception e) {
			if (e instanceof PositionCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof PositionCodeSameCodeException) {
				req.setAttribute("positionFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.nss.position.add");
			}
			else {
				throw e;
			}
		}		
	}

	private Position createPosition(ActionRequest req, ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
	
		String positionCode = ParamUtil.getString(uploadRequest, "positionCode");
		String positionName = ParamUtil.getString(uploadRequest, "positionName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		Position position = null;
		
		if (active) {
			position = PositionLocalServiceUtil.addPosition(positionCode, positionName, description, "1");
		}
		else {
			position = PositionLocalServiceUtil.addPosition(positionCode, positionName, description, "0");
		}
	
		return position;
	}
	
	private void deletePosition(ActionRequest req, ActionResponse res) throws Exception {
			
		String positionId = ParamUtil.getString(req, "positionId");
		PositionLocalServiceUtil.removePosition(positionId);
	}
	
	private Position updatePosition(ActionRequest req, ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String positionId = ParamUtil.getString(uploadRequest, "positionId");
		String positionCode = ParamUtil.getString(uploadRequest, "positionCode");
		String positionName = ParamUtil.getString(uploadRequest, "positionName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		Position position = null;
			
		if (active) {
			position = PositionLocalServiceUtil.updatePosition(positionId, positionCode, positionName, description, "1");
		}
		else {
			position = PositionLocalServiceUtil.updatePosition(positionId, positionCode, positionName, description, "0");
		}
		return position;
	}
	
	private void updateActivePosition(ActionRequest req, ActionResponse res) {
		
		String positionId = ParamUtil.getString(req, "positionId");
		
		try {
			Position position = PositionLocalServiceUtil.getPosition(positionId);
			
			if ("1".equals(position.getActive())) {
				position.setActive("0");
			}
			else {
				position.setActive("1");
			}
			
			position = PositionLocalServiceUtil.updatePosition(position);			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
	}
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				String cmd = ParamUtil.getString(req, Constants.CMD);
				if (!Validator.isNull(cmd)) {
					if (cmd.equals(Constants.EDIT)) {
						editPosition(req, res);
					}
				}
				return mapping.findForward("portlet.nss.position.view");
			}
	}

	private void editPosition(RenderRequest req, RenderResponse res) {
		String positionId = ParamUtil.getString(req, "positionId");
		_log.info("edit positionId: " + positionId);
		req.setAttribute("positionId", positionId);
		
	}
}
