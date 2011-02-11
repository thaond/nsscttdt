package com.sgs.portlet.signer.service;


/**
 * <a href="SignerServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.signer.service.SignerService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.service.SignerService
 *
 */
public class SignerServiceUtil {
    private static SignerService _service;

    public static SignerService getService() {
        if (_service == null) {
            throw new RuntimeException("SignerService is not set");
        }

        return _service;
    }

    public void setService(SignerService service) {
        _service = service;
    }
}
