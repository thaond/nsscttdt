package com.sgs.portlet.onedoorpcccreport.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class BaoCaoHoSoThangLuyKeDetailsAction extends PortletAction {
	
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
		
		Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2009");
		Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2009");
		
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
		String action = ParamUtil.getString(req, "action");
		
		// tinh toan cho fileType trong mot departmetn cu the
		if (action.equals("tenloaihoso")) {
			//System.out.println("tenloaihoso");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// Lay danh sach ho so thuoc pmlFileTypeId & pmlDepartmentId
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
					
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} 
		} else if (action.equals("tondauky")) {
			//System.out.println("tondauky");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
				
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("trongthanghosonhan")) {
			//System.out.println("trongthanghosonhan");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
				
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("tongcong")) {
			//System.out.println("tongcong");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				
				// lay tong cong tondauky va hosonhantrongthang
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
				pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
				
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// lay tong cong tondauky va hosonhantrongthang
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// lay tong cong tondauky va hosonhantrongthang
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("trongnamhosonhan")) {
			//System.out.println("trongnamhosonhan");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				
				// Lay nam bao cao tu toDate
				Calendar cal = Calendar.getInstance();
				cal.setTime(toDate);
				int year = cal.YEAR;
				
				// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
				Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
				
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
				
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// Lay nam bao cao tu toDate
					Calendar cal = Calendar.getInstance();
					cal.setTime(toDate);
					int year = cal.YEAR;
					
					// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
					Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
					
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// Lay nam bao cao tu toDate
					Calendar cal = Calendar.getInstance();
					cal.setTime(toDate);
					int year = cal.YEAR;
					
					// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
					Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
					
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("trongthanghosogiaiquyet")) {
			//System.out.println("trongthanghosogiaiquyet");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("trongnamhosogiaiquyet")) {
			//System.out.println("trongnamhosogiaiquyet");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(toDate);
				int year = cal.YEAR; // Lay nam bao cao tu toDate
				
				// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
				Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
				
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(toDate);
					int year = cal.YEAR; // Lay nam bao cao tu toDate
					
					// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
					Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
					
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(toDate);
					int year = cal.YEAR; // Lay nam bao cao tu toDate
					
					// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
					Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
					
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, startDateOfYear, toDate);
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		} else if (action.equals("hosoton")) {
			//System.out.println("hosoton");
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, fileTypeId);
				int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
				
				// lay tong cong tondauky va hosonhantrongthang
				pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
				pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
				pmlOneDoorReceiveFileList.removeAll(pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
				
				for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
					PmlFilePcccDTO dto = new PmlFilePcccDTO();
					PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
					dto.setFileId(file.getFileId());
					dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
					dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
					dto.setApplicationDate(file.getApplicationDate());
					dto.setExpectedReturingDate(file.getExpectedReturningDate());
					pmlFilePcccList.add(dto);
				}
			} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				// lay ra danh sach filetype cua phong ban
				List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				for (PmlField pmlField : pmlFieldList) {
					pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// lay tong cong tondauky va hosonhantrongthang
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					pmlOneDoorReceiveFileList.removeAll(pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				// lay ra danh sach tat ca cac phong ban
				List<Department> pmlDepartmentList = DepartmentUtil.findAll();
				List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
				
				for (Department pmlDepartment : pmlDepartmentList) {
					List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
					for (PmlField pmlField : pmlFieldList) {
						pmlFileTypeList.addAll(PmlFileTypeUtil.findByFieldId(pmlField.getFieldId()));
					}
				}
				
				for (PmlFileType pmlFileType : pmlFileTypeList) {

					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(departmentId, pmlFileType.getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					
					// lay tong cong tondauky va hosonhantrongthang
					pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileTonDauKyThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate);
					pmlOneDoorReceiveFileList.addAll(PmlUserLocalServiceUtil.getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					pmlOneDoorReceiveFileList.removeAll(pmlOneDoorReceiveFileList = PmlUserLocalServiceUtil.getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlOneDoorReceiveFileList, pmlOneDoorReceiveFileSize, fromDate, toDate));
					
					for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
						PmlFilePcccDTO dto = new PmlFilePcccDTO();
						PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlOneDoorReceiveFile.getFileId());
						dto.setFileId(file.getFileId());
						dto.setFileName(PmlFilePCCCUtil.findByPrimaryKey(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						pmlFilePcccList.add(dto);
					}
				}
			}
		}
		
		req.setAttribute("pmlFilePcccList", pmlFilePcccList);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
				
			return mapping.findForward("portlet.sgs.onedoorpcccreport.filedetails");
		}
	}
}
