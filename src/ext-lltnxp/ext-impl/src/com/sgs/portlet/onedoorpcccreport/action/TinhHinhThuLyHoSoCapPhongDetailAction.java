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
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class TinhHinhThuLyHoSoCapPhongDetailAction extends PortletAction {
	
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
		long id = ParamUtil.getLong(req, "id");
		
		String action = ParamUtil.getString(req, "action");
		
		if(action.equals("chuyenvien")) {
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListFileForUser(id);
			
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
			System.out.println("tontruoc id" + id);
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForTonTruoc(id, new Date());
			
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
			System.out.println("danhan id " + id);
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForDaNhan(id, new Date());
			
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
			System.out.println("chuanhan");
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForChuaNhan(id, new Date());
			
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
			System.out.println("tonghosocanxuly");
			List<PmlProcessDispose> pmlProcessDisposeTonTruocList = PmlUserLocalServiceUtil.getListFileForUser(id);
			List<PmlProcessDispose> pmlProcessDisposeDaNhanList = PmlUserLocalServiceUtil.getListForDaNhan(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeChuaNhanList = PmlUserLocalServiceUtil.getListForChuaNhan(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			pmlProcessDisposeList.addAll(pmlProcessDisposeTonTruocList);
			pmlProcessDisposeList.addAll(pmlProcessDisposeDaNhanList);
			pmlProcessDisposeList.addAll(pmlProcessDisposeChuaNhanList);
			
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
		} else if(action.equals("tugiaiquyet")) {
			System.out.println("tugiaiquyet");
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForTuGiaiQuyet(id, new Date());
			
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
		} else if(action.equals("nguoikhacthulythay")) {
			System.out.println("nguoikhacthulythay");
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForNguoiKhacThuLyThay(id, new Date());
			
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
		} else if(action.equals("tonghosogiaiquyet")) {
			System.out.println("tonghosogiaiquyet");
			List<PmlProcessDispose> pmlProcessDisposeTuGiaiQuyetList = PmlUserLocalServiceUtil.getListForTuGiaiQuyet(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeNguoiKhacThuLyThayList = PmlUserLocalServiceUtil.getListForNguoiKhacThuLyThay(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			pmlProcessDisposeList.addAll(pmlProcessDisposeTuGiaiQuyetList);
			pmlProcessDisposeList.addAll(pmlProcessDisposeNguoiKhacThuLyThayList);
			
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
			System.out.println("tronghaniso");
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForTrongHanISO(id, new Date());
			
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
			System.out.println("quahaniso");
			List<PmlProcessDispose> pmlProcessDisposeList = PmlUserLocalServiceUtil.getListForQuaHanISO(id, new Date());
			
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
			System.out.println("tonghosotondong");
			List<PmlProcessDispose> pmlProcessDisposeTrongHanISOList = PmlUserLocalServiceUtil.getListForTrongHanISO(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeQuaHanISOList = PmlUserLocalServiceUtil.getListForQuaHanISO(id, new Date());
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			pmlProcessDisposeList.addAll(pmlProcessDisposeTrongHanISOList);
			pmlProcessDisposeList.addAll(pmlProcessDisposeQuaHanISOList);
			
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
