package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlTransitionLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlTransitionLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlTransitionLocalService
 *
 */
public class PmlTransitionLocalServiceUtil {
    private static PmlTransitionLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlTransition addPmlTransition(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTransition(pmlTransition);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition createPmlTransition(
        long transitionId) {
        return getService().createPmlTransition(transitionId);
    }

    public static void deletePmlTransition(long transitionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTransition(transitionId);
    }

    public static void deletePmlTransition(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTransition(pmlTransition);
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

    public static com.nss.portlet.onedoor.model.PmlTransition getPmlTransition(
        long transitionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTransition(transitionId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> getPmlTransitions(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTransitions(start, end);
    }

    public static int getPmlTransitionsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTransitionsCount();
    }

    public static com.nss.portlet.onedoor.model.PmlTransition updatePmlTransition(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTransition(pmlTransition);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition updatePmlTransition(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTransition(pmlTransition, merge);
    }

    public static int countByFileTypeId(java.lang.String fileTypeId) {
        return getService().countByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getService().findByFileTypeId(fileTypeId);
    }

    public static PmlTransitionLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTransitionLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTransitionLocalService service) {
        _service = service;
    }
}
