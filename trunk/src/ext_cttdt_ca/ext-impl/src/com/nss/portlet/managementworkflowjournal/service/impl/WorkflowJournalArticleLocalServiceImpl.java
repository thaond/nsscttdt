package com.nss.portlet.managementworkflowjournal.service.impl;

import com.liferay.portal.SystemException;
import com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.service.base.WorkflowJournalArticleLocalServiceBaseImpl;
import com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticleUtil;


public class WorkflowJournalArticleLocalServiceImpl
    extends WorkflowJournalArticleLocalServiceBaseImpl {
	
	public WorkflowJournalArticle getWorkflowJournalArticle(long resourcePrimkey){
		try {
			return WorkflowJournalArticleUtil.findByResourcePrimkey(resourcePrimkey);
		} catch (NoSuchWorkflowJournalArticleException e) {
			return null;
		} catch (SystemException e) {
			return null;
		}
	}
	
	public WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(long processDefinitionId, int start, int end) throws SystemException{
		return workflowJournalArticleFinder.getWorkflowJournalArticleByProcessDefinition(processDefinitionId, start, end);	
	}
	
	public WorkflowJournalArticle getWorkflowJournalArticleFromPI(long processInstanceId){
		try {
			return WorkflowJournalArticleUtil.findByProcessInstanceId(processInstanceId);
		} catch (NoSuchWorkflowJournalArticleException e) {
			return null;
		} catch (SystemException e) {
			return null;
		}
	}
	
}
