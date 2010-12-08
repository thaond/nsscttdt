package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlFileReturningInfoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalService
 *
 */
public class PmlFileReturningInfoLocalServiceUtil {
    private static PmlFileReturningInfoLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlFileReturningInfo addPmlFileReturningInfo(
        com.nss.portlet.onedoor.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileReturningInfo(pmlFileReturningInfo);
    }

    public static com.nss.portlet.onedoor.model.PmlFileReturningInfo createPmlFileReturningInfo(
        long fileReturningInfoId) {
        return getService().createPmlFileReturningInfo(fileReturningInfoId);
    }

    public static void deletePmlFileReturningInfo(long fileReturningInfoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileReturningInfo(fileReturningInfoId);
    }

    public static void deletePmlFileReturningInfo(
        com.nss.portlet.onedoor.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileReturningInfo(pmlFileReturningInfo);
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

    public static com.nss.portlet.onedoor.model.PmlFileReturningInfo getPmlFileReturningInfo(
        long fileReturningInfoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileReturningInfo(fileReturningInfoId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileReturningInfo> getPmlFileReturningInfos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileReturningInfos(start, end);
    }

    public static int getPmlFileReturningInfosCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileReturningInfosCount();
    }

    public static com.nss.portlet.onedoor.model.PmlFileReturningInfo updatePmlFileReturningInfo(
        com.nss.portlet.onedoor.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileReturningInfo(pmlFileReturningInfo);
    }

    public static com.nss.portlet.onedoor.model.PmlFileReturningInfo updatePmlFileReturningInfo(
        com.nss.portlet.onedoor.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFileReturningInfo(pmlFileReturningInfo, merge);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getService().findByFileId(fileId);
    }

    public static PmlFileReturningInfoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileReturningInfoLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileReturningInfoLocalService service) {
        _service = service;
    }
}
