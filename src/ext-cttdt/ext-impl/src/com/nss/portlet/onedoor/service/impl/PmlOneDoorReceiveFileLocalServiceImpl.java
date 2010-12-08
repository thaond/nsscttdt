package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.service.base.PmlOneDoorReceiveFileLocalServiceBaseImpl;


public class PmlOneDoorReceiveFileLocalServiceImpl
    extends PmlOneDoorReceiveFileLocalServiceBaseImpl {
	
	public int getGeneralNumberReceipt(
			String ddmmyyyyReceiveDate) 
	throws SystemException {
		
		try {
			return pmlOneDoorReceiveFileFinder.getGeneralNumberReceipt(
					ddmmyyyyReceiveDate);
		}
		catch (Exception ex) {
			return -1;
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc)throws Exception {
		return pmlOneDoorReceiveFileFinder.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileNeedProcess(long userId, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileNeedProcess(userId,  typeList, valueTypeList, start, end, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	
	}
	
	public List<PmlOneDoorReceiveFile> getListFileDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileDelegated(userId,  typeList, valueTypeList, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
		
	}
	
	public List<PmlOneDoorReceiveFile> getListFileIsDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileIsDelegated(userId,  typeList, valueTypeList, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
		
	}
	
	public List<PmlOneDoorReceiveFile> search(String numberreceipt, String filename, String applicantname,
			String permanentaddress, String telephone, String filetypeid, String tuNgayTiepNhan,
			String denNgayTiepNhan, String tuNgayHenTra, String denNgayHenTra, 
			String tuNgayHSHoanThanh, String denNgayHSHoanThanh, String tuNgayHSTraThuc, String denNgayHSTraThuc,
			List<String> typeList, List<String> valueTypeList, int start, int end,  OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.search(numberreceipt, filename, applicantname,
					permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
					denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, 
					tuNgayHSHoanThanh, denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc,
					typeList, valueTypeList, start, end, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId) {
		try {
			return pmlOneDoorReceiveFilePersistence.findByFileTypeId(fileTypeId);
		} catch (SystemException e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> findByPMLFILERETURN(List<String> fileTypeIds, int year, List<String> typeList,
			List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.findByPMLFILERETURN(fileTypeIds, year, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(long userId, int year, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(List<PmlFileType> fileTypeList, String fromDate, List<String> typeList,
			List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoLuongHSTonBCThang(fileTypeList, fromDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoLuongHSNhanTrongThang(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoLuongTongHS(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoLuongTongHS(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoHSHoanThanhDungHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoHSHoanThanhTreHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoHSDangThuLyDungHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoHSDangThuLyTreHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> getSoHSChoBoSung(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getSoHSChoBoSung(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
	}
}
