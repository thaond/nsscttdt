package com.sgs.portlet.pml_trang_thai_hscv.service;


/**
 * <a href="PmlTrangThaiHSCVLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService
 *
 */
public class PmlTrangThaiHSCVLocalServiceUtil {
    private static PmlTrangThaiHSCVLocalService _service;

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTrangThaiHSCV(pmlTrangThaiHSCV);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV createPmlTrangThaiHSCV(
        long idTrangThaiHSCV) {
        return getService().createPmlTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static void deletePmlTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static void deletePmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTrangThaiHSCV(pmlTrangThaiHSCV);
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

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV getPmlTrangThaiHSCV(
        long idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> getPmlTrangThaiHSCVs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTrangThaiHSCVs(start, end);
    }

    public static int getPmlTrangThaiHSCVsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTrangThaiHSCVsCount();
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTrangThaiHSCV(pmlTrangThaiHSCV);
    }

    public static int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(andOperator, start, end, obc);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addPmlTrangThaiHSCV(tenTrangThaiHSCV);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        long idTrangThaiHSCV, java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updatePmlTrangThaiHSCV(idTrangThaiHSCV, tenTrangThaiHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static void removePmlTrangThaiHSCV(java.lang.String idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static PmlTrangThaiHSCVLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlTrangThaiHSCVLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTrangThaiHSCVLocalService service) {
        _service = service;
    }
}
