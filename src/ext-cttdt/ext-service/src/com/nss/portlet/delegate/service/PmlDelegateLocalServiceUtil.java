package com.nss.portlet.delegate.service;


/**
 * <a href="PmlDelegateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.delegate.service.PmlDelegateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.delegate.service.PmlDelegateLocalService
 *
 */
public class PmlDelegateLocalServiceUtil {
    private static PmlDelegateLocalService _service;

    public static com.nss.portlet.delegate.model.PmlDelegate addPmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDelegate(pmlDelegate);
    }

    public static com.nss.portlet.delegate.model.PmlDelegate createPmlDelegate(
        long delegateId) {
        return getService().createPmlDelegate(delegateId);
    }

    public static void deletePmlDelegate(long delegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDelegate(delegateId);
    }

    public static void deletePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDelegate(pmlDelegate);
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

    public static com.nss.portlet.delegate.model.PmlDelegate getPmlDelegate(
        long delegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDelegate(delegateId);
    }

    public static java.util.List<com.nss.portlet.delegate.model.PmlDelegate> getPmlDelegates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDelegates(start, end);
    }

    public static int getPmlDelegatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDelegatesCount();
    }

    public static com.nss.portlet.delegate.model.PmlDelegate updatePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDelegate(pmlDelegate);
    }

    public static com.nss.portlet.delegate.model.PmlDelegate updatePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDelegate(pmlDelegate, merge);
    }

    public static java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner(
        long assignerId) throws com.liferay.portal.SystemException {
        return getService().findByAssigner(assignerId);
    }

    public static PmlDelegateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlDelegateLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDelegateLocalService service) {
        _service = service;
    }
}
