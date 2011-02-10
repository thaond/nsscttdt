package com.sgs.portlet.onedoorpccc.ajax;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoorpccc.model.PmlPaintDocument;
import com.sgs.portlet.onedoorpccc.model.PmlTransition;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTransitionUtil;

public class OnedoorDwr {
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
			listResult = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
			
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
			List<PmlFileType> pmlFileTypeListTemp = PmlFileTypeUtil.findAll();
		if (pmlFileTypeList == null) {
			return pmlFileTypeList;
		}
		
		pmlFileTypeList = pmlFileTypeListTemp;
		
		}catch (Exception e) {
			e.printStackTrace();
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
		PmlFileType  pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
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
		List<ProcessTransition> processTransitionList = null;
		try {
			List<PmlTransition> pmlTransitionListTemp = PmlTransitionUtil.findByFileTypeId(fileTypeId);
			if (pmlTransitionListTemp == null || pmlTransitionListTemp.size() == 0) {
				processTransitionList = new ArrayList<ProcessTransition>();
			}
			else {
				PmlWorkflow pmlWorkflow = PmlWorkflowUtil.findByFileTypeId(fileTypeId).get(0);
				
				String version =  new OneDoorProcessLiferayWorkflowService().getVersion(fileTypeId) + "";
				ProcessTransition processTransition = null;
				processTransitionList = new ArrayList<ProcessTransition>();
				long stateProcessNext = 0;
				List<PmlStateWorkFlow> pmlStateWFList = null;
				
				for (PmlTransition pmlTransition : pmlTransitionListTemp) {
					stateProcessNext = pmlTransition.getStateProcessNext();
//					pmlStateWFList = PmlStateWorkFlowUtil.findByStateProcessId(stateProcessNext);
					pmlStateWFList = PmlStateWorkFlowUtil.findByWorkFlow_StateProcessId_Version(pmlWorkflow.getWorkflow(), stateProcessNext, Integer.parseInt(version));
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
		}catch (Exception e) {
			log.error("ERROR: in method getProcessTransition() "+ OnedoorDwr.class);
			e.printStackTrace();
		}
		return processTransitionList;
	}
	public static void main(String[] args) {
//		System.out.println(new OnedoorDwr().getExpectedReturningDate("10","23/04/2009"));
//		System.out.println(OnedoorDwr.timeProcessRemainOfFile("24/10/2009"));
	}
}
