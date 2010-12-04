package com.nss.portlet.position.service;


/**
 * <a href="PositionLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.position.service.PositionLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.service.PositionLocalService
 *
 */
public class PositionLocalServiceUtil {
    private static PositionLocalService _service;

    public static com.nss.portlet.position.model.Position addPosition(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException {
        return getService().addPosition(position);
    }

    public static com.nss.portlet.position.model.Position createPosition(
        java.lang.String positionId) {
        return getService().createPosition(positionId);
    }

    public static void deletePosition(java.lang.String positionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePosition(positionId);
    }

    public static void deletePosition(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException {
        getService().deletePosition(position);
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

    public static com.nss.portlet.position.model.Position getPosition(
        java.lang.String positionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPosition(positionId);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> getPositions(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPositions(start, end);
    }

    public static int getPositionsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPositionsCount();
    }

    public static com.nss.portlet.position.model.Position updatePosition(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException {
        return getService().updatePosition(position);
    }

    public static com.nss.portlet.position.model.Position updatePosition(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePosition(position, merge);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> find_CODE_NAME_DESCRIPTION(
        java.lang.String code, java.lang.String name,
        java.lang.String description, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .find_CODE_NAME_DESCRIPTION(code, name, description,
            andOperator, start, end, obc);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int count_CODE_NAME_DESCRIPTION(java.lang.String code,
        java.lang.String name, java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .count_CODE_NAME_DESCRIPTION(code, name, description,
            andOperator);
    }

    public static void removePosition(java.lang.String positionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePosition(positionId);
    }

    public static com.nss.portlet.position.model.Position addPosition(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addPosition(positionCode, positionName, description, active);
    }

    public static com.nss.portlet.position.model.Position updatePosition(
        java.lang.String positionId, java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updatePosition(positionId, positionCode, positionName,
            description, active);
    }

    public static PositionLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PositionLocalService is not set");
        }

        return _service;
    }

    public void setService(PositionLocalService service) {
        _service = service;
    }
}
