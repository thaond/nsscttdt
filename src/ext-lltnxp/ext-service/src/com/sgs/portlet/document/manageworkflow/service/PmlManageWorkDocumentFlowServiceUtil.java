package com.sgs.portlet.document.manageworkflow.service;


/**
 * <a href="PmlManageWorkDocumentFlowServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService
 *
 */
public class PmlManageWorkDocumentFlowServiceUtil {
    private static PmlManageWorkDocumentFlowService _service;

    public static PmlManageWorkDocumentFlowService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlManageWorkDocumentFlowService is not set");
        }

        return _service;
    }

    public void setService(PmlManageWorkDocumentFlowService service) {
        _service = service;
    }
}
