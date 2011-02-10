/**
 * 
 */
package com.sgs.portlet.issuingplace.action;

import java.util.ArrayList;
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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailUtil;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;

/**
 * @author thoind
 *
 */
public class AddLevelSend extends PortletAction {
	private static Log _log = LogFactory.getLog(AddLevelSend.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	// Yenlt update 08/02/2010
	@Override
	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {
		
		String cmd = ParamUtil.getString(req,Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");	
		if (Validator.isNotNull(cmd)&& cmd.equals(Constants.ADD)) {
			updateLevelSendChecked(req);
		}
		
		sendRedirect(req, res, redirect);
	}


	@Override
	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {
		
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");	
		//lay danh sach cap gui 
		List<PmlEdmLevelSend> listlevelsend = new ArrayList<PmlEdmLevelSend>();
		try {
			listlevelsend = PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSends(-1, -1);
		} catch (Exception e) {
			_log.error("NO GET LIST PMLEDMLEVELSEND");
			_log.error(e);
		}
		
		req.setAttribute("issuingPlaceId",issuingPlaceId);
		req.setAttribute("listlevelsend",listlevelsend);
		
		return mapping.findForward("portlet.sgs.issuingplace.addlevelsend");
	}
	
	public void updateLevelSendChecked(ActionRequest req) {
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");	
		String[] adds = ParamUtil.getString(req, "addDetailIds" ).split(",");
		String[] removes = ParamUtil.getString(req, "removeDetailIds").split(",");
		
		int[] addLevelSendIds = new int [0];
		int[] removeLevelSendIds = new int [0];
		
		if (!"".equals(ParamUtil.getString(req, "addDetailIds" ))) {
			addLevelSendIds = new int [adds.length];
		}
		
		if (!"".equals(ParamUtil.getString(req, "removeDetailIds"))) {
			removeLevelSendIds = new int [removes.length];
		}
		
		for (int i = 0; i < addLevelSendIds.length; i++) {
			addLevelSendIds[i] = Integer.parseInt(adds[i]);
		}
		
		for (int i = 0; i < removeLevelSendIds.length; i++) {
			removeLevelSendIds[i] = Integer.parseInt(removes[i]);
		}
		
		addLevelSend(addLevelSendIds, issuingPlaceId);
		removeLevelSend(removeLevelSendIds, issuingPlaceId);
	}
	
	public void addLevelSend(int[] addLevelSendIds, String issuingPlaceId) {
		
		PmlEdmLevelSendDetail levelSendDetail = null;
		int levelSendId = 0;
		for ( int i=0; i <addLevelSendIds.length; i++) {
			levelSendId = addLevelSendIds[i];
			
			try {
				levelSendDetail = PmlEdmLevelSendDetailUtil.findByLevelSendId_IssuingPlaceId(levelSendId, issuingPlaceId);
			} catch (NoSuchPmlEdmLevelSendDetailException e1) {
				levelSendDetail = null;
			} catch (SystemException e1) {
				levelSendDetail = null;
			}
			
			if ( null == levelSendDetail) {
				levelSendDetail = new PmlEdmLevelSendDetailImpl();
				
				levelSendDetail.setLevelSendId(levelSendId);
				levelSendDetail.setIssuingPlaceId(issuingPlaceId);
				
				try {
					PmlEdmLevelSendDetailLocalServiceUtil.addPmlEdmLevelSendDetail(levelSendDetail);
				} catch (SystemException e) {
					_log.error("NO ADD LIST PMLEDMLEVELSEND INTO PMLEDMISSUINGPLACE");
					_log.error(e);
				}
			}
		}
	}
	
	public void removeLevelSend(int[] removeLevelSendIds, String issuingPlaceId) {
		PmlEdmLevelSendDetail levelSendDetail = null;
		int levelSendId = 0;
	
		for ( int i=0; i <removeLevelSendIds.length; i++) {
			levelSendId = removeLevelSendIds[i];
			
			try {
				levelSendDetail = PmlEdmLevelSendDetailUtil.findByLevelSendId_IssuingPlaceId(levelSendId, issuingPlaceId);
			} catch (Exception e) {
				levelSendDetail = null;
				_log.error("NO GET PMLEDMLEVELSENDDETAIL");
				_log.error(e);
			}
			
			if ( null != levelSendDetail) {
				
				try {
					PmlEdmLevelSendDetailLocalServiceUtil.deletePmlEdmLevelSendDetail(levelSendDetail);
				} catch (SystemException e) {
					_log.error("NO DELETE PMLEDMLEVELSEND IN PMLEDMLEVELSENDDETAIL");
					_log.error(e);
				}
			}
		}
	}
}
