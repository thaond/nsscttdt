package com.sgs.portlet.signer.service;


/**
 * <a href="SignerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.signer.service.SignerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.service.SignerLocalService
 *
 */
public class SignerLocalServiceUtil {
    private static SignerLocalService _service;

    public static com.sgs.portlet.signer.model.Signer addSigner(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException {
        return getService().addSigner(signer);
    }

    public static com.sgs.portlet.signer.model.Signer createSigner(
        long signerId) {
        return getService().createSigner(signerId);
    }

    public static void deleteSigner(long signerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSigner(signerId);
    }

    public static void deleteSigner(com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException {
        getService().deleteSigner(signer);
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

    public static com.sgs.portlet.signer.model.Signer getSigner(long signerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSigner(signerId);
    }

    public static java.util.List<com.sgs.portlet.signer.model.Signer> getSigners(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSigners(start, end);
    }

    public static int getSignersCount()
        throws com.liferay.portal.SystemException {
        return getService().getSignersCount();
    }

    public static com.sgs.portlet.signer.model.Signer updateSigner(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException {
        return getService().updateSigner(signer);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(lastName, firstName, andOperator);
    }

    public static java.util.List<com.liferay.portal.model.User> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> search(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(lastName, firstName, andOperator, start, end, obc);
    }

    public static int searchCountAfterChecked(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountAfterChecked(keywords);
    }

    public static int searchCountAfterChecked(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCountAfterChecked(lastName, firstName, andOperator);
    }

    public static java.util.List<com.liferay.portal.model.User> searchAfterChecked(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchAfterChecked(keywords, start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> searchAfterChecked(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchAfterChecked(lastName, firstName, andOperator, start,
            end, obc);
    }

    public static boolean hasSigner(long userId) {
        return getService().hasSigner(userId);
    }

    public static java.util.List<com.sgs.portlet.signer.model.Signer> getAll()
        throws com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static com.sgs.portlet.signer.model.Signer addSigner(long userId)
        throws com.liferay.portal.SystemException {
        return getService().addSigner(userId);
    }

    public static boolean removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getService().removeByUserId(userId);
    }

    public static SignerLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("SignerLocalService is not set");
        }

        return _service;
    }

    public void setService(SignerLocalService service) {
        _service = service;
    }
}
