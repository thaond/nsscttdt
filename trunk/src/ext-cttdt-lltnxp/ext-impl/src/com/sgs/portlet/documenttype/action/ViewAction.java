package com.sgs.portlet.documenttype.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;
import com.sgs.portlet.document.receipt.PmlEdmDocumentTypeCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String action = ParamUtil.getString(req, Constants.ACTION, "");
		// yenlt update 23082010
//		String redirect = ParamUtil.getString(req, "redirect", "/sgs/documenttype/view");
		try {
			if (Constants.ADD.equals(action)) {
				addDocumentType(req);	
				
			} else if (Constants.UPDATE.equals(action)) {
				updateRecord(req);
				
			} else if (Constants.DELETE.equals(action)) {
//				boolean delete = deleteRecord(req);
//				redirect +="&delete=".concat(String.valueOf(delete));
				deleteRecord(req);
			}
			if (Validator.isNotNull(action)) {
				String documentTypeURL = ParamUtil.getString(
						req, "documentTypeURL");
				sendRedirect(req, res, documentTypeURL);
			}
//			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmDocumentTypeException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.documenttype.error");
			}
			else if (e instanceof PmlEdmDocumentTypeCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		// end yenlt update 23082010
		
	}

	private void deleteRecord(ActionRequest req) throws Exception {
		long documentTypeId = ParamUtil.getLong(req, "pmlEdmDocumentTypeId") ;
		PmlEdmDocumentTypeLocalServiceUtil.removePmlEdmDocumentType(documentTypeId);
	}

	
	private void updateRecord(ActionRequest req) {
		long documentTypeId = ParamUtil.getLong(req, "pmlEdmDocumentTypeId") ;
		String documentTypeSymbol = ParamUtil.getString(req, "documentTypeSymbol_".concat(String.valueOf(documentTypeId)));
		String documentTypeName = ParamUtil.getString(req, "documentTypeCode_".concat(String.valueOf(documentTypeId)));
		int documentRecordId = ParamUtil.getInteger(req, "hiddenDocumentRecordName_".concat(String.valueOf(documentTypeId)));
		int sendReceiptDistinction = ParamUtil.getInteger(req, "hiddenSendReceiptDistinction_".concat(String.valueOf(documentTypeId)));
		boolean haveDepartExtends = ParamUtil.getBoolean(req, "hiddenHaveDepartExtends_".concat(String.valueOf(documentTypeId)));
		try {
			PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
			pmlEdmDocumentType.setDocumentTypeName(documentTypeSymbol);
			pmlEdmDocumentType.setDocumentTypeName(documentTypeName);
			pmlEdmDocumentType.setDocumentRecordTypeId(documentRecordId);
			pmlEdmDocumentType.setSendReceiptDistinction(sendReceiptDistinction);
			pmlEdmDocumentType.setHaveDepartExtends(haveDepartExtends);
			PmlEdmDocumentTypeLocalServiceUtil.updatePmlEdmDocumentType(pmlEdmDocumentType);
		} catch (Exception e) {
			_log.error("NO UPDATE PMLDOCUMENTTYPE");
			_log.error(e);
		}
		
	}

	private void addDocumentType(ActionRequest req){
		String documentTypeName = ParamUtil.getString(req, "documentTypeNameAdd");
		int documentRecordId = ParamUtil.getInteger(req, "documentRecordTypeNameAdd");
		int sendReceiptDistinction = ParamUtil.getInteger(req, "sendReceiptDistinctionAdd");
		boolean haveDepartExtends = ParamUtil.getBoolean(req, "haveDepartExtendsAdd");
		try {
			PmlEdmDocumentType type =new PmlEdmDocumentTypeImpl();
			int id = (int)CounterServiceUtil.increment();
			String documentSymbol = ParamUtil.get(req, "symbol", "");
			type.setDocumentTypeId(id);
			type.setDocumentSymbol(documentSymbol);
			type.setDocumentTypeName(documentTypeName);
			type.setDocumentRecordTypeId(documentRecordId);
			type.setSendReceiptDistinction(sendReceiptDistinction);
			type.setHaveDepartExtends(haveDepartExtends);
			PmlEdmDocumentTypeLocalServiceUtil.addPmlEdmDocumentType(type);
		} catch (Exception e) {
			_log.error("NO ADD PMLDOCUMENTTYPE");
			_log.error(e);
		}
	
	
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
//			List<PmlEdmDocumentType> listtype= PmlEdmDocumentTypeUtil.findAll();
//			req.setAttribute("listtype",listtype);
			
			List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
			req.setAttribute("pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
			
			return mapping.findForward("portlet.sgs.documenttype.view");
	}

}
