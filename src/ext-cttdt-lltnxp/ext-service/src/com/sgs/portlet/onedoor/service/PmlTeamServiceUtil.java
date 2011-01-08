package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlTeamServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.service.PmlTeamService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlTeamService
 *
 */
public class PmlTeamServiceUtil {
    private static PmlTeamService _service;

    public static PmlTeamService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTeamService is not set");
        }

        return _service;
    }

    public void setService(PmlTeamService service) {
        _service = service;
    }
}
