package com.sgs.portlet.document.service;


/**
 * <a href="PmlFileStatusLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlFileStatusLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlFileStatusLocalService
 *
 */
public class PmlFileStatusLocalServiceUtil {
    private static PmlFileStatusLocalService _service;

    public static com.sgs.portlet.document.model.PmlFileStatus addPmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileStatus(pmlFileStatus);
    }

    public static com.sgs.portlet.document.model.PmlFileStatus createPmlFileStatus(
        long fileStatusId) {
        return getService().createPmlFileStatus(fileStatusId);
    }

    public static void deletePmlFileStatus(long fileStatusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileStatus(fileStatusId);
    }

    public static void deletePmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileStatus(pmlFileStatus);
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

    public static com.sgs.portlet.document.model.PmlFileStatus getPmlFileStatus(
        long fileStatusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileStatus(fileStatusId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> getPmlFileStatuses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileStatuses(start, end);
    }

    public static int getPmlFileStatusesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileStatusesCount();
    }

    public static com.sgs.portlet.document.model.PmlFileStatus updatePmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileStatus(pmlFileStatus);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByType(
        java.lang.String type) throws com.liferay.portal.SystemException {
        return getService().findByType(type);
    }

    public static int searchCountCV(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountCV(keywords);
    }

    public static int searchCountCV(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCountCV(fileStatusCode, fileStatusName, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchCV(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchCV(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchCV(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCV(fileStatusCode, fileStatusName, andOperator,
            start, end, obc);
    }

    public static int searchCountMC(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountMC(keywords);
    }

    public static int searchCountMC(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCountMC(fileStatusCode, fileStatusName, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchMC(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchMC(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchMC(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchMC(fileStatusCode, fileStatusName, andOperator,
            start, end, obc);
    }

    public static void removeFileStatus(long fileStatusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeFileStatus(fileStatusId);
    }

    public static com.sgs.portlet.document.model.PmlFileStatus addFileStatus(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        java.lang.String description, java.lang.String active,
        java.lang.String type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addFileStatus(fileStatusCode, fileStatusName, description,
            active, type);
    }

    public static com.sgs.portlet.document.model.PmlFileStatus updateFileStatus(
        long fileStatusId, java.lang.String fileStatusCode,
        java.lang.String fileStatusName, java.lang.String description,
        java.lang.String active, java.lang.String type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateFileStatus(fileStatusId, fileStatusCode,
            fileStatusName, description, active, type);
    }

    public static PmlFileStatusLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlFileStatusLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileStatusLocalService service) {
        _service = service;
    }
}
