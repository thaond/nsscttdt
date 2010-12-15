package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBMessageFlagLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBMessageFlagLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBMessageFlagLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBMessageFlagLocalService {
    public com.liferay.portlet.messageboards.model.MBMessageFlag addMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag createMBMessageFlag(
        long messageFlagId);

    public void deleteMBMessageFlag(long messageFlagId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessageFlag getMBMessageFlag(
        long messageFlagId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> getMBMessageFlags(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBMessageFlagsCount()
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag,
        boolean merge) throws com.liferay.portal.SystemException;

    public void addReadFlags(long userId,
        com.liferay.portlet.messageboards.model.MBThread thread)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addQuestionFlag(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteFlags(long userId)
        throws com.liferay.portal.SystemException;

    public void deleteFlags(long messageId, int flag)
        throws com.liferay.portal.SystemException;

    public void deleteQuestionAndAnswerFlags(long threadId)
        throws com.liferay.portal.SystemException;

    public void deleteThreadFlags(long threadId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasAnswerFlag(long messageId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasQuestionFlag(long messageId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasReadFlag(long userId,
        com.liferay.portlet.messageboards.model.MBThread thread)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
