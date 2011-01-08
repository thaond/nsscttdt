package com.sgs.portlet.onedoorpcccreport.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapSoDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class TinhHinhThuLyHoSoCapSoUtil extends RTFUtil {
	
	private List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList;
	private String toDay;
	
	public TinhHinhThuLyHoSoCapSoUtil(String outDirectory) {
		super(outDirectory);
		// TODO Auto-generated constructor stub
	}

	public TinhHinhThuLyHoSoCapSoUtil(String outDirectory, List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList, String toDay) {
		super(outDirectory);
		this.tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		this.tinhHinhThuLyHoSoCapSoList.addAll(tinhHinhThuLyHoSoCapSoList);
		this.toDay = toDay;
	}
	
	@Override
	protected void putContext(IContext context) {
		/*
		List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		
		for(int index = 0; index < 10; index ++) {
			
			String phongBan = "Phong ban " + index;
			int tonTruoc = 0;
			int daNhan = 0;
			int chuaNhan = 0;
			int tongHoSoCanXuLy = 0;
			int hoSoGiaiQuyet = 0;
			int trongHanISO = 0;
			int quaHanISO = 0;
			int tongHoSoTonDong = 0;
			
			// set attribute
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
		}*/
		
		context.put("tinhHinhThuLyHoSoCapSoList", this.tinhHinhThuLyHoSoCapSoList);
		context.put("toDay", this.toDay);
	}
}
