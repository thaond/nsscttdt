package com.sgs.portlet.citymanagement.service;


/**
 * <a href="CityLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.citymanagement.service.impl.CityLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.citymanagement.service.CityLocalServiceUtil
 *
 */
public interface CityLocalService {
    public com.sgs.portlet.citymanagement.model.City addCity(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City createCity(
        java.lang.String cityID);

    public void deleteCity(java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCity(com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City getCity(
        java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> getCities(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getCitiesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City updateCity(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_THANH_PHO(java.lang.String cityCode,
        java.lang.String cityName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String cityCode, java.lang.String cityName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAgency(java.lang.String cityId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City addCity(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, java.lang.String active,
        java.lang.String countryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City updateCity(
        java.lang.String cityId, java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
