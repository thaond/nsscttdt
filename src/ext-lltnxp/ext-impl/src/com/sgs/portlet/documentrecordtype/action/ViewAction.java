package com.sgs.portlet.documentrecordtype.action;

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
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;
import com.sgs.portlet.document.receipt.PmlEdmDocumentRecordTypeCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String action = ParamUtil.getString(req, Constants.ACTION, "");
		// yenlt update 23082010
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/documentrecordtype/view");
		try {
			if (Constants.ADD.equals(action)) {
				addRecord(req,res);
				
			} else if (Constants.UPDATE.equals(action)) {
				updateRecord(req);
				
			} else if (Constants.DELETE.equals(action)) {
//				boolean delete = deleteRecord(req);
//				redirect +="&delete=".concat(String.valueOf(delete));
				deleteRecord(req);
			}
			if (Validator.isNotNull(action)) {
				String documentRecordTypeURL = ParamUtil.getString(
						req, "documentRecordTypeURL");
				sendRedirect(req, res, documentRecordTypeURL);
			}
//			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			if (e instanceof NoSuchPmlEdmDocumentRecordTypeException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.documentrecordtype.error");
			}
			else if (e instanceof PmlEdmDocumentRecordTypeCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		// end yenlt
		
	}

	private void updateRecord(ActionRequest req) {
		int documentRecordTypeId = ParamUtil.getInteger(req, "pmlEdmDocumentRecordTypeId");
		String code = ParamUtil.getString(req, "documentRecordTypeCode_" + documentRecordTypeId);
		String name = ParamUtil.getString(req, "documentRecordTypeName_" + documentRecordTypeId);

		try {
			PmlEdmDocumentRecordType documentRecordType = PmlEdmDocumentRecordTypeLocalServiceUtil.
				getPmlEdmDocumentRecordType(documentRecordTypeId);
			documentRecordType.setDocumentRecordTypeCode(code);
			documentRecordType.setDocumentRecordTypeName(name);
			PmlEdmDocumentRecordTypeLocalServiceUtil.updatePmlEdmDocumentRecordType(documentRecordType);
		} catch (Exception e) {
			_log.error("NO UPDATE PMLEDMDOCUMENTRECORDTYPE");
			_log.error(e);
		}
	}

	private void addRecord(ActionRequest req, ActionResponse res) {
			
		try {
			PmlEdmDocumentRecordType recordType=new PmlEdmDocumentRecordTypeImpl();
			int id = (int)CounterServiceUtil.increment();
			//ma phai tu nhap, khong phat sinh tu dong
			//String code=IdTemplateServiceUtil.generatedStringId("DocumentRecordType");
			recordType.setDocumentRecordTypeId(id);
			String recordcode = ParamUtil.getString(req, "recordcode");
			String recordname = ParamUtil.getString(req, "recordname");
			recordcode = StringUtil.encodeHtml(recordcode);
			recordname = StringUtil.encodeHtml(recordname);
			recordType.setDocumentRecordTypeCode(recordcode);
			recordType.setDocumentRecordTypeName(recordname);
			
			PmlEdmDocumentRecordTypeLocalServiceUtil.addPmlEdmDocumentRecordType(recordType);
		} catch (Exception e) {
			_log.error("NO ADD PMLEDMDOCUMENTRECORDTYPE");
			_log.error(e);
		}
	
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res) throws Exception
	{	
		
//			String cmd = ParamUtil.getString(req, Constants.CMD);
//			int documentRecordTypeId = ParamUtil.getInteger(req, "documentRecordTypeId");

//					if (cmd.equals(Constants.DELETE)) {
//				deleteRecord(documentRecordTypeId);
//			}
			
//			List<PmlEdmDocumentRecordType> listrecordtype= PmlEdmDocumentRecordTypeUtil.findAll();
//			
//			req.setAttribute("listrecordtype",listrecordtype);
		
		return mapping.findForward("portlet.sgs.documentrecordtype.view");
		
	}
	/* yenlt close 23082010
	private boolean deleteRecord(ActionRequest req) throws Exception {
		// chua kiem tra ren buoc
		int documentRecordTypeId = ParamUtil.getInteger(req, "pmlEdmDocumentRecordTypeId");
		try {
			List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.
				findByDocumentRecordTypeId(documentRecordTypeId);
			if (pmlEdmDocumentTypeList != null && !pmlEdmDocumentTypeList.isEmpty()) {
				return false;
				
			} else {
				PmlEdmDocumentRecordTypeLocalServiceUtil.deletePmlEdmDocumentRecordType(documentRecordTypeId);
				return true;
			}
		} catch (Exception e) {
			_log.error("NO DELETE PMLEDMDOCUMENTRECORDTYPE");
			_log.error(e);
			return false;
		}
	}
	*/
	// yenlt update 23082010
	private void deleteRecord(ActionRequest req) throws Exception {
		// chua kiem tra ren buoc
		int documentRecordTypeId = ParamUtil.getInteger(req, "pmlEdmDocumentRecordTypeId");
		PmlEdmDocumentRecordTypeLocalServiceUtil.removePmlEdmDocumentType(documentRecordTypeId);
	}
	// end yenlt update 23082010

}
