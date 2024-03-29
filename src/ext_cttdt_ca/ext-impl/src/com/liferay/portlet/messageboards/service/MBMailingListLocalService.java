package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBMailingListLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBMailingListLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBMailingListLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBMailingListLocalService {
    public com.liferay.portlet.messageboards.model.MBMailingList addMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList createMBMailingList(
        long mailingListId);

    public void deleteMBMailingList(long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMailingList getMBMailingList(
        long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> getMBMailingLists(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBMailingListsCount()
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList addMailingList(
        java.lang.String uuid, long userId, long categoryId,
        java.lang.String emailAddress, java.lang.String inProtocol,
        java.lang.String inServerName, int inServerPort, boolean inUseSSL,
        java.lang.String inUserName, java.lang.String inPassword,
        int inReadInterval, java.lang.String outEmailAddress,
        boolean outCustom, java.lang.String outServerName, int outServerPort,
        boolean outUseSSL, java.lang.String outUserName,
        java.lang.String outPassword, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteCategoryMailingList(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteMailingList(long mailingListId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mailingList)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMailingList getCategoryMailingList(
        long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList updateMailingList(
        long mailingListId, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
