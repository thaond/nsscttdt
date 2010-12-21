package com.nss.portlet.qa_cau_hoi.service;


/**
 * <a href="CauHoiQALocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalService
 *
 */
public class CauHoiQALocalServiceUtil {
    private static CauHoiQALocalService _service;

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA addCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException {
        return getService().addCauHoiQA(cauHoiQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA createCauHoiQA(
        long maCauHoiQA) {
        return getService().createCauHoiQA(maCauHoiQA);
    }

    public static void deleteCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCauHoiQA(maCauHoiQA);
    }

    public static void deleteCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException {
        getService().deleteCauHoiQA(cauHoiQA);
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

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA getCauHoiQA(
        long maCauHoiQA)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCauHoiQA(maCauHoiQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> getCauHoiQAs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCauHoiQAs(start, end);
    }

    public static int getCauHoiQAsCount()
        throws com.liferay.portal.SystemException {
        return getService().getCauHoiQAsCount();
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException {
        return getService().updateCauHoiQA(cauHoiQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateCauHoiQA(cauHoiQA, merge);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTieuDe_ChuDe(maChuDeCauHoi, name, andOperator, start,
            end, obc);
    }

    public static int countByTieuDe_ChuDe(long maChuDeCauHoi,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByTieuDe_ChuDe(maChuDeCauHoi, name, andOperator);
    }

    public static int countByTieuDe_ChuDe_PhanQuyen(long userId,
        long maChuDeCauHoi, java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String name,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi) {
        return getService().findByMaChuDeCauHoi(maChuDeCauHoi);
    }

    public static CauHoiQALocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CauHoiQALocalService is not set");
        }

        return _service;
    }

    public void setService(CauHoiQALocalService service) {
        _service = service;
    }
}
