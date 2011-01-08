package com.sgs.portlet.nation.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.country.service.CountryLocalService;
import com.sgs.portlet.country.service.CountryService;
import com.sgs.portlet.country.service.persistence.CountryFinder;
import com.sgs.portlet.country.service.persistence.CountryPersistence;
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.service.NationLocalService;
import com.sgs.portlet.nation.service.NationService;
import com.sgs.portlet.nation.service.persistence.NationFinder;
import com.sgs.portlet.nation.service.persistence.NationPersistence;

import java.util.List;


public abstract class NationLocalServiceBaseImpl implements NationLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.NationLocalService.impl")
    protected NationLocalService nationLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.NationService.impl")
    protected NationService nationService;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.persistence.NationPersistence.impl")
    protected NationPersistence nationPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.persistence.NationFinder.impl")
    protected NationFinder nationFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryLocalService.impl")
    protected CountryLocalService countryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryService.impl")
    protected CountryService countryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryPersistence.impl")
    protected CountryPersistence countryPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryFinder.impl")
    protected CountryFinder countryFinder;

    public Nation addNation(Nation nation) throws SystemException {
        nation.setNew(true);

        return nationPersistence.update(nation, false);
    }

    public Nation createNation(String nationId) {
        return nationPersistence.create(nationId);
    }

    public void deleteNation(String nationId)
        throws PortalException, SystemException {
        nationPersistence.remove(nationId);
    }

    public void deleteNation(Nation nation) throws SystemException {
        nationPersistence.remove(nation);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return nationPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return nationPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Nation getNation(String nationId)
        throws PortalException, SystemException {
        return nationPersistence.findByPrimaryKey(nationId);
    }

    public List<Nation> getNations(int start, int end)
        throws SystemException {
        return nationPersistence.findAll(start, end);
    }

    public int getNationsCount() throws SystemException {
        return nationPersistence.countAll();
    }

    public Nation updateNation(Nation nation) throws SystemException {
        nation.setNew(false);

        return nationPersistence.update(nation, true);
    }

    public NationLocalService getNationLocalService() {
        return nationLocalService;
    }

    public void setNationLocalService(NationLocalService nationLocalService) {
        this.nationLocalService = nationLocalService;
    }

    public NationService getNationService() {
        return nationService;
    }

    public void setNationService(NationService nationService) {
        this.nationService = nationService;
    }

    public NationPersistence getNationPersistence() {
        return nationPersistence;
    }

    public void setNationPersistence(NationPersistence nationPersistence) {
        this.nationPersistence = nationPersistence;
    }

    public NationFinder getNationFinder() {
        return nationFinder;
    }

    public void setNationFinder(NationFinder nationFinder) {
        this.nationFinder = nationFinder;
    }

    public CountryLocalService getCountryLocalService() {
        return countryLocalService;
    }

    public void setCountryLocalService(CountryLocalService countryLocalService) {
        this.countryLocalService = countryLocalService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public CountryPersistence getCountryPersistence() {
        return countryPersistence;
    }

    public void setCountryPersistence(CountryPersistence countryPersistence) {
        this.countryPersistence = countryPersistence;
    }

    public CountryFinder getCountryFinder() {
        return countryFinder;
    }

    public void setCountryFinder(CountryFinder countryFinder) {
        this.countryFinder = countryFinder;
    }
}
