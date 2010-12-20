package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.base.PmlFilePCCCLocalServiceBaseImpl;

public class PmlFilePCCCLocalServiceImpl extends PmlFilePCCCLocalServiceBaseImpl {
	public List<PmlOneDoorReceiveFile> filter (List<PmlOneDoorReceiveFile> list, String fileId, String fileName, String applicantName, 
			String address,	String telephone, String email, long fileStatusId, String fileType, Date receiveFromDate, 
			Date receiveToDate, Date expectedReturningFromDate,
			Date expectedReturningToDate, Date expiredFromDate, Date expiredToDate,
			Date exactReturningFromDate, Date exactReturningToDate) {
	
		List<PmlOneDoorReceiveFile> retValue = filterByFileId(list, fileId);
		retValue = filterByFileName(retValue, fileName);
		retValue = filterByApplicantName(retValue, applicantName);
		retValue = filterByAddress(retValue, address);
		retValue = filterByTelephone(retValue, telephone);
		retValue = filterByEmail(retValue, email);
		retValue = filterByFileStatus(retValue, fileStatusId);
		retValue = filterByFileType(retValue, fileType);
		
		retValue = filterByReceiveFromDate(retValue, receiveFromDate);
		retValue = filterByReceiveToDate(retValue, receiveToDate);
		retValue = filterByExpectedReturningFromDate(retValue, expectedReturningFromDate);
		retValue = filterByExpectedReturningToDate(retValue, expectedReturningToDate);
		retValue = filterByExpiredFromDate(retValue, expiredFromDate);
		retValue = filterByExpiredToDate(retValue, expiredToDate);
		retValue = filterByExactReturningFromDate(retValue, exactReturningFromDate);
		retValue = filterByExactReturningToDate(retValue, exactReturningToDate);
		
		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByExactReturningFromDate(List<PmlOneDoorReceiveFile> list, Date exactReturningFromDate) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || exactReturningFromDate == null || exactReturningFromDate.toString().equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			Date exactReturningDate = item.getExactReturningDate();
			if (exactReturningDate != null) {
				if (exactReturningDate.after(exactReturningFromDate) || exactReturningDate.equals(exactReturningFromDate)) {
					retValue.add(item);
				} else if (exactReturningDate == null) {
					return list;
				}
			}
		}

		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByExactReturningToDate(List<PmlOneDoorReceiveFile> list, Date exactReturningToDate) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || exactReturningToDate == null || exactReturningToDate.toString().equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			Date exactReturningDate = item.getExactReturningDate();
			if (exactReturningDate != null) {
				if (exactReturningDate.before(exactReturningToDate) || exactReturningDate.equals(exactReturningToDate)) {
					retValue.add(item);
				} else if (exactReturningDate == null) {
					return list;
				}
			}
		}

		return retValue;
	}

	private List<PmlOneDoorReceiveFile> filterByExpiredToDate(List<PmlOneDoorReceiveFile> list, Date expiredToDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || expiredToDate == null || expiredToDate.toString().equals("")) {
			return list;
		}
		
		List<PmlProcessDispose> listProcessDispose = getListProcessDisposeToDate(list, expiredToDate);
		
		for (PmlProcessDispose pmlProcessDispose : listProcessDispose) {
			String fileId = pmlProcessDispose.getFileId();
			if (fileId != null) {
				try {
					retValue.add(PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId));
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	private List<PmlProcessDispose> getListProcessDisposeToDate(List<PmlOneDoorReceiveFile> list, Date expiredToDate) {

		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		if (list == null || expiredToDate == null || expiredToDate.toString().equals("")) {
			return retValue;
		}
		
		List<PmlProcessDispose> list2 = null;
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileId = pmlOneDoorReceiveFile.getFileId();
			if (fileId != null) {
				try {
					list2 = PmlProcessDisposeLocalServiceUtil.findByFileId(fileId);
					for (PmlProcessDispose pmlProcessDispose : list2) {
						Date expiredDate = pmlProcessDispose.getExpiredDate();
						if (expiredDate != null) {
							if (expiredDate.before(expiredToDate) || expiredDate.equals(expiredToDate)) {
								if (retValue.contains(pmlProcessDispose)) {
									continue;
								}
								retValue.add(pmlProcessDispose);
							}
						}
					}
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByExpiredFromDate(List<PmlOneDoorReceiveFile> list, Date expiredFromDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || expiredFromDate == null || expiredFromDate.toString().equals("")) {
			return list;
		}
		
		List<PmlProcessDispose> listProcessDispose = getListProcessDisposeFromDate(list, expiredFromDate);
		
		for (PmlProcessDispose pmlProcessDispose : listProcessDispose) {
			String fileId = pmlProcessDispose.getFileId();
			if (fileId != null) {
				try {
					retValue.add(PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId));
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	private List<PmlProcessDispose> getListProcessDisposeFromDate(List<PmlOneDoorReceiveFile> list, Date expiredFromDate) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		if (list == null || expiredFromDate == null || expiredFromDate.toString().equals("")) {
			return retValue;
		}
		
		List<PmlProcessDispose> list2 = null;
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileId = pmlOneDoorReceiveFile.getFileId();
			if (fileId != null) {
				try {
					list2 = PmlProcessDisposeLocalServiceUtil.findByFileId(fileId);
					for (PmlProcessDispose pmlProcessDispose : list2) {
						Date expiredDate = pmlProcessDispose.getExpiredDate();
						if (expiredDate != null) {
							if (expiredDate.after(expiredFromDate) || expiredDate.equals(expiredFromDate)) {
								if (retValue.contains(pmlProcessDispose)) {
									continue;
								}
								retValue.add(pmlProcessDispose);
							}
						}
					}
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByExpectedReturningToDate(List<PmlOneDoorReceiveFile> list, Date expectedReturningToDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || expectedReturningToDate == null || expectedReturningToDate.toString().equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			Date expectedReturningDate = pmlOneDoorReceiveFile.getExpectedReturningDate();
			if (expectedReturningDate != null) {
				if ((expectedReturningDate.before(expectedReturningToDate) || expectedReturningDate.equals(expectedReturningToDate))) {
					retValue.add(pmlOneDoorReceiveFile);
				} else if (expectedReturningDate == null) {
					return list;
				}
			}
		}

		return retValue;
	}

	private List<PmlOneDoorReceiveFile> filterByExpectedReturningFromDate(List<PmlOneDoorReceiveFile> list, Date expectedReturningFromDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || expectedReturningFromDate == null || expectedReturningFromDate.toString().equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			Date expectedReturningDate = pmlOneDoorReceiveFile.getExpectedReturningDate();
			if (expectedReturningDate != null) {
				if ((expectedReturningDate.after(expectedReturningFromDate) || expectedReturningDate.equals(expectedReturningFromDate))) {
					retValue.add(pmlOneDoorReceiveFile);
				} else if (expectedReturningDate == null) {
					return list;
				}
			}
		}

		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByReceiveToDate(List<PmlOneDoorReceiveFile> list, Date receiveToDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || receiveToDate == null || receiveToDate.toString().equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			Date applicationDate = pmlOneDoorReceiveFile.getApplicationDate(); // lay ra ngay nhan ho so
			if (applicationDate != null) {
				if (applicationDate.before(receiveToDate) || applicationDate.equals(receiveToDate)) {
					retValue.add(pmlOneDoorReceiveFile);
				} else if (applicationDate == null) {
					return list;
				}
			}
		}

		return retValue;
	}

	/**
	 * Phuong thuc nay dung de lay danh sach ho so co ngay nhan bang hoac sau ngay nhap vo de tim kiem
	 * @param list
	 * @param receiveFromDate
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> filterByReceiveFromDate(List<PmlOneDoorReceiveFile> list, Date receiveFromDate) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || receiveFromDate == null || (receiveFromDate.toString().equals(""))) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			Date applicationDate = pmlOneDoorReceiveFile.getApplicationDate(); // lay ra ngay nhan ho so
			if (applicationDate != null) {
				if (applicationDate.after(receiveFromDate) || applicationDate.equals(receiveFromDate)) {
					retValue.add(pmlOneDoorReceiveFile);
				}
			} else if (applicationDate == null) {
				return list;
			}
		}

		return retValue;
	}
	
	
	private List<PmlOneDoorReceiveFile> filterByFileType(List<PmlOneDoorReceiveFile> list, String fileType) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || fileType == null || fileType.equals("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileTypeId = pmlOneDoorReceiveFile.getFileTypeId();
			if (fileTypeId != null) {
				if (fileTypeId.equals(fileType)) {
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay danh sach PmlOneDoorReceiveFile theo fileStatusId : list2
	 * Ket qua tra ve la phan giao cua hai danh sach list va list2
	 * 
	 * @param list
	 * @param fileStatus
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> filterByFileStatus(List<PmlOneDoorReceiveFile> list, long fileStatusId) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || fileStatusId == 0) {
			return list;
		}
		
		List<PmlOneDoorReceiveFile> list2 = getListFileByFileStatus(fileStatusId, list);
		list.retainAll(list2);
		retValue = list;

		return retValue;
	}


	/**
	 * Hien tai chua co chuc nang tim kiem theo email.
	 * @param list
	 * @param email
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> filterByEmail(List<PmlOneDoorReceiveFile> list, String email) {

		if (list == null || email == null || email.equals("")) {
			return list;
		}

		return list;
	}

	private List<PmlOneDoorReceiveFile> filterByTelephone(List<PmlOneDoorReceiveFile> list, String telephone) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || telephone == null || "".equals(telephone)) {
			return list;
		}
		
		// get List<PmlFilePCCC> by List<PmlOneDoorReceiveFile> and fileName
		List<PmlFilePCCC> listFilePCCC = getListFilePCCCByTelephone(list, telephone);
		
		// get List<PmlOneDoorReceiveFile> by List<PmlFilePCCC>
		retValue = getListFileByListFilePCCC(listFilePCCC);
		
		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByAddress(List<PmlOneDoorReceiveFile> list, String address) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || address == null || "".equals(address)) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String permanentAddress = pmlOneDoorReceiveFile.getPermanentAddress();
			if (permanentAddress != null) {
				if (permanentAddress.toLowerCase(new Locale("vi")).indexOf(address.toLowerCase(new Locale("vi"))) != -1) {
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}

		return retValue;
	}
	
	private List<PmlOneDoorReceiveFile> filterByApplicantName(List<PmlOneDoorReceiveFile> list, String applicantName) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || applicantName == null || ("".equals(applicantName))) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String applicantname = pmlOneDoorReceiveFile.getApplicantName();
			if (applicantname != null) {
				if (applicantname.toLowerCase(new Locale("vi")).indexOf(applicantName.toLowerCase(new Locale("vi"))) != -1) {
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}

		return retValue;
	}
	
	/** 
	 * Phuong thuc nay dung de lay danh sach theo ma ho so.<br>
	 * Tim nhung ho so co ma ho so chua fileId truyen vao.<br>
	 * @param list
	 * @param fileId
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> filterByFileId(List<PmlOneDoorReceiveFile> list, String fileId) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || fileId == null || "".equals(fileId)) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileid = pmlOneDoorReceiveFile.getFileId();
			if (fileid != null) {
				if (fileid.toUpperCase().indexOf(fileId.toUpperCase()) != -1) {
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}

		return retValue;
	}
	
	/**
	 * Lay List<PmlFilePCCC> theo list va fileName. Danh sach nay loc nhung ho so co ten giong voi ten truyen vao (fileName)
	 * Lay List<PmlOneDoorReceiveFile> theo List<PmlFilePCCC> o tren.
	 * 
	 * @param list
	 * @param fileName : lay o bang PmlFilePCCC
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> filterByFileName(List<PmlOneDoorReceiveFile> list, String fileName) {

		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null || fileName == null || "".equals(fileName)) {
			return list;
		}
		
		// get List<PmlFilePCCC> by List<PmlOneDoorReceiveFile> and fileName
		List<PmlFilePCCC> listFilePCCC = getListFilePCCC(list, fileName);
		
		// get List<PmlOneDoorReceiveFile> by List<PmlFilePCCC>
		retValue = getListFileByListFilePCCC(listFilePCCC);
		
		return retValue;
	}
	/**
	 * Lay List<PmlFilePCCC> tu list va co ten ho so giong voi fileName truyen vao.<br>
	 * @param list
	 * @param fileName
	 * @return
	 */
	private List<PmlFilePCCC> getListFilePCCC(List<PmlOneDoorReceiveFile> list, String fileName) {
		
		List<PmlFilePCCC> retValue = new ArrayList<PmlFilePCCC>();
		
		if (list == null || fileName == null) {
			return retValue;
		}
		
		PmlFilePCCC filePCCC = null;
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileId = pmlOneDoorReceiveFile.getFileId();
			if (fileId != null) {
				try {
					filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
					String filename = filePCCC.getFileName();
					if (filename != null) {
						if (filename.toLowerCase(new Locale("vi")).indexOf(fileName.toLowerCase(new Locale("vi"))) != -1) {
							retValue.add(filePCCC);
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}

	/**
	 * @param listFilePCCC
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> getListFileByListFilePCCC(List<PmlFilePCCC> listFilePCCC) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (listFilePCCC == null) {
			return retValue;
		}
		
		for (PmlFilePCCC pmlFilePCCC : listFilePCCC) {
			String fileId = pmlFilePCCC.getFileId();
			if (fileId != null) {
				try {
					retValue.add(PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId));
				}
				catch (NoSuchPmlOneDoorReceiveFileException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}

	private List<PmlFilePCCC> getListFilePCCCByTelephone(List<PmlOneDoorReceiveFile> list, String telephone) {

		List<PmlFilePCCC> retValue = new ArrayList<PmlFilePCCC>();
		
		if (list == null || telephone == null || "".equals(telephone)) {
			return retValue;
		}
		
		PmlFilePCCC filePCCC = null;
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
			String fileId = pmlOneDoorReceiveFile.getFileId();
			if (fileId != null) {
				try {
					filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
					String applicantTelephone = filePCCC.getApplicantTelephone();
					if (applicantTelephone != null) {
						if (applicantTelephone.equalsIgnoreCase(telephone)) {
							retValue.add(filePCCC);
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}

	private List<PmlOneDoorReceiveFile> getListFileByFileStatus(long fileStatusId, List<PmlOneDoorReceiveFile> list) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (list == null) {
			return retValue;
		}
		
		String fileIdFromList = "";
		
		List<PmlProcessDispose> listProcessDispose = getListProcessDispose(fileStatusId);
		if (listProcessDispose != null && listProcessDispose.size() > 0) {
			for (PmlProcessDispose pmlProcessDispose : listProcessDispose) {
				String fileId = pmlProcessDispose.getFileId();
				if (fileId != null) {
					try {
						for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : list) {
							fileIdFromList = pmlOneDoorReceiveFile.getFileId();
							
							if (fileId.equals(fileIdFromList)) {
								PmlOneDoorReceiveFile oneDoorReceiveFile = null;
								try {
									oneDoorReceiveFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
								} catch (PortalException e) {
									oneDoorReceiveFile = null;
								}
								
								retValue.add(oneDoorReceiveFile);
							}
						}
					}
					catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return retValue;
	}

	private List<PmlProcessDispose> getListProcessDispose(long fileStatusId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		List<PmlStateProcess> listStateProcess = getListStateProcessByFileStatusId(fileStatusId);
		if (listStateProcess != null && listStateProcess.size() > 0) {
			for (PmlStateProcess pmlStateProcess : listStateProcess) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
					List<PmlProcessDispose> pmlProcessDispose = PmlProcessDisposeLocalServiceUtil.findByStateProcessIdBefore(stateProcessId);
					if (retValue.contains(pmlProcessDispose)) {
						continue;
					}
					retValue.addAll(pmlProcessDispose);
			}
		}

		return retValue;
	}
	
	private List<PmlStateProcess> getListStateProcessByFileStatusId(long fileStatusId) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		retValue = PmlStateProcessLocalServiceUtil.findByFileStatusId(fileStatusId);

		return retValue;
	}

}
