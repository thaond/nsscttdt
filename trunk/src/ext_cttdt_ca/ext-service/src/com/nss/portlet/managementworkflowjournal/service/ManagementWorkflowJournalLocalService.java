package com.nss.portlet.managementworkflowjournal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="ManagementWorkflowJournalLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.managementworkflowjournal.service.impl.ManagementWorkflowJournalLocalServiceImpl</code>.
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
 * @see com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ManagementWorkflowJournalLocalService {
    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal addManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal createManagementWorkflowJournal(
        long managementWorkflowJournalId);

    public void deleteManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal getManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> getManagementWorkflowJournals(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getManagementWorkflowJournalsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal getDateFromBetweenDateTo(
        java.sql.Timestamp now) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String workflowName, int version,
        boolean andOperator) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> search(
        java.lang.String workflowName, int version, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
