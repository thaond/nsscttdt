package com.nss.portlet.onedoor.ajax;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.holidaymanagement.service.PmlHolidayLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.PmlStateWorkFlow;
import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.model.PmlWorkflow;
import com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlTransitionLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlWorkflowLocalServiceUtil;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;

public class OnedoorDwr{
	private final static Logger log = Logger.getLogger(OnedoorDwr.class);

	
	/**
	 * Lay danh sach ho so dinh kem khi biet loai ho so. Danh sach tra ve la
	 * list cac doi tuong AttachedFile
	 * 
	 * @param fieldId
	 * @return
	 */	
	public static List<PmlFileTypeAttachedFile> getListPmlFileTypeAttachedFile(String fileTypeId) {		
		List<PmlFileTypeAttachedFile> listResult = new ArrayList<PmlFileTypeAttachedFile>();
		try {			
			listResult = PmlFileTypeAttachedFileLocalServiceUtil.findByFileTypeId(fileTypeId);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR: in method getListPmlFileTypeAttachedFile(), No Find List PmlFileTypeAttachedFile With Id [ "
					+ fileTypeId + " ]");
		}
		return listResult;
	}	
	
	public static List<PmlPaintDocument> getListPmlPaintDocument() {
		return null;
	}
	
	/**
	 * This method gets all PmlFileType 
	 * @return List<PmlFileType>
	 */
	public List<PmlFileType> getPmlFileTypes() {
		List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
		try{
			pmlFileTypeList = PmlFileTypeLocalServiceUtil.findAll();
		}catch (Exception e) {
			log.error("ERROR: in method getPmlFileTypes() "+ OnedoorDwr.class );
		}
		return pmlFileTypeList;
	}
	
	/**
	 * get process time total of a file
	 * @param fileTypeId
	 * @return int
	 *
	 */
	public int getProcessTime(String fileTypeId) {
		int timeTotal = 0;
		try{
		PmlFileType  pmlFileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
		if (pmlFileType != null) {
			timeTotal = Integer.parseInt(pmlFileType.getProcessTime());
		}
		}catch (Exception e) {
			log.error("ERROR: in method getProcessTime() "+ OnedoorDwr.class);
			e.printStackTrace();
		}
		return timeTotal;
	}
	
	/**
	 * so ngay xu ly con lai cua mot ho so
	 * @param expectedreturningdate
	 * @return
	 */
	public static int timeProcessRemainOfFile (Date expectedreturningdate ) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		String stringNow = dateFormat.format(now);
		String stringExpectedreturningdate = dateFormat.format(expectedreturningdate);
		long ngayConNgayNghi =0;
		int ngayKhongNgayNghi = 0;
		try {
			ngayConNgayNghi =((dateFormat.parse(stringExpectedreturningdate)).getTime() - (dateFormat.parse(stringNow)).getTime())/(24*60*60*1000);
		} catch (ParseException e) {
		} 
		int numberDateIncrement = 0;
		if (ngayConNgayNghi > 0) {
			numberDateIncrement = PmlHolidayLocalServiceUtil.checkDateHoliday(stringNow, (int)ngayConNgayNghi);
		}
		else {
			numberDateIncrement = PmlHolidayLocalServiceUtil.checkDateHoliday(stringExpectedreturningdate, Math.abs((int)ngayConNgayNghi));
		}
		ngayKhongNgayNghi = (int) ngayConNgayNghi - numberDateIncrement;
		return ngayKhongNgayNghi;
		
	}
	
	/**
	 * get return date of file
	 * @param numberDate
	 * @param dateReceipt
	 * @return String
	 *
	 */	
	public String getExpectedReturningDate(String numberDate, String dateReceipt){
		int numberDateIncrement = PmlHolidayLocalServiceUtil.checkDateHoliday(dateReceipt, Integer.parseInt(numberDate));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long receipt = (Long.parseLong(numberDate) + numberDateIncrement)* 24 * 60 * 60 * 1000;
		long numberDateReturn = 0;
		String textDate = null;
		try {
			numberDateReturn = receipt + dateFormat.parse(dateReceipt).getTime();
			Date date = new Date (numberDateReturn);
			textDate = dateFormat.format(date);
		} catch (Exception e) {
			log.error("ERROR: in method getExpectedReturningDate() "+ OnedoorDwr.class);
			e.printStackTrace();
		}
		
		return textDate;
	}
	
	/**
	 * get main process path of file
	 * @param fileTypeId
	 * @return List<ProcessTransition>
	 *
	 */
	public List<ProcessTransition> getProcessTransition(String fileTypeId){
		List<ProcessTransition> processTransitionList = new ArrayList<ProcessTransition>();
		try {
			List<PmlTransition> pmlTransitionListTemp = PmlTransitionLocalServiceUtil.findByFileTypeId(fileTypeId);
			if (pmlTransitionListTemp == null || pmlTransitionListTemp.size() == 0) {
				processTransitionList = new ArrayList<ProcessTransition>();
			}
			else {
				PmlWorkflow pmlWorkflow = null;
				
				if (PmlWorkflowLocalServiceUtil.findByFileTypeId(fileTypeId).size() > 0) {
				
				pmlWorkflow = PmlWorkflowLocalServiceUtil.findByFileTypeId(fileTypeId).get(0);
				String version =  new OneDoorProcessLiferayWorkflowService().getVersion(fileTypeId) + "";
				ProcessTransition processTransition = null;
				processTransitionList = new ArrayList<ProcessTransition>();
				long stateProcessNext = 0;
				List<PmlStateWorkFlow> pmlStateWFList = null;
				
				for (PmlTransition pmlTransition : pmlTransitionListTemp) {
					stateProcessNext = pmlTransition.getStateProcessNext();
					pmlStateWFList = PmlStateWorkFlowLocalServiceUtil.findByWorkFlow_StateProcessId_Version(pmlWorkflow.getWorkflow(), stateProcessNext, Integer.parseInt(version));
					if (pmlStateWFList != null && pmlStateWFList.size() > 0 && version.equalsIgnoreCase(pmlTransition.getVersion_())) {
						
						processTransition = new ProcessTransition();
						processTransition.setTransition(pmlTransition.getNoTransition());
						processTransition.setNameTransition(pmlTransition.getTransitionName());
						processTransition.setProcessTime(pmlStateWFList.get(0).getSolvingTime());
						processTransition.setGhiChu("");
						processTransitionList.add(processTransition);
					}
				}
				}
				
			}
		}catch (Exception e) {
			log.error("ERROR: in method getProcessTransition() "+ OnedoorDwr.class);
			e.printStackTrace();
		}
		
		return processTransitionList;
	}
}
