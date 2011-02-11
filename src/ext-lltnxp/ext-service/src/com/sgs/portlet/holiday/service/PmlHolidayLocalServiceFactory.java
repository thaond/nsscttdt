package com.sgs.portlet.holiday.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlHolidayLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.holiday.service.PmlHolidayLocalService</code>.
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
 * @see com.sgs.portlet.holiday.service.PmlHolidayLocalService
 * @see com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil
 *
 */
public class PmlHolidayLocalServiceFactory {
    private static final String _FACTORY = PmlHolidayLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlHolidayLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlHolidayLocalService.class.getName() +
        ".transaction";
    private static PmlHolidayLocalServiceFactory _factory;
    private static PmlHolidayLocalService _impl;
    private static PmlHolidayLocalService _txImpl;
    private PmlHolidayLocalService _service;

    /**
     * @deprecated
     */
    public static PmlHolidayLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlHolidayLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlHolidayLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlHolidayLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlHolidayLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlHolidayLocalService service) {
        _service = service;
    }

    private static PmlHolidayLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlHolidayLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
