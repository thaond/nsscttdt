package com.nss.portlet.delegate.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlDelegateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.delegate.service.impl.PmlDelegateLocalServiceImpl</code>.
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
 * @see com.nss.portlet.delegate.service.PmlDelegateLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlDelegateLocalService {
    public com.nss.portlet.delegate.model.PmlDelegate addPmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate createPmlDelegate(
        long delegateId);

    public void deletePmlDelegate(long delegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.delegate.model.PmlDelegate getPmlDelegate(
        long delegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> getPmlDelegates(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlDelegatesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate updatePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate updatePmlDelegate(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner(
        long assignerId) throws com.liferay.portal.SystemException;
}
