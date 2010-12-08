package com.nss.portlet.onedoor.util;

import java.util.ArrayList;
import java.util.List;

import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class BaoCaoHoSo_FileDetailUtil extends RTFUtil {
	
	private List<PmlFilePcccDTO> listSearch;
	
	public BaoCaoHoSo_FileDetailUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public BaoCaoHoSo_FileDetailUtil(String outDirectory, List<PmlFilePcccDTO> listSearch) {
		super(outDirectory);
		this.listSearch = new ArrayList<PmlFilePcccDTO>();
		this.listSearch.addAll(listSearch);
	}
	
	@Override
	protected void putContext(IContext context) {
		context.put("listSearch", this.listSearch);
	}

}
