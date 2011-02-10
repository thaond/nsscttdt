package com.sgs.portlet.onedoor.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.model.User;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class JBPMReport {
	private Date date;
	private User user;
	
	public JBPMReport() {
		
	}

	public JBPMReport(Date date, User user) {
		this.date = date;
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @param fileTypeId
	 * @param fromDate
	 * @param toDate
	 * @param state
	 * @return
	 * List
	 * Apr 1, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	public List<PmlProcessDispose> getFileReciveWithFileType(String fileTypeId, Date fromDate, Date toDate, long statusId) {
		List<PmlProcessDispose> result = new ArrayList<PmlProcessDispose>();
		try {
			List<PmlProcessDispose> listPmlProcessDispose = PmlProcessDisposeUtil.findAll();
			
			if (listPmlProcessDispose != null) {
				
				for (Iterator iterator = listPmlProcessDispose.iterator(); iterator.hasNext();) {
					PmlProcessDispose pmlProcessDispose = (PmlProcessDispose) iterator.next();
					long stateProcessIdBefore = pmlProcessDispose.getStateProcessIdBefore();
					
					PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessIdBefore);
					
					if (pmlStateProcess != null ) {
						long fileStatusId = pmlStateProcess.getFileStatusId();
						
						if (pmlProcessDispose.getReceiveDate().after(fromDate) && pmlProcessDispose.getReceiveDate().before(toDate)
								&& statusId == fileStatusId){
							
							String fileId = pmlProcessDispose.getFileId();
							
							PmlOneDoorReceiveFile pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
							
							if (fileTypeId == pmlOneDoorReceiveFile.getFileTypeId()) {
								result.add(pmlProcessDispose);
							}
						}
							
					}
							
				}
						
			}
					
	} catch (Exception e) {
			e.printStackTrace();
	} 
		
	return result;
	
	}
	
	/**
	 * 
	 * @param departmentId
	 * @param statusId
	 * @return
	 * int
	 * Apr 1, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	
	public int getFileWithStateSolveOfDepartment( String departmentId, long statusId) {
		int count = 0;
		try {
			List<PmlProcessDispose> listPmlProcessDispose = PmlProcessDisposeUtil.findAll();
			List<PmlUser> listPmlUser = PmlUserUtil.findByDepartmentsId(departmentId);
			if (listPmlProcessDispose != null && listPmlUser != null) {
				for (PmlUser pmlUser : listPmlUser) {
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}
}
