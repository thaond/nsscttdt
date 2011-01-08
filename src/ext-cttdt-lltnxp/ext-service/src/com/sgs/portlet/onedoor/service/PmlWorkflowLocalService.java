package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlWorkflowLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlWorkflowLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlWorkflowLocalServiceUtil
 *
 */
public interface PmlWorkflowLocalService {
    public com.sgs.portlet.onedoor.model.PmlWorkflow addPmlWorkflow(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow createPmlWorkflow(
        long workflowId);

    public void deletePmlWorkflow(long workflowId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlWorkflow(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow getPmlWorkflow(
        long workflowId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> getPmlWorkflows(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlWorkflowsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow updatePmlWorkflow(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow getByWorkflow_Version(
        java.lang.String workflow, int version);

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String fileTypeName,
        java.lang.String workflowName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> search(
        java.lang.String fileTypeName, java.lang.String workflowName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
