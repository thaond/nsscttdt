package com.sgs.portlet.generatetemplateid.service;


/**
 * <a href="IdGeneratedLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.generatetemplateid.service.impl.IdGeneratedLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil
 *
 */
public interface IdGeneratedLocalService {
    public com.sgs.portlet.generatetemplateid.model.IdGenerated addIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated createIdGenerated(
        long id);

    public void deleteIdGenerated(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated getIdGenerated(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> getIdGenerateds(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getIdGeneratedsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated updateIdGenerated(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException;

    public int searchCount() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> search(
        int start, int end) throws com.liferay.portal.SystemException;
}
