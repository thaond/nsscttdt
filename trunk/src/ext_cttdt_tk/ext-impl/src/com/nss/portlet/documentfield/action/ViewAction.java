package com.nss.portlet.documentfield.action;

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
import com.nss.portlet.documentfield.FieldCanNotDeleteException;
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil;
import com.nss.portlet.documentfield.util.DocumentFieldDTO;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, Constants.CMD, "");
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
	}

	public void deleteField(ActionRequest req) throws Exception {
		String fieldId = ParamUtil.getString(req, "fieldId");
		PmlFieldLocalServiceUtil.removePmlField(fieldId);
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<PmlField> listfield = PmlFieldLocalServiceUtil.getPmlFields(-1, -1);
				List<DocumentFieldDTO> results = new ArrayList<DocumentFieldDTO>();
				for (PmlField field : listfield) {
					DocumentFieldDTO fieldDTO = DocumentFieldDTO.convertDocumentFieldToDTO(field);
					results.add(fieldDTO);
				}
				req.setAttribute("listfield",results);
				return mapping.findForward("portlet.nss.documentfield.view");
			}
	}

}
