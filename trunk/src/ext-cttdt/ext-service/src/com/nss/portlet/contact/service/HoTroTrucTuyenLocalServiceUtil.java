package com.nss.portlet.contact.service;


/**
 * <a href="HoTroTrucTuyenLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.contact.service.HoTroTrucTuyenLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.contact.service.HoTroTrucTuyenLocalService
 *
 */
public class HoTroTrucTuyenLocalServiceUtil {
    private static HoTroTrucTuyenLocalService _service;

    public static com.nss.portlet.contact.model.HoTroTrucTuyen addHoTroTrucTuyen(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException {
        return getService().addHoTroTrucTuyen(hoTroTrucTuyen);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen createHoTroTrucTuyen(
        int maHoTroTrucTuyen) {
        return getService().createHoTroTrucTuyen(maHoTroTrucTuyen);
    }

    public static void deleteHoTroTrucTuyen(int maHoTroTrucTuyen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteHoTroTrucTuyen(maHoTroTrucTuyen);
    }

    public static void deleteHoTroTrucTuyen(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException {
        getService().deleteHoTroTrucTuyen(hoTroTrucTuyen);
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

    public static com.nss.portlet.contact.model.HoTroTrucTuyen getHoTroTrucTuyen(
        int maHoTroTrucTuyen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getHoTroTrucTuyen(maHoTroTrucTuyen);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> getHoTroTrucTuyens(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getHoTroTrucTuyens(start, end);
    }

    public static int getHoTroTrucTuyensCount()
        throws com.liferay.portal.SystemException {
        return getService().getHoTroTrucTuyensCount();
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen updateHoTroTrucTuyen(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException {
        return getService().updateHoTroTrucTuyen(hoTroTrucTuyen);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen updateHoTroTrucTuyen(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateHoTroTrucTuyen(hoTroTrucTuyen, merge);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getService().findByActive(active);
    }

    public static HoTroTrucTuyenLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("HoTroTrucTuyenLocalService is not set");
        }

        return _service;
    }

    public void setService(HoTroTrucTuyenLocalService service) {
        _service = service;
    }
}
