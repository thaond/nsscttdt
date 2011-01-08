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
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapPhongDTO;

public class TinhHinhThuLyHoSoCapPhongAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		// Lay Ma phong ban cua userId (user hien tai dang nhap vao he thong)
		long userId = PortalUtil.getUserId(req);
		Date toDay = new Date();
		xuatFileTinhHinhThuLyHoSoCapPhong(req, res, userId, toDay);
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				// Lay Ma phong ban cua userId (user hien tai dang nhap vao he thong)
				long userId = PortalUtil.getUserId(req);
				Date toDay = new Date();
				req.setAttribute("tinhHinhThuLyHoSoCapPhongList", getTinhHinhThuLyHoSoCapPhong(userId, toDay));
				
				return mapping.findForward("portlet.sgs.onedoorpcccreport.tinhhinhthulyhosocapphong");
			}
	}

	private List<TinhHinhThuLyHoSoCapPhongDTO> getTinhHinhThuLyHoSoCapPhong(long userId, Date toDay) throws Exception {
		
		List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
		
		String pmlDepartmentId = PmlUserLocalServiceUtil.getPmlUser(userId).getDepartmentsId();
		// Lay dang sach cac chuyen vien trong Phong ban
		List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId); //DMPB01090000037
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) { // Duyet qua tung chuyen vien
			
			String chuyenVien = PmlUserLocalServiceUtil.getFullName(pmlUserList.get(index).getUserId());
			int tonTruoc = getSoLuongHoSoTonTruoc(pmlUserList.get(index).getUserId(), toDay);
			int daNhan = getSoLuongHoSoDaNhan(pmlUserList.get(index).getUserId(), toDay);
			int chuaNhan = getSoLuongHoSoChuaNhan(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			int tuGiaiQuyet = getSoLuongHoSoTuGiaiQuyet(pmlUserList.get(index).getUserId(), toDay);
			int nguoiKhacThuLyThay = getSoLuongHoSoNguoiKhacThuLyThay(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoGiaiQuyet = tuGiaiQuyet + nguoiKhacThuLyThay;
			int trongHanISO = getSoLuongHoSoTrongHanISO(pmlUserList.get(index).getUserId(), toDay);
			int quaHanISO = getSoLuongHoSoQuaHanISO(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - tongHoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapPhongDTO tinhHinhThuLyHoSoCapPhongDTO = new TinhHinhThuLyHoSoCapPhongDTO();
			tinhHinhThuLyHoSoCapPhongDTO.setId(pmlUserList.get(index).getUserId());
			tinhHinhThuLyHoSoCapPhongDTO.setChuyenVien(chuyenVien);
			tinhHinhThuLyHoSoCapPhongDTO.setTonTruoc(tonTruoc);
			tinhHinhThuLyHoSoCapPhongDTO.setDaNhan(daNhan);
			tinhHinhThuLyHoSoCapPhongDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
			tinhHinhThuLyHoSoCapPhongDTO.setTuGiaiQuyet(tuGiaiQuyet);
			tinhHinhThuLyHoSoCapPhongDTO.setNguoiKhacThuLyThay(nguoiKhacThuLyThay);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoGiaiQuyet(tongHoSoGiaiQuyet);
			tinhHinhThuLyHoSoCapPhongDTO.setTrongHanISO(trongHanISO);
			tinhHinhThuLyHoSoCapPhongDTO.setQuaHanISO(quaHanISO);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoTonDong(tongHoSoTonDong);
			
			if ((tongHoSoCanXuLy > 0) ||(tongHoSoGiaiQuyet > 0) || (tongHoSoTonDong > 0)) {
				tinhHinhThuLyHoSoCapPhongDTO.setHasFile(true);
			}
			
			tinhHinhThuLyHoSoCapPhongList.add(tinhHinhThuLyHoSoCapPhongDTO);
		}
		return tinhHinhThuLyHoSoCapPhongList;
	}
	
	private List<TinhHinhThuLyHoSoCapPhongDTO> getTinhHinhThuLyHoSoCapPhongReport(long userId, Date toDay) throws Exception {
		
		List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
		
		String pmlDepartmentId = PmlUserLocalServiceUtil.getPmlUser(userId).getDepartmentsId();
		// Lay dang sach cac chuyen vien trong Phong ban
		List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId); //DMPB01090000037
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) { // Duyet qua tung chuyen vien
			
			String chuyenVien = StringUtils.convertToRTF(PmlUserLocalServiceUtil.getFullName(pmlUserList.get(index).getUserId()));
			int tonTruoc = getSoLuongHoSoTonTruoc(pmlUserList.get(index).getUserId(), toDay);
			int daNhan = getSoLuongHoSoDaNhan(pmlUserList.get(index).getUserId(), toDay);
			int chuaNhan = getSoLuongHoSoChuaNhan(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			int tuGiaiQuyet = getSoLuongHoSoTuGiaiQuyet(pmlUserList.get(index).getUserId(), toDay);
			int nguoiKhacThuLyThay = getSoLuongHoSoNguoiKhacThuLyThay(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoGiaiQuyet = tuGiaiQuyet + nguoiKhacThuLyThay;
			int trongHanISO = getSoLuongHoSoTrongHanISO(pmlUserList.get(index).getUserId(), toDay);
			int quaHanISO = getSoLuongHoSoQuaHanISO(pmlUserList.get(index).getUserId(), toDay);
			int tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - tongHoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapPhongDTO tinhHinhThuLyHoSoCapPhongDTO = new TinhHinhThuLyHoSoCapPhongDTO();
			tinhHinhThuLyHoSoCapPhongDTO.setChuyenVien(chuyenVien);
			tinhHinhThuLyHoSoCapPhongDTO.setTonTruoc(tonTruoc);
			tinhHinhThuLyHoSoCapPhongDTO.setDaNhan(daNhan);
			tinhHinhThuLyHoSoCapPhongDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
			tinhHinhThuLyHoSoCapPhongDTO.setTuGiaiQuyet(tuGiaiQuyet);
			tinhHinhThuLyHoSoCapPhongDTO.setNguoiKhacThuLyThay(nguoiKhacThuLyThay);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoGiaiQuyet(tongHoSoGiaiQuyet);
			tinhHinhThuLyHoSoCapPhongDTO.setTrongHanISO(trongHanISO);
			tinhHinhThuLyHoSoCapPhongDTO.setQuaHanISO(quaHanISO);
			tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoTonDong(tongHoSoTonDong);
			
			tinhHinhThuLyHoSoCapPhongList.add(tinhHinhThuLyHoSoCapPhongDTO);
		}
		return tinhHinhThuLyHoSoCapPhongList;
	}
	
	private int getSoLuongHoSoTonTruoc(long userId, Date date) throws Exception {
		return PmlUserLocalServiceUtil.countFileTonTruoc(userId, date);
	}
	
	private int getSoLuongHoSoDaNhan(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileDaNhan(userId, date);
	}
	
	private int getSoLuongHoSoChuaNhan(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileChuaNhan(userId, date);
	}
	
	private int getSoLuongHoSoTuGiaiQuyet(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileTuGiaiQuyet(userId, date);
	}
	
	private int getSoLuongHoSoNguoiKhacThuLyThay(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileNguoiKhacThuLyThay(userId, date);
	}
	
	private int getSoLuongHoSoTrongHanISO(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileTrongHanISO(userId, date);
	}
	
	private int getSoLuongHoSoQuaHanISO(long userId, Date date) throws Exception {
		
		return PmlUserLocalServiceUtil.countFileQuaHanISO(userId, date);
	}
	
	/**
	 * Lay cac chuyen vien cung phong voi user dang nhap
	 * 
	 * @param departmentId: Id cho phong cua user dang nhap
	 * @return List<PmlUser> danh sach nhan vien cung phong voi user dang nhap
	 */
	private List<PmlUser> getChuyenVien(String departmentId) throws Exception {
		List<PmlUser> pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
		return pmlUserList;
	}
	
	private void xuatFileTinhHinhThuLyHoSoCapPhong(PortletRequest req, PortletResponse res, long userId, Date date) throws Exception {

		
	}
}
