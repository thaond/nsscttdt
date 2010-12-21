package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBMessageFlagServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBMessageFlagService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBMessageFlagService
 *
 */
public class MBMessageFlagServiceUtil {
    private static MBMessageFlagService _service;

    public static void addAnswerFlag(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().addAnswerFlag(messageId);
    }

    public static void deleteAnswerFlag(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteAnswerFlag(messageId);
    }

    public static MBMessageFlagService getService() {
        if (_service == null) {
            throw new RuntimeException("MBMessageFlagService is not set");
        }

        return _service;
    }

    public void setService(MBMessageFlagService service) {
        _service = service;
    }
}
