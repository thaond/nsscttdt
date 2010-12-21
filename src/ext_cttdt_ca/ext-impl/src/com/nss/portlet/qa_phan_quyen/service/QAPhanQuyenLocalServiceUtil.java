package com.nss.portlet.qa_phan_quyen.service;


/**
 * <a href="QAPhanQuyenLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService
 *
 */
public class QAPhanQuyenLocalServiceUtil {
    private static QAPhanQuyenLocalService _service;

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen addQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException {
        return getService().addQAPhanQuyen(qaPhanQuyen);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen createQAPhanQuyen(
        long maPhanQuyen) {
        return getService().createQAPhanQuyen(maPhanQuyen);
    }

    public static void deleteQAPhanQuyen(long maPhanQuyen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteQAPhanQuyen(maPhanQuyen);
    }

    public static void deleteQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException {
        getService().deleteQAPhanQuyen(qaPhanQuyen);
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

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen getQAPhanQuyen(
        long maPhanQuyen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getQAPhanQuyen(maPhanQuyen);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> getQAPhanQuyens(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getQAPhanQuyens(start, end);
    }

    public static int getQAPhanQuyensCount()
        throws com.liferay.portal.SystemException {
        return getService().getQAPhanQuyensCount();
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException {
        return getService().updateQAPhanQuyen(qaPhanQuyen);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateQAPhanQuyen(qaPhanQuyen, merge);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi(
        long maChuDeCauHoi) {
        return getService().findByMaChuDeCauHoi(maChuDeCauHoi);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi) {
        return getService()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
            maNguoiTraLoi);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi) {
        return getService().findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi);
    }

    public static QAPhanQuyenLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("QAPhanQuyenLocalService is not set");
        }

        return _service;
    }

    public void setService(QAPhanQuyenLocalService service) {
        _service = service;
    }
}
