package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBDiscussionLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBDiscussionLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBDiscussionLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBDiscussionLocalService {
    public com.liferay.portlet.messageboards.model.MBDiscussion addMBDiscussion(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion createMBDiscussion(
        long discussionId);

    public void deleteMBDiscussion(long discussionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBDiscussion(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBDiscussion getMBDiscussion(
        long discussionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> getMBDiscussions(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBDiscussionsCount()
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion updateMBDiscussion(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion updateMBDiscussion(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion addDiscussion(
        long classNameId, long classPK, long threadId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBDiscussion getDiscussion(
        long discussionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBDiscussion getDiscussion(
        java.lang.String className, long classPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBDiscussion getThreadDiscussion(
        long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
