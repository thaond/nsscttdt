package com.sgs.portlet.pml_template.service;


/**
 * <a href="PmlTemplateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_template.service.PmlTemplateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.PmlTemplateLocalService
 *
 */
public class PmlTemplateLocalServiceUtil {
    private static PmlTemplateLocalService _service;

    public static com.sgs.portlet.pml_template.model.PmlTemplate addPmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTemplate(pmlTemplate);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate createPmlTemplate(
        long templateId) {
        return getService().createPmlTemplate(templateId);
    }

    public static void deletePmlTemplate(long templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTemplate(templateId);
    }

    public static void deletePmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTemplate(pmlTemplate);
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

    public static com.sgs.portlet.pml_template.model.PmlTemplate getPmlTemplate(
        long templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTemplate(templateId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> getPmlTemplates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTemplates(start, end);
    }

    public static int getPmlTemplatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTemplatesCount();
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate updatePmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTemplate(pmlTemplate);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> search(
        java.lang.String type, java.lang.String valueType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(type, valueType, start, end, obc);
    }

    public static int searchCount(java.lang.String type,
        java.lang.String valueType) throws com.liferay.portal.SystemException {
        return getService().searchCount(type, valueType);
    }

    public static PmlTemplateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTemplateLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTemplateLocalService service) {
        _service = service;
    }
}
