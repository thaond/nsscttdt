package com.sgs.portlet.pmlstreet.action;

import java.rmi.RemoteException;

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

import com.ext.portlet.util.StringUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.pmlstreet.NoGenerateStreetIdException;
import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.model.impl.PmlStreetImpl;
import com.sgs.portlet.pmlstreet.service.PmlStreetLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		try {
//			if (!Validator.isNull(cmd)) {
				
				if (cmd.equals(Constants.ADD)) {
					createStreet(req, res);
				}
				else if (cmd.equals(Constants.DELETE)) {
					boolean delete = deleteStreet(req);
					redirect += "&delete=".concat(String.valueOf(delete));
				}
				else if (cmd.equals(Constants.UPDATE)) {
					updateStreet(req, res);
				}
				if (Validator.isNotNull(cmd)) {
					String streetURL = ParamUtil.getString(req, "streetURL");
					sendRedirect(req, res, streetURL);
				}
//			}
			
		} catch (Exception e) {
			if (e instanceof NoGenerateStreetIdException) {
				SessionErrors.add(req,e.getClass().getName());
			} else {
				_log.error(e.getMessage());
			}
		}
	}
	
	
	public boolean deleteStreet(ActionRequest req) {
		String streetId = ParamUtil.getString(req, "streetId");
		PmlStreet street = null;
		try {
			street = PmlStreetLocalServiceUtil.getPmlStreet(streetId);
			
			PmlStreetLocalServiceUtil.deletePmlStreet(street);
			return true;
		} catch (PortalException e) {
			_log.error(e);
			return false;
		} catch (SystemException e) {
			_log.error(e);
			_log.error(" CAN NOT GET PMLSTREET");
			return false;
		}
		
	}
	
	public void updateStreet(ActionRequest req, ActionResponse res) {
		String streetId = ParamUtil.getString(req, "streetId");
		String streetName = ParamUtil.getString(req, "streetName_"+ streetId,"");
		PmlStreet street = null;
		try {
			street = PmlStreetLocalServiceUtil.getPmlStreet(streetId);
			
			street.setStreetName(StringUtil.encodeHtml(streetName));
			street = PmlStreetLocalServiceUtil.updatePmlStreet(street);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
			_log.error(" CAN NOT GET PMLSTREET");
		}
		
	}
	
	public void createStreet(ActionRequest req, ActionResponse res) throws NoSuchIdGeneratedException, NoGenerateStreetIdException, SystemException, RemoteException {
		String streetName = ParamUtil.getString(req, "ten");
		String streetCode = ParamUtil.getString(req, "streetCode", "");
		PmlStreet street = null;
		street = PmlStreetLocalServiceUtil.addStreet(streetCode, streetName);
//		String streetId = "";
//		try {
//			streetId = IdTemplateServiceUtil.generatedId(PmlStreet.class);
//		} catch (NoSuchIdGeneratedException e) {
//			_log.error(e);
//		} catch (SystemException e) {
//			_log.error(e);
//		} catch (RemoteException e) {
//			_log.error(e);
//		}
//		
//		
//		PmlStreet street = new PmlStreetImpl();
//		if (!"".equals(streetCode)) {
//			street.setStreetId(streetCode);
//		} else {
//			street.setStreetId(streetId);
//		}
//		street.setStreetName(streetName);
//		try {
//			PmlStreetLocalServiceUtil.addPmlStreet(street);
//		} catch (SystemException e) {
//			_log.error(e);
//		}
		
	}
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pmlstreet.view");
			}
	}

}
