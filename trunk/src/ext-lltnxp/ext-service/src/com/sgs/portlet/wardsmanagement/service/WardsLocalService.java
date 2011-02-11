package com.sgs.portlet.wardsmanagement.service;


/**
 * <a href="WardsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.wardsmanagement.service.impl.WardsLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil
 *
 */
public interface WardsLocalService {
    public com.sgs.portlet.wardsmanagement.model.Wards addWards(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards createWards(
        java.lang.String wardsId);

    public void deleteWards(java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteWards(com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards getWards(
        java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> getWardses(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getWardsesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards updateWards(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_PHUONG(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String districtId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> search(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards addWard(
        java.lang.String wardCode, java.lang.String wardName,
        java.lang.String districtId, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards updateWard(
        java.lang.String wardId, java.lang.String wardCode,
        java.lang.String wardName, java.lang.String districtId,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
