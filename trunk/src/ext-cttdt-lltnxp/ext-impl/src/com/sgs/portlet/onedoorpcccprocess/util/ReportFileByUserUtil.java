package com.sgs.portlet.onedoorpcccprocess.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.sgs.portlet.onedoor.workflow.util.DelegateConstants;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;

public class ReportFileByUserUtil extends RTFUtil {

	private List<PmlFilePcccDTO> ownerList;
	private List<PmlFilePcccDTO> isDelegatedList;
	private List<PmlFilePcccDTO> delegatedList;
	
	// xuat file cho search
	private List<PmlFilePcccDTO> listSearch;
	
	public ReportFileByUserUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public ReportFileByUserUtil(String outDirectory, Map<String, List<PmlFilePcccDTO>> map) {
		super(outDirectory);
		this.ownerList = map.get(DelegateConstants.OWNER);
		this.isDelegatedList = map.get(DelegateConstants.IS_DELEGATED);
		this.delegatedList = map.get(DelegateConstants.DELEGATED);
	}
	
	// constructor cho phan search
	public ReportFileByUserUtil(String outDirectory, List<PmlFilePcccDTO> listSearch) {
		super(outDirectory);
		this.listSearch = new ArrayList<PmlFilePcccDTO>();
		this.listSearch.addAll(listSearch);
	}
	
	@Override
	protected void putContext(IContext context) {
		context.put("ownerList", ownerList);
		context.put("isDelegateList", isDelegatedList);
		context.put("delegateList", delegatedList);
		
		// xuat file cho search
		context.put("listSearch", this.listSearch);
	}

}
