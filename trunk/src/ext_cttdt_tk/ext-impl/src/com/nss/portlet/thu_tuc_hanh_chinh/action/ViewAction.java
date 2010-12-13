package com.nss.portlet.thu_tuc_hanh_chinh.action;

import java.io.File;
import java.sql.Timestamp;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCImpl;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhImpl;
import com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalServiceUtil;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/thu_tuc_hanh_chinh/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editThuTucHanhChinh(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals("DETAIL")) {
				detailThuTucHanhChinh(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveThuTucHanhChinh(req, res);
				sendRedirect(req, res, redirect);
			}
		}
		
	}
	
	public void detailThuTucHanhChinh(ActionRequest req) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		ThuTucHanhChinh thuTucHanhChinh = null;
		try {
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(maThuTucHanhChinh);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("thuTucHanhChinh", thuTucHanhChinh);
	}
	
	public void deleteThuTucHanhChinh(ActionRequest req) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		List<FileDinhKemTTHC> fileDinhKemTTHCList = new ArrayList<FileDinhKemTTHC>();
		
		fileDinhKemTTHCList = FileDinhKemTTHCLocalServiceUtil.findByMaThuTucHanhChinh(maThuTucHanhChinh);
		try {
			ThuTucHanhChinhLocalServiceUtil.deleteThuTucHanhChinh(maThuTucHanhChinh);
			for (int i = 0; i < fileDinhKemTTHCList.size(); i++) {
				FileDinhKemTTHCLocalServiceUtil.deleteFileDinhKemTTHC(fileDinhKemTTHCList.get(i));
			}
			req.setAttribute("delete", true);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
	}
	
	public void updateActiveThuTucHanhChinh(ActionRequest req,
			ActionResponse res) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		ThuTucHanhChinh thuTucHanhChinh = null;
		Date date = new Date();
		
		try {
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(maThuTucHanhChinh);
			if (thuTucHanhChinh.getActive() == 0) {
				thuTucHanhChinh.setActive(1);
				thuTucHanhChinh.setModifieddate(date);
				ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(thuTucHanhChinh);
			} else {
				thuTucHanhChinh.setActive(0);
				thuTucHanhChinh.setModifieddate(date);
				ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(thuTucHanhChinh);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	public void updateThuTucHanhChinh(ActionRequest req) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		String tenThuTucHanhChinh = ParamUtil.getString(req, "tenThuTucHanhChinh");
		long maLinhVucThuTuc = ParamUtil.getLong(req, "maLinhVucThuTuc");
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		String diaChiLienHe = ParamUtil.getString(req, "diaChiLienHe");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		// phan cho file upload
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		//delete recent upload file
		String str_filethutuchanhchinhtodelete = ParamUtil.getString(req, "str_filethutuchanhchinhtodelete", "");
		if (!"".equals(str_filethutuchanhchinhtodelete) || str_filethutuchanhchinhtodelete != null) {
			try {
				deleteFileUpload(str_filethutuchanhchinhtodelete);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		// end
		ThuTucHanhChinh thuTucHanhChinh = null;
		try {
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(maThuTucHanhChinh);
			thuTucHanhChinh.setMaThuTucHanhChinh(maThuTucHanhChinh);
			thuTucHanhChinh.setTenThuTucHanhChinh(tenThuTucHanhChinh);
			thuTucHanhChinh.setMaLinhVucThuTucHanhChinh(maLinhVucThuTuc);
			thuTucHanhChinh.setMaDonViThuTucHanhChinh(maDonViThuTuc);
			thuTucHanhChinh.setDiaChiLienHe(diaChiLienHe);
			thuTucHanhChinh.setModifieddate(new Date());
			thuTucHanhChinh.setCompanyid(companyId);
			thuTucHanhChinh.setUserid(userId);
			
			if (active) {
				thuTucHanhChinh.setActive(1);
			} else {
				thuTucHanhChinh.setActive(0);
			}
			
			ThuTucHanhChinhLocalServiceUtil.updateThuTucHanhChinh(thuTucHanhChinh);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		/*
		 * upload file
		 */
		
		if (!"".equals(nameFieldRow)) {
			String [] nameFieldRowArr = nameFieldRow.split("_");
			String [] titleFilesArr = titleFiles.split("#");
			if (titleFilesArr.length == 0) {
				titleFilesArr = new String [nameFieldRowArr.length];
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					titleFilesArr[i] = "";
				}
			}
			for (int i = 0; i < nameFieldRowArr.length; i++) {
				uploadFile(req, nameFieldRowArr[i], thuTucHanhChinh, titleFilesArr[i]);
			}
		}
	}
	
	public void editThuTucHanhChinh(ActionRequest req, ActionResponse res) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		int radioCapDonVi = ParamUtil.getInteger(req, "radioCapDonVi", 0);
		
		ThuTucHanhChinh thuTucHanhChinh = null;
		List<FileDinhKemTTHC> fileDinhKemList = new ArrayList<FileDinhKemTTHC>();
		try {
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(maThuTucHanhChinh);
			fileDinhKemList = FileDinhKemTTHCLocalServiceUtil.findByMaThuTucHanhChinh(maThuTucHanhChinh);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("thuTucHanhChinh", thuTucHanhChinh);
		req.setAttribute("fileDinhKemList", fileDinhKemList);
		req.setAttribute("radioCapDonVi", radioCapDonVi);
	}
	
	public void addThuTucHanhChinh(ActionRequest req) {
		Date date = new Date();
		
		String tenThuTucHanhChinh = ParamUtil.getString(req, "tenThuTucHanhChinh");
		long maLinhVucThuTuc = ParamUtil.getLong(req, "maLinhVucThuTuc");
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		String diaChiLienHe = ParamUtil.getString(req, "diaChiLienHe");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		ThuTucHanhChinh thuTucHanhChinh = null;
		long maThuTucHanhChinh = 0;
		long userId = PortalUtil.getUserId(req);
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maThuTucHanhChinh = CounterLocalServiceUtil.increment();
		} catch (Exception e) {
			_log.error(e);
		}
		
		// phan cho file upload
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		// end
		try {
			thuTucHanhChinh = new ThuTucHanhChinhImpl();
			thuTucHanhChinh.setMaThuTucHanhChinh(maThuTucHanhChinh);
			thuTucHanhChinh.setTenThuTucHanhChinh(tenThuTucHanhChinh);
			thuTucHanhChinh.setMaLinhVucThuTucHanhChinh(maLinhVucThuTuc);
			thuTucHanhChinh.setMaDonViThuTucHanhChinh(maDonViThuTuc);
			thuTucHanhChinh.setDiaChiLienHe(diaChiLienHe);
			
			if (null != user) {
				thuTucHanhChinh.setCompanyid(user.getCompanyId());
				thuTucHanhChinh.setUserid(userId);
			}
			
			thuTucHanhChinh.setCreatedate(date);
			
			if (active) {
				thuTucHanhChinh.setActive(1);
			} else {
				thuTucHanhChinh.setActive(0);
			}
			
			ThuTucHanhChinhLocalServiceUtil.addThuTucHanhChinh(thuTucHanhChinh);
			/*
			 * upload file
			 */
			
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFile(req, nameFieldRowArr[i], thuTucHanhChinh, titleFilesArr[i]);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
	}
	
	/**
	 * This method allows upload many files from client to server 
	 * @param nameRowUpload 
	 * void 
	 *
	 */
	public void uploadFile(ActionRequest req, String nameFieldUpload, ThuTucHanhChinh thuTucHanhChinh, String titleFile) {
		try {
			//save file upload into folder upload
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String fileName = getDateTime()+ fileNames;			
			String patthFile = getServlet().getServletContext().getRealPath("/") + "upload/thutuchanhchinh";
			File destFile = new File(patthFile + "/" + fileName);
			long fileSize = myFile.length()/ 1024;
			if (!(new File(patthFile)).exists()) {
				(new File(patthFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			long maVanBanPhapQuy = 0;
			if (null != thuTucHanhChinh) {
				maVanBanPhapQuy = thuTucHanhChinh.getMaThuTucHanhChinh();
			}
			// set value into FileDinhKemTTHC
			FileDinhKemTTHC fileDinhKem = new FileDinhKemTTHCImpl();
			fileDinhKem.setMaFileDinhKemTTHC(CounterLocalServiceUtil.increment());
			fileDinhKem.setMaThuTucHanhChinh(maVanBanPhapQuy);
			fileDinhKem.setKichThuoc(fileSize);
			fileDinhKem.setDuongDan("/upload/thutuchanhchinh/" + fileName);
			
			List<FileDinhKemTTHC> fileDinhKemList = new ArrayList<FileDinhKemTTHC>();
			try {
				fileDinhKemList = FileDinhKemTTHCLocalServiceUtil.findByMaThuTucHanhChinh(maVanBanPhapQuy);
			} catch (Exception e) {
				_log.error(e);
			}
			fileDinhKem.setPhienBan(fileDinhKemList.size() + 1);
			
			// lay ra screenname user hien hanh
			long userId = PortalUtil.getUser(req).getUserId();
			User user = UserUtil.findByPrimaryKey(userId);
			String userName = "";
			if (user != null) { // Nguoi dung xac dinh
				userName = user.getScreenName();
			}
			// set title
			fileDinhKem.setTenFile(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + getDateTime())); // set title
			fileDinhKem.setMoTa(""); // set title
			
			FileDinhKemTTHCLocalServiceUtil.addFileDinhKemTTHC(fileDinhKem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFileUpload(String str_filethutuchanhchinhtodelete) throws Exception {
		String[] fileUploadId = str_filethutuchanhchinhtodelete.split("/");
		for (int i = 0; i < fileUploadId.length; i++) {
			if (!"".equals(fileUploadId[i])) {
				long maFileDinhKem = Long.parseLong(fileUploadId[i]);
				FileDinhKemTTHCLocalServiceUtil.deleteFileDinhKemTTHC(maFileDinhKem);
			}
		}
	}
	
	
	public static String getDateTime() {
		String result = "";
		Date dateCurrent = new Date();			
	    Timestamp timestamp = new Timestamp(dateCurrent.getTime());
	    result = timestamp.toString();	   
	    result = result.replaceAll("-", "");
	    result = result.replaceAll(" ", "");
	    result = result.replaceAll(":", "");
	    result = result.substring(0, result.indexOf("."));
		return result;
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = new ArrayList<LinhVucThuTucHanhChinh>();
				linhVucThuTucHanhChinhList = LinhVucThuTucHanhChinhLocalServiceUtil.findByActive(1);
				
				req.setAttribute("linhVucThuTucHanhChinhList", linhVucThuTucHanhChinhList);
				return mapping.findForward("portlet.nss.thu_tuc_hanh_chinh.view");
			}
	}

}
