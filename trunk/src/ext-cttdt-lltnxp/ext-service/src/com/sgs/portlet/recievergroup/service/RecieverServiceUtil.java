package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.RecieverService
 *
 */
public class RecieverServiceUtil {
    private static RecieverService _service;

    public static com.sgs.portlet.recievergroup.model.Reciever addReciever(
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .addReciever(recieverUserId, recieverUserName, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .getReciever(recieverUserId, recieverUserName, recieverType);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long recieverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getRecievers(recieverGroupId);
    }

    public static RecieverService getService() {
        if (_service == null) {
            throw new RuntimeException("RecieverService is not set");
        }

        return _service;
    }

    public void setService(RecieverService service) {
        _service = service;
    }
}
