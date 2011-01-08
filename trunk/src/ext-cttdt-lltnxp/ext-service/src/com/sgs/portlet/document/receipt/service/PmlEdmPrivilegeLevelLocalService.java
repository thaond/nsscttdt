package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmPrivilegeLevelLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmPrivilegeLevelLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil
 *
 */
public interface PmlEdmPrivilegeLevelLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel addPmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel createPmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId);

    public void deletePmlEdmPrivilegeLevel(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel getPmlEdmPrivilegeLevel(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> getPmlEdmPrivilegeLevels(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmPrivilegeLevelsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel updatePmlEdmPrivilegeLevel(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlEdmPrivilegeLevel(java.lang.String privilegeLevelId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
