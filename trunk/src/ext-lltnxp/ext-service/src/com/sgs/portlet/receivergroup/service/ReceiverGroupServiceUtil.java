package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverGroupServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupService
 *
 */
public class ReceiverGroupServiceUtil {
    private static ReceiverGroupService _service;

    public static void addReceiverToGroup(long groupPK, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService()
            .addReceiverToGroup(groupPK, receiverUserId, receiverUserName,
            receiverType);
    }

    public static void deleteReceiverGroup(long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService().deleteReceiverGroup(receiverGroupId);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        int type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getReceiverGroups(type);
    }

    public static void removeReceiverFromGroup(long receiverGroupId,
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService()
            .removeReceiverFromGroup(receiverGroupId, receiverUserId,
            receiverUserName, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        long receiverGroupId, java.lang.String receiverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .updateReceiverGroup(receiverGroupId, receiverGroupName,
            description, type, active);
    }

    public static ReceiverGroupService getService() {
        if (_service == null) {
            throw new RuntimeException("ReceiverGroupService is not set");
        }

        return _service;
    }

    public void setService(ReceiverGroupService service) {
        _service = service;
    }
}
