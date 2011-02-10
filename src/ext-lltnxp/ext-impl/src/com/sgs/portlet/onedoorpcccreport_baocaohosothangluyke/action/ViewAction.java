package com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.action;

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
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO;
import com.sgs.portlet.onedoorpcccreport.dto.LoaiHoSoDTO;
import com.sgs.portlet.onedoorpcccreport.util.BaoCaoHoSoThangLuyKeUtil;
import com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.search.BaoCaoHoSoLuyKeDisplayTerms;
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
		boolean report = ParamUtil.getBoolean(req, "report", false);
		List<String> typeList = new ArrayList<String>();
		List<String> valueTypeList = new ArrayList<String>();
		int start = -1;
		int end = -1;
		OrderByComparator obc = null;
		
		if (report) {
			Date fromDate = new Date();
			Date toDate = new Date();
			
			String fromDateString = ParamUtil.getString(req, BaoCaoHoSoLuyKeDisplayTerms.TUNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			String toDateString = ParamUtil.getString(req, BaoCaoHoSoLuyKeDisplayTerms.DENNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			
			if(ParamUtil.getString(req, "fromDate") != "" && ParamUtil.getString(req, "toDate") != "") {
				fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDateString);
				toDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDateString);
			}
			xuatFileBaoCaoHoSoThangLuyKe(req, res, fromDate, toDate, typeList,  valueTypeList, start, end, obc);
		}
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			
			//String month = ParamUtil.getString(req, "month");
			
			//Yenlt update 23/02/2010
//				String fromDate = ParamUtil.getString(req, "fromDate");
//				String toDate = ParamUtil.getString(req, "toDate");
			
