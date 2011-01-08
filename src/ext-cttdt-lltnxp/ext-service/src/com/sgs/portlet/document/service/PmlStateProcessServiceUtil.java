package com.sgs.portlet.document.service;


/**
 * <a href="PmlStateProcessServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlStateProcessService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlStateProcessService
 *
 */
public class PmlStateProcessServiceUtil {
    private static PmlStateProcessService _service;

    public static PmlStateProcessService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlStateProcessService is not set");
        }

        return _service;
    }

    public void setService(PmlStateProcessService service) {
        _service = service;
    }
}
