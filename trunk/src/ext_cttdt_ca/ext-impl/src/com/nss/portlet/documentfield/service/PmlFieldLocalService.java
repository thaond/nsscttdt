package com.nss.portlet.documentfield.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


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
 * <code>com.nss.portlet.documentfield.service.impl.PmlFieldLocalServiceImpl</code>.
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
 * @see com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlFieldLocalService {
    public com.nss.portlet.documentfield.model.PmlField addPmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.documentfield.model.PmlField createPmlField(
        java.lang.String fieldId);

    public void deletePmlField(java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.documentfield.model.PmlField getPmlField(
        java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.documentfield.model.PmlField> getPmlFields(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlFieldsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.documentfield.model.PmlField updatePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.documentfield.model.PmlField updatePmlField(
        com.nss.portlet.documentfield.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String fieldCode,
        java.lang.String fieldName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.documentfield.model.PmlField> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.documentfield.model.PmlField> search(
        java.lang.String fieldCode, java.lang.String fieldName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlField(java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.documentfield.model.PmlField addPmlField(
        java.lang.String fieldCode, java.lang.String fieldName,
        java.lang.String departmentsId, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.documentfield.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;
}
