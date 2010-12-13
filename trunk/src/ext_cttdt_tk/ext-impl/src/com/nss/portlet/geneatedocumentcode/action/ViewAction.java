package com.nss.portlet.geneatedocumentcode.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.model.impl.IdGeneratedImpl;
import com.nss.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if ( (cmd.equals(Constants.UPDATE)) ||(cmd.equals(Constants.ADD)) ) {
				addIdGenerated(req);
			} else if (cmd.equals(Constants.DELETE)) {
				deleteIdGenerated(req);
			}
		}
	}

	public void addIdGenerated(ActionRequest req){
		String cmd = ParamUtil.getString(req, Constants.CMD);
		long idGeneratedId = ParamUtil.getLong(req, "generateId");
		long format = ParamUtil.getLong(req, "format",0);
		String year = ParamUtil.getString(req, "year", "09");
		long currentNumber = ParamUtil.getLong(req, "currentNumber", 1);
		IdGenerated idGenerated = null;
		
		if (cmd.equals(Constants.UPDATE)) {
			
			try {
				idGenerated = IdGeneratedLocalServiceUtil.getIdGenerated(idGeneratedId);
			} catch (PortalException e) {
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			if (null != idGenerated) {
				try {
					idGenerated.setYear(year);
					idGenerated.setCurValue(currentNumber);
					IdGeneratedLocalServiceUtil.updateIdGenerated(idGenerated);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
			}
			
		} else if (cmd.equals(Constants.ADD)) {
			try {
				idGenerated = new IdGeneratedImpl();
				idGenerated.setId(format);
				idGenerated.setYear(year);
				idGenerated.setCurValue(currentNumber);
				IdGeneratedLocalServiceUtil.addIdGenerated(idGenerated);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteIdGenerated( ActionRequest req) {
		long generateId = ParamUtil.getLong(req, "generateId");
		
		IdGenerated generated = null;
		IdTemplate template = null;
		try {
			generated = IdGeneratedLocalServiceUtil.getIdGenerated(generateId);
			template = IdTemplateLocalServiceUtil.getIdTemplate(generateId);
		} catch (PortalException e) {
			generated = null;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if (null!= generated && null!= template) {
			if (generated.getCurValue() > Long.parseLong(template.getStartNumber())) {
				req.setAttribute("delete", false);
			} else {
				try {
					IdGeneratedLocalServiceUtil.deleteIdGenerated(generated);
					req.setAttribute("delete", true);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<IdGenerated> idGeneratedList = IdGeneratedLocalServiceUtil.getIdGenerateds(-1, -1);
			
			List<Long> idGeneratedIdList = new ArrayList<Long>();
			for (IdGenerated idGenerated : idGeneratedList) {
				long idGeneratedId = idGenerated.getId();
				idGeneratedIdList.add(idGeneratedId);
			}
			
			List<IdTemplate> idTemplateList = IdTemplateLocalServiceUtil.getIdTemplates(-1, -1);
			List<IdTemplate> idTemplateResults = new ArrayList<IdTemplate>();
			
			for (IdTemplate idTemplate : idTemplateList) {
				if (!idGeneratedIdList.contains(idTemplate.getTemplateId())) {	
					idTemplateResults.add(idTemplate);
				}
			}
			
			String listIdTemplate = "";
			
			for ( int i=0; i < idTemplateResults.size(); i++) {
				if ( i == idTemplateResults.size()-1) {
					listIdTemplate += idTemplateResults.get(i).getTemplateId() + "";
				} else {
					listIdTemplate += idTemplateResults.get(i).getTemplateId() + ",";
				}
			}
			req.setAttribute("idTemplateResults", idTemplateResults);
			req.setAttribute("listIdTemplate", listIdTemplate);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.geneatedocumentcode.view");
			}
	}

}
