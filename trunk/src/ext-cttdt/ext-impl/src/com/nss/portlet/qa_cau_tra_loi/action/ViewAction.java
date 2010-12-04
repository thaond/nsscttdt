package com.nss.portlet.qa_cau_tra_loi.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.mail.MailEngineException;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;
import com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil;
import com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalServiceUtil;
import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalServiceUtil;
import com.nss.portlet.qa_cau_tra_loi.util.SendMailUtil;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	public void addCauTraloi(ActionRequest req) throws AddressException {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		long maNguoiTraLoi = PortalUtil.getUserId(req);
		String noiDungTraLoi = ParamUtil.getString(req, "noiDungTraLoi");

		boolean answerThroughWeb = ParamUtil.getBoolean(req, "answerThroughWeb");
		boolean answerThroughEmail = ParamUtil.getBoolean(req, "answerThroughEmail");

		long maCauTraLoiQA = 0;
		CauTraLoiQA cauTraLoiQA = null;

		// cho phan gui mail
		boolean error = false;
		CauHoiQA cauHoi = null;
		InternetAddress toEmail = null;// tao dia chi mail
		String subject = "";

		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileupload = uploadRequest.getFile("file");
		// end
		try {
			maCauTraLoiQA = CounterLocalServiceUtil.increment();
			cauTraLoiQA = CauTraLoiQALocalServiceUtil.createCauTraLoiQA(maCauTraLoiQA);
			cauTraLoiQA.setMaCauHoiQA(maCauHoi);
			cauTraLoiQA.setMaNguoiTraLoi(maNguoiTraLoi);
			cauTraLoiQA.setNoiDungTraLoi(noiDungTraLoi);
			cauTraLoiQA.setCreatedate(new Date());
			cauTraLoiQA.setAnswerThroughWeb(answerThroughWeb);

			if (answerThroughEmail) { // chon tra loi qua email
				cauHoi = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
				subject = cauHoi.getTieuDe();
				try {
					toEmail = new InternetAddress(cauHoi.getEmail());
					SendMailUtil.sendMail(toEmail, subject, noiDungTraLoi, false, fileupload);
					cauTraLoiQA.setAnswerThroughEmail("0");
				} catch (MailEngineException e) {
					error = true;
				} 
			}

			CauTraLoiQALocalServiceUtil.addCauTraLoiQA(cauTraLoiQA);

			if (fileupload.exists()) {
				uploadFile(req, fileupload, cauTraLoiQA);
			}

		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} 

		req.setAttribute("error", error);
	}

	public void deleteCauHoi(ActionRequest req) {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		FileDinhKemQA fileDinhKemQA = null;
		try {
			cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi(maCauHoi);
			CauHoiQALocalServiceUtil.deleteCauHoiQA(maCauHoi);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		try {
			fileDinhKemQA = FileDinhKemQALocalServiceUtil.findByMaCauHoi(maCauHoi);
			if (null != fileDinhKemQA) {
				FileDinhKemQALocalServiceUtil.deleteFileDinhKemQA(fileDinhKemQA);
				String pathFile = getServlet().getServletContext().getRealPath("") + fileDinhKemQA.getDuongDan();
				deleteFileOnServer(pathFile);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (cauTraLoiQAList.size() > 0) {
			for (int i = 0; i < cauTraLoiQAList.size(); i++) {
				CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				try {
					fileDinhKemQA = FileDinhKemQALocalServiceUtil.findByMaCauTraLoi(cauTraLoiQA.getMaCauTraLoiQA());
					if (null != fileDinhKemQA) {
						FileDinhKemQALocalServiceUtil.deleteFileDinhKemQA(fileDinhKemQA);
						String pathFile = getServlet().getServletContext().getRealPath("") + fileDinhKemQA.getDuongDan();
						deleteFileOnServer(pathFile);
					}
					CauTraLoiQALocalServiceUtil.deleteCauTraLoiQA(cauTraLoiQA);
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
			}
		}

	}

	public void deleteCauTraloi(ActionRequest req) {
		long maCauTraLoi = ParamUtil.getLong(req, "maCauTraLoi");

		CauTraLoiQA cauTraLoiQA = null;
		FileDinhKemQA fileDinhKem = null;

		try {
			cauTraLoiQA = CauTraLoiQALocalServiceUtil.getCauTraLoiQA(maCauTraLoi);

			CauTraLoiQALocalServiceUtil.deleteCauTraLoiQA(cauTraLoiQA);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		try {
			fileDinhKem = FileDinhKemQALocalServiceUtil.findByMaCauTraLoi(maCauTraLoi);
			if (null != fileDinhKem) {
				String patthFile = getServlet().getServletContext().getRealPath("") + fileDinhKem.getDuongDan();
				File file = new File(patthFile);
				if (file.exists()) {
					file.delete();
				}
				FileDinhKemQALocalServiceUtil.deleteFileDinhKemQA(fileDinhKem);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

	}

	public void deleteFileOnServer(String pathFile) {
		File file = new File(pathFile);
		if (file.exists()) {
			file.delete();
		}
	}

	public void editCauTraloi(ActionRequest req) {
		long maCauTraLoi = ParamUtil.getLong(req, "maCauTraLoi");
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		CauTraLoiQA cauTraLoiQA = null;
		CauHoiQA cauHoiQA = null;
		FileDinhKemQA fileDinhKemQA = null;

		try {
			cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
		} catch (Exception e1) {
			_log.error(e1.getMessage());
		}

		try {
			cauTraLoiQA = CauTraLoiQALocalServiceUtil.getCauTraLoiQA(maCauTraLoi);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		fileDinhKemQA = FileDinhKemQALocalServiceUtil.findByMaCauTraLoi(maCauTraLoi);
		req.setAttribute("cauHoiQA", cauHoiQA);
		req.setAttribute("cauTraLoiQA", cauTraLoiQA);
		req.setAttribute("fileDinhKemQA", fileDinhKemQA);
	}

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void prepareCauTraloi(ActionRequest req) {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		CauHoiQA cauHoiQA = null;
		try {
			cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi(maCauHoi);
		req.setAttribute("cauHoiQA", cauHoiQA);
		req.setAttribute("cauTraLoiQAList", cauTraLoiQAList);
	}

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		if (Validator.isNotNull(cmd)) {
			if (Constants.ADD.equals(cmd)) {
				addCauTraloi(req);
			} else if ("UPDATE_CAUHOI".equals(cmd)) {
				updateCauHoi(req);
			} else if ("DELETE_CAUHOI".equals(cmd)) {
				deleteCauHoi(req);
				sendRedirect(req, res, redirect);
			} else if (Constants.DELETE.equals(cmd)) {
				deleteCauTraloi(req);
			} else if (Constants.EDIT.equals(cmd)) {
				editCauTraloi(req);
			} else if (Constants.UPDATE.equals(cmd)) {
				updateCauTraloi(req);
			} else if ("ANSWER".equals(cmd)) {
				prepareCauTraloi(req);
			} else if ("PUBLISH".equals(cmd)) {
				publishCauTraloi(req);
			}
		}
	}

	public void publishCauTraloi(ActionRequest req) {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		long maCauTraLoi = ParamUtil.getLong(req, "maCauTraLoi");
		CauHoiQA cauHoiQA = null;
		CauTraLoiQA cauTraLoiQA = null;
		try {
			cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
			cauHoiQA.setPublish(true);
			cauHoiQA = CauHoiQALocalServiceUtil.updateCauHoiQA(cauHoiQA);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		try {
			cauTraLoiQA = CauTraLoiQALocalServiceUtil
			.getCauTraLoiQA(maCauTraLoi);
			cauTraLoiQA.setPublish(true);
			cauTraLoiQA = CauTraLoiQALocalServiceUtil
			.updateCauTraLoiQA(cauTraLoiQA);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
	throws Exception {

		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (Validator.isNotNull(cmd) && !(Constants.EDIT.equals(cmd))
				&& !("DELETE_CAUHOI".equals(cmd)) && !("ANSWER".equals(cmd))) {
			setDataForDetail(req);
		}
		List<QAChuDeCauHoi> qAChuDeCauHoilList = new ArrayList<QAChuDeCauHoi>();
		qAChuDeCauHoilList = QAChuDeCauHoiLocalServiceUtil.getQAChuDeCauHois(
				-1, -1);

		req.setAttribute("qAChuDeCauHoilList", qAChuDeCauHoilList);
		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		} else {
			return mapping.findForward("portlet.nss.qa_cau_tra_loi.view");
		}
	}


	public void setDataForDetail(RenderRequest req) {
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
		cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi(maCauHoi);
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

	public void updateCauHoi(ActionRequest req) {
		long maCauHoi = ParamUtil.getLong(req, "maCauHoi");
		String tieuDe = ParamUtil.getString(req, "tieuDe");
		String noiDungHoi = ParamUtil.getString(req, "noiDungHoi");
		CauHoiQA cauHoiQA = null;

		try {
			cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
			cauHoiQA.setTieuDe(tieuDe);
			cauHoiQA.setNoiDungHoi(noiDungHoi);
			cauHoiQA = CauHoiQALocalServiceUtil.updateCauHoiQA(cauHoiQA);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	public void updateCauTraloi(ActionRequest req) {
		long maCauTraLoi = ParamUtil.getLong(req, "maCauTraLoi");
		String noiDungTraLoi = ParamUtil.getString(req, "noiDungTraLoi");
		CauTraLoiQA cauTraLoiQA = null;

		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil
		.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		// end
		try {
			cauTraLoiQA = CauTraLoiQALocalServiceUtil
			.getCauTraLoiQA(maCauTraLoi);
			cauTraLoiQA.setNoiDungTraLoi(noiDungTraLoi);
			cauTraLoiQA = CauTraLoiQALocalServiceUtil
			.updateCauTraLoiQA(cauTraLoiQA);

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (file.exists()) {
			FileDinhKemQA fileDinhKemQA = null;
			try {
				fileDinhKemQA = FileDinhKemQALocalServiceUtil
				.findByMaCauTraLoi(maCauTraLoi);
				if (null != fileDinhKemQA) {
					FileDinhKemQALocalServiceUtil
					.deleteFileDinhKemQA(fileDinhKemQA);
					String pathFile = getServlet().getServletContext()
					.getRealPath("")
					+ fileDinhKemQA.getDuongDan();
					deleteFileOnServer(pathFile);
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			uploadFile(req, file, cauTraLoiQA);
		}

	}

	public void uploadFile(ActionRequest req, File file, CauTraLoiQA cauTraLoiQA) {
		String tenFile = ParamUtil.getString(req, "fileName");
		String fileName = StringUtil.getDateTime() + tenFile;
		String patthFile = getServlet().getServletContext().getRealPath("/")  + "upload/hoidaptructuyen";
		File destFile = new File(patthFile + "/" + fileName);
		long fileSize = file.length() / 1024;
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
			fileDinhKem = FileDinhKemQALocalServiceUtil
			.createFileDinhKemQA(maFileDinhKem);
			fileDinhKem.setMaCauTraLoi(cauTraLoiQA.getMaCauTraLoiQA());
			fileDinhKem.setTenFile(tenFile);
			fileDinhKem.setKichThuoc(fileSize);
			fileDinhKem.setDuongDan("/upload/hoidaptructuyen/" + fileName);
			fileDinhKem = FileDinhKemQALocalServiceUtil
			.addFileDinhKemQA(fileDinhKem);
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
		cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi(maCauHoi);
		if (cauTraLoiQAList.size() > 0) {
			for (int i = 0; i < cauTraLoiQAList.size(); i++) {
				CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				file = FileDinhKemQALocalServiceUtil
				.findByMaCauTraLoi(cauTraLoiQA.getMaCauTraLoiQA());
				if (null != file) {
					fileDinhKemQAList.add(file);
				}
			}
		}
		req.setAttribute("cauHoiQA", cauHoiQA);
		req.setAttribute("cauTraLoiQAList", cauTraLoiQAList);
		req.setAttribute("fileDinhKemQAList", fileDinhKemQAList);

	}

}
