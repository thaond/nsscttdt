package com.sgs.portlet.sovanbannoibo.service;


/**
 * <a href="LoaiVanBanNoiBoCuaSoLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.sovanbannoibo.service.impl.LoaiVanBanNoiBoCuaSoLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalServiceUtil
 *
 */
public interface LoaiVanBanNoiBoCuaSoLocalService {
    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo addLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo createLoaiVanBanNoiBoCuaSo(
        long loaiVanBanNoiBoId);

    public void deleteLoaiVanBanNoiBoCuaSo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo getLoaiVanBanNoiBoCuaSo(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> getLoaiVanBanNoiBoCuaSos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getLoaiVanBanNoiBoCuaSosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo updateLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException;

    public int countByKeyword(java.lang.String keyword)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findByKeyword(
        java.lang.String keyword, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countLoaiVanBanNoiBo(java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findLoaiVanBanNoiBo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
