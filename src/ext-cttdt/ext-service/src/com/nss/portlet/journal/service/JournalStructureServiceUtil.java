package com.nss.portlet.journal.service;


/**
 * <a href="JournalStructureServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalStructureService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalStructureService
 *
 */
public class JournalStructureServiceUtil {
    private static JournalStructureService _service;

    public static com.nss.portlet.journal.model.JournalStructure addStructure(
        long groupId, java.lang.String structureId, boolean autoStructureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addStructure(groupId, structureId, autoStructureId,
            parentStructureId, name, description, xsd, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalStructure copyStructure(
        long groupId, java.lang.String oldStructureId,
        java.lang.String newStructureId, boolean autoStructureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .copyStructure(groupId, oldStructureId, newStructureId,
            autoStructureId);
    }

    public static void deleteStructure(long groupId,
        java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteStructure(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalStructure getStructure(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getStructure(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalStructure updateStructure(
        long groupId, java.lang.String structureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateStructure(groupId, structureId, parentStructureId,
            name, description, xsd, serviceContext);
    }

    public static JournalStructureService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalStructureService is not set");
        }

        return _service;
    }

    public void setService(JournalStructureService service) {
        _service = service;
    }
}
