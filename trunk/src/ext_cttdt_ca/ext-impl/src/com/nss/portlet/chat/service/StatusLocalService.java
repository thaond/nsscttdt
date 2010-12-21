package com.nss.portlet.chat.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="StatusLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.chat.service.impl.StatusLocalServiceImpl</code>.
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
 * @see com.nss.portlet.chat.service.StatusLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface StatusLocalService {
    public com.nss.portlet.chat.model.Status addStatus(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status createStatus(long statusId);

    public void deleteStatus(long statusId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteStatus(com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.chat.model.Status getStatus(long statusId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.chat.model.Status> getStatuses(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStatusesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status updateStatus(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status updateStatus(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<Object[]> getAllStatuses(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<Object[]> getGroupStatuses(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<Object[]> getSocialStatuses(long userId, int type,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.chat.model.Status getUserStatus(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status updateStatus(long userId,
        long modifiedDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status updateStatus(long userId,
        long modifiedDate, int online, int awake,
        java.lang.String activePanelId, java.lang.String message, int playSound)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
