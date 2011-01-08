package com.sgs.portlet.country.pmluserfiletype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlUserFileTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService</code>.
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
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalServiceUtil
 *
 */
public class PmlUserFileTypeLocalServiceFactory {
    private static final String _FACTORY = PmlUserFileTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlUserFileTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlUserFileTypeLocalService.class.getName() +
        ".transaction";
    private static PmlUserFileTypeLocalServiceFactory _factory;
    private static PmlUserFileTypeLocalService _impl;
    private static PmlUserFileTypeLocalService _txImpl;
    private PmlUserFileTypeLocalService _service;

    /**
     * @deprecated
     */
    public static PmlUserFileTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlUserFileTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlUserFileTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlUserFileTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlUserFileTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlUserFileTypeLocalService service) {
        _service = service;
    }

    private static PmlUserFileTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlUserFileTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
