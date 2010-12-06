package com.sgs.liferay.jbpm.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.context.ApplicationContext;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.jbpm.service.JbpmService;
import com.sgs.liferay.jbpm.component.TaskAction;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public abstract class AbstractLiferayWorkflowService implements
		LiferayWorkflowService {
	private final static Logger log = Logger
			.getLogger(AbstractLiferayWorkflowService.class);
	private static ApplicationContext applicationContext = new org.springframework.context.support.ClassPathXmlApplicationContext(
			"META-INF/jbpm-spring.xml");

	private JbpmService jbpmService = (JbpmService) applicationContext
			.getBean("jbpmService");


	protected final static String STATE_SEPARATOR = ":";
	protected final static String USER_PREFIX = "#";

	/**
	 * @return the jbpmService
	 */
	public JbpmService getJbpmService() {
		return jbpmService;
	}

	/**
	 * @param jbpmService
	 *            the jbpmService to set
	 */
	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#signalTask(long,
	 * java.lang.String)
	 */
	public void signalTask(long taskId, String transition, String receiver) {
		ProcessInstance pi = getJbpmService()
				.getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiver);
		getJbpmService().signalTask(taskId, transition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#getTaskAction(long)
	 */
	public TaskAction getTaskAction(long taskInstanceId) {

		TaskInstance taskInstance = getJbpmService().getTaskInstance(
				taskInstanceId);

		String nameTask = this.getJbpmService()
				.getNameTaskIntance(taskInstance);

		String[] arrayInfo = nameTask.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);
		TaskAction taskAction = null;

		if (arrayInfo.length == 3) {
			taskAction = new TaskAction();
			taskAction.setTaskInstanceId(taskInstanceId);
			taskAction.setForm(arrayInfo[0].trim());
			taskAction.setTaskActionName(arrayInfo[1].trim());
			taskAction.setTransition(arrayInfo[2].trim());
		}

		return taskAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#getTaskActions(long)
	 */
	public List<TaskAction> getTaskActions(long processInstanceId) {
		
		List<TaskInstance> listTasks = this.getJbpmService().getListTasksNode(
				processInstanceId);

		List<TaskAction> listTaskAction = new ArrayList<TaskAction>();
		TaskAction taskAction = null;

		for (TaskInstance taskInstance : listTasks) {

			if (taskInstance != null) {
				String nameTask = this.getJbpmService().getNameTaskIntance(
						taskInstance);
				String[] arrayInfo = nameTask.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);

				if (arrayInfo.length == 3) {
					taskAction = new TaskAction();
					taskAction.setTaskInstanceId(taskInstance.getId());
					taskAction.setForm(arrayInfo[0].trim());
					taskAction.setTaskActionName(arrayInfo[1].trim());
					taskAction.setTransition(arrayInfo[2].trim());
					listTaskAction.add(taskAction);
				}
			}
		}

		return listTaskAction;
	}

	/**
	 * 
	 * @param processName
	 * @param version
	 * @return total time on each node in workflow
	 */
	public int getTimeWorkflow(final String processName, final int version) {
		
		List<Node> listNodes = this.jbpmService.getListNode(processName, version);
		int totalTime = 0;
		
		try {
			for(Node node : listNodes) {
				String nodeName = node.getName();
				
				if (nodeName.contains(AbstractLiferayWorkflowService.STATE_SEPARATOR)) {
					totalTime += Integer.parseInt(nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR)[1]);
				}
				else {
					totalTime +=0 ;
				}
			}
		} catch (Exception e) {
			log.error("ERROR: No get Total Time Of Workflow");
			e.printStackTrace();
		}
		
		return totalTime;
	}

	/**
	 * get state of a node of a instance definition
	 * 
	 * @param nodeId
	 * @return state of node
	 */
	public String getStateNode (final long processInstanceId) {
		String nodeName =this.jbpmService.getNodeName(processInstanceId);
		String nodeState = null;		
		try{
		if(nodeName.contains(AbstractLiferayWorkflowService.STATE_SEPARATOR)){
			nodeState = nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR)[0];
		}
		else{
			nodeState = nodeName;
		}
		}catch (Exception e) {
			log.equals("ERROR: No Get State Of Node");
			e.printStackTrace();
		}
		
		return nodeState;
	}

	/**
	 * get number day work of a node
	 * 
	 * @param nodeId
	 * @return number day of a node
	 */
	public int getNumberDayOfNode(final long processInstanceId) {
		String nodeName =this.jbpmService.getNodeName(processInstanceId);
		int numDayOfNode = 0;
		try{
		if(nodeName.contains(AbstractLiferayWorkflowService.STATE_SEPARATOR)){
			numDayOfNode = Integer.parseInt(nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR)[1]);
		}		
		}catch (Exception e) {
			log.equals("ERROR: No Get Number Day Of Node");
			e.printStackTrace();
		}
		
		
		return numDayOfNode;
	}
	
	/**
	 * get pooled Actor of taskinstance.
	 * @param taskInstance
	 * @return list of liferay User
	 */
	public List<User> getPooledUser(long taskInstance) {

		List<String> listUserId = getJbpmService().getPooledActor(taskInstance);
		List<User> results = new ArrayList<User>();
		
		try {
			if (listUserId == null) {
				return results;
			}
			
			for (Iterator iterator = listUserId.iterator(); iterator.hasNext();) {
				String userId = (String) iterator.next();
				if (userId != null && !"".equals(userId.trim())&& !userId.contains(USER_PREFIX)) {
					results.add(UserLocalServiceUtil.getUser(Long.parseLong(userId)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
	/**
	 * get all users process  parallel with concrete user
	 * @param taskInstance
	 * @return List<User>
	 *
	 */
	
	public List<User> getPooledUserparallel(long taskInstance) {

		List<String> listUserId = getJbpmService().getPooledActor(taskInstance);
		List<User> results = new ArrayList<User>();
		
		try {
			if (listUserId == null) {
				return results;
			}
			
			for (Iterator iterator = listUserId.iterator(); iterator.hasNext();) {
				String userId = (String) iterator.next();
				if (userId != null && !"".equals(userId.trim())&& userId.contains(USER_PREFIX)) {
					results.add(UserLocalServiceUtil.getUser(Long.parseLong(userId)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	/**
	 * deploy process definition by xml inputstream.
	 * @param inputStream
	 * @return a process definition if deploy successful
	 */
	public ProcessDefinition deployWorkflow(InputStream inputStream) {
		return getJbpmService().deployProcessDefinition(inputStream);
	}

	/**
	 * delete a process definition by given name and version.
	 * @param nameWorkFlow name of process definition
	 * @param version version of process definition
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#deleteWorkflow(java.lang.String, int)
	 */
	public void deleteWorkflow(String nameWorkFlow, int version) {
		try {
			this.getJbpmService().deleteProcessDefinitionhasVersion(nameWorkFlow,
					version);
		} catch (Exception e) {
		}
	}
}