package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingDetailWeekLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService</code>.
 * Spring manages the lookup and lifecycle of the beans. This means you can
 * modify the Spring configuration files to return a different implementation or
 * to inject additional behavior.
 * </p>
 *
 * <p>
 * See the <code>spring.configs</code> property in portal.properties for
 * additional information on how to customize the Spring XML files.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil
 *
 */
public class MeetingDetailWeekLocalServiceFactory {
    private static final String _FACTORY = MeetingDetailWeekLocalServiceFactory.class.getName();
    private static final String _IMPL = MeetingDetailWeekLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingDetailWeekLocalService.class.getName() +
        ".transaction";
    private static MeetingDetailWeekLocalServiceFactory _factory;
    private static MeetingDetailWeekLocalService _impl;
    private static MeetingDetailWeekLocalService _txImpl;
    private MeetingDetailWeekLocalService _service;

    /**
     * @deprecated
     */
    public static MeetingDetailWeekLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingDetailWeekLocalService getImpl() {
        if (_impl == null) {
            _impl = (MeetingDetailWeekLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingDetailWeekLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingDetailWeekLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingDetailWeekLocalService service) {
        _service = service;
    }

    private static MeetingDetailWeekLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingDetailWeekLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
