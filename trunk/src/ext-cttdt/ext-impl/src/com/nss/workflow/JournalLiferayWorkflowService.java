/**
 * 
 */

package com.nss.workflow;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleImpl;
import com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalImpl;
import com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl;
import com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalServiceUtil;
import com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalServiceUtil;
import com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;

/**
 * @author minhnv
 */
public class JournalLiferayWorkflowService
	extends AbstractLiferayWorkflowService {
	private final String START = "start";
	private final String END = "end";
	private final String ACTORID = "actorId";

	private final static Logger log =
		Logger.getLogger(JournalLiferayWorkflowService.class);

	public JournalLiferayWorkflowService() {

	}

	public void addWorkflowInstance(List<WorkflowParam> params) {

		// get necessary parameters include documentId and fileId
		long articleId = WorkflowParamUtil.getLong(params, "resourcePrimey", 0);
		long userId = WorkflowParamUtil.getLong(params, "userId", 0);
		long groudId = WorkflowParamUtil.getLong(params, "groundId", 0);
		String counterImage =
			WorkflowParamUtil.getString(params, "countImage", "0");

		if ((articleId == 0) || (userId == 0)) {
			log.info("CAN'T CREATE WORKFLOW INSTANCE: PARAMETER INVALID");
			return;
		}

		// get process definition proper
		ManagementWorkflowJournal managementWorkflowJournal = null;
		Timestamp now = new Timestamp(new Date().getTime());
		try {
			managementWorkflowJournal =
				ManagementWorkflowJournalLocalServiceUtil.getDateFromBetweenDateTo(now);
		}
		catch (Exception e) {
			log.error("ERROR: IN METHOD ADDWORKFLOWINSTANCE OF JOURNALLIFERAYWORKFLOWSERVICE " +
				e.getMessage());
		}

		if (managementWorkflowJournal != null) {
			ProcessInstance pi =
				getJbpmService().createProcessInstanceHasVersion(
					managementWorkflowJournal.getWorkflowname(),
					managementWorkflowJournal.getVersion_());

			if (pi != null) {
				long processInstanceId = pi.getId();
				getJbpmService().setContext(
					processInstanceId, ACTORID, String.valueOf(userId));
				getJbpmService().signalProcessInstance(processInstanceId);
				// wire into table nss_workflow_journal_article
				WorkflowJournalArticle workflowJournalArticle =
					new WorkflowJournalArticleImpl();
				User user = null;
				try {
					user = UserLocalServiceUtil.getUser(userId);
				}
				catch (NumberFormatException e) {
					log.error("ERROR LONG.PARSELONG(USERID) OF ADDWORKFLOWJOURNALARTICLE OF CLASS JOURNALLIFERAYWORKFLOWSERVICE "+e.getMessage());
				}
				catch (PortalException e) {
					log.error("ERROR PORTALEXCEPTION OF ADDWORKFLOWJOURNALARTICLE OF CLASS JOURNALLIFERAYWORKFLOWSERVICE "+e.getMessage());
				}
				catch (SystemException e) {
					log.error("ERROR SYSTEMEXCEPTION OF ADDWORKFLOWJOURNALARTICLE OF CLASS JOURNALLIFERAYWORKFLOWSERVICE "+e.getMessage());
				}
				try {
					workflowJournalArticle.setWorkflowJournalArticleId(CounterLocalServiceUtil.increment());
					workflowJournalArticle.setGroupId(groudId);
					workflowJournalArticle.setCompanyId(user.getCompanyId());
					workflowJournalArticle.setUserId(userId);
					workflowJournalArticle.setUserIds(String.valueOf(userId));
					workflowJournalArticle.setProcessDefinitionId(managementWorkflowJournal.getProcessDefinitionId());
					workflowJournalArticle.setProcessInstanceId(processInstanceId);
					workflowJournalArticle.setResourcePrimkey(articleId);
					workflowJournalArticle.setCountImageOfArticle(Integer.parseInt(counterImage));

					WorkflowJournalArticleLocalServiceUtil.addWorkflowJournalArticle(workflowJournalArticle);
				}
				catch (SystemException e) {
					log.error("ERROR: ADD WORKFLOWJOURNALARTICLE OF ADDWORKFLOWINSTANCE "+e.getMessage());

				}
				// wire into table log_workflow_journal_article
				LogWorkflowJournalArticle logW =
					logNewNode(
						0, articleId, userId, groudId, user.getCompanyId(),
						String.valueOf(userId), userId, String.valueOf(userId), "",
						now, now, now);
				logW.setWorkflowStatusAfter(getStateNode(processInstanceId));
				try {
					LogWorkflowJournalArticleLocalServiceUtil.updateLogWorkflowJournalArticle(logW);
				}
				catch (SystemException e) {
					log.error("ERROR: IN METHOD ADDWORKFLOWINSTANCE MESSAGE " +
						e.getMessage());
				}
				logNewNode(
					processInstanceId, articleId, userId, groudId,
					user.getCompanyId(), String.valueOf(userId), userId, "", "",
					now, now, now);
			}
		}
	}

	/**
	 * @param workflowName
	 * @param version
	 * @return
	 */
	public boolean deleteProcessDefinition(
		String workflowName, int version, long managementWorkflowJournalId,
		long processdefinitionId) {

		try {
			int end =
				WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticles(
					-1, -1).size();
			WorkflowJournalArticle workflowJournalArticle =
				WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleByProcessDefinition(
					processdefinitionId, 0, end);
			if (workflowJournalArticle == null) {
				getJbpmService().deleteProcessDefinitionhasVersion(
					workflowName, version);
				ManagementWorkflowJournalLocalServiceUtil.deleteManagementWorkflowJournal(managementWorkflowJournalId);
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			log.error("ERROR: IN METHOD DELETEPROCESSDEFINITION IN CLASS " +
				JournalLiferayWorkflowService.class);
			return false;
		}
	}

	public void deloyProcessSupport(
		InputStream is, String description, Timestamp dateFrom, Timestamp dateTo, long userId, long companyId, long groupId, long managementWorkflowJournalIdOld, String dateSaveUpdate) {

		ProcessDefinition processDefinition = deployWorkflow(is);
		ManagementWorkflowJournal managementWorkflowJournal =
			new ManagementWorkflowJournalImpl();
		try {
			if(dateSaveUpdate.equals("save")){
				long managementWorkflowJournalId = CounterLocalServiceUtil.increment();
				managementWorkflowJournal.setManagementWorkflowJournalId(managementWorkflowJournalId);
				managementWorkflowJournal.setUserId(userId);
				managementWorkflowJournal.setGroupId(groupId);
				managementWorkflowJournal.setCompanyId(companyId);
				managementWorkflowJournal.setProcessDefinitionId(processDefinition.getId());
				managementWorkflowJournal.setWorkflowname(processDefinition.getName());
				managementWorkflowJournal.setVersion_(processDefinition.getVersion());
				managementWorkflowJournal.setDescription(description);
				managementWorkflowJournal.setDateFrom(dateFrom);
				managementWorkflowJournal.setDateTo(dateTo);
				ManagementWorkflowJournalLocalServiceUtil.addManagementWorkflowJournal(managementWorkflowJournal);
			}else if(dateSaveUpdate.equals("saveAndUpdate")){
				long managementWorkflowJournalId = CounterLocalServiceUtil.increment();
				managementWorkflowJournal.setManagementWorkflowJournalId(managementWorkflowJournalId);
				managementWorkflowJournal.setUserId(userId);
				managementWorkflowJournal.setGroupId(groupId);
				managementWorkflowJournal.setCompanyId(companyId);
				managementWorkflowJournal.setProcessDefinitionId(processDefinition.getId());
				managementWorkflowJournal.setWorkflowname(processDefinition.getName());
				managementWorkflowJournal.setVersion_(processDefinition.getVersion());
				managementWorkflowJournal.setDescription(description);
				managementWorkflowJournal.setDateFrom(dateFrom);
				managementWorkflowJournal.setDateTo(dateTo);
				ManagementWorkflowJournalLocalServiceUtil.addManagementWorkflowJournal(managementWorkflowJournal);
				try {
					managementWorkflowJournal = ManagementWorkflowJournalLocalServiceUtil.getManagementWorkflowJournal(managementWorkflowJournalIdOld);
					managementWorkflowJournal.setDateTo(dateFrom);
					ManagementWorkflowJournalLocalServiceUtil.updateManagementWorkflowJournal(managementWorkflowJournal);
				} catch (PortalException e) {
					log.equals("ERROR: GETMANAGEMENTWORKFLOWJOURNAL IN DELOYPROCESSSUPPORT OF JOURNALLIFERAYWORKFLOWSERVICE " +	e.getMessage());
				}
			}
		}
		catch (SystemException e) {
			log.equals("ERROR: CREATE MANAGEMENTWORKFLOWJOURNALID IN DELOYPROCESSSUPPORT OF JOURNALLIFERAYWORKFLOWSERVICE " + e.getMessage());
		}
	}

	/**
	 * Get list user from a department to process file
	 * 
	 * @param req
	 * @param res
	 * @return List<User> users;
	 * @throws Exception
	 */
	public List<User> getListUsers(long taskInstanceId)
		throws Exception {

		List<User> users = new ArrayList<User>();
		try {
			if (taskInstanceId != 0) {
				users = getPooledUser(taskInstanceId);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		Collections.sort(users, new Comparator<User>() {

			public int compare(User o1, User o2) {

				return o1.getFullName().compareTo(o2.getFullName());
			}
		});

		return users;
	}

	/**
	 * This method add a line data in table Pml_DocumentReceipt_Log
	 * 
	 * @param documentReceiptId
	 *            : id of document receipt
	 * @param userId
	 *            : id of user but receipt document
	 * @param processId
	 *            : id of process definition
	 * @param receiptDate
	 *            : is date but processor receipt document
	 * @param type
	 *            : for know process main or support
	 * @return PmlDocumentReceiptLog
	 */
	private LogWorkflowJournalArticle logNewNode(
		long processInstanceId, long arcticleId, long userId, long groupId,
		long companyId, String userIds, long userIdProcess,
		String userIdsProcess, String processinformation,
		Timestamp dateReceiptOfUserReceipt, Timestamp dateProcessOfUserReceipt,
		Timestamp sendDateOfUserReceipt) {

		LogWorkflowJournalArticle logWorkflowJournalArticle =
			new LogWorkflowJournalArticleImpl();

		try {
			long logWorkflowJournalArticleId =
				CounterLocalServiceUtil.increment();

			// get state process code from process instance
			String stateProcessCode = "start";

			if (processInstanceId != 0) {
				stateProcessCode = getStateNode(processInstanceId);
			}

			// write information to log
			logWorkflowJournalArticle.setLogWorkflowJournalArticleId(logWorkflowJournalArticleId);
			logWorkflowJournalArticle.setResourcePrimkey(arcticleId);
			logWorkflowJournalArticle.setGroupId(groupId);
			logWorkflowJournalArticle.setCompanyId(companyId);
			logWorkflowJournalArticle.setUserId(userId);
			logWorkflowJournalArticle.setUserIds(userIds);
			logWorkflowJournalArticle.setUseridProcess(userIdProcess);
			logWorkflowJournalArticle.setUserIdsProcess(userIdsProcess);
			logWorkflowJournalArticle.setProcessInformation(processinformation);
			// logWorkflowJournalArticle.setRoleId(roleId);

			logWorkflowJournalArticle.setWorkflowStatusBefore(stateProcessCode);

			int transition =
				LogWorkflowJournalArticleLocalServiceUtil.countLogWorkflowJournalArticle(arcticleId);

			logWorkflowJournalArticle.setTransition(LogWorkflowJournalArticleLocalServiceUtil.countLogWorkflowJournalArticle(arcticleId) + 1);

			if (dateReceiptOfUserReceipt != null) {
				logWorkflowJournalArticle.setDateReceiptOfUserReceipt(dateReceiptOfUserReceipt);
			}

			if (dateProcessOfUserReceipt != null) {
				logWorkflowJournalArticle.setDateProcessOfUserReceipt(dateProcessOfUserReceipt);
			}

			if ((1 != transition) && (sendDateOfUserReceipt != null)) {
				logWorkflowJournalArticle.setDateSendOfUserReceipt(sendDateOfUserReceipt);
			}
			logWorkflowJournalArticle =
				LogWorkflowJournalArticleLocalServiceUtil.addLogWorkflowJournalArticle(logWorkflowJournalArticle);

		}
		catch (Exception e) {
			log.error("ERROR: IN METHOD LOGNEWNODE IN CLASS " +
				JournalLiferayWorkflowService.class);
		}

		return logWorkflowJournalArticle;
	}

	/**
	 * 
	 */
	public void signalTask(List<WorkflowParam> params) {

		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);

		String transition =
			WorkflowParamUtil.getString(params, "transition", "");

		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");

		String userIds = WorkflowParamUtil.getString(params, "userIds", "0");

		long userIdProcess =
			WorkflowParamUtil.getLong(params, "userIdProcess", 0);

		if ((taskId == -1) || "".equals(transition)) {
			return;
		}

		try {

			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processInstanceId = pi.getId();

			// get article from processInstanceId
			WorkflowJournalArticle workflowJournalArticle =
				WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleFromPI(processInstanceId);

			if (workflowJournalArticle != null) {
				long articleId = workflowJournalArticle.getResourcePrimkey();

				// write into row current of table log

				// signal process definition

				getJbpmService().setContext(
					processInstanceId, ACTORID, String.valueOf(userIds));
				
				
				List<String> listNodeBack = (List<String>) getJbpmService().getContextVariable(processInstanceId, "listNodeBack");
				List<Long> listUserNodeBack = (List<Long>) getJbpmService().getContextVariable(processInstanceId, "listUserNodeBack");
				String nameNodeCurrent = getStateNode(processInstanceId);
				if (listNodeBack !=null  ){
					listNodeBack.add(nameNodeCurrent);
					getJbpmService().setContext(processInstanceId, "listNodeBack", listNodeBack);
				}
				else {
					listNodeBack = new ArrayList<String>();
					listNodeBack.add(nameNodeCurrent);
					getJbpmService().setContext(processInstanceId, "listNodeBack", listNodeBack);
				}
				
				if (listUserNodeBack !=null  ){
					listUserNodeBack.add(userIdProcess);
					getJbpmService().setContext(processInstanceId, "listUserNodeBack", listUserNodeBack);
				}
				else {
					 listUserNodeBack = new ArrayList<Long>();
					 listUserNodeBack.add(userIdProcess);
					 getJbpmService().setContext(processInstanceId, "listUserNodeBack", listUserNodeBack);
				}	
				
				getJbpmService().signalTask(taskId, transition);

				// update colum userIds of table nss_workflow_journal_article
				workflowJournalArticle.setUserIds(userIds);
				WorkflowJournalArticleLocalServiceUtil.updateWorkflowJournalArticle(workflowJournalArticle);
				// create a row log in table log_workflow_journal_article
				LogWorkflowJournalArticle logWorkflowJournalArticle =
					LogWorkflowJournalArticleLocalServiceUtil.getLogByResourceTrainsition(articleId);
				Timestamp now = new Timestamp(new Date().getTime());
				if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
					logWorkflowJournalArticle.setUserIdsProcess(userIds);
					logWorkflowJournalArticle.setDateReceiptOfUserReceipt(now);
					logWorkflowJournalArticle.setDateProcessOfUserReceipt(now);
					logWorkflowJournalArticle.setDateSendOfUserReceipt(now);
					logWorkflowJournalArticle.setWorkflowStatusAfter(nameNodeCurrent);
					LogWorkflowJournalArticleLocalServiceUtil.updateLogWorkflowJournalArticle(logWorkflowJournalArticle);

					logNewNode(
						processInstanceId, articleId,
						logWorkflowJournalArticle.getUserId(),
						logWorkflowJournalArticle.getGroupId(),
						logWorkflowJournalArticle.getCompanyId(), userIds,
						userIdProcess, "", processInformation, null, null, null);
				}
				if (getJbpmService().getProcessInstance(processInstanceId).getEnd() != null) {
					logWorkflowJournalArticle.setUserIdsProcess(userIds);
					logWorkflowJournalArticle.setDateReceiptOfUserReceipt(now);
					logWorkflowJournalArticle.setDateProcessOfUserReceipt(now);
					logWorkflowJournalArticle.setDateSendOfUserReceipt(now);
					logWorkflowJournalArticle.setWorkflowStatusAfter(END);
					LogWorkflowJournalArticleLocalServiceUtil.updateLogWorkflowJournalArticle(logWorkflowJournalArticle);
				}

			}
			else {
				log.error("ERROR: NO EXIST WORKFLOWJOURNALARTICLE IN METHOD SIGNALTASK() WITH PROCESSINSTANCEID = " +
					processInstanceId);
			}

		}
		catch (Exception e) {
			log.error("ERROR: IN METHOD SIGNALTASK() NO SIGNAL TASK = " +
				taskId);
			e.printStackTrace();
		}

	}

	public void signalTaskBack(List<WorkflowParam> params) {

		String transition =
			WorkflowParamUtil.getString(params, "transition", "");
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		long receiverId = WorkflowParamUtil.getLong(params, "receiverId", -1);
		String processor = WorkflowParamUtil.getString(params, "processor", "");
		try {

			if ((taskId == -1) || "".equals(transition)) {
				return;
			}

			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processInstanceId = pi.getId();
			getJbpmService().setContext(
				processInstanceId, ACTORID, receiverId + "");

			// get state process
			String stateProcessCode = getStateNode(processInstanceId);

			// get article from processInstanceId
			WorkflowJournalArticle workflowJournalArticle =
				WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleFromPI(processInstanceId);
			if (workflowJournalArticle != null) {
				long articleId = workflowJournalArticle.getResourcePrimkey();

				// write into row current of table log
				// TODO

				// signal Task
				List<String> listNodeBack =
					(List<String>) getJbpmService().getContextVariable(
						processInstanceId, "listNodeBack");
				List<Long> listUserNodeBack =
					(List<Long>) getJbpmService().getContextVariable(
						processInstanceId, "listUserNodeBack");

				getJbpmService().signalTask(taskId, listNodeBack.get(listNodeBack.size() - 1));

				String nameNodeAfter = listNodeBack.remove(listNodeBack.size() - 1);
				Long userRemove = listUserNodeBack.remove(listUserNodeBack.size() - 1);
				
				getJbpmService().setContext(
					processInstanceId, "listNodeBack", listNodeBack);
				getJbpmService().setContext(
					processInstanceId, "listUserNodeBack", listUserNodeBack);

				// create a row log in table log_workflow_journal_article
				// TODO

				if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
					Timestamp now = new Timestamp(new Date().getTime());
					// logNewNode(
					// articleId, processInstanceId, receiverId, 0, 0, 0l, now);
				}

			}
			else {
				log.error("ERROR: no exist WorkflowJournalArticle in method signalTaskBack() with processInstanceId = " +
					processInstanceId);
			}

		}
		catch (Exception e) {
			log.error("ERROR: in method signalTaskBack() no signal task " +
				taskId);
		}

	}
}
