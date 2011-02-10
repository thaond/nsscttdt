package com.sgs.portlet.country.pmluserfiletype.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService;
import com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService;
import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePersistence;


public abstract class PmlUserFileTypeServiceBaseImpl extends PrincipalBean
    implements PmlUserFileTypeService {
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService.impl")
    protected PmlUserFileTypeLocalService pmlUserFileTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService.impl")
    protected PmlUserFileTypeService pmlUserFileTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePersistence.impl")
    protected PmlUserFileTypePersistence pmlUserFileTypePersistence;

    public PmlUserFileTypeLocalService getPmlUserFileTypeLocalService() {
        return pmlUserFileTypeLocalService;
    }

    public void setPmlUserFileTypeLocalService(
        PmlUserFileTypeLocalService pmlUserFileTypeLocalService) {
        this.pmlUserFileTypeLocalService = pmlUserFileTypeLocalService;
    }

    public PmlUserFileTypeService getPmlUserFileTypeService() {
        return pmlUserFileTypeService;
    }

    public void setPmlUserFileTypeService(
        PmlUserFileTypeService pmlUserFileTypeService) {
        this.pmlUserFileTypeService = pmlUserFileTypeService;
    }

    public PmlUserFileTypePersistence getPmlUserFileTypePersistence() {
        return pmlUserFileTypePersistence;
    }

    public void setPmlUserFileTypePersistence(
        PmlUserFileTypePersistence pmlUserFileTypePersistence) {
        this.pmlUserFileTypePersistence = pmlUserFileTypePersistence;
    }
}
