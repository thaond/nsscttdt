package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlWorkflowLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlWorkflowLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlWorkflowLocalService
 *
 */
public class PmlWorkflowLocalServiceUtil {
    private static PmlWorkflowLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlWorkflow addPmlWorkflow(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException {
        return getService().addPmlWorkflow(pmlWorkflow);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow createPmlWorkflow(
        long workflowId) {
        return getService().createPmlWorkflow(workflowId);
    }

    public static void deletePmlWorkflow(long workflowId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlWorkflow(workflowId);
    }

    public static void deletePmlWorkflow(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException {
        getService().deletePmlWorkflow(pmlWorkflow);
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

    public static com.nss.portlet.onedoor.model.PmlWorkflow getPmlWorkflow(
        long workflowId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlWorkflow(workflowId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> getPmlWorkflows(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlWorkflows(start, end);
    }

    public static int getPmlWorkflowsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlWorkflowsCount();
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow updatePmlWorkflow(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlWorkflow(pmlWorkflow);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow updatePmlWorkflow(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlWorkflow(pmlWorkflow, merge);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String fileTypeName,
        java.lang.String workflowName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(fileTypeName, workflowName, andOperator);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> search(
        java.lang.String fileTypeName, java.lang.String workflowName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(fileTypeName, workflowName, andOperator, start, end,
            obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String nameProcess, int version)
        throws com.liferay.portal.SystemException {
        return getService().findByWorkFlow_Version(nameProcess, version);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getService().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version)
        throws com.liferay.portal.SystemException {
        return getService().findByFileTypeId_Version(fileTypeId, version);
    }

    public static PmlWorkflowLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlWorkflowLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlWorkflowLocalService service) {
        _service = service;
    }
}
