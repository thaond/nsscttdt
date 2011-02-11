package com.sgs.portlet.pmlissuingplace.service;


/**
 * <a href="PmlEdmIssuingPlaceLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService
 *
 */
public class PmlEdmIssuingPlaceLocalServiceUtil {
    private static PmlEdmIssuingPlaceLocalService _service;

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace addPmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmIssuingPlace(pmlEdmIssuingPlace);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace createPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId) {
        return getService().createPmlEdmIssuingPlace(issuingPlaceId);
    }

    public static void deletePmlEdmIssuingPlace(java.lang.String issuingPlaceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmIssuingPlace(issuingPlaceId);
    }

    public static void deletePmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmIssuingPlace(pmlEdmIssuingPlace);
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

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace getPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmIssuingPlace(issuingPlaceId);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlaces(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmIssuingPlaces(start, end);
    }

    public static int getPmlEdmIssuingPlacesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmIssuingPlacesCount();
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmIssuingPlace(pmlEdmIssuingPlace);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace addPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        java.lang.String note, java.lang.String signer)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName,
            note, signer);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceIds(
        java.util.List<String> issuingPlaceIds) throws java.lang.Exception {
        return getService().findByIssuingPlaceIds(issuingPlaceIds);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords2(
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getService().findByKeywords2(keywords);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId) throws java.lang.Exception {
        return getService()
                   .getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
    }

    public static void removePmlEdmIssuingPlace(java.lang.String issuingPlaceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmIssuingPlace(issuingPlaceId);
    }

    public static int searchCountIssuingPlace(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountIssuingPlace(keywords);
    }

    public static int searchCountIssuingPlace(java.lang.String codes,
        java.lang.String names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCountIssuingPlace(codes, names, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> searchIssuingPlace(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchIssuingPlace(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> searchIssuingPlace(
        java.lang.String codes, java.lang.String names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchIssuingPlace(codes, names, andOperator, start, end,
            obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        java.lang.String signer) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName,
            signer);
    }

    public static PmlEdmIssuingPlaceLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmIssuingPlaceLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmIssuingPlaceLocalService service) {
        _service = service;
    }
}
