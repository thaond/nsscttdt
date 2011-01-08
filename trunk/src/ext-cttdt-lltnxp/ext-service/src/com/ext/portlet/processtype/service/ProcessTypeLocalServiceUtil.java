package com.ext.portlet.processtype.service;


/**
 * <a href="ProcessTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.processtype.service.ProcessTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.processtype.service.ProcessTypeLocalService
 *
 */
public class ProcessTypeLocalServiceUtil {
    private static ProcessTypeLocalService _service;

    public static com.ext.portlet.processtype.model.ProcessType addProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException {
        return getService().addProcessType(processType);
    }

    public static com.ext.portlet.processtype.model.ProcessType createProcessType(
        long processTypeId) {
        return getService().createProcessType(processTypeId);
    }

    public static void deleteProcessType(long processTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteProcessType(processTypeId);
    }

    public static void deleteProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException {
        getService().deleteProcessType(processType);
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

    public static com.ext.portlet.processtype.model.ProcessType getProcessType(
        long processTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getProcessType(processTypeId);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> getProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getProcessTypes(start, end);
    }

    public static int getProcessTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getProcessTypesCount();
    }

    public static com.ext.portlet.processtype.model.ProcessType updateProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException {
        return getService().updateProcessType(processType);
    }

    public static com.ext.portlet.processtype.model.ProcessType getProcessTypeById(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getProcessTypeById(id);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> getProcessTypeByFlag(
        int flag)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getProcessTypeByFlag(flag);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception {
        return getService().getListProcessType(documentReceiptId);
    }

    public static ProcessTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ProcessTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(ProcessTypeLocalService service) {
        _service = service;
    }
}
