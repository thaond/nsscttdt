package com.sgs.portlet.pcccdocumentsendprocess.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.pcccdocumentsendprocess.dto.QuanLyCongVanDiDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class QuanLyCongVanDiUtil extends RTFUtil {
	private List<QuanLyCongVanDiDTO> quanLyCongVanDiList;
	
	/**
	 * 
	 */
	public QuanLyCongVanDiUtil(String outDirectory) {
		super(outDirectory);
	}

	public QuanLyCongVanDiUtil(String outDirectory, List<QuanLyCongVanDiDTO> quanLyCongVanDiList) {
		super(outDirectory);
		this.quanLyCongVanDiList = new ArrayList<QuanLyCongVanDiDTO>();
		this.quanLyCongVanDiList.addAll(quanLyCongVanDiList);
	}
	
	@Override
	protected void putContext(IContext context) {
		context.put("quanLyCongVanDiDTOList", this.quanLyCongVanDiList);
	}
}
