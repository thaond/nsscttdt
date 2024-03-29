package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBMessageFlagLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBMessageFlagLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBMessageFlagLocalService
 *
 */
public class MBMessageFlagLocalServiceUtil {
    private static MBMessageFlagLocalService _service;

    public static com.liferay.portlet.messageboards.model.MBMessageFlag addMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException {
        return getService().addMBMessageFlag(mbMessageFlag);
    }

    public static com.liferay.portlet.messageboards.model.MBMessageFlag createMBMessageFlag(
        long messageFlagId) {
        return getService().createMBMessageFlag(messageFlagId);
    }

    public static void deleteMBMessageFlag(long messageFlagId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMBMessageFlag(messageFlagId);
    }

    public static void deleteMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException {
        getService().deleteMBMessageFlag(mbMessageFlag);
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

    public static com.liferay.portlet.messageboards.model.MBMessageFlag getMBMessageFlag(
        long messageFlagId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMBMessageFlag(messageFlagId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> getMBMessageFlags(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMBMessageFlags(start, end);
    }

    public static int getMBMessageFlagsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMBMessageFlagsCount();
    }

    public static com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException {
        return getService().updateMBMessageFlag(mbMessageFlag);
    }

    public static com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMBMessageFlag(mbMessageFlag, merge);
    }

    public static void addReadFlags(long userId,
        com.liferay.portlet.messageboards.model.MBThread thread)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().addReadFlags(userId, thread);
    }

    public static void addQuestionFlag(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().addQuestionFlag(messageId);
    }

    public static void deleteFlags(long userId)
        throws com.liferay.portal.SystemException {
        getService().deleteFlags(userId);
    }

    public static void deleteFlags(long messageId, int flag)
        throws com.liferay.portal.SystemException {
        getService().deleteFlags(messageId, flag);
    }

    public static void deleteQuestionAndAnswerFlags(long threadId)
        throws com.liferay.portal.SystemException {
        getService().deleteQuestionAndAnswerFlags(threadId);
    }

    public static void deleteThreadFlags(long threadId)
        throws com.liferay.portal.SystemException {
        getService().deleteThreadFlags(threadId);
    }

    public static boolean hasAnswerFlag(long messageId)
        throws com.liferay.portal.SystemException {
        return getService().hasAnswerFlag(messageId);
    }

    public static boolean hasQuestionFlag(long messageId)
        throws com.liferay.portal.SystemException {
        return getService().hasQuestionFlag(messageId);
    }

    public static boolean hasReadFlag(long userId,
        com.liferay.portlet.messageboards.model.MBThread thread)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().hasReadFlag(userId, thread);
    }

    public static MBMessageFlagLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MBMessageFlagLocalService is not set");
        }

        return _service;
    }

    public void setService(MBMessageFlagLocalService service) {
        _service = service;
    }
}
