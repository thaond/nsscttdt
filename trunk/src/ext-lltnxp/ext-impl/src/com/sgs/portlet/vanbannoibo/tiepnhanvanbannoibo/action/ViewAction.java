package com.sgs.portlet.vanbannoibo.tiepnhanvanbannoibo.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoImpl;
import com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.vanbannoibo.workflow.VanBanNoiBoPortletAction;

public class ViewAction extends VanBanNoiBoPortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/vanbannoibo/tiepnhanvanbannoibo");
		String cmd = ParamUtil.getString(req, Constants.CMD);
//		String soVaoSo = ParamUtil.getString(req, "soVaoSo");
		long vanBanNoiBoId = ParamUtil.getLong(req, "vanBanNoiBoId");
		System.out.println("vanBanNoiBoId "+vanBanNoiBoId);
		List<VanBanNoiBo> vanBanNoiBos = VanBanNoiBoLocalServiceUtil.getVanBanNoiBos(-1, -1);
		boolean checkSoVaoSo = false;
//		for(VanBanNoiBo vbnb : vanBanNoiBos){
//			if(soVaoSo.equals(vbnb.getSoVanBanNoiBo())){
//				checkSoVaoSo = true;
//			}
//		}
		for(VanBanNoiBo vbnb : vanBanNoiBos){
			if(vanBanNoiBoId == vbnb.getVanBanNoiBoId()){
				checkSoVaoSo = true;
			}
		}
		if(cmd.equals(Constants.ADD)){
			if(!checkSoVaoSo){
				addVanBanNoiBo(req, res, redirect);
			}else{
				updateVanBanNoiBo(req, res, redirect);
			}
		}else if(cmd.equals("DELETEFILEATTACT")){
			deleteFileAttact(req, res, redirect);
		}else if(cmd.equals("SELECTSOVANBANNOIBO")){
			selectSoVanBanNoiBo(req);
		}
	}
	
	public  void selectSoVanBanNoiBo(ActionRequest req) {
		try{
			long soVanBanId = ParamUtil.getLong(req, "soVanBan");
			String selectSoVanBanNoiBo = ParamUtil.getString(req, "selectSoVanBanNoiBo");
			req.setAttribute("soVanBanId", soVanBanId);
			long vanBanNoiBoId = ParamUtil.getLong(req, "vanBanNoiBoId");
			VanBanNoiBo vanBanNoiBo = null;
			if(vanBanNoiBoId != 0){
				vanBanNoiBo = VanBanNoiBoLocalServiceUtil.getVanBanNoiBo(vanBanNoiBoId);
			}
			if(!selectSoVanBanNoiBo.equals("")){
				req.setAttribute("vanBanNoiBo", vanBanNoiBo);
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD selectSoVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void deleteFileAttact(ActionRequest req, ActionResponse res, String redirect) {
		long fileDinhKemVanBanNoiBoId = ParamUtil.getLong(req, "fileDinhKemVanBanNoiBoId");
		try {
			FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo = FileDinhKemVanBanNoiBoLocalServiceUtil.getFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBoId);
			//xoa trong csdl
			FileDinhKemVanBanNoiBoLocalServiceUtil.deleteFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBo);
			//xoa tren server
			String pathAttactFile = fileDinhKemVanBanNoiBo.getDuongDanFile();
			String pathFile = getServlet().getServletContext().getRealPath("/");
			String pathServer = pathFile + pathAttactFile;
			File file = new File(pathServer);
			file.delete();
			String deleteFile = ParamUtil.getString(req, "deleteFile");
			long vanBanNoiBoId = ParamUtil.getLong(req, "vanBanNoiBoId");
			long soVanBanId = ParamUtil.getLong(req, "soVanBan");
			System.out.println("soVanBanId ------------------------ "+soVanBanId);
			VanBanNoiBo vanBanNoiBo = VanBanNoiBoLocalServiceUtil.getVanBanNoiBo(vanBanNoiBoId);
			if(!deleteFile.equals("")){
				req.setAttribute("vanBanNoiBo", vanBanNoiBo);
				req.setAttribute("soVanBanId", soVanBanId);
			}
			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteFileAttact OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void addVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) {
		try {
			String soVaoSo = ParamUtil.getString(req, "soVaoSo");
			long nguoiKy = ParamUtil.getLong(req, "nguoiKy");
			long loaiVanBan = ParamUtil.getLong(req, "loaiVanBan");
			long soVanBan = ParamUtil.getLong(req, "soVanBan");
			String ngayKy = ParamUtil.getString(req, "ngayKy");
			String trichYeu = ParamUtil.getString(req, "trichYeu");
			String ghiChu = ParamUtil.getString(req, "ghiChu");
			
			long vanBanNoiBoId = CounterLocalServiceUtil.increment();
			VanBanNoiBo vanBanNoiBo = VanBanNoiBoLocalServiceUtil.createVanBanNoiBo(vanBanNoiBoId);
			
			long userId = PortalUtil.getUserId(req);
			User user = UserLocalServiceUtil.getUser(userId);
			long companyId = user.getCompanyId();
			long groupId = user.getGroup().getGroupId();
			vanBanNoiBo.setUserId(userId);
			vanBanNoiBo.setGroupId(groupId);
			vanBanNoiBo.setCompanyId(companyId);
			
			vanBanNoiBo.setSoVaoSoVanBanNoiBo(soVaoSo);
			vanBanNoiBo.setNguoiKy(nguoiKy);
			vanBanNoiBo.setUserId(userId);
			vanBanNoiBo.setLoaiVanBanNoiBo(loaiVanBan);
			vanBanNoiBo.setSoVanBanNoiBo(soVanBan);
			vanBanNoiBo.setTrichYeu(trichYeu);
			vanBanNoiBo.setGhiChu(ghiChu);
			
			Date date = new Date();
			Timestamp dateNow = new Timestamp(date.getTime());
			vanBanNoiBo.setNgayTao(dateNow);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateCreate = simpleDateFormat.parse(ngayKy);
			Timestamp ngayKyDate = new Timestamp(dateCreate.getTime());
			vanBanNoiBo.setNgayKy(ngayKyDate);
			vanBanNoiBo.setSoPhatSinhTheoNam(dateNow.getYear() + 1900);
			
			String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
			nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
			String titleFiles  = ParamUtil.getString(req, "titleFiles");
			titleFiles = StringUtil.encodeHtml(titleFiles);
			
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				String vanBanNoiBoTitles = "";
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					vanBanNoiBoTitles += titleFilesArr[i];
					uploadFile(req, vanBanNoiBoId, userId, dateNow, nameFieldRowArr[i], titleFilesArr[i]);
				}
			}
			VanBanNoiBoLocalServiceUtil.addVanBanNoiBo(vanBanNoiBo);
			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
			addWorkflowParameter(req, "vanBanNoiBoId", WorkflowParam.TRANSIENT, "" + vanBanNoiBo.getVanBanNoiBoId());
			
			String luu = ParamUtil.getString(req, "luu");
			if(!luu.equals("")){
				req.setAttribute("vanBanNoiBo", vanBanNoiBo);
				long soVanBanId = ParamUtil.getLong(req, "soVanBan");
				req.setAttribute("soVanBanId", soVanBanId);
			}
			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addvanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void updateVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) {
		try {
			String soVaoSo = ParamUtil.getString(req, "soVaoSo");
			long nguoiKy = ParamUtil.getLong(req, "nguoiKy");
			long loaiVanBan = ParamUtil.getLong(req, "loaiVanBan");
			long soVanBan = ParamUtil.getLong(req, "soVanBan");
			String ngayKy = ParamUtil.getString(req, "ngayKy");
			String trichYeu = ParamUtil.getString(req, "trichYeu");
			String ghiChu = ParamUtil.getString(req, "ghiChu");
			
			long vanBanNoiBoId = ParamUtil.getLong(req, "vanBanNoiBoId");
			VanBanNoiBo vanBanNoiBo = VanBanNoiBoLocalServiceUtil.getVanBanNoiBo(vanBanNoiBoId);
			
			long userId = vanBanNoiBo.getUserId();
			vanBanNoiBo.setSoVaoSoVanBanNoiBo(soVaoSo);
			vanBanNoiBo.setNguoiKy(nguoiKy);
			
			vanBanNoiBo.setLoaiVanBanNoiBo(loaiVanBan);
			vanBanNoiBo.setSoVanBanNoiBo(soVanBan);
			vanBanNoiBo.setTrichYeu(trichYeu);
			vanBanNoiBo.setGhiChu(ghiChu);
			
			Date date = new Date();
			Timestamp dateNow = new Timestamp(date.getTime());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateCreate = simpleDateFormat.parse(ngayKy);
			Timestamp ngayKyDate = new Timestamp(dateCreate.getTime());
			vanBanNoiBo.setNgayKy(ngayKyDate);
			
			String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
			nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
			String titleFiles  = ParamUtil.getString(req, "titleFiles");
			titleFiles = StringUtil.encodeHtml(titleFiles);
			
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				String vanBanNoiBoTitles = "";
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					vanBanNoiBoTitles += titleFilesArr[i];
					uploadFile(req, vanBanNoiBoId, userId, dateNow, nameFieldRowArr[i], titleFilesArr[i]);
				}
			}
			VanBanNoiBoLocalServiceUtil.updateVanBanNoiBo(vanBanNoiBo);
//			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
//			addWorkflowParameter(req, "vanBanNoiBoId", WorkflowParam.TRANSIENT, "" + vanBanNoiBo.getVanBanNoiBoId());
			
			String luu = ParamUtil.getString(req, "luu");
			if(!luu.equals("")){
				req.setAttribute("vanBanNoiBo", vanBanNoiBo);
				long soVanBanId = ParamUtil.getLong(req, "soVanBan");
				req.setAttribute("soVanBanId", soVanBanId);
			}
			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updatevanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void uploadFile(ActionRequest req, long vanBanNoiBoId, long userId, Timestamp ngayTao, String nameFieldUpload, String titleFile) throws SystemException, IOException, PortalException {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String dateValue = com.sgs.portlet.vanbannoibo.util.Constants.getDateTime();
			String fileName = dateValue + fileNames;		
			fileName= fileName.replace(" ", "");
			String pathFile = getServlet().getServletContext().getRealPath("/") + "upload";
			File destFile = new File(pathFile + "/" + fileName);
			if (!(new File(pathFile)).exists()) {
				(new File(pathFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo = new FileDinhKemVanBanNoiBoImpl();
			long fileDinhKemVanBanNoiBoId = CounterLocalServiceUtil.increment();
			fileDinhKemVanBanNoiBo.setFileDinhKemVanBanNoiBoId(fileDinhKemVanBanNoiBoId);
			
			fileDinhKemVanBanNoiBo.setUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			long companyId = user.getCompanyId();
			fileDinhKemVanBanNoiBo.setCompanyId(companyId);
			long groupId = user.getGroup().getGroupId();
			fileDinhKemVanBanNoiBo.setGroupId(groupId);
			
			String userName = user.getScreenName();
			fileDinhKemVanBanNoiBo.setDuongDanFile("/upload" + "/" + fileName);
			String fullTitle = titleFile + "_" + userName + "_" + dateValue;
			fileDinhKemVanBanNoiBo.setTenFile(fileNames);
			fileDinhKemVanBanNoiBo.setTenFileFull(fullTitle);
			fileDinhKemVanBanNoiBo.setTieuDe(titleFile);
			fileDinhKemVanBanNoiBo.setNgayTao(ngayTao);
			String loaiFile = fileNames.substring(fileNames.lastIndexOf("."), fileNames.length());
			fileDinhKemVanBanNoiBo.setLoaiFile(loaiFile);
			fileDinhKemVanBanNoiBo.setMucDichFile("0");
			fileDinhKemVanBanNoiBo.setVanBanNoiBoId(vanBanNoiBoId);
			
			FileDinhKemVanBanNoiBoLocalServiceUtil.addFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBo);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD uploadFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			long userId = PortalUtil.getUserId(req);
			req.setAttribute("userId", userId);
			return mapping.findForward("portlet.sgs.vanbannoibo.tiepnhanvanbannoibo");
		}	
	}
}


