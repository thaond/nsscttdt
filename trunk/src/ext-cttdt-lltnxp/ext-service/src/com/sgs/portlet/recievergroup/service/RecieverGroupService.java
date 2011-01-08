package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverGroupService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.recievergroup.service.impl.RecieverGroupServiceImpl</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil
 *
 */
public interface RecieverGroupService {
    public void addRecieverToGroup(long groupPK, long recieverUserId,
        java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteRecieverGroup(long recieverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        int type)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removeRecieverFromGroup(long recieverGroupId,
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        long recieverGroupId, java.lang.String recieverGroupName,
        java.lang.String description, int type, boolean active)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
