package com.nss.portlet.qa_chu_de.service;


/**
 * <a href="QAChuDeCauHoiLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService
 *
 */
public class QAChuDeCauHoiLocalServiceUtil {
    private static QAChuDeCauHoiLocalService _service;

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi addQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getService().addQAChuDeCauHoi(qaChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi createQAChuDeCauHoi(
        long maChuDeCauHoi) {
        return getService().createQAChuDeCauHoi(maChuDeCauHoi);
    }

    public static void deleteQAChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteQAChuDeCauHoi(maChuDeCauHoi);
    }

    public static void deleteQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        getService().deleteQAChuDeCauHoi(qaChuDeCauHoi);
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

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi getQAChuDeCauHoi(
        long maChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getQAChuDeCauHoi(maChuDeCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> getQAChuDeCauHois(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getQAChuDeCauHois(start, end);
    }

    public static int getQAChuDeCauHoisCount()
        throws com.liferay.portal.SystemException {
        return getService().getQAChuDeCauHoisCount();
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getService().updateQAChuDeCauHoi(qaChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateQAChuDeCauHoi(qaChuDeCauHoi, merge);
    }

    public static int countChuDeCauHoi(java.lang.String tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().countChuDeCauHoi(tenChuDeCauHoi, andOperator);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findChuDeCauHoi(tenChuDeCauHoi, andOperator, start, end, obc);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi addQAChuDeCauHoi(
        java.lang.String tenChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addQAChuDeCauHoi(tenChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        long maChuDeCauHoi, java.lang.String tenChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateQAChuDeCauHoi(maChuDeCauHoi, tenChuDeCauHoi);
    }

    public static QAChuDeCauHoiLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("QAChuDeCauHoiLocalService is not set");
        }

        return _service;
    }

    public void setService(QAChuDeCauHoiLocalService service) {
        _service = service;
    }
}
