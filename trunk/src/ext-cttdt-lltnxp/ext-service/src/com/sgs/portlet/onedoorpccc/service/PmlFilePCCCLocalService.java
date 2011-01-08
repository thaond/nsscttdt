package com.sgs.portlet.onedoorpccc.service;


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
 * <code>com.sgs.portlet.onedoorpccc.service.impl.PmlFilePCCCLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalServiceUtil
 *
 */
public interface PmlFilePCCCLocalService {
    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCC addPmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCC createPmlFilePCCC(
        java.lang.String fileId);

    public void deletePmlFilePCCC(java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCC getPmlFilePCCC(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> getPmlFilePCCCs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFilePCCCsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCC updatePmlFilePCCC(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filter(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileId, java.lang.String fileName,
        java.lang.String applicantName, java.lang.String address,
        java.lang.String telephone, java.lang.String email, long fileStatusId,
        java.lang.String fileType, java.util.Date receiveFromDate,
        java.util.Date receiveToDate, java.util.Date expectedReturningFromDate,
        java.util.Date expectedReturningToDate, java.util.Date expiredFromDate,
        java.util.Date expiredToDate, java.util.Date exactReturningFromDate,
        java.util.Date exactReturningToDate);
}
