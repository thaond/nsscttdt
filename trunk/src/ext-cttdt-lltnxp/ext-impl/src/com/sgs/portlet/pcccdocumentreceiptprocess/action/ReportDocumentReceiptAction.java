package com.sgs.portlet.pcccdocumentreceiptprocess.action;

/**
 * @author triltm
 * @author thoind
 */
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ReportDocumentReceiptAction extends DocumentReceiptPortletAction {	
	private static Log _log = LogFactory.getLog(ReportDocumentReceiptAction.class); // yenlt 06052010
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req)+"");
//		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req)+"");
		
		//update date document receipt go away department 
		//get year current
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());		
//		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
//		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
//		int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
//		long userId = PortalUtil.getUserId(req);
//		updateBookDocumentReceipt(userId, yearInUse, documentRecordTypeId, documentReceiptId);
		// yenlt UPDATE 06052010
		// minh update 20101227
//		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String receiverIdReports = ParamUtil.getString(req, "receiverIdReports", "");
		String receiverIdReportMain = ParamUtil.getString(req, "receiverIdReportMain", "");
		String processInformation = ParamUtil.getString(req, "processInformation", "");
		
//		addWorkflowParameter(req, "receiverIds",  WorkflowParam.TRANSIENT, receiverId+"");
		addWorkflowParameter(req, "receiverIdReports",  WorkflowParam.TRANSIENT, receiverIdReports);
		addWorkflowParameter(req, "receiverIdReportMain",  WorkflowParam.TRANSIENT, receiverIdReportMain);
		// end minh update 20101227
		addWorkflowParameter(req, "processInformation",  WorkflowParam.TRANSIENT, processInformation);
		_log.info("in processstrutsAction method");
	
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
		
		// end YENLT 06052010
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		//upload file
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		
		String titleFiles = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		if (!"".equals(nameFieldRow)) {
			String[] nameFieldRowArr = nameFieldRow.split("_");
			
			String[] titleFilesArr = titleFiles.split("#");
			if (titleFilesArr.length == 0) {
				titleFilesArr = new String[nameFieldRowArr.length];
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					titleFilesArr[i] = "";
				}
			}
			for (int i = 0; i < nameFieldRowArr.length; i++) {
				uploadFile(req, nameFieldRowArr[i],
						documentReceipt, titleFilesArr[i]);
			}
		}
		
		
