package com.nss.portlet.holidaymanagement.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService;
import com.nss.portlet.holidaymanagement.service.PmlHolidayService;
import com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence;


public abstract class PmlHolidayServiceBaseImpl extends PrincipalBean
    implements PmlHolidayService {
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.PmlHolidayLocalService.impl")
    protected PmlHolidayLocalService pmlHolidayLocalService;
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.PmlHolidayService.impl")
    protected PmlHolidayService pmlHolidayService;
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence.impl")
    protected PmlHolidayPersistence pmlHolidayPersistence;

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
