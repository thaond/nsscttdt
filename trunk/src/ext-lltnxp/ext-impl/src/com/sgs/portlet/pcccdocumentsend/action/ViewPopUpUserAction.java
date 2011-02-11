package com.sgs.portlet.pcccdocumentsend.action;

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

import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pcccdocumentsend.dto.UserDTO;


public class ViewPopUpUserAction extends PortletAction {
	
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		
		
		
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		List<UserDTO> userDTOList =	new ArrayList<UserDTO>();

		
		List<User > listUser=UserUtil.findAll();
		
		for (User user : listUser) {
			UserDTO dto = new UserDTO();
			dto.setUserId(user.getUserId());
			dto.setAccount(user.getScreenName());
			dto.setUserName(PmlUserLocalServiceUtil.getFullName(user.getUserId()));

			userDTOList.add(dto);
		}

		req.setAttribute("userDTOList", userDTOList);

			
				return mapping.findForward("portlet.sgs.pcccdocumentsend.viewpopupuser");
			
	}
	
	
}