//				String fromDate = ParamUtil.getString(req, BaoCaoHoSoLuyKeDisplayTerms.TUNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//				String toDate = ParamUtil.getString(req, BaoCaoHoSoLuyKeDisplayTerms.DENNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//				
//				// end
//				if(Validator.isNull(fromDate) == true && Validator.isNull(toDate) == true) {
//					toDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//					String[] arrToDate = toDate.split("/");
//					fromDate = "01/" + arrToDate[1] + "/" + arrToDate[2];
//				}
//				req.setAttribute("month", getMonth(toDate));
//				req.setAttribute("fromDate", fromDate);
//				req.setAttribute("toDate", toDate);
//				
//				List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = getBaoCaoHoSoThangLuyKe(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate), new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
//				BaoCaoHoSoThangLuyKeDTO totalDTO = baoCaoHoSoThangLuyKeList.get(baoCaoHoSoThangLuyKeList.size() - 1);
//				baoCaoHoSoThangLuyKeList.remove(baoCaoHoSoThangLuyKeList.size() - 1);
//				req.setAttribute("totalDTO", totalDTO);
//				req.setAttribute("baoCaoHoSoThangLuyKeList", baoCaoHoSoThangLuyKeList);
//				
			return mapping.findForward("portlet.sgs.onedoorpcccreport_baocaohosothangluyke.view");
		}
	}

	private String getMonth(String date) {
		String[] arrDate = date.split("/");
		return (arrDate[1] + "/" + arrDate[2]);
	}
	
	public List<BaoCaoHoSoThangLuyKeDTO> getBaoCaoHoSoThangLuyKeReport(String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		
		List<Department> pmlDepartmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
		List<PmlFileType> pmlFileTypeList = PmlFileTypeLocalServiceUtil.getPmlFileTypes(-1, -1);
		List<Long> allUserList = new ArrayList<Long>();
		for(int index = 0; index < pmlDepartmentList.size(); index ++) {
			List<LoaiHoSoDTO> loaiHoSoList = new ArrayList<LoaiHoSoDTO>();
			
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

			// Lay danh sach user thuoc pmlDepartmentId
			List<PmlUser> pmlUserList = null;
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(pmlDepartmentId);
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			List<Long> longList = new ArrayList<Long>();
			for (int i = 0; i < pmlUserList.size(); i++) {
				longList.add(pmlUserList.get(i).getUserId());
				allUserList.add(pmlUserList.get(i).getUserId());
			}
			for(int i = 0; i <  pmlFileTypeList.size(); i ++) {
				PmlFileType pmlFileType = pmlFileTypeList.get(i);
				String pmlFileTypeId = pmlFileType.getFileTypeId();

				String tenLoaiHoSo = pmlFileType.getFileTypeName();
				
				int tonDauKy = getTonDauKyThangLuyKe("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int trongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe("",longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int tongCong = getListTongHSNhanThangLuyKe("",longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int trongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int trongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int trongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, start, end , obc);
				int hoSoTon = getHoSoTonThangLuyKe("", longList, pmlFileTypeId, toDate, typeList, valueTypeList, start, end , obc);
			
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
				if ((tongCong > 0) || (trongNamHoSoNhan > 0) || (trongThangHoSoGiaiQuyet > 0) || (trongNamHoSoGiaiQuyet > 0) || (hoSoTon > 0)) {
					loaiHoSoList.add(loaiHoSoDTO);
				}
				
			}	
			phongBanTonDauKy = getTonDauKyThangLuyKe(pmlDepartmentId, longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanTrongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe(pmlDepartmentId,longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanTongCong = getListTongHSNhanThangLuyKe(pmlDepartmentId,longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanTrongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe(pmlDepartmentId, longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanTrongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe(pmlDepartmentId, longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanTrongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam(pmlDepartmentId, longList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
			phongBanHoSoTon = getHoSoTonThangLuyKe(pmlDepartmentId, longList, "", toDate, typeList, valueTypeList, start, end , obc);
			
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
			
			baoCaoHoSoThangLuyKeList.add(baoCaoHoSoThangLuyKeDTO);
		}
		
		// Tong cong
		int totalTonDauKy = getTonDauKyThangLuyKe("", allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalTrongThangHoSoNhan = getHoSoNhanTrongThangThangLuyKe("",allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalTongCong = getListTongHSNhanThangLuyKe("",allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalTrongNamHoSoNhan = getHoSoNhanTrongNamThangLuyKe("", allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalTrongThangHoSoGiaiQuyet = getHoSoGiaiQuyetTrongThangThangLuyKe("", allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalTrongNamHoSoGiaiQuyet = getHoSoGiaiQuyetTrongNam("", allUserList, "", fromDate, toDate, typeList, valueTypeList, start, end , obc);
		int totalHoSoTon = getHoSoTonThangLuyKe("", allUserList, "", toDate, typeList, valueTypeList, start, end , obc);
		
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
	
	private int getHoSoTonThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		return PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe(departmentId, userIds, fileTypeId, toDate, typeList, valueTypeList, start, end, obc).size();
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
	private int getTonDauKyThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate,  String toDate,List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception{
		return PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
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
	private int getHoSoNhanTrongThangThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		return PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
	}
	/**
	 * hs nhan ton dau ky + hs nhan trong thang
	 */
	private int getListTongHSNhanThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		return PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
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
	private int getHoSoNhanTrongNamThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		String startDateOfYear = "";
		if (null != toDate) {
			String[] date = toDate.split("-");
			// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
			startDateOfYear = "01/01/"+date[0];
		}
		return PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, userIds, fileTypeId, startDateOfYear, toDate, typeList, valueTypeList, start, end, obc).size();
	}
	// end yen 11052010
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
	private int getHoSoGiaiQuyetTrongThangThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		return PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
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
	private int getHoSoGiaiQuyetTrongNam(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		
		String startDateOfYear = "";
		if (null != toDate) {
			String[] date = toDate.split("-");
			// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
			startDateOfYear = "01/01/"+date[0];
		}
		return PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe(departmentId, userIds, fileTypeId, startDateOfYear, toDate, typeList, valueTypeList, start, end, obc).size();
	}
	
	/**
	 * Xuat file .doc bao cao ho so thang luy ke
	 * 
	 * @param req:	PortletRequest
	 * @param res:	PortletResponse
	 * @throws Exception
	 */
	private void xuatFileBaoCaoHoSoThangLuyKe(PortletRequest req, PortletResponse res, Date fromDate, Date toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		// yen 11052010
		String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
		String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
		List<BaoCaoHoSoThangLuyKeDTO> listDTO = getBaoCaoHoSoThangLuyKeReport(fromDate1, toDate1, typeList, valueTypeList, start, end, obc);
		
		String path = request.getSession().getServletContext().getRealPath("reports");
		BaoCaoHoSoThangLuyKeUtil rtfUtil = new BaoCaoHoSoThangLuyKeUtil(path,
				listDTO , new SimpleDateFormat("dd/MM/yyyy").format(fromDate), new SimpleDateFormat("dd/MM/yyyy").format(toDate), 
				getMonth(new SimpleDateFormat("dd/MM/yyyy").format(toDate)));
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/BaoCaoHoSoThangLuyKe.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}

}
