/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptreport.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO;
import com.sgs.portlet.pcccdocumentreceiptreport.dto.TinhHinhThuLyCongVanDTO;

/**
 * @author diennh
 * 
 */
public class TinhHinhThuLyCongVanUtil extends RTFUtil {

	private List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList;
	private List<PCCCDocumentListDTO> pCCCDocumentListDTOList;
	private String fromDate;
	private String toDate;
	private String name;
	private String tenPhongBan;
	private String tenAction;

	public TinhHinhThuLyCongVanUtil(String outDirectory) {
		super(outDirectory);
	}

	// xuat file tu view
	public TinhHinhThuLyCongVanUtil(String outDirectory, String tenPhongBan, String fromDate, String toDate,
									List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList, String name) {
		super(outDirectory);
		this.tenPhongBan = tenPhongBan;
		this.fromDate = fromDate;
		this.toDate = toDate;

		this.tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		this.tinhHinhThuLyCongVanList.addAll(tinhHinhThuLyCongVanList);

		this.name = name;
	}

	// xuat file tu ds documentreceipt
	public TinhHinhThuLyCongVanUtil(String outDirectory, String tenPhongBan, String tenAction, String fromDate, String toDate,
									List<PCCCDocumentListDTO> pCCCDocumentListDTOList) {
		super(outDirectory);
		this.tenPhongBan = tenPhongBan;
		this.tenAction = tenAction;
		this.fromDate = fromDate;
		this.toDate = toDate;

		this.pCCCDocumentListDTOList = new ArrayList<PCCCDocumentListDTO>();
		this.pCCCDocumentListDTOList.addAll(pCCCDocumentListDTOList);

	}

	@Override
	protected void putContext(IContext context) {
		context.put("tenPhongBan", this.tenPhongBan);
		context.put("fromDate", this.fromDate);
		context.put("toDate", this.toDate);
		context.put("tenAction", this.tenAction);

		context.put("tinhHinhThuLyCongVanList", this.tinhHinhThuLyCongVanList);
		context.put("pCCCDocumentListDTOList", this.pCCCDocumentListDTOList);

		context.put("name", this.name);
	}
}
