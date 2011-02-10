package com.sgs.portlet.documentdelegate.action;

import java.sql.Timestamp;
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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl;
import com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlAgencyLeader;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil;
import com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.util.PmlUserUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		PmlDocumentDelegate pmlDocumentDelegate = null; 
		long[] addUserIsDelegateArr = StringUtil.split(ParamUtil.getString(req, "addUserIsDelegate"),0l);
		boolean dateAllUser = ParamUtil.getBoolean(req, "dateAllUser", true);
		boolean update = ParamUtil.getBoolean(req, "update", false);
		boolean cancel = ParamUtil.getBoolean(req, "cancel", false);
		long pmlDocumentDelegateId = ParamUtil.getLong(req, "pmlDocumentDelegateId", 0);
		Long userDelelegate = ParamUtil.getLong(req, "userDelelegate", 0);
		SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
		
		if (update) {
			if (userDelelegate != 0) {
				long pk = 0;
				String fromDateDelegate = "";
				String toDateDelegate = "";
				Timestamp timestampFrom = null;
				Timestamp timestampTo = null;
				for (int i = 0; i < addUserIsDelegateArr.length; i++) {
					
					if (addUserIsDelegateArr[i] > 0) {
					pmlDocumentDelegate = new PmlDocumentDelegateImpl();
					pk = CounterLocalServiceUtil.increment();
					pmlDocumentDelegate.setDocumentDelegateId(pk);
					pmlDocumentDelegate.setUserDelegateId(userDelelegate);
					pmlDocumentDelegate.setUserIsDelegateId(addUserIsDelegateArr[i]);
					if (dateAllUser){
						fromDateDelegate = ParamUtil.getString(req, "fromDateDelegate"+addUserIsDelegateArr[i], dateFormat.format(new Date().getTime()));
						toDateDelegate = ParamUtil.getString(req, "toDateDelegate"+addUserIsDelegateArr[i], "");
					} else {
						fromDateDelegate = ParamUtil.getString(req, "fromDateDelegate", dateFormat.format( new Date().getTime()));
						toDateDelegate = ParamUtil.getString(req, "toDateDelegate", "");
					}
					
					timestampFrom = new Timestamp(dateFormat.parse(fromDateDelegate).getTime());
					pmlDocumentDelegate.setFromtDate(timestampFrom);
					if (!"".equals(toDateDelegate)) {
						timestampTo = new Timestamp(dateFormat.parse(toDateDelegate).getTime());
						pmlDocumentDelegate.setToDate(timestampTo);
					}
					
					PmlDocumentDelegateLocalServiceUtil.addPmlDocumentDelegate(pmlDocumentDelegate);
					}
				}
			}
		} else if (cancel) {
			pmlDocumentDelegate = PmlDocumentDelegateLocalServiceUtil.getPmlDocumentDelegate(pmlDocumentDelegateId);
			pmlDocumentDelegate.setCancelDate(new Timestamp(new Date().getTime()));
			PmlDocumentDelegateLocalServiceUtil.updatePmlDocumentDelegate(pmlDocumentDelegate);
		}
		
		sendRedirect(req, res);
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				long userDelelegate = ParamUtil.getLong(req, "userDelelegate", 0);
				
				long userLogin = PortalUtil.getUserId(req);
				List<PmlUser> pmlUserDelegates = new ArrayList<PmlUser>();
				List<PmlUser> pmlUserIsDelegates = new ArrayList<PmlUser>();
				
				List<PmlDepartmentsLeader> departmentsLeaders = PmlDepartmentsLeaderLocalServiceUtil.getPmlDepartmentsLeaders(-1, -1);
				int size = departmentsLeaders.size();
				boolean checkUserLogin = false;
				
				boolean checkAllUser = ParamUtil.getBoolean(req, "checkAllUser"); // phmphuc add 05/01/2011
				
				if (userDelelegate != 0) {
					userLogin = userDelelegate;
				}
				
				for (int i = 0; i < size; i++) {
					if (departmentsLeaders.get(i).getUserId() == userLogin) {
						checkUserLogin = true;						
					}
					try {
						pmlUserDelegates.add(PmlUserLocalServiceUtil.getPmlUser(departmentsLeaders.get(i).getUserId()));
					} catch (Exception e) {
						_log.error("ERROR CREATE LIST  PMLUSER FROM DEPARTMENTLEADER IN " + ViewAction.class + " " + e.getMessage());
						
					}
				}
				
				PmlUser pmlUserDelegate = null;
				String departmentParentId = "";
				List<PmlUser> pmlUserIsDelegateTemps = new ArrayList<PmlUser>();
				List<PmlDepartmentsLeader> departmentsLeaderTemps = new ArrayList<PmlDepartmentsLeader>();

				if (checkUserLogin) {
					try {
						if (userDelelegate == 0) {
							pmlUserDelegates = new ArrayList<PmlUser>();
							pmlUserDelegate = PmlUserLocalServiceUtil.getPmlUser(userLogin);
							pmlUserDelegates.add(pmlUserDelegate);
						} else {
							pmlUserDelegate = PmlUserLocalServiceUtil.getPmlUser(userDelelegate);
						}
						
						
						List<PmlAgencyLeader> agencyLeaders = null;
						try {
							agencyLeaders = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeaders(-1, -1);
						} catch (Exception e) {
							_log.error("ERROR GET LIST AGENCY LEADER " + ViewAction.class + " " + e.getMessage());
							agencyLeaders = new ArrayList<PmlAgencyLeader>();
						}
						
						long userAgencyLeaderId = 0;
						PmlUser pmlUserAgencyLeader = null;
						boolean isAgencyLeader = false;
						
						for (int i = 0; i < agencyLeaders.size(); i++) {
							userAgencyLeaderId = agencyLeaders.get(i).getUserId();
							try {
								pmlUserAgencyLeader = PmlUserLocalServiceUtil.getPmlUser(userAgencyLeaderId);
								if (pmlUserAgencyLeader.getDepartmentsId().equals(pmlUserDelegate.getDepartmentsId())) {
									isAgencyLeader = true;
								}
							} catch (Exception e) {
								_log.error("ERROR: GET PMLUSER LEAGER " + ViewAction.class + " " + e.getMessage());		
							}
						}
						// phmphuc them 05/01/2011 - neu chon uy quyen tat ca chuyen vien
						if (checkAllUser) {
							List<PmlDepartmentsLeader> departmentsLeaderList = null;
							PmlDepartmentsLeader departmentsLeader = null;
							PmlUser pmlUser = null;
							try {
								pmlUserIsDelegates = PmlUserLocalServiceUtil.getPmlUsers(-1, -1);
								departmentsLeaderList = PmlDepartmentsLeaderLocalServiceUtil.getPmlDepartmentsLeaders(-1, -1);
								
								for (int i = 0; i < departmentsLeaderList.size(); i ++) {
									departmentsLeader = departmentsLeaderList.get(i);
									try {
										pmlUser = PmlUserLocalServiceUtil.getPmlUser(departmentsLeader.getUserId());
									} catch (Exception e) { }
									
									pmlUserIsDelegates.remove(pmlUser);
								}
							} catch (Exception e) {
								_log.error("ERROR: GET LIST PMLUSER " + ViewAction.class + " " + e.getMessage());	
							}
						}
						// end phmphuc add 05/01/2011
						else {
						
							if (isAgencyLeader) {
								try {
									pmlUserIsDelegates = PmlUserLocalServiceUtil.getPmlUsers(-1, -1);
									
								} catch (Exception e) {
									_log.error("ERROR: GET LIST PMLUSER " + ViewAction.class + " " + e.getMessage());	
								}
							
							} else {
								departmentParentId = pmlUserDelegate.getDepartmentsId(); 
								List<Department> departments = null;
								try {
									departments = DepartmentUtil.findByDepartmentsParentId(departmentParentId);
								} catch (Exception e) {
									_log.error("ERROR GET DEPARTMENT OF USER DELEGATE " + ViewAction.class + " " + e.getMessage());
								}
								
								if (departments == null || departments.isEmpty()) {
									pmlUserIsDelegateTemps = PmlUserUtil.getPmlUserByDepartmentId(departmentParentId);
									departmentsLeaderTemps = PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentParentId);
									
									int sizePmlUserTemp = pmlUserIsDelegateTemps.size();
									
									for (int i = 0; i < departmentsLeaderTemps.size(); i++) {
										if (departmentsLeaderTemps.get(i).getUserId() == userLogin) {
											if (departmentsLeaderTemps.get(i).getMain()) {
												pmlUserIsDelegateTemps.remove(pmlUserDelegate);
												break;
											}
										}
									}
									
									if (sizePmlUserTemp == pmlUserIsDelegateTemps.size()) {		
										for (int i = 0; i < departmentsLeaderTemps.size(); i++) {
											pmlUserIsDelegateTemps.remove(PmlUserLocalServiceUtil.getPmlUser(departmentsLeaderTemps.get(i).getUserId()));
										}
									}
									
									pmlUserIsDelegates = pmlUserIsDelegateTemps;
								} else {
									for (int i = 0; i < departments.size(); i++) {
										pmlUserIsDelegates.addAll(PmlUserUtil.getPmlUserByDepartmentId(departments.get(i).getDepartmentsId()));
									}
								}
							}
						}
						
					} catch (Exception e) {
						_log.error("ERROR CREATE LIST  PMLUSER FROM USER LOGIN IN " + ViewAction.class + " " + e.getMessage());
					}
				}  
				
				req.setAttribute("pmlUserDelegates", pmlUserDelegates);
				req.setAttribute("pmlUserIsDelegates", pmlUserIsDelegates);
				
				return mapping.findForward("portlet.sgs.documentdelegate.view");
			}
	}

}
