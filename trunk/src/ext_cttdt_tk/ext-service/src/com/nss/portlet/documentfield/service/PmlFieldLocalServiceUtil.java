package com.nss.portlet.documentfield.service;


/**
 * <a href="PmlFieldLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.documentfield.service.PmlFieldLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.documentfield.service.PmlFieldLocalService
 *
 */
public class PmlFieldLocalServiceUtil {
    private static PmlFieldLocalService _service;

    public static com.nss.portlet.documentfield.model.PmlField addPmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException {
        return getService().addPmlField(pmlField);
    }

    public static com.nss.portlet.documentfield.model.PmlField createPmlField(
        java.lang.String fieldId) {
        return getService().createPmlField(fieldId);
    }

    public static void deletePmlField(java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlField(fieldId);
    }

    public static void deletePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException {
        getService().deletePmlField(pmlField);
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

    public static com.nss.portlet.documentfield.model.PmlField getPmlField(
        java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlField(fieldId);
    }

    public static java.util.List<com.nss.portlet.documentfield.model.PmlField> getPmlFields(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFields(start, end);
    }

    public static int getPmlFieldsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFieldsCount();
    }

    public static com.nss.portlet.documentfield.model.PmlField updatePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlField(pmlField);
    }

    public static com.nss.portlet.documentfield.model.PmlField updatePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlField(pmlField, merge);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String fieldCode,
        java.lang.String fieldName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(fieldCode, fieldName, andOperator);
    }

    public static java.util.List<com.nss.portlet.documentfield.model.PmlField> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.documentfield.model.PmlField> search(
        java.lang.String fieldCode, java.lang.String fieldName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(fieldCode, fieldName, andOperator, start, end, obc);
    }

    public static void removePmlField(java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlField(fieldId);
    }

    public static com.nss.portlet.documentfield.model.PmlField addPmlField(
        java.lang.String fieldCode, java.lang.String fieldName,
        java.lang.String departmentsId, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addPmlField(fieldCode, fieldName, departmentsId,
            description, active);
    }

    public static java.util.List<com.nss.portlet.documentfield.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().findByDepartmentsId(departmentsId);
    }

    public static PmlFieldLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlFieldLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFieldLocalService service) {
        _service = service;
    }
}
