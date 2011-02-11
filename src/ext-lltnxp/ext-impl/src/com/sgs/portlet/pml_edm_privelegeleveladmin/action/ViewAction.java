/**
 * @author triltm
 * @since 10/4/2009
 * @version 1.0
 * This class for admin to do some action with privilege level
 */

package com.sgs.portlet.pml_edm_privelegeleveladmin.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;
import com.sgs.portlet.document.receipt.PmlEdmPrivilegeLevelCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.pml_edm_privelegeleveladmin.search.PmlEDMPrivelegelevelAdminSearchTerms;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, Constants.ACTION, "");
		// yenlt update 23082020
//		String redirect = ParamUtil.getString(req, "redirect",
//				"/sgs/pml_edm_privelegeleveladmin/view");
		try {
			if (Constants.ADD.equals(action)) {
				addPrivilegeLevel(req);
			} else if (Constants.UPDATE.equals(action)) {
				updatePrivilegeLevel(req);
			}
			
			else if (Constants.DELETE.equals(action)) {
				//boolean delete = deletePrivilegeLevel(req);
				//redirect += "&delete=".concat(String.valueOf(delete));
				deletePrivilegeLevel(req);
			}
			if (Validator.isNotNull(action)) {
				String levelAdmin = ParamUtil.getString(
						req, "levelAdmin");
				sendRedirect(req, res, levelAdmin);
			}
			
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmPrivilegeLevelException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.pml_edm_privelegeleveladmin.error");
			}
			else if (e instanceof PmlEdmPrivilegeLevelCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
//		sendRedirect(req, res, redirect);
		// end yenlt update 23082020
	}

	// minh update
	/**
	 * xoa do khan
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	/* yenlt close 23082010
	private boolean deletePrivilegeLevel(ActionRequest req) {

		String id = ParamUtil.getString(req, "privilegeLevelId", "");
		List<PmlEdmDocumentReceipt> pmlDocumentReceiptList = null;

		try {
			pmlDocumentReceiptList = PmlEdmDocumentReceiptUtil
					.findByPrivilegeLevelId(id);
		} catch (Exception e) {
		}

		if (pmlDocumentReceiptList != null && !pmlDocumentReceiptList.isEmpty()) {
			return false;
		}

		else {
			try {
				PmlEdmPrivilegeLevelLocalServiceUtil
						.deletePmlEdmPrivilegeLevel(id);
				return true;
			} catch (Exception e) {
				_log.error("NO DELETE PmlEdmPrivilegeLevel");
				_log.error(e);
				return false;
			}
		}

	}
	*/
	public void deletePrivilegeLevel(ActionRequest req) throws Exception {
		String privilegeLevelId = ParamUtil.getString(req, "privilegeLevelId", "");
		PmlEdmPrivilegeLevelLocalServiceUtil.removePmlEdmPrivilegeLevel(privilegeLevelId);
		
	}

	private void updatePrivilegeLevel(ActionRequest req)  {
		String id = ParamUtil.getString(req, "privilegeLevelId", "");
		String name = ParamUtil.getString(req, "privilegeLevelName_" + id, "");
		try {
			PmlEdmPrivilegeLevel privilegeLevel = PmlEdmPrivilegeLevelLocalServiceUtil
					.getPmlEdmPrivilegeLevel(id);
			privilegeLevel.setPrivilegeLevelName(StringUtil.encodeHtml(name));
			PmlEdmPrivilegeLevelLocalServiceUtil
					.updatePmlEdmPrivilegeLevel(privilegeLevel);
		} catch (Exception e) {
			_log.error("NO UPDATE PmlEdmPrivilegeLevel");
			_log.error(e);
		}

	}

	private void addPrivilegeLevel(ActionRequest req) {
		
		try {
			String id = IdTemplateServiceUtil
					.generatedStringId(PmlEdmPrivilegeLevel.class.getName());
			String name = ParamUtil.getString(req,
					PmlEDMPrivelegelevelAdminSearchTerms.PRIVILEGELEVEL_NAME, "");
			PmlEdmPrivilegeLevel pri = new PmlEdmPrivilegeLevelImpl();
			pri.setPrivilegeLevelId(id);
			pri.setPrivilegeLevelName(StringUtil.encodeHtml(name));
	
			PmlEdmPrivilegeLevelLocalServiceUtil.addPmlEdmPrivilegeLevel(pri);
		} catch (Exception e) {
			_log.error("NO ADD PmlEdmPrivilegeLevel");
			_log.error(e);
		}

	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

//		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelUtil
//				.findAll();
//		req.setAttribute("privilegeLevels", privilegeLevels);
		return mapping.findForward("portlet.sgs.pml_edm_privelegeleveladmin.view");
	}

}
