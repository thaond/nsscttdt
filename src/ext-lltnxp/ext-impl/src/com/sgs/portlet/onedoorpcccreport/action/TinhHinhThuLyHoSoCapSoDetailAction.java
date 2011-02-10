package com.sgs.portlet.onedoorpcccreport.action;

import java.util.ArrayList;
import java.util.Date;
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
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class TinhHinhThuLyHoSoCapSoDetailAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		List<PmlFilePcccDTO> pmlFilePcccList = new ArrayList<PmlFilePcccDTO>();
		String id = ParamUtil.getString(req, "id");
		String action = ParamUtil.getString(req, "action");
		
		if(action.equals("phongban")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListFileForUser(pmlUser.getUserId()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("tontruoc")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListForTonTruoc(pmlUser.getUserId(), new Date()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("danhan")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListForDaNhan(pmlUser.getUserId(), new Date()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("chuanhan")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListForChuaNhan(pmlUser.getUserId(), new Date()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("tonghosocanxuly")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				List<PmlProcessDispose> pmlProcessDisposeTonTruocList = PmlUserLocalServiceUtil.getListFileForUser(pmlUser.getUserId());
				List<PmlProcessDispose> pmlProcessDisposeDaNhanList = PmlUserLocalServiceUtil.getListForDaNhan(pmlUser.getUserId(), new Date());
				List<PmlProcessDispose> pmlProcessDisposeChuaNhanList = PmlUserLocalServiceUtil.getListForChuaNhan(pmlUser.getUserId(), new Date());
				pmlProcessDisposeList.addAll(pmlProcessDisposeTonTruocList);
				pmlProcessDisposeList.addAll(pmlProcessDisposeDaNhanList);
				pmlProcessDisposeList.addAll(pmlProcessDisposeChuaNhanList);
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("hosogiaiquyet")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				List<PmlProcessDispose> pmlProcessDisposeTuGiaiQuyetList = PmlUserLocalServiceUtil.getListForTuGiaiQuyet(pmlUser.getUserId(), new Date());
				List<PmlProcessDispose> pmlProcessDisposeNguoiKhacThuLyThayList = PmlUserLocalServiceUtil.getListForNguoiKhacThuLyThay(pmlUser.getUserId(), new Date());
				pmlProcessDisposeList.addAll(pmlProcessDisposeTuGiaiQuyetList);
				pmlProcessDisposeList.addAll(pmlProcessDisposeNguoiKhacThuLyThayList);
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("tronghaniso")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListForTrongHanISO(pmlUser.getUserId(), new Date()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("quahaniso")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlProcessDisposeList.addAll(PmlUserLocalServiceUtil.getListForQuaHanISO(pmlUser.getUserId(), new Date()));
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		} else if(action.equals("tonghosotondong")) {
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(id);
			
			for (PmlUser pmlUser : pmlUserList) {
				List<PmlProcessDispose> pmlProcessDisposeTrongHanISOList = PmlUserLocalServiceUtil.getListForTrongHanISO(pmlUser.getUserId(), new Date());
				List<PmlProcessDispose> pmlProcessDisposeQuaHanISOList = PmlUserLocalServiceUtil.getListForQuaHanISO(pmlUser.getUserId(), new Date());
				pmlProcessDisposeList.addAll(pmlProcessDisposeTrongHanISOList);
				pmlProcessDisposeList.addAll(pmlProcessDisposeQuaHanISOList);
			}
			
			for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlFilePcccDTO dto = new PmlFilePcccDTO();
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
				dto.setFileId(file.getFileId());
				dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
				dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
				dto.setApplicationDate(file.getApplicationDate());
				dto.setExpectedReturingDate(file.getExpectedReturningDate());
				pmlFilePcccList.add(dto);
			}
		}
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
				
			req.setAttribute("pmlFilePcccList", pmlFilePcccList);
				
			return mapping.findForward("portlet.sgs.onedoorpcccreport.filedetails");
		}
	}
}