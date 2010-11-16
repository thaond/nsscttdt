package com.nss.portlet.digitalsignature.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="DigitalSignatureLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.digitalsignature.service.impl.DigitalSignatureLocalServiceImpl</code>.
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
 * @see com.nss.portlet.digitalsignature.service.DigitalSignatureLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DigitalSignatureLocalService {
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public byte[] hash(java.io.InputStream inputStream,
        java.lang.String algorithm) throws java.lang.Exception;

    public byte[] sign(java.security.PrivateKey privateKey, byte[] hashValue)
        throws java.security.GeneralSecurityException;

    public boolean verysign(java.security.PublicKey publicKey,
        byte[] hashValue, byte[] signature)
        throws java.security.GeneralSecurityException;
}
