package com.sgs.portlet.pml_do_quan_trong.service;


/**
 * <a href="PmlDoQuanTrongLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService
 *
 */
public class PmlDoQuanTrongLocalServiceUtil {
    private static PmlDoQuanTrongLocalService _service;

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDoQuanTrong(pmlDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong createPmlDoQuanTrong(
        long idDoQuanTrong) {
        return getService().createPmlDoQuanTrong(idDoQuanTrong);
    }

    public static void deletePmlDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDoQuanTrong(idDoQuanTrong);
    }

    public static void deletePmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDoQuanTrong(pmlDoQuanTrong);
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

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong getPmlDoQuanTrong(
        long idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDoQuanTrong(idDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> getPmlDoQuanTrongs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDoQuanTrongs(start, end);
    }

    public static int getPmlDoQuanTrongsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDoQuanTrongsCount();
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDoQuanTrong(pmlDoQuanTrong);
    }

    public static int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(andOperator, start, end, obc);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addPmlDoQuanTrong(tenDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updatePmlDoQuanTrong(idDoQuanTrong, tenDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static void removePmlDoQuanTrong(java.lang.String idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlDoQuanTrong(idDoQuanTrong);
    }

    public static PmlDoQuanTrongLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlDoQuanTrongLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDoQuanTrongLocalService service) {
        _service = service;
    }
}
