package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="LogVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.vanbannoibo.service.impl.LogVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalServiceUtil
 *
 */
public interface LogVanBanNoiBoLocalService {
    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo addLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo createLogVanBanNoiBo(
        long logVanBanNoiBoId);

    public void deleteLogVanBanNoiBo(long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo getLogVanBanNoiBo(
        long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> getLogVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getLogVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo updateLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException;
}
