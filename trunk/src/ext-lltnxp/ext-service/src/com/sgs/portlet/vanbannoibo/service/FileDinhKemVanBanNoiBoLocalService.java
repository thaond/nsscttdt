package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="FileDinhKemVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.vanbannoibo.service.impl.FileDinhKemVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalServiceUtil
 *
 */
public interface FileDinhKemVanBanNoiBoLocalService {
    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo addFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo createFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId);

    public void deleteFileDinhKemVanBanNoiBo(long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo getFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getFileDinhKemVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo updateFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException;
}
