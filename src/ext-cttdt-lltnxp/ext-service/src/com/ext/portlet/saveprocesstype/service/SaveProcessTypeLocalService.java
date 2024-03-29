package com.ext.portlet.saveprocesstype.service;


/**
 * <a href="SaveProcessTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.saveprocesstype.service.impl.SaveProcessTypeLocalServiceImpl</code>.
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
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil
 *
 */
public interface SaveProcessTypeLocalService {
    public com.ext.portlet.saveprocesstype.model.SaveProcessType addSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType createSaveProcessType(
        long sptId);

    public void deleteSaveProcessType(long sptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType getSaveProcessType(
        long sptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> getSaveProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getSaveProcessTypesCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType updateSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType getSaveProcessTypeById(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> getProcessTypeByDocId(
        long docId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
