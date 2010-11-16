package com.nss.portlet.qa_cau_hoi.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="CauHoiQALocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.qa_cau_hoi.service.impl.CauHoiQALocalServiceImpl</code>.
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
 * @see com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CauHoiQALocalService {
    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA addCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA createCauHoiQA(
        long maCauHoiQA);

    public void deleteCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA getCauHoiQA(
        long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> getCauHoiQAs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCauHoiQAsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateCauHoiQA(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByTieuDe_ChuDe(long maChuDeCauHoi, java.lang.String name,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String name,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi);
}
