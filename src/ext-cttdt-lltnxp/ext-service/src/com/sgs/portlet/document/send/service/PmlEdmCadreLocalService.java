package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmCadreLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.send.service.impl.PmlEdmCadreLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreLocalServiceUtil
 *
 */
public interface PmlEdmCadreLocalService {
    public com.sgs.portlet.document.send.model.PmlEdmCadre addPmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre createPmlEdmCadre(
        long userId);

    public void deletePmlEdmCadre(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre getPmlEdmCadre(
        long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> getPmlEdmCadres(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmCadresCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre updatePmlEdmCadre(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException;
}
