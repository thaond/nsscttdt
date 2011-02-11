package com.sgs.portlet.pmlissuingplace.service;


/**
 * <a href="PmlEdmIssuingPlaceLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pmlissuingplace.service.impl.PmlEdmIssuingPlaceLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil
 *
 */
public interface PmlEdmIssuingPlaceLocalService {
    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace addPmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace createPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId);

    public void deletePmlEdmIssuingPlace(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace getPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlaces(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmIssuingPlacesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace addPmlEdmIssuingPlace(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        java.lang.String note, java.lang.String signer)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceIds(
        java.util.List<String> issuingPlaceIds) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords2(
        java.lang.String keywords) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId) throws java.lang.Exception;

    public void removePmlEdmIssuingPlace(java.lang.String issuingPlaceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public int searchCountIssuingPlace(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountIssuingPlace(java.lang.String codes,
        java.lang.String names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> searchIssuingPlace(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> searchIssuingPlace(
        java.lang.String codes, java.lang.String names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        java.lang.String signer) throws com.liferay.portal.SystemException;
}
