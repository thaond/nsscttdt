package com.sgs.portlet.pml_do_quan_trong.service;


/**
 * <a href="PmlDoQuanTrongServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService
 *
 */
public class PmlDoQuanTrongServiceUtil {
    private static PmlDoQuanTrongService _service;

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().addPmlDoQuanTrong(tenDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().updatePmlDoQuanTrong(idDoQuanTrong, tenDoQuanTrong);
    }

    public static PmlDoQuanTrongService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlDoQuanTrongService is not set");
        }

        return _service;
    }

    public void setService(PmlDoQuanTrongService service) {
        _service = service;
    }
}
