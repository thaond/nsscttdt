package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="LoaiVanBanNoiBoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.loaivanbannoibo.service.impl.LoaiVanBanNoiBoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil
 *
 */
public interface LoaiVanBanNoiBoLocalService {
    public com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo addLoaiVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo createLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId);

    public void deleteLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLoaiVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo getLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> getLoaiVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getLoaiVanBanNoiBosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo updateLoaiVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    public int countByKeyword(java.lang.String keyword)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findByKeyword(
        java.lang.String keyword, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countLoaiVanBanNoiBo(java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findLoaiVanBanNoiBo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
