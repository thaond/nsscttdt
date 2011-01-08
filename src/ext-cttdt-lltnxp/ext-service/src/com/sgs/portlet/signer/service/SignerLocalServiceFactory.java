package com.sgs.portlet.signer.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SignerLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.signer.service.SignerLocalService</code>.
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
 * @see com.sgs.portlet.signer.service.SignerLocalService
 * @see com.sgs.portlet.signer.service.SignerLocalServiceUtil
 *
 */
public class SignerLocalServiceFactory {
    private static final String _FACTORY = SignerLocalServiceFactory.class.getName();
    private static final String _IMPL = SignerLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SignerLocalService.class.getName() +
        ".transaction";
    private static SignerLocalServiceFactory _factory;
    private static SignerLocalService _impl;
    private static SignerLocalService _txImpl;
    private SignerLocalService _service;

    /**
     * @deprecated
     */
    public static SignerLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SignerLocalService getImpl() {
        if (_impl == null) {
            _impl = (SignerLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SignerLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SignerLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SignerLocalService service) {
        _service = service;
    }

    private static SignerLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SignerLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
