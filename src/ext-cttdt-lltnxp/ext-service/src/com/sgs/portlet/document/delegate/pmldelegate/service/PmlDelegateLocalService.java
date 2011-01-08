package com.sgs.portlet.document.delegate.pmldelegate.service;


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
 * <code>com.sgs.portlet.document.delegate.pmldelegate.service.impl.PmlDelegateLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalServiceUtil
 *
 */
public interface PmlDelegateLocalService {
    public com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate addPmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate createPmlDelegate(
        long delegateId);

    public void deletePmlDelegate(long delegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate getPmlDelegate(
        long delegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getPmlDelegates(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDelegatesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate updatePmlDelegate(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getListDelegateByDefault();

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getListHadDelegate();

    public boolean checkDelegatedByTime(long userId,
        java.lang.String fileTypeId, java.util.Date date)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException;

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> getByReceive_StartDate_CancelDate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate)
        throws com.liferay.portal.SystemException;

    public int searchCount() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> search(
        int start, int end) throws com.liferay.portal.SystemException;
}
