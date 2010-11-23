package com.nss.portlet.qa_cau_hoi.service;


/**
 * <a href="CauHoiQAServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_cau_hoi.service.CauHoiQAService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.CauHoiQAService
 *
 */
public class CauHoiQAServiceUtil {
    private static CauHoiQAService _service;

    public static CauHoiQAService getService() {
        if (_service == null) {
            throw new RuntimeException("CauHoiQAService is not set");
        }

        return _service;
    }

    public void setService(CauHoiQAService service) {
        _service = service;
    }
}
