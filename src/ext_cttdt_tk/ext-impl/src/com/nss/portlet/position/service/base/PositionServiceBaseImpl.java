package com.nss.portlet.position.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.position.service.PositionLocalService;
import com.nss.portlet.position.service.PositionService;
import com.nss.portlet.position.service.persistence.PositionFinder;
import com.nss.portlet.position.service.persistence.PositionPersistence;


public abstract class PositionServiceBaseImpl extends PrincipalBean
    implements PositionService {
    @BeanReference(name = "com.nss.portlet.position.service.PositionLocalService.impl")
    protected PositionLocalService positionLocalService;
    @BeanReference(name = "com.nss.portlet.position.service.PositionService.impl")
    protected PositionService positionService;
    @BeanReference(name = "com.nss.portlet.position.service.persistence.PositionPersistence.impl")
    protected PositionPersistence positionPersistence;
    @BeanReference(name = "com.nss.portlet.position.service.persistence.PositionFinder.impl")
    protected PositionFinder positionFinder;

    public PositionLocalService getPositionLocalService() {
        return positionLocalService;
    }

    public void setPositionLocalService(
        PositionLocalService positionLocalService) {
        this.positionLocalService = positionLocalService;
    }

    public PositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    public PositionPersistence getPositionPersistence() {
        return positionPersistence;
    }

    public void setPositionPersistence(PositionPersistence positionPersistence) {
        this.positionPersistence = positionPersistence;
    }

    public PositionFinder getPositionFinder() {
        return positionFinder;
    }

    public void setPositionFinder(PositionFinder positionFinder) {
        this.positionFinder = positionFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
