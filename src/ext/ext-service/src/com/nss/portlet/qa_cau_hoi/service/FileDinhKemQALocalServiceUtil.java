package com.nss.portlet.qa_cau_hoi.service;


/**
 * <a href="FileDinhKemQALocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalService
 *
 */
public class FileDinhKemQALocalServiceUtil {
    private static FileDinhKemQALocalService _service;

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA addFileDinhKemQA(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException {
        return getService().addFileDinhKemQA(fileDinhKemQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA createFileDinhKemQA(
        long maFileDinhKemQA) {
        return getService().createFileDinhKemQA(maFileDinhKemQA);
    }

    public static void deleteFileDinhKemQA(long maFileDinhKemQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFileDinhKemQA(maFileDinhKemQA);
    }

    public static void deleteFileDinhKemQA(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException {
        getService().deleteFileDinhKemQA(fileDinhKemQA);
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

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA getFileDinhKemQA(
        long maFileDinhKemQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFileDinhKemQA(maFileDinhKemQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> getFileDinhKemQAs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemQAs(start, end);
    }

    public static int getFileDinhKemQAsCount()
        throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemQAsCount();
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA updateFileDinhKemQA(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKemQA(fileDinhKemQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA updateFileDinhKemQA(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKemQA(fileDinhKemQA, merge);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauHoi(
        long maCauHoi) {
        return getService().findByMaCauHoi(maCauHoi);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauTraLoi(
        long maCauTraLoi) {
        return getService().findByMaCauTraLoi(maCauTraLoi);
    }

    public static FileDinhKemQALocalService getService() {
        if (_service == null) {
            throw new RuntimeException("FileDinhKemQALocalService is not set");
        }

        return _service;
    }

    public void setService(FileDinhKemQALocalService service) {
        _service = service;
    }
}
