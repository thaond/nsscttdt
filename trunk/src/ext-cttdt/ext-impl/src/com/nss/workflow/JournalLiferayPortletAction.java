/**
 * 
 */
package com.nss.workflow;

import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.web.struts.action.WorkflowPortletAction;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;


/**
 * @author minhnv
 *
 */
public abstract class JournalLiferayPortletAction extends WorkflowPortletAction {
	private final static Logger log = Logger.getLogger(JournalLiferayPortletAction.class);
	public static final String COMMAND_PREFIX = "command.article.journal";
	
	protected JournalLiferayWorkflowService journalLWS = new JournalLiferayWorkflowService(); 
	protected JournalLiferayTaskNameDispatcher journalTND = new JournalLiferayTaskNameDispatcher();
	
	@Override
	protected LiferayWorkflowService getLiferayWorkflowService() {
		 return journalLWS;
	}

	@Override
	protected long getProcessInstanceId(PortletRequest req) {
		// get documentReceiptId from request.
		long articleId = ParamUtil.getLong(req,"resourcePrimkey", -1);
		
		if (articleId == -1) {
			return articleId;
		}		
		try {
			WorkflowJournalArticle workflowJournalArticle = WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(articleId);
			if (workflowJournalArticle != null) {
				return workflowJournalArticle.getProcessInstanceId();
			} else {
				return -1;
			}
		} catch (PortalException e) {
			log.error("ERROR IN METHOD getProcessInstanceId() WITH articleId = " + articleId + " "+e.getMessage());
			return -1;
		} catch (SystemException e) {
			log.error("ERROR IN METHOD getProcessInstanceId() WITH articleId = " + articleId + " "+e.getMessage());
			return -1;
		}
		
	}

	@Override
	protected long getTaskInstanceId(PortletRequest req) {
		return ParamUtil.getLong(req, "taskId", -1);
	}


	@Override
	protected TaskNameDispatcher getTaskNameDispatcher() {
		return journalTND;
	}

	
}