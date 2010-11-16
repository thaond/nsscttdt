package com.nss.portlet.digitalsignature.service;


/**
 * <a href="DigitalSignatureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService
 *
 */
public class DigitalSignatureLocalServiceUtil {
    private static DigitalSignatureLocalService _service;

    public static byte[] hash(java.io.InputStream inputStream,
        java.lang.String algorithm) throws java.lang.Exception {
        return getService().hash(inputStream, algorithm);
    }

    public static byte[] sign(java.security.PrivateKey privateKey,
        byte[] hashValue) throws java.security.GeneralSecurityException {
        return getService().sign(privateKey, hashValue);
    }

    public static boolean verysign(java.security.PublicKey publicKey,
        byte[] hashValue, byte[] signature)
        throws java.security.GeneralSecurityException {
        return getService().verysign(publicKey, hashValue, signature);
    }

    public static DigitalSignatureLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "DigitalSignatureLocalService is not set");
        }

        return _service;
    }

    public void setService(DigitalSignatureLocalService service) {
        _service = service;
    }
}
