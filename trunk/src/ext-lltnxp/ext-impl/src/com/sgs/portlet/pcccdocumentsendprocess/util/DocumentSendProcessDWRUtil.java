package com.sgs.portlet.pcccdocumentsendprocess.util;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.util.PropsUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;

public class DocumentSendProcessDWRUtil {
	
	// lay so hieu cho vb di phat hanh
	public static long getSoHieuVB(long docTypeId, boolean numOfDirector) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		
		long result = 0;
		try {
			result = PmlEdmDocumentSendLocalServiceUtil.getSoPhatHanhVBDi(docTypeId, year, numOfDirector) + 1;
		}
		catch (Exception ex) {
			System.out.println("ERROR: in method getSoHieuVB " + DocumentSendProcessDWRUtil.class);
		}
		
		return result;
	}
	
	
	// lay phan mo rong cho vb di phat hanh
	public static String getPhanMoRong(long docTypeId, String departCreateId, boolean numOfDirector) {
		String phanMoRong = "";
		PmlEdmDocumentType documentType = null;
		Department department = null;
		try {
			documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(docTypeId);
			
			department = DepartmentUtil.findByPrimaryKey(departCreateId);
			
			String documentSymbol = documentType.getDocumentSymbol();
			String maVanPhong = PropsUtil.get("abbreviation.agency.name");
			String soGiamDoc = PropsUtil.get("congvan.den.morong");
			
			String maDoi = department.getAbbreviateName();
			
			phanMoRong += "/" + documentSymbol ;
			if (numOfDirector == true) {
				phanMoRong += soGiamDoc.replace("/", "-") + "(" + maVanPhong.replaceFirst("-", "") + ")";
			}
			else {
				phanMoRong += maVanPhong + maDoi;
			}
		} 
		catch (Exception ex) {
			System.out.println("ERROR: in method getPhanMoRong " + DocumentSendProcessDWRUtil.class);
			System.out.println(ex.getMessage());
		} 
		
		return phanMoRong;
	}

	// phmphuc add 07/01/2011 - ham kiem tra so va ky hieu cho vb phat hanh theo nam co ton tai trong csdl chua
	public static int kiemTraSoVaKyHieuVBPhatHanh(String soVBPhatHanh, int issuingYear, long documentSendId) {
		try {
			return PmlEdmDocumentSendLocalServiceUtil.kiemTraSoVaKyHieuVBPhatHanh(soVBPhatHanh, issuingYear, documentSendId);
		} catch (Exception ex) {
			System.out.println("ERROR: in method kiemTraSoVaKyHieuVBPhatHanh " + DocumentSendProcessDWRUtil.class);
			return -1;
		}
	}
}
