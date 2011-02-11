package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.ReceiverService
 *
 */
public class ReceiverServiceUtil {
    private static ReceiverService _service;

    public static com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .addReceiver(receiverUserId, receiverUserName, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .getReceiver(receiverUserId, receiverUserName, receiverType);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getReceivers(receiverGroupId);
    }

    public static ReceiverService getService() {
        if (_service == null) {
            throw new RuntimeException("ReceiverService is not set");
        }

        return _service;
    }

    public void setService(ReceiverService service) {
        _service = service;
    }
}
