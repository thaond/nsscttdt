/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.pcccdocumentreceiptprocess.dto.PhieuChuyenDTO;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.PhieuChuyenUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;

/**
 * @author minh.nv
 *
 */
public class PrintPhieuChuyen extends PortletAction {
	
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
		
		String cmd = ParamUtil.getString(req, "cmd");
		String documentReceiptIdList = ParamUtil.getString(req, "documentReceiptIdList", "");
		
		if ("PRINTS_LIST".equals(cmd)) {
			inDSPhieuChuyen(documentReceiptIdList, req, res);
		} else {
			inPhieuChuyen(req, res);
		}
	}


	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {
		
		return mapping.findForward("portlet.sgs.onedoorpcccprocess.inphieuchuyenchophong");
	}
	
	
	private void inPhieuChuyen(ActionRequest req, ActionResponse res) {
		long receiverId = ParamUtil.getLong(req, "receiverId", -1);
//		String mainDepartment =  ParamUtil.getString(req, "mainDepartment", "");
		
		// truong hop chuyen cho phong ban thi chi in ra ten truong phong cua phong ban xu ly chinh
		long mainUser =  ParamUtil.getLong(req, "mainUser", 0);
		
		// yeu cau xy ly
		String processInformation =  ParamUtil.getString(req, "processInformation", "");
		
		// thoi gian xu ly
		String dateNumberProcess =  ParamUtil.getString(req, "dateNumberProcess", "");
		String totalDateProcessCalenRes =  ParamUtil.getString(req, "totalDateProcessCalenRes", "");
		
		/* phmphuc close - khi chuyen cho phong ban receiverId luon = -1, vi ko lay duoc pmlDepartmentsLeaderList
		if (!"".equals(mainDepartment)) {
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = null;
			try {
				pmlDepartmentsLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(mainDepartment,true);
				receiverId = pmlDepartmentsLeaderList.get(0).getUserId();
			} catch (Exception e) {
			}
		}*/
		
		long documentReceiptId = ParamUtil.getLong(req, com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "documentReceiptId");
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);		
		String realPath = request.getSession().getServletContext().getRealPath("reports");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String documentReference = ""; // So van ban goc
		String issuingdate = "";
		String numberdocumentreceipt = "";
		String hour = "";
		String minute = "";
		String datearrive = "";
		String issuingplaceName = "";
		String briefcontent = "";
		String receiver = "";
		String processinfomation = "";
		String numdateprocess = "";
		String yKienLDBan = "";
		
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
		PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
		
		try {
			pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
		
			// so van ban goc
			documentReference = StringUtils.convertToRTF(pmlEdmDocumentReceipt.getDocumentReference());
			
			// ngay ban hanh
			issuingdate = dateFormat.format(pmlEdmDocumentReceipt.getIssuingDate());
			
			// so van ban
			numberdocumentreceipt = pmlEdmDocumentReceipt.getNumberDocumentReceipt();
			
			// gio den
			String []arrayThoigiannhancvden = pmlEdmDocumentReceipt.getThoigiannhancvden().split(":");
			hour = arrayThoigiannhancvden[0];
			minute = arrayThoigiannhancvden[1];
			
			// ngay den
			datearrive = dateFormat.format(pmlEdmDocumentReceipt.getDateArrive());
			
			// co quan ban hanh
			try {
				pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId());
				issuingplaceName = StringUtils.convertToRTF(pmlEdmIssuingPlace.getIssuingPlaceName());
			} catch (Exception e) {
				issuingplaceName = StringUtils.convertToRTF(pmlEdmDocumentReceipt.getIssuingPlaceOtherName());
 			}
			
			// trich yeu
			briefcontent = StringUtils.convertToRTF(pmlEdmDocumentReceipt.getBriefContent());
			
			// nguoi xu ly
			try {
				if (receiverId == -1) {
					receiver = StringUtils.convertToRTF(TinhHinhThuLyCongVanDWRUtil.getFullName(mainUser));
				}
				else {
					receiver = StringUtils.convertToRTF(TinhHinhThuLyCongVanDWRUtil.getFullName(receiverId));
				}
			} catch (Exception e) {
				receiver = "";
			}
			
			// yeu cau xu ly
			processinfomation = StringUtils.convertToRTF(processInformation);
			
			// thoi gian xu ly
			if (!dateNumberProcess.equals("")) {
				numdateprocess = dateNumberProcess + StringUtils.convertToRTF(" ng\u00E0y");
			} else if (dateNumberProcess.equals("") && !totalDateProcessCalenRes.equals("")) {
				numdateprocess = totalDateProcessCalenRes;
			} else {
				numdateprocess = "";
			}
			
		} catch (Exception e) {
			pmlEdmDocumentReceipt = null;
		}
		
		/* phmphuc close - lam gon code
		if (null != pmlEdmDocumentReceipt) {
			String []arrayThoigiannhancvden = pmlEdmDocumentReceipt.getThoigiannhancvden().split(":");
			hour = arrayThoigiannhancvden[0];
			minute = arrayThoigiannhancvden[1];
			datearrive = dateFormat.format(pmlEdmDocumentReceipt.getDateArrive());
			numberdocumentreceipt = pmlEdmDocumentReceipt.getNumberDocumentReceipt();
			issuingdate = dateFormat.format(pmlEdmDocumentReceipt.getIssuingDate());
			
			PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
			try {
				pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId());
			} catch (Exception e) {
				pmlEdmIssuingPlace = null;
 			}
			
			if (null != pmlEdmIssuingPlace) {
				issuingplaceName = pmlEdmIssuingPlace.getIssuingPlaceName();
			}
			
			else {
				issuingplaceName = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
			}
			
			briefcontent = pmlEdmDocumentReceipt.getBriefContent();
			
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(receiverId);
			} catch (Exception e) {
				user = null;
			}
			
			if(null != user) {
				receiver = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			}					
			documentReference = pmlEdmDocumentReceipt.getDocumentReference();
		}
		*/

		/* xuancong close start
		 * Can xuat ra man hinh la so van ban goc chu khong phai ma so cua van ban
		PhieuChuyenUtil rtfUtil = new PhieuChuyenUtil(realPath, String.valueOf(documentReceiptId),
				hour, minute, datearrive, numberdocumentreceipt, issuingdate, StringUtils.convertToRTF(issuingplaceName),
				StringUtils.convertToRTF(briefcontent), StringUtils.convertToRTF(receiver));
		xuancong close end */
		PhieuChuyenUtil rtfUtil = new PhieuChuyenUtil(realPath, documentReference, hour, minute, datearrive, 
							numberdocumentreceipt, issuingdate, issuingplaceName, briefcontent, receiver, 
							processinfomation, numdateprocess, StringUtils.convertToRTF(yKienLDBan));
		
		InputStream in = null;
		try {
			in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/Phieuchuyencongvan.rtf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ServletResponseUtil.sendFile(response, "Phieuchuyencongvan.rtf", in, "application/rtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void inDSPhieuChuyen(String documentReceiptIdList, ActionRequest req, ActionResponse res) {
		List<PhieuChuyenDTO> results = new ArrayList<PhieuChuyenDTO>();
		
		long receiverId = ParamUtil.getLong(req, "supportUsers", -1);
		String receiverName = ParamUtil.getString(req, "receiverid", "");
		String processInformation =  ParamUtil.getString(req, "processInformation", "");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		if (!documentReceiptIdList.equals("")) {
			String[] arrDocumentReceiptIds = documentReceiptIdList.trim().split(",");
			long documentReceiptId = 0;
			for (int t = 0; t < arrDocumentReceiptIds.length; t ++) {
				try {
					documentReceiptId = Long.parseLong(arrDocumentReceiptIds[t]);
					// du lieu merge field
					String documentReference = ""; // so van ban goc
					String numberdocumentreceipt = ""; // so van ban
					String issuingdate = ""; // ngay ban hanh
					String hour = ""; // gio den
					String datearrive = ""; // ngay den
					String issuingplaceName = ""; // co quan ban hanh
					String receiver = ""; // nguoi nhan
					String briefcontent = ""; // trich yeu
					String processinfomation = ""; // yeu cau xu ly
					
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
					
					// gia tri merge field
					try {
						pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
						documentReference = pmlEdmDocumentReceipt.getDocumentReference();
						numberdocumentreceipt = pmlEdmDocumentReceipt.getNumberDocumentReceipt();
						issuingdate = dateFormat.format(pmlEdmDocumentReceipt.getIssuingDate());
						hour = pmlEdmDocumentReceipt.getThoigiannhancvden();
						datearrive = dateFormat.format(pmlEdmDocumentReceipt.getDateArrive());
						
						try {
							pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId());
							issuingplaceName = pmlEdmIssuingPlace.getIssuingPlaceName();
						} catch (Exception e) {
							issuingplaceName = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
						}
						
						try {
							if (receiverId == -1) {
								receiver = receiverName;
							}
							else {
								receiver = TinhHinhThuLyCongVanDWRUtil.getFullName(receiverId);
							}
						} catch (Exception e) {
							receiver = "";
						}
						
						briefcontent = pmlEdmDocumentReceipt.getBriefContent();
						processinfomation = StringUtils.convertToRTF(processInformation);
						
					} catch (Exception e1) { 
						pmlEdmDocumentReceipt = null;
					}
					
					// luu vao gia tri DTO
					PhieuChuyenDTO dto = new PhieuChuyenDTO();
					dto.setDocumentReference(StringUtils.convertToRTF(documentReference));
					dto.setNumberdocumentreceipt(StringUtils.convertToRTF(numberdocumentreceipt));
					dto.setIssuingdate(issuingdate);
					dto.setHour(hour);
					dto.setDatearrive(datearrive);
					dto.setIssuingplaceName(StringUtils.convertToRTF(issuingplaceName));
					dto.setReceiver(StringUtils.convertToRTF(receiver));
					dto.setBriefcontent(StringUtils.convertToRTF(briefcontent));
					dto.setProcessinfomation(StringUtils.convertToRTF(processinfomation));
					dto.setNumberdocumentreceipt(numberdocumentreceipt);
					
					results.add(dto);
				} catch (Exception e) { 
				}
			}
		}
		
		// thuc hien xuat file
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);		
		String realPath = request.getSession().getServletContext().getRealPath("reports");
		
		PhieuChuyenUtil rtfUtil = new PhieuChuyenUtil(realPath, results);
		
		try {
			InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/danhSachPhieuChuyen.rtf"));
			ServletResponseUtil.sendFile(response, "danhSachPhieuChuyen.rtf", in, "application/rtf");
		} catch (Exception e) { }
	}
}
