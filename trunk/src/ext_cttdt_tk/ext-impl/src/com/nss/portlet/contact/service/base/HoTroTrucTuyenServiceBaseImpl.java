package com.nss.portlet.contact.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.contact.service.HoTroTrucTuyenLocalService;
import com.nss.portlet.contact.service.HoTroTrucTuyenService;
import com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence;


public abstract class HoTroTrucTuyenServiceBaseImpl extends PrincipalBean
    implements HoTroTrucTuyenService {
    @BeanReference(name = "com.nss.portlet.contact.service.HoTroTrucTuyenLocalService.impl")
    protected HoTroTrucTuyenLocalService hoTroTrucTuyenLocalService;
    @BeanReference(name = "com.nss.portlet.contact.service.HoTroTrucTuyenService.impl")
    protected HoTroTrucTuyenService hoTroTrucTuyenService;
    @BeanReference(name = "com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence.impl")
    protected HoTroTrucTuyenPersistence hoTroTrucTuyenPersistence;

    public HoTroTrucTuyenLocalService getHoTroTrucTuyenLocalService() {
        return hoTroTrucTuyenLocalService;
    }

    public void setHoTroTrucTuyenLocalService(
        HoTroTrucTuyenLocalService hoTroTrucTuyenLocalService) {
        this.hoTroTrucTuyenLocalService = hoTroTrucTuyenLocalService;
    }

    public HoTroTrucTuyenService getHoTroTrucTuyenService() {
        return hoTroTrucTuyenService;
    }

    public void setHoTroTrucTuyenService(
        HoTroTrucTuyenService hoTroTrucTuyenService) {
        this.hoTroTrucTuyenService = hoTroTrucTuyenService;
    }

    public HoTroTrucTuyenPersistence getHoTroTrucTuyenPersistence() {
        return hoTroTrucTuyenPersistence;
    }

    public void setHoTroTrucTuyenPersistence(
        HoTroTrucTuyenPersistence hoTroTrucTuyenPersistence) {
        this.hoTroTrucTuyenPersistence = hoTroTrucTuyenPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
