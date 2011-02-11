package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service;


/**
 * <a href="PmlFileTypeDelegateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService
 *
 */
public class PmlFileTypeDelegateLocalServiceUtil {
    private static PmlFileTypeDelegateLocalService _service;

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate addPmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileTypeDelegate(pmlFileTypeDelegate);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate createPmlFileTypeDelegate(
        long fileTypeDelegateId) {
        return getService().createPmlFileTypeDelegate(fileTypeDelegateId);
    }

    public static void deletePmlFileTypeDelegate(long fileTypeDelegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileTypeDelegate(fileTypeDelegateId);
    }

    public static void deletePmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileTypeDelegate(pmlFileTypeDelegate);
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

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate getPmlFileTypeDelegate(
        long fileTypeDelegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileTypeDelegate(fileTypeDelegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> getPmlFileTypeDelegates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypeDelegates(start, end);
    }

    public static int getPmlFileTypeDelegatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypeDelegatesCount();
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate updatePmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileTypeDelegate(pmlFileTypeDelegate);
    }

    public static PmlFileTypeDelegateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileTypeDelegateLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileTypeDelegateLocalService service) {
        _service = service;
    }
}
