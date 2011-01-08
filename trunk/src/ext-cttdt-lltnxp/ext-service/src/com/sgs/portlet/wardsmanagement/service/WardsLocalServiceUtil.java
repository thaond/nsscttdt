package com.sgs.portlet.wardsmanagement.service;


/**
 * <a href="WardsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.wardsmanagement.service.WardsLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.wardsmanagement.service.WardsLocalService
 *
 */
public class WardsLocalServiceUtil {
    private static WardsLocalService _service;

    public static com.sgs.portlet.wardsmanagement.model.Wards addWards(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException {
        return getService().addWards(wards);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards createWards(
        java.lang.String wardsId) {
        return getService().createWards(wardsId);
    }

    public static void deleteWards(java.lang.String wardsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteWards(wardsId);
    }

    public static void deleteWards(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException {
        getService().deleteWards(wards);
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

    public static com.sgs.portlet.wardsmanagement.model.Wards getWards(
        java.lang.String wardsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getWards(wardsId);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> getWardses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getWardses(start, end);
    }

    public static int getWardsesCount()
        throws com.liferay.portal.SystemException {
        return getService().getWardsesCount();
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards updateWards(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException {
        return getService().updateWards(wards);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_PHUONG(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTEN_MA_MOTA_PHUONG(code, name, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_MOTA_PHUONG(code, name, des, andOperator, start,
            end, obc);
    }

    public static int searchCount(java.lang.String districtId)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(districtId);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> search(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().search(districtId, start, end);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards addWard(
        java.lang.String wardCode, java.lang.String wardName,
        java.lang.String districtId, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addWard(wardCode, wardName, districtId, description, active);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards updateWard(
        java.lang.String wardId, java.lang.String wardCode,
        java.lang.String wardName, java.lang.String districtId,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateWard(wardId, wardCode, wardName, districtId,
            description, active);
    }

    public static WardsLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("WardsLocalService is not set");
        }

        return _service;
    }

    public void setService(WardsLocalService service) {
        _service = service;
    }
}
