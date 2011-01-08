package com.sgs.portlet.pml_template.service;


/**
 * <a href="FileTemplateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_template.service.FileTemplateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.FileTemplateLocalService
 *
 */
public class FileTemplateLocalServiceUtil {
    private static FileTemplateLocalService _service;

    public static com.sgs.portlet.pml_template.model.FileTemplate addFileTemplate(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException {
        return getService().addFileTemplate(fileTemplate);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate createFileTemplate(
        long fileTemplateId) {
        return getService().createFileTemplate(fileTemplateId);
    }

    public static void deleteFileTemplate(long fileTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFileTemplate(fileTemplateId);
    }

    public static void deleteFileTemplate(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException {
        getService().deleteFileTemplate(fileTemplate);
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

    public static com.sgs.portlet.pml_template.model.FileTemplate getFileTemplate(
        long fileTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFileTemplate(fileTemplateId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> getFileTemplates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getFileTemplates(start, end);
    }

    public static int getFileTemplatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getFileTemplatesCount();
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate updateFileTemplate(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException {
        return getService().updateFileTemplate(fileTemplate);
    }

    public static FileTemplateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("FileTemplateLocalService is not set");
        }

        return _service;
    }

    public void setService(FileTemplateLocalService service) {
        _service = service;
    }
}
