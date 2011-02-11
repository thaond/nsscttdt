package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlWfOnedoorProcessServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService
 *
 */
public class PmlWfOnedoorProcessServiceUtil {
    private static PmlWfOnedoorProcessService _service;

    public static PmlWfOnedoorProcessService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlWfOnedoorProcessService is not set");
        }

        return _service;
    }

    public void setService(PmlWfOnedoorProcessService service) {
        _service = service;
    }
}
