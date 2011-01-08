package com.sgs.portlet.pmllevelsend.service;


/**
 * <a href="PmlEdmLevelSendLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService
 *
 */
public class PmlEdmLevelSendLocalServiceUtil {
    private static PmlEdmLevelSendLocalService _service;

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend addPmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmLevelSend(pmlEdmLevelSend);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend createPmlEdmLevelSend(
        int levelSendId) {
        return getService().createPmlEdmLevelSend(levelSendId);
    }

    public static void deletePmlEdmLevelSend(int levelSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmLevelSend(levelSendId);
    }

    public static void deletePmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmLevelSend(pmlEdmLevelSend);
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

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend getPmlEdmLevelSend(
        int levelSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSend(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> getPmlEdmLevelSends(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSends(start, end);
    }

    public static int getPmlEdmLevelSendsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSendsCount();
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend updatePmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmLevelSend(pmlEdmLevelSend);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId) {
        return getService()
                   .getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo() {
        return getService().getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypeWithPmlEdmDocumentRecordType(
        int documentRecordTypeId) {
        return getService()
                   .getPmlEdmDocumentTypeWithPmlEdmDocumentRecordType(documentRecordTypeId);
    }

    public static java.lang.String getNumberDocumentReceipt(
        long documentRecordId) {
        return getService().getNumberDocumentReceipt(documentRecordId);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> getAll()
        throws com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendIds(
        java.util.List<Integer> levelSendIds) throws java.lang.Exception {
        return getService().findByLevelSendIds(levelSendIds);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static void removePmlEdmLevelSend(int levelSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmLevelSend(levelSendId);
    }

    public static PmlEdmLevelSendLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlEdmLevelSendLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmLevelSendLocalService service) {
        _service = service;
    }
}
