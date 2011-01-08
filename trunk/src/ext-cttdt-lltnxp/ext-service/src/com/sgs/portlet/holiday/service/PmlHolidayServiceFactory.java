package com.sgs.portlet.holiday.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlHolidayServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday.service.PmlHolidayService</code>.
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
 * @see com.sgs.portlet.holiday.service.PmlHolidayService
 * @see com.sgs.portlet.holiday.service.PmlHolidayServiceUtil
 *
 */
public class PmlHolidayServiceFactory {
    private static final String _FACTORY = PmlHolidayServiceFactory.class.getName();
    private static final String _IMPL = PmlHolidayService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlHolidayService.class.getName() +
        ".transaction";
    private static PmlHolidayServiceFactory _factory;
    private static PmlHolidayService _impl;
    private static PmlHolidayService _txImpl;
    private PmlHolidayService _service;

    /**
     * @deprecated
     */
    public static PmlHolidayService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlHolidayService getImpl() {
        if (_impl == null) {
            _impl = (PmlHolidayService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlHolidayService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlHolidayService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlHolidayService service) {
        _service = service;
    }

    private static PmlHolidayServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlHolidayServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
