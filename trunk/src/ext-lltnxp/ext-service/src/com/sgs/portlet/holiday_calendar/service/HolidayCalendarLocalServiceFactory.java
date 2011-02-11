package com.sgs.portlet.holiday_calendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="HolidayCalendarLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService</code>.
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
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil
 *
 */
public class HolidayCalendarLocalServiceFactory {
    private static final String _FACTORY = HolidayCalendarLocalServiceFactory.class.getName();
    private static final String _IMPL = HolidayCalendarLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = HolidayCalendarLocalService.class.getName() +
        ".transaction";
    private static HolidayCalendarLocalServiceFactory _factory;
    private static HolidayCalendarLocalService _impl;
    private static HolidayCalendarLocalService _txImpl;
    private HolidayCalendarLocalService _service;

    /**
     * @deprecated
     */
    public static HolidayCalendarLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static HolidayCalendarLocalService getImpl() {
        if (_impl == null) {
            _impl = (HolidayCalendarLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static HolidayCalendarLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (HolidayCalendarLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(HolidayCalendarLocalService service) {
        _service = service;
    }

    private static HolidayCalendarLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (HolidayCalendarLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
