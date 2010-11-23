package com.nss.portlet.journalworkflow.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="InstanceBeanLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journalworkflow.service.impl.InstanceBeanLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.InstanceBeanLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface InstanceBeanLocalService {
    public com.nss.portlet.journalworkflow.model.InstanceBean addInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean createInstanceBean(
        long processInstanceId);

    public void deleteInstanceBean(long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journalworkflow.model.InstanceBean getInstanceBean(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> getInstanceBeans(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getInstanceBeansCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean updateInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean updateInstanceBean(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getInstanceId(
        com.liferay.portlet.journal.model.JournalArticle article);

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish);
}
