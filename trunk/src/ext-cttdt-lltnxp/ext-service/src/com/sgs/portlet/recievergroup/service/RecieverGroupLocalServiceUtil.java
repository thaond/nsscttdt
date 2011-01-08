package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverGroupLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupLocalService
 *
 */
public class RecieverGroupLocalServiceUtil {
    private static RecieverGroupLocalService _service;

    public static com.sgs.portlet.recievergroup.model.RecieverGroup addRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        return getService().addRecieverGroup(recieverGroup);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup createRecieverGroup(
        long recieverGroupId) {
        return getService().createRecieverGroup(recieverGroupId);
    }

    public static void deleteRecieverGroup(long recieverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteRecieverGroup(recieverGroupId);
    }

    public static void deleteRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        getService().deleteRecieverGroup(recieverGroup);
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

    public static com.sgs.portlet.recievergroup.model.RecieverGroup getRecieverGroup(
        long recieverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getRecieverGroup(recieverGroupId);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getRecieverGroups(start, end);
    }

    public static int getRecieverGroupsCount()
        throws com.liferay.portal.SystemException {
        return getService().getRecieverGroupsCount();
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        return getService().updateRecieverGroup(recieverGroup);
    }

    public static void addReciever(long recieverGroupPK, long recieverPK)
        throws com.liferay.portal.SystemException {
        getService().addReciever(recieverGroupPK, recieverPK);
    }

    public static void removeReciever(long recieverGroupPK, long recieverPK)
        throws com.liferay.portal.SystemException {
        getService().removeReciever(recieverGroupPK, recieverPK);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        long userId, long recieverGroupId, java.lang.String recieverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateRecieverGroup(userId, recieverGroupId,
            recieverGroupName, description, type, active);
    }

    public static RecieverGroupLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("RecieverGroupLocalService is not set");
        }

        return _service;
    }

    public void setService(RecieverGroupLocalService service) {
        _service = service;
    }
}
