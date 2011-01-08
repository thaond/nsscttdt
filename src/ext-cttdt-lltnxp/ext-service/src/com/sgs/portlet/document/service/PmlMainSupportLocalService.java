package com.sgs.portlet.document.service;


/**
 * <a href="PmlMainSupportLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlMainSupportLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlMainSupportLocalServiceUtil
 *
 */
public interface PmlMainSupportLocalService {
    public com.sgs.portlet.document.model.PmlMainSupport addPmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport createPmlMainSupport(
        long processId);

    public void deletePmlMainSupport(long processId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport getPmlMainSupport(
        long processId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> getPmlMainSupports(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlMainSupportsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport updatePmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException;
}
