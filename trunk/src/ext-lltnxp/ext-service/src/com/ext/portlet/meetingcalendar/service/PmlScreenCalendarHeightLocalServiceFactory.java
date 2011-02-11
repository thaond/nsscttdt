package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlScreenCalendarHeightLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalServiceUtil
 *
 */
public class PmlScreenCalendarHeightLocalServiceFactory {
    private static final String _FACTORY = PmlScreenCalendarHeightLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlScreenCalendarHeightLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlScreenCalendarHeightLocalService.class.getName() +
        ".transaction";
    private static PmlScreenCalendarHeightLocalServiceFactory _factory;
    private static PmlScreenCalendarHeightLocalService _impl;
    private static PmlScreenCalendarHeightLocalService _txImpl;
    private PmlScreenCalendarHeightLocalService _service;

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlScreenCalendarHeightLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlScreenCalendarHeightLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlScreenCalendarHeightLocalService service) {
        _service = service;
    }

    private static PmlScreenCalendarHeightLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlScreenCalendarHeightLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
