package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverGroupServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupService
 *
 */
public class RecieverGroupServiceUtil {
    private static RecieverGroupService _service;

    public static void addRecieverToGroup(long groupPK, long recieverUserId,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService()
            .addRecieverToGroup(groupPK, recieverUserId, recieverUserName,
            recieverType);
    }

    public static void deleteRecieverGroup(long recieverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService().deleteRecieverGroup(recieverGroupId);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        int type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getRecieverGroups(type);
    }

    public static void removeRecieverFromGroup(long recieverGroupId,
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService()
            .removeRecieverFromGroup(recieverGroupId, recieverUserId,
            recieverUserName, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        long recieverGroupId, java.lang.String recieverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .updateRecieverGroup(recieverGroupId, recieverGroupName,
            description, type, active);
    }

    public static RecieverGroupService getService() {
        if (_service == null) {
            throw new RuntimeException("RecieverGroupService is not set");
        }

        return _service;
    }

    public void setService(RecieverGroupService service) {
        _service = service;
    }
}
