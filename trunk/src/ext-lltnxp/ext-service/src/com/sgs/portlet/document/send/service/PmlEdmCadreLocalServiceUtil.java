package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmCadreLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.send.service.PmlEdmCadreLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreLocalService
 *
 */
public class PmlEdmCadreLocalServiceUtil {
    private static PmlEdmCadreLocalService _service;

    public static com.sgs.portlet.document.send.model.PmlEdmCadre addPmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmCadre(pmlEdmCadre);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre createPmlEdmCadre(
        long userId) {
        return getService().createPmlEdmCadre(userId);
    }

    public static void deletePmlEdmCadre(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmCadre(userId);
    }

    public static void deletePmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmCadre(pmlEdmCadre);
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

    public static com.sgs.portlet.document.send.model.PmlEdmCadre getPmlEdmCadre(
        long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmCadre(userId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> getPmlEdmCadres(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmCadres(start, end);
    }

    public static int getPmlEdmCadresCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmCadresCount();
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre updatePmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmCadre(pmlEdmCadre);
    }

    public static PmlEdmCadreLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlEdmCadreLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmCadreLocalService service) {
        _service = service;
    }
}
