package com.sgs.portlet.document.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.DuplicateDocumentRelationException;
import com.sgs.portlet.document.model.PmlEdmDocumentRelation;
import com.sgs.portlet.document.service.base.PmlEdmDocumentRelationLocalServiceBaseImpl;

public class PmlEdmDocumentRelationLocalServiceImpl
    extends PmlEdmDocumentRelationLocalServiceBaseImpl {
	
	public PmlEdmDocumentRelation addPmlEdmDocumentRelation(
			long docLeftId, long docRightId, boolean leftIsReceipt, boolean rightIsReceipt) 
	throws PortalException, SystemException {

		// Kiem tra truoc khi them
		validateForAdd(docLeftId, docRightId, leftIsReceipt, rightIsReceipt);
		
		// Them moi quan he dang A relation B
		long documentRelationId = CounterLocalServiceUtil.increment();
		PmlEdmDocumentRelation newItem = pmlEdmDocumentRelationPersistence.create(documentRelationId);
		
		// Dat thuoc tinh
		newItem.setDocLeftId(docLeftId);
		newItem.setDocRightId(docRightId);
		newItem.setLeftIsReceipt(leftIsReceipt);
		newItem.setRightIsReceipt(rightIsReceipt);
		
		// Cap nhat database
		pmlEdmDocumentRelationPersistence.update(newItem, false);
		
		// Them moi quan he dang A relation B
		documentRelationId = CounterLocalServiceUtil.increment();
		newItem = pmlEdmDocumentRelationPersistence.create(documentRelationId);
		
		// Dat thuoc tinh
		newItem.setDocLeftId(docRightId);
		newItem.setDocRightId(docLeftId);
		newItem.setLeftIsReceipt(rightIsReceipt);
		newItem.setRightIsReceipt(leftIsReceipt);
		
		// Cap nhat database
		pmlEdmDocumentRelationPersistence.update(newItem, false);
		
		// Tra ket qua ve
		return newItem;
	}
	
	/**
	 * Kiem tra mot moi quan he da co trong database hay chua
	 */
	protected void validateForAdd(long docLeftId, long docRightId, boolean leftIsReceipt, 
			boolean rightIsReceipt) throws PortalException, SystemException {
		
		// Trong database luu theo dang A relation B va B relation A
		// Kiem tra co mau tin nao trong bang hay chua (dang A relation B)
		PmlEdmDocumentRelation dRItem = null;
		try {
			dRItem = pmlEdmDocumentRelationPersistence.findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
						docLeftId, docRightId, leftIsReceipt, rightIsReceipt);
		}
		catch (Exception ex) { }
		if (dRItem != null) {
			throw new DuplicateDocumentRelationException();
		}
		
		// Kiem tra dang B relation A
		dRItem = null;
		try {
			dRItem = pmlEdmDocumentRelationPersistence.findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
					docRightId, docLeftId, rightIsReceipt, leftIsReceipt);
		}
		catch (Exception ex) {}
		if (dRItem != null) {
			throw new DuplicateDocumentRelationException();
		}
	}
	
	/**
	 * Xoa cac mau tin van ban lien quan dua vao ma so van ban. Su dung khi xoa van ban den hoac di.
	 * 
	 * @param documentId Ma so van ban
	 * @param isDocReceipt Van ban den hay van van di. True: van ban den, false: van ban di.
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteByDocumentId(long documentId, boolean isDocReceipt) throws PortalException, SystemException {
		
		// Lay danh sach mau tin co ma so left la van ban can xoa
		List<PmlEdmDocumentRelation> delLefts = 
			pmlEdmDocumentRelationPersistence.findByDocLeftId_LeftIsReceipt(
					documentId, isDocReceipt);
		if (!delLefts.isEmpty()) {
			for (int idxDL = 0; idxDL < delLefts.size(); idxDL ++) {
				pmlEdmDocumentRelationPersistence.remove(delLefts.get(idxDL).getDocumentRelationId());
			}
		}
		
		// Lay danh sach mau tin co ma so right la van ban can xoa
		List<PmlEdmDocumentRelation> delRights = 
			pmlEdmDocumentRelationPersistence.findByDocRightId_RightIsReceipt(
					documentId, isDocReceipt);
		if (!delRights.isEmpty()) {
			for (int idxDR = 0; idxDR < delRights.size(); idxDR ++) {
				pmlEdmDocumentRelationPersistence.remove(delRights.get(idxDR).getDocumentRelationId());
			}
		}
	}
	
	/**
	 * Xoa cac mau tin dua vao ma so van ban goc va danh sach ma so van ban lien quan theo loai
	 * 
	 * @param documentId Ma so van ban goc de xoa.
	 * @param isDocReceipt Van ban goc la van ban den hay di. True: van ban den, false: van ban di.
	 * @param relationDocumentIds Danh sach ma so van ban lien quan.
	 * @param isReceiptIdList Danh sach ma so van ban lien quan la van ban den hay di. True: danh sach den, false: danh sach di
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteByDocumentId_RelationDocumentIds(long documentId, boolean isDocReceipt, 
				List<Long> relationDocumentIds, boolean isReceiptIdList) throws PortalException, SystemException {
		
		List<PmlEdmDocumentRelation> delDocRels = new ArrayList<PmlEdmDocumentRelation>();
		
		// ***** Duyet danh sach ma so lien quan de lay ra danh sach cac mau tin can xoa start *****
		if (!relationDocumentIds.isEmpty()) {
			for (int idxRDI = 0; idxRDI < relationDocumentIds.size(); idxRDI ++) {
				// Tim mau tin dang A relation B
				PmlEdmDocumentRelation findDEItem = 
					pmlEdmDocumentRelationPersistence.findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
							documentId, relationDocumentIds.get(idxRDI), isDocReceipt, isReceiptIdList);
				if (findDEItem != null && !delDocRels.contains(findDEItem)) {
					// Them vao danh sach neu doi tuong khac null va chua co trong danh sach xoa
					delDocRels.add(findDEItem);
				}
				// Tim theo dang B relation A
				findDEItem = pmlEdmDocumentRelationPersistence.findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
						relationDocumentIds.get(idxRDI), documentId, isReceiptIdList, isDocReceipt);
				if (findDEItem != null && !delDocRels.contains(findDEItem)) {
					// Them vao danh sach neu doi tuong khac null va chua co trong danh sach xoa
					delDocRels.add(findDEItem);
				}
			}
		}
		// ***** Duyet danh sach ma so lien quan de lay ra danh sach cac mau tin can xoa end *****
		
		// ***** Duyet tung phan tu trong danh sach va xoa start *****
		if (!delDocRels.isEmpty()) {
			for (int idxDDR = 0; idxDDR < delDocRels.size(); idxDDR ++) {
				try {
					pmlEdmDocumentRelationPersistence.remove(delDocRels.get(idxDDR).getDocumentRelationId());
				}
				catch (Exception ex) {
					System.out.println("Co loi trong ham deleteByDocumentId_RelationDocumentIds. Kiem tra lai ma so.");
				}
			}
		}
		// ***** Duyet tung phan tu trong danh sach va xoa end *****
	}
}
