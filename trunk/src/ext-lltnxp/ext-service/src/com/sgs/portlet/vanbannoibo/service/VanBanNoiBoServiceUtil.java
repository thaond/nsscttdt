package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="VanBanNoiBoServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService
 *
 */
public class VanBanNoiBoServiceUtil {
    private static VanBanNoiBoService _service;

    public static VanBanNoiBoService getService() {
        if (_service == null) {
            throw new RuntimeException("VanBanNoiBoService is not set");
        }

        return _service;
    }

    public void setService(VanBanNoiBoService service) {
        _service = service;
    }
}
