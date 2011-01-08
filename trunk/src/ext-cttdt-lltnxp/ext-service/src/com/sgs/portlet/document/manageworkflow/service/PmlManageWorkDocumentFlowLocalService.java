package com.sgs.portlet.document.manageworkflow.service;


/**
 * <a href="PmlManageWorkDocumentFlowLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.manageworkflow.service.impl.PmlManageWorkDocumentFlowLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalServiceUtil
 *
 */
public interface PmlManageWorkDocumentFlowLocalService {
    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow addPmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow createPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId);

    public void deletePmlManageWorkDocumentFlow(long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow getPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> getPmlManageWorkDocumentFlows(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlManageWorkDocumentFlowsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow updatePmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String workflowName,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> search(
        java.lang.String workflowName, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
