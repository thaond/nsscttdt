package com.sgs.portlet.documentlevelsend.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;
import com.sgs.portlet.pmllevelsend.PmlEdmLevelSendCanNotDeleteException;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailUtil;
import com.sgs.portlet.documentlevelsend.search.PmlEdmLevelSendSearchTerms;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.ACTION);
		// yenlt updater 23082010
//		String redirect = ParamUtil.getString(req, "redirect", "/sgs/documentlevelsend/view");
		try {
			if (cmd.equals(Constants.ADD)) {
				addLevelSend(req,res);
				
			} else if (cmd.equals(Constants.UPDATE)) {
				updateLevelSend(req);
				
			} else if (cmd.equals(Constants.DELETE)) {
				deleteLevelSend(req); 
			}
			if (Validator.isNotNull(cmd)) {
				String pmlLevelSendURL = ParamUtil.getString(
						req, "pmlLevelSendURL");
				sendRedirect(req, res, pmlLevelSendURL);
			}
//			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmLevelSendException ||
					e instanceof PrincipalException) {
					SessionErrors.add(req, e.getClass().getName());
					setForward(req, "portlet.sgs.documentlevelsend.error");
				}
				else if (e instanceof PmlEdmLevelSendCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
				}
				else {
					throw e;
				}
		}
	}

	
	protected void updateLevelSend(ActionRequest req) {
		int levelsendId = ParamUtil.getInteger(req, "documentLevelSendId");
		String levelSendName = ParamUtil.getString(req, "levelSendName_" + levelsendId, "");
		try {
			PmlEdmLevelSend pmlEdmLevelSend = PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSend(levelsendId);
			pmlEdmLevelSend.setLevelSendName(levelSendName);
			PmlEdmLevelSendLocalServiceUtil.updatePmlEdmLevelSend(pmlEdmLevelSend);
		} catch (Exception e) {
			_log.error("NO UPDATE PmlEdmLevelSend");
			_log.error(e);
		}
	}


	protected void addLevelSend(ActionRequest req, ActionResponse res){
		try {
			PmlEdmLevelSend levelsend=new PmlEdmLevelSendImpl();
			int id = (int)CounterServiceUtil.increment();
			String levelSendCode = IdTemplateServiceUtil.generatedStringId(PmlEdmLevelSend.class.getName());
			levelsend.setLevelSendId(id);
			levelsend.setLevelSendCode(levelSendCode);
			String levelsendname = ParamUtil.getString(req, PmlEdmLevelSendSearchTerms.PMLEDMLEVELSEND_NAME);
			levelsendname = StringUtil.encodeHtml(levelsendname);
			levelsend.setLevelSendName(levelsendname);
			PmlEdmLevelSendLocalServiceUtil.addPmlEdmLevelSend(levelsend);
		} catch (Exception e) {
			_log.error("NO ADD PmlEdmLevelSend");
			_log.error(e);
		}
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		}
		else {
			return mapping.findForward("portlet.sgs.documentlevelsend.view");
		}
	}
	// yenlt update 23082010
	protected void deleteLevelSend(ActionRequest req) throws Exception {
		int levelSendId = ParamUtil.getInteger(req, "documentLevelSendId");
		PmlEdmLevelSendLocalServiceUtil.removePmlEdmLevelSend(levelSendId);
	}
	// end yenlt update 23082010
}
