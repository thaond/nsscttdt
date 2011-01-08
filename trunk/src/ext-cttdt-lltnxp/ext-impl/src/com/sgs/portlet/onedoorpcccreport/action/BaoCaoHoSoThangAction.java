package com.sgs.portlet.onedoorpcccreport.action;

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

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangDTO;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class BaoCaoHoSoThangAction extends PortletAction {
	
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
				xuatFileBaoCaoHoSoThang(req, res, fromDate, toDate);
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
		
				String fromDate = ParamUtil.getString(req, "fromDate", "");
				String toDate = ParamUtil.getString(req, "toDate", "");
				if(Validator.isNull(fromDate) == true && Validator.isNull(toDate) == true) {
					toDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
					String[] arrToDate = toDate.split("/");
					fromDate = "01/" + arrToDate[1] + "/" + arrToDate[2];
				}
				req.setAttribute("fromDate", fromDate);
				req.setAttribute("toDate", toDate);
				req.setAttribute("baoCaoHoSoThangList", getBaoCaoHoSoThang(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate), new SimpleDateFormat("dd/MM/yyyy").parse(toDate)));
				
				return mapping.findForward("portlet.sgs.onedoorpcccreport.baocaohosothang");
			}
	}
	
	/**
	 * Lay bao cao ho so thang
	 * 
	 * @param fromDate: tu ngay
	 * @param toDate: 	den ngay
	 * @return
	 * @throws Exception
	 */
	public List<BaoCaoHoSoThangDTO> getBaoCaoHoSoThang(Date fromDate, Date toDate) throws Exception {
		
		List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
		
		try {
			// Lay cac FileType co trong he thong
			List<PmlFileType> pmlFileTypeList = PmlFileTypeUtil.findAll();
			int pmlFileTypeSize = pmlFileTypeList.size();
			for(int index = 0; index < pmlFileTypeSize; index ++) {
				
				// Lay ra tung FileType de xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(index);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				
				List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileUtil.findByFileTypeId(pmlFileTypeId);
				int pmlFilePCCCSize = pmlFilePCCCList.size();
				
				String fileTypeId = pmlFileTypeId;
				int stt = index + 1;
				String tenSanPham = pmlFileType.getFileTypeName();
				int tonDauKy = getTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int hoSoNhanTrongThang = getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int tongCong = tonDauKy + hoSoNhanTrongThang;
				int soDungHan = getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int soTreHan = getSoLuongHoSoTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongHan = getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int daTreHan = getSoLuongHoSoDaTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int chinhSuaBoSung = getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				// Cach tinh: [(hoan thanh dung han + ton trong han + ton chinh sua, bo sung) / tong ho so can xu ly trong thang]*100%
				String tyLeHoSoDungHan = "\ufeffKh\u00f4ng x\u00e1c \u0111\u1ecbnh";
				if(getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) > 0) {
					tyLeHoSoDungHan = 	(((getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) +
											getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) +
											getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate)) /
											getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate)) * 100) + "%";
				}
				
				BaoCaoHoSoThangDTO baoCaoHoSoThangDTO = new BaoCaoHoSoThangDTO();
				baoCaoHoSoThangDTO.setFileTypeId(fileTypeId);
				baoCaoHoSoThangDTO.setStt(stt);
				baoCaoHoSoThangDTO.setTenSanPham(tenSanPham);
				baoCaoHoSoThangDTO.setTonDauKy(tonDauKy);
				baoCaoHoSoThangDTO.setHoSoNhanTrongThang(hoSoNhanTrongThang);
				baoCaoHoSoThangDTO.setTongCong(tongCong);
				baoCaoHoSoThangDTO.setSoDungHan(soDungHan);
				baoCaoHoSoThangDTO.setSoTreHan(soTreHan);
				baoCaoHoSoThangDTO.setTrongHan(trongHan);
				baoCaoHoSoThangDTO.setDaTreHan(daTreHan);
				baoCaoHoSoThangDTO.setChinhSuaBoSung(chinhSuaBoSung);
				baoCaoHoSoThangDTO.setTyLeHoSoDungHan(tyLeHoSoDungHan);
				
				if ((tongCong > 0) || (soDungHan > 0) || (soTreHan > 0) || (trongHan > 0) || (daTreHan > 0) || (chinhSuaBoSung > 0)) {
					baoCaoHoSoThangDTO.setHasFile(true);
				}
				
				baoCaoHoSoThangList.add(baoCaoHoSoThangDTO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return baoCaoHoSoThangList;
		
	}
	
	public List<BaoCaoHoSoThangDTO> getBaoCaoHoSoThangReport(Date fromDate, Date toDate) throws Exception {
		
		List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
		
		try {
			
			int tongTonDauKy = 0;
			int tongHoSoNhanTrongThang = 0;
			int tongTongCong = 0;
			int tongSoDungHan = 0;
			int tongSoTreHan = 0;
			int tongTrongHan = 0;
			int tongDaTreHan = 0;
			int tongChinhSuaBoSung = 0;
			int tongTyLeHoSoDungHan = 0;
			
			// Lay cac FileType co trong he thong
			List<PmlFileType> pmlFileTypeList = PmlFileTypeUtil.findAll();
			int pmlFileTypeSize = pmlFileTypeList.size();
			for(int index = 0; index < pmlFileTypeSize; index ++) {
				
				// Lay ra tung FileType de xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(index);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				
				List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileUtil.findByFileTypeId(pmlFileTypeId);
				int pmlFilePCCCSize = pmlFilePCCCList.size();
				
				String fileTypeId = pmlFileTypeId;
				int stt = index + 1;
				String tenSanPham = StringUtils.convertToRTF(pmlFileType.getFileTypeName());
				int tonDauKy = getTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int hoSoNhanTrongThang = getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int tongCong = tonDauKy + hoSoNhanTrongThang;
				int soDungHan = getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int soTreHan = getSoLuongHoSoTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int trongHan = getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int daTreHan = getSoLuongHoSoDaTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				int chinhSuaBoSung = getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
				// Cach tinh: [(hoan thanh dung han + ton trong han + ton chinh sua, bo sung) / tong ho so can xu ly trong thang]*100%
				String tyLeHoSoDungHan = StringUtils.convertToRTF("\ufeffKh\u00f4ng x\u00e1c \u0111\u1ecbnh");
				if(getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) > 0) {
					int tyLe = 	(((getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) +
											getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate) +
											getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate)) /
											getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate)) * 100);
					tyLeHoSoDungHan = tyLe + "%";
					tongTyLeHoSoDungHan += tyLe;
				}
				
				BaoCaoHoSoThangDTO baoCaoHoSoThangDTO = new BaoCaoHoSoThangDTO();
				baoCaoHoSoThangDTO.setFileTypeId(fileTypeId);
				baoCaoHoSoThangDTO.setStt(stt);
				baoCaoHoSoThangDTO.setTenSanPham(tenSanPham);
				baoCaoHoSoThangDTO.setTonDauKy(tonDauKy);
				baoCaoHoSoThangDTO.setHoSoNhanTrongThang(hoSoNhanTrongThang);
				baoCaoHoSoThangDTO.setTongCong(tongCong);
				baoCaoHoSoThangDTO.setSoDungHan(soDungHan);
				baoCaoHoSoThangDTO.setSoTreHan(soTreHan);
				baoCaoHoSoThangDTO.setTrongHan(trongHan);
				baoCaoHoSoThangDTO.setDaTreHan(daTreHan);
				baoCaoHoSoThangDTO.setChinhSuaBoSung(chinhSuaBoSung);
				baoCaoHoSoThangDTO.setTyLeHoSoDungHan(tyLeHoSoDungHan);
				
				baoCaoHoSoThangList.add(baoCaoHoSoThangDTO);
				
				tongTonDauKy += tonDauKy;
				tongHoSoNhanTrongThang += hoSoNhanTrongThang;
				tongTongCong += tongCong;
				tongSoDungHan += soDungHan;
				tongSoTreHan += soTreHan;
				tongTrongHan += trongHan;
				tongDaTreHan += daTreHan;
				tongChinhSuaBoSung += chinhSuaBoSung;
			}
			
			BaoCaoHoSoThangDTO tongCongDTO = new BaoCaoHoSoThangDTO();
			tongCongDTO.setFileTypeId("all");
			tongCongDTO.setStt(pmlFileTypeSize + 1);
			tongCongDTO.setTenSanPham(StringUtils.convertToRTF(""));
			tongCongDTO.setTonDauKy(tongTonDauKy);
			tongCongDTO.setHoSoNhanTrongThang(tongHoSoNhanTrongThang);
			tongCongDTO.setTongCong(tongTongCong);
			tongCongDTO.setSoDungHan(tongSoDungHan);
			tongCongDTO.setSoTreHan(tongSoTreHan);
			tongCongDTO.setTrongHan(tongTrongHan);
			tongCongDTO.setDaTreHan(tongDaTreHan);
			tongCongDTO.setChinhSuaBoSung(tongChinhSuaBoSung);
			tongCongDTO.setTyLeHoSoDungHan(tongTyLeHoSoDungHan + "%");
			
			baoCaoHoSoThangList.add(tongCongDTO);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return baoCaoHoSoThangList;
		
	}
	
	/**
	 * Lay so luong ho so ton dau ky
	 * 
	 * Dieu kien: 	ngay nop truoc ngay bat dau thong ke
	 * 				va ngay hoan thanh khong co hoac lon
	 * 				hon hay bang ngay bat dau thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numTonDauKy: so luong ho so ton dau ky
	 * @throws Exception 
	 */
	private int getTonDauKy(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		return PmlUserLocalServiceUtil.getTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so nhan trong thang
	 * 
	 * Dieu kien:	la nhung ho so co ngay nhan nam trong doan
	 * 				tu ngay bat dau den ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoNhanTrongThang: so luong ho so nhan trong thang
	 */
	private int getHoSoNhanTrongThang(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so dung han (hoan thanh)
	 * 
	 * Dieu kien:	- Ho so co ngay hoan thanh nam trong thoi gian thong ke
	 * 				- Ngay hoan thanh khong lon hon ngay hen tra
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoDungHan: so luong ho so dung han
	 */
	private int getSoLuongHoSoDungHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so tre han
	 * 
	 * Dieu kien:	- Ho so co ngay hoan thanh trong thoi gian thong ke
	 * 				- Ngay hoan thanh lon hon ngay hen tra
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoTreHan: so luong ho so tre han
	 */
	private int getSoLuongHoSoTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
			
		return PmlUserLocalServiceUtil.getSoLuongHoSoTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so trong han (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so chua co ngay hoan thanh hoac ngay hoan thanh
	 * 				  lon hon ngay ket thuc thong ke
	 * 				- Ngay hen tra lon hon hoac bang ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoTrongHan: so luong ho so trong han
	 */
	private int getSoLuongHoSoTrongHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
			
		return PmlUserLocalServiceUtil.getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so da tre han (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so chua co ngay hoan thanh hoac ngay hoan thanh
	 * 				  lon hon ngay ket thuc thong ke
	 * 				- Ngay hen tra nho hon ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoDaTreHan: so luong ho so da tre han
	 */
	private int getSoLuongHoSoDaTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoDaTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay so luong ho so chinh sua, bo sung (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so co ngay nhan nho hon hoac bang ngay ket thuc thong ke
	 * 				- Co tinh trang cho bo sung
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoChinhSuaBoSung: so luong ho so chinh sua, bo sung
	 */
	private int getSoLuongHoSoChinhSuBoSung(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return PmlUserLocalServiceUtil.getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	/**
	 * Lay buoc chuyen cuoi cung cua mot ho so (max transition_)
	 * 
	 * @param pmlProcessDisposeList
	 * @return
	 *
	private int getMaxTransition_(List<PmlProcessDispose> pmlProcessDisposeList) {
		
		int max = 1;
		int pmlProcessDisposeSize = pmlProcessDisposeList.size();
		if(pmlProcessDisposeSize > 1) {
			max = pmlProcessDisposeList.get(0).getTransition_();
			for(int index = 1; index < pmlProcessDisposeSize; index ++) {
				int transition_ = pmlProcessDisposeList.get(index).getTransition_();
				if(transition_ > max) {
					max = transition_;
				}
			}
		}
		return max;
	}*/
	
	private void xuatFileBaoCaoHoSoThang(PortletRequest req, PortletResponse res, Date fromDate, Date toDate) throws Exception {
		
		
	}
	
}
