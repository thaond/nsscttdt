package com.sgs.portlet.holiday_calendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AttactFileHolidayLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService</code>.
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
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalServiceUtil
 *
 */
public class AttactFileHolidayLocalServiceFactory {
    private static final String _FACTORY = AttactFileHolidayLocalServiceFactory.class.getName();
    private static final String _IMPL = AttactFileHolidayLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AttactFileHolidayLocalService.class.getName() +
        ".transaction";
    private static AttactFileHolidayLocalServiceFactory _factory;
    private static AttactFileHolidayLocalService _impl;
    private static AttactFileHolidayLocalService _txImpl;
    private AttactFileHolidayLocalService _service;

    /**
     * @deprecated
     */
    public static AttactFileHolidayLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AttactFileHolidayLocalService getImpl() {
        if (_impl == null) {
            _impl = (AttactFileHolidayLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AttactFileHolidayLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AttactFileHolidayLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AttactFileHolidayLocalService service) {
        _service = service;
    }

    private static AttactFileHolidayLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AttactFileHolidayLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
