package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="SoVanBanNoiBoServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoService
 *
 */
public class SoVanBanNoiBoServiceUtil {
    private static SoVanBanNoiBoService _service;

    public static SoVanBanNoiBoService getService() {
        if (_service == null) {
            throw new RuntimeException("SoVanBanNoiBoService is not set");
        }

        return _service;
    }

    public void setService(SoVanBanNoiBoService service) {
        _service = service;
    }
}
