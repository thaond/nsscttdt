package com.sgs.portlet.filetype.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.filetype.service.PmlFileTypeLocalService;
import com.sgs.portlet.filetype.service.PmlFileTypeService;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeFinder;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypePersistence;


public abstract class PmlFileTypeServiceBaseImpl extends PrincipalBean
    implements PmlFileTypeService {
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.PmlFileTypeLocalService.impl")
    protected PmlFileTypeLocalService pmlFileTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.PmlFileTypeService.impl")
    protected PmlFileTypeService pmlFileTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected PmlFileTypePersistence pmlFileTypePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.persistence.PmlFileTypeFinder.impl")
    protected PmlFileTypeFinder pmlFileTypeFinder;

    public PmlFileTypeLocalService getPmlFileTypeLocalService() {
        return pmlFileTypeLocalService;
    }

    public void setPmlFileTypeLocalService(
        PmlFileTypeLocalService pmlFileTypeLocalService) {
        this.pmlFileTypeLocalService = pmlFileTypeLocalService;
    }

    public PmlFileTypeService getPmlFileTypeService() {
        return pmlFileTypeService;
    }

    public void setPmlFileTypeService(PmlFileTypeService pmlFileTypeService) {
        this.pmlFileTypeService = pmlFileTypeService;
    }

    public PmlFileTypePersistence getPmlFileTypePersistence() {
        return pmlFileTypePersistence;
    }

    public void setPmlFileTypePersistence(
        PmlFileTypePersistence pmlFileTypePersistence) {
        this.pmlFileTypePersistence = pmlFileTypePersistence;
    }

    public PmlFileTypeFinder getPmlFileTypeFinder() {
        return pmlFileTypeFinder;
    }

    public void setPmlFileTypeFinder(PmlFileTypeFinder pmlFileTypeFinder) {
        this.pmlFileTypeFinder = pmlFileTypeFinder;
    }
}
