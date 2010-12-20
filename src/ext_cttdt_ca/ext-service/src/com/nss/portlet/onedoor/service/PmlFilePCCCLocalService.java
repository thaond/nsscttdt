package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlFilePCCCLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlFilePCCCLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlFilePCCCLocalService {
    public com.nss.portlet.onedoor.model.PmlFilePCCC addPmlFilePCCC(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC createPmlFilePCCC(
        java.lang.String fileId);

    public void deletePmlFilePCCC(java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFilePCCC(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlFilePCCC getPmlFilePCCC(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> getPmlFilePCCCs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlFilePCCCsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC updatePmlFilePCCC(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC updatePmlFilePCCC(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> filter(
        java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileId, java.lang.String fileName,
        java.lang.String applicantName, java.lang.String address,
        java.lang.String telephone, java.lang.String email, long fileStatusId,
        java.lang.String fileType, java.util.Date receiveFromDate,
        java.util.Date receiveToDate, java.util.Date expectedReturningFromDate,
        java.util.Date expectedReturningToDate, java.util.Date expiredFromDate,
        java.util.Date expiredToDate, java.util.Date exactReturningFromDate,
        java.util.Date exactReturningToDate);
}
