package com.sgs.portlet.country.pmluserfiletype.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType;
import com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService;
import com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService;
import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK;
import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePersistence;

import java.util.List;


public abstract class PmlUserFileTypeLocalServiceBaseImpl
    implements PmlUserFileTypeLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService.impl")
    protected PmlUserFileTypeLocalService pmlUserFileTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService.impl")
    protected PmlUserFileTypeService pmlUserFileTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePersistence.impl")
    protected PmlUserFileTypePersistence pmlUserFileTypePersistence;

    public PmlUserFileType addPmlUserFileType(PmlUserFileType pmlUserFileType)
        throws SystemException {
        pmlUserFileType.setNew(true);

        return pmlUserFileTypePersistence.update(pmlUserFileType, false);
    }

    public PmlUserFileType createPmlUserFileType(
        PmlUserFileTypePK pmlUserFileTypePK) {
        return pmlUserFileTypePersistence.create(pmlUserFileTypePK);
    }

    public void deletePmlUserFileType(PmlUserFileTypePK pmlUserFileTypePK)
        throws PortalException, SystemException {
        pmlUserFileTypePersistence.remove(pmlUserFileTypePK);
    }

    public void deletePmlUserFileType(PmlUserFileType pmlUserFileType)
        throws SystemException {
        pmlUserFileTypePersistence.remove(pmlUserFileType);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlUserFileTypePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlUserFileTypePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlUserFileType getPmlUserFileType(
        PmlUserFileTypePK pmlUserFileTypePK)
        throws PortalException, SystemException {
        return pmlUserFileTypePersistence.findByPrimaryKey(pmlUserFileTypePK);
    }

    public List<PmlUserFileType> getPmlUserFileTypes(int start, int end)
        throws SystemException {
        return pmlUserFileTypePersistence.findAll(start, end);
    }

    public int getPmlUserFileTypesCount() throws SystemException {
        return pmlUserFileTypePersistence.countAll();
    }

    public PmlUserFileType updatePmlUserFileType(
        PmlUserFileType pmlUserFileType) throws SystemException {
        pmlUserFileType.setNew(false);

        return pmlUserFileTypePersistence.update(pmlUserFileType, true);
    }

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
