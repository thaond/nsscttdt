package com.sgs.portlet.departmentleader.action;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderImpl;
import com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class SetLeaderAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		updateLeader(req);
		// phmphuc close sendRedirect 23/09/2010
//		sendRedirect(req, res, "/sgs/departmentleader/setleader");// yenlt update 24082010
		// phmphuc close 28/05/2010
//		String redirect = ParamUtil.getString(req, "redirect");
		// end
	}

	/**
	 * @author phmphuc - 23/09/2010
	 * update phuong thuc updateLeader
	 */
	private void updateLeader(ActionRequest req) throws Exception {
		

		//lay tat ca userId ko duoc check
		long[] removeDepartmentLeaderArr = StringUtil.split(ParamUtil.getString(req, "removeDepartmentLeader"), 0L);
		removeDepartmentLeader(req, removeDepartmentLeaderArr);
		
		// lay tat ca user duoc check
		long[] addDepartmentLeaderArr = StringUtil.split(ParamUtil.getString(req, "addDepartmentLeader"), 0L);
		addDepartmentLeader(req, addDepartmentLeaderArr);
		

		//lay tat ca nguoi chu  tri ko duoc check
		long[] removeLeaderMettingArr = StringUtil.split(ParamUtil.getString(req, "removeLeaderMetting"), 0L);
		removeLeaderMetting(req, removeLeaderMettingArr);
		
		// lay tat ca nguoi chu  tri duoc check
		long[] addLeaderMettingArr = StringUtil.split(ParamUtil.getString(req, "addLeaderMetting"), 0L);
		addLeaderMetting(req, addLeaderMettingArr);
		
		//lay tat ca van thu phong ko duoc check
		long[] removeVanThuPhongArr = StringUtil.split(ParamUtil.getString(req, "removeVanThuPhong"), 0L);
		removeVanThuPhong(req, removeVanThuPhongArr);
		
		// lay tat ca van thu phong duoc check
		long[] addVanThuPhongArr = StringUtil.split(ParamUtil.getString(req, "addVanThuPhong"), 0L);
		addVanThuPhong(req, addVanThuPhongArr);
	}
	
	
	
	private void addVanThuPhong(ActionRequest req, long[] addVanThuPhongArr) {
		long userId = 0;
		PmlUser pmlUser = null;
		for (int i = 0; i < addVanThuPhongArr.length; i++) {
			userId = addVanThuPhongArr[i];
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				pmlUser.setIsVanThuPhong(true);
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	private void removeVanThuPhong(ActionRequest req,
			long[] removeVanThuPhongArr) {
		long userId = 0;
		PmlUser pmlUser = null;
		for (int i = 0; i < removeVanThuPhongArr.length; i++) {
			userId = removeVanThuPhongArr[i];
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				pmlUser.setIsVanThuPhong(false);
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void removeLeaderMetting(ActionRequest req,
			long[] removeLeaderMettingArr) {
		long userId = 0;
		PmlUser pmlUser = null;
		for (int i = 0; i < removeLeaderMettingArr.length; i++) {
			userId = removeLeaderMettingArr[i];
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				pmlUser.setIsLeaderMetting(false);
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	private void addLeaderMetting(ActionRequest req, long[] addLeaderMettingArr) {
		long userId = 0;
		PmlUser pmlUser = null;
		for (int i = 0; i < addLeaderMettingArr.length; i++) {
			userId = addLeaderMettingArr[i];
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				pmlUser.setIsLeaderMetting(true);
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void addDepartmentLeader(ActionRequest req, long[] addDepartmentLeaderArr) throws SystemException {
		long main = ParamUtil.getLong(req, "isLeaderMain");
		String departmentsId = ParamUtil.getString(req, "departmentId", "");
		
		for (int i = 0; i < addDepartmentLeaderArr.length; i++) {
			long userId = addDepartmentLeaderArr[i];

			PmlDepartmentsLeader pmlDepartmentsLeader = new PmlDepartmentsLeaderImpl();
			
			pmlDepartmentsLeader.setUserId(userId);
			pmlDepartmentsLeader.setDepartmentsId(departmentsId);
			if (userId == main) {
				pmlDepartmentsLeader.setMain(true);
			}
			else {
				pmlDepartmentsLeader.setMain(false);
			}
			PmlDepartmentsLeaderLocalServiceUtil.updatePmlDepartmentsLeader(pmlDepartmentsLeader);
		}
	}
	
	private void removeDepartmentLeader(ActionRequest req, long[] removeDepartmentLeaderArr) {
		String departmentsId = ParamUtil.getString(req, "departmentId", "");
		
		for (int i = 0; i < removeDepartmentLeaderArr.length; i++) {
			long userId = removeDepartmentLeaderArr[i];
			PmlDepartmentsLeader pmlDepartmentsLeader = null;

			try {
				pmlDepartmentsLeader = PmlDepartmentsLeaderUtil.findByDepartmentsId_UserId(departmentsId, userId).get(0);
				
				PmlDepartmentsLeaderLocalServiceUtil.deletePmlDepartmentsLeader(pmlDepartmentsLeader);
			} catch (Exception e) {
			}
			
		}
	}
	
	/*
	private void updateLeader(ActionRequest req) throws Exception {
		
		String[] userIdArr = req.getParameterValues("isLeader");
		List<PmlDepartmentsLeader> departmentLeader  = new ArrayList<PmlDepartmentsLeader>();
		List<PmlDepartmentsLeader> departmentLeaderNoLeader  = new ArrayList<PmlDepartmentsLeader>();
		String departmentIdNoLeader = ParamUtil.getString(req, "departmentId", "");
		String main = ParamUtil.getString(req, "isLeaderMain", "0");
		
		try {
			departmentLeaderNoLeader = PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentIdNoLeader);
		} catch (Exception e) {			
		}
		
		for (PmlDepartmentsLeader pmlDepartmentsLeader : departmentLeaderNoLeader) {
			PmlDepartmentsLeaderLocalServiceUtil.deletePmlDepartmentsLeader(pmlDepartmentsLeader);
		}
		
		if (userIdArr != null) {
			long pmlUserId = Long.parseLong(userIdArr[0]);
			PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(pmlUserId);
			String departmentId = pmlUser.getDepartmentsId();
			departmentLeader = PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentId);
			for (PmlDepartmentsLeader pmlDepartmentsLeader : departmentLeader) {
				PmlDepartmentsLeaderLocalServiceUtil.deletePmlDepartmentsLeader(pmlDepartmentsLeader);
			}
			for (int i = 0; i < userIdArr.length; i++) {
				long userId = Long.parseLong(userIdArr[i]);
				long mainL = Long.parseLong(main);
				PmlDepartmentsLeader pmlDepartmentsLeader = new PmlDepartmentsLeaderImpl();
				pmlDepartmentsLeader.setUserId(userId);
				pmlDepartmentsLeader.setDepartmentsId(departmentId);
				if (userId == mainL) {
					pmlDepartmentsLeader.setMain(true);
				}
				else {
					pmlDepartmentsLeader.setMain(false);
				}
				PmlDepartmentsLeaderLocalServiceUtil.updatePmlDepartmentsLeader(pmlDepartmentsLeader);
			}
		}
	}
	*/

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		
		Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
		String departmentName = department.getDepartmentsName();

		req.setAttribute("departmentName", departmentName);
		req.setAttribute("departmentId", departmentId);
		
		/* phmphuc close 28/05/2010
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		List<PmlUser> users = getListUser(req);
		List<PmlUserDTO> userList = populateUserToUserDTO(users, departmentId);
		req.setAttribute("userList", userList);
		end */ 
		
		return mapping.findForward("portlet.sgs.departmentleader.setleader");
	}

//	private List<PmlUser> getListUser(RenderRequest req) throws Exception{
//		String departmentId = ParamUtil.getString(req, "departmentId", "");
//		
//		Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
//		String departmentName = department.getDepartmentsName();
//		
//		List<PmlUser> listUser = PmlUserUtil.findByDepartmentsId(departmentId);
//
//		req.setAttribute("departmentName", departmentName);
//		req.setAttribute("departmentId", departmentId);
//		return listUser;
//	}
	
//	private List<PmlUserDTO> populateUserToUserDTO(List<PmlUser> users, String departmentId) throws Exception{
//		List<PmlUserDTO> listUserDTO = new ArrayList<PmlUserDTO>();
//		List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
//		for (int i = 0; i < users.size(); i++) {
//			PmlUser pmlUser = users.get(i);
//			long pmlUserId = pmlUser.getUserId();
//			User user = UserLocalServiceUtil.getUser(pmlUserId);
//			String userName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
//			
//			String positionId = pmlUser.getPositionId();
//			Position position = PositionLocalServiceUtil.getPosition(positionId);
//			String positionName = position.getPositionName();
//			
//			String isLeader = "";
//			try {
//				pmlDepartmentsLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId_UserId(departmentId, pmlUserId);
//			} catch (Exception e) {
//				pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
//			}
//			
////			if (PmlDepartmentsLeaderUtil.findByUserId(pmlUserId).size() != 0) {
//			if (pmlDepartmentsLeaderList.size()!= 0 ) {
//				isLeader = "1";
//			}
//			else {
//				isLeader = "0";
//			}
//			PmlUserDTO userDTO = new PmlUserDTO();
//			userDTO.setId(pmlUserId);
//			userDTO.setName(userName);
//			userDTO.setPosition(positionName);
//			userDTO.setIsLeader(isLeader);
//			
//			
//			for (int j = 0; j < pmlDepartmentsLeaderList.size(); j++) {
//				if (pmlUserId == pmlDepartmentsLeaderList.get(j).getUserId() && pmlDepartmentsLeaderList.get(j).getMain()) {
//					userDTO.setMain(true);
//					break;
//				}
//				else {
//					userDTO.setMain(false);
//				}
//				
//			}
//			
//			listUserDTO.add(userDTO);
//		}
//		return listUserDTO;
//	}

}
