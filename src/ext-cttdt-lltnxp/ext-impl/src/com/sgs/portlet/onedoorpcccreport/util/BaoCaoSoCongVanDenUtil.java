package com.sgs.portlet.onedoorpcccreport.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoSoCongVanDenDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class BaoCaoSoCongVanDenUtil extends RTFUtil {
	
	private List<BaoCaoSoCongVanDenDTO> baoCaoSoCongVanDenList;
	private String fullname;
	
	public BaoCaoSoCongVanDenUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public BaoCaoSoCongVanDenUtil(String outDirectory, List<BaoCaoSoCongVanDenDTO> baoCaoSoCongVanDenList, String fullname) {
		super(outDirectory);
		this.baoCaoSoCongVanDenList = new ArrayList<BaoCaoSoCongVanDenDTO>();
		this.baoCaoSoCongVanDenList.addAll(baoCaoSoCongVanDenList);
		this.fullname = fullname;
	}

	@Override
	protected void putContext(IContext context) {
		
		context.put("baoCaoSoCongVanDenList", this.baoCaoSoCongVanDenList);
		context.put("fullname", this.fullname);
	}

}
