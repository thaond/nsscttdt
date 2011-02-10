/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptprocess.util;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.pcccdocumentreceiptprocess.dto.PhieuChuyenDTO;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

/**
 * @author minh.nv
 *
 */
public class PhieuChuyenUtil extends RTFUtil {
	
	private String documentReference = "";
	private String issuingdate = "";
	private String numberdocumentreceipt = "";
	private String hour = "";
	private String minute = "";
	private String datearrive = "";
	private String issuingplaceName = "";
	private String briefcontent = "";
	private String receiver = "";
	private String processinfomation = "";
	private String numdateprocess = "";
	private String yKienLanhDaoBan = "";
	
	private List<PhieuChuyenDTO> phieuChuyenDTOList;
	
	
	public PhieuChuyenUtil(String outDirectory) {
		super(outDirectory);
	}
	
	
	public PhieuChuyenUtil(String outDirectory, List<PhieuChuyenDTO> phieuChuyenDTOList) {
		super(outDirectory);
		this.phieuChuyenDTOList = new ArrayList<PhieuChuyenDTO>();
		this.phieuChuyenDTOList.addAll(phieuChuyenDTOList);
	}
	
	
	public PhieuChuyenUtil(String outDirectory, String documentReference, String hour,
			String minute, String datearrive, String numberdocumentreceipt,
			String issuingdate, String issuingplaceName, String briefcontent,
			String receiver, String processinfomation, String numdateprocess, String yKienLDBan) {
		
		super(outDirectory);
		this.documentReference = documentReference;
		this.issuingdate = issuingdate;
		this.numberdocumentreceipt = numberdocumentreceipt;
		this.hour = hour;
		this.minute = minute;
		this.datearrive = datearrive;
		this.issuingplaceName = issuingplaceName;
		this.briefcontent = briefcontent;
		this.receiver = receiver;
		this.processinfomation = processinfomation;
		this.numdateprocess = numdateprocess;
		this.yKienLanhDaoBan = yKienLDBan;
	}

	protected void putContext(IContext icontext) {
		icontext.put("soVBGoc", this.documentReference);
		icontext.put("ngayBanHanh", this.issuingdate);
		icontext.put("soVanBan", this.numberdocumentreceipt);
		icontext.put("gio", this.hour);
		icontext.put("phut", this.minute);
		icontext.put("ngayDen", this.datearrive);
		icontext.put("coQuanBanHanh", this.issuingplaceName);
		icontext.put("trichYeu", this.briefcontent);
		icontext.put("nguoiXuLy", this.receiver);
		icontext.put("yKienXuLy", this.processinfomation);
		icontext.put("thoiGianXuLy", this.numdateprocess);
		icontext.put("yKienLanhDaoBan", this.yKienLanhDaoBan);
		
		icontext.put("list", this.phieuChuyenDTOList);
	}
}
