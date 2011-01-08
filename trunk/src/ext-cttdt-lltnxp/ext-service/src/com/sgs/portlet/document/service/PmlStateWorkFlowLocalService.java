package com.sgs.portlet.document.service;


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
 * <code>com.sgs.portlet.document.service.impl.PmlStateWorkFlowLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowLocalServiceUtil
 *
 */
public interface PmlStateWorkFlowLocalService {
    public com.sgs.portlet.document.model.PmlStateWorkFlow addPmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateWorkFlow createPmlStateWorkFlow(
        long stateWfId);

    public void deletePmlStateWorkFlow(long stateWfId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateWorkFlow getPmlStateWorkFlow(
        long stateWfId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> getPmlStateWorkFlows(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlStateWorkFlowsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;
}
