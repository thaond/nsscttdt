package com.sgs.portlet.pml_do_quan_trong.service;


/**
 * <a href="PmlDoQuanTrongService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_do_quan_trong.service.impl.PmlDoQuanTrongServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongServiceUtil
 *
 */
public interface PmlDoQuanTrongService {
    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
