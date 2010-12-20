package com.nss.portlet.delegate.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlFileTypeDelegateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.delegate.service.impl.PmlFileTypeDelegateLocalServiceImpl</code>.
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
 * @see com.nss.portlet.delegate.service.PmlFileTypeDelegateLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlFileTypeDelegateLocalService {
    public com.nss.portlet.delegate.model.PmlFileTypeDelegate addPmlFileTypeDelegate(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate createPmlFileTypeDelegate(
        long fileTypeDelegateId);

    public void deletePmlFileTypeDelegate(long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileTypeDelegate(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.delegate.model.PmlFileTypeDelegate getPmlFileTypeDelegate(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> getPmlFileTypeDelegates(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlFileTypeDelegatesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate updatePmlFileTypeDelegate(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate updatePmlFileTypeDelegate(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId) throws com.liferay.portal.SystemException;
}
