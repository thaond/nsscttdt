package com.nss.portlet.onedoorprocess.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.impl.PmlFileReturningInfoImpl;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class ReturnDocumentAction extends OneDoorProcessPortletAction {

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req,
			ActionResponse res) throws Exception {
		
		saveReturnDocumentInfo(req);
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "return",PortletSession.APPLICATION_SCOPE);
		String isDelegate = ParamUtil.getString(req, "isDelegate");
		addWorkflowParameter(req, "isDelegate", WorkflowParam.TRANSIENT, isDelegate);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req,
			RenderResponse res) throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			initData(req, res);
			return mapping.findForward("portlet.nss.onedoorprocess.returndocument");
		}
	}

	private void initData(RenderRequest req, RenderResponse res) throws Exception {
		
		String fileId = ParamUtil.getString(req, "fileId");
		PmlFilePCCC filePccc = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
		PmlOneDoorReceiveFile pmlFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		req.setAttribute("filePccc", filePccc);
		req.setAttribute("pmlFile", pmlFile);
	}
	
	private boolean saveReturnDocumentInfo(ActionRequest req) throws Exception {
		
		boolean flag = true;
		try {
		
			String fileId = ParamUtil.getString(req, "fileId");
			// Cap nhat thong tin vao bang pml_filereturninginfo
			PmlFileReturningInfo pmlFileReturningInfo = new PmlFileReturningInfoImpl();
			pmlFileReturningInfo.setFileReturningInfoId(CounterUtil.increment());
			pmlFileReturningInfo.setFileId(fileId);
			pmlFileReturningInfo.setFileSender(ParamUtil.getString(req, "nguoiTra"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date receiveLicenseDate = dateFormat.parse(ParamUtil.getString(req, "ngayNhanGiayPhep"));
			pmlFileReturningInfo.setReceiveLicenseDate(receiveLicenseDate);
			pmlFileReturningInfo.setDocumentNumber(ParamUtil.getString(req, "soCongVan"));
			pmlFileReturningInfo.setBillNumber(ParamUtil.getString(req, "soHoaDon"));
			pmlFileReturningInfo.setNumberMoney(ParamUtil.getLong(req, "soTien"));
			pmlFileReturningInfo.setNote(ParamUtil.getString(req, "ghiChu"));
			PmlFileReturningInfoLocalServiceUtil.addPmlFileReturningInfo(pmlFileReturningInfo);
			
			// Cap nhat ngay tra vao bang pml_file
			PmlOneDoorReceiveFile pmlFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
			Date exactReturningDate = dateFormat.parse(ParamUtil.getString(req, "ngayTra"));
			pmlFile.setExactReturningDate(exactReturningDate);
			PmlOneDoorReceiveFileLocalServiceUtil.updatePmlOneDoorReceiveFile(pmlFile);
			
		} catch(Exception e) {
			flag = false;
		}
		return flag;
	}
}
