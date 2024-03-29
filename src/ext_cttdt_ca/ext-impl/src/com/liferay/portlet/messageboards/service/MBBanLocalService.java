package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBBanLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBBanLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBBanLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBBanLocalService {
    public com.liferay.portlet.messageboards.model.MBBan addMBBan(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan createMBBan(long banId);

    public void deleteMBBan(long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBBan(com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBBan getMBBan(long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> getMBBans(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBBansCount() throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan updateMBBan(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan updateMBBan(
        com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan addBan(long userId,
        long banUserId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkBan(long groupId, long banUserId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteBan(long banUserId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.SystemException;

    public void deleteBansByBanUserId(long banUserId)
        throws com.liferay.portal.SystemException;

    public void deleteBansByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void expireBans() throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> getBans(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getBansCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasBan(long groupId, long banUserId)
        throws com.liferay.portal.SystemException;
}
