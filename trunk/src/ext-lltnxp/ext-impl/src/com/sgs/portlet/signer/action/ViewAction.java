package com.sgs.portlet.signer.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.signer.NoSuchSignerException;
import com.sgs.portlet.signer.model.Signer;
import com.sgs.portlet.signer.model.impl.SignerImpl;
import com.sgs.portlet.signer.service.SignerLocalServiceUtil;
import com.sgs.portlet.signer.service.persistence.SignerUtil;

public class ViewAction extends PortletAction {
	/**
	 * @method processAction
	 * @return void
	 * goi phuong thuc updateSignerChecked
	 */
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			
		} else {
			
			req.setAttribute("afterCheckFlag", ParamUtil.getString(req, "afterCheckFlag","false"));
			req.setAttribute("beforeCheckFlag", ParamUtil.getString(req, "beforeCheckFlag", "false"));
			updateSignerChecked(req);
				
			boolean search = ParamUtil.getBoolean(req, "search");
			PortletSession session = req.getPortletSession();
			session.setAttribute("search", search ,PortletSession.APPLICATION_SCOPE);
		}
		return mapping.findForward("portlet.sgs.signer.view");
	}
	/**
	 * @method updateSignerChecked	
	 * @param actionRequest
	 * @return void
	 * Lay danh sach userId cua nhung user duoc check va khong duoc check
	 */
	private void updateSignerChecked(RenderRequest req) throws PortalException,
			SystemException {
		//lay tat ca userId duoc check
		long[] addUserIds = StringUtil.split(ParamUtil.getString(req,
				"addUserIds"), 0L);
		//lay tat ca userId ko duoc check
		long[] removeUserIds = StringUtil.split(ParamUtil.getString(req,
				"removeUserIds"), 0L);
		addSigner(addUserIds);
		removeSigner(removeUserIds);
	}
	/**
	 * @method addSigner	
	 * @param addUserIds
	 * @return void
	 * kiem tra user duoc check co trong bang pml_signer, neu ko co trong bang thi add vao
	 */
	private void addSigner(long[] addUserIds) {
		Signer signer = null;
		long userId = 0;
		for (int i = 0; i < addUserIds.length; i++) {
			userId = addUserIds[i];

			try {
				signer = SignerUtil.findByUserId(userId);
			} catch (NoSuchSignerException e) {
				signer = null;
			} catch (SystemException e) {
				signer = null;
			}

			if (signer == null) {
				signer = new SignerImpl();
				try {
					signer.setSignerId(CounterLocalServiceUtil.increment());
					signer.setUserId(userId);
					SignerLocalServiceUtil.addSigner(signer);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @method removeSigner	
	 * @param removeUserIds
	 * @return void
	 * kiem tra user khong duoc check co trong bang pml_signer khong, neu co thi remove
	 */
	private void removeSigner(long[] removeUserIds) {

		Signer signer = null;
		long userId = 0;

		for (int j = 0; j < removeUserIds.length; j++) {
			userId = removeUserIds[j];
			try {
				signer = SignerUtil.findByUserId(userId);
			} catch (NoSuchSignerException e1) {
				signer = null;
			} catch (SystemException e1) {
				signer = null;
			}

			if (signer != null) {
				try {
					SignerLocalServiceUtil.deleteSigner(signer);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
