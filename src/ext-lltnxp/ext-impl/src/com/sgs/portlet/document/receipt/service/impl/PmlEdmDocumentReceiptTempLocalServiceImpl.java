package com.sgs.portlet.document.receipt.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentReceiptTempLocalServiceBaseImpl;


public class PmlEdmDocumentReceiptTempLocalServiceImpl
    extends PmlEdmDocumentReceiptTempLocalServiceBaseImpl {
	public int countPmlEdmDocumentReceiptTemp(String soVBDen, String soHieuGoc, int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay) throws SystemException {
		return pmlEdmDocumentReceiptTempFinder.countPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(String soVBDen, String soHieuGoc, int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlEdmDocumentReceiptTempFinder.listPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay, start, end, obc);
	}
	
	public List<PmlEdmDocumentReceiptTemp> getAllList(int start, int end, OrderByComparator obc) throws SystemException {
		return pmlEdmDocumentReceiptTempFinder.getAllList(start, end, obc);
	}
	
	public int countAllList() throws SystemException {
		return pmlEdmDocumentReceiptTempFinder.countAllList();
	}
}
