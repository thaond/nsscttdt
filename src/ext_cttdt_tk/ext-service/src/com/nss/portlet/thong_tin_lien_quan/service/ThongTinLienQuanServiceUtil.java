package com.nss.portlet.thong_tin_lien_quan.service;


/**
 * <a href="ThongTinLienQuanServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService
 *
 */
public class ThongTinLienQuanServiceUtil {
    private static ThongTinLienQuanService _service;

    public static ThongTinLienQuanService getService() {
        if (_service == null) {
            throw new RuntimeException("ThongTinLienQuanService is not set");
        }

        return _service;
    }

    public void setService(ThongTinLienQuanService service) {
        _service = service;
    }
}
