package com.nss.portlet.digitalsignature.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="SignatureLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.digitalsignature.service.impl.SignatureLocalServiceImpl</code>.
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
 * @see com.nss.portlet.digitalsignature.service.SignatureLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface SignatureLocalService {
    public com.nss.portlet.digitalsignature.model.Signature addSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Signature createSignature(
        long signatureId);

    public void deleteSignature(long signatureId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.digitalsignature.model.Signature getSignature(
        long signatureId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.digitalsignature.model.Signature> getSignatures(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getSignaturesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Signature updateSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Signature updateSignature(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException;
}
