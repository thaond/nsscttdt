package com.nss.portlet.qa_cau_tra_loi.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="CauTraLoiQALocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.qa_cau_tra_loi.service.impl.CauTraLoiQALocalServiceImpl</code>.
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
 * @see com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CauTraLoiQALocalService {
    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA addCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA createCauTraLoiQA(
        long maCauTraLoiQA);

    public void deleteCauTraLoiQA(long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA getCauTraLoiQA(
        long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> getCauTraLoiQAs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCauTraLoiQAsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateCauTraLoiQA(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoi(
        long maCauHoi);

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoi_Publish(
        long maCauHoi);
}
