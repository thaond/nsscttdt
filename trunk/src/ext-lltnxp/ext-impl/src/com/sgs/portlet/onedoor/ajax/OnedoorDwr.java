package com.sgs.portlet.onedoor.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.service.persistence.AttachedFileUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.service.impl.PmlOneDoorReceiveFileLocalServiceImpl;
import com.sgs.portlet.onedoor.util.OneDoorUtil;

public class OnedoorDwr {
	private final static Logger log = Logger.getLogger(OneDoorUtil.class);

	/**
	 * Lay ngay du dinh hoan tra ho so. Mo loai ho so co thoi gian xu ly rieng.
	 * Lay ngay tra ve bang cach lay ngay hien tai + so ngay xu ly cua ho so
	 * 
	 * @param fileTypeId
	 * @return
	 */
	public static String getExpectedReturingDate(String fileTypeId) {
		int solvingTime = getSolvingTime(fileTypeId);
		Date today = new Date();
		
		Date receiveDay = new Date(today.getTime() + solvingTime*24*60*60*1000);
		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(receiveDay);
	}
	/**
	 * Lay danh sach ho so dinh kem khi biet loai ho so. Danh sach tra ve la
	 * list cac doi tuong AttachedFile
	 * 
	 * @param fieldId
	 * @return
	 */
	
	
	
	public static List<PmlFileTypeAttachedFile> getListPmlFileTypeAttachedFile(String fileTypeId) {
		List<PmlFileTypeAttachedFile> listAttachedFiles = new ArrayList<PmlFileTypeAttachedFile>();
		List<PmlFileTypeAttachedFile> listResult = new ArrayList<PmlFileTypeAttachedFile>();
		try {
			PmlOneDoorReceiveFileLocalServiceImpl pODRFLSI = new PmlOneDoorReceiveFileLocalServiceImpl();			
			listAttachedFiles = pODRFLSI.getFileTypeAttachedFileByFileTypeId(fileTypeId);
			AttachedFile pmlAttachedFile = null;
			for(PmlFileTypeAttachedFile pmlFileTypeAttachedFile:listAttachedFiles){
				pmlAttachedFile = AttachedFileUtil.fetchByPrimaryKey(pmlFileTypeAttachedFile.getAttachedFileId());
				pmlFileTypeAttachedFile.setAttachedFileName(pmlAttachedFile.getAttachedFileName());
				listResult.add(pmlFileTypeAttachedFile);
			}
		} catch (Exception e) {
			log.error("ERROR: No Find List PmlFileAttachedFile With Id [ "
					+ fileTypeId + " ]");
		}
		return listResult;
	}
	
	public static int getSolvingTime(String fileTypeId) {
		PmlFileType fileType = null;
		try {
			fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
			return Integer.parseInt(fileType.getProcessTime());
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
