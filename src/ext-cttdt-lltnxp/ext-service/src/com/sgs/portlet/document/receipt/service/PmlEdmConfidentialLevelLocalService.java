package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmConfidentialLevelLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmConfidentialLevelLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil
 *
 */
public interface PmlEdmConfidentialLevelLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel addPmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel createPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId);

    public void deletePmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel getPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> getPmlEdmConfidentialLevels(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmConfidentialLevelsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updatePmlEdmConfidentialLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel addPmlEdmConfidentialLevel(
        java.lang.String confidentialLevelName, int confidentialLevelSymbol,
        boolean limitViewDetail, boolean haveProcess)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updatePmlEdmConfidentialLevel(
        java.lang.String confidentialLevelId,
        java.lang.String confidentialLevelName, int confidentialLevelSymbol,
        boolean limitViewDetail, boolean haveProcess)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
