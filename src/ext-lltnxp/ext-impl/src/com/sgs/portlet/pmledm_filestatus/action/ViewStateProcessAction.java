/**
 * @author triltm
 * @since 10/04/2009
 * @version 1.0
 */

package com.sgs.portlet.pmledm_filestatus.action;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;

public class ViewStateProcessAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String action = ParamUtil.getString(req, "action", "");		
		if (Constants.ADD.equals(action)) {
			addStatusProcess(req, res);
		}
		else if (Constants.UPDATE.equals(action)) {
			updateStatusProcess(req, res);
		}
		else if (Constants.DELETE.equals(action)) {
			deleteStateProcess(req, res);
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			String cmd = ParamUtil.getString(req, Constants.CMD, "");			
			List<PmlFileStatusStateProcess> fileStatusStateProcess = getListStateProcesses(req, res);
			
			// check for sorting
			/*
			if ("sort".equals(cmd)) {
				int sort = ParamUtil.getInteger(req, "sort", 0);
				int flag = ParamUtil.getInteger(req, "flag", 0);
				if (flag == 0) {
					flag = 1;
				}else {
					flag = 0;
				}
				fileStatusStateProcess = sort(fileStatusStateProcess, sort, flag);
				req.setAttribute("flag", flag);
			}
			
			else */
			
			if (Constants.EDIT.equals(cmd)) {
				editStateProcess(req, res);
			}
			
			else if (Constants.DEACTIVATE.equals(cmd)) {
				deactiveStateProcess(req, res);
			}
			req.setAttribute("fileStatusStateProcess", fileStatusStateProcess);
			return mapping.findForward("portlet.sgs.pmledm_stateprocess.view");
	}

	/**
	 * This method use to deactive a selected state process
	 * @param req
	 * @param res
	 */
	private void deactiveStateProcess(RenderRequest req, RenderResponse res) {
		long stateProcessId = ParamUtil.getLong(req, "stateProcessId");
		PmlStateProcess stateProcess = null;
		try {
			stateProcess = PmlStateProcessLocalServiceUtil.getPmlStateProcess(stateProcessId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if ("1".equals(stateProcess.getActive())) {
			stateProcess.setActive("0");
		}
		else {
			stateProcess.setActive("1");
		}
		try {
			PmlStateProcessLocalServiceUtil.updatePmlStateProcess(stateProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method use to delete a selected state process
	 * @param req
	 * @param res
	 */
	private void deleteStateProcess(ActionRequest req, ActionResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");
		long stateProcessId = ParamUtil.getLong(req, "stateProcessId");

		List<PmlFileStatusStateProcess> results = null;
		
		try {
			results = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(fileStatusId, stateProcessId);
			if (results != null) {
				PmlFileStatusStateProcessLocalServiceUtil.deletePmlFileStatusStateProcess(results.get(0));
			}
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * This method use to change page from display form to edit form
	 * @param req
	 * @param res
	 */
	private void editStateProcess(RenderRequest req, RenderResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");
		long stateProcessId = ParamUtil.getLong(req, "stateProcessId");
		PmlFileStatusStateProcess fileStatusIdStateProcess = null;
		
		try {
			fileStatusIdStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(fileStatusId, stateProcessId).get(0);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlStateProcess> stateProcessList = new ArrayList<PmlStateProcess>();
		
		try {
			stateProcessList = PmlStateProcessUtil.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("fileStatusIdStateProcess", fileStatusIdStateProcess);
		req.setAttribute("stateProcessList", stateProcessList);
	}

	/**
	 * This method use to get a list of state process to view on display form
	 * @param req
	 * @param res
	 * @return list of state process
	 */
	private List<PmlFileStatusStateProcess> getListStateProcesses(RenderRequest req,
			RenderResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");
		int page = ParamUtil.getInteger(req, "pageStateProcess", 1);
		int limit = ParamUtil.getInteger(req, "limit", 20); // default
		
		int start = (page - 1) * limit;
		int totalItems = 0;
		try {
			totalItems = PmlFileStatusStateProcessUtil.findByFileStatusId(fileStatusId).size();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		int totalPages = totalItems / limit;
		totalPages = totalItems % limit == 0 ? totalPages : totalPages + 1;
		
		List<PmlFileStatusStateProcess> fileStatusStateProcess = new ArrayList<PmlFileStatusStateProcess>();
		
		try {
			fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatusId(fileStatusId, start, totalItems);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalItems", totalItems);
		req.setAttribute("fileStatusId", fileStatusId);
		
		return fileStatusStateProcess;
	}

	/**
	 * This method use to update a selected state process
	 * @param req
	 * @param res
	 */
	private void updateStatusProcess(ActionRequest req, ActionResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");
		long stateProcessId = ParamUtil.getLong(req, "stateProcessId");
		long id = ParamUtil.getLong(req, "state_process_id", 0);
		
		String description = ParamUtil.getString(req, "description", "");
		
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		
		try {
			fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(fileStatusId, stateProcessId).get(0);
			if (id != 0) {
				fileStatusStateProcess.setStateProcessId(id);
				fileStatusStateProcess.setDescription(description);
			}
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
			
		try {
			PmlFileStatusStateProcessLocalServiceUtil.updatePmlFileStatusStateProcess(fileStatusStateProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method use to add a new status process to database
	 * @param req
	 * @param res
	 */
	private void addStatusProcess(ActionRequest req, ActionResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");
		long stateProcessId = ParamUtil.getLong(req, "state_process_id");
		String description = ParamUtil.getString(req, "description", "");
		long id = 0;
		try {
			id = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.createPmlFileStatusStateProcess(id);
		fileStatusStateProcess.setFileStatusId(fileStatusId);
		fileStatusStateProcess.setStateProcessId(stateProcessId);
		fileStatusStateProcess.setDescription(description);
		try {
			PmlFileStatusStateProcessLocalServiceUtil.updatePmlFileStatusStateProcess(fileStatusStateProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method use to sort a list of file state process
	 * @param fileStateProcesses
	 * @param sort
	 * @param flag
	 * @return sorted fileStateProcess
	 */
	/*
	private List<PmlStateProcess> sort(List<PmlStateProcess> fileStateProcesses,
			int sort, int flag) {
		int len = fileStateProcesses.size();
		int i, j;
		Collator viCollator = Collator.getInstance(new Locale("vi"));
		for(i = 0; i < len - 1; i ++) {
			for(j = i + 1; j < len; j ++) {
				String str1, str2;
				switch(sort) {
				
				case 2:
					str1 = ((PmlStateProcess) fileStateProcesses.get(i)).getStateProcessName();
					str2 = ((PmlStateProcess) fileStateProcesses.get(j)).getStateProcessName();
					break;
				
				case 3:
					str1 = ((PmlStateProcess) fileStateProcesses.get(i)).getDescription();
					str2 = ((PmlStateProcess) fileStateProcesses.get(j)).getDescription();
					break;
					
				case 4:
					str1 = ((PmlStateProcess) fileStateProcesses.get(i)).getActive();
					str2 = ((PmlStateProcess) fileStateProcesses.get(j)).getActive();
					break;
					
				default :
					str1 = "" + ((PmlStateProcess) fileStateProcesses.get(i)).getStateProcessCode();
					str2 = "" + ((PmlStateProcess) fileStateProcesses.get(j)).getStateProcessCode();
					break;
					
				}
				if (flag == 1) { 
					if(viCollator.compare(str1, str2) < 0) {
						PmlStateProcess temp = (PmlStateProcess) fileStateProcesses.get(i);
						fileStateProcesses.set(i, fileStateProcesses.get(j));
						fileStateProcesses.set(j, temp);
					}
				} else { 
					if (viCollator.compare(str1, str2) > 0) {
						PmlStateProcess temp = (PmlStateProcess) fileStateProcesses.get(i);
						fileStateProcesses.set(i, fileStateProcesses.get(j));
						fileStateProcesses.set(j, temp);
					}
				}
			}
		}
		return fileStateProcesses;
	}
	*/
}
