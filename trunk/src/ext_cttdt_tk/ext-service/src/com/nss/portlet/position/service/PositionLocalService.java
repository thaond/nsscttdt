package com.nss.portlet.position.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PositionLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.position.service.impl.PositionLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.service.PositionLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PositionLocalService {
    public com.nss.portlet.position.model.Position addPosition(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position createPosition(
        java.lang.String positionId);

    public void deletePosition(java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePosition(com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.position.model.Position getPosition(
        java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.position.model.Position> getPositions(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPositionsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position updatePosition(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position updatePosition(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> find_CODE_NAME_DESCRIPTION(
        java.lang.String code, java.lang.String name,
        java.lang.String description, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_CODE_NAME_DESCRIPTION(java.lang.String code,
        java.lang.String name, java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public void removePosition(java.lang.String positionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position addPosition(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position updatePosition(
        java.lang.String positionId, java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
