package com.sgs.portlet.documentdelegate.service;


/**
 * <a href="PmlDocumentDelegateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.documentdelegate.service.impl.PmlDocumentDelegateLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalServiceUtil
 *
 */
public interface PmlDocumentDelegateLocalService {
    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate addPmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate createPmlDocumentDelegate(
        long documentDelegateId);

    public void deletePmlDocumentDelegate(long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate getPmlDocumentDelegate(
        long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> getPmlDocumentDelegates(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDocumentDelegatesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate updatePmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> getPmlDocumentDelegate_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc);

    public int countPmlDocumentDelegate_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate);
}
