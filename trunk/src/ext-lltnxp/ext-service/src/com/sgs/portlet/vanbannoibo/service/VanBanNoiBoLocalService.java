package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="VanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.vanbannoibo.service.impl.VanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalServiceUtil
 *
 */
public interface VanBanNoiBoLocalService {
    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo addVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo createVanBanNoiBo(
        long vanBanNoiBoId);

    public void deleteVanBanNoiBo(long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo getVanBanNoiBo(
        long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> getVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getVanBanNoiBosCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> getVanBanNoiBoByYear(
        int year) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long idVanBanNoiBo) throws com.liferay.portal.SystemException;

    public void reIndex(long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo addVanBanNoiBo(
        long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateVanBanNoiBo(
        long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deleteVanBanNoiBo(long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deleteVanBanNoiBo(long companyId, long vanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;
}
