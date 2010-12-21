package com.nss.portlet.qa_chu_de.service;


/**
 * <a href="QAChuDeCauHoiServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService
 *
 */
public class QAChuDeCauHoiServiceUtil {
    private static QAChuDeCauHoiService _service;

    public static QAChuDeCauHoiService getService() {
        if (_service == null) {
            throw new RuntimeException("QAChuDeCauHoiService is not set");
        }

        return _service;
    }

    public void setService(QAChuDeCauHoiService service) {
        _service = service;
    }
}
