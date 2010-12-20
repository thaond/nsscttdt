package com.nss.portlet.permissonuserbyfile.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalService;
import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeService;
import com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence;


public abstract class PmlUserFileTypeServiceBaseImpl extends PrincipalBean
    implements PmlUserFileTypeService {
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalService.impl")
    protected PmlUserFileTypeLocalService pmlUserFileTypeLocalService;
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeService.impl")
    protected PmlUserFileTypeService pmlUserFileTypeService;
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence.impl")
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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
