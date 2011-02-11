package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmPrivilegeLevelLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService
 *
 */
public class PmlEdmPrivilegeLevelLocalServiceUtil {
    private static PmlEdmPrivilegeLevelLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel addPmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmPrivilegeLevel(pmlEdmPrivilegeLevel);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel createPmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId) {
        return getService().createPmlEdmPrivilegeLevel(privilegeLevelId);
    }

    public static void deletePmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmPrivilegeLevel(privilegeLevelId);
    }

    public static void deletePmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmPrivilegeLevel(pmlEdmPrivilegeLevel);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel getPmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmPrivilegeLevel(privilegeLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> getPmlEdmPrivilegeLevels(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmPrivilegeLevels(start, end);
    }

    public static int getPmlEdmPrivilegeLevelsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmPrivilegeLevelsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel updatePmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmPrivilegeLevel(pmlEdmPrivilegeLevel);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static void removePmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmPrivilegeLevel(privilegeLevelId);
    }

    public static PmlEdmPrivilegeLevelLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmPrivilegeLevelLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmPrivilegeLevelLocalService service) {
        _service = service;
    }
}
