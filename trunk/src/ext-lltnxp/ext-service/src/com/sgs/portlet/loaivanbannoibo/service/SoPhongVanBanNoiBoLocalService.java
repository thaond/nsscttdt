package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="SoPhongVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.loaivanbannoibo.service.impl.SoPhongVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalServiceUtil
 *
 */
public interface SoPhongVanBanNoiBoLocalService {
    public com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo addSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo createSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK);

    public void deleteSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo getSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo> getSoPhongVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getSoPhongVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo updateSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;
}
