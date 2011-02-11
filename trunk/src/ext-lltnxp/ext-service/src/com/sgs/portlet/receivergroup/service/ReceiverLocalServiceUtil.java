package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.ReceiverLocalService
 *
 */
public class ReceiverLocalServiceUtil {
    private static ReceiverLocalService _service;

    public static com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        return getService().addReceiver(receiver);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver createReceiver(
        long receiverId) {
        return getService().createReceiver(receiverId);
    }

    public static void deleteReceiver(long receiverId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteReceiver(receiverId);
    }

    public static void deleteReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        getService().deleteReceiver(receiver);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long receiverId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getReceiver(receiverId);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getReceivers(start, end);
    }

    public static int getReceiversCount()
        throws com.liferay.portal.SystemException {
        return getService().getReceiversCount();
    }

    public static com.sgs.portlet.receivergroup.model.Receiver updateReceiver(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        return getService().updateReceiver(receiver);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        long userId, long receiverUserId, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addReceiver(userId, receiverUserId, receiverUserName,
            receiverType);
    }

    public static java.util.List<com.liferay.portal.model.User> findUsersByFullname_ScreenName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getService().findUsersByFullname_ScreenName(companyId, name);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        long userId, long receiverUserId, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getReceiver(userId, receiverUserId, receiverUserName,
            receiverType);
    }

    public static ReceiverLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ReceiverLocalService is not set");
        }

        return _service;
    }

    public void setService(ReceiverLocalService service) {
        _service = service;
    }
}
