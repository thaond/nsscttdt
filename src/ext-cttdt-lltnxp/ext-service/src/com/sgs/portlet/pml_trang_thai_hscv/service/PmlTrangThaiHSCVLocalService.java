package com.sgs.portlet.pml_trang_thai_hscv.service;


/**
 * <a href="PmlTrangThaiHSCVLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.impl.PmlTrangThaiHSCVLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil
 *
 */
public interface PmlTrangThaiHSCVLocalService {
    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV createPmlTrangThaiHSCV(
        long idTrangThaiHSCV);

    public void deletePmlTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV getPmlTrangThaiHSCV(
        long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> getPmlTrangThaiHSCVs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlTrangThaiHSCVsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        long idTrangThaiHSCV, java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removePmlTrangThaiHSCV(java.lang.String idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
