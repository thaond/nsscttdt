package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.recievergroup.service.impl.RecieverLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverLocalServiceUtil
 *
 */
public interface RecieverLocalService {
    public com.sgs.portlet.recievergroup.model.Reciever addReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever createReciever(
        long recieverId);

    public void deleteReciever(long recieverId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long recieverId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getRecieversCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever updateReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever addReciever(
        long userId, long recieverUserId, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findUsersByFullname_ScreenName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long userId, long recieverUserId, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
