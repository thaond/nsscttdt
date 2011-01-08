package com.sgs.portlet.pml_ho_so_cong_viec.service;


/**
 * <a href="PmlHoSoCongViecServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService
 *
 */
public class PmlHoSoCongViecServiceUtil {
    private static PmlHoSoCongViecService _service;

    public static PmlHoSoCongViecService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlHoSoCongViecService is not set");
        }

        return _service;
    }

    public void setService(PmlHoSoCongViecService service) {
        _service = service;
    }
}
