/**
 * Luu thong tin khi cong van di duoc tra ve yeu cau bo sung
 * Sau do he thong chuyen ve trang hien thi danh sach
 */
package com.sgs.portlet.document.sendprocess.action;

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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.onedoor.model.PmlAgencyLeader;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.onedoor.service.persistence.PmlAgencyLeaderUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * @author doanhdv
 *
 */
public class GiveOpinionAndMoveToAgencyLeaderAction extends DocumentSendPortletAction {
	
	private static Log _log = LogFactory.getLog(GiveOpinionAndMoveToAgencyLeaderAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		_log.info("process move to agency leader action");
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			//_log.info("----------Prepare data for view ----------");
			
			// sender is login user
			long userId = PortalUtil.getUserId(req);
			String sender = PortalUtil.getUserName(userId, "");
			
			// receiver is AgencyLeader of User.
			long receiverId = getAgencyLeader(userId);
			String receiver = PortalUtil.getUserName(receiverId, "");
			
			req.setAttribute("sender", sender);
			req.setAttribute("senderId", "" + userId);
			
			req.setAttribute("receiver", receiver);
			req.setAttribute("receiverId", "" + receiverId);
			
			return mapping.findForward("portlet.sgs.document.sendprocess.giveOpinionAndMoveToAgencyLeader");
		}
	}
	
	/**
	 * get agency leader of an user via given userId
	 * @param userId
	 * @return
	 */
	private long getAgencyLeader(long userId) {
		PmlUser user = null;

		//System.out.println("User Id = " + userId);
		
		// get user in SGS Core
		try {
			user = PmlUserUtil.findByPrimaryKey(userId);
		} catch (Exception e) {
			_log.info("PML_User Not Found -> Department Leader Not found");
		}
		
		// user not found return -1
		if (Validator.isNull(user)) {
			return -1;
		}
		
		// get department leader of user.
		String departmentId = user.getDepartmentsId();
		
		//System.out.println("Department Id = " + departmentId);
		
		Department department = null;
		try {
			department = DepartmentUtil.findByPrimaryKey(departmentId);
		} catch (Exception e) {
			_log.info("Department Leader Not found");
		}
		
		// deparment leader not found, return -1
		if (Validator.isNull(department)) {
			return -1;
		}
		
		//System.out.println("Agency Id = " + department.getAgencyId());
		
		// get agency leader of department 
		PmlAgencyLeader aLeader = null;
		
		try {
			aLeader = PmlAgencyLeaderUtil.findByPrimaryKey(department.getAgencyId());
		} catch (Exception e) {
		}
		
		if (Validator.isNull(aLeader)) {
			return -1;
		}
		
		//System.out.println("Agency Leader = " + aLeader.getUserId());
		// return userId of department leader
		return aLeader.getUserId();
	}
}
