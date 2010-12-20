package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBThreadServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBThreadService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBThreadService
 *
 */
public class MBThreadServiceUtil {
    private static MBThreadService _service;

    public static void deleteThread(long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThread(threadId);
    }

    public static com.liferay.portlet.messageboards.model.MBThread moveThread(
        long categoryId, long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().moveThread(categoryId, threadId);
    }

    public static com.liferay.portlet.messageboards.model.MBThread splitThread(
        long messageId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().splitThread(messageId, serviceContext);
    }

    public static MBThreadService getService() {
        if (_service == null) {
            throw new RuntimeException("MBThreadService is not set");
        }

        return _service;
    }

    public void setService(MBThreadService service) {
        _service = service;
    }
}
