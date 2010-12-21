package com.nss.portlet.journalworkflow.service;


/**
 * <a href="InstanceBeanLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journalworkflow.service.InstanceBeanLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.InstanceBeanLocalService
 *
 */
public class InstanceBeanLocalServiceUtil {
    private static InstanceBeanLocalService _service;

    public static com.nss.portlet.journalworkflow.model.InstanceBean addInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException {
        return getService().addInstanceBean(instanceBean);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean createInstanceBean(
        long processInstanceId) {
        return getService().createInstanceBean(processInstanceId);
    }

    public static void deleteInstanceBean(long processInstanceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteInstanceBean(processInstanceId);
    }

    public static void deleteInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException {
        getService().deleteInstanceBean(instanceBean);
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

    public static com.nss.portlet.journalworkflow.model.InstanceBean getInstanceBean(
        long processInstanceId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getInstanceBean(processInstanceId);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> getInstanceBeans(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getInstanceBeans(start, end);
    }

    public static int getInstanceBeansCount()
        throws com.liferay.portal.SystemException {
        return getService().getInstanceBeansCount();
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean updateInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException {
        return getService().updateInstanceBean(instanceBean);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean updateInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateInstanceBean(instanceBean, merge);
    }

    public static long getInstanceId(
        com.nss.portlet.journal.model.JournalArticle article) {
        return getService().getInstanceId(article);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish) {
        return getService().findByStatus_Finish(status, finish);
    }

    public static InstanceBeanLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("InstanceBeanLocalService is not set");
        }

        return _service;
    }

    public void setService(InstanceBeanLocalService service) {
        _service = service;
    }
}
