package com.nss.portlet.qa_phan_quyen.action;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil;

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
		long maChuDeCauHoi = ParamUtil.getLong(req, "maChuDeCauHoi", 0);
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		List<User> userList = new ArrayList<User>();
		userList = UserLocalServiceUtil.getUsers(-1, -1);
		
		String[] views = req.getParameterValues("xem");
		String[] updates = req.getParameterValues("capnhat");
		String[] answers = req.getParameterValues("traloi");
		String[] publishs = req.getParameterValues("duyet");
		
		List<String[]> arrayRoles = new ArrayList<String[]>();
		arrayRoles.add(views);
		arrayRoles.add(updates);
		arrayRoles.add(answers);
		arrayRoles.add(publishs);
		List<String> types = new ArrayList<String>();
		types.add("view");
		types.add("update");
		types.add("answer");
		types.add("publish");
		if (Validator.isNotNull(cmd)) {
			if (Constants.ADD.equals(cmd)) {
				for (int i = 0; i < arrayRoles.size(); i++) {
					String type = types.get(i);
					String[] roles = arrayRoles.get(i);
					if (null != roles && roles.length > 0) {
						userList = UserLocalServiceUtil.getUsers(-1, -1);
						addCheckedUser(roles, userList, maChuDeCauHoi, type);
						removeUncheckUser(userList, maChuDeCauHoi, type);
					}
				}
				qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi(maChuDeCauHoi);
			} 
			else if (Constants.VIEW.equals(cmd)) {
				if (maChuDeCauHoi != 0) {
					qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi(maChuDeCauHoi);
				}
				else {
					qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.getQAPhanQuyens(-1, -1);
				}
			}
		}
 		else {
			qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.getQAPhanQuyens(-1, -1);
		}
		
		req.setAttribute("maChuDeCauHoi", maChuDeCauHoi);
		req.setAttribute("qAPhanQuyenList", qAPhanQuyenList);
		
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<QAChuDeCauHoi> qAChuDeCauHoiList = new ArrayList<QAChuDeCauHoi>();
			List<User> userList = new ArrayList<User>();
			
			qAChuDeCauHoiList = QAChuDeCauHoiLocalServiceUtil.getQAChuDeCauHois(-1, -1);
			userList = UserLocalServiceUtil.getUsers(-1, -1);
			
			req.setAttribute("userList", userList);
			req.setAttribute("qAChuDeCauHoiList", qAChuDeCauHoiList);
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.qa_phan_quyen.view");
			}
	}

	public void addCheckedUser(String[] roles, List<User> userList, long maChuDeCauHoi, String type) {
		for (int i = 0; i < roles.length; i++) {
			QAPhanQuyen phanQuyen = null;
			long maNguoiTraLoi = Long.parseLong(roles[i]);
			User userView = null;
			try {
				userView = UserLocalServiceUtil.getUser(maNguoiTraLoi);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
			if (null != userView) {
				userList.remove(userView);
			}
			phanQuyen = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi, maNguoiTraLoi);
			
			if (null == phanQuyen) {
				long maPhanQuyen = 0;
				try {
					maPhanQuyen = CounterLocalServiceUtil.increment();
					phanQuyen = QAPhanQuyenLocalServiceUtil.createQAPhanQuyen(maPhanQuyen);
					phanQuyen.setMaChuDeCauHoi(maChuDeCauHoi);
					phanQuyen.setMaNguoiTraLoi(maNguoiTraLoi);
					if ("view".equals(type)) {
						phanQuyen.setQuyenXem(true);
					}
					if ("update".equals(type)) {
						phanQuyen.setQuyenCapNhat(true);
					}
					if ("answer".equals(type)) {
						phanQuyen.setQuyenTraLoi(true);
					}
					if ("publish".equals(type)) {
						phanQuyen.setQuyenDuyet(true);
					}
					QAPhanQuyenLocalServiceUtil.addQAPhanQuyen(phanQuyen);
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
			} else {
				if ("view".equals(type)) {
					phanQuyen.setQuyenXem(true);
				}
				if ("update".equals(type)) {
					phanQuyen.setQuyenCapNhat(true);
				}
				if ("answer".equals(type)) {
					phanQuyen.setQuyenTraLoi(true);
				}
				if ("publish".equals(type)) {
					phanQuyen.setQuyenDuyet(true);
				}
				try {
					QAPhanQuyenLocalServiceUtil.updateQAPhanQuyen(phanQuyen);
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
			}
		}
	}
	
	public void removeUncheckUser(List<User> userList, long maChuDeCauHoi, String type) {
		for (int i = 0; i < userList.size(); i++) {
			QAPhanQuyen phanQuyenRemove = null;
			User userRemove = userList.get(i);
			phanQuyenRemove = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi, userRemove.getUserId());
			if (null != phanQuyenRemove) {
				try {
					if ("view".equals(type)) {
						phanQuyenRemove.setQuyenXem(false);
					}
					if ("update".equals(type)) {
						phanQuyenRemove.setQuyenCapNhat(false);
					}
					if ("answer".equals(type)) {
						phanQuyenRemove.setQuyenTraLoi(false);
					}
					if ("publish".equals(type)) {
						phanQuyenRemove.setQuyenDuyet(false);
					}
					QAPhanQuyenLocalServiceUtil.updateQAPhanQuyen(phanQuyenRemove);
						
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
			}
		}
	}
}
