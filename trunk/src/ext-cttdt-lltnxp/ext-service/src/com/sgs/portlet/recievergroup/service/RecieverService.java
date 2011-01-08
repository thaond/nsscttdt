package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.recievergroup.service.impl.RecieverServiceImpl</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverServiceUtil
 *
 */
public interface RecieverService {
    public com.sgs.portlet.recievergroup.model.Reciever addReciever(
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long recieverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
