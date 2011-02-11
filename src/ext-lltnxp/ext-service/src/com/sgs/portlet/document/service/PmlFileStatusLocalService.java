package com.sgs.portlet.document.service;


/**
 * <a href="PmlFileStatusLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlFileStatusLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil
 *
 */
public interface PmlFileStatusLocalService {
    public com.sgs.portlet.document.model.PmlFileStatus addPmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus createPmlFileStatus(
        long fileStatusId);

    public void deletePmlFileStatus(long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus getPmlFileStatus(
        long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> getPmlFileStatuses(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFileStatusesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus updatePmlFileStatus(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByType(
        java.lang.String type) throws com.liferay.portal.SystemException;

    public int searchCountCV(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountCV(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchCV(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchCV(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCountMC(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountMC(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchMC(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> searchMC(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeFileStatus(long fileStatusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus addFileStatus(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        java.lang.String description, java.lang.String active,
        java.lang.String type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus updateFileStatus(
        long fileStatusId, java.lang.String fileStatusCode,
        java.lang.String fileStatusName, java.lang.String description,
        java.lang.String active, java.lang.String type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
