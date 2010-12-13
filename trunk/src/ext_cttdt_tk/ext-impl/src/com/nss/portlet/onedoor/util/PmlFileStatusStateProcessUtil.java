package com.nss.portlet.onedoor.util;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil;

public class PmlFileStatusStateProcessUtil {
	
	public boolean checkExitFileStatusStateProcess(String fileStatusIdString, long stateProcessId, long stateProcessIdChooice){
		boolean result = false;
		long fileStatusId = Long.parseLong(fileStatusIdString);
		
		List<PmlFileStatusStateProcess> listPmlFileStatusStateProcess = null;
		
		if ( 0 == stateProcessId) {
			try {
				listPmlFileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByFileStatusId(fileStatusId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			for (int i=1; i< listPmlFileStatusStateProcess.size() ; i++) {
				if (stateProcessIdChooice == listPmlFileStatusStateProcess.get(i).getStateProcessId()){
					result = true;
					break;
				}
			}
		} else {
			try {
				listPmlFileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByFileStatus_StateProcess(fileStatusId, stateProcessIdChooice);
			} catch (SystemException e) {
				e.printStackTrace();
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
