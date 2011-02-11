package com.sgs.portlet.signer.service;


/**
 * <a href="SignerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.signer.service.impl.SignerLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.signer.service.SignerLocalServiceUtil
 *
 */
public interface SignerLocalService {
    public com.sgs.portlet.signer.model.Signer addSigner(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer createSigner(long signerId);

    public void deleteSigner(long signerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSigner(com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer getSigner(long signerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.signer.model.Signer> getSigners(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getSignersCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer updateSigner(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> search(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCountAfterChecked(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountAfterChecked(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> searchAfterChecked(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> searchAfterChecked(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public boolean hasSigner(long userId);

    public java.util.List<com.sgs.portlet.signer.model.Signer> getAll()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer addSigner(long userId)
        throws com.liferay.portal.SystemException;

    public boolean removeByUserId(long userId)
        throws com.liferay.portal.SystemException;
}
