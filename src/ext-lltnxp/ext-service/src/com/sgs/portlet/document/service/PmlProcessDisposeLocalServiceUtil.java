package com.sgs.portlet.document.service;


/**
 * <a href="PmlProcessDisposeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlProcessDisposeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlProcessDisposeLocalService
 *
 */
public class PmlProcessDisposeLocalServiceUtil {
    private static PmlProcessDisposeLocalService _service;

    public static com.sgs.portlet.document.model.PmlProcessDispose addPmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException {
        return getService().addPmlProcessDispose(pmlProcessDispose);
    }

    public static com.sgs.portlet.document.model.PmlProcessDispose createPmlProcessDispose(
        long processDisposeId) {
        return getService().createPmlProcessDispose(processDisposeId);
    }

    public static void deletePmlProcessDispose(long processDisposeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlProcessDispose(processDisposeId);
    }

    public static void deletePmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException {
        getService().deletePmlProcessDispose(pmlProcessDispose);
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

    public static com.sgs.portlet.document.model.PmlProcessDispose getPmlProcessDispose(
        long processDisposeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlProcessDispose(processDisposeId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getPmlProcessDisposes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlProcessDisposes(start, end);
    }

    public static int getPmlProcessDisposesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlProcessDisposesCount();
    }

    public static com.sgs.portlet.document.model.PmlProcessDispose updatePmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlProcessDispose(pmlProcessDispose);
    }

    public static PmlProcessDisposeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlProcessDisposeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlProcessDisposeLocalService service) {
        _service = service;
    }
}
