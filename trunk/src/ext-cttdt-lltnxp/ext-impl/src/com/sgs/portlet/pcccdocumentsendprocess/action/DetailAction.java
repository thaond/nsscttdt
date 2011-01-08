
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pcccdocumentsend.dto.DocumentSendLogDTO;
import com.sgs.portlet.pcccdocumentsendprocess.dto.DocumentSendLogNode;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class DetailAction extends DocumentSendPortletAction {

	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		/*
		 * Process Action Code Goes Here
		 */
	}

	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		DocumentSendDTO documentSendDTO = new DocumentSendDTO();
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document =
			PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		documentSendDTO = populateDocumentSendToDTO(document);

		// attachedFiles
		List<PmlEdmAttachedFile> attachedFiles =
			PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType_D_OR_H(
				documentSendId,
				new PmlEdmDocumentSendImpl().getClass().getName(), true);

		List<PmlEdmAnswerDetail> answerDetails =
			PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);

		if ((answerDetails != null) && (answerDetails.size() != 0)) {
			PmlEdmAnswerDetail answerDetail = answerDetails.get(0);
			long documentReceipt = answerDetail.getDocumentReceiptId();
			PmlEdmDocumentReceipt receipt =
				PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceipt);
			req.setAttribute("documentReceipt", receipt);

			List<PmlEdmAttachedFile> attachedFileReceivers =
				PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(
					documentReceipt,
					new PmlEdmDocumentReceiptImpl().getClass().getName());

			req.setAttribute("attachedFileReceivers", attachedFileReceivers);
		}

		long editor = document.getEditorId();
		/*
		 * xuancong close start PmlUser user =
		 * PmlUserLocalServiceUtil.getPmlUser(editor); String departmentId =
		 * user.getDepartmentsId(); PmlDepartment department =
		 * PmlDepartmentUtil.findByPrimaryKey(departmentId);
		 * req.setAttribute("department", department.getDepartmentsName());
		 * xuancong close end
		 */
		// xuancong add start
		// Sua loi No PmlUser exists with the primary key 0
		PmlUser user = null;
		String departmentId = "";
		Department department = null;
		try {
			if (editor > 0) {
				user = PmlUserLocalServiceUtil.getPmlUser(editor);
				departmentId = user.getDepartmentsId();
				department = DepartmentUtil.findByPrimaryKey(departmentId);
			}
		}
		catch (Exception ex) {
			// Do nothing
		}

		if (department != null) {
			req.setAttribute("department", department.getDepartmentsName());
		}
		else {
			req.setAttribute("department", "");
		}
		// xuancong add end

		req.setAttribute("documentDTO", documentSendDTO);
		req.setAttribute("attachedFiles", attachedFiles);

		// lay so cong van den cua phong

		List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList = null;
		try {
			pmlEdmWriteDocumentSendList =
				PmlEdmWriteDocumentSendUtil.findByDocumentSendId(documentSendId);
		}
		catch (Exception e) {
			pmlEdmWriteDocumentSendList =
				new ArrayList<PmlEdmWriteDocumentSend>();
		}

		long bookDocumentSendId = 0;
		PmlEdmBookDocumentSend pmlEdmBookDocumentSend = null;
		String soCongVanDiHientai = "";
		for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : pmlEdmWriteDocumentSendList) {
			bookDocumentSendId =
				pmlEdmWriteDocumentSend.getBookDocumentSendId();
			try {
				pmlEdmBookDocumentSend =
					PmlEdmBookDocumentSendUtil.findByPrimaryKey(bookDocumentSendId);
			}
			catch (Exception e) {
				pmlEdmBookDocumentSend = null;
			}

			if ((null != pmlEdmBookDocumentSend) &&
				departmentId.equals(pmlEdmBookDocumentSend.getDepartmentsId())) {
				soCongVanDiHientai =
					String.valueOf(pmlEdmWriteDocumentSend.getSoCongVanDiPhongHienTai());
				break;
			}
		}

		req.setAttribute("soCongVanDiHientai", soCongVanDiHientai);

		// lay hscv
		List<PmlChiTietHSCV> chiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		try {
			chiTietHSCVList =
				PmlChiTietHSCVUtil.findByIdCongVanDi(documentSendId);
		}
		catch (Exception e) {

		}

		List<PmlHoSoCongViec> pmlHoSoCongViecList =
			new ArrayList<PmlHoSoCongViec>();
		if (chiTietHSCVList.size() > 0) {

			PmlHoSoCongViec pmlHoSoCongViec = null;
			for (PmlChiTietHSCV pmlChiTietHSCV : chiTietHSCVList) {
				try {
					pmlHoSoCongViec =
						PmlHoSoCongViecUtil.findByPrimaryKey(pmlChiTietHSCV.getIdHoSoCongViec());
				}
				catch (Exception e) {
				}

				if (pmlHoSoCongViec != null) {
					pmlHoSoCongViecList.add(pmlHoSoCongViec);
				}

			}
		}
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);

		// Canh
		DocumentSendLogNode root = null;
		try {
			List<PmlDocumentSendLog> documentSendLogs =
				PmlDocumentSendLogUtil.findByDocumentSendId_Transition(
					documentSendId, 1);
			if (documentSendLogs.size() > 0) {
				root = new DocumentSendLogNode(documentSendLogs.get(0), null);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("workflow_tree", root);
		// End of Canh

		// watch series process
		List<PmlDocumentSendLog> pmlDocumentSendLogList =
			PmlDocumentSendLogUtil.findByDocumentSendId(documentSendId);
		List<DocumentSendLogDTO> documentSendLogDTOs =
			new ArrayList<DocumentSendLogDTO>();
		if (pmlDocumentSendLogList != null) {
			for (int i = 0; i < pmlDocumentSendLogList.size(); i++) {
				PmlDocumentSendLog log = pmlDocumentSendLogList.get(i);
				DocumentSendLogDTO sendDTO = new DocumentSendLogDTO();
				User processer = null;
				try {
					processer = UserUtil.findByPrimaryKey(log.getProcesser());
					sendDTO.setProcessor(com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(processer));

				}
				catch (Exception e) {
					sendDTO.setProcessor("");
				}
				try {
					processer =
						UserUtil.findByPrimaryKey(log.getDirectProcesserId());
					sendDTO.setProcessor(sendDTO.getProcessor() +
						"<br/><small>\u1ee6y quy\u1ec1n x\u1eed l\u00fd: " +
						com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(processer) +
						"</small>");

				}
				catch (Exception e) {
				}

				// sendDTO.setProcessor(com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(processer));
				sendDTO.setDateProcess(log.getDateProcess());
				sendDTO.setProcessInformation(log.getProcessInfomation());
				User receiver = null;
				try {
					receiver = UserUtil.findByPrimaryKey(log.getReceiver());
					sendDTO.setReceiver(com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(receiver));
				}
				catch (Exception e) {
					sendDTO.setReceiver("");
				}

				sendDTO.setReceiverDate(log.getReceiveDate());
				sendDTO.setExpireDate(log.getExpiredDate());
				documentSendLogDTOs.add(sendDTO);
			}
		}

		List<DocumentSendLogDTO> logDTOs = new ArrayList<DocumentSendLogDTO>();
		for (int i = documentSendLogDTOs.size() - 1; i > -1; i--) {
			logDTOs.add(documentSendLogDTOs.get(i));
		}

		req.setAttribute("pmlDocumentSendLogList", logDTOs);

		/* get current node by fileId */
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		boolean processTranlate =
			ParamUtil.getBoolean(req, "vtxulythayldb", false);
		boolean processTranlateLDVP =
			ParamUtil.getBoolean(req, "vtxulythayldvp", false);

		long userId = 0;
		if ((0 != userIdXLT) && (processTranlate || processTranlateLDVP)) {
			userId = userIdXLT;
		}
		else {
			userId = PortalUtil.getUserId(req);
		}

		DocumentSendLiferayWorkflowService service =
			new DocumentSendLiferayWorkflowService();
		service.updateReceiveDate(documentSendId, userId);

		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.detail");
		}
	}

}
