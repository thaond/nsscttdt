package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmLevelSendDetailLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmLevelSendDetailLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil
 *
 */
public interface PmlEdmLevelSendDetailLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail addPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail createPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK);

    public void deletePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail getPmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> getPmlEdmLevelSendDetails(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmLevelSendDetailsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail updatePmlEdmLevelSendDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> getAll()
        throws com.liferay.portal.SystemException;

    public boolean addPmlEdmLevelSendDetailList(
        java.lang.String levelSendIdList, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public boolean updatePmlEdmLevelSendDetailList(
        java.lang.String levelSendIdList, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public boolean hasLevelSend(int levelSendId, java.lang.String issuingPlaceId);
}
