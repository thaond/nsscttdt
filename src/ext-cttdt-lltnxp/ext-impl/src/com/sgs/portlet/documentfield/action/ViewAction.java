package com.sgs.portlet.documentfield.action;


import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.documentfield.dto.DocumentFieldDTO;
import com.sgs.portlet.field.FieldCanNotDeleteException;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.PmlFieldLocalServiceUtil;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;

public class ViewAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			String action = ParamUtil.getString(req, Constants.CMD, "");
			// yenlt update 24082010
			try {
				if (Constants.DELETE.equals(action)) {
					deleteField(req);
				}
				if (Validator.isNotNull(action)) {
					String fieldURL = ParamUtil.getString(req, "fieldURL");
					sendRedirect(req, res, fieldURL);
				}
			} catch (Exception e) {
				if (e instanceof FieldCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
				}
				else {
					throw e;
				}
			}
			 /* yenlt close 24082010
			String redirect = ParamUtil.getString(req, "redirect", "");
			if (Constants.DELETE.equals(action)) {
				String fieldId = ParamUtil.getString(req, "fieldId");
				
				List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
				try {
					fileTypeList = PmlFileTypeUtil.findByFieldId(fieldId);
				} catch (Exception e) {
					
				}
				if (fileTypeList.size() == 0){
					
//					FieldLocalServiceUtil.deleteField(fieldId);
					PmlFieldLocalServiceUtil.deletePmlField(fieldId);
					req.getPortletSession().setAttribute("field", Constants.DELETE, PortletSession.APPLICATION_SCOPE);
				}
				else {
					req.setAttribute("delete", false);
				}
				res.sendRedirect(redirect);
			}
			*/
	}
		
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
	
			List<PmlField> listfield = PmlFieldUtil.findAll();
			List<DocumentFieldDTO> results = new ArrayList<DocumentFieldDTO>();
			for (PmlField field : listfield) {
				DocumentFieldDTO fieldDTO = DocumentFieldDTO.convertDocumentFieldToDTO(field);
				results.add(fieldDTO);
			}
			req.setAttribute("listfield",results);
			return mapping.findForward("portlet.sgs.documentfield.view");
	}
	// yenlt update 24082010
	public void deleteField(ActionRequest req) throws Exception {
		String fieldId = ParamUtil.getString(req, "fieldId");
		PmlFieldLocalServiceUtil.removeAgency(fieldId);
	}
}
