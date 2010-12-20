package com.nss.portlet.holidaymanagement.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.holidaymanagement.model.PmlHoliday;
import com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService;
import com.nss.portlet.holidaymanagement.service.PmlHolidayService;
import com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence;

import java.util.List;


public abstract class PmlHolidayLocalServiceBaseImpl
    implements PmlHolidayLocalService {
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService.impl")
    protected PmlHolidayLocalService pmlHolidayLocalService;
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.PmlHolidayService.impl")
    protected PmlHolidayService pmlHolidayService;
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence.impl")
    protected PmlHolidayPersistence pmlHolidayPersistence;

    public PmlHoliday addPmlHoliday(PmlHoliday pmlHoliday)
        throws SystemException {
        pmlHoliday.setNew(true);

        return pmlHolidayPersistence.update(pmlHoliday, false);
    }

    public PmlHoliday createPmlHoliday(long holidayId) {
        return pmlHolidayPersistence.create(holidayId);
    }

    public void deletePmlHoliday(long holidayId)
        throws PortalException, SystemException {
        pmlHolidayPersistence.remove(holidayId);
    }

    public void deletePmlHoliday(PmlHoliday pmlHoliday)
        throws SystemException {
        pmlHolidayPersistence.remove(pmlHoliday);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlHolidayPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlHolidayPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlHoliday getPmlHoliday(long holidayId)
        throws PortalException, SystemException {
        return pmlHolidayPersistence.findByPrimaryKey(holidayId);
    }

    public List<PmlHoliday> getPmlHolidaies(int start, int end)
        throws SystemException {
        return pmlHolidayPersistence.findAll(start, end);
    }

    public int getPmlHolidaiesCount() throws SystemException {
        return pmlHolidayPersistence.countAll();
    }

    public PmlHoliday updatePmlHoliday(PmlHoliday pmlHoliday)
        throws SystemException {
        pmlHoliday.setNew(false);

        return pmlHolidayPersistence.update(pmlHoliday, true);
    }

    public PmlHoliday updatePmlHoliday(PmlHoliday pmlHoliday, boolean merge)
        throws SystemException {
        pmlHoliday.setNew(false);

        return pmlHolidayPersistence.update(pmlHoliday, merge);
    }

    public PmlHolidayLocalService getPmlHolidayLocalService() {
        return pmlHolidayLocalService;
    }

    public void setPmlHolidayLocalService(
        PmlHolidayLocalService pmlHolidayLocalService) {
        this.pmlHolidayLocalService = pmlHolidayLocalService;
    }

    public PmlHolidayService getPmlHolidayService() {
        return pmlHolidayService;
    }

    public void setPmlHolidayService(PmlHolidayService pmlHolidayService) {
        this.pmlHolidayService = pmlHolidayService;
    }

    public PmlHolidayPersistence getPmlHolidayPersistence() {
        return pmlHolidayPersistence;
    }

    public void setPmlHolidayPersistence(
        PmlHolidayPersistence pmlHolidayPersistence) {
        this.pmlHolidayPersistence = pmlHolidayPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
