package com.nss.portlet.journalworkflow.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalProcessDefinitionLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journalworkflow.service.impl.JournalProcessDefinitionLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalProcessDefinitionLocalService {
    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition addJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition createJournalProcessDefinition(
        long journalProcessDefinitionId);

    public void deleteJournalProcessDefinition(long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition getJournalProcessDefinition(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> getJournalProcessDefinitions(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalProcessDefinitionsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition addJPD(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition jPD);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.tags.model.TagsEntry> getListTagsEntry(
        long categoryId);
}
