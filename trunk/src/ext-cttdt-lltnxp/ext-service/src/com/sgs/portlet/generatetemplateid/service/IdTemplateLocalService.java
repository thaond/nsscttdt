package com.sgs.portlet.generatetemplateid.service;


/**
 * <a href="IdTemplateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.generatetemplateid.service.impl.IdTemplateLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil
 *
 */
public interface IdTemplateLocalService {
    public com.sgs.portlet.generatetemplateid.model.IdTemplate addIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdTemplate createIdTemplate(
        long templateId);

    public void deleteIdTemplate(long templateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdTemplate getIdTemplate(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> getIdTemplates(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getIdTemplatesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdTemplate updateIdTemplate(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String format, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdTemplate> search(
        java.lang.String format, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
