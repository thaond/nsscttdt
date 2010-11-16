package com.nss.portlet.digitalsignature.service;


/**
 * <a href="SignatureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.digitalsignature.service.SignatureLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.SignatureLocalService
 *
 */
public class SignatureLocalServiceUtil {
    private static SignatureLocalService _service;

    public static com.nss.portlet.digitalsignature.model.Signature addSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException {
        return getService().addSignature(signature);
    }

    public static com.nss.portlet.digitalsignature.model.Signature createSignature(
        long signatureId) {
        return getService().createSignature(signatureId);
    }

    public static void deleteSignature(long signatureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSignature(signatureId);
    }

    public static void deleteSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException {
        getService().deleteSignature(signature);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.nss.portlet.digitalsignature.model.Signature getSignature(
        long signatureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSignature(signatureId);
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> getSignatures(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSignatures(start, end);
    }

    public static int getSignaturesCount()
        throws com.liferay.portal.SystemException {
        return getService().getSignaturesCount();
    }

    public static com.nss.portlet.digitalsignature.model.Signature updateSignature(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException {
        return getService().updateSignature(signature);
    }

    public static com.nss.portlet.digitalsignature.model.Signature updateSignature(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateSignature(signature, merge);
    }

    public static SignatureLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("SignatureLocalService is not set");
        }

        return _service;
    }

    public void setService(SignatureLocalService service) {
        _service = service;
    }
}
