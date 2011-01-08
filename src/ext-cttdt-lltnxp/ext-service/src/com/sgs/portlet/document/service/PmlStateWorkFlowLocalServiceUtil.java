package com.sgs.portlet.document.service;


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
 * <code>com.sgs.portlet.document.service.PmlStateWorkFlowLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowLocalService
 *
 */
public class PmlStateWorkFlowLocalServiceUtil {
    private static PmlStateWorkFlowLocalService _service;

    public static com.sgs.portlet.document.model.PmlStateWorkFlow addPmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStateWorkFlow(pmlStateWorkFlow);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow createPmlStateWorkFlow(
        long stateWfId) {
        return getService().createPmlStateWorkFlow(stateWfId);
    }

    public static void deletePmlStateWorkFlow(long stateWfId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStateWorkFlow(stateWfId);
    }

    public static void deletePmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
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

    public static com.sgs.portlet.document.model.PmlStateWorkFlow getPmlStateWorkFlow(
        long stateWfId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlow(stateWfId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> getPmlStateWorkFlows(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlows(start, end);
    }

    public static int getPmlStateWorkFlowsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStateWorkFlowsCount();
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow updatePmlStateWorkFlow(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStateWorkFlow(pmlStateWorkFlow);
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
