package com.sgs.portlet.position.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalService;
import com.sgs.portlet.position.service.PositionService;
import com.sgs.portlet.position.service.persistence.PositionFinder;
import com.sgs.portlet.position.service.persistence.PositionPersistence;

import java.util.List;


public abstract class PositionLocalServiceBaseImpl
    implements PositionLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.PositionLocalService.impl")
    protected PositionLocalService positionLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.PositionService.impl")
    protected PositionService positionService;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.persistence.PositionPersistence.impl")
    protected PositionPersistence positionPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.persistence.PositionFinder.impl")
    protected PositionFinder positionFinder;

    public Position addPosition(Position position) throws SystemException {
        position.setNew(true);

        return positionPersistence.update(position, false);
    }

    public Position createPosition(String positionId) {
        return positionPersistence.create(positionId);
    }

    public void deletePosition(String positionId)
        throws PortalException, SystemException {
        positionPersistence.remove(positionId);
    }

    public void deletePosition(Position position) throws SystemException {
        positionPersistence.remove(position);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return positionPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return positionPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Position getPosition(String positionId)
        throws PortalException, SystemException {
        return positionPersistence.findByPrimaryKey(positionId);
    }

    public List<Position> getPositions(int start, int end)
        throws SystemException {
        return positionPersistence.findAll(start, end);
    }

    public int getPositionsCount() throws SystemException {
        return positionPersistence.countAll();
    }

    public Position updatePosition(Position position) throws SystemException {
        position.setNew(false);

        return positionPersistence.update(position, true);
    }

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
}
