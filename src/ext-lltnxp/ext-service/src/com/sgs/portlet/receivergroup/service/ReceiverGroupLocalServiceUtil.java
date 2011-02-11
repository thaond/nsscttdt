package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverGroupLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService
 *
 */
public class ReceiverGroupLocalServiceUtil {
    private static ReceiverGroupLocalService _service;

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup addReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        return getService().addReceiverGroup(receiverGroup);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup createReceiverGroup(
        long receiverGroupId) {
        return getService().createReceiverGroup(receiverGroupId);
    }

    public static void deleteReceiverGroup(long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteReceiverGroup(receiverGroupId);
    }

    public static void deleteReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        getService().deleteReceiverGroup(receiverGroup);
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

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup getReceiverGroup(
        long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getReceiverGroup(receiverGroupId);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getReceiverGroups(start, end);
    }

    public static int getReceiverGroupsCount()
        throws com.liferay.portal.SystemException {
        return getService().getReceiverGroupsCount();
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        return getService().updateReceiverGroup(receiverGroup);
    }

    public static void addReceiver(long receiverGroupPK, long receiverPK)
        throws com.liferay.portal.SystemException {
        getService().addReceiver(receiverGroupPK, receiverPK);
    }

    public static void removeReceiver(long receiverGroupPK, long receiverPK)
        throws com.liferay.portal.SystemException {
        getService().removeReceiver(receiverGroupPK, receiverPK);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        long userId, long receiverGroupId, java.lang.String receiverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateReceiverGroup(userId, receiverGroupId,
            receiverGroupName, description, type, active);
    }

    public static ReceiverGroupLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ReceiverGroupLocalService is not set");
        }

        return _service;
    }

    public void setService(ReceiverGroupLocalService service) {
        _service = service;
    }
}
