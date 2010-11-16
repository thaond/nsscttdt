package com.nss.portlet.van_ban_phap_quy.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemImpl;
import com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyImpl;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalServiceUtil;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/van_ban_phap_quy/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addVanBanPhapQuy(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editVanBanPhapQuy(req, res);
			}
			
			else if (cmd.equals("DETAIL")) {
				detailVanBanPhapQuy(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteVanBanPhapQuy(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateVanBanPhapQuy(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveVanBanPhapQuy(req, res);
				sendRedirect(req, res, redirect);
			}
		}
	}
	
	public void detailVanBanPhapQuy(ActionRequest req, ActionResponse res) {
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		VanBanPhapQuy vanBanPhapQuy = null;

		try {
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
		} catch (Exception e) {
			_log.error(e);
		}
		
		req.setAttribute("vanBanPhapQuy", vanBanPhapQuy);
	}
	
	
	public void updateActiveVanBanPhapQuy(ActionRequest req, ActionResponse res) {
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		
		VanBanPhapQuy vanBanPhapQuy = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
			if (vanBanPhapQuy.getActive() == 1 ) {
				vanBanPhapQuy.setActive(0);
				vanBanPhapQuy.setModifieddate(date);
				vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy(companyId, vanBanPhapQuy);
			} else if (vanBanPhapQuy.getActive() == 0) {
				vanBanPhapQuy.setActive(1);
				vanBanPhapQuy.setModifieddate(date);
				vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy(companyId, vanBanPhapQuy);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void updateVanBanPhapQuy(ActionRequest req) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		String kyHieuVanBan = ParamUtil.getString(req, "kyHieuVanBan");
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		String tomTat = ParamUtil.getString(req, "tomTat");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		String nguon = ParamUtil.getString(req, "nguon");
		String noiDung = ParamUtil.getString(req, "noiDung");
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy");
		
		Date ngayKy = null;
		String ngayKyString = ParamUtil.getString(req, "ngayKy");
		if (!ngayKyString.equals("")) {
			try {
				ngayKy = sdf.parse(ngayKyString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayCoHieuLuc = null;
		String ngayCoHieuLucString = ParamUtil.getString(req, "ngayCoHieuLuc");
		if (!ngayCoHieuLucString.equals("")) {
			try {
				ngayCoHieuLuc = sdf.parse(ngayCoHieuLucString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayHetHieuLuc = null;
		String ngayHetHieuLucString = ParamUtil.getString(req, "ngayHetHieuLuc");
		if (!ngayHetHieuLucString.equals("")) {
			try {
				ngayHetHieuLuc = sdf.parse(ngayHetHieuLucString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayBanHanh = null;
		String ngayBanHanhString = ParamUtil.getString(req, "ngayBanHanh");
		if (!ngayBanHanhString.equals("")) {
			try {
				ngayBanHanh = sdf.parse(ngayBanHanhString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		// phan cho file upload
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		//delete recent upload file
		String str_filevanbanphapquytodelete = ParamUtil.getString(req, "str_filevanbanphapquytodelete", "");
		if (!"".equals(str_filevanbanphapquytodelete) || str_filevanbanphapquytodelete != null) {
			try {
				deleteFileUpload(str_filevanbanphapquytodelete);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		// end
		VanBanPhapQuy vanBanPhapQuy = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
			vanBanPhapQuy.setMaVanBanPhapQuy(maVanBanPhapQuy);
			vanBanPhapQuy.setKyHieuVanBan(kyHieuVanBan);
			vanBanPhapQuy.setMaLoaiVanBan(maLoaiVanBan);
			vanBanPhapQuy.setMaLinhVucVanBan(maLinhVucVanBan);
			vanBanPhapQuy.setTomTat(tomTat);
			vanBanPhapQuy.setNguon(nguon);
			vanBanPhapQuy.setNoiDung(noiDung);
			vanBanPhapQuy.setMaCoQuanBanHanh(maCoQuanBanHanh);
			vanBanPhapQuy.setNguoiKy(nguoiKy);
			
			vanBanPhapQuy.setNgayKy(ngayKy);
			vanBanPhapQuy.setNgayCoHieuLuc(ngayCoHieuLuc);
			vanBanPhapQuy.setNgayHetHieuLuc(ngayHetHieuLuc);
			vanBanPhapQuy.setNgayBanHanh(ngayBanHanh);
			
			vanBanPhapQuy.setCompanyid(user.getCompanyId());
			vanBanPhapQuy.setUserid(userId);
			vanBanPhapQuy.setModifieddate(date);
			
			if (active) {
				vanBanPhapQuy.setActive(1);
			} else {
				vanBanPhapQuy.setActive(0);
			}
			
			vanBanPhapQuy.setDescription(description);
			
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy(companyId, vanBanPhapQuy);
		} catch (Exception e) {
			_log.error(e);
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
					uploadFile(req, nameFieldRowArr[i], vanBanPhapQuy, titleFilesArr[i]);
				}
			}
			
	}
	
	
	public void editVanBanPhapQuy(ActionRequest req, ActionResponse res) {
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		VanBanPhapQuy vanBanPhapQuy = null;
		List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
//		List<FileDinhKem> fileDinhKemListAll = new ArrayList<FileDinhKem>();
		try {
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
			fileDinhKemList = FileDinhKemLocalServiceUtil.getListFileDinhKemByMaVanBanPhapQuy(maVanBanPhapQuy);
//			fileDinhKemListAll = FileDinhKemLocalServiceUtil.getFileDinhKems(-1, -1);
			
			req.setAttribute("vanBanPhapQuy", vanBanPhapQuy);
			req.setAttribute("fileDinhKemList", fileDinhKemList);
//			req.setAttribute("fileDinhKemListAll", fileDinhKemListAll);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}
	public void deleteVanBanPhapQuy(ActionRequest req) {
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;
		User user = null;
		
		List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			fileDinhKemList = FileDinhKemLocalServiceUtil.getListFileDinhKemByMaVanBanPhapQuy(maVanBanPhapQuy);
		} catch (Exception e) {
			_log.error(e);
		}
		
		try {
			VanBanPhapQuyLocalServiceUtil.deleteVanBanPhapQuy(companyId, maVanBanPhapQuy) ;
			
			for (int i = 0; i < fileDinhKemList.size(); i++) {
				FileDinhKem fileDinhKem = fileDinhKemList.get(i);
				deleteFileOnServer(fileDinhKem);
				FileDinhKemLocalServiceUtil.deleteFileDinhKem(fileDinhKem);
			}
			
			req.setAttribute("delete", true);
		} catch (SearchException e) {
			_log.error(e);
		} catch (NoSuchVanBanPhapQuyException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	
	public void addVanBanPhapQuy(ActionRequest req) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String kyHieuVanBan = ParamUtil.getString(req, "kyHieuVanBan");
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		String tomTat = ParamUtil.getString(req, "tomTat");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		String nguon = ParamUtil.getString(req, "nguon");
		String noiDung = ParamUtil.getString(req, "noiDung");
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy");
		
		Date ngayKy = null;
		String ngayKyString = ParamUtil.getString(req, "ngayKy");
		if (!ngayKyString.equals("")) {
			try {
				ngayKy = sdf.parse(ngayKyString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayCoHieuLuc = null;
		String ngayCoHieuLucString = ParamUtil.getString(req, "ngayCoHieuLuc");
		if (!ngayCoHieuLucString.equals("")) {
			try {
				ngayCoHieuLuc = sdf.parse(ngayCoHieuLucString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayHetHieuLuc = null;
		String ngayHetHieuLucString = ParamUtil.getString(req, "ngayHetHieuLuc");
		if (!ngayHetHieuLucString.equals("")) {
			try {
				ngayHetHieuLuc = sdf.parse(ngayHetHieuLucString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		Date ngayBanHanh = null;
		String ngayBanHanhString = ParamUtil.getString(req, "ngayBanHanh");
		if (!ngayBanHanhString.equals("")) {
			try {
				ngayBanHanh = sdf.parse(ngayBanHanhString);
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		// phan cho file upload
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		// end
		long maVanBanPhapQuy = 0;
		VanBanPhapQuy vanBanPhapQuy = null;
		long userId = PortalUtil.getUserId(req);
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maVanBanPhapQuy = CounterLocalServiceUtil.increment();
		} catch (Exception e) {
			_log.error(e);
		}

		try {
			vanBanPhapQuy = new VanBanPhapQuyImpl();
			vanBanPhapQuy.setMaVanBanPhapQuy(maVanBanPhapQuy);
			vanBanPhapQuy.setKyHieuVanBan(kyHieuVanBan);
			vanBanPhapQuy.setMaLoaiVanBan(maLoaiVanBan);
			vanBanPhapQuy.setMaLinhVucVanBan(maLinhVucVanBan);
			vanBanPhapQuy.setTomTat(tomTat);
			vanBanPhapQuy.setNguon(nguon);
			vanBanPhapQuy.setNoiDung(noiDung);
			vanBanPhapQuy.setMaCoQuanBanHanh(maCoQuanBanHanh);
			vanBanPhapQuy.setNguoiKy(nguoiKy);
			
			vanBanPhapQuy.setNgayKy(ngayKy);
			vanBanPhapQuy.setNgayCoHieuLuc(ngayCoHieuLuc);
			vanBanPhapQuy.setNgayHetHieuLuc(ngayHetHieuLuc);
			vanBanPhapQuy.setNgayBanHanh(ngayBanHanh);
			
			if (null != user) {
				vanBanPhapQuy.setCompanyid(user.getCompanyId());
				vanBanPhapQuy.setUserid(userId);
			}
			
			vanBanPhapQuy.setCreatedate(date);
			
			if (active) {
				vanBanPhapQuy.setActive(1);
			} else {
				vanBanPhapQuy.setActive(0);
			}
			
			vanBanPhapQuy.setDescription(description);
			
			VanBanPhapQuyLocalServiceUtil.addVanBanPhapQuy(user.getCompanyId(), vanBanPhapQuy);
			
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
					uploadFile(req, nameFieldRowArr[i], vanBanPhapQuy, titleFilesArr[i]);
				}
			}
				
		} catch (SearchException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}
	
	/**
	 * This method allows upload many files from client to server 
	 * @param nameRowUpload 
	 * void 
	 *
	 */
	public void uploadFile(ActionRequest req, String nameFieldUpload, VanBanPhapQuy vanBanPhapQuy, String titleFile) {
		try {
			//save file upload into folder upload
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String fileName = getDateTime()+ fileNames;			
			String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
			File destFile = new File(patthFile + "/" + fileName);
			long fileSize = myFile.length()/ 1024;
			if (!(new File(patthFile)).exists()) {
				(new File(patthFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			long maVanBanPhapQuy = 0;
			if (null != vanBanPhapQuy) {
				maVanBanPhapQuy = vanBanPhapQuy.getMaVanBanPhapQuy();
			}
			// set value into FileDinhKem
			FileDinhKem fileDinhKem = new FileDinhKemImpl();
			fileDinhKem.setMaFileDinhKem(CounterLocalServiceUtil.increment());
			fileDinhKem.setMaVanBanPhapQuy(maVanBanPhapQuy);
			fileDinhKem.setKichThuoc(fileSize);
			fileDinhKem.setDuongDan("/upload" + "/" + fileName);
			
			List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
			try {
				fileDinhKemList = FileDinhKemLocalServiceUtil.getListFileDinhKemByMaVanBanPhapQuy(maVanBanPhapQuy);
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
			
			FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteFileUpload(String str_filevanbanphapquytodelete) throws Exception {
		String[] fileUploadId = str_filevanbanphapquytodelete.split("/");
		for (int i = 0; i < fileUploadId.length; i++) {
			if (!"".equals(fileUploadId[i])) {
				long maFileDinhKem = Long.parseLong(fileUploadId[i]);
				FileDinhKem fileDinhKem = null;
				fileDinhKem = FileDinhKemLocalServiceUtil.getFileDinhKem(maFileDinhKem);
				deleteFileOnServer(fileDinhKem);
				FileDinhKemLocalServiceUtil.deleteFileDinhKem(maFileDinhKem);
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
				List<LinhVucVanBan> linhVucVBList = new ArrayList<LinhVucVanBan>();
				List<LoaiVanBan> loaiVBList = new ArrayList<LoaiVanBan>();
				List<CoQuanBanHanh> coQuanBanHanhList = new ArrayList<CoQuanBanHanh>();
				
				coQuanBanHanhList = CoQuanBanHanhLocalServiceUtil.findByActive(1);
				loaiVBList = LoaiVanBanLocalServiceUtil.findByActive(1);
				linhVucVBList = LinhVucVanBanLocalServiceUtil.findByActive(1);
				
				req.setAttribute("linhVucVBList", linhVucVBList);
				req.setAttribute("loaiVBList", loaiVBList);
				req.setAttribute("coQuanBanHanhList", coQuanBanHanhList);
				
				return mapping.findForward("portlet.nss.van_ban_phap_quy.view");
			}
	}
	
	public void deleteFileOnServer(FileDinhKem fileDinhKem) {
		String pathFile = getServlet().getServletContext().getRealPath("")+ fileDinhKem.getDuongDan();
		File file = new File(pathFile);
		if (file.exists()) {
			file.delete();
		}
	}

}
