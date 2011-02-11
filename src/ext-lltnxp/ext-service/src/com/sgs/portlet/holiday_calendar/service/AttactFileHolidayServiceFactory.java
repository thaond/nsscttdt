package com.sgs.portlet.holiday_calendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AttactFileHolidayServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService</code>.
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
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayServiceUtil
 *
 */
public class AttactFileHolidayServiceFactory {
    private static final String _FACTORY = AttactFileHolidayServiceFactory.class.getName();
    private static final String _IMPL = AttactFileHolidayService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AttactFileHolidayService.class.getName() +
        ".transaction";
    private static AttactFileHolidayServiceFactory _factory;
    private static AttactFileHolidayService _impl;
    private static AttactFileHolidayService _txImpl;
    private AttactFileHolidayService _service;

    /**
     * @deprecated
     */
    public static AttactFileHolidayService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AttactFileHolidayService getImpl() {
        if (_impl == null) {
            _impl = (AttactFileHolidayService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AttactFileHolidayService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AttactFileHolidayService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AttactFileHolidayService service) {
        _service = service;
    }

    private static AttactFileHolidayServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AttactFileHolidayServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
