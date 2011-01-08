package com.sgs.portlet.onedoorpcccreport.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapPhongDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class TinhHinhThuLyHoSoCapPhongUtil extends RTFUtil {
	
	private List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList;
	private String toDay;
	
	public TinhHinhThuLyHoSoCapPhongUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public TinhHinhThuLyHoSoCapPhongUtil(String outDirectory, List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList, String toDay) {
		super(outDirectory);
		this.tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
		this.tinhHinhThuLyHoSoCapPhongList.addAll(tinhHinhThuLyHoSoCapPhongList);
		this.toDay = toDay;
	}

	@Override
	protected void putContext(IContext context) {
		
		/*
		// TODO Auto-generated method stub
		List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
		
		for(int index = 0; index < 10; index ++) {
			
			String chuyenVien = "Ten chuyen vien " + index;
			int tonTruoc = 10;
			int daNhan = 0;
			int chuaNhan = 0;
			int tongHoSoCanXuLy = 0;
			int tuGiaiQuyet = 0;
			int nguoiKhacThuLyThay = 0;
			int tongHoSoGiaiQuyet = 0;
			int trongHanISO = 0;
			int quaHanISO = 0;
			int tongHoSoTonDong = 0;
			
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
		}*/
		
		context.put("tinhHinhThuLyHoSoCapPhongList", this.tinhHinhThuLyHoSoCapPhongList);
		context.put("toDay", this.toDay);
	}

}
