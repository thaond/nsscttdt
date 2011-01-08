package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.DuplicateDocumentRelationException;
import com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DocumentRelationAction extends PortletAction {

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD)) {
				// Them moi lien ket van ban
				updatePmlEdmDocumentRelation(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deletePmlEdmDocumentRelation(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(actionRequest, "redirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pcccdocumentsendprocess.error");
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		}
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.documentrelation");
		}
	}

	protected void updatePmlEdmDocumentRelation(ActionRequest actionRequest)
	throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
	
		// Lay du lieu truyen qua form
		long documentId = ParamUtil.getLong(uploadRequest, "documentId");
		String addDocReceiptIds = ParamUtil.getString(uploadRequest, "addDocReceiptIds");
		String addDocSendIds = ParamUtil.getString(uploadRequest, "addDocSendIds");
		
		// Khong thuc thi neu nhu ma so documentId khong xac dinh
		if (documentId <= 0) return;
		
		// ***** Duyet danh sach ma so van ban den can them lien ket de them start *****
		if (addDocReceiptIds.length() > 0) {
			String[] arrDocReceiptIds = addDocReceiptIds.split(":");
			for (int idxDR = 0; idxDR < arrDocReceiptIds.length; idxDR ++) {
				try {
					long docRightId = Long.valueOf(arrDocReceiptIds[idxDR]);
					// Goi ham them lien ket
					PmlEdmDocumentRelationLocalServiceUtil.addPmlEdmDocumentRelation(
							documentId, docRightId, false, true);
				}
				catch (Exception ex) {
					if (ex instanceof NumberFormatException) {
						System.out.println("Khong phai ma so hop le:" + arrDocReceiptIds[idxDR]);
					}
					else if (ex instanceof DuplicateDocumentRelationException) {
						System.out.println("Trung lien ket, khong them");
					}
				}
			}
		}
		// ***** Duyet danh sach ma so van ban den can them lien ket de them end *****
	
		// ***** Duyet danh sach ma so van ban di can them lien ket de them start *****
		if (addDocSendIds.length() > 0) {
			String[] arrDocSendIds = addDocSendIds.split(":");
			for (int idxDS = 0; idxDS < arrDocSendIds.length; idxDS ++) {
				try {
					long docRightId = Long.valueOf(arrDocSendIds[idxDS]);
					// Goi ham them lien ket
					PmlEdmDocumentRelationLocalServiceUtil.addPmlEdmDocumentRelation(
							documentId, docRightId, false, false);
				}
				catch (Exception ex) {
					if (ex instanceof NumberFormatException) {
						System.out.println("Khong phai ma so hop le:" + arrDocSendIds[idxDS]);
					}
					else if (ex instanceof DuplicateDocumentRelationException) {
						System.out.println("Trung lien ket, khong them");
					}
				}
			}
		}
		// ***** Duyet danh sach ma so van ban di can them lien ket de them end *****

		return;
	}

	protected void deletePmlEdmDocumentRelation(ActionRequest actionRequest)
	throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
	
		long documentId = ParamUtil.getLong(uploadRequest, "documentId");
		String delDocReceiptIds = ParamUtil.getString(uploadRequest, "delDocReceiptIds");
		String delDocSendIds = ParamUtil.getString(uploadRequest, "delDocSendIds");
		
		// ***** Duyet chuoi delDocReceiptIds de tao ra danh sach ma so van ban den can xoa lien ket start *****
		if (delDocReceiptIds.length() > 0) {
			List<Long> lstDelDocReceiptId = new ArrayList<Long>();
			String[] arrTemp = delDocReceiptIds.split(":");
			for (int idxTmp = 0; idxTmp < arrTemp.length; idxTmp ++) {
				try {
					if (Long.valueOf(arrTemp[idxTmp]) > 0) {
						lstDelDocReceiptId.add(Long.valueOf(arrTemp[idxTmp]));
					}
				}
				catch (Exception ex) {
					System.out.println("Khong phai ma so hop le:" + arrTemp[idxTmp]);
				}
			}
			// Goi ham xoa
			if (!lstDelDocReceiptId.isEmpty()) {
				PmlEdmDocumentRelationLocalServiceUtil.deleteByDocumentId_RelationDocumentIds(
						documentId, false, lstDelDocReceiptId, true);
			}
		}
		// ***** Duyet chuoi delDocReceiptIds de tao ra danh sach ma so van ban den can xoa lien ket end *****

		// ***** Duyet chuoi delDocSendIds de tao ra danh sach ma so van ban di can xoa lien ket start *****
		if (delDocSendIds.length() > 0) {
			List<Long> lstDelDocSendId = new ArrayList<Long>();
			String[] arrTemp = delDocSendIds.split(":");
			for (int idxTmp = 0; idxTmp < arrTemp.length; idxTmp ++) {
				try {
					if (Long.valueOf(arrTemp[idxTmp]) > 0) {
						lstDelDocSendId.add(Long.valueOf(arrTemp[idxTmp]));
					}
				}
				catch (Exception ex) {
					System.out.println("Khong phai ma so hop le:" + arrTemp[idxTmp]);
				}
			}
			// Goi ham xoa
			if (!lstDelDocSendId.isEmpty()) {
				PmlEdmDocumentRelationLocalServiceUtil.deleteByDocumentId_RelationDocumentIds(
						documentId, false, lstDelDocSendId, false);
			}
		}
		// ***** Duyet chuoi delDocSendIds de tao ra danh sach ma so van ban di can xoa lien ket end *****
	}
}