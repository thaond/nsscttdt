package com.sgs.portlet.career.service;


/**
 * <a href="CareerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.career.service.impl.CareerLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.career.service.CareerLocalServiceUtil
 *
 */
public interface CareerLocalService {
    public com.sgs.portlet.career.model.Career addCareer(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career createCareer(
        java.lang.String careerId);

    public void deleteCareer(java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCareer(com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career getCareer(
        java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.career.model.Career> getCareers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getCareersCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career updateCareer(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_NGHENGHIEP(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findTEN_MA_NGHENGHIEP(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career addCareer(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career updateCareer(
        java.lang.String careerId, java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
