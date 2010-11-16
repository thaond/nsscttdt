package com.nss.portlet.digitalsignature.service;


/**
 * <a href="CertificateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.digitalsignature.service.CertificateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.CertificateLocalService
 *
 */
public class CertificateLocalServiceUtil {
    private static CertificateLocalService _service;

    public static com.nss.portlet.digitalsignature.model.Certificate addCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException {
        return getService().addCertificate(certificate);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate createCertificate(
        long userId) {
        return getService().createCertificate(userId);
    }

    public static void deleteCertificate(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCertificate(userId);
    }

    public static void deleteCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException {
        getService().deleteCertificate(certificate);
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

    public static com.nss.portlet.digitalsignature.model.Certificate getCertificate(
        long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCertificate(userId);
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> getCertificates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCertificates(start, end);
    }

    public static int getCertificatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getCertificatesCount();
    }

    public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException {
        return getService().updateCertificate(certificate);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateCertificate(certificate, merge);
    }

    public static CertificateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CertificateLocalService is not set");
        }

        return _service;
    }

    public void setService(CertificateLocalService service) {
        _service = service;
    }
}
