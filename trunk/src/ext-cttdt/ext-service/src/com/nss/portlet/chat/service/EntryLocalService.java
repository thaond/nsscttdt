package com.nss.portlet.chat.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="EntryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.chat.service.impl.EntryLocalServiceImpl</code>.
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
 * @see com.nss.portlet.chat.service.EntryLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface EntryLocalService {
    public com.nss.portlet.chat.model.Entry addEntry(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry createEntry(long entryId);

    public void deleteEntry(long entryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteEntry(com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.chat.model.Entry getEntry(long entryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.chat.model.Entry> getEntries(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getEntriesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry updateEntry(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry updateEntry(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry addEntry(long fromUserId,
        long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry addEntry(long createDate,
        long fromUserId, long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException;

    public void deleteEntries(long userId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.chat.model.Entry> getNewEntries(
        long userId, long createDate, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.chat.model.Entry> getOldEntries(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException;
}
