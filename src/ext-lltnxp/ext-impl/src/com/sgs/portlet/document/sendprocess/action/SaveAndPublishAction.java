/**
 * 
 */
package com.sgs.portlet.document.sendprocess.action;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;
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

import com.ext.portlet.util.Constants;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.util.DocumentSendUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;

/**
 * @author doanhdv
 *
 */
public class SaveAndPublishAction extends DocumentSendPortletAction {
	
	private static Log _log = LogFactory.getLog(SaveAndPublishAction.class);
	
	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		//_log.info("process action document send: save and publish ");
		updateDocumentSend(req, res);
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend documentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		
		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelUtil.findAll();
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil.findAll();
		List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelUtil.findAll();
		
		req.setAttribute("privilegeLevels", privilegeLevels);
		req.setAttribute("documentTypes", documentTypes);
		req.setAttribute("confidentialLevels", confidentialLevels);
		
		req.setAttribute("documentSend", documentSend);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.document.sendprocess.saveAndPublish");
		}
	}
	
	/**
	 * @param req
	 * @param res
	 */
	private void updateDocumentSend(ActionRequest req, ActionResponse res) {
		_log.info("=================create return document action=============");
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId"); //id
		String privilegeLevelId = ParamUtil.getString(req, "privilegeLevelId"); //do khan
		String receivingPlace = ParamUtil.getString(req, "receivingPlace");//noi goi
		String briefContent = ParamUtil.getString(req, "briefContent");//trich yeu
		
		boolean isLocalBoolean = ParamUtil.getBoolean(req, "isLocal", false);//cong van noi bo
//		String isLocal = Constants.IS_LOCAL;
//		
//		if(!isLocalBoolean) {
//			isLocal = Constants.IS_NOT_LOCAL;
//		}
		
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");//loai cong van
		long editorId = ParamUtil.getLong(req, "editorId");//nguoi soan thao
		String documentReference = ParamUtil.getString(req, "documentReference");//so hieu cong van di
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");//do mat
		
		PmlEdmDocumentSend documentSend = new PmlEdmDocumentSendImpl();
		//documentSend.setSignerId(signerId);
		
		try {
			documentSend.setDocumentSendId(CounterServiceUtil.increment());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		documentSend.setDocumentSendId(documentSendId);
		documentSend.setPrivilegeLevelId(privilegeLevelId);
		documentSend.setReceivingPlace(receivingPlace);
		documentSend.setBriefContent(briefContent);
		documentSend.setIsLocal(isLocalBoolean);
		
		documentSend.setDocumentTypeId(documentTypeId);
		documentSend.setEditorId(editorId);
		documentSend.setDocumentReference(documentReference);
		documentSend.setConfidentialLevelId(confidentialLevelId);
		
		String addResult = "";
		try {
			documentSend = PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(documentSend);
			
			// vao so cong van cho so
			Date date = new Timestamp( new Date().getTime());
			String yearInUse = String.valueOf(date.getYear() + 1900);
			int documentRecordTypeId = PmlEdmBookDocumentSendLocalServiceUtil.getDocumentRecordTypeIdByDocumentType(documentTypeId);
			
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(PortalUtil.getUserId(req));
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(departmentId);
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			
			PmlEdmBookDocumentSend bookDocumentSend =  
					PmlEdmBookDocumentSendLocalServiceUtil
						.getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(agencyId, yearInUse, documentRecordTypeId);
			
			if (bookDocumentSend != null) {
				if (bookDocumentSend.getAgencyId() != null && bookDocumentSend.getYearInUse() != null) {
					PmlEdmWriteDocumentSend writeDocumentSend = new PmlEdmWriteDocumentSendImpl();
					
					writeDocumentSend.setDocumentSendId(documentSendId);
					writeDocumentSend.setBookDocumentSendId(bookDocumentSend.getBookDocumentSendId());
					writeDocumentSend.setDateCreated(date);
					
					PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(writeDocumentSend);
				}
			} else {
				try {
					PmlEdmDocumentSendLocalServiceUtil.deletePmlEdmDocumentSend(documentSendId);
					return ;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			addResult = "success";
		} catch (Exception e) {
			addResult = "fail";
		}
		
		PmlEdmDocumentSendDTO documentSendDTO = DocumentSendUtil.getDocDTOFormDocSend(documentSend);
		req.setAttribute("documentSendDTO", documentSendDTO);
		req.setAttribute("addResult", addResult);
	}
}
