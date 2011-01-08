package com.sgs.portlet.document.sendprocess.action;

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
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

public class ViewAction extends DocumentSendPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, "action");
		List<DocumentSendDTO> documentDTOs = getListDocumentSendDTO(req, res);
		if (action.equals("sort")) {
			int flag = ParamUtil.getInteger(req, "flag", 0);
			if (flag == 0) {
				flag = 1;
			}else {
				flag = 0;
			}
			int sort = ParamUtil.getInteger(req, "sort", 0);
			documentDTOs = sort(documentDTOs, sort, flag);
			req.setAttribute("flag", flag);
		}
		req.setAttribute("documentSends", documentDTOs);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); 
		} else {
			return mapping.findForward("portlet.sgs.document.sendprocess.view");
		}
	}
	
	private List<DocumentSendDTO> getListDocumentSendDTO(RenderRequest req, RenderResponse res) {
		
		// get current page, by default current page is 1
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page, by default current page is 10
		int limit = ParamUtil.getInteger(req, "limit", 10); 
		
		//get start position of page
		int start = (page - 1) * limit;
		
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentReference = ParamUtil.getString(req, "documentReference");
		//String signer = ParamUtil.getString(req, "signer");
		String issuingPlace = ParamUtil.getString(req, "issuingPlace");
		Date dateArrive = ParamUtil.getDate(req, "receiveDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		String status = ParamUtil.getString(req, "status");
		
		req.setAttribute("briefContent", briefContent);
		req.setAttribute("documentReference", documentReference);
		//req.setAttribute("signer", signer);
		req.setAttribute("issuingPlace", issuingPlace);
		req.setAttribute("dateArrive", dateArrive);
		req.setAttribute("status", status);
		
		List<PmlEdmDocumentSend> documentSends = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
								.getListPmlEdmDocumentSendsByUser(PortalUtil.getUserId(req));
		System.out.println("---------------------------------------------------------------------------------------------------");
		if (documentSends != null) {
			System.out.println("Size of Documents Send:" + documentSends.size());
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		documentSends = PmlEdmDocumentSendLocalServiceUtil.filter(documentSends, briefContent, dateArrive, documentReference, issuingPlace);
		List<DocumentSendDTO> documentSendDTOs = new ArrayList<DocumentSendDTO>();
		for(PmlEdmDocumentSend documentSend : documentSends) {
			DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(documentSend);
			documentSendDTOs.add(documentSendDTO);
		}
		
		try {
			//documentSendDTOs = sort(documentSendDTOs, 0, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalItems = documentSendDTOs.size();
		int totalPages = totalItems / limit;
		totalPages = totalItems % limit == 0 ? totalPages : totalPages + 1;
		
		//get end position of page
		int end = Math.min(page * limit, totalItems);
		List<DocumentSendDTO> results = new ArrayList<DocumentSendDTO>();
		
		for (int i = start; i < end; i++) {
			results.add(documentSendDTOs.get(i));
		}
		
		//set attributes
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalItems", totalItems);
		req.setAttribute("documentSends", results);
		
		return results;
	}
	
	/**
	 * @param list
	 * @param sort
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	private List<DocumentSendDTO> sort(List<DocumentSendDTO> list, int sort, int flag) throws Exception {
		
		int len = list.size();
		int i, j;
		Collator viCollator = Collator.getInstance(new Locale("vi"));
		
		for (i = 0; i < len - 1; i ++) {
			for (j = i + 1; j < len; j ++) {
				
				String str1, str2;
				switch(sort) {
				
					case 1:
						str1 = ((DocumentSendDTO) list.get(i)).getDocumentReference();
						str2 = ((DocumentSendDTO) list.get(j)).getDocumentReference();
						break;
						
					case 2:
						str1 = new SimpleDateFormat("yyyy/MM/dd").format(((DocumentSendDTO) list.get(i)).getDateCreate());
						str2 = new SimpleDateFormat("yyyy/MM/dd").format(((DocumentSendDTO) list.get(j)).getDateCreate());
						break;
						
					case 3:
						str1 = ((DocumentSendDTO) list.get(i)).getReceivingPlace();
						str2 = ((DocumentSendDTO) list.get(j)).getReceivingPlace();
						break;
						
					case 4:
						str1 = ((DocumentSendDTO) list.get(i)).getBriefContent();
						str2 = ((DocumentSendDTO) list.get(j)).getBriefContent();
						break;
						
					default:
						str1 = new SimpleDateFormat("yyyy/MM/dd").format(((DocumentSendDTO) list.get(i)).getDateCreate())
								+ ((DocumentSendDTO) list.get(i)).getReceivingPlace()
								+ ((DocumentSendDTO) list.get(i)).getDocumentReference()
								+ ((DocumentSendDTO) list.get(i)).getBriefContent();
						str2 = new SimpleDateFormat("yyyy/MM/dd").format(((DocumentSendDTO) list.get(j)).getDateCreate())
								+ ((DocumentSendDTO) list.get(j)).getReceivingPlace()
								+ ((DocumentSendDTO) list.get(j)).getDocumentReference()
								+ ((DocumentSendDTO) list.get(j)).getBriefContent();
						break;
				}
				
				if (flag == 1) { // sort down
					if(viCollator.compare(str1, str2) < 0) {
						DocumentSendDTO temp = (DocumentSendDTO) list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				} else { // sort up
					if(viCollator.compare(str1, str2) > 0) {
						DocumentSendDTO temp = (DocumentSendDTO) list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
		return list;
	}
	
}
