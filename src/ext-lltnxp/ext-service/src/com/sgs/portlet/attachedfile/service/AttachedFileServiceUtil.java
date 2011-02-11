package com.sgs.portlet.attachedfile.service;


/**
 * <a href="AttachedFileServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.attachedfile.service.AttachedFileService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.attachedfile.service.AttachedFileService
 *
 */
public class AttachedFileServiceUtil {
    private static AttachedFileService _service;

    public static AttachedFileService getService() {
        if (_service == null) {
            throw new RuntimeException("AttachedFileService is not set");
        }

        return _service;
    }

    public void setService(AttachedFileService service) {
        _service = service;
    }
}
