package com.sgs.portlet.pml_template.service;


/**
 * <a href="PmlTemplateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_template.service.impl.PmlTemplateLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pml_template.service.PmlTemplateLocalServiceUtil
 *
 */
public interface PmlTemplateLocalService {
    public com.sgs.portlet.pml_template.model.PmlTemplate addPmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate createPmlTemplate(
        long templateId);

    public void deletePmlTemplate(long templateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate getPmlTemplate(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> getPmlTemplates(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlTemplatesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate updatePmlTemplate(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> search(
        java.lang.String type, java.lang.String valueType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String type, java.lang.String valueType)
        throws com.liferay.portal.SystemException;
}
