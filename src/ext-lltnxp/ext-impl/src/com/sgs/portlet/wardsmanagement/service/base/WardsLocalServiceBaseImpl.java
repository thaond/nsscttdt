package com.sgs.portlet.wardsmanagement.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.service.WardsLocalService;
import com.sgs.portlet.wardsmanagement.service.WardsService;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsFinder;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsPersistence;

import java.util.List;


public abstract class WardsLocalServiceBaseImpl implements WardsLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.WardsLocalService.impl")
    protected WardsLocalService wardsLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.WardsService.impl")
    protected WardsService wardsService;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.persistence.WardsPersistence.impl")
    protected WardsPersistence wardsPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.persistence.WardsFinder.impl")
    protected WardsFinder wardsFinder;

    public Wards addWards(Wards wards) throws SystemException {
        wards.setNew(true);

        return wardsPersistence.update(wards, false);
    }

    public Wards createWards(String wardsId) {
        return wardsPersistence.create(wardsId);
    }

    public void deleteWards(String wardsId)
        throws PortalException, SystemException {
        wardsPersistence.remove(wardsId);
    }

    public void deleteWards(Wards wards) throws SystemException {
        wardsPersistence.remove(wards);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return wardsPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return wardsPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Wards getWards(String wardsId)
        throws PortalException, SystemException {
        return wardsPersistence.findByPrimaryKey(wardsId);
    }

    public List<Wards> getWardses(int start, int end) throws SystemException {
        return wardsPersistence.findAll(start, end);
    }

    public int getWardsesCount() throws SystemException {
        return wardsPersistence.countAll();
    }

    public Wards updateWards(Wards wards) throws SystemException {
        wards.setNew(false);

        return wardsPersistence.update(wards, true);
    }

    public WardsLocalService getWardsLocalService() {
        return wardsLocalService;
    }

    public void setWardsLocalService(WardsLocalService wardsLocalService) {
        this.wardsLocalService = wardsLocalService;
    }

    public WardsService getWardsService() {
        return wardsService;
    }

    public void setWardsService(WardsService wardsService) {
        this.wardsService = wardsService;
    }

    public WardsPersistence getWardsPersistence() {
        return wardsPersistence;
    }

    public void setWardsPersistence(WardsPersistence wardsPersistence) {
        this.wardsPersistence = wardsPersistence;
    }

    public WardsFinder getWardsFinder() {
        return wardsFinder;
    }

    public void setWardsFinder(WardsFinder wardsFinder) {
        this.wardsFinder = wardsFinder;
    }
}
