package com.sgs.portlet.holiday_calendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="HolidayCalendarServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday_calendar.service.HolidayCalendarService</code>.
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
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarService
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarServiceUtil
 *
 */
public class HolidayCalendarServiceFactory {
    private static final String _FACTORY = HolidayCalendarServiceFactory.class.getName();
    private static final String _IMPL = HolidayCalendarService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = HolidayCalendarService.class.getName() +
        ".transaction";
    private static HolidayCalendarServiceFactory _factory;
    private static HolidayCalendarService _impl;
    private static HolidayCalendarService _txImpl;
    private HolidayCalendarService _service;

    /**
     * @deprecated
     */
    public static HolidayCalendarService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static HolidayCalendarService getImpl() {
        if (_impl == null) {
            _impl = (HolidayCalendarService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static HolidayCalendarService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (HolidayCalendarService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(HolidayCalendarService service) {
        _service = service;
    }

    private static HolidayCalendarServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (HolidayCalendarServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
