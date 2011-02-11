package com.sgs.portlet.document.delegate.pmldelegate.service;


/**
 * <a href="PmlDelegateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService
 *
 */
public class PmlDelegateLocalServiceUtil {
    private static PmlDelegateLocalService _service;

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate addPmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDelegate(pmlDelegate);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate createPmlDelegate(
        long delegateId) {
        return getService().createPmlDelegate(delegateId);
    }

    public static void deletePmlDelegate(long delegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDelegate(delegateId);
    }

    public static void deletePmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDelegate(pmlDelegate);
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

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate getPmlDelegate(
        long delegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDelegate(delegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getPmlDelegates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDelegates(start, end);
    }

    public static int getPmlDelegatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDelegatesCount();
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate updatePmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDelegate(pmlDelegate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getListDelegateByDefault() {
        return getService().getListDelegateByDefault();
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getListHadDelegate() {
        return getService().getListHadDelegate();
    }

    public static boolean checkDelegatedByTime(long userId,
        java.lang.String fileTypeId, java.util.Date date)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getService().checkDelegatedByTime(userId, fileTypeId, date);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getByReceive_StartDate_EndDate(receiver, startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getByReceive_StartDate_CancelDate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getByReceive_StartDate_CancelDate(receiver, startDate,
            cancelDate);
    }

    public static int searchCount() throws com.liferay.portal.SystemException {
        return getService().searchCount();
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> search(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().search(start, end);
    }

    public static PmlDelegateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlDelegateLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDelegateLocalService service) {
        _service = service;
    }
}
