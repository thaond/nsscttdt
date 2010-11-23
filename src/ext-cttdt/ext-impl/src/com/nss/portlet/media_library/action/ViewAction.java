package com.nss.portlet.media_library.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.model.impl.MediaLibraryImpl;
import com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil;
import com.nss.portlet.media_library.util.MediaLibraryDAO;

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
		
		if (Validator.isNotNull(cmd)) {
			if (Constants.ADD.equals(cmd)) {
				addMediaLibrary(req);
			}
			else if (Constants.LOCK.equals(cmd)) {
				updateActiveMediaLibrary(req);
			}
			else if (Constants.UPDATE.equals(cmd)) {
				updateMediaLibrary(req);
			}
			else if (Constants.DELETE.equals(cmd)) {
				deleteMediaLibrary(req);
			}
		}
	}
	
	public void deleteMediaLibrary(ActionRequest req) {
		long maMediaLibrary = ParamUtil.getLong(req, "maMediaLibrary");
		MediaLibrary mediaLibrary = null;
		try {
			mediaLibrary = MediaLibraryLocalServiceUtil.getMediaLibrary(maMediaLibrary);
			deleteFileOnServer(mediaLibrary);
			MediaLibraryLocalServiceUtil.deleteMediaLibrary(maMediaLibrary);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public void updateMediaLibrary(ActionRequest req) {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		long maMediaLibrary = ParamUtil.getLong(req, "maMediaLibrary");
		String tieuDe = ParamUtil.getString(req, "tieuDe");
		boolean active = ParamUtil.getBoolean(req, "active");
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileupload = uploadRequest.getFile("file");
		MediaLibraryDAO dao = null;
		long userId = PortalUtil.getUserId(req);
		MediaLibrary mediaLibrary = null;
		Date date = new Date();
		try {
			mediaLibrary = MediaLibraryLocalServiceUtil.getMediaLibrary(maMediaLibrary);
			if (fileupload.exists()) {
				deleteFileOnServer(mediaLibrary);
				dao = uploadFile(req, fileupload, maMediaChuDe);
				mediaLibrary.setTenMediaLibrary(dao.getTenFile());
				mediaLibrary.setDuongDan(dao.getPath());
				mediaLibrary.setKichThuoc(dao.getKichThuocFile());
			}
			mediaLibrary.setMaMediaChuDe(maMediaChuDe);
			mediaLibrary.setTieuDeMediaLibrary(tieuDe);
			mediaLibrary.setModifieddate(date);
			mediaLibrary.setUserId(userId);
			mediaLibrary.setActive(active);
			mediaLibrary = MediaLibraryLocalServiceUtil.updateMediaLibrary(mediaLibrary, false);
		} catch (Exception e1) {
			_log.error(e1.getMessage());
		}
	}
	
	public void updateActiveMediaLibrary(ActionRequest req) {
		long maMediaLibrary = ParamUtil.getLong(req, "maMediaLibrary");
		MediaLibrary mediaLibrary = null;
		try {
			mediaLibrary = MediaLibraryLocalServiceUtil.getMediaLibrary(maMediaLibrary);
			if (mediaLibrary.getActive()) {
				mediaLibrary.setActive(false);
			} else {
				mediaLibrary.setActive(true);
			}
			mediaLibrary = MediaLibraryLocalServiceUtil.updateMediaLibrary(mediaLibrary);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public void addMediaLibrary(ActionRequest req) {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		String tieuDe = ParamUtil.getString(req, "tieuDe");
		boolean active = ParamUtil.getBoolean(req, "active");
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileupload = uploadRequest.getFile("file");
		MediaLibraryDAO dao = uploadFile(req, fileupload, maMediaChuDe);
		// end
		long maMediaLibrary = 0;
		long userId = PortalUtil.getUserId(req);
		MediaLibrary mediaLibrary = null;
		Date date = new Date();
		try {
			maMediaLibrary = CounterLocalServiceUtil.increment();
			mediaLibrary = new MediaLibraryImpl();
			mediaLibrary.setMaMediaLibrary(maMediaLibrary);
			mediaLibrary.setMaMediaChuDe(maMediaChuDe);
			mediaLibrary.setTieuDeMediaLibrary(tieuDe);
			mediaLibrary.setTenMediaLibrary(dao.getTenFile());
			mediaLibrary.setDuongDan(dao.getPath());
			mediaLibrary.setKichThuoc(dao.getKichThuocFile());
			mediaLibrary.setCreatedate(date);
			mediaLibrary.setUserId(userId);
			mediaLibrary.setActive(active);
			mediaLibrary = MediaLibraryLocalServiceUtil.updateMediaLibrary(mediaLibrary, false);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD);
				
			if (Validator.isNotNull(cmd)) {
				if (Constants.EDIT.equals(cmd)) {
					editMediaLibrary(req);
				}
			}
			List<MediaChuDe> mediaChuDeList = new ArrayList<MediaChuDe>();
			mediaChuDeList = MediaChuDeLocalServiceUtil.findByActive(true);
			
			req.setAttribute("mediaChuDeList", mediaChuDeList);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.media_library.view");
			}
	}
	
	public void editMediaLibrary(RenderRequest req) {
		long maMediaLibrary = ParamUtil.getLong(req, "maMediaLibrary");
		MediaLibrary mediaLibrary = null;
		try {
			mediaLibrary = MediaLibraryLocalServiceUtil.getMediaLibrary(maMediaLibrary);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("mediaLibrary", mediaLibrary);
	}
	
	public MediaLibraryDAO uploadFile(ActionRequest req, File file, long maMediaChuDe) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		String tenFile = ParamUtil.getString(req, "fileName");
		String fileName = StringUtil.getDateTime() + tenFile;
		String tenMediaChuDe = "";
		String duongDan = "";
		MediaChuDe mediaChuDe = null;
		try {
			mediaChuDe = MediaChuDeLocalServiceUtil.getMediaChuDe(maMediaChuDe);
			tenMediaChuDe = mediaChuDe.getTenMediaChuDe();
		} catch (Exception e) {
			tenMediaChuDe = "";
		}
		String localPath = "upload/medialibrary/" + year + "/" + tenMediaChuDe;
		String patthFile = getServlet().getServletContext().getRealPath("/") + localPath;
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
		
		duongDan = "/" + localPath + "/" + fileName;
		
		MediaLibraryDAO dao = new MediaLibraryDAO();
		dao.setTenFile(tenFile);
		dao.setKichThuocFile(fileSize);
		dao.setPath(duongDan);
		
		return dao;
	}
	
	public void deleteFileOnServer(MediaLibrary mediaLibrary) {
		String pathFile = getServlet().getServletContext().getRealPath("")+ mediaLibrary.getDuongDan();
		File file = new File(pathFile);
		if (file.exists()) {
			file.delete();
		}
	}

}
