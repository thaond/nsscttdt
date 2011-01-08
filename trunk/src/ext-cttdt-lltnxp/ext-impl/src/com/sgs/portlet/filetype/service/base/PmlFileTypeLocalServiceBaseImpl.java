package com.sgs.portlet.filetype.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalService;
import com.sgs.portlet.filetype.service.PmlFileTypeService;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeFinder;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypePersistence;

import java.util.List;


public abstract class PmlFileTypeLocalServiceBaseImpl
    implements PmlFileTypeLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.PmlFileTypeLocalService.impl")
    protected PmlFileTypeLocalService pmlFileTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.PmlFileTypeService.impl")
    protected PmlFileTypeService pmlFileTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected PmlFileTypePersistence pmlFileTypePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.filetype.service.persistence.PmlFileTypeFinder.impl")
    protected PmlFileTypeFinder pmlFileTypeFinder;

    public PmlFileType addPmlFileType(PmlFileType pmlFileType)
        throws SystemException {
        pmlFileType.setNew(true);

        return pmlFileTypePersistence.update(pmlFileType, false);
    }

    public PmlFileType createPmlFileType(String fileTypeId) {
        return pmlFileTypePersistence.create(fileTypeId);
    }

    public void deletePmlFileType(String fileTypeId)
        throws PortalException, SystemException {
        pmlFileTypePersistence.remove(fileTypeId);
    }

    public void deletePmlFileType(PmlFileType pmlFileType)
        throws SystemException {
        pmlFileTypePersistence.remove(pmlFileType);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlFileTypePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlFileTypePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlFileType getPmlFileType(String fileTypeId)
        throws PortalException, SystemException {
        return pmlFileTypePersistence.findByPrimaryKey(fileTypeId);
    }

    public List<PmlFileType> getPmlFileTypes(int start, int end)
        throws SystemException {
        return pmlFileTypePersistence.findAll(start, end);
    }

    public int getPmlFileTypesCount() throws SystemException {
        return pmlFileTypePersistence.countAll();
    }

    public PmlFileType updatePmlFileType(PmlFileType pmlFileType)
        throws SystemException {
        pmlFileType.setNew(false);

        return pmlFileTypePersistence.update(pmlFileType, true);
    }

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
