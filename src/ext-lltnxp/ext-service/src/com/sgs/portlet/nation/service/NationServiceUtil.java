package com.sgs.portlet.nation.service;


/**
 * <a href="NationServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.nation.service.NationService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.service.NationService
 *
 */
public class NationServiceUtil {
    private static NationService _service;

    public static NationService getService() {
        if (_service == null) {
            throw new RuntimeException("NationService is not set");
        }

        return _service;
    }

    public void setService(NationService service) {
        _service = service;
    }
}
