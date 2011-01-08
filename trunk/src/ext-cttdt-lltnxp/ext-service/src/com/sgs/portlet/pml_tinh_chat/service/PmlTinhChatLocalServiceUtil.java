package com.sgs.portlet.pml_tinh_chat.service;


/**
 * <a href="PmlTinhChatLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService
 *
 */
public class PmlTinhChatLocalServiceUtil {
    private static PmlTinhChatLocalService _service;

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTinhChat(pmlTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat createPmlTinhChat(
        long idTinhChat) {
        return getService().createPmlTinhChat(idTinhChat);
    }

    public static void deletePmlTinhChat(long idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTinhChat(idTinhChat);
    }

    public static void deletePmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTinhChat(pmlTinhChat);
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

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat getPmlTinhChat(
        long idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTinhChat(idTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> getPmlTinhChats(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTinhChats(start, end);
    }

    public static int getPmlTinhChatsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTinhChatsCount();
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTinhChat(pmlTinhChat);
    }

    public static int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(andOperator, start, end, obc);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addPmlTinhChat(tenTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        long idTinhChat, java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updatePmlTinhChat(idTinhChat, tenTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static void removePmlTinhChat(java.lang.String idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlTinhChat(idTinhChat);
    }

    public static PmlTinhChatLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTinhChatLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTinhChatLocalService service) {
        _service = service;
    }
}
