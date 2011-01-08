package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptWFServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptWFService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFService
 *
 */
public class PmlDocumentReceiptWFServiceUtil {
    private static PmlDocumentReceiptWFService _service;

    public static PmlDocumentReceiptWFService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlDocumentReceiptWFService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentReceiptWFService service) {
        _service = service;
    }
}
