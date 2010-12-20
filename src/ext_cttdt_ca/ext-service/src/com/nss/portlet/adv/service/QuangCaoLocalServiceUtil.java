package com.nss.portlet.adv.service;


/**
 * <a href="QuangCaoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.adv.service.QuangCaoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.service.QuangCaoLocalService
 *
 */
public class QuangCaoLocalServiceUtil {
    private static QuangCaoLocalService _service;

    public static com.nss.portlet.adv.model.QuangCao addQuangCao(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException {
        return getService().addQuangCao(quangCao);
    }

    public static com.nss.portlet.adv.model.QuangCao createQuangCao(
        long maQuangCao) {
        return getService().createQuangCao(maQuangCao);
    }

    public static void deleteQuangCao(long maQuangCao)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteQuangCao(maQuangCao);
    }

    public static void deleteQuangCao(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException {
        getService().deleteQuangCao(quangCao);
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

    public static com.nss.portlet.adv.model.QuangCao getQuangCao(
        long maQuangCao)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getQuangCao(maQuangCao);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> getQuangCaos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getQuangCaos(start, end);
    }

    public static int getQuangCaosCount()
        throws com.liferay.portal.SystemException {
        return getService().getQuangCaosCount();
    }

    public static com.nss.portlet.adv.model.QuangCao updateQuangCao(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException {
        return getService().updateQuangCao(quangCao);
    }

    public static com.nss.portlet.adv.model.QuangCao updateQuangCao(
        com.nss.portlet.adv.model.QuangCao quangCao, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateQuangCao(quangCao, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static QuangCaoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("QuangCaoLocalService is not set");
        }

        return _service;
    }

    public void setService(QuangCaoLocalService service) {
        _service = service;
    }
}
