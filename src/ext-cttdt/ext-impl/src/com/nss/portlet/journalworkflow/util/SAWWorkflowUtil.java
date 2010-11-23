package com.nss.portlet.journalworkflow.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.tags.model.TagsEntry;
import com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;
import com.nss.portlet.journalworkflow.model.InstanceBean;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.service.InstanceBeanLocalServiceUtil;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil;
import com.sun.saw.Workflow;
import com.sun.saw.WorkflowException;
import com.sun.saw.WorkflowFactory;
import com.sun.saw.vo.BusinessProcessInstanceVO;
import com.sun.saw.vo.BusinessProcessVO;
import com.sun.saw.vo.CheckoutTaskVO;
import com.sun.saw.vo.CompleteTaskVO;
import com.sun.saw.vo.FilterTaskVO;
import com.sun.saw.vo.OutputVO;
import com.sun.saw.vo.TaskVO;
import com.sun.saw.vo.TokenVO;

@SuppressWarnings("unchecked")
public class SAWWorkflowUtil {
	private static Workflow workflow;
	static {
		try {
			workflow = WorkflowFactory.getInstance().getWorkflowInstance();
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
	}

	public static OutputVO deploy(String xml) {
		OutputVO result = new OutputVO();
		Map paramMap = new HashMap();
		paramMap.put("processDefinition", xml);
		BusinessProcessVO businessProcessVO = new BusinessProcessVO();
		businessProcessVO.setParamMap(paramMap);

		try {
			result = workflow.deployBusinessProcess(businessProcessVO);
			result = workflow.getBusinessProcess(result.getBusinessProcessVOList().get(0));
			businessProcessVO = result.getBusinessProcessVOList().get(0);
			JournalProcessDefinition processDefinition = JournalProcessDefinitionLocalServiceUtil.createJournalProcessDefinition(Long.valueOf(businessProcessVO.getId()));
			processDefinition.setName(businessProcessVO.getName());
			processDefinition.setVersion(businessProcessVO.getVersion());
			processDefinition.setContent(xml);

			JournalProcessDefinitionLocalServiceUtil.updateJournalProcessDefinition(processDefinition, false);
		} catch (WorkflowException e) {
			e.printStackTrace();
		} catch (SystemException e) {			
			e.printStackTrace();
		} 
		return result;
	}
	
	public static OutputVO startBusinessProcess(long bpId, long articleId, long userId) {
		OutputVO result = new OutputVO();
		BusinessProcessVO businessProcessVO = new BusinessProcessVO();
		businessProcessVO.setId(String.valueOf(bpId));
		businessProcessVO.setUserId(String.valueOf(userId));
		try {
			result = workflow.startBusinessProcess(businessProcessVO);
			BusinessProcessInstanceVO instanceVO = result.getBusinessProcessInstanceVOList().get(0);
			TokenVO tokenVO = instanceVO.getToken();
			List<TagsEntry> entries = ArticleUtil.getCategoryOfArticle(articleId);
			
			InstanceBean instanceBean = InstanceBeanLocalServiceUtil.createInstanceBean(Long.valueOf(instanceVO.getId()));
			instanceBean.setArticleId(articleId);
			if (entries.size() > 0) {
				instanceBean.setCategoryId(entries.get(0).getEntryId());
			}
			instanceBean.setBusinessProcessId(bpId);
			instanceBean.setCreateUserId(Long.valueOf(userId));
			instanceBean.setStatus(tokenVO.getNode().getName());
			instanceBean.setFinish(false);
			workflow.signalBusinessProcessInstance(instanceVO);
			result = workflow.getBusinessProcessInstances(instanceVO);
			tokenVO = result.getBusinessProcessInstanceVOList().get(0).getToken();
			instanceBean.setPreviousNode(instanceBean.getStatus());
			instanceBean.setStatus(tokenVO.getNode().getName());
			InstanceBeanLocalServiceUtil.updateInstanceBean(instanceBean, false);
		} catch (WorkflowException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static OutputVO checkoutTask(long taskId, long userId) {
		OutputVO outputVO = new OutputVO();
		CheckoutTaskVO checkoutTaskVO = new CheckoutTaskVO();
		List<String> list = new ArrayList<String>();
		list.add(String.valueOf(taskId));
		checkoutTaskVO.setTaskIdList(list);
		checkoutTaskVO.setUserId(String.valueOf(userId));
		try {
			outputVO = workflow.checkoutTasks(checkoutTaskVO);
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return outputVO;
	}
	
	public static OutputVO checkoutTasks(long instanceId, long userId, String nodeName) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		TokenVO tokenVO = new TokenVO();
		FilterTaskVO filterTaskVO = new FilterTaskVO();
		List<TaskVO> taskVOs = new ArrayList<TaskVO>();
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);			
			tokenVO = businessProcessInstanceVO.getToken();
			if (tokenVO.getNode().getName().equals(nodeName)) {
				filterTaskVO.setToken(tokenVO);
				outputVO = workflow.getTasks(filterTaskVO);
				taskVOs = outputVO.getTaskVOList();
				for (TaskVO taskVO : taskVOs) {
					outputVO = checkoutTask(new Long(taskVO.getId()).longValue(), userId);
				}
			}
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		
		return outputVO;
	}
	
	public static OutputVO checkoutTasks(long instanceId, long userId) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		TokenVO tokenVO = new TokenVO();
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			tokenVO = businessProcessInstanceVO.getToken();
			outputVO = checkoutTasks(instanceId, userId, tokenVO.getNode().getName());
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return outputVO;
	}
	
	public static OutputVO completeTasks(long instanceId, long userId, String nodeName) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		TokenVO tokenVO = new TokenVO();
		FilterTaskVO filterTaskVO = new FilterTaskVO();
		List<TaskVO> taskVOs = new ArrayList<TaskVO>();
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);			
			tokenVO = businessProcessInstanceVO.getToken();
			if (tokenVO.getNode().getName().equals(nodeName)) {
				filterTaskVO.setToken(tokenVO);
				outputVO = workflow.getTasks(filterTaskVO);
				taskVOs = outputVO.getTaskVOList();
				for (TaskVO taskVO : taskVOs) {
					outputVO = completeTask(new Long(taskVO.getId()).longValue(), userId, instanceId);
				}
			}
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		
		return outputVO;
	}
	
	public static OutputVO completeTasks(long instanceId, long userId) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		TokenVO tokenVO = new TokenVO();
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			tokenVO = businessProcessInstanceVO.getToken();
			outputVO = completeTasks(instanceId, userId, tokenVO.getNode().getName());
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return outputVO;
	}
	
	public static OutputVO completeTask(long taskId, long userId, long instanceId) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		CompleteTaskVO completeTaskVO = new CompleteTaskVO();
		List<String> list = new ArrayList<String>();
		list.add(String.valueOf(taskId));
		completeTaskVO.setTaskIdList(list);
		completeTaskVO.setUserId(String.valueOf(userId));
		TokenVO tokenVO = new TokenVO();
		
		try {
			outputVO = workflow.completeTasks(completeTaskVO);
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			tokenVO = businessProcessInstanceVO.getToken();
			InstanceBean instanceBean = InstanceBeanLocalServiceUtil.getInstanceBean(instanceId);
			instanceBean.setPreviousNode(instanceBean.getStatus());
			instanceBean.setStatus(tokenVO.getNode().getName());
			if (businessProcessInstanceVO.getEndDate() != null) {
				instanceBean.setFinish(true);
				JournalArticle article = JournalArticleLocalServiceUtil.getArticle(instanceBean.getArticleId());
				article.setApproved(true);
				User user = UserLocalServiceUtil.getUser(userId);
				article.setApprovedByUserId(userId);
				article.setApprovedByUserUuid(user.getUuid());
				JournalArticleLocalServiceUtil.updateJournalArticle(article);
			}
			
			InstanceBeanLocalServiceUtil.updateInstanceBean(instanceBean, true);
			
		} catch (WorkflowException e) {
			e.printStackTrace();
		} catch (NoSuchInstanceBeanException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return outputVO;
	}
	
	public static OutputVO getBusinessProcessInstances(long bpid, String nodeName) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessVO businessProcessVO = new BusinessProcessVO();
		businessProcessVO.setId(String.valueOf(bpid));
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setBusinessProcess(businessProcessVO);
		List<BusinessProcessInstanceVO> businessProcessInstanceVOs = new ArrayList<BusinessProcessInstanceVO>();
		TokenVO tokenVO = new TokenVO();
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVOs = outputVO.getBusinessProcessInstanceVOList();
			for (BusinessProcessInstanceVO instanceVO : businessProcessInstanceVOs) {
				tokenVO = instanceVO.getToken();
				if (!tokenVO.getNode().getName().equals(nodeName)) {
					businessProcessInstanceVOs.remove(instanceVO);
				}
			}
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		
		outputVO.setBusinessProcessInstanceVOList(businessProcessInstanceVOs);
		
		return outputVO;
	}
	
	public static OutputVO getBusinessProcessInstance(long instanceId) {
		OutputVO outputVO = new OutputVO();
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		try {
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return outputVO;
	}

	public static OutputVO goBack(long instanceId, long userId, long articleId) {
		OutputVO outputVO = new OutputVO();
		InstanceBean instanceBean = null;
		InstanceBean newInstanceBean = null;
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		BusinessProcessInstanceVO newBusinessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		TokenVO current = new TokenVO();
		TokenVO temp = new TokenVO();
		String previousNode = "";
		
		try {
			instanceBean = InstanceBeanLocalServiceUtil.getInstanceBean(instanceId);
			previousNode = instanceBean.getPreviousNode();
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			current = businessProcessInstanceVO.getToken();
			outputVO = startBusinessProcess(instanceBean.getBusinessProcessId(), articleId, userId);
			newBusinessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			outputVO = workflow.getBusinessProcessInstances(newBusinessProcessInstanceVO);
			newBusinessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			temp = newBusinessProcessInstanceVO.getToken();
			
			newInstanceBean = InstanceBeanLocalServiceUtil.getInstanceBean(Long.valueOf(newBusinessProcessInstanceVO.getId()));
			
			while (!temp.getNode().getName().equals(previousNode)) {
				workflow.signalToken(temp);
				outputVO = workflow.getBusinessProcessInstances(newBusinessProcessInstanceVO);
				temp = outputVO.getBusinessProcessInstanceVOList().get(0).getToken();
				if (newInstanceBean.getStatus() != null) newInstanceBean.setPreviousNode(newInstanceBean.getStatus());
				newInstanceBean.setStatus(temp.getNode().getName());
			}
			workflow.deleteBusinessProcessInstance(businessProcessInstanceVO);
			InstanceBeanLocalServiceUtil.deleteInstanceBean(instanceBean);
			InstanceBeanLocalServiceUtil.updateInstanceBean(newInstanceBean, false);
		} catch (WorkflowException e) {
			e.printStackTrace();
		} catch (NoSuchInstanceBeanException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return outputVO;
	}
	
	public static void deleteInstanceArticle(long instanceId, long userId, long articleId) {
		OutputVO outputVO = new OutputVO();
		InstanceBean instanceBean = null;
		BusinessProcessInstanceVO businessProcessInstanceVO = new BusinessProcessInstanceVO();
		businessProcessInstanceVO.setId(String.valueOf(instanceId));
		try {
			instanceBean = InstanceBeanLocalServiceUtil.getInstanceBean(instanceId);
			outputVO = workflow.getBusinessProcessInstances(businessProcessInstanceVO);
			businessProcessInstanceVO = outputVO.getBusinessProcessInstanceVOList().get(0);
			
			workflow.deleteBusinessProcessInstance(businessProcessInstanceVO);
			InstanceBeanLocalServiceUtil.deleteInstanceBean(instanceBean);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		
	}
	
}
