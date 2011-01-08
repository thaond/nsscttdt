package com.sgs.portlet.country.service;


/**
 * <a href="CountryLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.country.service.CountryLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.service.CountryLocalService
 *
 */
public class CountryLocalServiceUtil {
    private static CountryLocalService _service;

    public static com.sgs.portlet.country.model.Country addCountry(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException {
        return getService().addCountry(country);
    }

    public static com.sgs.portlet.country.model.Country createCountry(
        java.lang.String countryId) {
        return getService().createCountry(countryId);
    }

    public static void deleteCountry(java.lang.String countryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCountry(countryId);
    }

    public static void deleteCountry(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException {
        getService().deleteCountry(country);
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

    public static com.sgs.portlet.country.model.Country getCountry(
        java.lang.String countryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCountry(countryId);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> getCountries(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCountries(start, end);
    }

    public static int getCountriesCount()
        throws com.liferay.portal.SystemException {
        return getService().getCountriesCount();
    }

    public static com.sgs.portlet.country.model.Country updateCountry(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException {
        return getService().updateCountry(country);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode) {
        return getService().findByCountryCode(countryCode);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName) {
        return getService().findByCountryName(countryName);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description) {
        return getService().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active) {
        return getService().findByActive(active);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String code, java.lang.String name,
        java.lang.String description) {
        return getService().findByC_N_D(code, name, description);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end) {
        return getService().findByCountryCode(countryCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end) {
        return getService().findByCountryName(countryName, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end) {
        return getService().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end) {
        return getService().findByActive(active, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String code, java.lang.String name,
        java.lang.String description, int start, int end) {
        return getService().findByC_N_D(code, name, description, start, end);
    }

    public static int countByCountryCode(java.lang.String countryCode) {
        return getService().countByCountryCode(countryCode);
    }

    public static int countByCountryName(java.lang.String countryName) {
        return getService().countByCountryName(countryName);
    }

    public static int countByDescription(java.lang.String description) {
        return getService().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String code,
        java.lang.String name, java.lang.String description) {
        return getService().countByC_N_D(code, name, description);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_QUOCGIA(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator,
            start, end, obc);
    }

    public static CountryLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CountryLocalService is not set");
        }

        return _service;
    }

    public void setService(CountryLocalService service) {
        _service = service;
    }
}
