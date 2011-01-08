package com.sgs.portlet.onedoorpcccreport.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO;
import com.sgs.portlet.onedoorpcccreport.dto.LoaiHoSoDTO;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class BaoCaoHoSoThangLuyKeAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		String cmd = ParamUtil.getString(req, "cmd");
		if(Validator.isNull(cmd) == false) {
			if(cmd.equals("report")) {
				Date fromDate = new Date();
				Date toDate = new Date();
				if(ParamUtil.getString(req, "fromDate") != "" && ParamUtil.getString(req, "toDate") != "") {
					fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "fromDate"));
					toDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "toDate"));
				}
				xuatFileBaoCaoHoSoThangLuyKe(req, res, fromDate, toDate);
			}
		}
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				String month = ParamUtil.getString(req, "month");
				String fromDate = ParamUtil.getString(req, "fromDate");
				String toDate = ParamUtil.getString(req, "toDate");
				if(Validator.isNull(fromDate) == true && Validator.isNull(toDate) == true) {
					toDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
					String[] arrToDate = toDate.split("/");
					fromDate = "01/" + arrToDate[1] + "/" + arrToDate[2];
				}
				req.setAttribute("month", month);
				req.setAttribute("fromDate", fromDate);
				req.setAttribute("toDate", toDate);
				
				List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = getBaoCaoHoSoThangLuyKe(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate), new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
				BaoCaoHoSoThangLuyKeDTO totalDTO = baoCaoHoSoThangLuyKeList.get(baoCaoHoSoThangLuyKeList.size() - 1);
				baoCaoHoSoThangLuyKeList.remove(baoCaoHoSoThangLuyKeList.size() - 1);
				req.setAttribute("totalDTO", totalDTO);
				req.setAttribute("baoCaoHoSoThangLuyKeList", baoCaoHoSoThangLuyKeList);
								
				return mapping.findForward("portlet.sgs.onedoorpcccreport.baocaohosothangluyke");
			}
	}

	/**
	 * Lay bao cao ho so thang luy ke
	 * 
	 * @param fromDate: tu ngay
	 * @param toDate: 	den ngay
	 * @return
	 * @throws Exception
	 */
	public List<BaoCaoHoSoThangLuyKeDTO> getBaoCaoHoSoThangLuyKe(Date fromDate, Date toDate) throws Exception {
		
		/*List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		
		// Lay ra danh sach Phong co trong he thong
		List<PmlDepartment> pmlDepartmentList = PmlDepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// Lay ra tung Phong de xu ly
			PmlDepartment pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			String tenPhongBan = pmlDepartment.getDepartmentsName();
			String ghiChuPhong = pmlDepartment.getDescription();

			BaoCaoHoSoThangLuyKeDTO baoCaoHoSoThangLuyKeDTO = new BaoCaoHoSoThangLuyKeDTO(); 
			baoCaoHoSoThangLuyKeDTO.setDepartmentId(pmlDepartmentId);
			baoCaoHoSoThangLuyKeDTO.setTenPhongBan(tenPhongBan);
			baoCaoHoSoThangLuyKeDTO.setGhiChu(ghiChuPhong);
			
			// Lay danh sach loai ho so cua tung Phong
			List<PmlFileType> pmlFileTypeList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileTypeByDepartmentId(pmlDepartmentId);
			int pmlFileTypeSize = pmlFileTypeList.size();
			List<LoaiHoSoDTO> loaiHoSoList = new ArrayList<LoaiHoSoDTO>();
			for(int i = 0; i < pmlFileTypeSize; i ++) {
				
				// Lay ra tung FileType xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(i);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				
				// Lay danh sach ho so thuoc pmlFileTypeId & pmlDepartmentId
				List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(pmlDepartmentId, pmlFileTypeId);
				int pmlFilePCCCSize = pmlFilePCCCList.size();
				
				//
				String fileTypeId = pmlFileType.getFileTypeId();
				String tenLoaiHoSo = pmlFileType.getFileTypeName();
				int tonDauKy = getTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int tongCong = tonDauKy + trongThangHoSoNhan;
				int trongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize, toDate);
				int hoSoTon = tongCong - trongThangHoSoGiaiQuyet;
				String ghiChuLoaiHoSo = "";
				
				// set vao DTO
				LoaiHoSoDTO loaiHoSoDTO = new LoaiHoSoDTO();
				loaiHoSoDTO.setFileTypeId(fileTypeId);
				loaiHoSoDTO.setTenLoaiHoSo(tenLoaiHoSo);
				loaiHoSoDTO.setTonDauKy(tonDauKy);
				loaiHoSoDTO.setTrongThangHoSoNhan(trongThangHoSoNhan);
				loaiHoSoDTO.setTongCong(tongCong);
				loaiHoSoDTO.setTrongNamHoSoNhan(trongNamHoSoNhan);
				loaiHoSoDTO.setTrongThangHoSoGiaiQuyet(trongThangHoSoGiaiQuyet);
				loaiHoSoDTO.setTrongNamHoSoGiaiQuyet(trongNamHoSoGiaiQuyet);
				loaiHoSoDTO.setHoSoTon(hoSoTon);
				loaiHoSoDTO.setGhiChu(ghiChuLoaiHoSo);
				
				if ((tongCong > 0) || (trongNamHoSoNhan > 0) || (trongThangHoSoGiaiQuyet > 0) || (trongNamHoSoGiaiQuyet > 0) || (hoSoTon > 0)) {
					loaiHoSoDTO.setHasFile(true);
				}
				
				// add vao loaiHoSoList
				loaiHoSoList.add(loaiHoSoDTO);
			}			
			baoCaoHoSoThangLuyKeDTO.setLoaiHoSoList(loaiHoSoList);
			
			if (loaiHoSoList.size() != 0) {
				baoCaoHoSoThangLuyKeList.add(baoCaoHoSoThangLuyKeDTO);
			}
		}
		return baoCaoHoSoThangLuyKeList;*/
		
		List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		
		// set cac truong cho tong so
		//String totalDienGiai = "         \ufeffT\u1ed5ng s\u1ed1";
		int totalTonDauKy = 0;
		int totalTrongThangHoSoNhan = 0;
		int totalTongCong = 0;
		int totalTrongNamHoSoNhan = 0;
		int totalTrongThangHoSoGiaiQuyet = 0;
		int totalTrongNamHoSoGiaiQuyet = 0;
		int totalHoSoTon = 0;
		//String totalGhiChu = "";
		
		// Lay ra danh sach Phong co trong he thong
		List<Department> pmlDepartmentList = DepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		//System.out.println("============================" + pmlDepartmentList.size());
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// set cac truong cho phong ban
			String tenPhongBan = "";
			int phongBanTonDauKy = 0;
			int phongBanTrongThangHoSoNhan = 0;
			int phongBanTongCong = 0;
			int phongBanTrongNamHoSoNhan = 0;
			int phongBanTrongThangHoSoGiaiQuyet = 0;
			int phongBanTrongNamHoSoGiaiQuyet = 0;
			int phongBanHoSoTon = 0;
			String ghiChuPhong = "";
			
			// Lay ra tung Phong de xu ly
			Department pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			tenPhongBan = pmlDepartment.getDepartmentsName();
			ghiChuPhong = pmlDepartment.getDescription();

			// Lay danh sach loai ho so cua tung Phong
			List<PmlFileType> pmlFileTypeList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileTypeByDepartmentId(pmlDepartmentId);
			//System.out.println("============================" + pmlFileTypeList);
			int pmlFileTypeSize = pmlFileTypeList.size();
			List<LoaiHoSoDTO> loaiHoSoList = new ArrayList<LoaiHoSoDTO>();
			for(int i = 0; i < pmlFileTypeSize; i ++) {
				
				// Lay ra tung FileType xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(i);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				
				// Lay danh sach ho so thuoc pmlFileTypeId & pmlDepartmentId
				List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(pmlDepartmentId, pmlFileTypeId);
				//System.out.println("===========================" + pmlDepartmentId);
				//System.out.println("===========================" + pmlFilePCCCList);
				int pmlFilePCCCSize = pmlFilePCCCList.size();
				
				//
				String tenLoaiHoSo = pmlFileType.getFileTypeName();
				int tonDauKy = getTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int tongCong = tonDauKy + trongThangHoSoNhan;
				int trongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize, toDate);
				int hoSoTon = tongCong - trongThangHoSoGiaiQuyet;
				String ghiChuLoaiHoSo = "";
				
				// set vao DTO
				LoaiHoSoDTO loaiHoSoDTO = new LoaiHoSoDTO();
				loaiHoSoDTO.setFileTypeId(pmlFileTypeId);
				loaiHoSoDTO.setTenLoaiHoSo(tenLoaiHoSo);
				loaiHoSoDTO.setTonDauKy(tonDauKy);
				loaiHoSoDTO.setTrongThangHoSoNhan(trongThangHoSoNhan);
				loaiHoSoDTO.setTongCong(tongCong);
				loaiHoSoDTO.setTrongNamHoSoNhan(trongNamHoSoNhan);
				loaiHoSoDTO.setTrongThangHoSoGiaiQuyet(trongThangHoSoGiaiQuyet);
				loaiHoSoDTO.setTrongNamHoSoGiaiQuyet(trongNamHoSoGiaiQuyet);
				loaiHoSoDTO.setHoSoTon(hoSoTon);
				loaiHoSoDTO.setGhiChu(ghiChuLoaiHoSo);
				
				if ((tongCong > 0) || (trongNamHoSoNhan > 0) || (trongThangHoSoGiaiQuyet > 0) || (trongNamHoSoGiaiQuyet > 0) || (hoSoTon > 0)) {
					loaiHoSoDTO.setHasFile(true);
				}
				
				// add vao loaiHoSoList
				loaiHoSoList.add(loaiHoSoDTO);
				
				phongBanTonDauKy += tonDauKy;
				phongBanTrongThangHoSoNhan += trongThangHoSoNhan;
				phongBanTongCong += tongCong;
				phongBanTrongNamHoSoNhan += trongNamHoSoNhan;
				phongBanTrongThangHoSoGiaiQuyet += trongThangHoSoGiaiQuyet;
				phongBanTrongNamHoSoGiaiQuyet += trongNamHoSoGiaiQuyet;
				phongBanHoSoTon += hoSoTon;
			}	
			
			BaoCaoHoSoThangLuyKeDTO baoCaoHoSoThangLuyKeDTO = new BaoCaoHoSoThangLuyKeDTO(); 
			baoCaoHoSoThangLuyKeDTO.setDepartmentId(pmlDepartmentId);
			baoCaoHoSoThangLuyKeDTO.setTenPhongBan(tenPhongBan);
			baoCaoHoSoThangLuyKeDTO.setTonDauKy(phongBanTonDauKy);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoNhan(phongBanTrongThangHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTongCong(phongBanTongCong);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoNhan(phongBanTrongNamHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoGiaiQuyet(phongBanTrongThangHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoGiaiQuyet(phongBanTrongNamHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setHoSoTon(phongBanHoSoTon);
			baoCaoHoSoThangLuyKeDTO.setGhiChu(ghiChuPhong);
			
			baoCaoHoSoThangLuyKeDTO.setLoaiHoSoList(loaiHoSoList);
			
			if ((phongBanTongCong > 0) || (phongBanTrongNamHoSoNhan > 0) || (phongBanTrongThangHoSoGiaiQuyet > 0) || (phongBanTrongNamHoSoGiaiQuyet > 0) || (phongBanHoSoTon > 0)) {
				baoCaoHoSoThangLuyKeDTO.setHasFile(true);
			}
			
			//if (loaiHoSoList.size() != 0) {
				baoCaoHoSoThangLuyKeList.add(baoCaoHoSoThangLuyKeDTO);
			//}
			
			totalTonDauKy += phongBanTonDauKy;
			totalTrongThangHoSoNhan += phongBanTrongThangHoSoNhan;
			totalTongCong += phongBanTongCong;
			totalTrongNamHoSoNhan += phongBanTrongNamHoSoNhan;
			totalTrongThangHoSoGiaiQuyet += phongBanTrongThangHoSoGiaiQuyet;
			totalTrongNamHoSoGiaiQuyet += phongBanTrongNamHoSoGiaiQuyet;
			totalHoSoTon += phongBanHoSoTon;
		}
		
		BaoCaoHoSoThangLuyKeDTO totalDTO = new BaoCaoHoSoThangLuyKeDTO(); 
		totalDTO.setTonDauKy(totalTonDauKy);
		totalDTO.setTrongThangHoSoNhan(totalTrongThangHoSoNhan);
		totalDTO.setTongCong(totalTongCong);
		totalDTO.setTrongNamHoSoNhan(totalTrongNamHoSoNhan);
		totalDTO.setTrongThangHoSoGiaiQuyet(totalTrongThangHoSoGiaiQuyet);
		totalDTO.setTrongNamHoSoGiaiQuyet(totalTrongNamHoSoGiaiQuyet);
		totalDTO.setHoSoTon(totalHoSoTon);
		
		if ((totalTongCong > 0) || (totalTrongNamHoSoNhan > 0) || (totalTrongThangHoSoGiaiQuyet > 0) || (totalTrongNamHoSoGiaiQuyet > 0) || (totalHoSoTon > 0)) {
			totalDTO.setHasFile(true);
		}
		
		baoCaoHoSoThangLuyKeList.add(totalDTO);
		
		return baoCaoHoSoThangLuyKeList;
	}
	
	public List<BaoCaoHoSoThangLuyKeDTO> getBaoCaoHoSoThangLuyKeReport(Date fromDate, Date toDate) throws Exception {
		
		List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		
		// set cac truong cho tong so
		//String totalDienGiai = "         \ufeffT\u1ed5ng s\u1ed1";
		int totalTonDauKy = 0;
		int totalTrongThangHoSoNhan = 0;
		int totalTongCong = 0;
		int totalTrongNamHoSoNhan = 0;
		int totalTrongThangHoSoGiaiQuyet = 0;
		int totalTrongNamHoSoGiaiQuyet = 0;
		int totalHoSoTon = 0;
		//String totalGhiChu = "";
		
		// Lay ra danh sach Phong co trong he thong
		List<Department> pmlDepartmentList = DepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// set cac truong cho phong ban
			String tenPhongBan = "";
			int phongBanTonDauKy = 0;
			int phongBanTrongThangHoSoNhan = 0;
			int phongBanTongCong = 0;
			int phongBanTrongNamHoSoNhan = 0;
			int phongBanTrongThangHoSoGiaiQuyet = 0;
			int phongBanTrongNamHoSoGiaiQuyet = 0;
			int phongBanHoSoTon = 0;
			String ghiChuPhong = "";
			
			// Lay ra tung Phong de xu ly
			Department pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			tenPhongBan = pmlDepartment.getDepartmentsName();
			ghiChuPhong = pmlDepartment.getDescription();

			// Lay danh sach loai ho so cua tung Phong
			List<PmlFileType> pmlFileTypeList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileTypeByDepartmentId(pmlDepartmentId);
			int pmlFileTypeSize = pmlFileTypeList.size();
			List<LoaiHoSoDTO> loaiHoSoList = new ArrayList<LoaiHoSoDTO>();
			for(int i = 0; i < pmlFileTypeSize; i ++) {
				
				// Lay ra tung FileType xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(i);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				
				// Lay danh sach ho so thuoc pmlFileTypeId & pmlDepartmentId
				List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId_FileTypeId(pmlDepartmentId, pmlFileTypeId);
				int pmlFilePCCCSize = pmlFilePCCCList.size();
				
				//
				String tenLoaiHoSo = pmlFileType.getFileTypeName();
				int tonDauKy = getTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int tongCong = tonDauKy + trongThangHoSoNhan;
				int trongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize, toDate);
				int hoSoTon = tongCong - trongThangHoSoGiaiQuyet;
				String ghiChuLoaiHoSo = "";
				
				// set vao DTO
				int k = i;
				LoaiHoSoDTO loaiHoSoDTO = new LoaiHoSoDTO();
				loaiHoSoDTO.setTenLoaiHoSo(StringUtils.convertToRTF((k + 1) + "/ " + tenLoaiHoSo));
				loaiHoSoDTO.setTonDauKy(tonDauKy);
				loaiHoSoDTO.setTrongThangHoSoNhan(trongThangHoSoNhan);
				loaiHoSoDTO.setTongCong(tongCong);
				loaiHoSoDTO.setTrongNamHoSoNhan(trongNamHoSoNhan);
				loaiHoSoDTO.setTrongThangHoSoGiaiQuyet(trongThangHoSoGiaiQuyet);
				loaiHoSoDTO.setTrongNamHoSoGiaiQuyet(trongNamHoSoGiaiQuyet);
				loaiHoSoDTO.setHoSoTon(hoSoTon);
				loaiHoSoDTO.setGhiChu(ghiChuLoaiHoSo != "" ? StringUtils.convertToRTF(ghiChuLoaiHoSo) : "");
				
				// add vao loaiHoSoList
				loaiHoSoList.add(loaiHoSoDTO);
				
				phongBanTonDauKy += tonDauKy;
				phongBanTrongThangHoSoNhan += trongThangHoSoNhan;
				phongBanTongCong += tongCong;
				phongBanTrongNamHoSoNhan += trongNamHoSoNhan;
				phongBanTrongThangHoSoGiaiQuyet += trongThangHoSoGiaiQuyet;
				phongBanTrongNamHoSoGiaiQuyet += trongNamHoSoGiaiQuyet;
				phongBanHoSoTon += hoSoTon;
			}	
			
			BaoCaoHoSoThangLuyKeDTO baoCaoHoSoThangLuyKeDTO = new BaoCaoHoSoThangLuyKeDTO(); 
			baoCaoHoSoThangLuyKeDTO.setTenPhongBan(StringUtils.convertToRTF(tenPhongBan));
			baoCaoHoSoThangLuyKeDTO.setTonDauKy(phongBanTonDauKy);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoNhan(phongBanTrongThangHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTongCong(phongBanTongCong);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoNhan(phongBanTrongNamHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoGiaiQuyet(phongBanTrongThangHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoGiaiQuyet(phongBanTrongNamHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setHoSoTon(phongBanHoSoTon);
			baoCaoHoSoThangLuyKeDTO.setGhiChu(ghiChuPhong != "" ? StringUtils.convertToRTF(ghiChuPhong) : "");
			
			baoCaoHoSoThangLuyKeDTO.setLoaiHoSoList(loaiHoSoList);
			
			if (loaiHoSoList.size() != 0) {
				baoCaoHoSoThangLuyKeList.add(baoCaoHoSoThangLuyKeDTO);
			}
			
			totalTonDauKy += phongBanTonDauKy;
			totalTrongThangHoSoNhan += phongBanTrongThangHoSoNhan;
			totalTongCong += phongBanTongCong;
			totalTrongNamHoSoNhan += phongBanTrongNamHoSoNhan;
			totalTrongThangHoSoGiaiQuyet += phongBanTrongThangHoSoGiaiQuyet;
			totalTrongNamHoSoGiaiQuyet += phongBanTrongNamHoSoGiaiQuyet;
			totalHoSoTon += phongBanHoSoTon;
		}
		
		BaoCaoHoSoThangLuyKeDTO totalDTO = new BaoCaoHoSoThangLuyKeDTO(); 
		totalDTO.setTonDauKy(totalTonDauKy);
		totalDTO.setTrongThangHoSoNhan(totalTrongThangHoSoNhan);
		totalDTO.setTongCong(totalTongCong);
		totalDTO.setTrongNamHoSoNhan(totalTrongNamHoSoNhan);
		totalDTO.setTrongThangHoSoGiaiQuyet(totalTrongThangHoSoGiaiQuyet);
		totalDTO.setTrongNamHoSoGiaiQuyet(totalTrongNamHoSoGiaiQuyet);
		totalDTO.setHoSoTon(totalHoSoTon);
		
		baoCaoHoSoThangLuyKeList.add(totalDTO);
		
		return baoCaoHoSoThangLuyKeList;
	}
	
	/**
	 * Lay so luong ho so nhan ton dau ky (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien:	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh theo: ngay nop truoc ngay bat dau bao cao va
	 * 				  ngay hoan thanh khong co hoac lon hon hay bang ngay bat dau bao cao
	 * 
	 * @param pmlDepartmentId: 	ma phong ban
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	private int getTonDauKyThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so nhan trong thang (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien: 	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh trong giai doan thoi gian bao cao (tu ngay -> den ngay)
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	private int getHoSoNhanTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so giai quyet trong nam
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	private int getHoSoNhanTrongNamThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		// Lay nam bao cao tu toDate
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		int year = cal.YEAR;
		
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return PmlUserLocalServiceUtil.getHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate);
	}
	
	/**
	 * Lay so luong ho so giai quyet trong thang
	 * 
	 * Dieu kien:	- Ho so giai quyet trong thang trong khoang thoi gian bao cao (tu ngay -> den ngay)
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	private int getHoSoGiaiQuyetTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}

	/**
	 * Lay so luong so ho so giai quyet trong nam
	 * 
	 * Dieu kien:	- Ho so giai quyet trong nam den thoi diem bao cao
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 * @throws Exception 
	 */
	private int getHoSoGiaiQuyetTrongNam(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date toDate) throws Exception {
				
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		int year = cal.YEAR; // Lay nam bao cao tu toDate
		
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return PmlUserLocalServiceUtil.getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate);
	}
	
	/**
	 * Xuat file .doc bao cao ho so thang luy ke
	 * 
	 * @param req:	PortletRequest
	 * @param res:	PortletResponse
	 * @throws Exception
	 */
	/*private void xuatFileBaoCaoHoSoThangLuyKe(PortletRequest req, PortletResponse res, Date fromDate, Date toDate) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		File templateFile = new File(request.getSession().getServletContext().getRealPath("reports/BaoCaoHoSoThangLuyKe.odt"));
        File outputFile = File.createTempFile("report", ".doc");

        DocumentTemplate template = null;
        if (templateFile.isDirectory()) {
            template = new UnzippedDocumentTemplate(templateFile);
        } else {
            template = new ZippedDocumentTemplate(templateFile);
        }

        Map model = new HashMap();
        model.put("baoCaoHoSoThangLuyKeList", getBaoCaoHoSoThangLuyKeReport(fromDate, toDate));

		if ("odt".equals(FilenameUtils.getExtension(outputFile.getName()))) {
			template.createDocument(model, new FileOutputStream(outputFile));
		} else {
	        OpenOfficeConnection connection = new SocketOpenOfficeConnection();
	        try {
	            connection.connect();
	        } catch (ConnectException connectException) {
	            System.err.println("ERROR: connection failed. Please make sure OpenOffice.org is running and listening on port "+ SocketOpenOfficeConnection.DEFAULT_PORT +".");
	            System.exit(1);
	        }

			File temporaryFile = File.createTempFile("document", ".odt");
			temporaryFile.deleteOnExit();
	        template.createDocument(model, new FileOutputStream(temporaryFile));

	        try {
	            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
	            converter.convert(temporaryFile, outputFile);
	        } finally {
	            connection.disconnect();
	        }
		}
		
		String contentType = MimeTypesUtil.getContentType(outputFile);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ServletResponseUtil.sendFile(response, outputFile.getName(), inputStream, contentType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	private void xuatFileBaoCaoHoSoThangLuyKe(PortletRequest req, PortletResponse res, Date fromDate, Date toDate) throws Exception {
		

	}
	
}
