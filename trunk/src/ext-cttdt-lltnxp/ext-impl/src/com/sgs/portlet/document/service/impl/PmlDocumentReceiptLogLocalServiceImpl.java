package com.sgs.portlet.document.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.NoSuchReceiptLogException;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.service.base.PmlDocumentReceiptLogLocalServiceBaseImpl;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;


public class PmlDocumentReceiptLogLocalServiceImpl
    extends PmlDocumentReceiptLogLocalServiceBaseImpl {
	
	public int deletePmlDocumentReceiptLogByRecId(long documentReceiptId) {
		int retVal = 0;
		
		try {
			List<PmlDocumentReceiptLog> docRecLogs = PmlDocumentReceiptLogUtil
					.findByDocumentReceiptId(documentReceiptId);
			for (PmlDocumentReceiptLog docRecLogItem : docRecLogs) {
				// Xoa log
				PmlDocumentReceiptLogUtil.remove(docRecLogItem);
				// Tang so luong log bi xoa
				retVal ++;
			} // end for
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa log cua van ban den.");
			ex.printStackTrace();
}
		return retVal;
	}
	
	/**
	 * Kiem tra xem dong log co phai thuoc lan luan chuyen dau tien cua log van ban den
	 * 
	 * @param documentReceiptId Ma so van ban den
	 * @param transition_ Transition_ cua dong log can kiem tra
	 * @return -1 neu khong hop le, 0 neu khong phai buoc dau tien, 1 neu la buoc dau tien
	 */
	public int checkFirstStepDocRecByTran(long documentReceiptId, int transition_) {
		int retVal = -1;
		
		try {
			// Lay danh sach log cua van ban den
			List<PmlDocumentReceiptLog> logs = pmlDocumentReceiptLogPersistence
					.findByDocumentReceiptId(documentReceiptId);
			// Chi thuc hien kiem tra khi logs co gia tri va transition_ > 0
			if (!logs.isEmpty() && transition_ > 0) {
				if (transition_ == 1) return 1;

				// Sap xep logs theo gia tri tang dan cua transition_
				Collections.sort(logs, new Comparator<PmlDocumentReceiptLog>() {
					public int compare(PmlDocumentReceiptLog log1, PmlDocumentReceiptLog log2) {
						if (log1.getTransition_() == log2.getTransition_()) {
							return 0;
						} // end if
						else if (log1.getTransition_() < log2.getTransition_()) {
							return -1;
						} // end if
						else {
							return 1;
						} // end else
					}
				});
				
				// Khi co log, mac dinh coi nhu dong log kiem tra la dong bat dau cua buoc chuyen
				retVal = 1;
				// Lay ra doi tuong dau tien de lam chuan so sanh
				PmlDocumentReceiptLog firstLog = (PmlDocumentReceiptLog) logs.get(0);
				// Duyet danh sach va kiem tra
				for (int idx = 1; idx < (transition_ < logs.size() ? transition_ : logs.size()); idx++) {
					PmlDocumentReceiptLog curLog = (PmlDocumentReceiptLog) logs.get(idx);
					// Kiem tra
					if (curLog.getProcesser() != firstLog.getProcesser() || 
							curLog.getDateProcess() != firstLog.getDateProcess() || 
							!curLog.getProcessInfomation().equals(firstLog.getProcessInfomation()) || 
							curLog.getStateProcessIdBefore() != firstLog.getStateProcessIdBefore() || 
							curLog.getStateProcessIdAfter() != firstLog.getStateProcessIdAfter() || 
							curLog.getType_() != firstLog.getType_() || 
							curLog.getNumDateProcess() != firstLog.getNumDateProcess() || 
							curLog.getProcessInstanceId() != firstLog.getProcessInstanceId()) {
						retVal = 0;
						break;
					} // end if
				} // end for
			} // end if
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi kiem tra dong log thuoc buoc dau tien cua luan chuyen van ban den.");
			retVal = -1;
		}
		return retVal;
	}
	
	/**
	 * Gia han thoi gian xu ly VB
	 * Cap nhat log cua van ban den dua vao ma so
	 * 
	 * @param documentReceiptLogId Ma so dong log cua van ban den
	 * @param expiredDate Ngay het han xu ly
	 * @param numDateProcess So ngay xu ly
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public PmlDocumentReceiptLog updateDocumentReceiptLog(long documentReceiptLogId, 
			Date expiredDate, int numDateProcess) throws PortalException, SystemException {
		
		PmlDocumentReceiptLog docRecLogItem = null;
		try {
			docRecLogItem = PmlDocumentReceiptLogUtil.findByPrimaryKey(documentReceiptLogId);
			// Cap nhat thuoc tinh
			docRecLogItem.setExpiredDate(expiredDate);
			docRecLogItem.setNumDateProcess(numDateProcess);
			
			// Cap nhat
			pmlDocumentReceiptLogPersistence.update(docRecLogItem, false);
		}
		catch (Exception ex) {
			if (ex instanceof NoSuchReceiptLogException) {
				// Do nothing
			}
			else {
				System.out.println("Error in PmlDocumentReceiptLogLocalServiceImpl." + ex.getMessage());
				ex.printStackTrace();
			}
		}
		return docRecLogItem;
	}
}
