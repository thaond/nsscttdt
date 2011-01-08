package com.sgs.portlet.document.util;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;

public class PmlFileStatusStateProcessUtil {
	
	public boolean checkExitFileStatusStateProcess(String fileStatusIdString, long stateProcessId, long stateProcessIdChooice){
		boolean result = false;
		long fileStatusId = Long.parseLong(fileStatusIdString);
		
		List<PmlFileStatusStateProcess> listPmlFileStatusStateProcess = null;
		
		if ( 0 == stateProcessId) {
			try {
				listPmlFileStatusStateProcess = com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil.findByFileStatusId(fileStatusId);
			} catch (SystemException e) {
			}
			
			for (int i=1; i< listPmlFileStatusStateProcess.size() ; i++) {
				if (stateProcessIdChooice == listPmlFileStatusStateProcess.get(i).getStateProcessId()){
					result = true;
					break;
				}
			}
		} else {
			try {
				listPmlFileStatusStateProcess = com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(fileStatusId, stateProcessIdChooice);
			} catch (SystemException e) {
				listPmlFileStatusStateProcess = null;
			}
			if(listPmlFileStatusStateProcess.size()>= 2){
				result = true;
			}else if(listPmlFileStatusStateProcess.size() == 1){
				if (stateProcessId == listPmlFileStatusStateProcess.get(0).getStateProcessId()) {
					result = false;
				} else {
					result = true;
				}
			}
		}
		return result;
		
	}
}
