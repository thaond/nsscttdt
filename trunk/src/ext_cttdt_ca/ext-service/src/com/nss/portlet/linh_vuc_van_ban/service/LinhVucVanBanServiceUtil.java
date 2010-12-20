package com.nss.portlet.linh_vuc_van_ban.service;


/**
 * <a href="LinhVucVanBanServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService
 *
 */
public class LinhVucVanBanServiceUtil {
    private static LinhVucVanBanService _service;

    public static LinhVucVanBanService getService() {
        if (_service == null) {
            throw new RuntimeException("LinhVucVanBanService is not set");
        }

        return _service;
    }

    public void setService(LinhVucVanBanService service) {
        _service = service;
    }
}
