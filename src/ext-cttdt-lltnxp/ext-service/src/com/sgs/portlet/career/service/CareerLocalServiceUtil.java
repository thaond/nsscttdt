package com.sgs.portlet.career.service;


/**
 * <a href="CareerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.career.service.CareerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.service.CareerLocalService
 *
 */
public class CareerLocalServiceUtil {
    private static CareerLocalService _service;

    public static com.sgs.portlet.career.model.Career addCareer(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException {
        return getService().addCareer(career);
    }

    public static com.sgs.portlet.career.model.Career createCareer(
        java.lang.String careerId) {
        return getService().createCareer(careerId);
    }

    public static void deleteCareer(java.lang.String careerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCareer(careerId);
    }

    public static void deleteCareer(com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException {
        getService().deleteCareer(career);
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

    public static com.sgs.portlet.career.model.Career getCareer(
        java.lang.String careerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCareer(careerId);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> getCareers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCareers(start, end);
    }

    public static int getCareersCount()
        throws com.liferay.portal.SystemException {
        return getService().getCareersCount();
    }

    public static com.sgs.portlet.career.model.Career updateCareer(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException {
        return getService().updateCareer(career);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_NGHENGHIEP(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTEN_MA_NGHENGHIEP(code, name, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findTEN_MA_NGHENGHIEP(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_NGHENGHIEP(code, name, des, andOperator, start,
            end, obc);
    }

    public static com.sgs.portlet.career.model.Career addCareer(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addCareer(careerCode, careerName, description, active);
    }

    public static com.sgs.portlet.career.model.Career updateCareer(
        java.lang.String careerId, java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateCareer(careerId, careerCode, careerName, description,
            active);
    }

    public static CareerLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CareerLocalService is not set");
        }

        return _service;
    }

    public void setService(CareerLocalService service) {
        _service = service;
    }
}
