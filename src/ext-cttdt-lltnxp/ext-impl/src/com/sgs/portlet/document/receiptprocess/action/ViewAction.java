package com.sgs.portlet.document.receiptprocess.action;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class ViewAction extends DocumentReceiptPortletAction {
	
	
	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
		String action = ParamUtil.getString(req, "action");
		List<PmlEdmDocumentReceiptDTO> documentDTOs = getListDocumentReceiptDTOByUser(req, res);
		
		// check for sorting
		if ("sort".equals(action)) {
			int sort = ParamUtil.getInteger(req, "sort", 0);
			int flag = ParamUtil.getInteger(req, "flag", 0);
			if (flag == 0) {
				flag = 1;
			}else {
				flag = 0;
			}
			
			documentDTOs = sort(documentDTOs, sort, flag);
			req.setAttribute("flag", flag);
		}
		
		req.setAttribute("documentDTOs", documentDTOs);
		return mapping.findForward("portlet.sgs.document.receiptprocess.view");
	}
	
	/**
	 * Get document receipt list of loginer
	 * @param userId
	 * @return list of PmlEdmDocumentReipt
	 */
	private List<PmlEdmDocumentReceipt> getDocumentReceiptsByUser(long userId) {
		// get list from workflow service
		List<PmlEdmDocumentReceipt> list = null;
		try {
			List<PmlEdmDocumentReceipt> listTemp = 
				((DocumentReceiptLiferayWorkflowService)getLiferayWorkflowService())
					.getListPmlEdmDocumentReceiptsByUser(userId);
			if (listTemp == null || listTemp.size() == 0) {
				list = new ArrayList<PmlEdmDocumentReceipt>();				
			}
			else {
				list = listTemp;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Get list DocumentReceiptDTO by user
	 * @param req RenderRequest
	 * @param res RenderResponse
	 * @return list PmlEdmDocumentReceiptDTO
	 */
	private List<PmlEdmDocumentReceiptDTO> getListDocumentReceiptDTOByUser(RenderRequest req, RenderResponse res) {
		String briefContent = ParamUtil.getString(req, "briefContent", "");
		String documentReference = ParamUtil.getString(req, "documentReference", "");
		String signer = ParamUtil.getString(req, "signer", "");
		String issuingPlace = ParamUtil.getString(req, "issuingPlace", "");
		Date dateArrive = ParamUtil.getDate(req, "receiveDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		String status = ParamUtil.getString(req, "status", ""); 
		
		/* 
		 * set attributes:
		 * - briefContent
		 * - documentReference
		 * - signer
		 * - issuingPlace
		 * - dateArrive
		 * - status
		 */
		req.setAttribute("briefContent", briefContent);
		req.setAttribute("documentReference", documentReference);
		req.setAttribute("signer", signer);
		req.setAttribute("issuingPlace", issuingPlace);
		req.setAttribute("dateArrive", dateArrive);
		req.setAttribute("status", status);
		
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 10); // default
		
		//get start position of page
		int start = (page - 1) * limit;
		
		List<PmlEdmDocumentReceiptDTO> results = new ArrayList<PmlEdmDocumentReceiptDTO>();		
		List<PmlEdmDocumentReceipt> list = getDocumentReceiptsByUser(PortalUtil.getUserId(req));
		List<PmlEdmDocumentReceipt> documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil
							.filter(list, briefContent, signer, dateArrive, documentReference, issuingPlace, status);
		
		List<PmlEdmDocumentReceiptDTO> subResults = new ArrayList<PmlEdmDocumentReceiptDTO>();
		for (PmlEdmDocumentReceipt docReceipt : documentReceipts) {
			PmlEdmDocumentReceiptDTO docDTO = populateDocumentReceiptToDTO(req, docReceipt);
			subResults.add(docDTO);
		}
		
		try {
			subResults = sort(subResults, 0, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int totalItems = subResults.size();
		int totalPages = totalItems / limit;
		totalPages = totalItems % limit == 0 ? totalPages : totalPages + 1;
		
		//get end position of page
		int end = Math.min(page * limit, totalItems);
		
		for (int i = start; i < end; i++) {
			results.add(subResults.get(i));
		}
		// set attributes
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalItems", totalItems);
		req.setAttribute("documentDTOs", results);
		
		return results;
	}
	/**
	 * @param list
	 * @param sort
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	private List<PmlEdmDocumentReceiptDTO> sort(List<PmlEdmDocumentReceiptDTO> list, int sort, int flag) throws Exception {
		
		int len = list.size();
		int i, j;
		Collator viCollator = Collator.getInstance(new Locale("vi"));
		
		for(i = 0; i < len - 1; i ++) {
			for(j = i + 1; j < len; j ++) {
				
				String str1, str2;
				switch(sort) {
					
					case 1:
						str1 = ((PmlEdmDocumentReceiptDTO) list.get(i)).getNumberLocalDocumentReceipt();
						str2 = ((PmlEdmDocumentReceiptDTO) list.get(j)).getNumberLocalDocumentReceipt();
						break;
						
					case 2:
						str1 = ((PmlEdmDocumentReceiptDTO) list.get(i)).getDocumentReference();
						str2 = ((PmlEdmDocumentReceiptDTO) list.get(j)).getDocumentReference();
						break;
						
					case 3:
						str1 = new SimpleDateFormat("yyyy/MM/dd").format(((PmlEdmDocumentReceiptDTO) list.get(i)).getDateArrive());
						str2 = new SimpleDateFormat("yyyy/MM/dd").format(((PmlEdmDocumentReceiptDTO) list.get(j)).getDateArrive());
						break;
						
					case 4:
						str1 = ((PmlEdmDocumentReceiptDTO) list.get(i)).getIssuingPlaceName();
						str2 = ((PmlEdmDocumentReceiptDTO) list.get(j)).getIssuingPlaceName();
						break;
						
					case 5:
						str1 = ((PmlEdmDocumentReceiptDTO) list.get(i)).getBriefContent();
						str2 = ((PmlEdmDocumentReceiptDTO) list.get(j)).getBriefContent();
						break;
					default:
						str1 = new SimpleDateFormat("yyyy/MM/dd").format(((PmlEdmDocumentReceiptDTO) list.get(i)).getDateArrive())
									+ ((PmlEdmDocumentReceiptDTO) list.get(i)).getIssuingPlaceName()
									+ ((PmlEdmDocumentReceiptDTO) list.get(i)).getNumberLocalDocumentReceipt()
									+ ((PmlEdmDocumentReceiptDTO) list.get(i)).getDocumentReference()
									+ ((PmlEdmDocumentReceiptDTO) list.get(i)).getBriefContent();
						str2 = new SimpleDateFormat("yyyy/MM/dd").format(((PmlEdmDocumentReceiptDTO) list.get(j)).getDateArrive())
							 		+ ((PmlEdmDocumentReceiptDTO) list.get(j)).getIssuingPlaceName()
									+ ((PmlEdmDocumentReceiptDTO) list.get(j)).getNumberLocalDocumentReceipt()
									+ ((PmlEdmDocumentReceiptDTO) list.get(j)).getDocumentReference()
									+ ((PmlEdmDocumentReceiptDTO) list.get(j)).getBriefContent();
						break;
				}
				
				if (flag == 1) { // sort down
					if(viCollator.compare(str1, str2) < 0) {
						PmlEdmDocumentReceiptDTO temp = (PmlEdmDocumentReceiptDTO) list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				} else { // sort up
					if (viCollator.compare(str1, str2) > 0) {
						PmlEdmDocumentReceiptDTO temp = (PmlEdmDocumentReceiptDTO) list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
		return list;
	}
}
