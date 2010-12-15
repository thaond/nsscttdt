package com.nss.portlet.thu_tuc_hanh_chinh.service;


/**
 * <a href="ThuTucHanhChinhServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhService
 *
 */
public class ThuTucHanhChinhServiceUtil {
    private static ThuTucHanhChinhService _service;

    public static ThuTucHanhChinhService getService() {
        if (_service == null) {
            throw new RuntimeException("ThuTucHanhChinhService is not set");
        }

        return _service;
    }

    public void setService(ThuTucHanhChinhService service) {
        _service = service;
    }
}
