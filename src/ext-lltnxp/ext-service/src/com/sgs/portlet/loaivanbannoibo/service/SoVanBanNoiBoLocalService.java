package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="SoVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.loaivanbannoibo.service.impl.SoVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoLocalServiceUtil
 *
 */
public interface SoVanBanNoiBoLocalService {
    public com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo addSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo createSoVanBanNoiBo(
        long soVanBanNoiBoId);

    public void deleteSoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo getSoVanBanNoiBo(
        long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> getSoVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getSoVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo updateSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException;
}
