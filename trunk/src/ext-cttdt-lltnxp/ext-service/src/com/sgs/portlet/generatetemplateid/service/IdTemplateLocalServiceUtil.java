package com.sgs.portlet.generatetemplateid.service;


/**
 * <a href="IdTemplateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService
 *
 */
public class IdTemplateLocalServiceUtil {
    private static IdTemplateLocalService _service;

    public static com.sgs.portlet.generatetemplateid.model.IdTemplate addIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException {
        return getService().addIdTemplate(idTemplate);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdTemplate createIdTemplate(
        long templateId) {
        return getService().createIdTemplate(templateId);
    }

    public static void deleteIdTemplate(long templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteIdTemplate(templateId);
    }

    public static void deleteIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException {
        getService().deleteIdTemplate(idTemplate);
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

    public static com.sgs.portlet.generatetemplateid.model.IdTemplate getIdTemplate(
        long templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getIdTemplate(templateId);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> getIdTemplates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getIdTemplates(start, end);
    }

    public static int getIdTemplatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getIdTemplatesCount();
    }

    public static com.sgs.portlet.generatetemplateid.model.IdTemplate updateIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException {
        return getService().updateIdTemplate(idTemplate);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String format,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(format, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> search(
        java.lang.String format, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(format, des, andOperator, start, end, obc);
    }

    public static IdTemplateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("IdTemplateLocalService is not set");
        }

        return _service;
    }

    public void setService(IdTemplateLocalService service) {
        _service = service;
    }
}
