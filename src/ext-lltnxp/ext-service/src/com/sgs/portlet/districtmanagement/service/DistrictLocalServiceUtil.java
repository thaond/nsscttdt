package com.sgs.portlet.districtmanagement.service;


/**
 * <a href="DistrictLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.districtmanagement.service.DistrictLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.districtmanagement.service.DistrictLocalService
 *
 */
public class DistrictLocalServiceUtil {
    private static DistrictLocalService _service;

    public static com.sgs.portlet.districtmanagement.model.District addDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException {
        return getService().addDistrict(district);
    }

    public static com.sgs.portlet.districtmanagement.model.District createDistrict(
        java.lang.String districtId) {
        return getService().createDistrict(districtId);
    }

    public static void deleteDistrict(java.lang.String districtId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDistrict(districtId);
    }

    public static void deleteDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException {
        getService().deleteDistrict(district);
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

    public static com.sgs.portlet.districtmanagement.model.District getDistrict(
        java.lang.String districtId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDistrict(districtId);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> getDistricts(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDistricts(start, end);
    }

    public static int getDistrictsCount()
        throws com.liferay.portal.SystemException {
        return getService().getDistrictsCount();
    }

    public static com.sgs.portlet.districtmanagement.model.District updateDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException {
        return getService().updateDistrict(district);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_QUAN(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByTEN_MA_MOTA_QUAN(code, name, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_MOTA_QUAN(code, name, des, andOperator, start,
            end, obc);
    }

    public static int searchCount(java.lang.String cityId)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(cityId);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> search(
        java.lang.String cityId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().search(cityId, start, end);
    }

    public static void removeDistrict(java.lang.String districtId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeDistrict(districtId);
    }

    public static com.sgs.portlet.districtmanagement.model.District addDistrict(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addDistrict(districtCode, districtName, cityID,
            description, active);
    }

    public static com.sgs.portlet.districtmanagement.model.District updateDistrict(
        java.lang.String districtId, java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateDistrict(districtId, districtCode, districtName,
            cityID, description, active);
    }

    public static DistrictLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("DistrictLocalService is not set");
        }

        return _service;
    }

    public void setService(DistrictLocalService service) {
        _service = service;
    }
}
