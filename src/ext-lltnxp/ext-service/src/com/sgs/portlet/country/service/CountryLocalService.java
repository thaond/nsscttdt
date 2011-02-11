package com.sgs.portlet.country.service;


/**
 * <a href="CountryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.country.service.impl.CountryLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.service.CountryLocalServiceUtil
 *
 */
public interface CountryLocalService {
    public com.sgs.portlet.country.model.Country addCountry(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country createCountry(
        java.lang.String countryId);

    public void deleteCountry(java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCountry(com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country getCountry(
        java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.country.model.Country> getCountries(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getCountriesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country updateCountry(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode);

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName);

    public java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description);

    public java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active);

    public java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String code, java.lang.String name,
        java.lang.String description);

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end);

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end);

    public java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end);

    public java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end);

    public java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String code, java.lang.String name,
        java.lang.String description, int start, int end);

    public int countByCountryCode(java.lang.String countryCode);

    public int countByCountryName(java.lang.String countryName);

    public int countByDescription(java.lang.String description);

    public int countByC_N_D(java.lang.String code, java.lang.String name,
        java.lang.String description);

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_QUOCGIA(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
