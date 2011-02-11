package com.sgs.portlet.country.pmluserfiletype.service;


/**
 * <a href="PmlUserFileTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalService
 *
 */
public class PmlUserFileTypeLocalServiceUtil {
    private static PmlUserFileTypeLocalService _service;

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType addPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        return getService().addPmlUserFileType(pmlUserFileType);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType createPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK) {
        return getService().createPmlUserFileType(pmlUserFileTypePK);
    }

    public static void deletePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlUserFileType(pmlUserFileTypePK);
    }

    public static void deletePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        getService().deletePmlUserFileType(pmlUserFileType);
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

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType getPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlUserFileType(pmlUserFileTypePK);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> getPmlUserFileTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlUserFileTypes(start, end);
    }

    public static int getPmlUserFileTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlUserFileTypesCount();
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType updatePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlUserFileType(pmlUserFileType);
    }

    public static PmlUserFileTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlUserFileTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlUserFileTypeLocalService service) {
        _service = service;
    }
}
