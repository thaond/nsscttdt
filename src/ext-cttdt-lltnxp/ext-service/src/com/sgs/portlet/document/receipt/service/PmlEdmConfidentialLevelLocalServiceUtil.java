package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmConfidentialLevelLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService
 *
 */
public class PmlEdmConfidentialLevelLocalServiceUtil {
    private static PmlEdmConfidentialLevelLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel addPmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmConfidentialLevel(pmlEdmConfidentialLevel);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel createPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId) {
        return getService().createPmlEdmConfidentialLevel(confidentialLevelId);
    }

    public static void deletePmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmConfidentialLevel(confidentialLevelId);
    }

    public static void deletePmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmConfidentialLevel(pmlEdmConfidentialLevel);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel getPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmConfidentialLevel(confidentialLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> getPmlEdmConfidentialLevels(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmConfidentialLevels(start, end);
    }

    public static int getPmlEdmConfidentialLevelsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmConfidentialLevelsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updatePmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmConfidentialLevel(pmlEdmConfidentialLevel);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel addPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelName, int confidentialLevelSymbol,
        boolean limitViewDetail, boolean haveProcess)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmConfidentialLevel(confidentialLevelName,
            confidentialLevelSymbol, limitViewDetail, haveProcess);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updatePmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId,
        java.lang.String confidentialLevelName, int confidentialLevelSymbol,
        boolean limitViewDetail, boolean haveProcess)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmConfidentialLevel(confidentialLevelId,
            confidentialLevelName, confidentialLevelSymbol, limitViewDetail,
            haveProcess);
    }

    public static PmlEdmConfidentialLevelLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmConfidentialLevelLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmConfidentialLevelLocalService service) {
        _service = service;
    }
}
