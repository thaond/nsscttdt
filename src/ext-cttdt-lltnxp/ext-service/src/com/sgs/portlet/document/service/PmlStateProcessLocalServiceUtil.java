package com.sgs.portlet.document.service;


/**
 * <a href="PmlStateProcessLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlStateProcessLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlStateProcessLocalService
 *
 */
public class PmlStateProcessLocalServiceUtil {
    private static PmlStateProcessLocalService _service;

    public static com.sgs.portlet.document.model.PmlStateProcess addPmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStateProcess(pmlStateProcess);
    }

    public static com.sgs.portlet.document.model.PmlStateProcess createPmlStateProcess(
        long stateProcessId) {
        return getService().createPmlStateProcess(stateProcessId);
    }

    public static void deletePmlStateProcess(long stateProcessId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStateProcess(stateProcessId);
    }

    public static void deletePmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        getService().deletePmlStateProcess(pmlStateProcess);
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

    public static com.sgs.portlet.document.model.PmlStateProcess getPmlStateProcess(
        long stateProcessId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStateProcess(stateProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateProcess> getPmlStateProcesses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStateProcesses(start, end);
    }

    public static int getPmlStateProcessesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStateProcessesCount();
    }

    public static com.sgs.portlet.document.model.PmlStateProcess updatePmlStateProcess(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStateProcess(pmlStateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateProcess> getListStateProcess(
        java.lang.String fileTypeId) {
        return getService().getListStateProcess(fileTypeId);
    }

    public static int counterFileByState(java.lang.String fileTypeId,
        long stateProcessId) {
        return getService().counterFileByState(fileTypeId, stateProcessId);
    }

    public static int countFileByState(java.lang.String departmentId,
        long fileStatusId, java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .countFileByState(departmentId, fileStatusId, startDate,
            endDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDispose(
        java.lang.String departmentId, long fileStatusId,
        java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListProcessDispose(departmentId, fileStatusId,
            startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDisposeByStateProcess(
        long stateProcessId, java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListProcessDisposeByStateProcess(stateProcessId,
            startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> getListDepartmentByFileTypeId(
        java.lang.String fileTypeId) {
        return getService().getListDepartmentByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListProcessDisposeBy_FileTypeId_StateProcessId(
        java.lang.String fileTypeId, long stateProcessId,
        java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListProcessDisposeBy_FileTypeId_StateProcessId(fileTypeId,
            stateProcessId, startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListStateProcessByFileType(
        java.lang.String fileTypeId) {
        return getService().getListStateProcessByFileType(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListFileFromDate_ToDate(
        java.lang.String fileTypeId, java.util.Date fromDate,
        java.util.Date toDate) {
        return getService()
                   .getListFileFromDate_ToDate(fileTypeId, fromDate, toDate);
    }

    public static com.sgs.portlet.document.model.PmlProcessDispose getFileOverTime(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date fromDate, java.util.Date toDate) {
        return getService().getFileOverTime(fileId, fileTypeId, fromDate, toDate);
    }

    public static boolean getPmlOneDoorReceiveFileOverTime(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile) {
        return getService()
                   .getPmlOneDoorReceiveFileOverTime(pmlOneDoorReceiveFile);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception {
        return getService().findByStateProcessIds(stateProcessIds);
    }

    public static PmlStateProcessLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlStateProcessLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlStateProcessLocalService service) {
        _service = service;
    }
}
