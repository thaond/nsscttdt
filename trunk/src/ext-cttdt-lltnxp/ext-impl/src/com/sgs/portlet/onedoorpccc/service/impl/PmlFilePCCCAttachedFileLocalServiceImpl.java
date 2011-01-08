package com.sgs.portlet.onedoorpccc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile;
import com.sgs.portlet.onedoorpccc.service.base.PmlFilePCCCAttachedFileLocalServiceBaseImpl;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCAttachedFileUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlFilePCCCAttachedFileLocalServiceImpl  extends PmlFilePCCCAttachedFileLocalServiceBaseImpl {
	
	/**
	 * get List<PmlFilePCCCAttachedFile> by a class name and id of it (id of this class has type is string)
	 * @param clazz
	 * @param id
	 * @return List<PmlFilePCCCAttachedFile>
	 */
	@SuppressWarnings("unchecked")
	public List<PmlFilePCCCAttachedFile> getAttachedFilePCCCForUpload (Class clazz, String id) {
		
		List<PmlFilePCCCAttachedFile>  retValue = new ArrayList<PmlFilePCCCAttachedFile>();
		
		if (clazz == null) {
			return retValue;
		}
		
		String objectType = clazz.getName();
		try {
			retValue = PmlFilePCCCAttachedFileUtil.findByFilePcccId_ObjectType(id, objectType);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
}
