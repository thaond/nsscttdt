package com.sgs.portlet.citymanagement.service;


/**
 * <a href="CityLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.citymanagement.service.CityLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.citymanagement.service.CityLocalService
 *
 */
public class CityLocalServiceUtil {
    private static CityLocalService _service;

    public static com.sgs.portlet.citymanagement.model.City addCity(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException {
        return getService().addCity(city);
    }

    public static com.sgs.portlet.citymanagement.model.City createCity(
        java.lang.String cityID) {
        return getService().createCity(cityID);
    }

    public static void deleteCity(java.lang.String cityID)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCity(cityID);
    }

    public static void deleteCity(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException {
        getService().deleteCity(city);
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

    public static com.sgs.portlet.citymanagement.model.City getCity(
        java.lang.String cityID)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCity(cityID);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> getCities(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCities(start, end);
    }

    public static int getCitiesCount()
        throws com.liferay.portal.SystemException {
        return getService().getCitiesCount();
    }

    public static com.sgs.portlet.citymanagement.model.City updateCity(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException {
        return getService().updateCity(city);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_THANH_PHO(java.lang.String cityCode,
        java.lang.String cityName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTEN_MA_THANH_PHO(cityCode, cityName, andOperator);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String cityCode, java.lang.String cityName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByTEN_MA_THANH_PHO(cityCode, cityName, andOperator,
            start, end, obc);
    }

    public static void removeAgency(java.lang.String cityId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeAgency(cityId);
    }

    public static com.sgs.portlet.citymanagement.model.City addCity(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, java.lang.String active,
        java.lang.String countryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addCity(cityCode, cityName, description, active, countryId);
    }

    public static com.sgs.portlet.citymanagement.model.City updateCity(
        java.lang.String cityId, java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateCity(cityId, cityCode, cityName, description);
    }

    public static CityLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CityLocalService is not set");
        }

        return _service;
    }

    public void setService(CityLocalService service) {
        _service = service;
    }
}
