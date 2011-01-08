package com.sgs.portlet.onedoorpccc.service;


/**
 * <a href="PmlFilePCCCLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService
 *
 */
public class PmlFilePCCCLocalServiceUtil {
    private static PmlFilePCCCLocalService _service;

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC addPmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFilePCCC(pmlFilePCCC);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC createPmlFilePCCC(
        java.lang.String fileId) {
        return getService().createPmlFilePCCC(fileId);
    }

    public static void deletePmlFilePCCC(java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFilePCCC(fileId);
    }

    public static void deletePmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFilePCCC(pmlFilePCCC);
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

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC getPmlFilePCCC(
        java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFilePCCC(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> getPmlFilePCCCs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCs(start, end);
    }

    public static int getPmlFilePCCCsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCsCount();
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC updatePmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFilePCCC(pmlFilePCCC);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filter(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileId, java.lang.String fileName,
        java.lang.String applicantName, java.lang.String address,
        java.lang.String telephone, java.lang.String email, long fileStatusId,
        java.lang.String fileType, java.util.Date receiveFromDate,
        java.util.Date receiveToDate, java.util.Date expectedReturningFromDate,
        java.util.Date expectedReturningToDate, java.util.Date expiredFromDate,
        java.util.Date expiredToDate, java.util.Date exactReturningFromDate,
        java.util.Date exactReturningToDate) {
        return getService()
                   .filter(list, fileId, fileName, applicantName, address,
            telephone, email, fileStatusId, fileType, receiveFromDate,
            receiveToDate, expectedReturningFromDate, expectedReturningToDate,
            expiredFromDate, expiredToDate, exactReturningFromDate,
            exactReturningToDate);
    }

    public static PmlFilePCCCLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlFilePCCCLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFilePCCCLocalService service) {
        _service = service;
    }
}
