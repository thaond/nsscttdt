package com.nss.portlet.partner.service;


/**
 * <a href="PartnerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.partner.service.PartnerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.service.PartnerLocalService
 *
 */
public class PartnerLocalServiceUtil {
    private static PartnerLocalService _service;

    public static com.nss.portlet.partner.model.Partner addPartner(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException {
        return getService().addPartner(partner);
    }

    public static com.nss.portlet.partner.model.Partner createPartner(
        long maPartner) {
        return getService().createPartner(maPartner);
    }

    public static void deletePartner(long maPartner)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePartner(maPartner);
    }

    public static void deletePartner(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException {
        getService().deletePartner(partner);
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

    public static com.nss.portlet.partner.model.Partner getPartner(
        long maPartner)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPartner(maPartner);
    }

    public static java.util.List<com.nss.portlet.partner.model.Partner> getPartners(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPartners(start, end);
    }

    public static int getPartnersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPartnersCount();
    }

    public static com.nss.portlet.partner.model.Partner updatePartner(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException {
        return getService().updatePartner(partner);
    }

    public static com.nss.portlet.partner.model.Partner updatePartner(
        com.nss.portlet.partner.model.Partner partner, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePartner(partner, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static java.util.List<com.nss.portlet.partner.model.Partner> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static int countByTEN_MOTA(java.lang.String name,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByTEN_MOTA(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.partner.model.Partner> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static PartnerLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PartnerLocalService is not set");
        }

        return _service;
    }

    public void setService(PartnerLocalService service) {
        _service = service;
    }
}
