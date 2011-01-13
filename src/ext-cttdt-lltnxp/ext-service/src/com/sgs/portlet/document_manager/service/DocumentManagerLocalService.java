package com.sgs.portlet.document_manager.service;


/**
 * <a href="DocumentManagerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document_manager.service.impl.DocumentManagerLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil
 *
 */
public interface DocumentManagerLocalService {
    public com.sgs.portlet.document_manager.model.DocumentManager addDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.DocumentManager createDocumentManager(
        long documentManagerId);

    public void deleteDocumentManager(long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.DocumentManager getDocumentManager(
        long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> getDocumentManagers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getDocumentManagersCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.DocumentManager updateDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long documentManagerId) throws com.liferay.portal.SystemException;

    public int countDocumentManager(java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findDocumentManager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
