package com.sgs.portlet.holiday.service;


/**
 * <a href="PmlHolidayLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.holiday.service.impl.PmlHolidayLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil
 *
 */
public interface PmlHolidayLocalService {
    public com.sgs.portlet.holiday.model.PmlHoliday addPmlHoliday(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday createPmlHoliday(
        long holidayId);

    public void deletePmlHoliday(long holidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlHoliday(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday getPmlHoliday(
        long holidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> getPmlHolidaies(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlHolidaiesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday updatePmlHoliday(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public java.util.Date getExpextedRetrningDateByDateArrive(
        java.util.Date dateArrive, int numProcessDate);

    public int checkDateHolidayHelp(java.lang.String dateReceipt,
        int fileProcessNumber);

    public int checkDateHoliday(java.lang.String dateReceipt,
        int fileProcessNumber);

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findListPmlHoliday(
        int start, int end) throws com.liferay.portal.SystemException;

    public int countListPmlHoliday() throws java.lang.Exception;

    public int countHolidayByValue(java.lang.String holidayValue)
        throws com.liferay.portal.SystemException;

    public int checkDateHolidayWithTwoDays(java.lang.String dateReceipt,
        java.lang.String dateInput);
}
