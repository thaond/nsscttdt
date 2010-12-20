package com.nss.portlet.onedoorreport_tinhhinhthulyhosocapphong.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.onedoor.dto.TinhHinhThuLyHoSoCapPhongDTO;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.util.TinhHinhThuLyHoSoCapPhongUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		boolean report = ParamUtil.getBoolean(req, "report", false);
		if ( report == true) {
			long userId = PortalUtil.getUserId(req);
			Date toDay = new Date();
			List<String> typeList = new ArrayList<String>();
			List<String> valueTypeList = new ArrayList<String>();
			int start = -1;
			int end = -1;
			OrderByComparator obc = null;
			
			xuatFileTinhHinhThuLyHoSoCapPhong(req, res, userId, toDay, typeList, valueTypeList, start, end, obc);
		}
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.onedoorreport_tinhhinhthulyhosocapphong.view");
			}
	}
	
	private List<TinhHinhThuLyHoSoCapPhongDTO> getTinhHinhThuLyHoSoCapPhongReport(long userId, Date toDay, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(toDay);
		
		List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
		
		// Lay dang sach cac chuyen vien trong Phong ban
		String pmlDepartmentId = PmlUserLocalServiceUtil.getPmlUser(userId).getDepartmentsId();
		List<PmlUser> pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(pmlDepartmentId);
		
		for(int index = 0; index < pmlUserList.size(); index ++) {
			List<Long> userList = new ArrayList<Long>();
			userList.add(pmlUserList.get(index).getUserId());
			String chuyenVien = "";
			try {
				chuyenVien = PmlUserLocalServiceUtil.getFullName(pmlUserList.get(index).getUserId());
			} catch (Exception e) {
				chuyenVien = "";
			}
			
			int tonTruoc = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTruoc(userList, today, typeList, valueTypeList, start, end , obc).size();
			int daNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoDaNhan(userList, today, typeList, valueTypeList, start, end , obc).size();
			int chuaNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoChuaNhan(userList, typeList, valueTypeList, start, end , obc).size();
			int tuGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTuGiaiQuyet(userList, today, typeList, valueTypeList, start, end , obc).size();
			int nguoiKhacThuLyThay = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoNguoiKhacThuLyThay(userList, today, typeList, valueTypeList, start, end , obc).size();
			int trongHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTrongHanISO(userList, today, typeList, valueTypeList, start, end , obc).size();
			int quaHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonQuaHanISO(userList, today, typeList, valueTypeList, start, end , obc).size();
			int tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			int tongHoSoGiaiQuyet = tuGiaiQuyet + nguoiKhacThuLyThay;
			int tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - tongHoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapPhongDTO tinhHinhThuLyHoSoCapPhongDTO = new TinhHinhThuLyHoSoCapPhongDTO();
			tinhHinhThuLyHoSoCapPhongDTO.setChuyenVien(StringUtils.convertToRTF(chuyenVien));
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
	
	private void xuatFileTinhHinhThuLyHoSoCapPhong(PortletRequest req, PortletResponse res, long userId, Date date, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		String path = request.getSession().getServletContext().getRealPath("reports");
		List<TinhHinhThuLyHoSoCapPhongDTO> listDTD = getTinhHinhThuLyHoSoCapPhongReport(userId, date, typeList, valueTypeList, start, end , obc);
		String stringToDay = new SimpleDateFormat("dd/MM/yyyy").format(date);
		
		TinhHinhThuLyHoSoCapPhongUtil rtfUtil = new TinhHinhThuLyHoSoCapPhongUtil(path, listDTD, stringToDay);
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/TinhHinhThuLyHoSoCapPhong.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	

}
