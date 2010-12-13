package com.nss.portlet.onedoor.util;

import java.util.ArrayList;
import java.util.List;

import com.nss.portlet.onedoor.dto.BaoCaoHoSoThangDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class BaoCaoHoSoThangUtil extends RTFUtil {
	
	private List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList;
	private BaoCaoHoSoThangDTO totalDTO;
	private String fromDate;
	private String toDate;
	
	public BaoCaoHoSoThangUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public BaoCaoHoSoThangUtil(String outDirectory, List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList, String fromDate, String toDate) {
		super(outDirectory);
		this.baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
		this.totalDTO = baoCaoHoSoThangList.get(baoCaoHoSoThangList.size() - 1);
		baoCaoHoSoThangList.remove(baoCaoHoSoThangList.size() - 1);
		this.baoCaoHoSoThangList.addAll(baoCaoHoSoThangList);
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	@Override
	protected void putContext(IContext context) {
		
		context.put("baoCaoHoSoThangList", this.baoCaoHoSoThangList);
		context.put("totalDTO", this.totalDTO);
		context.put("fromDate", this.fromDate);
		context.put("toDate", this.toDate);
	}

}
