package com.sgs.portlet.signer.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SignerServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.signer.service.SignerService</code>.
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
 * @see com.sgs.portlet.signer.service.SignerService
 * @see com.sgs.portlet.signer.service.SignerServiceUtil
 *
 */
public class SignerServiceFactory {
    private static final String _FACTORY = SignerServiceFactory.class.getName();
    private static final String _IMPL = SignerService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SignerService.class.getName() +
        ".transaction";
    private static SignerServiceFactory _factory;
    private static SignerService _impl;
    private static SignerService _txImpl;
    private SignerService _service;

    /**
     * @deprecated
     */
    public static SignerService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SignerService getImpl() {
        if (_impl == null) {
            _impl = (SignerService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SignerService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SignerService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SignerService service) {
        _service = service;
    }

    private static SignerServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SignerServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
