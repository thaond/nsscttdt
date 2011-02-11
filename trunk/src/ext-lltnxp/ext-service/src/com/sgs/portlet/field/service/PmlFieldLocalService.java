package com.sgs.portlet.field.service;


/**
 * <a href="PmlFieldLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.field.service.impl.PmlFieldLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.field.service.PmlFieldLocalServiceUtil
 *
 */
public interface PmlFieldLocalService {
    public com.sgs.portlet.field.model.PmlField addPmlField(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField createPmlField(
        java.lang.String fieldId);

    public void deletePmlField(java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlField(com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField getPmlField(
        java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> getPmlFields(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFieldsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField updatePmlField(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String fieldCode,
        java.lang.String fieldName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> search(
        java.lang.String fieldCode, java.lang.String fieldName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAgency(java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField addPmlField(
        java.lang.String fieldCode, java.lang.String fieldName,
        java.lang.String departmentsId, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
