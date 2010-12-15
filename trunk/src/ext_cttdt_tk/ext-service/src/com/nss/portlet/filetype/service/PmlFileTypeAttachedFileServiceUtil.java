package com.nss.portlet.filetype.service;


/**
 * <a href="PmlFileTypeAttachedFileServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.filetype.service.PmlFileTypeAttachedFileService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.PmlFileTypeAttachedFileService
 *
 */
public class PmlFileTypeAttachedFileServiceUtil {
    private static PmlFileTypeAttachedFileService _service;

    public static PmlFileTypeAttachedFileService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileTypeAttachedFileService is not set");
        }

        return _service;
    }

    public void setService(PmlFileTypeAttachedFileService service) {
        _service = service;
    }
}
