/**
 * 
 */
package com.sgs.liferay.jbpm.service;

import java.io.InputStream;
import java.util.List;

import org.jbpm.graph.def.ProcessDefinition;

import com.liferay.portal.model.User;
import com.sgs.liferay.jbpm.component.TaskAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

/**
 * @author hieuvh
 *
 */
public interface LiferayWorkflowService {
	
	/**
	 * @param processInstanceId
	 * @return
	 */
	List<TaskAction> getTaskActions(long processInstanceId);
	
	/**
	 * @param taskInstanceId
	 * @return
	 */
	TaskAction getTaskAction(long taskInstanceId);
	
	/**
	 * @param params
	 */
	void addWorkflowInstance(List<WorkflowParam> params);
	
	/**
	 * signal a task instance with given parameters
	 * @param params list of parameters of workflow 
	 */
	void signalTask(List<WorkflowParam> params);
	
	/**
	 * signal a task instance with given taskId end transition, set receiver as actorId of
	 * all task instance of next node.
	 * @param taskId
	 * @param transition
	 * @param receiver
	 */
	void signalTask(long taskId, String transition, String receiver);
	
	/**
	 * Get number day complete of a node
	 * @param processInstanceId
	 * @return int
	 */
	public int getNumberDayOfNode (final long processInstanceId);

	/**
	 * get state of a node of a instance definition  
	 * @param processInstanceId
	 * @return String
	 */
	public String getStateNode (final long processInstanceId);
	
	/**
	 * 
	 * @param processName
	 * @param version
	 * @return
	 * Mar 6, 2009
	 */
	public int getTimeWorkflow(final String processName, final int version);
	
	/**
	 * get pooled Actor of taskinstance.
	 * @param taskInstance
	 * @return list of liferay User
	 */
	public List<User> getPooledUser(long taskInstance);
	
	/**
	 * deploy process definition by xml inputstream.
	 * @param inputStream
	 * @return a process definition if deploy successful
	 */
	public ProcessDefinition deployWorkflow(InputStream inputStream);
	
	/**
	 * delete a process definition by given name and version.
	 * @param nameWorkFlow name of process definition
	 * @param version version of process definition
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#deleteWorkflow(java.lang.String, int)
	 */
	public void deleteWorkflow(String nameWorkFlow, int version);
}
