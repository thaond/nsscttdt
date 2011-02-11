package com.sgs.portlet.generatetemplateid.service;


/**
 * <a href="IdGeneratedLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService
 *
 */
public class IdGeneratedLocalServiceUtil {
    private static IdGeneratedLocalService _service;

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated addIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException {
        return getService().addIdGenerated(idGenerated);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated createIdGenerated(
        long id) {
        return getService().createIdGenerated(id);
    }

    public static void deleteIdGenerated(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteIdGenerated(id);
    }

    public static void deleteIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException {
        getService().deleteIdGenerated(idGenerated);
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

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated getIdGenerated(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getIdGenerated(id);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> getIdGenerateds(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getIdGenerateds(start, end);
    }

    public static int getIdGeneratedsCount()
        throws com.liferay.portal.SystemException {
        return getService().getIdGeneratedsCount();
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated updateIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException {
        return getService().updateIdGenerated(idGenerated);
    }

    public static int searchCount() throws com.liferay.portal.SystemException {
        return getService().searchCount();
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> search(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().search(start, end);
    }

    public static IdGeneratedLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("IdGeneratedLocalService is not set");
        }

        return _service;
    }

    public void setService(IdGeneratedLocalService service) {
        _service = service;
    }
}
