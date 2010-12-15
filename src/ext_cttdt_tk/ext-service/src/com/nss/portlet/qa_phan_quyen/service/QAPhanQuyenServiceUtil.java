package com.nss.portlet.qa_phan_quyen.service;


/**
 * <a href="QAPhanQuyenServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService
 *
 */
public class QAPhanQuyenServiceUtil {
    private static QAPhanQuyenService _service;

    public static QAPhanQuyenService getService() {
        if (_service == null) {
            throw new RuntimeException("QAPhanQuyenService is not set");
        }

        return _service;
    }

    public void setService(QAPhanQuyenService service) {
        _service = service;
    }
}
