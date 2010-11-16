package com.nss.portlet.partner.service;


/**
 * <a href="PartnerServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.partner.service.PartnerService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.service.PartnerService
 *
 */
public class PartnerServiceUtil {
    private static PartnerService _service;

    public static PartnerService getService() {
        if (_service == null) {
            throw new RuntimeException("PartnerService is not set");
        }

        return _service;
    }

    public void setService(PartnerService service) {
        _service = service;
    }
}
