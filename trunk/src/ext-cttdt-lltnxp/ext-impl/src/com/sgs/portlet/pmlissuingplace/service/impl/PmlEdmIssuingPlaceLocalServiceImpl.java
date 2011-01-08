
package com.sgs.portlet.pmlissuingplace.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailUtil;
import com.sgs.portlet.pmlissuingplace.PmlEdmIssuingPlaceCanNotDeleteException;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.base.PmlEdmIssuingPlaceLocalServiceBaseImpl;

public class PmlEdmIssuingPlaceLocalServiceImpl
	extends PmlEdmIssuingPlaceLocalServiceBaseImpl {

	/**
	 * Add new item of PmlEdmIssuingPlace object
	 * 
	 * @param issuingPlaceId
	 * @param issuingPlaceName
	 * @param signer
	 * @return
	 * @throws SystemException
	 */
	public PmlEdmIssuingPlace addPmlEdmIssuingPlace(
		String issuingPlaceId, String issuingPlaceName, String note,
		String signer)
		throws SystemException {

		try {
			// Create a new item
			PmlEdmIssuingPlace newItem =
				pmlEdmIssuingPlacePersistence.create(issuingPlaceId);
			// Set the values of this properties
			newItem.setIssuingPlaceName(issuingPlaceName);
			newItem.setNote(note);
			newItem.setSigner(signer);
			// Return object
			return pmlEdmIssuingPlacePersistence.update(newItem, false);
		} // end try
		catch (Exception ex) {
			return null;
		} // end catch
	}

	/**
	 * Lay ve danh sach don vi phat hanh dua vao danh sach ma so don vi phat
	 * hanh
	 * 
	 * @param issuingPlaceIds
	 *            Danh sach ma so don vi phat hanh
	 * @return
	 * @throws Exception
	 */
	public List<PmlEdmIssuingPlace> findByIssuingPlaceIds(
		List<String> issuingPlaceIds)
		throws Exception {

		try {
			return pmlEdmIssuingPlaceFinder.findByIssuingPlaceIds(issuingPlaceIds);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @author canhminh
	 * @param keywords
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmIssuingPlace> findByKeywords2(String keywords)
		throws SystemException {

		return pmlEdmIssuingPlaceFinder.findByKeywords2(keywords);
	}

	/**
	 * Lay toan bo don vi
	 * 
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<PmlEdmIssuingPlace> getAll()
		throws PortalException, SystemException {

		try {
			return pmlEdmIssuingPlacePersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * phmphuc get 10/07/2010 - chuyen ham lay noi phat hanh theo cap goi ve cau
	 * sql de sort theo ten hien thi
	 */
	public List<PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
		int levelSendId)
		throws Exception {

		return pmlEdmIssuingPlaceFinder.getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
	}

	public void removePmlEdmIssuingPlace(String issuingPlaceId)
		throws SystemException, PortalException {

		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList =
			PmlEdmDocumentReceiptUtil.findByIssuingPlaceId(issuingPlaceId);
		List<PmlEdmLevelSendDetail> pmlEdmLevelSendDetailList =
			PmlEdmLevelSendDetailUtil.findByIssuingPlaceId(issuingPlaceId);
		int documentReceiptSize = pmlEdmDocumentReceiptList.size();
		int levelSendDetailSize = pmlEdmLevelSendDetailList.size();
		validatePmlEdmIssuingPlace(documentReceiptSize, levelSendDetailSize);
		pmlEdmIssuingPlacePersistence.remove(issuingPlaceId);
	}

	public int searchCountIssuingPlace(String keywords)
		throws SystemException {

		return pmlEdmIssuingPlaceFinder.countByKeywords(keywords);
	}

	// end Yenlt

	public int searchCountIssuingPlace(
		String codes, String names, boolean andOperator)
		throws SystemException {

		return pmlEdmIssuingPlaceFinder.countIssuingPlace(
			codes, names, andOperator);
	}

	/**
	 * Yenlt 06/02/2010
	 * 
	 * @param keywords
	 * @return
	 */
	public List<PmlEdmIssuingPlace> searchIssuingPlace(
		String keywords, int start, int end, OrderByComparator obc)
		throws SystemException {

		return pmlEdmIssuingPlaceFinder.findByKeywords(
			keywords, start, end, obc);
	}

	public List<PmlEdmIssuingPlace> searchIssuingPlace(
		String codes, String names, boolean andOperator, int start, int end,
		OrderByComparator obc)
		throws SystemException {

		return pmlEdmIssuingPlaceFinder.findIssuingPlace(
			codes, names, andOperator, start, end, obc);
	}

	/**
	 * Update existing item of PmlEdmIssuingPlace object
	 * 
	 * @param issuingPlaceId
	 * @param issuingPlaceName
	 * @param signer
	 * @return
	 * @throws SystemException
	 */
	public PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
		String issuingPlaceId, String issuingPlaceName, String signer)
		throws SystemException {

		try {
			// Get existing item
			PmlEdmIssuingPlace editItem =
				pmlEdmIssuingPlacePersistence.findByPrimaryKey(issuingPlaceId);
			// Set the values of this properties
			editItem.setIssuingPlaceName(issuingPlaceName);
			editItem.setSigner(signer);
			// Return object
			return pmlEdmIssuingPlacePersistence.update(editItem, false);
		} // end try
		catch (Exception ex) {
			return null;
		} // end catch
	}

	// end
	// yenlt update 23082010
	protected void validatePmlEdmIssuingPlace(
		int documentReceiptSize, int levelSendDetailSize)
		throws PortalException, SystemException {

		if (documentReceiptSize != 0) {
			throw new PmlEdmIssuingPlaceCanNotDeleteException();
		}
		if (levelSendDetailSize != 0) {
			throw new PmlEdmIssuingPlaceCanNotDeleteException();
		}
	}

}
