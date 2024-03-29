package com.sgs.portlet.pmllevelsend.service;


/**
 * <a href="PmlEdmLevelSendLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pmllevelsend.service.impl.PmlEdmLevelSendLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil
 *
 */
public interface PmlEdmLevelSendLocalService {
    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend addPmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend createPmlEdmLevelSend(
        int levelSendId);

    public void deletePmlEdmLevelSend(int levelSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend getPmlEdmLevelSend(
        int levelSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> getPmlEdmLevelSends(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmLevelSendsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend updatePmlEdmLevelSend(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo();

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypeWithPmlEdmDocumentRecordType(
        int documentRecordTypeId);

    public java.lang.String getNumberDocumentReceipt(long documentRecordId);

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> getAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendIds(
        java.util.List<Integer> levelSendIds) throws java.lang.Exception;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlEdmLevelSend(int levelSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
