package com.sgs.portlet.document.service;


/**
 * <a href="PmlEdmDocumentRelationLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlEdmDocumentRelationLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalServiceUtil
 *
 */
public interface PmlEdmDocumentRelationLocalService {
    public com.sgs.portlet.document.model.PmlEdmDocumentRelation addPmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation createPmlEdmDocumentRelation(
        long documentRelationId);

    public void deletePmlEdmDocumentRelation(long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation getPmlEdmDocumentRelation(
        long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> getPmlEdmDocumentRelations(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentRelationsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation updatePmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation addPmlEdmDocumentRelation(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteByDocumentId(long documentId, boolean isDocReceipt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteByDocumentId_RelationDocumentIds(long documentId,
        boolean isDocReceipt, java.util.List<Long> relationDocumentIds,
        boolean isReceiptIdList)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
