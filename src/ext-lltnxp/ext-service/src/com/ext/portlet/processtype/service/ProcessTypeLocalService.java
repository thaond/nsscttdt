package com.ext.portlet.processtype.service;


/**
 * <a href="ProcessTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.processtype.service.impl.ProcessTypeLocalServiceImpl</code>.
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
 * @see com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil
 *
 */
public interface ProcessTypeLocalService {
    public com.ext.portlet.processtype.model.ProcessType addProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType createProcessType(
        long processTypeId);

    public void deleteProcessType(long processTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType getProcessType(
        long processTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> getProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getProcessTypesCount() throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType updateProcessType(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType getProcessTypeById(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> getProcessTypeByFlag(
        int flag)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception;
}
