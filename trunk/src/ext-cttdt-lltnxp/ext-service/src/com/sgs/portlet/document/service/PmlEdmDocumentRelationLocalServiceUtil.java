package com.sgs.portlet.document.service;


/**
 * <a href="PmlEdmDocumentRelationLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService
 *
 */
public class PmlEdmDocumentRelationLocalServiceUtil {
    private static PmlEdmDocumentRelationLocalService _service;

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation addPmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentRelation(pmlEdmDocumentRelation);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation createPmlEdmDocumentRelation(
        long documentRelationId) {
        return getService().createPmlEdmDocumentRelation(documentRelationId);
    }

    public static void deletePmlEdmDocumentRelation(long documentRelationId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRelation(documentRelationId);
    }

    public static void deletePmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRelation(pmlEdmDocumentRelation);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation getPmlEdmDocumentRelation(
        long documentRelationId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRelation(documentRelationId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> getPmlEdmDocumentRelations(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRelations(start, end);
    }

    public static int getPmlEdmDocumentRelationsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRelationsCount();
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation updatePmlEdmDocumentRelation(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocumentRelation(pmlEdmDocumentRelation);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation addPmlEdmDocumentRelation(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmDocumentRelation(docLeftId, docRightId,
            leftIsReceipt, rightIsReceipt);
    }

    public static void deleteByDocumentId(long documentId, boolean isDocReceipt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteByDocumentId(documentId, isDocReceipt);
    }

    public static void deleteByDocumentId_RelationDocumentIds(long documentId,
        boolean isDocReceipt, java.util.List<Long> relationDocumentIds,
        boolean isReceiptIdList)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deleteByDocumentId_RelationDocumentIds(documentId, isDocReceipt,
            relationDocumentIds, isReceiptIdList);
    }

    public static PmlEdmDocumentRelationLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentRelationLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentRelationLocalService service) {
        _service = service;
    }
}
