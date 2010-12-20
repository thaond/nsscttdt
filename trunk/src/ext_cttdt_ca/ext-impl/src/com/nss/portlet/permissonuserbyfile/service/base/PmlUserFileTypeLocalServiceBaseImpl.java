package com.nss.portlet.permissonuserbyfile.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;
import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalService;
import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeService;
import com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK;
import com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence;

import java.util.List;


public abstract class PmlUserFileTypeLocalServiceBaseImpl
    implements PmlUserFileTypeLocalService {
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalService.impl")
    protected PmlUserFileTypeLocalService pmlUserFileTypeLocalService;
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeService.impl")
    protected PmlUserFileTypeService pmlUserFileTypeService;
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence.impl")
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

    public PmlUserFileType updatePmlUserFileType(
        PmlUserFileType pmlUserFileType, boolean merge)
        throws SystemException {
        pmlUserFileType.setNew(false);

        return pmlUserFileTypePersistence.update(pmlUserFileType, merge);
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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
