package com.nss.portlet.loai_thu_tuc.service;


/**
 * <a href="LoaiThuTucHanhChinhServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService
 *
 */
public class LoaiThuTucHanhChinhServiceUtil {
    private static LoaiThuTucHanhChinhService _service;

    public static LoaiThuTucHanhChinhService getService() {
        if (_service == null) {
            throw new RuntimeException("LoaiThuTucHanhChinhService is not set");
        }

        return _service;
    }

    public void setService(LoaiThuTucHanhChinhService service) {
        _service = service;
    }
}
