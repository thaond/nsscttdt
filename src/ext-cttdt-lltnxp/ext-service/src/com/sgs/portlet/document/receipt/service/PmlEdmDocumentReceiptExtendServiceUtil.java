package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptExtendServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService
 *
 */
public class PmlEdmDocumentReceiptExtendServiceUtil {
    private static PmlEdmDocumentReceiptExtendService _service;

    public static PmlEdmDocumentReceiptExtendService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentReceiptExtendService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentReceiptExtendService service) {
        _service = service;
    }
}
