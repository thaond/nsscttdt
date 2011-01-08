package com.sgs.portlet.pcccdocumentreceipt.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.util.PropsUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * 
 * @author 
 * @author XUANCONG 
 *
 */
@SuppressWarnings("static-access")
public class PCCCDocumentUtil {
	
	
	public static final int CAPGOI_TATCA = -1;
	public static final String ACTIVE = "1";

	/**
	 * gets all level send 
	 * @return List<String>
	 *
	 */
	public static List<PmlEdmLevelSend> getLevelSend() {
		List<PmlEdmLevelSend> resultList = new ArrayList<PmlEdmLevelSend>();
		
		try {			
			resultList = PmlEdmLevelSendUtil.findAll();			
		} catch (Exception e) {
			if (resultList == null) {
				resultList = new ArrayList<PmlEdmLevelSend>();
			}
			System.out.println("ERROR: in method getLevelSend "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * get all name issue place from concrete level send
	 * @param levelSendId
	 * @return List<String>
	 *
	 */
	public static List<PmlEdmIssuingPlace> getIssuingPlaces(int levelSendId) {
		List<PmlEdmIssuingPlace> resultList = new ArrayList<PmlEdmIssuingPlace>();
		
		try {
			if (CAPGOI_TATCA == levelSendId) {
				resultList = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlaces(0, PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlacesCount());
			}
			else {
//				resultList = PmlEdmLevelSendLocalServiceUtil.getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
				resultList = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: in method getNameIssuingPlace "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			
		}
		
		return resultList;
	}
	
	/**
	 * get all name of DocumentRecordTo
	 * @param documentRecordToName
	 * @return List<String>
	 *
	 */
	public static List<PmlEdmDocumentType> getDocumentType(int documentRecordTypeid) {
		List<PmlEdmDocumentType> resultList = new ArrayList<PmlEdmDocumentType>();
		
		try {
			resultList = PmlEdmLevelSendLocalServiceUtil.getPmlEdmDocumentTypeWithPmlEdmDocumentRecordType(documentRecordTypeid);
		} catch (Exception e) {
			System.out.println("ERROR: in method getDocumentType "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * get number of document receipt from  documentRecordTo and documentType
	 * @param documentRecordToName
	 * @param documentType
	 * @return String
	 *
	 */
	public static String getNumberDocumentReceipt(int documentRecordTypeId, long documentTypeId, long userId ) {
		String numberResult = null;
		
		try {
			PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			if (pmlEdmDocumentType == null) {
				return numberResult;
			}
			String documentSymbol = pmlEdmDocumentType.getDocumentSymbol();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int yearCurrent = calendar.get(calendar.YEAR);
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);		
			Department  department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearCurrent+"", department.getAgencyId(), documentRecordTypeId);
			int numberDocument = (int) (pmlEdmDocumentRecordTo.getCurrentRecord() + 1);
			numberResult = numberDocument + "/" +documentSymbol;
		} catch (Exception e) {
			System.out.println("ERROR: in method getNumberDocumentReceipt "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		
		return numberResult;
	}

	/**
	 * check book document receipt of department record exists ??? 
	 * @param mainDepartmentId
	 * @param documentReceiptId
	 * @return boolean
	 *
	 */
	public static boolean isBookDocumentRecord(String mainDepartmentId, long documentReceiptId) {
		try {
			//get year current
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());		
			String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
			
			int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(yearInUse, mainDepartmentId, documentRecordTypeId);
			
			if (pmlEdmDocumentRecordTo != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method getNumberDocumentReceipt "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * check book document receipt record of agency exists ??? 
	 * @param mainDepartmentId
	 * @param documentReceiptId
	 * @return boolean
	 *
	 */
	public static boolean isBookDocumentRecordAgency(int documentRecordTypeId, long userId){
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		Department department = null;
		try {
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(userId);
			department = DepartmentUtil.findByPrimaryKey(departmentId);
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = 
				PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearInUse, agencyId, documentRecordTypeId);
			if (pmlEdmDocumentRecordTo != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method isBookDocumentRecordAgency "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	/**
	 * check book document send record of agency exists ??? 
	 * @param mainDepartmentId
	 * @param documentReceiptId
	 * @return boolean
	 *
	 */
	public static boolean isBookDocumentSendAgency(int documentRecordTypeId, long userId){
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		Department department = null;
		try {
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(userId);
			department = DepartmentUtil.findByPrimaryKey(departmentId);
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			
			PmlEdmBookDocumentSend bookDocumentSend =  
				PmlEdmBookDocumentSendLocalServiceUtil
					.getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(agencyId, yearInUse, documentRecordTypeId);
			if (bookDocumentSend != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method isBookDocumentSendRecordAgency "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	/**
	 * check book document send of department record exists ??? 
	 * @param mainDepartmentId
	 * @param documentReceiptId
	 * @return boolean
	 *
	 */
	public static boolean isWriteDocumentSend(String editorDepartmentId, long documentSendId) {
		try {
			//get year current
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());		
			String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
			
			PmlEdmDocumentSend pmlEdmDocumentSend = null;
			try {
				pmlEdmDocumentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
			} catch (Exception e) {
				pmlEdmDocumentSend = null;
			}
			
			if (pmlEdmDocumentSend != null) {
				int documentRecordTypeId = PmlEdmBookDocumentSendLocalServiceUtil.getDocumentRecordTypeIdByDocumentType(pmlEdmDocumentSend.getDocumentTypeId());
				
				PmlEdmBookDocumentSend pmlEdmBookDocumentSend = PmlEdmBookDocumentSendLocalServiceUtil.getBookDocumentSend(yearInUse, editorDepartmentId, documentRecordTypeId);
				if (pmlEdmBookDocumentSend != null) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
		
	}

	
	/*
	 * Tim cong van di theo so hieu cong van
	 */
	
	public static List<PmlEdmDocumentSend> findPmlEdmDocumentSendWithDocumentreference(){
		List<PmlEdmDocumentSend> res = new ArrayList<PmlEdmDocumentSend>();
		List<PmlEdmDocumentSend> listTemp = new ArrayList<PmlEdmDocumentSend>();
		try {
			listTemp = PmlEdmDocumentSendUtil.findAll();
		
		} catch (Exception e) {
		}
		
		for (int i = 0; i < listTemp.size(); i++) {
			if (listTemp.get(i).getDocumentReference() != null && !"".equals(listTemp.get(i).getDocumentReference())) {
				res.add(listTemp.get(i));
			}
		}
		
		return res;
		
	}
	
	/**
	 * Lay so tong hop cua cong van den de tra ve
	 * Neu ngay hop le thi tra ve so >= 1
	 * Neu ngay khong hop le thi tra ve 0
	 */
	public int getGeneralNumberDocumentReceipt(
			String ddmmyyyyReceiveDate) {
		
		try {
			return PmlEdmDocumentReceiptLocalServiceUtil.getGeneralNumberDocumentReceipt(ddmmyyyyReceiveDate);
		}
		catch (Exception ex) {
			return -1;
		}
	}
	
	/**
	 * kiem tra so cong van phuc dap cho cong van den co ton tai hay khong
	 * @param reponsenumberDocument: la so cong van di 
	 */
	
	public boolean checkReponseNumberDocument(String reponsenumberDocument) {
		boolean result = false;
		List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
		try {
			pmlEdmDocumentSendList = PmlEdmDocumentSendUtil.findByDocumentReference(reponsenumberDocument);
		} catch (Exception e) {
			return result;
		}
		
		if (pmlEdmDocumentSendList != null && pmlEdmDocumentSendList.size() > 0) {
			result = true;
		}
		return result;
	}
	

	public static String getNumberDocumentPublish(int documentTypeId, String departmentsId ) {
		String numberResult = null;
		
		try {
			PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			if (pmlEdmDocumentType == null) {
				return numberResult;
			}
//			String documentRecordTypeCode = pmlEdmDocumentRecodeType.getDocumentRecordTypeCode();
			String documentsymbol = pmlEdmDocumentType.getDocumentSymbol();
			String abbreviationAgencyName = PropsUtil.get("abbreviation.agency.name");
			String loaivanbanCVD = PropsUtil.get("type.document.send");
			
			Department  department = DepartmentUtil.findByPrimaryKey(departmentsId);
//			String departmentCode = department.getDepartmentsCode();
			String abbreviateName = department.getAbbreviateName();
			
			int documentCount =	PmlEdmDocumentSendLocalServiceUtil.countDocumentType(documentTypeId, abbreviateName);
			int documentTypeIdCountIncrement = documentCount+1;
			if (pmlEdmDocumentType.getDocumentSymbol().equals(loaivanbanCVD)) {
				numberResult = documentTypeIdCountIncrement+"/"+ abbreviationAgencyName.replaceFirst("-", "") + abbreviateName;
				
			}
			else{
			numberResult = documentTypeIdCountIncrement+"/"+ documentsymbol + abbreviationAgencyName + abbreviateName;
			
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method getNumberDocumentPublish "+PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		
		return numberResult;
	}
	
	/**
	 * Ham tinh so van ban di tra ve theo loai, phong ban va nam phat hanh
	 * @param docTypeId: ma so loai van ba
	 * @param departCreateId: ma so phong ban soan thao de lay phan mo rong
	 * @param issuingYear: nam phat hanh. Neu nhap < 1 thi lay nam hien tai
	 * @return
	 */
	public static String getNumberDocumentPublishByTDY(
			long docTypeId, String departCreateId, int issuingYear) {

		String retVal = "";
		try {
			PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(docTypeId);
			if (pmlEdmDocumentType == null) {
				System.out.println("Loi trong ham getNumberDocumentPublish: khong lay duoc loai van ban.");
				return retVal;
			} // end if
			Department department = DepartmentUtil.findByPrimaryKey(departCreateId);
			if (department == null) {
				System.out.println("Loi trong ham getNumberDocumentPublish: khong lay duoc phong ban.");
				return retVal;
			} // end if

			String documentSymbol = pmlEdmDocumentType.getDocumentSymbol();
			String abbreviationAgencyName = PropsUtil.get("abbreviation.agency.name");
			String loaiVBCVD = PropsUtil.get("type.document.send");
			
			String abbreviateName = department.getAbbreviateName();
			
			// Neu issuingYear < 1 thi lay nam hien tai
			int calYear = issuingYear;
			Calendar cal = Calendar.getInstance();
			if (issuingYear < 1) {
				calYear = cal.get(Calendar.YEAR);
			} // end if
			long nextDocRef = PmlEdmDocumentSendLocalServiceUtil.getMaxDocRefByTypeYear(docTypeId, calYear) + 1;
			// Phat sinh so moi
			if (pmlEdmDocumentType.getDocumentSymbol().equals(loaiVBCVD)) {
				retVal = String.valueOf(nextDocRef) + "/" + abbreviationAgencyName.replaceFirst("-", "") + abbreviateName;
			} // end if
			else {
				retVal = String.valueOf(nextDocRef) + "/" + documentSymbol + abbreviationAgencyName + abbreviateName;
			
			} // end else
		} // end try
		catch (Exception ex) {
			System.out.println("ERROR: in method getNumberDocumentPublish " + PCCCDocumentUtil.class);
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} // end catch
		
		return retVal;
	}
	
	/**
	 * Ham them don vi phat hanh van ban kem theo cap gui cua don vi
	 * @param issuingPlaceId
	 * @param issuingPlaceName
	 * @param signer
	 * @param lstLevelSendId: danh sach ma cap gui, cach nhau bang dau ;
	 * @return
	 */
	public static boolean addPmlEdmIssuingPlaceSL(
			String issuingPlaceId, String issuingPlaceName, String signer, String lstLevelSendId) {
		
		boolean retVal = true;
		try {
			// Kiem tra ma so va ten phai nhap
			if (issuingPlaceId.trim().length() == 0 || issuingPlaceName.trim().length() == 0) {
				return false;
			} // end if
			// Kiem tra ma so khong duoc trung lap
			try {
				if (PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId) != null) {
					return false;
				} // end if
			} // end try
			catch (Exception e) {
				// Do nothing
			} // end catch
			// Goi ham them thong tin don vi gui
			PmlEdmIssuingPlace newItem = PmlEdmIssuingPlaceLocalServiceUtil.addPmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName, "", signer);
			if (newItem == null) {
				return false;
			} // end if
			// Goi ham them cap gui cho don vi gui
			return PmlEdmLevelSendDetailLocalServiceUtil.addPmlEdmLevelSendDetailList(lstLevelSendId, newItem.getPrimaryKey());
		} // end try
		catch (Exception ex) {
			retVal = false;
		} // end catch
		return retVal;
	}

	/**
	 * Ham cap nhat thong tin IssuingPlace
	 * @param issuingPlaceId
	 * @param issuingPlaceName
	 * @param signer
	 * @param lstLevelSendId
	 * @return
	 */
	public static boolean updatePmlEdmIssuingPlace(
			String issuingPlaceId, String issuingPlaceName, String signer, String lstLevelSendId) {
		
		boolean retVal = true;
		try {
			// Kiem tra ma so va ten phai nhap
			if (issuingPlaceId.trim().length() == 0 || issuingPlaceName.trim().length() == 0) {
				return false;
			} // end if
			// Kiem tra don vi da ton tai
			try {
				PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId);
			} // end try
			catch (Exception e) {
				// issuingPlace ko ton tai
				return false;
			} // end catch
			// Goi ham cap nhat thong tin don vi gui
			PmlEdmIssuingPlace editItem = PmlEdmIssuingPlaceLocalServiceUtil.updatePmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName, signer);
			if (editItem == null) {
				return false;
			} // end if
			// Goi ham cap nhat cap gui cho don vi gui
			return PmlEdmLevelSendDetailLocalServiceUtil.updatePmlEdmLevelSendDetailList(lstLevelSendId, editItem.getPrimaryKey());
		} // end try
		catch (Exception ex) {
			retVal = false;
		} // end catch
		return retVal;
	}
	
	/**
	 * Ham lay ve PmlEdmIssuingPlace dua vao ma so issuingPlaceId
	 * @param issuingPlaceId
	 * @return
	 */
	public static PmlEdmIssuingPlace getPmlEdmIssuingPlace(
			String issuingPlaceId) {
		try {
			return PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(issuingPlaceId);
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi goi ham getPmlEdmIssuingPlace tu PCCCDocumentUtil.java");
			return null;
		} // end catch
	}

	/**
	 * Them don vi moi
	 * @param issuingPlaceId
	 * @param issuingPlaceName
	 * @param note
	 * @return
	 */
	public static boolean addPmlEdmIssuingPlace(
			String issuingPlaceId, String issuingPlaceName, String note) {
		
		boolean retVal = true;
		try {
			// Kiem tra ma so va ten phai nhap
			if (issuingPlaceId.trim().length() == 0 || issuingPlaceName.trim().length() == 0) {
				return false;
			} // end if
			// Kiem tra ma so khong duoc trung lap
			try {
				if (PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId) != null) {
					return false;
				} // end if
			} // end try
			catch (Exception e) {
				// Do nothing
			} // end catch
			// Goi ham them thong tin don vi gui
			PmlEdmIssuingPlace newItem = PmlEdmIssuingPlaceLocalServiceUtil.addPmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName, note, "");
			if (newItem == null) {
				return false;
			} // end if
			return true;
		} // end try
		catch (Exception ex) {
			retVal = false;
		} // end catch
		return retVal;
	}
	
	public static int countByDocrefIssyearArrYear(String docRef,
			int issuingYear, boolean findIssuingYear, int arriveYear, 
			boolean findArriveYear) {
		try {
			return PmlEdmDocumentReceiptLocalServiceUtil.countByDocrefIssyearArrYear(
				docRef, issuingYear, findIssuingYear, arriveYear, findArriveYear);
		} catch (Exception ex) {
			System.out.println("Co loi khi goi ham countByDocrefIssyearArrYear tu PCCCDocumentUtil.java");
			return -1;
		} // end catch
	}
	
	/**
	 * lay so cong van theo loai cong van duoc chon 11/11/2010
	 */
	public static PmlEdmDocumentRecordType getDocumentRecordByDocType(int documentTypeId) {
		PmlEdmDocumentType documentType = null;
		PmlEdmDocumentRecordType result = null;
		try {
			documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			if(documentType!=null){
				int docRecordTypeId = documentType.getDocumentRecordTypeId();
				if(docRecordTypeId != 0) {
					result = PmlEdmDocumentRecordTypeUtil.findByPrimaryKey(docRecordTypeId);
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method getDocumentRecordByDocType " + PCCCDocumentUtil.class);
			System.out.println(e.getMessage());
		}

		return result;
	}
	
	/**
	 * phmphuc update 01/12/2010 - gan them phan mo rong phong ban cho vb di phat hanh
	 */
	// lay so hieu cho vb di phat hanh
	public static long getSoHieuVB(long docTypeId) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		
		long result = 0;
		try {
			result = PmlEdmDocumentSendLocalServiceUtil.getMaxDocRefByTypeYear(docTypeId, year) + 1;
		}
		catch (Exception ex) {
			System.out.println("ERROR: in method getSoHieuVB " + PCCCDocumentUtil.class);
		}
		
		return result;
	}
	
	// lay phan mo rong cho vb di phat hanh
	public static String getPhanMoRong(long docTypeId, String departCreateId) {
		String phanMoRong = "";
		PmlEdmDocumentType documentType = null;
		Department department = null;
		try {
			documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(docTypeId);
			
			department = DepartmentUtil.findByPrimaryKey(departCreateId);
			
			String documentSymbol = documentType.getDocumentSymbol();
			String abbreviationAgencyName = PropsUtil.get("abbreviation.agency.name");
			
			String abbreviateName = department.getAbbreviateName();
			
			phanMoRong += "/";
			if ((documentSymbol != null) && !documentSymbol.equals("")) {
				phanMoRong += documentSymbol + "-";
			}
			
			if (documentType.getHaveDepartExtends() == true) {
				phanMoRong += abbreviationAgencyName.replaceFirst("-", "") + abbreviateName;
			}
			else {
				phanMoRong += abbreviationAgencyName.replaceAll("-", "");
			}
		} 
		catch (Exception ex) {
			System.out.println("ERROR: in method getPhanMoRong " + PCCCDocumentUtil.class);
			System.out.println(ex.getMessage());
		} 
		
		return phanMoRong;
	}
	
	// phmphuc add 05/01/2011 - ham kiem tra so den theo so theo nam co ton tai trong csdl chua
	public static int countByNumberDocumentReceipt(String numberDocumentReceipt, int issuingYear, long documentReceiptId) {
		try {
			return PmlEdmDocumentReceiptLocalServiceUtil.countByNumberDocumentReceipt(numberDocumentReceipt, issuingYear, documentReceiptId);
		} catch (Exception ex) {
			System.out.println("Co loi khi goi ham countByNumberDocumentReceipt tu PCCCDocumentUtil.java");
			return -1;
		} // end catch
	}
	
	// ham kiem tra so hieu trung cho edit
	public static int countByDocumentReference(String documentReference, int issuingYear, long documentReceiptId) {
		try {
			return PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReference(documentReference, issuingYear, documentReceiptId);
		} catch (Exception ex) {
			System.out.println("Co loi khi goi ham countByDocrefIssyearArrYear tu PCCCDocumentUtil.java");
			return -1;
		} // end catch
	}
}

