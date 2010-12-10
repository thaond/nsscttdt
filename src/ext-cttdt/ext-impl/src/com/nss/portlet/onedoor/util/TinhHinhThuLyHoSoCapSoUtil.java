package com.nss.portlet.onedoor.util;

import java.util.ArrayList;
import java.util.List;

import com.nss.portlet.onedoor.dto.TinhHinhThuLyHoSoCapSoDTO;


import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class TinhHinhThuLyHoSoCapSoUtil extends RTFUtil {
	
	private List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList;
	private String toDay;
	
	public TinhHinhThuLyHoSoCapSoUtil(String outDirectory) {
		super(outDirectory);
	}

	public TinhHinhThuLyHoSoCapSoUtil(String outDirectory, List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList, String toDay) {
		super(outDirectory);
		this.tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
		this.tinhHinhThuLyHoSoCapSoList.addAll(tinhHinhThuLyHoSoCapSoList);
		this.toDay = toDay;
	}
	
	@Override
	protected void putContext(IContext context) {
		context.put("tinhHinhThuLyHoSoCapSoList", this.tinhHinhThuLyHoSoCapSoList);
		context.put("toDay", this.toDay);
	}
}
