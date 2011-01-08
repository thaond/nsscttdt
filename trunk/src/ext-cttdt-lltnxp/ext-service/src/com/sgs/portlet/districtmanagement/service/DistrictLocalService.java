package com.sgs.portlet.districtmanagement.service;


/**
 * <a href="DistrictLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.districtmanagement.service.impl.DistrictLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil
 *
 */
public interface DistrictLocalService {
    public com.sgs.portlet.districtmanagement.model.District addDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District createDistrict(
        java.lang.String districtId);

    public void deleteDistrict(java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District getDistrict(
        java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> getDistricts(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getDistrictsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District updateDistrict(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_QUAN(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String cityId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> search(
        java.lang.String cityId, int start, int end)
        throws com.liferay.portal.SystemException;

    public void removeDistrict(java.lang.String districtId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District addDistrict(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District updateDistrict(
        java.lang.String districtId, java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
