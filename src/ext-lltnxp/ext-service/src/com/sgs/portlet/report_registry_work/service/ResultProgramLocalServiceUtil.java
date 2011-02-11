package com.sgs.portlet.report_registry_work.service;


/**
 * <a href="ResultProgramLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.report_registry_work.service.ResultProgramLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramLocalService
 *
 */
public class ResultProgramLocalServiceUtil {
    private static ResultProgramLocalService _service;

    public static com.sgs.portlet.report_registry_work.model.ResultProgram addResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException {
        return getService().addResultProgram(resultProgram);
    }

    public static com.sgs.portlet.report_registry_work.model.ResultProgram createResultProgram(
        long resultProgramId) {
        return getService().createResultProgram(resultProgramId);
    }

    public static void deleteResultProgram(long resultProgramId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteResultProgram(resultProgramId);
    }

    public static void deleteResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException {
        getService().deleteResultProgram(resultProgram);
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

    public static com.sgs.portlet.report_registry_work.model.ResultProgram getResultProgram(
        long resultProgramId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getResultProgram(resultProgramId);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getResultPrograms(start, end);
    }

    public static int getResultProgramsCount()
        throws com.liferay.portal.SystemException {
        return getService().getResultProgramsCount();
    }

    public static com.sgs.portlet.report_registry_work.model.ResultProgram updateResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException {
        return getService().updateResultProgram(resultProgram);
    }

    public static ResultProgramLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ResultProgramLocalService is not set");
        }

        return _service;
    }

    public void setService(ResultProgramLocalService service) {
        _service = service;
    }
}
