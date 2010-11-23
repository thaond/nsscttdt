package com.nss.portlet.qa_cau_tra_loi.service;


/**
 * <a href="CauTraLoiQAServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService
 *
 */
public class CauTraLoiQAServiceUtil {
    private static CauTraLoiQAService _service;

    public static CauTraLoiQAService getService() {
        if (_service == null) {
            throw new RuntimeException("CauTraLoiQAService is not set");
        }

        return _service;
    }

    public void setService(CauTraLoiQAService service) {
        _service = service;
    }
}
