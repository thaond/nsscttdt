package com.sgs.portlet.document_manager.service;


/**
 * <a href="DocumentManagerServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document_manager.service.DocumentManagerService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.DocumentManagerService
 *
 */
public class DocumentManagerServiceUtil {
    private static DocumentManagerService _service;

    public static DocumentManagerService getService() {
        if (_service == null) {
            throw new RuntimeException("DocumentManagerService is not set");
        }

        return _service;
    }

    public void setService(DocumentManagerService service) {
        _service = service;
    }
}
