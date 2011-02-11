package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverGroupService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.receivergroup.service.impl.ReceiverGroupServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil
 *
 */
public interface ReceiverGroupService {
    public void addReceiverToGroup(long groupPK, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteReceiverGroup(long receiverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        int type)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removeReceiverFromGroup(long receiverGroupId,
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        long receiverGroupId, java.lang.String receiverGroupName,
        java.lang.String description, int type, boolean active)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
