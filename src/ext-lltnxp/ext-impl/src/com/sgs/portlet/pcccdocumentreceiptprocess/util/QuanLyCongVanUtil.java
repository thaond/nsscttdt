package com.sgs.portlet.pcccdocumentreceiptprocess.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.sgs.portlet.pcccdocumentreceiptprocess.dto.QuanLyCongVanDTO;

public class QuanLyCongVanUtil extends RTFUtil {
	private List<QuanLyCongVanDTO> quanLyCongVanList;
	
	public QuanLyCongVanUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public QuanLyCongVanUtil(String outDirectory, List<QuanLyCongVanDTO> quanLyCongVanList) {
		super(outDirectory);
		this.quanLyCongVanList = new ArrayList<QuanLyCongVanDTO>();
		this.quanLyCongVanList.addAll(quanLyCongVanList);
	}

	protected void putContext(IContext context) {
		context.put("quanLyCongVanDTOList", this.quanLyCongVanList);
		
	}

}
