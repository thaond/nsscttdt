package com.sgs.portlet.document.service;


/**
 * <a href="PmlProcessDisposeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlProcessDisposeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlProcessDisposeLocalServiceUtil
 *
 */
public interface PmlProcessDisposeLocalService {
    public com.sgs.portlet.document.model.PmlProcessDispose addPmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose createPmlProcessDispose(
        long processDisposeId);

    public void deletePmlProcessDispose(long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose getPmlProcessDispose(
        long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getPmlProcessDisposes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlProcessDisposesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose updatePmlProcessDispose(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException;
}
