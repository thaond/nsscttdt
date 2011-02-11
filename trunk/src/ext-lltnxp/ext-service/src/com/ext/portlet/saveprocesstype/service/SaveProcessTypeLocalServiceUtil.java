package com.ext.portlet.saveprocesstype.service;


/**
 * <a href="SaveProcessTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService
 *
 */
public class SaveProcessTypeLocalServiceUtil {
    private static SaveProcessTypeLocalService _service;

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType addSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException {
        return getService().addSaveProcessType(saveProcessType);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType createSaveProcessType(
        long sptId) {
        return getService().createSaveProcessType(sptId);
    }

    public static void deleteSaveProcessType(long sptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSaveProcessType(sptId);
    }

    public static void deleteSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException {
        getService().deleteSaveProcessType(saveProcessType);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType getSaveProcessType(
        long sptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSaveProcessType(sptId);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> getSaveProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSaveProcessTypes(start, end);
    }

    public static int getSaveProcessTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getSaveProcessTypesCount();
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType updateSaveProcessType(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException {
        return getService().updateSaveProcessType(saveProcessType);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType getSaveProcessTypeById(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSaveProcessTypeById(id);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> getProcessTypeByDocId(
        long docId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getProcessTypeByDocId(docId);
    }

    public static SaveProcessTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("SaveProcessTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(SaveProcessTypeLocalService service) {
        _service = service;
    }
}
