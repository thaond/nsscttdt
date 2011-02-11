package com.sgs.portlet.document.service;


/**
 * <a href="PmlStateProcessLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlStateProcessLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil
 *
 */
public interface PmlStateProcessLocalService {
    public com.sgs.portlet.document.model.PmlStateProcess addPmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess createPmlStateProcess(
        long stateProcessId);

    public void deletePmlStateProcess(long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess getPmlStateProcess(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> getPmlStateProcesses(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlStateProcessesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess updatePmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> getListStateProcess(
        java.lang.String fileTypeId);

    public int counterFileByState(java.lang.String fileTypeId,
        long stateProcessId);

    public int countFileByState(java.lang.String departmentId,
        long fileStatusId, java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDispose(
        java.lang.String departmentId, long fileStatusId,
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDisposeByStateProcess(
        long stateProcessId, java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.department.model.Department> getListDepartmentByFileTypeId(
        java.lang.String fileTypeId);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDisposeBy_FileTypeId_StateProcessId(
        java.lang.String fileTypeId, long stateProcessId,
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListStateProcessByFileType(
        java.lang.String fileTypeId);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListFileFromDate_ToDate(
        java.lang.String fileTypeId, java.util.Date fromDate,
        java.util.Date toDate);

    public com.sgs.portlet.document.model.PmlProcessDispose getFileOverTime(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date fromDate, java.util.Date toDate);

    public boolean getPmlOneDoorReceiveFileOverTime(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile);

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception;
}
