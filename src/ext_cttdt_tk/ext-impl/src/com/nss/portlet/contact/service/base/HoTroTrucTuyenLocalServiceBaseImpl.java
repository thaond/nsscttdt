package com.nss.portlet.contact.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.contact.model.HoTroTrucTuyen;
import com.nss.portlet.contact.service.HoTroTrucTuyenLocalService;
import com.nss.portlet.contact.service.HoTroTrucTuyenService;
import com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence;

import java.util.List;


public abstract class HoTroTrucTuyenLocalServiceBaseImpl
    implements HoTroTrucTuyenLocalService {
    @BeanReference(name = "com.nss.portlet.contact.service.HoTroTrucTuyenLocalService.impl")
    protected HoTroTrucTuyenLocalService hoTroTrucTuyenLocalService;
    @BeanReference(name = "com.nss.portlet.contact.service.HoTroTrucTuyenService.impl")
    protected HoTroTrucTuyenService hoTroTrucTuyenService;
    @BeanReference(name = "com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence.impl")
    protected HoTroTrucTuyenPersistence hoTroTrucTuyenPersistence;

    public HoTroTrucTuyen addHoTroTrucTuyen(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        hoTroTrucTuyen.setNew(true);

        return hoTroTrucTuyenPersistence.update(hoTroTrucTuyen, false);
    }

    public HoTroTrucTuyen createHoTroTrucTuyen(int maHoTroTrucTuyen) {
        return hoTroTrucTuyenPersistence.create(maHoTroTrucTuyen);
    }

    public void deleteHoTroTrucTuyen(int maHoTroTrucTuyen)
        throws PortalException, SystemException {
        hoTroTrucTuyenPersistence.remove(maHoTroTrucTuyen);
    }

    public void deleteHoTroTrucTuyen(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        hoTroTrucTuyenPersistence.remove(hoTroTrucTuyen);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return hoTroTrucTuyenPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return hoTroTrucTuyenPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public HoTroTrucTuyen getHoTroTrucTuyen(int maHoTroTrucTuyen)
        throws PortalException, SystemException {
        return hoTroTrucTuyenPersistence.findByPrimaryKey(maHoTroTrucTuyen);
    }

    public List<HoTroTrucTuyen> getHoTroTrucTuyens(int start, int end)
        throws SystemException {
        return hoTroTrucTuyenPersistence.findAll(start, end);
    }

    public int getHoTroTrucTuyensCount() throws SystemException {
        return hoTroTrucTuyenPersistence.countAll();
    }

    public HoTroTrucTuyen updateHoTroTrucTuyen(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        hoTroTrucTuyen.setNew(false);

        return hoTroTrucTuyenPersistence.update(hoTroTrucTuyen, true);
    }

    public HoTroTrucTuyen updateHoTroTrucTuyen(HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws SystemException {
        hoTroTrucTuyen.setNew(false);

        return hoTroTrucTuyenPersistence.update(hoTroTrucTuyen, merge);
    }

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
