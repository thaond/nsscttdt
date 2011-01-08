package com.sgs.portlet.onedoor.role.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.onedoor.role.model.PmlRole;
import com.sgs.portlet.onedoor.role.service.PmlRoleLocalService;
import com.sgs.portlet.onedoor.role.service.PmlRoleService;
import com.sgs.portlet.onedoor.role.service.persistence.PmlRolePersistence;

import java.util.List;


public abstract class PmlRoleLocalServiceBaseImpl implements PmlRoleLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.PmlRoleLocalService.impl")
    protected PmlRoleLocalService pmlRoleLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.PmlRoleService.impl")
    protected PmlRoleService pmlRoleService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.role.service.persistence.PmlRolePersistence.impl")
    protected PmlRolePersistence pmlRolePersistence;

    public PmlRole addPmlRole(PmlRole pmlRole) throws SystemException {
        pmlRole.setNew(true);

        return pmlRolePersistence.update(pmlRole, false);
    }

    public PmlRole createPmlRole(String roleId) {
        return pmlRolePersistence.create(roleId);
    }

    public void deletePmlRole(String roleId)
        throws PortalException, SystemException {
        pmlRolePersistence.remove(roleId);
    }

    public void deletePmlRole(PmlRole pmlRole) throws SystemException {
        pmlRolePersistence.remove(pmlRole);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlRolePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlRolePersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public PmlRole getPmlRole(String roleId)
        throws PortalException, SystemException {
        return pmlRolePersistence.findByPrimaryKey(roleId);
    }

    public List<PmlRole> getPmlRoles(int start, int end)
        throws SystemException {
        return pmlRolePersistence.findAll(start, end);
    }

    public int getPmlRolesCount() throws SystemException {
        return pmlRolePersistence.countAll();
    }

    public PmlRole updatePmlRole(PmlRole pmlRole) throws SystemException {
        pmlRole.setNew(false);

        return pmlRolePersistence.update(pmlRole, true);
    }

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
