package com.nss.portlet.qa_chu_de.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;
import com.nss.portlet.qa_chu_de.QAChuDeCauHoiCanNotDeleteException;
import com.nss.portlet.qa_chu_de.QAChuDeCauHoiTenChuDeException;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if (cmd.equals(Constants.ADD)) {
				addQAChuDeCauHoi(req);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteChuDeCauHoi(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateChuDeCauHoi(req);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveQAChuDeCauHoi(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String chuDeCauHoiURL = ParamUtil.getString(req, "chuDeCauHoiURL");
				sendRedirect(req, res, chuDeCauHoiURL);
			}
		} catch (Exception e) {
			if (e instanceof QAChuDeCauHoiCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof NoSuchQAChuDeCauHoiException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
			}
			else if (e instanceof QAChuDeCauHoiTenChuDeException) {
				String tenChuDeCauHoi = ParamUtil.getString(req, "tenChuDeCauHoi");
				req.setAttribute("tenChuDeCauHoi", tenChuDeCauHoi);
				req.setAttribute("QAChuDeCauHoiAUFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	public void deleteChuDeCauHoi(ActionRequest req) throws PortalException, SystemException {
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi");
		QAChuDeCauHoiLocalServiceUtil.deleteQAChuDeCauHoi(maChuDeCauHoi);
	}
	
	public QAChuDeCauHoi updateChuDeCauHoi(ActionRequest req) throws PortalException, SystemException {
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi");
		String tenChuDeCauHoi = ParamUtil.getString(req, "tenChuDeCauHoi");
		QAChuDeCauHoi chuDeCauHoi = QAChuDeCauHoiLocalServiceUtil.updateQAChuDeCauHoi(maChuDeCauHoi, tenChuDeCauHoi);
		return chuDeCauHoi;	
	}
	
	public void updateActiveQAChuDeCauHoi(ActionRequest req, ActionResponse res) {
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi");
		QAChuDeCauHoi chuDeCauHoi = null;
		try {
			chuDeCauHoi = QAChuDeCauHoiLocalServiceUtil.getQAChuDeCauHoi(maChuDeCauHoi);
			if(0 == chuDeCauHoi.getActive()) {
				chuDeCauHoi.setActive(1);
				QAChuDeCauHoiLocalServiceUtil.updateQAChuDeCauHoi(chuDeCauHoi, true);
			} else {
				chuDeCauHoi.setActive(0);
				QAChuDeCauHoiLocalServiceUtil.updateQAChuDeCauHoi(chuDeCauHoi, true);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public QAChuDeCauHoi addQAChuDeCauHoi(ActionRequest req) throws PortalException, SystemException {
		String tenChuDeCauHoi = ParamUtil.getString(req, "tenChuDeCauHoi");
		QAChuDeCauHoi chuDeCauHoi = QAChuDeCauHoiLocalServiceUtil.addQAChuDeCauHoi(tenChuDeCauHoi);
		return chuDeCauHoi;
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD);
	
			if (cmd.equals(Constants.EDIT)) {
				getQAChuDeCauHoi(req);
			}
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.qa_chu_de.view");
			}
	}
	
	public void getQAChuDeCauHoi(RenderRequest req) {
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi");
		QAChuDeCauHoi chuDeCauHoi = null;
		try {
			chuDeCauHoi = QAChuDeCauHoiLocalServiceUtil.getQAChuDeCauHoi(maChuDeCauHoi);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("chuDeCauHoi", chuDeCauHoi);
		
	}

}
