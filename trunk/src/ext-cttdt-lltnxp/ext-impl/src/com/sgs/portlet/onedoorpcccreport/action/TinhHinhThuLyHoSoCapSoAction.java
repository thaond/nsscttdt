package com.sgs.portlet.onedoorpcccreport.action;

import java.util.ArrayList;
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

import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapSoDTO;

public class TinhHinhThuLyHoSoCapSoAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		// Lay ngay thong ke bao cao (ngay hien tai)
		Date toDay = new Date();
		xuatFileTinhHinhThuLyHoSoCapSo(req, res, toDay);
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				// Lay ngay thong ke bao cao (ngay hien tai)
				Date toDay = new Date();
				req.setAttribute("tinhHinhThuLyHoSoCapSoList", getTinhHinhThuLyHoSoCapSo(toDay));
				
				return mapping.findForward("portlet.sgs.onedoorpcccreport.tinhhinhthulyhosocapso");
			}
	}

	/**
	 * Tinh hinh thu ly ho so cap so
	 * 
	 * @param toDay:	ngay thong ke bao cao
	 * @return
	 * @throws Exception
	 */
	private List<TinhHinhThuLyHoSoCapSoDTO> getTinhHinhThuLyHoSoCapSo(Date toDay) throws Exception {
		
		List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		
		List<Department> pmlDepartmentList = DepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// Lay tung Phong ban ra xu ly
			Department pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			// Lay danh sach user thuoc pmlDepartmentId
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId);
			
			/*
			// pmlFilePCCCList luu danh sach tat ca ho so Phong ban
			List<PmlOneDoorReceiveFile> pmlFilePCCCList = new ArrayList<PmlOneDoorReceiveFile>();
			
			// Lay danh sach cac Field thuoc Phong ban
			List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
			int pmlFieldSize = pmlFieldList.size();
			for(int i = 0; i < pmlFieldSize; i ++) {
				// Lay danh sach cac FileType thuoc Field
				List<PmlFileType> pmlFileTypeList = PmlFileTypeUtil.findByFieldId(pmlFieldList.get(i).getFieldId());
				int pmlFileTypeSize = pmlFileTypeList.size();
				for(int j = 0; j < pmlFileTypeSize; j ++) {
					// Lay danh sach cac ho so thuoc FileType
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileUtil.findByFileTypeId(pmlFileTypeList.get(j).getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					for(int k = 0; k < pmlOneDoorReceiveFileSize; k ++) {
						// Them vao pmlFilePCCCList
						pmlFilePCCCList.add(pmlOneDoorReceiveFileList.get(k));
					}
				}
			}
			
			// So luong ho so trong Phong ban
			int pmlFilePCCCSize = pmlFilePCCCList.size(); */
			
			String phongBan = pmlDepartment.getDepartmentsName();
			int tonTruoc = getSoLuongHoSoTonTruoc(pmlUserList, toDay);
			int daNhan = getSoLuongHoSoDaNhan(pmlUserList, toDay);
			int chuaNhan = getSoLuongHoSoChuaNhan(pmlUserList, toDay);
			int tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			int hoSoGiaiQuyet = getSoLuongHoSoGiaiQuyet(pmlUserList, toDay);
			int trongHanISO = getSoLuongHoSoTrongHanISO(pmlUserList, toDay);
			int quaHanISO = getSoLuongHoSoQuaHanISO(pmlUserList, toDay);
			int tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - hoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapSoDTO tinhHinhThuLyHoSoCapSoDTO = new TinhHinhThuLyHoSoCapSoDTO();
			tinhHinhThuLyHoSoCapSoDTO.setId(pmlDepartmentId);
			tinhHinhThuLyHoSoCapSoDTO.setPhongBan(phongBan);
			tinhHinhThuLyHoSoCapSoDTO.setTonTruoc(tonTruoc);
			tinhHinhThuLyHoSoCapSoDTO.setDaNhan(daNhan);
			tinhHinhThuLyHoSoCapSoDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
			tinhHinhThuLyHoSoCapSoDTO.setHoSoGiaiQuyet(hoSoGiaiQuyet);
			tinhHinhThuLyHoSoCapSoDTO.setTrongHanISO(trongHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setQuaHanISO(quaHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoTonDong(tongHoSoTonDong);
			
			if ((tongHoSoCanXuLy > 0) || (hoSoGiaiQuyet > 0) || (tongHoSoTonDong > 0)) {
				tinhHinhThuLyHoSoCapSoDTO.setHasFile(true);
			}
			
			// add list
			tinhHinhThuLyHoSoCapSoList.add(tinhHinhThuLyHoSoCapSoDTO);
		}
		return tinhHinhThuLyHoSoCapSoList;
	}
	
	private List<TinhHinhThuLyHoSoCapSoDTO> getTinhHinhThuLyHoSoCapSoReport(Date toDay) throws Exception {
		
		List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		
		List<Department> pmlDepartmentList = DepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// Lay tung Phong ban ra xu ly
			Department pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			// Lay danh sach user thuoc pmlDepartmentId
			List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId);
			
			/*
			// pmlFilePCCCList luu danh sach tat ca ho so Phong ban
			List<PmlOneDoorReceiveFile> pmlFilePCCCList = new ArrayList<PmlOneDoorReceiveFile>();
			
			// Lay danh sach cac Field thuoc Phong ban
			List<PmlField> pmlFieldList = PmlFieldUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
			int pmlFieldSize = pmlFieldList.size();
			for(int i = 0; i < pmlFieldSize; i ++) {
				// Lay danh sach cac FileType thuoc Field
				List<PmlFileType> pmlFileTypeList = PmlFileTypeUtil.findByFieldId(pmlFieldList.get(i).getFieldId());
				int pmlFileTypeSize = pmlFileTypeList.size();
				for(int j = 0; j < pmlFileTypeSize; j ++) {
					// Lay danh sach cac ho so thuoc FileType
					List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileUtil.findByFileTypeId(pmlFileTypeList.get(j).getFileTypeId());
					int pmlOneDoorReceiveFileSize = pmlOneDoorReceiveFileList.size();
					for(int k = 0; k < pmlOneDoorReceiveFileSize; k ++) {
						// Them vao pmlFilePCCCList
						pmlFilePCCCList.add(pmlOneDoorReceiveFileList.get(k));
					}
				}
			}
			
			// So luong ho so trong Phong ban
			int pmlFilePCCCSize = pmlFilePCCCList.size(); */
			
			String phongBan = StringUtils.convertToRTF(pmlDepartment.getDepartmentsName());
			int tonTruoc = getSoLuongHoSoTonTruoc(pmlUserList, toDay);
			int daNhan = getSoLuongHoSoDaNhan(pmlUserList, toDay);
			int chuaNhan = getSoLuongHoSoChuaNhan(pmlUserList, toDay);
			int tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			int hoSoGiaiQuyet = getSoLuongHoSoGiaiQuyet(pmlUserList, toDay);
			int trongHanISO = getSoLuongHoSoTrongHanISO(pmlUserList, toDay);
			int quaHanISO = getSoLuongHoSoQuaHanISO(pmlUserList, toDay);
			int tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - hoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapSoDTO tinhHinhThuLyHoSoCapSoDTO = new TinhHinhThuLyHoSoCapSoDTO();
			tinhHinhThuLyHoSoCapSoDTO.setPhongBan(phongBan);
			tinhHinhThuLyHoSoCapSoDTO.setTonTruoc(tonTruoc);
			tinhHinhThuLyHoSoCapSoDTO.setDaNhan(daNhan);
			tinhHinhThuLyHoSoCapSoDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
			tinhHinhThuLyHoSoCapSoDTO.setHoSoGiaiQuyet(hoSoGiaiQuyet);
			tinhHinhThuLyHoSoCapSoDTO.setTrongHanISO(trongHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setQuaHanISO(quaHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoTonDong(tongHoSoTonDong);
			
			// add list
			tinhHinhThuLyHoSoCapSoList.add(tinhHinhThuLyHoSoCapSoDTO);
		}
		return tinhHinhThuLyHoSoCapSoList;
	}
	
	/**
	 * Lay so luong ho so ton truoc
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoTonTruoc(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoTonTruocCapSo(pmlUserList, date);
	}
	
	/**
	 * Lay so luong ho so da nhan
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoDaNhan(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoDaNhanCapSo(pmlUserList, date);
	}
	
	/**
	 * Lay so luong ho so chua nhan
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoChuaNhan(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoChuaNhanCapSo(pmlUserList, date);
	}
	
	/**
	 * Lay so luong ho so giai quyet
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoGiaiQuyet(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoGiaiQuyetCapSo(pmlUserList, date);
	}
	
	/**
	 * Lay so luong ho so trong han ISO
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoTrongHanISO(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoTrongHanISOCapSo(pmlUserList, date);
	}
	
	/**
	 * Lay so luong ho so qua han ISO
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	private int getSoLuongHoSoQuaHanISO(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoQuaHanISOCapSo(pmlUserList, date);
	}
	
	/**
	 * Xuat ra file .doc tinh hinh thu ly ho so cap so
	 * 
	 * @param req
	 * @param res
	 * @param date
	 * @throws Exception
	 */
	private void xuatFileTinhHinhThuLyHoSoCapSo(PortletRequest req, PortletResponse res, Date date) throws Exception {
		
		
	}
}
