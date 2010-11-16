package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBBanServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBBanService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBBanService
 *
 */
public class MBBanServiceUtil {
    private static MBBanService _service;

    public static com.liferay.portlet.messageboards.model.MBBan addBan(
        long banUserId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addBan(banUserId, serviceContext);
    }

    public static void deleteBan(long banUserId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteBan(banUserId, serviceContext);
    }

    public static MBBanService getService() {
        if (_service == null) {
            throw new RuntimeException("MBBanService is not set");
        }

        return _service;
    }

    public void setService(MBBanService service) {
        _service = service;
    }
}
