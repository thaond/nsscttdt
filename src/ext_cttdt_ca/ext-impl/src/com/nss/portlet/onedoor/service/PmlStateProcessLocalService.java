package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlStateProcessLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlStateProcessLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlStateProcessLocalService {
    public com.nss.portlet.onedoor.model.PmlStateProcess addPmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateProcess createPmlStateProcess(
        long stateProcessId);

    public void deletePmlStateProcess(long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlStateProcess getPmlStateProcess(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> getPmlStateProcesses(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlStateProcessesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateProcess updatePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateProcess updatePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String typeWorkflow)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessName(
        java.lang.String typeWorkflow)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId);
}
