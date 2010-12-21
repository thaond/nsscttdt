package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlWfOnedoorProcessLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlWfOnedoorProcessLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlWfOnedoorProcessLocalService {
    public com.nss.portlet.onedoor.model.PmlWfOnedoorProcess addPmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlWfOnedoorProcess createPmlWfOnedoorProcess(
        java.lang.String fileId);

    public void deletePmlWfOnedoorProcess(java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlWfOnedoorProcess getPmlWfOnedoorProcess(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlWfOnedoorProcess> getPmlWfOnedoorProcesses(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlWfOnedoorProcessesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlWfOnedoorProcess updatePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlWfOnedoorProcess updatePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException;
}