//		PortletSession session= req.getPortletSession();
//		session.setAttribute("transition", "save",PortletSession.APPLICATION_SCOPE);
	}

	
	/**
	 * This method allows upload many files from client to server 
	 * @param nameRowUpload 
	 * void 
	 *
	 */
	public void uploadFile(ActionRequest req, String nameFieldUpload, PmlEdmDocumentReceipt documentReceipt, String titleFile) {
		try {
			//save file upload into folder upload
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String fileName = com.sgs.portlet.document.receipt.util.Constants.getDateTime()+ fileNames;	
			String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
			File destFile = new File(patthFile + "/" + fileName);
			if (!(new File(patthFile)).exists()) {
				(new File(patthFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			// set value into attachedFile
			PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
			attachedFile.setAttachedFileId(CounterServiceUtil.increment());
			attachedFile.setObjectContentId(documentReceipt.getDocumentReceiptId());
			attachedFile.setObjectType(documentReceipt.getClass().getName());
			attachedFile.setAttachedFileName(fileName);
			attachedFile.setPath("/upload" + "/" + fileName);
			attachedFile.setDateCreated(new Date());
			if (fileName.lastIndexOf(".") != -1) {
				attachedFile.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
			}
			long userId = PortalUtil.getUser(req).getUserId();
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(userId);
			} catch (Exception e) {
				user = null;
			}
			
			String userName = "";
			if (user != null) { // Nguoi dung xac dinh
				userName = user.getScreenName();
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String datevalue = formatter.format(date.getTime());
			
			//attachedFile.setTitle(StringUtil.encodeHtml(titleFile));
			//set title dang title_screenname_ngay
			attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + datevalue));
			attachedFile.setDisplayOrHidden(true);
			//attachedFile.setTitle(titleFile);
			//persistence attachedFile into database
			PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set date complete of department process document receipt
	 * @param userId
	 * @param yearInUse
	 * @param documentRecordTypeId
	 * @param documentReceiptId
	 * void
	 *
	 */
	private void updateBookDocumentReceipt (long userId, String yearInUse, int documentRecordTypeId, long documentReceiptId) {
		PmlUser pmlUser = null;
		String departmentIdMain = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			
		} catch (Exception e) {	} 
		
		if (pmlUser != null) {
			try {
				departmentIdMain = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId()).getDepartmentsId();
				if (departmentIdMain != null) {
					PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(yearInUse, departmentIdMain, documentRecordTypeId);
					if (pmlEdmDocumentRecordTo != null) {
						
						PmlEdmBookDocumentRecordTo bookDocumentRecordTo = PmlEdmBookDocumentRecordToUtil.findByDocumentReceiptId_DocumentRecordToId(documentReceiptId, pmlEdmDocumentRecordTo.getDocumentRecordToId()).get(0);
						Date date = new Timestamp( new Date().getTime());
						bookDocumentRecordTo.setDateComplete(date);
						
						PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
					}
				}
			} catch (Exception e) {}
				
		}
		
	}
	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		//yenlt update 06052010
		List<User> users = getListUser(req);
		req.setAttribute("users", users);
		// end yenlt
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.reportdocumentreceipt");
	}

	//yenlt update 06052010
	private List<User> getListUser(RenderRequest req){
		List<User> results = new ArrayList<User>();
		List<User> resultsUser = new ArrayList<User>();
		List<User> resultsUserLDB = new ArrayList<User>();
		List<User> resultsUserAll = new ArrayList<User>();
		List<User> resultsUserTP = new ArrayList<User>();
		List<User> resultsUserPP = new ArrayList<User>();
		long userLoginId = PortalUtil.getUserId(req);
		User userLogin = null;
		PmlUser pmlUser = null;
		List<PmlDepartmentsLeader> listLeader = new ArrayList<PmlDepartmentsLeader> ();
		List<PmlDepartmentsLeader> listLeaderAll = new ArrayList<PmlDepartmentsLeader> ();
		List<PmlDepartmentsLeader> listLeaderPP = new ArrayList<PmlDepartmentsLeader> ();
		List<PmlDepartmentsLeader> listLeaderTP = new ArrayList<PmlDepartmentsLeader> ();
		PmlDepartmentsLeader departmentsLeader = null;
		User userAll = null;
		// user dang nhap
		try {
			userLogin = UserUtil.findByPrimaryKey(userLoginId);
			pmlUser = PmlUserLocalServiceUtil.getPmlUser(userLoginId);
		} catch (Exception e1) {
			_log.error(e1);
		} 
		
		// tim danh sach tat ca leader
		try {
			listLeaderAll = PmlDepartmentsLeaderUtil.findAll();
			for ( int i=0; i < listLeaderAll.size(); i++) {
				try {
					userAll = UserLocalServiceUtil.getUser(listLeaderAll.get(i).getUserId());
					resultsUserAll.add(userAll);
				} catch (Exception e) {
					_log.error(e);
				}
			}
		} catch (Exception e2) {
			_log.error(e2);
			resultsUserAll = new ArrayList<User>();
		}
		
		// tim danh sach TP
		try {
			listLeaderTP = PmlDepartmentsLeaderUtil.findByMain(true);
			for ( int i=0; i < listLeaderTP.size(); i++) {
				try {
					userAll = UserLocalServiceUtil.getUser(listLeaderTP.get(i).getUserId());
					resultsUserTP.add(userAll);
				} catch (Exception e) {
					_log.error(e);
					resultsUserTP = new ArrayList<User>();
				}
			}
		} catch (Exception e2) {
			_log.error(e2);
		}
		// tim danh sach pho phong
		try {
			listLeaderPP = PmlDepartmentsLeaderUtil.findByMain(false);
			for ( int i=0; i < listLeaderPP.size(); i++) {
				
				try {
					userAll = UserLocalServiceUtil.getUser(listLeaderPP.get(i).getUserId());
					resultsUserPP.add(userAll);
				} catch (Exception e) {
					_log.error(e);
					resultsUserPP = new ArrayList<User>();
				}
			}
		} catch (Exception e2) {
			_log.error(e2);
		} 
		PortletPreferences prefs = req.getPreferences();
		//list user LDB
		String[] listUserLDB = prefs.getValues("listUserLDB", new String[0]);
		for (int i = 0; i < listUserLDB.length; i++) {
			try {
				userAll = UserUtil.findByPrimaryKey(Long.parseLong(listUserLDB[i]));
				resultsUserLDB.add(userAll);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		// list user CVP
		String[] listUser = prefs.getValues("listUser", new String[0]);
		for (int i = 0; i < listUser.length; i++) {
			try {
				userAll = UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
				resultsUser.add(userAll);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		
		Department department = null;
		try {
		department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		// CHUYEN VIEN 
		if (!resultsUserAll.contains(userLogin) && 
				(("".equals(department.getDepartmentsParentId())) || (null == department.getDepartmentsParentId()))) {	
			try {
				listLeader = PmlDepartmentsLeaderUtil.findByDepartmentsId(pmlUser.getDepartmentsId());
				for (int i=0; i < listLeader.size(); i++) {
					departmentsLeader = listLeader.get(i);
					User userTP = null;
					try {
						userTP = UserLocalServiceUtil.getUser(departmentsLeader.getUserId());
						results.add(userTP);
					} catch (Exception e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(e);
				results = new ArrayList<User>();
			}
					
		} else if ((resultsUserPP.contains(userLogin)) && !resultsUser.contains(userLogin) && !resultsUserLDB.contains(userLogin)) { // PHO PHONG
			resultsUserAll.remove(userLogin);
			results = resultsUserAll;
			
		} else if ((resultsUserTP.contains(userLogin)) && (!resultsUser.contains(userLogin)) && (!resultsUserLDB.contains(userLogin))) { // LANH DAO PHONG
			resultsUserTP.remove(userLogin);
			for (int i = 0; i < resultsUser.size(); i++) {
				if (!resultsUserTP.contains(resultsUser.get(i))) {
					resultsUserTP.add(resultsUser.get(i));
				}
				
			}
			for (int i = 0; i < resultsUserLDB.size(); i++) {
				if (!resultsUserTP.contains(resultsUserLDB.get(i))) {
					resultsUserTP.add(resultsUserLDB.get(i));
				}
				
			}
			results = resultsUserTP;
			
		} else if (resultsUser.contains(userLogin)) {// LANH DAO VAN PHONG
			resultsUserLDB.remove(userLogin);
			results = resultsUserLDB;
			
		} else if (resultsUserLDB.contains(userLogin)) { // LANH DAO BAN
			results = resultsUserLDB;
		}
		else if ((!resultsUserAll.contains(userLogin)) && 
				((!"".equals(department.getDepartmentsParentId())) || (null != department.getDepartmentsParentId()))) {//VAN THU 
			results = resultsUser;
		}
	
		Collections.sort(results, new Comparator<User>(){
			public int compare(User o1, User o2) {						
				return o1.getFullName().compareTo(o2.getFullName());
			}					
		});	
		
		return results;
	}
	//end yenlt
}
