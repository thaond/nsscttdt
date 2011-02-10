package com.sgs.portlet.document.receipt.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.document.receipt.service.base.PmlEdmLevelSendDetailLocalServiceBaseImpl;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;


public class PmlEdmLevelSendDetailLocalServiceImpl
    extends PmlEdmLevelSendDetailLocalServiceBaseImpl {

	/**
	 * Lay ve tat ca cac doi tuong levelsenddetail
	 */
	public List<PmlEdmLevelSendDetail> getAll() 
	throws SystemException {
		try {
			return pmlEdmLevelSendDetailPersistence.findAll();
		} // end try
		catch (Exception ex) {
			return null;
		} // end catch
	}
	
	/**
	 * Them LevelSendDetail dua vao danh sach id va id 
	 * @param levelsendidList: danh sach ma cap gui, cach nhau bang dau ;
	 * @param issuingplaceid
	 * @return
	 * @throws SystemException
	 */
	public boolean addPmlEdmLevelSendDetailList(
			String levelSendIdList, String issuingPlaceId) 
	throws SystemException {
		try {
			String[] arrLevelSendId = levelSendIdList.split(";");
			// Kiem tra don vi gui ton tai
			if (PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId) != null) {
				for (int idx = 0; idx < arrLevelSendId.length; idx ++) {
					int levelSendId = Integer.parseInt(arrLevelSendId[idx]);
					if (PmlEdmLevelSendUtil.findByPrimaryKey(levelSendId) != null) {
						// Them doi tuong moi
						PmlEdmLevelSendDetailPK newPK = new PmlEdmLevelSendDetailPK();
						newPK.issuingPlaceId = issuingPlaceId;
						newPK.levelSendId = levelSendId;
						PmlEdmLevelSendDetail newItem = pmlEdmLevelSendDetailPersistence.create(newPK);
						// Cap nhat vao db
						pmlEdmLevelSendDetailPersistence.update(newItem, false);
					} // end if
				} // end if
			} // end if
			return true;
		}
		catch (Exception ex) {
			return false;
		} // end catch
	}

	/**
	 * Cap nhat levelSendDetail dua vao danh sach ma cap gui va ma don vi gui
	 * @param levelSendIdList
	 * @param issuingPlaceId
	 * @return
	 * @throws SystemException
	 */
	public boolean updatePmlEdmLevelSendDetailList(
			String levelSendIdList, String issuingPlaceId) 
	throws SystemException {
		try {
			String[] arrLevelSendId = levelSendIdList.split(";");
			// Kiem tra don vi gui ton tai
			if (PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId) != null) {
				// Xoa bang pml_edm_levelsenddetail dua vao issuingPlaceId
				pmlEdmLevelSendDetailPersistence.removeByIssuingPlaceId(issuingPlaceId);
				// Them record moi
				for (int idx = 0; idx < arrLevelSendId.length; idx ++) {
					int levelSendId = Integer.parseInt(arrLevelSendId[idx]);
					if (PmlEdmLevelSendUtil.findByPrimaryKey(levelSendId) != null) {
						// Them doi tuong moi
						PmlEdmLevelSendDetailPK newPK = new PmlEdmLevelSendDetailPK();
						newPK.issuingPlaceId = issuingPlaceId;
						newPK.levelSendId = levelSendId;
						PmlEdmLevelSendDetail newItem = pmlEdmLevelSendDetailPersistence.create(newPK);
						// Cap nhat vao db
						pmlEdmLevelSendDetailPersistence.update(newItem, false);
					} // end if
				} // end if
			} // end if
			return true;
		}
		catch (Exception ex) {
			return false;
		} // end catch
	}
	
	public boolean hasLevelSend(int levelSendId, String issuingPlaceId){
		
		try {
			return (pmlEdmLevelSendDetailFinder.containLevelSend(levelSendId, issuingPlaceId)== 0 ? false : true);
		} catch (SystemException e) {			
			e.printStackTrace();
		}
		return false;
	} 
}
