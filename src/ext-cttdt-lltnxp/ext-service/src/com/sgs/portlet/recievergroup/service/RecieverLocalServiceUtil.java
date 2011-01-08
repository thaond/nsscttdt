package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.RecieverLocalService
 *
 */
public class RecieverLocalServiceUtil {
    private static RecieverLocalService _service;

    public static com.sgs.portlet.recievergroup.model.Reciever addReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        return getService().addReciever(reciever);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever createReciever(
        long recieverId) {
        return getService().createReciever(recieverId);
    }

    public static void deleteReciever(long recieverId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteReciever(recieverId);
    }

    public static void deleteReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        getService().deleteReciever(reciever);
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

    public static com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long recieverId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getReciever(recieverId);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getRecievers(start, end);
    }

    public static int getRecieversCount()
        throws com.liferay.portal.SystemException {
        return getService().getRecieversCount();
    }

    public static com.sgs.portlet.recievergroup.model.Reciever updateReciever(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        return getService().updateReciever(reciever);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever addReciever(
        long userId, long recieverUserId, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addReciever(userId, recieverUserId, recieverUserName,
            recieverType);
    }

    public static java.util.List<com.liferay.portal.model.User> findUsersByFullname_ScreenName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getService().findUsersByFullname_ScreenName(companyId, name);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever getReciever(
        long userId, long recieverUserId, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getReciever(userId, recieverUserId, recieverUserName,
            recieverType);
    }

    public static RecieverLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("RecieverLocalService is not set");
        }

        return _service;
    }

    public void setService(RecieverLocalService service) {
        _service = service;
    }
}
