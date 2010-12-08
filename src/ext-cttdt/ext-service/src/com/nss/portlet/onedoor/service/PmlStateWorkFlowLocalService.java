package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlStateWorkFlowLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlStateWorkFlowLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlStateWorkFlowLocalService {
    public com.nss.portlet.onedoor.model.PmlStateWorkFlow addPmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow createPmlStateWorkFlow(
        long stateWfId);

    public void deletePmlStateWorkFlow(long stateWfId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlStateWorkFlow getPmlStateWorkFlow(
        long stateWfId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> getPmlStateWorkFlows(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlStateWorkFlowsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessNext, int version)
        throws com.liferay.portal.SystemException;
}
