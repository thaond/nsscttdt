package com.sgs.portlet.documentdelegate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.service.base.PmlDocumentDelegateLocalServiceBaseImpl;
import com.sgs.portlet.pmluser.model.PmlUser;


public class PmlDocumentDelegateLocalServiceImpl
    extends PmlDocumentDelegateLocalServiceBaseImpl {
	
	public List<PmlDocumentDelegate> getPmlDocumentDelegate_ALLUSERISDELEGATE(int start, int end, OrderByComparator obc){
				try {
					return pmlDocumentDelegateFinder.findBy_ALLUSERISDELEGATE(start, end, obc);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				return new ArrayList<PmlDocumentDelegate>();
		
	}
	
	public List<PmlDocumentDelegate> getPmlDocumentDelegate_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate, int start, int end, OrderByComparator obc){
				try {
					return pmlDocumentDelegateFinder.findBy_SD_TD_USERISDELEGATE(userDelegate, 
							fromDateDelegate, toDateDelegate, listUserIsDelegate, start, end, obc);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				return new ArrayList<PmlDocumentDelegate>();
		
	}
	
	public int countPmlDocumentDelegate_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate){
				try {
					return pmlDocumentDelegateFinder.countBy_SD_TD_USERISDELEGATE(userDelegate, 
							fromDateDelegate, toDateDelegate, listUserIsDelegate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			return -1;
		
	}
	
	// lay danh sach nguoi uy quyen - chuyen vien lay danh sach lanh dao uy quyen
	public List<PmlUser> getDanhSachNguoiUyQuyen(long userIsDelegateId, int start, int end, OrderByComparator obc) {
		try {
			return pmlDocumentDelegateFinder.getDanhSachNguoiUyQuyen(userIsDelegateId, start, end, obc);
		} catch (SystemException e) {
			return new ArrayList<PmlUser>();
		}
	}
	
	public int countDanhSachNguoiUyQuyen(long userIsDelegateId) {
		try {
			return pmlDocumentDelegateFinder.countDanhSachNguoiUyQuyen(userIsDelegateId);
		} catch (SystemException e) {
			return -1;
		}
	}
	
	// lay danh sach nguoi duoc uy quyen - lanh dao lay danh sach chuyen vien duoc uy quyen
	public List<PmlUser> getDanhSachNguoiDuocUyQuyen(long userDelegateId, int start, int end, OrderByComparator obc) {
		try {
			return pmlDocumentDelegateFinder.getDanhSachNguoiDuocUyQuyen(userDelegateId, start, end, obc);
		} catch (SystemException e) {
			return new ArrayList<PmlUser>();
		}
	}
	
	public int countDanhSachNguoiDuocUyQuyen(long userDelegateId) {
		try {
			return pmlDocumentDelegateFinder.countDanhSachNguoiDuocUyQuyen(userDelegateId);
		} catch (SystemException e) {
			return -1;
		}
	}
	
	// dem so luong van ban den duoc xu ly thay
	public int countNumOfDocumentReceiptIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, Date toDate) throws SystemException {
		return pmlDocumentDelegateFinder.countNumOfDocumentReceiptIsDelegated(userDelegateId, userIsDelegateId, fromDate, toDate);
	}
	
	public List<PmlEdmDocumentReceipt> getNumOfDocumentReceiptIsDelegated(long userDelegateId, long userIsDelegateId, 
			Date fromDate, Date toDate, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlDocumentDelegateFinder.getNumOfDocumentReceiptIsDelegated(userDelegateId, userIsDelegateId, fromDate, toDate, start, end, obc);
	}
	
	// dem so luong van ban di duoc xu ly thay
	public int countNumOfDocumentSendIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, Date toDate) throws SystemException {
		return pmlDocumentDelegateFinder.countNumOfDocumentSendIsDelegated(userDelegateId, userIsDelegateId, fromDate, toDate);
	}
	
	public List<PmlEdmDocumentSend> getNumOfDocumentSendIsDelegated(long userDelegateId, long userIsDelegateId, 
			Date fromDate, Date toDate, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlDocumentDelegateFinder.getNumOfDocumentSendIsDelegated(userDelegateId, userIsDelegateId, fromDate, toDate, start, end, obc);
	}
}
