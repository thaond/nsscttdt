package com.sgs.portlet.country.pmluserfiletype.service;


/**
 * <a href="PmlUserFileTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.country.pmluserfiletype.service.impl.PmlUserFileTypeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalServiceUtil
 *
 */
public interface PmlUserFileTypeLocalService {
    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType addPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType createPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK);

    public void deletePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType getPmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> getPmlUserFileTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlUserFileTypesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType updatePmlUserFileType(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException;
}
