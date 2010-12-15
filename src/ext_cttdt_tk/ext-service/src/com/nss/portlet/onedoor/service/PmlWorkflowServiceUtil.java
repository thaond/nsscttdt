package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlWorkflowServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlWorkflowService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlWorkflowService
 *
 */
public class PmlWorkflowServiceUtil {
    private static PmlWorkflowService _service;

    public static PmlWorkflowService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlWorkflowService is not set");
        }

        return _service;
    }

    public void setService(PmlWorkflowService service) {
        _service = service;
    }
}
