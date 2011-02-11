package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.receivergroup.service.impl.ReceiverLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverLocalServiceUtil
 *
 */
public interface ReceiverLocalService {
    public com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver createReceiver(
        long receiverId);

    public void deleteReceiver(long receiverId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long receiverId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getReceiversCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver updateReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        long userId, long receiverUserId, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findUsersByFullname_ScreenName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long userId, long receiverUserId, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
