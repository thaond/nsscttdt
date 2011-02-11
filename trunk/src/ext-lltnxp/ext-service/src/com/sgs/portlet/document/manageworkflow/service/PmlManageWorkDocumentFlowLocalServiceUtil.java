package com.sgs.portlet.document.manageworkflow.service;


/**
 * <a href="PmlManageWorkDocumentFlowLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService
 *
 */
public class PmlManageWorkDocumentFlowLocalServiceUtil {
    private static PmlManageWorkDocumentFlowLocalService _service;

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow addPmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlManageWorkDocumentFlow(pmlManageWorkDocumentFlow);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow createPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId) {
        return getService()
                   .createPmlManageWorkDocumentFlow(manageDocumentWorkFlowId);
    }

    public static void deletePmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlManageWorkDocumentFlow(manageDocumentWorkFlowId);
    }

    public static void deletePmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException {
        getService().deletePmlManageWorkDocumentFlow(pmlManageWorkDocumentFlow);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow getPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getPmlManageWorkDocumentFlow(manageDocumentWorkFlowId);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> getPmlManageWorkDocumentFlows(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlManageWorkDocumentFlows(start, end);
    }

    public static int getPmlManageWorkDocumentFlowsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlManageWorkDocumentFlowsCount();
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow updatePmlManageWorkDocumentFlow(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlManageWorkDocumentFlow(pmlManageWorkDocumentFlow);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String workflowName,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(workflowName, description, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> search(
        java.lang.String workflowName, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(workflowName, description, andOperator, start, end,
            obc);
    }

    public static PmlManageWorkDocumentFlowLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlManageWorkDocumentFlowLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlManageWorkDocumentFlowLocalService service) {
        _service = service;
    }
}
