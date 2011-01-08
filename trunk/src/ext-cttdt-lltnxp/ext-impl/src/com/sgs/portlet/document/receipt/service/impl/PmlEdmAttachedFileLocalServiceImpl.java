package com.sgs.portlet.document.receipt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.service.base.PmlEdmAttachedFileLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;


/**
 * @author lethanhtung
 * @author XuanCong
 */
public class PmlEdmAttachedFileLocalServiceImpl extends PmlEdmAttachedFileLocalServiceBaseImpl {
	
	/**
	 * this method get a list of PmlEdmAttachedFile by a class name and id of it
	 * @param clazz
	 * @param id
	 * @return list of PmlEdmAttachedFile. 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<PmlEdmAttachedFile> getAttachedFileForLog (Class clazz, long id) {
		
		List<PmlEdmAttachedFile>  retValue = new ArrayList<PmlEdmAttachedFile>();
		
		if (clazz == null) {
			return retValue;
		}
		
		String objectType = clazz.getName();
		try {
			retValue = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(id, objectType);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * Xoa tap tin dinh kem dua vao ma so va loai
	 * 
	 * @param objectContentId ma so van ban di hoac den
	 * @param objectType loai van ban di hoac den
	 * @return
	 */
	public int deletePmlEdmAttachedFileByOO(long objectContentId, String objectType) {
		int retVal = 0;
		
		try {
			List<PmlEdmAttachedFile> lstAttFles = PmlEdmAttachedFileUtil
					.findByObjectContentId_ObjectType(objectContentId, objectType);
			if (lstAttFles != null && lstAttFles.size() > 0) {
				for (PmlEdmAttachedFile attFleItem : lstAttFles) {
					// Xoa tap tin dinh kem
					PmlEdmAttachedFileUtil.remove(attFleItem);
					// Tang so luong tap tin bi xoa
					retVal ++;
				} // end for
			} // end if
		} // end try 
		catch (Exception ex) {
			System.out.println("Co loi khi xoa file dinh kem theo ma so va loai.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}
}
