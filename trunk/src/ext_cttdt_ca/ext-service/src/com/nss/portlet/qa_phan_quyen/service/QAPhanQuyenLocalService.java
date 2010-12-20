package com.nss.portlet.qa_phan_quyen.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="QAPhanQuyenLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.qa_phan_quyen.service.impl.QAPhanQuyenLocalServiceImpl</code>.
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
 * @see com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface QAPhanQuyenLocalService {
    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen addQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen createQAPhanQuyen(
        long maPhanQuyen);

    public void deleteQAPhanQuyen(long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen getQAPhanQuyen(
        long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> getQAPhanQuyens(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getQAPhanQuyensCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateQAPhanQuyen(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi(
        long maChuDeCauHoi);

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi);

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi);
}
