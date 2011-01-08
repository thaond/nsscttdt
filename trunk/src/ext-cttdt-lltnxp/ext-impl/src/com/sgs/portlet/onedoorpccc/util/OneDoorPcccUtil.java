/**
 * 
 */
package com.sgs.portlet.onedoorpccc.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.util.OneDoorUtil;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalServiceUtil;


/**
 * @author kienbqc
 *
 */
public class OneDoorPcccUtil {
	private static Log _log = LogFactory.getLog(OneDoorPcccUtil.class);
	public static List<PmlFilePcccDTO> getFilePcccDTOs(long userId, String type, String valueType) throws PortalException, SystemException {
		
		List<PmlOneDoorReceiveFile> files = OneDoorUtil.getFilesByUserId(userId, type, valueType);
		_log.info("userId: " + userId);
		_log.info("type: " + type);
		_log.info("valueType: " + valueType);
		_log.info("files:" + files);
//		List<PmlOneDoorReceiveFile> files = PmlOneDoorReceiveFileUtil.findAll();
		List<PmlFilePcccDTO> filePcccDTOs = new ArrayList<PmlFilePcccDTO>();
		
		if(files != null || files.size() != 0) {
			for (int i = 0; i < files.size(); i++) {
				
				PmlOneDoorReceiveFile file = files.get(i);
				
				/* get pmlFilePccc by fileId */
				PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(file.getFileId());
				
				String fileTypeId = file.getFileTypeId();
				PmlFileType pmlFileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
				
				PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
				filePcccDTO.setFileId(file.getFileId());
				filePcccDTO.setFileName(filePCCC.getFileName());
				filePcccDTO.setFiletype(pmlFileType.getFileTypeName());
				filePcccDTO.setExpectedReturingDate(file.getExpectedReturningDate());
				filePcccDTO.setInputDataDate(filePCCC.getInputDataDate());
				filePcccDTO.setNumberReceipt(file.getNumberReceipt());
				
				filePcccDTOs.add(filePcccDTO);
			}
		}
		return filePcccDTOs;
	}

}
