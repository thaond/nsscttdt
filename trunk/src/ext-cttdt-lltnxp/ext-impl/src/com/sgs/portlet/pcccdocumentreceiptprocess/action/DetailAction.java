
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil;
import com.ext.portlet.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.dto.DocumentReceiptLogNode;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class DetailAction extends DocumentReceiptPortletAction {

	private static Log _log = LogFactory.getLog(DetailAction.class);

	public static void getPreviousProcess(
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList,
		long documentReceiptId, PmlDocumentReceiptLog preLog) {

		List<PmlDocumentReceiptLog> documentReceiptLogListReceiver =
			new ArrayList<PmlDocumentReceiptLog>();
		try {
			documentReceiptLogListReceiver =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
					documentReceiptId, preLog.getProcesser());
		}
		catch (Exception e) {
			documentReceiptLogListReceiver =
				new ArrayList<PmlDocumentReceiptLog>();
			_log.error(e.getMessage());
		}
		Collections.sort(
			documentReceiptLogListReceiver,
			new Comparator<PmlDocumentReceiptLog>() {

				public int compare(
					PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

					int sort = o2.getTransition_() - o1.getTransition_();
					return sort;
				}
			});
		if (documentReceiptLogListReceiver.size() > 0) {
			if (documentReceiptLogListReceiver.get(0).getTransition_() > 1) {
				for (PmlDocumentReceiptLog temp : documentReceiptLogListReceiver) {
					if (temp.getTransition_() < preLog.getTransition_()) {
						pmlDocumentReceiptLogList.add(temp);
						getPreviousProcess(
							pmlDocumentReceiptLogList, documentReceiptId, temp);
						break;
					}
					else {
						continue;
					}
				}
			}
			else {
				pmlDocumentReceiptLogList.add(documentReceiptLogListReceiver.get(0));
			}
		}
	}

	// yenlt update hien thi ds luan chuyen VB cua chuyen vien 20101026
	public static List<PmlDocumentReceiptLog> getTrinhTuLuanChuyenVBChuyenVien(
		long documentReceiptId, long userId) {

		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList =
			new ArrayList<PmlDocumentReceiptLog>();
		List<PmlDocumentReceiptLog> documentReceiptLogListProcesser =
			new ArrayList<PmlDocumentReceiptLog>();
		List<PmlDocumentReceiptLog> documentReceiptLogListReceiver =
			new ArrayList<PmlDocumentReceiptLog>();

		try {
			documentReceiptLogListReceiver =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
					documentReceiptId, userId);
		}
		catch (Exception e) {
			documentReceiptLogListReceiver =
				new ArrayList<PmlDocumentReceiptLog>();
			_log.error(e.getMessage());
		}
		try {
			documentReceiptLogListProcesser =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(
					documentReceiptId, userId);
		}
		catch (Exception e) {
			documentReceiptLogListProcesser =
				new ArrayList<PmlDocumentReceiptLog>();
			_log.error(e.getMessage());
		}
		Collections.sort(
			documentReceiptLogListProcesser,
			new Comparator<PmlDocumentReceiptLog>() {

				public int compare(
					PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

					int sort = o2.getTransition_() - o1.getTransition_();
					return sort;
				}
			});
		Collections.sort(
			documentReceiptLogListReceiver,
			new Comparator<PmlDocumentReceiptLog>() {

				public int compare(
					PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

					int sort = o2.getTransition_() - o1.getTransition_();
					return sort;
				}
			});

		pmlDocumentReceiptLogList.add(documentReceiptLogListProcesser.get(0));
		if (documentReceiptLogListReceiver.size() > 0) {
			PmlDocumentReceiptLog temp = documentReceiptLogListReceiver.get(0);
			if (temp.getTransition_() > 1) {
				pmlDocumentReceiptLogList.add(temp);
				getPreviousProcess(
					pmlDocumentReceiptLogList, documentReceiptId, temp);
			}
			else {
				pmlDocumentReceiptLogList.add(temp);
			}
		}
		Collections.sort(
			pmlDocumentReceiptLogList, new Comparator<PmlDocumentReceiptLog>() {

				public int compare(
					PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

					int sort = o1.getTransition_() - o2.getTransition_();
					return sort;
				}
			});

		return pmlDocumentReceiptLogList;
	}

	// yenlt update 20101126 kiem tra userLogin co phai la VT ko
	public boolean checkIsVanThu(RenderRequest req) {

		boolean flag = false;
		long userLoginId = PortalUtil.getUserId(req);
		Department department = null;
		String departmentId = "";
		try {
			department = DepartmentUtil.findByDepartmentsCode("BPVT").get(0);
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (null != department) {
			departmentId = department.getDepartmentsId();
			List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
			}
			catch (Exception e) {
				_log.error(e.getMessage());
			}

			for (PmlUser pmlUser : pmlUserList) {
				if (userLoginId == pmlUser.getUserId()) {
					flag = true;
					break;
				}
				else {
					flag = false;
				}
			}
		}
		return flag;
	}

	// end yenlt 20101026

	private String getDocumentRecordTypeName(RenderRequest req)
		throws Exception {

		String documentRecordTypeName = "";
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt =
			PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		long documentTypeId = documentReceipt.getDocumentTypeId();
		int documentRecordTypeId = 0;
		PmlEdmDocumentType documentType = null;
		PmlEdmDocumentRecordType documentRecordType = null;
		try {
			documentType =
				PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
			documentRecordTypeId = documentType.getDocumentRecordTypeId();
		}
		catch (Exception e) {
		}
		if (documentRecordTypeId != 0) {
			try {
				documentRecordType =
					PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(documentRecordTypeId);
				documentRecordTypeName =
					documentRecordType.getDocumentRecordTypeName();
			}
			catch (Exception e) {
				documentRecordTypeName = "";
			}
		}
		return documentRecordTypeName;
	}

	/**
	 * get days process on main deparmetn
	 * 
	 * @param req
	 * @return List<Integer>
	 */
	private void getTimeProcessOnDeparment(RenderRequest req)
		throws Exception {

		int result = 0;
		String expireDateProcess = "";
		String mainProcessName = "";
		String mainDepartmentName = "";
		String processInformation = "";
		try {
			long documentReceiptId =
				ParamUtil.getLong(req, "documentReceiptId");
			// phmphuc close and change 10/12/2010 - lay danh sach theo user xu
			// ly
			// List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList =
			// PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			long userLogin = PortalUtil.getUserId(req); // user login
			long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0); // user
																		// duoc
																		// cho
																		// xu ly
																		// thay
			boolean processTranlate =
				ParamUtil.getBoolean(req, "vtxulythayldb", false);
			boolean processTranlateLDVP =
				ParamUtil.getBoolean(req, "vtxulythayldvp", false);
			boolean search = ParamUtil.getBoolean(req, "timkiemcvdendetail"); // cho
																				// phan
																				// tim
																				// kiem
																				// vb

			List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = null;

			try {
				if (processTranlate || processTranlateLDVP) {
					pmlDocumentReceiptLogList =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
							documentReceiptId, userIdXLT);
				}
				else if (search) {
					pmlDocumentReceiptLogList =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
				}
				else {
					pmlDocumentReceiptLogList =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
							documentReceiptId, userLogin);
				}
			}
			catch (Exception e) {
			}
			// end phmphuc update 10/12/2010

			if ((pmlDocumentReceiptLogList != null) &&
				(pmlDocumentReceiptLogList.size() > 0)) {
				// List<PmlDocumentReceiptLog> resultList = new
				// ArrayList<PmlDocumentReceiptLog>();
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {
					String inf =
						pmlDocumentReceiptLogList.get(i).getProcessInfomation();
					if (!"".equals(inf)) {
						processInformation = inf;
						break;
					}
				}
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {
					/*
					 * phmphuc close 18/11/2010 // Thoi update 20100319 if
					 * (pmlDocumentReceiptLogList.get(i).getNumDateProcess() > 0
					 * ||
					 * (pmlDocumentReceiptLogList.get(i).getMainDepartmentProcessId
					 * () != null &&
					 * !"".equals(pmlDocumentReceiptLogList.get(i).
					 * getMainDepartmentProcessId())) || 0 !=
					 * pmlDocumentReceiptLogList.get(i).getMainUserProcessId())
					 * { if
					 * (pmlDocumentReceiptLogList.get(i).getNumDateProcess() >
					 * 0) { // end result =
					 * pmlDocumentReceiptLogList.get(i).getNumDateProcess();
					 * DateFormat dateFormat = new
					 * SimpleDateFormat("dd/MM/yyyy"); Date dateProcess =
					 * pmlDocumentReceiptLogList.get(i).getDateProcess(); long
					 * numberDateRemain = result -
					 * (dateFormat.parse(dateFormat.format(new
					 * Date())).getTime() -
					 * dateFormat.parse(dateFormat.format(pmlDocumentReceiptLogList
					 * .get(i).getDateProcess())).getTime( ))/ (24 * 60 * 60 *
					 * 1000); OnedoorDwr onedoorDwr = new OnedoorDwr();
					 * expireDateProcess =
					 * onedoorDwr.getExpectedReturningDate(""+numberDateRemain,
					 * dateFormat.format(dateProcess)); // Thoi update 20100319
					 * } // end
					 * resultList.add(pmlDocumentReceiptLogList.get(i)); }
					 */
					// phmphuc update 18/11/2010
					if (pmlDocumentReceiptLogList.get(i).getExpiredDate() != null) {

						result =
							pmlDocumentReceiptLogList.get(i).getNumDateProcess();
						DateFormat dateFormat =
							new SimpleDateFormat("dd/MM/yyyy");
						expireDateProcess =
							dateFormat.format(pmlDocumentReceiptLogList.get(i).getExpiredDate());
						break;
					}
					// end phmphuc update 18/11/2010
				}

				/*
				 * phmphuc close 11/09/2010 lay phong ban xu ly chinh va chuyen
				 * vien xu ly chinh thong qua PmlEdmDocumentReceipt // phan
				 * gianh cho nhung cong van khi bang log chua co hai truong:
				 * phong xu ly chinh va user xu ly chinh if (resultList.size() >
				 * 1) { Collections.sort(resultList, new
				 * Comparator<PmlDocumentReceiptLog>() { public int
				 * compare(PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {
				 * return o1.getTransition_() - o2.getTransition_(); } }); //
				 * Thoi update 20100319 if
				 * (resultList.get(1).getMainUserProcessId() != 0) { String
				 * departmentId =
				 * resultList.get(0).getMainDepartmentProcessId(); Department
				 * department =
				 * DepartmentLocalServiceUtil.getDepartment(departmentId);
				 * mainDepartmentName = department.getDepartmentsName(); long
				 * mainProcessId = resultList.get(1).getReceiver(); User
				 * mainUser = UserLocalServiceUtil.getUser(mainProcessId);
				 * mainProcessName = mainUser.getLastName() + " " +
				 * mainUser.getMiddleName() + " " + mainUser.getFirstName(); }
				 * else { long mainProcessId = resultList.get(1).getReceiver();
				 * // end PmlUser mainProcess =
				 * PmlUserLocalServiceUtil.getPmlUser(mainProcessId); String
				 * departmentId = mainProcess.getDepartmentsId(); Department
				 * department =
				 * DepartmentLocalServiceUtil.getDepartment(departmentId);
				 * mainDepartmentName = department.getDepartmentsName(); User
				 * mainUser = UserLocalServiceUtil.getUser(mainProcessId);
				 * mainProcessName = mainUser.getLastName() + " " +
				 * mainUser.getMiddleName() + " " + mainUser.getFirstName(); //
				 * Thoi update 20100319 } // end } else if (resultList.size() >
				 * 0) { // Thoi update 20100319 if
				 * (resultList.get(0).getMainDepartmentProcessId() != null &&
				 * !"".equals(resultList.get(0).getMainDepartmentProcessId())) {
				 * Department department =
				 * DepartmentLocalServiceUtil.getDepartment
				 * (resultList.get(0).getMainDepartmentProcessId());
				 * mainDepartmentName = department.getDepartmentsName(); } else
				 * { // end long mainProcessId =
				 * resultList.get(0).getReceiver(); PmlUser mainProcess =
				 * PmlUserLocalServiceUtil.getPmlUser(mainProcessId); String
				 * departmentId = mainProcess.getDepartmentsId(); Department
				 * department =
				 * DepartmentLocalServiceUtil.getDepartment(departmentId);
				 * mainDepartmentName = department.getDepartmentsName(); // Thoi
				 * update 20100319 } // end } end phmphuc close
				 */

				// phmphuc update 11/09/2010 - lay phong ban xu ly chinh va
				// chuyen vien xu ly chinh
				PmlEdmDocumentReceipt documentReceipt = null;
				try {
					documentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
					documentReceipt = null;
				}

				// phong ban xu ly chinh
				try {
					String departmentId =
						documentReceipt.getMainDepartmentProcessId();
					Department department =
						DepartmentLocalServiceUtil.getDepartment(departmentId);
					mainDepartmentName = department.getDepartmentsName();
				}
				catch (Exception e) {
					mainDepartmentName = "";
				}

				// chuyen vien xu ly chinh
				try {
					long mainProcessId = documentReceipt.getMainUserProcessId();
					User mainUser = UserLocalServiceUtil.getUser(mainProcessId);
					mainProcessName =
						mainUser.getLastName() + " " +
							mainUser.getMiddleName() + " " +
							mainUser.getFirstName();
				}
				catch (Exception e) {
					mainProcessName = "";
				}
				// end phmphuc update
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("daysProcessDeparmentMain", "" + result);
		req.setAttribute("expireDateProcess", "" + expireDateProcess);
		req.setAttribute("mainProcessName", mainProcessName);
		req.setAttribute("mainDepartmentName", mainDepartmentName);
		req.setAttribute("processInformation", processInformation);
	}

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		/*
		 * Process Action Code Goes Here
		 */
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// get current page
		// int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		// int limit = ParamUtil.getInteger(req, "limit", 20); // default

		// phmphuc update 12/03/2010 - khoa dong stateProcessId
		// minh update 2009/10/29
		// Long stateProcessId = ParamUtil.getLong(req, "stateProcessId" , 0);
		// end

		PmlEdmDocumentReceiptDTO documentReceiptDTO =
			new PmlEdmDocumentReceiptDTO();
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt document =
			PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);

		// yenlt update

		// end
		// minh update 2009/10/29
		// document.setStatusId(stateProcessId);
		// end
		// end
		documentReceiptDTO = populateDocumentReceiptToDTO(req, document);

		List<PmlEdmAttachedFile> attachedFiles =
			PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(
				documentReceiptId,
				new PmlEdmDocumentReceiptImpl().getClass().getName());

		List<PmlEdmAttachedFile> formatAttachedFiles =
			new ArrayList<PmlEdmAttachedFile>();
		/* format name of attached file */
		if (attachedFiles != null) {
			for (int i = 0; i < attachedFiles.size(); i++) {
				PmlEdmAttachedFile attachedFile = attachedFiles.get(i);
				String name = attachedFile.getAttachedFileName();
				String subName =
					name.substring(Constants.NUMBER_REFIX_ATTACHEDFILE);
				attachedFile.setAttachedFileName(subName);

				formatAttachedFiles.add(attachedFile);
			}
		}

		String documentRecordTypeName = getDocumentRecordTypeName(req);

		req.setAttribute("documentRecordTypeId", documentRecordTypeName);
		req.setAttribute("documentDTO", documentReceiptDTO);
		req.setAttribute("attachedFiles", formatAttachedFiles);

		// req.setAttribute("currentPage", page);
		// req.setAttribute("currentLimit", limit);
		// lay so cong van den cua phong
		long userId = PortalUtil.getUserId(req);
		PmlUser pmlUser = null;
		String departmentId = "";
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
		}
		catch (Exception e) {
			pmlUser = null;
		}
		if (null != pmlUser) {
			departmentId = pmlUser.getDepartmentsId();
		}

		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = null;
		try {
			pmlEdmBookDocumentRecordToList =
				PmlEdmBookDocumentRecordToUtil.findByDocumentReceiptId(documentReceiptId);
		}
		catch (Exception e) {
			pmlEdmBookDocumentRecordToList =
				new ArrayList<PmlEdmBookDocumentRecordTo>();
		}

		long documentRecordToId = 0;
		PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = null;
		String soCongVanDenHientai = "";
		for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : pmlEdmBookDocumentRecordToList) {
			documentRecordToId =
				pmlEdmBookDocumentRecordTo.getDocumentRecordToId();
			try {
				pmlEdmDocumentRecordTo =
					PmlEdmDocumentRecordToUtil.findByPrimaryKey(documentRecordToId);
			}
			catch (Exception e) {
				pmlEdmDocumentRecordTo = null;
			}

			if ((null != pmlEdmDocumentRecordTo) &&
				departmentId.equals(pmlEdmDocumentRecordTo.getDepartmentsId())) {
				soCongVanDenHientai =
					String.valueOf(pmlEdmBookDocumentRecordTo.getSoCongVanDenPhongHienTai());
				break;
			}
		}

		req.setAttribute("soCongVanDenHientai", soCongVanDenHientai);

		// lay hscv
		List<PmlChiTietHSCV> chiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		try {
			chiTietHSCVList =
				PmlChiTietHSCVUtil.findByIdCongVanDen(documentReceiptId);
		}
		catch (Exception e) {

		}

		List<PmlHoSoCongViec> pmlHoSoCongViecList =
			new ArrayList<PmlHoSoCongViec>();
		if (chiTietHSCVList.size() > 0) {

			PmlHoSoCongViec pmlHoSoCongViec = null;
			for (PmlChiTietHSCV pmlChiTietHSCV : chiTietHSCVList) {
				try {
					pmlHoSoCongViec =
						PmlHoSoCongViecUtil.findByPrimaryKey(pmlChiTietHSCV.getIdHoSoCongViec());
				}
				catch (Exception e) {
				}

				if (pmlHoSoCongViec != null) {
					pmlHoSoCongViecList.add(pmlHoSoCongViec);
				}
			}
		}
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		// watch series process

		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList =
			PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
		req.setAttribute("pmlDocumentReceiptLogList", pmlDocumentReceiptLogList);
		// Canh
		DocumentReceiptLogNode root = null;
		try {
			List<PmlDocumentReceiptLog> documentReceiptLogs =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(
					documentReceiptId, 1);
			if (documentReceiptLogs.size() > 0) {
				root =
					new DocumentReceiptLogNode(documentReceiptLogs.get(0), null);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("workflow_tree", root);
		// End of Canh

		// List<PmlDocumentReceiptLog> pmlDocumentReceiptLogListTemp =
		// PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
		// List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = new
		// ArrayList<PmlDocumentReceiptLog>();
		//
		// for (int i = pmlDocumentReceiptLogListTemp.size() -1; i >= 0; i--) {
		// if(0 == pmlDocumentReceiptLogListTemp.get(i).getType_()) {
		// pmlDocumentReceiptLogList.add(pmlDocumentReceiptLogListTemp.get(i));
		// }
		// }
		//
		// xuancong add start
		// Sap xep thu tu luan chuyen van ban tang dan theo thoi gian
		if (!pmlDocumentReceiptLogList.isEmpty()) {
			Collections.sort(
				pmlDocumentReceiptLogList,
				new Comparator<PmlDocumentReceiptLog>() {

					public int compare(
						PmlDocumentReceiptLog obj1, PmlDocumentReceiptLog obj2) {

						if (obj1.getTransition_() < obj2.getTransition_()) {
							return -1;
						}
						if (obj1.getTransition_() == obj2.getTransition_()) {
							return 0;
						}
						return 1;
					}
				});
		} // end if
			// xuancong add end

		getTimeProcessOnDeparment(req);

		/* get current node by fileId */
		DocumentReceiptLiferayWorkflowService service =
			new DocumentReceiptLiferayWorkflowService();

		/* phmphuc them - truong hop xu ly thay */
		long userXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		boolean processTranlate =
			ParamUtil.getBoolean(req, "vtxulythayldb", false);
		boolean processTranlateLDVP =
			ParamUtil.getBoolean(req, "vtxulythayldvp", false);

		if ((userXLT != 0) && (processTranlate || processTranlateLDVP)) {
			service.updateReceiveDate(documentReceiptId, userXLT);
		}
		else {
			service.updateReceiveDate(
				documentReceiptId, PortalUtil.getUserId(req));
		}

		// Quan add 20091118 start
		// truyen cach thuc xu ly tuong ung cong van len trang detail.jsp
		long documentId = ParamUtil.getLong(req, "documentReceiptId");
		ProcessType pt_tmp = null;
		if (documentId != 0) {
			List<SaveProcessType> lstSavePT =
				SaveProcessTypeLocalServiceUtil.getProcessTypeByDocId(documentId);

			// lay ra danh sach cach thuc xu ly tuong ung cong van
			List<ProcessType> lstPT = new ArrayList<ProcessType>();
			if (lstSavePT != null) {
				Iterator<SaveProcessType> itrSavePT = lstSavePT.iterator();
				while (itrSavePT.hasNext()) {
					SaveProcessType saveProcessType = itrSavePT.next();
					pt_tmp =
						ProcessTypeLocalServiceUtil.getProcessTypeById(saveProcessType.getFlagProcessType());
					if (pt_tmp != null) {
						lstPT.add(pt_tmp);
					}
				}
			}
			req.setAttribute("listprocesstype_doc", lstPT);
		}
		// Quan add 20091118 end
		// yenlt 20101126
		boolean isVanThu = checkIsVanThu(req);
		req.setAttribute("isVanThu", isVanThu);
		// end yenlt 20101126
		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.detail");
		}
	}
}
