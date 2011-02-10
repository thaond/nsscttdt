package com.sgs.portlet.document.receipt.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.InvalidExtendProcessException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentReceiptExtendLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendUtil;

public class PmlEdmDocumentReceiptExtendLocalServiceImpl
    extends PmlEdmDocumentReceiptExtendLocalServiceBaseImpl {

	/**
	 * Them moi muc gia han cho van ban den
	 * 
	 * @param documentReceiptId Ma so van ban den
	 * @param documentReceiptLogId Ma so dong log cua van ban den se thay doi
	 * @param startProcessDate Ngay bat dau cua buoc gia han
	 * @param numDayProcessBef So ngay xu ly cu cua buoc
	 * @param limitDateBef Gioi han ngay xu ly cu
	 * @param extendReason Li do gia han
	 * @param numDayProcessAft So ngay xu ly moi
	 * @param limitDateAft Giai han ngay xu ly moi
	 * @param leanOnLimitDate Dua vao gioi han ngay de tinh ra so ngay hay nguoc lai
	 * @param extendUserId Ma so nguoi dung gia han
	 * @param extendDepartmentId Ma so phong ban gia han
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public PmlEdmDocumentReceiptExtend addDocumentReceiptExtend(
			long documentReceiptId, long documentReceiptLogId, Date startProcessDate, 
			int numDayProcessBef, Date limitDateBef, String extendReason, 
			int numDayProcessAft, Date limitDateAft, boolean leanOnLimitDate, 
			long extendUserId, String extendDepartmentId) throws PortalException, SystemException {
		
		// Kiem tra cac gia tri nhap vao truoc khi them
		validateForAdd(documentReceiptId, documentReceiptLogId, startProcessDate, numDayProcessBef, 
				limitDateBef, extendUserId, extendDepartmentId);
		
		// Phat sinh ma so cho muc gia han moi 
		long documentReceiptExtendId = CounterLocalServiceUtil.increment();
		PmlEdmDocumentReceiptExtend docRecExt = PmlEdmDocumentReceiptExtendUtil.create(
				documentReceiptExtendId);
		
		// Lay chi so thu tu cua muc gia han moi them
		int extendOrderNo = 0;
		try { 
			extendOrderNo = pmlEdmDocumentReceiptExtendFinder.getMaxOrderNoByDocumentReceiptId(
					documentReceiptId) + 1;
		}
		catch (Exception e) {
			extendOrderNo = 1;
		}
		
		// Dat thuoc tinh cho doi tuong moi
		docRecExt.setDocumentReceiptId(documentReceiptId);
		docRecExt.setDocumentReceiptLogId(documentReceiptLogId);
		docRecExt.setExtendOrderNo(extendOrderNo);
		docRecExt.setStartProcessDate(startProcessDate);
		docRecExt.setNumDayProcessBef(numDayProcessBef);
		docRecExt.setLimitDateBef(limitDateBef);
		docRecExt.setExtendReason(extendReason);
		docRecExt.setNumDayProcessAft(numDayProcessAft);
		docRecExt.setLimitDateAft(limitDateAft);
		docRecExt.setLeanOnLimitDate(leanOnLimitDate);
		docRecExt.setExtendUserId(extendUserId);
		docRecExt.setExtendDepartmentId(extendDepartmentId);
		
		// Update
		pmlEdmDocumentReceiptExtendPersistence.update(docRecExt, false);
		
		return docRecExt;
	}
	
	protected void validateForAdd(
			long documentReceiptId, long documentReceiptLogId, Date startProcessDate, 
			int numDayProcessBef, Date limitDateBef, long extendUserId, 
			String extendDepartmentId) throws PortalException, SystemException {
		
		// Kiem tra co nhap day du
		if (documentReceiptId <= 0 || 
				documentReceiptLogId <= 0 ||
				startProcessDate == null ||
				numDayProcessBef <= 0 ||
				limitDateBef == null || 
				extendUserId <= 0 ||
				extendDepartmentId.trim().length() == 0) {
			throw new InvalidExtendProcessException();
		}
	}	
}
