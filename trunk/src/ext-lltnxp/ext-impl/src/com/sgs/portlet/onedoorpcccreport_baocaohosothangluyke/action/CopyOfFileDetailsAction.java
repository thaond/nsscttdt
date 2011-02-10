package com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class CopyOfFileDetailsAction extends PortletAction {
	
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
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
				
			String columeName = ParamUtil.getString(req, "action", "");
			String departmentId = ParamUtil.getString(req, "departmentId");
			String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
			Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "fromDate"));
			Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "toDate"));
			req.setAttribute("pmlFilePcccList", getPmlFilePcccList(req, columeName, departmentId, fileTypeId, fromDate, toDate));
			
			return mapping.findForward("portlet.sgs.onedoorpcccreport_baocaohosothangluyke.filedetails");
		}
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccList(PortletRequest req, String columeName, String departmentId, String fileTypeId, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		if(Validator.isNull(columeName) == false) {
			
			List<PmlOneDoorReceiveFile> pmlFilePCCCList = DepartmentLocalServiceUtil.getListFileByDepartment_FileType(departmentId, fileTypeId, toDate);
			int pmlFilePCCCSize = pmlFilePCCCList.size();
			
			if (columeName.equals("tenloaihoso")) {
				res = layDanhSachHoSoTheoLoaiHoSo(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("tondauky")) {
				res = layDanhSachHoSoTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("trongthanghosonhan")) {
				res = layDanhSachHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("tongcong")) {
				res = layDanhSachHoSoTongCong(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("trongnamhosonhan")) {
				res = layDanhSachHoSoNhanTrongNam(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("trongthanghosogiaiquyet")) {
				res = layDanhSachHoSoGiaiQuyetTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("trongnamhosogiaiquyet")) {
				res = layDanhSachHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("hosoton")) {
				res = layDanhSachHoSoTon(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			}
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoLoaiHoSo(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTonDauKy(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			
			String pmlFileId = pmlOneDoorReceiveFile.getFileId();
			
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			pmlFilePcccDTO.setFileId(pmlFileId);
			pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
			pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			res.add(pmlFilePcccDTO);
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoNhanTrongThang(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			
			String pmlFileId = pmlOneDoorReceiveFile.getFileId();
			
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			pmlFilePcccDTO.setFileId(pmlFileId);
			pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
			pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			res.add(pmlFilePcccDTO);
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTongCong(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		res.addAll(layDanhSachHoSoTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate));
		res.addAll(layDanhSachHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate));
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoNhanTrongNam(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			
			String pmlFileId = pmlOneDoorReceiveFile.getFileId();
			
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			pmlFilePcccDTO.setFileId(pmlFileId);
			pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
			pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			res.add(pmlFilePcccDTO);
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoGiaiQuyetTrongThang(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			
			String pmlFileId = pmlOneDoorReceiveFile.getFileId();
			
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			pmlFilePcccDTO.setFileId(pmlFileId);
			pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
			pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			res.add(pmlFilePcccDTO);
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoGiaiQuyetTrongNam(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize, toDate);
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			
			String pmlFileId = pmlOneDoorReceiveFile.getFileId();
			
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			pmlFilePcccDTO.setFileId(pmlFileId);
			pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
			pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			res.add(pmlFilePcccDTO);
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTon(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		res.addAll(layDanhSachHoSoTongCong(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate));
		res.removeAll(layDanhSachHoSoGiaiQuyetTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate));
		
		return res;
	}
	
}
