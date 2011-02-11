package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingCalComponentLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil
 *
 */
public class MeetingCalComponentLocalServiceFactory {
    private static final String _FACTORY = MeetingCalComponentLocalServiceFactory.class.getName();
    private static final String _IMPL = MeetingCalComponentLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingCalComponentLocalService.class.getName() +
        ".transaction";
    private static MeetingCalComponentLocalServiceFactory _factory;
    private static MeetingCalComponentLocalService _impl;
    private static MeetingCalComponentLocalService _txImpl;
    private MeetingCalComponentLocalService _service;

    /**
     * @deprecated
     */
    public static MeetingCalComponentLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingCalComponentLocalService getImpl() {
        if (_impl == null) {
            _impl = (MeetingCalComponentLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingCalComponentLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingCalComponentLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingCalComponentLocalService service) {
        _service = service;
    }

    private static MeetingCalComponentLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingCalComponentLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
