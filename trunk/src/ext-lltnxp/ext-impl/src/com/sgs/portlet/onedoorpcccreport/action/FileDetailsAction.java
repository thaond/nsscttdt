package com.sgs.portlet.onedoorpcccreport.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;

public class FileDetailsAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				//List<PmlFilePcccDTO> pmlFilePcccList = new ArrayList<PmlFilePcccDTO>();
				String columeName = ParamUtil.getString(req, "columeName", "");
				String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
				Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "fromDate"));
				Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(ParamUtil.getString(req, "toDate"));
				req.setAttribute("pmlFilePcccList", getPmlFilePcccList(columeName, fileTypeId, fromDate, toDate));
				
				return mapping.findForward("portlet.sgs.onedoorpcccreport.filedetails");
			}
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccList(String columeName, String fileTypeId, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		if(Validator.isNull(columeName) == false) {
			
			List<PmlOneDoorReceiveFile> pmlFilePCCCList = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			int pmlFilePCCCSize = pmlFilePCCCList.size();
			
			if (columeName.equals("tensanpham")) {
				res = layDanhSachHoSoTheoTenSanPham(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("tondauky")) {
				res = layDanhSachHoSoTheoTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("nhantrongthang")) {
				res = layDanhSachHoSoTheoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("tongcong")) {
				res = layDanhSachHoSoTheoTongCong(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("sodunghan")) {
				res = layDanhSachHoSoTheoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("sotrehan")) {
				res = layDanhSachHoSoTheoSoTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("tronghan")) {
				res = layDanhSachHoSoTheoTrongHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("datrehan")) {
				res = layDanhSachHoSoTheoDaTreHan(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			} else if (columeName.equals("chinhsuabosung")) {
				res = layDanhSachHoSoTheoChinhSuaBoSung(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
			}
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoTenSanPham(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((c1.before(applicationDate) || c1.equals(applicationDate)) && (c2.after(applicationDate) || c2.equals(applicationDate))) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoTonDauKy(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();		
				
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				//Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				c1.setTime(fromDate);
				//c2.setTime(toDate);
				
				if(applicationDate.before(c1) && 
						(returnDate == null || exactReturningDate.after(c1) || exactReturningDate.equals(c1))) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoNhanTrongThang(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();	
				
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((c1.before(applicationDate) || c1.equals(applicationDate)) && (c2.after(applicationDate) || c2.equals(applicationDate))) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoTongCong(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
			
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		
				
		return res;
	}
		
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoSoDungHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();			
				
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				
				if(returnDate != null) { // Co ngay hoan thanh

					Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
					Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra 
					Calendar c1 = Calendar.getInstance(); // Tu ngay
					Calendar c2 = Calendar.getInstance(); // Den ngay
					
					exactReturningDate.setTime(returnDate);
					expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
					c1.setTime(fromDate);
					c2.setTime(toDate);
					
					if((c1.before(exactReturningDate) || c1.equals(exactReturningDate)) && 
							(c2.after(exactReturningDate) || c2.equals(exactReturningDate)) &&
							(exactReturningDate.before(expectedReturningDate) || exactReturningDate.equals(expectedReturningDate))) {
						PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
						pmlFilePcccDTO.setFileId(pmlFileId);
						pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
						pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
						pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
						pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
						res.add(pmlFilePcccDTO);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoSoTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();

				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				
				if(returnDate != null) { // Co ngay hoan thanh
					
					Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
					Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra 
					Calendar c1 = Calendar.getInstance(); // Tu ngay
					Calendar c2 = Calendar.getInstance(); // Den ngay
					
					exactReturningDate.setTime(returnDate);
					expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
					c1.setTime(fromDate);
					c2.setTime(toDate);
					
					if(returnDate != null) { // Co ngay hoan thanh
						if((c1.before(exactReturningDate) || c1.equals(exactReturningDate)) && 
								(c2.after(exactReturningDate) || c2.equals(exactReturningDate)) &&
								(exactReturningDate.after(expectedReturningDate))) {
							PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
							pmlFilePcccDTO.setFileId(pmlFileId);
							pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
							pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
							pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
							pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
							res.add(pmlFilePcccDTO);
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoTrongHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();
				
				Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra		
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((returnDate == null || exactReturningDate.after(c2)) &&
						(expectedReturningDate.after(c2) || expectedReturningDate.equals(c2))) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoDaTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();
				
				Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra		
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((returnDate == null || exactReturningDate.after(c2)) &&
												expectedReturningDate.before(c2)) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return res;
	}
	
	public List<PmlFilePcccDTO> layDanhSachHoSoTheoChinhSuaBoSung(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		List<PmlFilePcccDTO> res = new ArrayList<PmlFilePcccDTO>();
		
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFileId = pmlFilePCCC.getFileId();
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				// Lay tinh trang cua ho so
				List<PmlProcessDispose> pmlProcessDisposeList = PmlProcessDisposeUtil.findByFileId(pmlFileId);
				PmlProcessDispose pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition (pmlFileId, getMaxTransition_(pmlProcessDisposeList)).get(0);
				String state = PmlStateProcessLocalServiceUtil.getPmlStateProcess(pmlProcessDispose.getStateProcessIdBefore()).getStateProcessCode();
				
				if((applicationDate.before(c2) || applicationDate.equals(c2)) && (state.equals("chobosung"))) {
					PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
					pmlFilePcccDTO.setFileId(pmlFileId);
					pmlFilePcccDTO.setFileName(PmlFilePCCCUtil.findByPrimaryKey(pmlFileId).getFileName());
					pmlFilePcccDTO.setFiletype(PmlFileTypeUtil.findByPrimaryKey(PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlFileId).getFileTypeId()).getFileTypeName());
					pmlFilePcccDTO.setApplicationDate(pmlFilePCCC.getApplicationDate());
					pmlFilePcccDTO.setExpectedReturingDate(pmlFilePCCC.getExpectedReturningDate());
					res.add(pmlFilePcccDTO);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return res;
	}
	
	private int getMaxTransition_(List<PmlProcessDispose> pmlProcessDisposeList) {
		
		int max = 1;
		int pmlProcessDisposeSize = pmlProcessDisposeList.size();
		if(pmlProcessDisposeSize > 1) {
			max = pmlProcessDisposeList.get(0).getTransition_();
			for(int index = 1; index < pmlProcessDisposeSize; index ++) {
				int transition_ = pmlProcessDisposeList.get(index).getTransition_();
				if(transition_ > max) {
					max = transition_;
				}
			}
		}
		return max;
	}

}
