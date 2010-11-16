package com.nss.portlet.digitalsignature.service;


/**
 * <a href="SignatureServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.digitalsignature.service.SignatureService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.SignatureService
 *
 */
public class SignatureServiceUtil {
    private static SignatureService _service;

    public static SignatureService getService() {
        if (_service == null) {
            throw new RuntimeException("SignatureService is not set");
        }

        return _service;
    }

    public void setService(SignatureService service) {
        _service = service;
    }
}
