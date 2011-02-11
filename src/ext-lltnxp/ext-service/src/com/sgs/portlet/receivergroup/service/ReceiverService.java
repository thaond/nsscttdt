package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.receivergroup.service.impl.ReceiverServiceImpl</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverServiceUtil
 *
 */
public interface ReceiverService {
    public com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long receiverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
