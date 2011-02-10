package com.sgs.portlet.delegate.action;

/**
 * @author triltm
 * @author minhnv
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;
import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalServiceUtil;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateUtil;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalServiceUtil;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegateUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ViewAction extends PortletAction {

	// Yenlt update 06/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, Constants.ACTION, "");
		if (Constants.ADD.equals(action)) {
			updateDelegate(req);
		} else if (Constants.DEACTIVATE.equals(action)) {
			deactiveDelegate(req);
		}
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		List<PmlDelegate> delegates = getListDelegates(req);
		String[] pmlFileTypeChecked = req.getParameterValues("fileTypes"); 
		
		if (Constants.ADD.equals(cmd)) {
			addDelegate(req);
		}

		req.setAttribute("delegates", delegates);
		req.setAttribute("pmlFileTypeChecked", pmlFileTypeChecked);
		return mapping.findForward("portlet.sgs.delegate.view");
	}

	/**
	 * Get data for form Add
	 * 
	 * @param req
	 * @throws Exception
	 */
	private void addDelegate(RenderRequest req) {
		User userLogin = null;
		String assigner = "";
		List<User> receivers = new ArrayList<User>();
		List<PmlFileType> fileTypes;
		try {
			userLogin = PortalUtil.getUser(req);
		} catch (PortalException e) {
			userLogin = null;
		} catch (SystemException e) {
			userLogin = null;
		}
		if (userLogin != null) {
			assigner = userLogin.getLastName() + " "
					+ userLogin.getMiddleName() + " "
					+ userLogin.getFirstName();

		}

		try {
			fileTypes = PmlFileTypeUtil.findAll();
		} catch (SystemException e) {
			fileTypes = new ArrayList<PmlFileType>();
		}

		long userLoginId = userLogin.getUserId();
		PmlUser pmlUserLogin = null;
		try {
			pmlUserLogin = PmlUserUtil.findByPrimaryKey(userLoginId);
		} catch (NoSuchPmlUserException e) {
			pmlUserLogin = null;
		} catch (SystemException e) {
			pmlUserLogin = null;
		}

		if (pmlUserLogin != null) {
			String departmentId = pmlUserLogin.getDepartmentsId();
			List<PmlUser> receiverTemps;
			try {
				receiverTemps = PmlUserUtil.findByDepartmentsId(departmentId);
			} catch (SystemException e) {
				receiverTemps = new ArrayList<PmlUser>();
			}

			for (PmlUser userReceiver : receiverTemps) {

				if (userReceiver.getUserId() != userLoginId) {
					User user;
					try {
						user = UserUtil.findByPrimaryKey(userReceiver
								.getPrimaryKey());
					} catch (NoSuchUserException e) {
						user = null;
					} catch (SystemException e) {
						user = null;
					}
					if (user != null) {
						receivers.add(user);
					}
				}
			}
		}

		req.setAttribute("assigner", assigner);
		req.setAttribute("fileTypes", fileTypes);
		req.setAttribute("receivers", receivers);
	}

	/**
	 * Get list delegates for form display to display data
	 * 
	 * @param req
	 * @return List<PmlDelegate>
	 * @throws Exception
	 */
	private List<PmlDelegate> getListDelegates(RenderRequest req) {
		long assignerId = PortalUtil.getUserId(req);
		List<PmlDelegate> delegates = new ArrayList<PmlDelegate>();
		try {
			delegates = PmlDelegateUtil.findByAssigner(assignerId);
		} catch (Exception e) {
			delegates = new ArrayList<PmlDelegate>();
		}

		return delegates;
	}

	/**
	 * to add a new delegate
	 * 
	 * @param req
	 * @throws Exception
	 */
	private void updateDelegate(ActionRequest req) {
		// update delegate object
		long assigner = PortalUtil.getUserId(req);
		long receiver = ParamUtil.getLong(req, "receiver");
		Date startDate = ParamUtil.getDate(req, "startDate",
				new SimpleDateFormat("dd/MM/yyyy"));
		Date endDate = ParamUtil.getDate(req, "endDate", new SimpleDateFormat(
				"dd/MM/yyyy"));

		long delegateId = 0;
		try {
			delegateId = CounterUtil.increment();
		} catch (SystemException e) {

		}
		PmlDelegate delegate = PmlDelegateUtil.create(delegateId);

		delegate.setAssigner(assigner);
		delegate.setReceiver(receiver);
		delegate.setStartDate(startDate);
		delegate.setEndDate(endDate);
		delegate.setDateCreated(new Date());
		delegate.setCancelDelegate("0");

		try {
			PmlDelegateLocalServiceUtil.updatePmlDelegate(delegate);
		} catch (SystemException e) {
		}

		// update file type delegate
//		String[] fileTypeArr = req.getParameterValues("pmlFileTypeChecked");
		String[] fileTypeArr = req.getParameterValues("fileTypes");
		String fileTypeId = "";
		if (fileTypeArr != null && fileTypeArr.length > 0) {
			for (int i = 0; i < fileTypeArr.length; i++) {
				fileTypeId = fileTypeArr[i];
				long fileTypeDelegateId = 0;
				try {
					fileTypeDelegateId = CounterUtil.increment();
				} catch (SystemException e) {
				}

				PmlFileTypeDelegate fileTypeDelegate = PmlFileTypeDelegateUtil
						.create(fileTypeDelegateId);
				fileTypeDelegate.setFileTypeId(fileTypeId);
				fileTypeDelegate.setDelegateId(delegateId);

				try {
					PmlFileTypeDelegateLocalServiceUtil
							.updatePmlFileTypeDelegate(fileTypeDelegate);
				} catch (SystemException e) {
				}
			}
		}

	}

	/**
	 * to deactive a selected delegate by set cancelDelegate to "1" and set
	 * cancelDate to current date
	 * 
	 * @param req
	 * @throws Exception
	 */
	private void deactiveDelegate(ActionRequest req) {
		long delegateId = ParamUtil.getLong(req, "delegateId");
		PmlDelegate delegate = null;
		try {
			delegate = PmlDelegateLocalServiceUtil.getPmlDelegate(delegateId);
		} catch (PortalException e) {
			delegate = null;
		} catch (SystemException e) {
			delegate = null;
		}
		if (null != delegate) {
			delegate.setCancelDelegate("1");
			delegate.setCancelDate(new Date());
			try {
				PmlDelegateLocalServiceUtil.updatePmlDelegate(delegate);
			} catch (SystemException e) {

			}
		}
	}

}
