package com.sgs.portlet.pml_trang_thai_hscv.service;


/**
 * <a href="PmlTrangThaiHSCVServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService
 *
 */
public class PmlTrangThaiHSCVServiceUtil {
    private static PmlTrangThaiHSCVService _service;

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().addPmlTrangThaiHSCV(tenTinhChat);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        long idTinhChat, java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().updatePmlTrangThaiHSCV(idTinhChat, tenTinhChat);
    }

    public static PmlTrangThaiHSCVService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTrangThaiHSCVService is not set");
        }

        return _service;
    }

    public void setService(PmlTrangThaiHSCVService service) {
        _service = service;
    }
}
