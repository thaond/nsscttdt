/**
 * 
 */
package com.sgs.portlet.document.util;

import java.util.Date;
import java.util.List;

import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;



/**
 * @author lethanhtung
 *
 */
public class DataReportUtil {
	private static DataReport dataReport = new DataReport();
	
	public static int tonDauKy_CVDen(String departmentId, long userId,	int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.tonDauKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int nhanTrongKy_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.nhanTrongKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int daGiaiQuyet_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.daGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int dungHan_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dungHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int treHan_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.treHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int dangGiaiQuyet_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dangGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int trongQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.trongQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int quaQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.quaQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int tonDauKy_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.tonDauKy_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int nhanTrongKy_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.nhanTrongKy_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int daGiaiQuyet_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.daGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int dungHan_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dungHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int treHan_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.treHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int dangGiaiQuyet_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dangGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int trongQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.trongQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int quaQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.quaQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTonDauKy_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate) {
		
		return dataReport.getListForTonDauKy_CVDen(departmentId, userId, documentRecordTypeId, startDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForNhanTrongKy_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForNhanTrongKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForDungHan_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForDungHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTreHan_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForTreHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTrongQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForTrongQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForQuaQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForQuaQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTonDauKy_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate) {
		
		return dataReport.getListForTonDauKy_CVDi(departmentId, userId, documentRecordTypeId, startDate);
	}
	
	public static List<PmlDocumentSendLog> getListForNhanTrongKy_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForNhanTrongKy_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForDungHan_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForDungHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTreHan_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForTreHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTrongQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForTrongQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForQuaQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId,
			Date startDate, Date endDate) {
		
		return dataReport.getListForQuaQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
	}
	
	public static int tonDauKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.tonDauKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int nhanTrongKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.nhanTrongKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int dungHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dungHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int treHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.treHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int trongQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.trongQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int quaQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.quaQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int tonDauKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.tonDauKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int nhanTrongKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.nhanTrongKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int dungHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.dungHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int treHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.treHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int trongQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.trongQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static int quaQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.quaQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTonDauKy_CVDen_ToanCoQuan(int documentRecordTypeId,	Date startDate) {
		
		return dataReport.getListForTonDauKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForNhanTrongKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForNhanTrongKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForDungHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForDungHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTreHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForTreHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForTrongQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId,	Date startDate, Date endDate) {
		
		return dataReport.getListForTrongQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentReceiptLog> getListForQuaQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForQuaQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTonDauKy_CVDi_ToanCoQuan(int documentRecordTypeId,	Date startDate) {
		
		return dataReport.getListForTonDauKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate);
	}
	
	public static List<PmlDocumentSendLog> getListForNhanTrongKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForNhanTrongKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForDungHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForDungHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTreHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForTreHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForTrongQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId,	Date startDate, Date endDate) {
		
		return dataReport.getListForTrongQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlDocumentSendLog> getListForQuaQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		return dataReport.getListForQuaQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
	}
	
	public static List<PmlEdmDocumentReceipt> getListDocumentReceiptForTreHan(long userId, Date date, long statusId) {
		return dataReport.getListDocumentReceiptForTreHan(userId, date, statusId);
	}
	
	public static List<PmlEdmDocumentSend> getListDocumentSendForTreHan(long userId, Date date, long statusId) {
		return dataReport.getListDocumentSendForTreHan(userId, date, statusId);
	}
	
	public static List<PmlEdmDocumentReceipt> getListDocumentReceipt_DaXuLy_TreHan (long userId, Date date, long statusId) {
		return dataReport.getListDocumentReceipt_DaXuLy_TreHan(userId, date, statusId);
	}
	
	public static List<PmlEdmDocumentReceipt> getListDocumentReceipt_DaXuLy (long userId, long statusId, int year) {
		
		return dataReport.getListDocumentReceipt_DaXuLy(userId, statusId, year);
	}
	
	public static List<PmlEdmDocumentSend> getListDocumentSend_DaXuLy_TreHan (long userId, Date date, long statusId) {
		
		return dataReport.getListDocumentSend_DaXuLy_TreHan(userId, date, statusId);
	}
	
	public static List<PmlEdmDocumentSend> getListDocumentSend_DaXuLy (long userId, long statusId, int year) {
		
		return dataReport.getListDocumentSend_DaXuLy(userId, statusId, year);
	}

}
