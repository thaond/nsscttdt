package com.nss.portlet.qa_cau_tra_loi.service;


/**
 * <a href="CauTraLoiQALocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService
 *
 */
public class CauTraLoiQALocalServiceUtil {
    private static CauTraLoiQALocalService _service;

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA addCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException {
        return getService().addCauTraLoiQA(cauTraLoiQA);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA createCauTraLoiQA(
        long maCauTraLoiQA) {
        return getService().createCauTraLoiQA(maCauTraLoiQA);
    }

    public static void deleteCauTraLoiQA(long maCauTraLoiQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCauTraLoiQA(maCauTraLoiQA);
    }

    public static void deleteCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException {
        getService().deleteCauTraLoiQA(cauTraLoiQA);
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

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA getCauTraLoiQA(
        long maCauTraLoiQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCauTraLoiQA(maCauTraLoiQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> getCauTraLoiQAs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCauTraLoiQAs(start, end);
    }

    public static int getCauTraLoiQAsCount()
        throws com.liferay.portal.SystemException {
        return getService().getCauTraLoiQAsCount();
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException {
        return getService().updateCauTraLoiQA(cauTraLoiQA);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateCauTraLoiQA(cauTraLoiQA, merge);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoi(
        long maCauHoi) {
        return getService().findByMaCauHoi(maCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoi_Publish(
        long maCauHoi) {
        return getService().findByMaCauHoi_Publish(maCauHoi);
    }

    public static CauTraLoiQALocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CauTraLoiQALocalService is not set");
        }

        return _service;
    }

    public void setService(CauTraLoiQALocalService service) {
        _service = service;
    }
}
