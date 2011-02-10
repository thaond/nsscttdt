package com.sgs.portlet.onedoor.role.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.onedoor.role.service.PmlRoleLocalService;
import com.sgs.portlet.onedoor.role.service.PmlRoleService;
import com.sgs.portlet.onedoor.role.service.persistence.PmlRolePersistence;


public abstract class PmlRoleServiceBaseImpl extends PrincipalBean
    implements PmlRoleService {
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.PmlRoleLocalService.impl")
    protected PmlRoleLocalService pmlRoleLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.PmlRoleService.impl")
    protected PmlRoleService pmlRoleService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.persistence.PmlRolePersistence.impl")
    protected PmlRolePersistence pmlRolePersistence;

    public PmlRoleLocalService getPmlRoleLocalService() {
        return pmlRoleLocalService;
    }

    public void setPmlRoleLocalService(PmlRoleLocalService pmlRoleLocalService) {
        this.pmlRoleLocalService = pmlRoleLocalService;
    }

    public PmlRoleService getPmlRoleService() {
        return pmlRoleService;
    }

    public void setPmlRoleService(PmlRoleService pmlRoleService) {
        this.pmlRoleService = pmlRoleService;
    }

    public PmlRolePersistence getPmlRolePersistence() {
        return pmlRolePersistence;
    }

    public void setPmlRolePersistence(PmlRolePersistence pmlRolePersistence) {
        this.pmlRolePersistence = pmlRolePersistence;
    }
}
