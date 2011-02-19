package com.sgs.portlet.sovanbannoibo.service;


/**
 * <a href="SoLoaiVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.sovanbannoibo.service.impl.SoLoaiVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalServiceUtil
 *
 */
public interface SoLoaiVanBanNoiBoLocalService {
    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo addSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo createSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK);

    public void deleteSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo getSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> getSoLoaiVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getSoLoaiVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo updateSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;
}
