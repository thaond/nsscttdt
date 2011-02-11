package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service;


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
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.impl.PmlFileTypeDelegateLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalServiceUtil
 *
 */
public interface PmlFileTypeDelegateLocalService {
    public com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate addPmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate createPmlFileTypeDelegate(
        long fileTypeDelegateId);

    public void deletePmlFileTypeDelegate(long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate getPmlFileTypeDelegate(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> getPmlFileTypeDelegates(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFileTypeDelegatesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate updatePmlFileTypeDelegate(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;
}
