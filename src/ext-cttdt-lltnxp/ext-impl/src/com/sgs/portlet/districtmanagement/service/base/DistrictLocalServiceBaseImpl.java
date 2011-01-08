package com.sgs.portlet.districtmanagement.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.DistrictLocalService;
import com.sgs.portlet.districtmanagement.service.DistrictService;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictFinder;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictPersistence;

import java.util.List;


public abstract class DistrictLocalServiceBaseImpl
    implements DistrictLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.DistrictLocalService.impl")
    protected DistrictLocalService districtLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.DistrictService.impl")
    protected DistrictService districtService;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.persistence.DistrictPersistence.impl")
    protected DistrictPersistence districtPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.persistence.DistrictFinder.impl")
    protected DistrictFinder districtFinder;

    public District addDistrict(District district) throws SystemException {
        district.setNew(true);

        return districtPersistence.update(district, false);
    }

    public District createDistrict(String districtId) {
        return districtPersistence.create(districtId);
    }

    public void deleteDistrict(String districtId)
        throws PortalException, SystemException {
        districtPersistence.remove(districtId);
    }

    public void deleteDistrict(District district) throws SystemException {
        districtPersistence.remove(district);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return districtPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return districtPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public District getDistrict(String districtId)
        throws PortalException, SystemException {
        return districtPersistence.findByPrimaryKey(districtId);
    }

    public List<District> getDistricts(int start, int end)
        throws SystemException {
        return districtPersistence.findAll(start, end);
    }

    public int getDistrictsCount() throws SystemException {
        return districtPersistence.countAll();
    }

    public District updateDistrict(District district) throws SystemException {
        district.setNew(false);

        return districtPersistence.update(district, true);
    }

    public DistrictLocalService getDistrictLocalService() {
        return districtLocalService;
    }

    public void setDistrictLocalService(
        DistrictLocalService districtLocalService) {
        this.districtLocalService = districtLocalService;
    }

    public DistrictService getDistrictService() {
        return districtService;
    }

    public void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    public DistrictPersistence getDistrictPersistence() {
        return districtPersistence;
    }

    public void setDistrictPersistence(DistrictPersistence districtPersistence) {
        this.districtPersistence = districtPersistence;
    }

    public DistrictFinder getDistrictFinder() {
        return districtFinder;
    }

    public void setDistrictFinder(DistrictFinder districtFinder) {
        this.districtFinder = districtFinder;
    }
}
