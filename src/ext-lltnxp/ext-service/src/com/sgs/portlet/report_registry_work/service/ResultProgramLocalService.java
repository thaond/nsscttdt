package com.sgs.portlet.report_registry_work.service;


/**
 * <a href="ResultProgramLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.report_registry_work.service.impl.ResultProgramLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil
 *
 */
public interface ResultProgramLocalService {
    public com.sgs.portlet.report_registry_work.model.ResultProgram addResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram createResultProgram(
        long resultProgramId);

    public void deleteResultProgram(long resultProgramId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram getResultProgram(
        long resultProgramId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getResultProgramsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram updateResultProgram(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException;
}
