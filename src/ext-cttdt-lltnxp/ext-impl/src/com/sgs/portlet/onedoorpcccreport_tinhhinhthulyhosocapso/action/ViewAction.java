package com.sgs.portlet.onedoorpcccreport_tinhhinhthulyhosocapso.action;

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
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapSoDTO;
import com.sgs.portlet.onedoorpcccreport.util.TinhHinhThuLyHoSoCapSoUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		List<String> typeList = new ArrayList<String>();
		List<String> valueTypeList = new ArrayList<String>();
		int start = -1;
		int end = -1;
		OrderByComparator obc = null;
		Date toDay = new Date();
		
		boolean report = ParamUtil.getBoolean(req, "report", false);
		if ( report == true) {
			xuatFileTinhHinhThuLyHoSoCapSo(req, res, toDay, typeList,  valueTypeList, start, end, obc);
		}
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
//				// Lay ngay thong ke bao cao (ngay hien tai)
//				Date toDay = new Date();
//				req.setAttribute("tinhHinhThuLyHoSoCapSoList", getTinhHinhThuLyHoSoCapSo(toDay));
				
				return mapping.findForward("portlet.sgs.onedoorpcccreport_tinhhinhthulyhosocapso.view");
			}
	}
	
	private List<TinhHinhThuLyHoSoCapSoDTO> getTinhHinhThuLyHoSoCapSoReport(Date toDay, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(toDay);
		List<PmlUser> pmlUserList = null;
		int tonTruoc = 0;
		int daNhan = 0;
		int chuaNhan = 0;
		int hoSoGiaiQuyet = 0;
		int trongHanISO = 0;
		int quaHanISO = 0;
		int tongHoSoCanXuLy = 0;
		int tongHoSoTonDong = 0;
		
		List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		
		List<Department> pmlDepartmentList = DepartmentUtil.findAll();
		int pmlDepartmentSize = pmlDepartmentList.size();
		for(int index = 0; index < pmlDepartmentSize; index ++) {
			
			// Lay tung Phong ban ra xu ly
			Department pmlDepartment = pmlDepartmentList.get(index);
			String pmlDepartmentId = pmlDepartment.getDepartmentsId();
			
			// Lay danh sach user thuoc pmlDepartmentId
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId);
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			List<Long> longList = new ArrayList<Long>();
			for (int i = 0; i < pmlUserList.size(); i++) {
				longList.add(pmlUserList.get(i).getUserId());
			}
			
			String phongBan = pmlDepartment.getDepartmentsName();
			tonTruoc = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTruoc(longList, today, typeList, valueTypeList, start, end, obc).size();
			daNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoDaNhan( longList,  today,  typeList, valueTypeList, start, end , obc).size();
			chuaNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoChuaNhan(longList, typeList, valueTypeList, start, end , obc).size();
			hoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoGiaiQuyet(longList, today, typeList, valueTypeList, start, end, obc).size();
			trongHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTrongHanISO(longList, today, typeList, valueTypeList, start, end , obc).size();
			quaHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonQuaHanISO(longList, today, typeList, valueTypeList, start, end , obc).size();
			tongHoSoCanXuLy = tonTruoc + daNhan + chuaNhan;
			tongHoSoTonDong = trongHanISO + quaHanISO; // hoac = tongHoSoCanXuLy - hoSoGiaiQuyet
			
			TinhHinhThuLyHoSoCapSoDTO tinhHinhThuLyHoSoCapSoDTO = new TinhHinhThuLyHoSoCapSoDTO();
			tinhHinhThuLyHoSoCapSoDTO.setPhongBan(StringUtils.convertToRTF(phongBan));
			tinhHinhThuLyHoSoCapSoDTO.setTonTruoc(tonTruoc);
			tinhHinhThuLyHoSoCapSoDTO.setDaNhan(daNhan);
			tinhHinhThuLyHoSoCapSoDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
			tinhHinhThuLyHoSoCapSoDTO.setHoSoGiaiQuyet(hoSoGiaiQuyet);
			tinhHinhThuLyHoSoCapSoDTO.setTrongHanISO(trongHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setQuaHanISO(quaHanISO);
			tinhHinhThuLyHoSoCapSoDTO.setTongHoSoTonDong(tongHoSoTonDong);
			
			tinhHinhThuLyHoSoCapSoList.add(tinhHinhThuLyHoSoCapSoDTO);
		}
		return tinhHinhThuLyHoSoCapSoList;
	}
	
	/**
	 * Xuat ra file .doc tinh hinh thu ly ho so cap so
	 * 
	 * @param req
	 * @param res
	 * @param date
	 * @throws Exception
	 */
	private void xuatFileTinhHinhThuLyHoSoCapSo(PortletRequest req, PortletResponse res, Date date, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		String path = request.getSession().getServletContext().getRealPath("reports");
		List<TinhHinhThuLyHoSoCapSoDTO>  listDTO = getTinhHinhThuLyHoSoCapSoReport(date, typeList, valueTypeList, start, end , obc);
		
		String stringToDay =  new SimpleDateFormat("dd/MM/yyyy").format(date);
		TinhHinhThuLyHoSoCapSoUtil rtfUtil = new TinhHinhThuLyHoSoCapSoUtil(path, listDTO,stringToDay);
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/TinhHinhThuLyHoSoCapSo.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}

}
