/**
 * @author triltm
 * @since 14/04/2009
 */

package com.sgs.portlet.pml_edm_confidentiallevel.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.ConfidentialLevelNameNotSameException;
import com.sgs.portlet.document.receipt.ConfidentialLevelReferenceException;
import com.sgs.portlet.document.receipt.ConfidentialLevelSymbolNotSameException;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;

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
		try {
			String action = ParamUtil.getString(req, Constants.ACTION, "");
			String redirect = ParamUtil.getString(req, "redirect", "/sgs/pml_edm_confidentiallevel/view");
			/*
			if (Constants.ADD.equals(action)) {
				addConfidentialLevel(req);
			}
			else if (Constants.UPDATE.equals(action)) {
				updateConfidentialLevel(req);
			}
			*/
			if (Constants.ADD.equals(action) || Constants.UPDATE.equals(action)) {
				updateConfidentialLevel(req);
			}
			else if (Constants.DELETE.equals(action)) {
				boolean delete = deleteConfidentialLevel(req);
					//xuancong close redirect += "&delete=".concat(String.valueOf(delete));
					if (delete == false) { // Khong xoa duoc vi tham chieu
						throw new ConfidentialLevelReferenceException();
					}
			}
			sendRedirect(req, res, redirect);
		}
		catch (Exception ex) {
			if (ex instanceof ConfidentialLevelReferenceException) { // Khong xoa duoc vi con tham chieu
				SessionErrors.add(req, ex.getClass().getName());
			}
			else if (ex instanceof ConfidentialLevelSymbolNotSameException || ex instanceof ConfidentialLevelNameNotSameException) {
				req.setAttribute("flag", "fail");
				SessionErrors.add(req, ex.getClass().getName());
				setForward(req, "portlet.sgs.pml_edm_confidentiallevel.view");
			}
			else {
				throw ex;
			}
		}
	}

	//minh update
	/*
	 * xoa do mat
	 */
	private boolean deleteConfidentialLevel(ActionRequest req) {
		String id = ParamUtil.getString(req, "confidentialLevelId", "");
		List<PmlEdmDocumentReceipt> pmlDocumentReceiptList = null;
		
			try {
				pmlDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByConfidentialLevelId(id);
		} 
		catch (Exception e) {
			}
			
			if (pmlDocumentReceiptList != null && !pmlDocumentReceiptList.isEmpty()) {
				return false;
			}	
		else {
				try {
					PmlEdmConfidentialLevelLocalServiceUtil.deletePmlEdmConfidentialLevel(id);
					return true;
				} catch (Exception e) {
					_log.error("NO DELETE PmlEdmConfidentialLevel");
					_log.error(e);
					return false;
				}
			}
	}

	/*
	private void addConfidentialLevel(ActionRequest req) {
		try {
			String id = IdTemplateServiceUtil.generatedStringId(PmlEdmConfidentialLevel.class.getName());
			
			//String name = ParamUtil.getString(req, PmlEDMConfidentialLevelSearchTerms.PMLEDMCONFIDENTIALLEVEL_NAME, "");
			// Lay gia tri nhap vao tren form
			String confidentialLevelName = ParamUtil.getString(req, "confidentialLevelName");
			int confidentialLevelSymbol = ParamUtil.getInteger(req, "confidentialLevelSymbol");
			boolean limitViewDetail = ParamUtil.getBoolean(req, "limitViewDetail");
			boolean haveProcess = ParamUtil.getBoolean(req, "haveProcess");
			
			PmlEdmConfidentialLevel confidentialLevel = new PmlEdmConfidentialLevelImpl();
			confidentialLevel.setConfidentialLevelId(id);
			//confidentialLevel.setConfidentialLevelName(StringUtil.encodeHtml(name));
			// Cap nhat thuoc tinh cho doi tuong moi
			confidentialLevel.setConfidentialLevelName(confidentialLevelName);
			confidentialLevel.setConfidentialLevelSymbol(confidentialLevelSymbol);
			confidentialLevel.setLimitViewDetail(limitViewDetail);
			confidentialLevel.setHaveProcess(haveProcess);
			
			PmlEdmConfidentialLevelLocalServiceUtil.addPmlEdmConfidentialLevel(confidentialLevel);
		} 
		catch (Exception e) {
			_log.error("NO ADD PmlEdmConfidentialLevel");
			_log.error(e);
		}
	}

	private void updateConfidentialLevel(ActionRequest req) {
		
		String id = ParamUtil.getString(req, "confidentialLevelId", "");
		//String name = ParamUtil.getString(req, "confidentialLevelName_" + id, "");
		String name = ParamUtil.getString(req, "confidentialLevelName", "");
		int symbol = ParamUtil.getInteger(req, "confidentialLevelSymbol");
		boolean limitViewDetail = ParamUtil.getBoolean(req, "limitViewDetail");
		boolean haveProcess = ParamUtil.getBoolean(req, "haveProcess"); 
		
		try {
			PmlEdmConfidentialLevel confidentialLevel = PmlEdmConfidentialLevelLocalServiceUtil.getPmlEdmConfidentialLevel(id);
			confidentialLevel.setConfidentialLevelName(name);
			confidentialLevel.setConfidentialLevelSymbol(symbol);
			confidentialLevel.setLimitViewDetail(limitViewDetail);
			confidentialLevel.setHaveProcess(haveProcess);
			
			PmlEdmConfidentialLevelLocalServiceUtil.updatePmlEdmConfidentialLevel(confidentialLevel);
		} catch (Exception e) {
			_log.error("NO UPDATE PmlEdmConfidentialLevel");
			_log.error(e);
		}
	}
	*/
	
	/* chinh code de rang buoc dieu kien them moi hoac update doi tuong da ton tai */
	private PmlEdmConfidentialLevel updateConfidentialLevel(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String action = ParamUtil.getString(req, Constants.ACTION, "");
		
		String confidentialLevelId = ParamUtil.getString(uploadRequest, "confidentialLevelId");
		String confidentialLevelName = ParamUtil.getString(uploadRequest, "confidentialLevelName");
		int confidentialLevelSymbol = ParamUtil.getInteger(uploadRequest, "confidentialLevelSymbol");
		boolean limitViewDetail = ParamUtil.getBoolean(req, "limitViewDetail");
		boolean haveProcess = ParamUtil.getBoolean(req, "haveProcess"); 
		
		PmlEdmConfidentialLevel confidentialLevel = null;
		
		if (Constants.ADD.equals(action)) {
			confidentialLevel = PmlEdmConfidentialLevelLocalServiceUtil.addPmlEdmConfidentialLevel
										(confidentialLevelName, confidentialLevelSymbol, limitViewDetail, haveProcess);
		}
		else if (Constants.UPDATE.equals(action)) {
			confidentialLevel = PmlEdmConfidentialLevelLocalServiceUtil.updatePmlEdmConfidentialLevel
										(confidentialLevelId, confidentialLevelName, confidentialLevelSymbol, limitViewDetail, haveProcess);
		}
		
		return confidentialLevel;
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
//			List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelUtil.findAll();
//		
//			req.setAttribute("confidentialLevels", confidentialLevels);
			return mapping.findForward("portlet.sgs.pml_edm_confidentiallevel.view");
	}
}
