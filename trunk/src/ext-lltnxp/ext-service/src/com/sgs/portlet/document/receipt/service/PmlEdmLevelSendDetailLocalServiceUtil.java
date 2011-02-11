package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmLevelSendDetailLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService
 *
 */
public class PmlEdmLevelSendDetailLocalServiceUtil {
    private static PmlEdmLevelSendDetailLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail addPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmLevelSendDetail(pmlEdmLevelSendDetail);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail createPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK) {
        return getService().createPmlEdmLevelSendDetail(pmlEdmLevelSendDetailPK);
    }

    public static void deletePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmLevelSendDetail(pmlEdmLevelSendDetailPK);
    }

    public static void deletePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmLevelSendDetail(pmlEdmLevelSendDetail);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail getPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSendDetail(pmlEdmLevelSendDetailPK);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> getPmlEdmLevelSendDetails(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSendDetails(start, end);
    }

    public static int getPmlEdmLevelSendDetailsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmLevelSendDetailsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail updatePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmLevelSendDetail(pmlEdmLevelSendDetail);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> getAll()
        throws com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static boolean addPmlEdmLevelSendDetailList(
        java.lang.String levelSendIdList, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmLevelSendDetailList(levelSendIdList, issuingPlaceId);
    }

    public static boolean updatePmlEdmLevelSendDetailList(
        java.lang.String levelSendIdList, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmLevelSendDetailList(levelSendIdList,
            issuingPlaceId);
    }

    public static boolean hasLevelSend(int levelSendId,
        java.lang.String issuingPlaceId) {
        return getService().hasLevelSend(levelSendId, issuingPlaceId);
    }

    public static PmlEdmLevelSendDetailLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmLevelSendDetailLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmLevelSendDetailLocalService service) {
        _service = service;
    }
}
