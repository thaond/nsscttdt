package com.nss.portlet.holidaymanagement.service;


/**
 * <a href="PmlHolidayLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService
 *
 */
public class PmlHolidayLocalServiceUtil {
    private static PmlHolidayLocalService _service;

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday addPmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException {
        return getService().addPmlHoliday(pmlHoliday);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday createPmlHoliday(
        long holidayId) {
        return getService().createPmlHoliday(holidayId);
    }

    public static void deletePmlHoliday(long holidayId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlHoliday(holidayId);
    }

    public static void deletePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException {
        getService().deletePmlHoliday(pmlHoliday);
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

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday getPmlHoliday(
        long holidayId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlHoliday(holidayId);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> getPmlHolidaies(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlHolidaies(start, end);
    }

    public static int getPmlHolidaiesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlHolidaiesCount();
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday updatePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlHoliday(pmlHoliday);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday updatePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlHoliday(pmlHoliday, merge);
    }

    public static java.util.Date getExpextedRetrningDateByDateArrive(
        java.util.Date dateArrive, int numProcessDate) {
        return getService()
                   .getExpextedRetrningDateByDateArrive(dateArrive,
            numProcessDate);
    }

    public static int countHolidayByValue(java.lang.String holidayValue)
        throws com.liferay.portal.SystemException {
        return getService().countHolidayByValue(holidayValue);
    }

    public static int checkDateHoliday(java.lang.String dateReceipt,
        int fileProcessNumber) {
        return getService().checkDateHoliday(dateReceipt, fileProcessNumber);
    }

    public static PmlHolidayLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlHolidayLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlHolidayLocalService service) {
        _service = service;
    }
}
