package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlStateWorkFlowLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalService
 *
 */
public class PmlStateWorkFlowLocalServiceUtil {
    private static PmlStateWorkFlowLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlStateWorkFlow addPmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStateWorkFlow(pmlStateWorkFlow);
    }

    public static com.nss.portlet.onedoor.model.PmlStateWorkFlow createPmlStateWorkFlow(
        long stateWfId) {
        return getService().createPmlStateWorkFlow(stateWfId);
    }

    public static void deletePmlStateWorkFlow(long stateWfId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStateWorkFlow(stateWfId);
    }

    public static void deletePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        getService().deletePmlStateWorkFlow(pmlStateWorkFlow);
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

    public static com.nss.portlet.onedoor.model.PmlStateWorkFlow getPmlStateWorkFlow(
        long stateWfId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlow(stateWfId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> getPmlStateWorkFlows(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlows(start, end);
    }

    public static int getPmlStateWorkFlowsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlowsCount();
    }

    public static com.nss.portlet.onedoor.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStateWorkFlow(pmlStateWorkFlow);
    }

    public static com.nss.portlet.onedoor.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlStateWorkFlow(pmlStateWorkFlow, merge);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessNext, int version)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByWorkFlow_StateProcessId_Version(workflow,
            stateProcessNext, version);
    }

    public static PmlStateWorkFlowLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlStateWorkFlowLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlStateWorkFlowLocalService service) {
        _service = service;
    }
}
