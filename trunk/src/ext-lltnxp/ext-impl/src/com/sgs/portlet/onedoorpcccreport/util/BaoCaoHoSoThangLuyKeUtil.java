package com.sgs.portlet.onedoorpcccreport.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class BaoCaoHoSoThangLuyKeUtil extends RTFUtil {
	
	private List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList;
	private BaoCaoHoSoThangLuyKeDTO totalDTO;
	private String fromDate;
	private String toDate;
	private String month;
	
	public BaoCaoHoSoThangLuyKeUtil(String outDirectory, List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList, String fromDate, String toDate, String month) {
		super(outDirectory);
		this.totalDTO = baoCaoHoSoThangLuyKeList.get(baoCaoHoSoThangLuyKeList.size()-1);
		this.baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		baoCaoHoSoThangLuyKeList.remove(baoCaoHoSoThangLuyKeList.size()-1);
		this.baoCaoHoSoThangLuyKeList.addAll(baoCaoHoSoThangLuyKeList);
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.month = month;
	}

	@Override
	protected void putContext(IContext context) {
		context.put("total", totalDTO);
		context.put("baoCaoHoSoThangLuyKeList", baoCaoHoSoThangLuyKeList);
		context.put("fromDate", this.fromDate);
		context.put("toDate", this.toDate);
		context.put("month", this.month);
	}

}
