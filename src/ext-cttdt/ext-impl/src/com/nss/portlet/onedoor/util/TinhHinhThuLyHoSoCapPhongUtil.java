package com.nss.portlet.onedoor.util;

import java.util.ArrayList;
import java.util.List;

import com.nss.portlet.onedoor.dto.TinhHinhThuLyHoSoCapPhongDTO;


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
		
		
		context.put("tinhHinhThuLyHoSoCapPhongList", this.tinhHinhThuLyHoSoCapPhongList);
		context.put("toDay", this.toDay);
	}

}
