/**
 * 
 */
package com.nss.workflow;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
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
public class JournalLiferayWorkflowService extends
		AbstractLiferayWorkflowService {

	private final static Logger log = Logger
			.getLogger(JournalLiferayWorkflowService.class);
	
	
	public JournalLiferayWorkflowService() {

	}

	public void deloyProcessSupport(InputStream is, String description, Timestamp dateFrom, Timestamp dateTo, long userId) {
		ProcessDefinition processDefinition = deployWorkflow(is);
		ManagementWorkflowJournal managementWorkflowJournal = new ManagementWorkflowJournalImpl();
		try {
			long managementWorkflowJournalId = CounterLocalServiceUtil.increment();
			System.out.println("userId "+userId);
			managementWorkflowJournal.setManagementWorkflowJournalId(managementWorkflowJournalId);
			managementWorkflowJournal.setProcessDefinitionId(processDefinition.getId());
			managementWorkflowJournal.setWorkflowname(processDefinition.getName());
			managementWorkflowJournal.setVersion_(processDefinition.getVersion());
			managementWorkflowJournal.setDescription(description);
			managementWorkflowJournal.setDateFrom(dateFrom);
			managementWorkflowJournal.setDateTo(dateTo);
			
			ManagementWorkflowJournalLocalServiceUtil.addManagementWorkflowJournal(managementWorkflowJournal);
		} catch (SystemException e) {
			log.equals("ERROR: create   managementWorkflowJournalId in deloyProcessSupport of JournalLiferayWorkflowService "+ e.getMessage());
		}
	}

	@Override
	public void addWorkflowInstance(List<WorkflowParam> params) {
		// get necessary parameters include documentId and fileId
		long articleId = WorkflowParamUtil.getLong(params,"resourcePrimey", 0);
		long userId = WorkflowParamUtil.getLong(params,"userId", 0);

		if (articleId == 0 || userId == 0) {
			log.info("Can't create Workflow Instance: Parameter invalid");
			return;
		}
		
		// get process definition proper
		ManagementWorkflowJournal managementWorkflowJournal = null;		
		Timestamp now = new Timestamp(new Date().getTime());
		try {
			managementWorkflowJournal = ManagementWorkflowJournalLocalServiceUtil.getDateFromBetweenDateTo(now);
		} catch (Exception e) {
			log.equals("ERROR: in method addWorkflowInstance of JournalLiferayWorkflowService "+ e.getMessage());
		}
		
		if (managementWorkflowJournal != null) {			
			ProcessInstance pi = getJbpmService().createProcessInstanceHasVersion(managementWorkflowJournal.getWorkflowname(), managementWorkflowJournal.getVersion_());
		
			if (pi != null) {
				long processInstanceId = pi.getId();	
				getJbpmService().setContext(processInstanceId, "actorId", String.valueOf(userId));
				getJbpmService().signalProcessInstance(processInstanceId);
				// wire into table nss_workflow_journal_article
				WorkflowJournalArticle workflowJournalArticle = new WorkflowJournalArticleImpl();
				try {
					workflowJournalArticle.setWorkflowJournalArticleId(CounterLocalServiceUtil.increment());
					workflowJournalArticle.setProcessDefinitionId(managementWorkflowJournal.getProcessDefinitionId());
					workflowJournalArticle.setProcessInstanceId(processInstanceId);
					workflowJournalArticle.setResourcePrimkey(articleId);
					
					WorkflowJournalArticleLocalServiceUtil.addWorkflowJournalArticle(workflowJournalArticle);
				} catch (SystemException e) {
					
				}
				//TODO
				// wire into table log_workflow_journal_article
				logNewNode(processInstanceId, articleId, userId ,0l , now);
			}
		}
	}


	/**
	 * 
	 */
	public void signalTask(List<WorkflowParam> params) {
		
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition = WorkflowParamUtil.getString(params, "transition", "");
		long receiverId = WorkflowParamUtil.getLong(params, "receiverId", -1);	
		String processInformation = WorkflowParamUtil.getString(params, "processInformation", "");
		Date dateProcess = new Date();
	
		if (taskId == -1 || "".equals(transition)) {
			return;
		}
		
		try {
			
			// get process instance
			ProcessInstance pi = getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processInstanceId = pi.getId();
			
			// get state process
			String stateProcessCode = getStateNode(processInstanceId);
			
			// get article from processInstanceId
			WorkflowJournalArticle workflowJournalArticle = WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleFromPI(processInstanceId);
			if (workflowJournalArticle != null) {
				long articleId = workflowJournalArticle.getResourcePrimkey();
				
				// write into row current of table log
				//TODO
				
				// signal process definition 
				getJbpmService().signalTask(taskId, transition);
				
				// create a row log in table log_workflow_journal_article
				//TODO
				
				if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
					Timestamp now = new Timestamp(new Date().getTime());
					logNewNode(articleId, processInstanceId , receiverId, 0l, now);
				}
				
			} else {
				log.error("ERROR: no exist WorkflowJournalArticle in method signalTask() with processInstanceId = "+ processInstanceId);
			}
	
		} catch (Exception e) {
			log.error("ERROR: in method signalTask() no signal task = " + taskId);
		}
		
	}
	
	
	public void signalTaskBack(List<WorkflowParam> params) {		
		String transition = WorkflowParamUtil.getString(params, "transition", "");
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String processInformation = WorkflowParamUtil.getString(params, "processInformation", "");		
		long receiverId =  WorkflowParamUtil.getLong(params, "receiverId", -1);		
		String processor = WorkflowParamUtil.getString(params, "processor", ""); 
		try {
			
			if (taskId == -1 || "".equals(transition)) {
				return;
			}
			
			// get process instance
			ProcessInstance pi = getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processInstanceId = pi.getId();
			getJbpmService().setContext(processInstanceId, "actorId", receiverId + "");
			
			// get state process
			String stateProcessCode = getStateNode(processInstanceId);
			
			// get article from processInstanceId
			WorkflowJournalArticle workflowJournalArticle = WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleFromPI(processInstanceId);
			if (workflowJournalArticle != null) {
				long articleId = workflowJournalArticle.getResourcePrimkey();
				
				// write into row current of table log
				//TODO
				
				//signal Task
				List<String> listNodeBack = (List<String>)  getJbpmService().getContextVariable(processInstanceId, "listNodeBack");
				List<Long> listUserNodeBack = (List<Long>)  getJbpmService().getContextVariable(processInstanceId, "listUserNodeBack");
				
				getJbpmService().signalTask(taskId, listNodeBack.get(listNodeBack.size()-1));
				
				listNodeBack.remove(listNodeBack.get(listNodeBack.size()-1));		
				listUserNodeBack.remove(listUserNodeBack.size() -1);
				getJbpmService().setContext(processInstanceId, "listNodeBack",listNodeBack);
				getJbpmService().setContext(processInstanceId, "listUserNodeBack",listUserNodeBack);
				
				// create a row log in table log_workflow_journal_article
				//TODO
				
				if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
					Timestamp now = new Timestamp(new Date().getTime());
					logNewNode(articleId, processInstanceId , receiverId, 0l, now);
				}
				
			} else {
				log.error("ERROR: no exist WorkflowJournalArticle in method signalTaskBack() with processInstanceId = "+ processInstanceId);
			}
		
		} catch (Exception e) {
			log.error("ERROR: in method signalTaskBack() no signal task " + taskId);
		}

	}
	
	/**
	 * This method add a line data in table Pml_DocumentReceipt_Log 
	 * @param documentReceiptId: id of document receipt 
	 * @param userId: id of user but receipt document
	 * @param processId: id of process definition 
	 * @param receiptDate: is date but processor receipt document
	 * @param type: for know process main or support
	 * @return PmlDocumentReceiptLog
	 *
	 */
	private LogWorkflowJournalArticle logNewNode(long processInstanceId, long arcticleId, long userId, long roleId, Timestamp sendDateOfUserReceipt) {
		LogWorkflowJournalArticle logWorkflowJournalArticle = new LogWorkflowJournalArticleImpl();
		
		try {
			long logWorkflowJournalArticleId = CounterLocalServiceUtil.increment();
			
			// get state process code from process instance
			String stateProcessCode = getStateNode(processInstanceId);			
			
			// write information to log
			logWorkflowJournalArticle.setLogWorkflowJournalArticleId(logWorkflowJournalArticleId);
			logWorkflowJournalArticle.setResourcePrimkey(arcticleId);
//			logWorkflowJournalArticle.setGroupid(groupid);
//			logWorkflowJournalArticle.setCompanyid(companyid);
			logWorkflowJournalArticle.setUserId(userId);
			logWorkflowJournalArticle.setRoleId(roleId);
			
			logWorkflowJournalArticle.setWorkflowStatusBefore(stateProcessCode);	
			
			int transition = LogWorkflowJournalArticleLocalServiceUtil.countLogWorkflowJournalArticle(arcticleId);
			logWorkflowJournalArticle.setTransition(LogWorkflowJournalArticleLocalServiceUtil.countLogWorkflowJournalArticle(arcticleId) + 1);
			
			if (1 != transition) {
				logWorkflowJournalArticle.setDateSendOfUserReceipt(sendDateOfUserReceipt);
			}
			logWorkflowJournalArticle = LogWorkflowJournalArticleLocalServiceUtil.addLogWorkflowJournalArticle(logWorkflowJournalArticle);
			
		} catch (Exception e) {
			log.error("ERROR: in method logNewNode in class " + JournalLiferayWorkflowService.class);
			e.printStackTrace();
		}
		
		return logWorkflowJournalArticle;
	}

	/**
	 * 
	 * @param workflowName
	 * @param version
	 * @return
	 */
	public boolean deleteProcessDefinition(String workflowName, int version, long managementWorkflowJournalId, long processdefinitionId){
		try {
			int end = WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticles(-1, -1).size();
			WorkflowJournalArticle workflowJournalArticle = WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticleByProcessDefinition(processdefinitionId, 0, end);
			if(workflowJournalArticle == null){
				getJbpmService().deleteProcessDefinitionhasVersion(workflowName, version);
				ManagementWorkflowJournalLocalServiceUtil.deleteManagementWorkflowJournal(managementWorkflowJournalId);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			log.error("ERROR: in method deleteProcessDefinition in class " + JournalLiferayWorkflowService.class);
			return false;
		}
	}
}
