package com.nss.portlet.holidaymanagement.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


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
 * <code>com.nss.portlet.holidaymanagement.service.impl.PmlHolidayLocalServiceImpl</code>.
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
 * @see com.nss.portlet.holidaymanagement.service.PmlHolidayLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlHolidayLocalService {
    public com.nss.portlet.holidaymanagement.model.PmlHoliday addPmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.holidaymanagement.model.PmlHoliday createPmlHoliday(
        long holidayId);

    public void deletePmlHoliday(long holidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.holidaymanagement.model.PmlHoliday getPmlHoliday(
        long holidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> getPmlHolidaies(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlHolidaiesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.holidaymanagement.model.PmlHoliday updatePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.holidaymanagement.model.PmlHoliday updatePmlHoliday(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Date getExpextedRetrningDateByDateArrive(
        java.util.Date dateArrive, int numProcessDate);

    public int countHolidayByValue(java.lang.String holidayValue)
        throws com.liferay.portal.SystemException;

    public int checkDateHoliday(java.lang.String dateReceipt,
        int fileProcessNumber);
}
