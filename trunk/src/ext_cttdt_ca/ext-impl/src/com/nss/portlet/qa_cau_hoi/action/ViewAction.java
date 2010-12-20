package com.nss.portlet.qa_cau_hoi.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;
import com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil;
import com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalServiceUtil;
import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalServiceUtil;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil;

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
		if (Validator.isNotNull(cmd)) {
			if (Constants.VIEW.equals(cmd)) {
				viewDetail(req);
			}
			else if (Constants.ADD.equals(cmd)) {
				addCauHoi(req);
				sendRedirect(req, res, redirect);
			}
		}
	}

	private void addCauHoi(ActionRequest req) {
		String tieuDeCauHoi = ParamUtil.getString(req, "tieuDeCauHoi");
		String email = ParamUtil.getString(req, "email");
		String tenNguoiHoi = ParamUtil.getString(req, "tenNguoiHoi");
		String noiDungHoi = ParamUtil.getString(req, "noiDung");
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi");
		long maCauHoi = 0;
		CauHoiQA cauHoiQA = null;
		
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		// end
		
		try {
			maCauHoi = CounterLocalServiceUtil.increment();
			cauHoiQA = CauHoiQALocalServiceUtil.createCauHoiQA(maCauHoi);
			cauHoiQA.setMaChuDeCauHoi(maChuDeCauHoi);
			cauHoiQA.setTieuDe(tieuDeCauHoi);
			cauHoiQA.setTenNguoiHoi(tenNguoiHoi);
			cauHoiQA.setEmail(email);
			cauHoiQA.setNoiDungHoi(noiDungHoi);
			cauHoiQA.setCreatedate(new Date());
			cauHoiQA.setPublish(false);
			cauHoiQA = CauHoiQALocalServiceUtil.addCauHoiQA(cauHoiQA);
			
			if (file.exists()) {
				uploadFile(req, file, cauHoiQA);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	public void uploadFile(ActionRequest req, File file, CauHoiQA cauHoiQA) {
		String tenFile = ParamUtil.getString(req, "fileName");
		String fileName = StringUtil.getDateTime() + tenFile;	
		String patthFile = getServlet().getServletContext().getRealPath("/") + "upload/hoidaptructuyen";
		File destFile = new File(patthFile + "/" + fileName);
		long fileSize = file.length()/ 1024;
		if (!(new File(patthFile)).exists()) {
			(new File(patthFile)).mkdir();
		}
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			_log.error(e.getMessage());
		}
		
		long maFileDinhKem = 0;
		FileDinhKemQA fileDinhKem = null;
		try {
			maFileDinhKem = CounterLocalServiceUtil.increment();
			fileDinhKem = FileDinhKemQALocalServiceUtil.createFileDinhKemQA(maFileDinhKem);
			fileDinhKem.setMaCauHoi(cauHoiQA.getMaCauHoiQA());
			fileDinhKem.setTenFile(tenFile); 
			fileDinhKem.setKichThuoc(fileSize);
			fileDinhKem.setDuongDan("/upload/hoidaptructuyen/" + fileName);
			fileDinhKem = FileDinhKemQALocalServiceUtil.addFileDinhKemQA(fileDinhKem);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public void viewDetail(ActionRequest req) {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		List<FileDinhKemQA> fileDinhKemQAList = new ArrayList<FileDinhKemQA>();
		CauHoiQA cauHoiQA = null;
		FileDinhKemQA file = null;
		try {
			cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi_Publish(maCauHoi);
		if (cauTraLoiQAList.size() > 0) {
			for (int i = 0; i < cauTraLoiQAList.size(); i++) {
				CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				file = FileDinhKemQALocalServiceUtil.findByMaCauTraLoi(cauTraLoiQA.getMaCauTraLoiQA());
				if (null != file) {
					fileDinhKemQAList.add(file);
				}
			}
		}
		req.setAttribute("cauHoiQA", cauHoiQA);
		req.setAttribute("cauTraLoiQAList", cauTraLoiQAList);
		req.setAttribute("fileDinhKemQAList", fileDinhKemQAList);
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<QAChuDeCauHoi> qAChuDeCauHoilList = new ArrayList<QAChuDeCauHoi>();
			qAChuDeCauHoilList = QAChuDeCauHoiLocalServiceUtil.getQAChuDeCauHois(-1, -1);
			
			req.setAttribute("qAChuDeCauHoilList", qAChuDeCauHoilList);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.qa_cau_hoi.view");
			}
	}

	
}
