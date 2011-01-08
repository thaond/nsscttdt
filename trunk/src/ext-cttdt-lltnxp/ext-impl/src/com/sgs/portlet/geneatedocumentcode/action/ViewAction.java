/**
 * @author triltm
 * @since 10/04/2009
 * @version 1.1
 */

package com.sgs.portlet.geneatedocumentcode.action;

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
import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.model.impl.IdGeneratedImpl;
import com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedUtil;
import com.sgs.portlet.generatetemplateid.service.persistence.IdTemplateUtil;

public class ViewAction extends PortletAction {
	// Yenlt update 28/01/2010
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
			} else if (cmd.equals(Constants.EDIT)) {
				long generateId = ParamUtil.getLong(req, "generateId");
				req.setAttribute("generateId", generateId);
				setForward(req, "portlet.sgs.geneatedocumentcode.add_edit");
			}
		}
				
	}
	
	public void addIdGenerated(ActionRequest req){
		long idGeneratedId = ParamUtil.getLong(req, "generateId");
		long format = ParamUtil.getLong(req, "format",0);
		String year = ParamUtil.getString(req, "year", "09");
		String flag = ParamUtil.get(req, "flag", "");
		long currentNumber = ParamUtil.getLong(req, "currentNumber", 1);
		IdGenerated idGenerated = null;
		
		if ("update".equals(flag)) {
			
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
			
		} else if ("add".equals(flag)) {
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
		
				String tab = ParamUtil.getString(req, "tab","");
				
				List<IdGenerated> idGeneratedList = IdGeneratedUtil.findAll();
				
				List<Long> idGeneratedIdList = new ArrayList<Long>();
				for (IdGenerated idGenerated : idGeneratedList) {
					long idGeneratedId = idGenerated.getId();
					idGeneratedIdList.add(idGeneratedId);
				}
				
				List<IdTemplate> idTemplateList = IdTemplateUtil.findAll();
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
				
				if ("add_new".equals(tab)) {
					setForward(req, "portlet.sgs.geneatedocumentcode.add_edit");
				}
				
				if (getForward(req) != null && !getForward(req).equals("")) {
					return mapping.findForward(getForward(req)); // Use forward set in
				}
				else {
					return mapping.findForward("portlet.sgs.geneatedocumentcode.view");
				}
	}

}
