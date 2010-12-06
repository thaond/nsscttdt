/**
 * 
 */
package com.sgs.jbpm.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jbpm.JbpmException;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Required;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

/**
 * This class creates methods (API) support 
 *         for access data in data in jBPM database         
 * @author minhnv
 * @Date 9/04/2009
 */
public interface JbpmService {
	

	/**
	 * This method use to parse  definition xml file become ProcessDefinition object 
	 * @param processXmlResource: path to process definition xml file 
	 * @return ProcessDefinition: if parsed from process definition xml successfully 
	 * @return null: if parsed from definition file unsuccessfully and
	 *         throw exception
	 */
	public ProcessDefinition parseXMLResource(String processXmlResource);
	
	/**
	 * This method Deploys a process definition into jBPM database from xml file name
	 * @param processXmlResource: path to process definition xml file
	 * if deploy no success will throw exception
	 */
	public void deployProcessDefinition(String processXmlResource);
	
	/**
	 * This method deploys the given ProcessDefinition to the jBPM database
	 * @param processDefinition: is object support in jBPM
	 * if deploy no success will throw exception
	 */
	public void deployProcessDefinition(
			final ProcessDefinition processDefinition);

	/**
	 * This method finds the latest definition of a process in jBPM database
	 * @param processName: is process definition xml file name 
	 * @return latest ProcessDefinition if has in jBPM database
	 * @return null if no has in jBPM database and throw exception
	 */
	public ProcessDefinition findLatestProcessDefinition(
			final String processName);

	/**
	 * This method creates an instance of the latest process definition for the given
	 *         process name. The returned process instance is left in the start state.
	 * @param processName: name of process definition 
	 * @return ProcessInstance: is new instance of process definition
	 *		   if process definition has deployed
	 * @return null if process definition hasn't deployed and throw exception 	 			 		
	 */
	public ProcessInstance createProcessInstance(final String processName);
	
	/**
	 * This method sets a (name, value) pair into concrete process definition  
	 * @param processInstanceId: id of a instance process definition
	 * @param name: name of variable want save
	 * @param value: value of variable want save with concrete name
	 * @exception if no has concrete process instance
	 */
	public void setContext(final long processInstanceId, final String name,
			final Object value);


	/**
	 * This method finds value of variable with concrete variable name
	 * @param processInstanceId: id of a instance process definition 
	 * @param name: is name of variable to find value 
	 * @return Object: is value of variable if variable name
	 *         has concrete process definition
	 * @return null: if variable name no has concrete process definition
	 *         and throw exception            
	 */
	public Object getContextVariable(final long processInstanceId,
			final String name);
	
	/**
	 * this method find all instance task in a instance of process definition
	 * @param processInstanceId: id of a instance process definition
	 * @return Collection: a collection of taskInstances with instance of process definition
	 *         if a instance of process definition exist
	 * @return null: if a instance of process definition no exist and
	 * 		   throw exception	      
	 */
	public Collection findTaskInstances(final long processInstanceId);

	/**
	 * This method instructs the main path of execution to continue by taking the default
	 *         transition on the current node.
	 * @param processInstanceId: id of a instance process definition
	 * @exception: if a instance of process definition no exist
	 */
	public void signalProcessInstance(final long processInstanceId);

	/**
	 * This method instructs the path of execution associated with the given token to
	 *         continue by taking the default transition to the next node.
	 * @param processInstance:
	 *         the ProcessInstance that the token is associated with
	 * @param tokenName: the full name of the token
	 * @throws JbpmException: if a token with the given name could not be found
	 *         within the tree of the processInstance's root token
	 */
	public void signalToken(final ProcessInstance processInstance,
			final String tokenName);

	/**
	 * This method retrieves an instance of a jBPM process definition in database
	 * @param processInstanceId:internal database Id of instance
	 * @return ProcessInstance: process definition instance from database if this instance has exist
	 * @return null: if process definition instance no exist
	 */
	public ProcessInstance getProcessInstance(final long processInstanceId);

	/**
	 * This method end an instance of a jBPM process definition in database
	 * @param processInstanceId:internal database Id of instance
	 * @return true: process definition instance from database has ended
	 * @return false: if process definition instance  didn't has ended
	 */
	public boolean endProcessInstance(final long processInstanceId);

	/**
	 * This method deletes the latest definition of a process from the jBPM database
	 * @param processName: name of process definition
	 * @exception: if name of process definition no has in database
	 */
	public void deleteLatestProcessDefinition(final String processName);

	/**
	 * This is deletes the latest definition of a process from the jBPM database
	 * @param processdefinitionId: id of process definition instance
	 * @exception: if id of process definition instance no has in database
	 */
	public void deleteProcessDefinition(final long processdefinitionId);

	/**
	 * this method check a process definition has ended ? 
	 * @param processInstanceId: id of process definition instance
	 * @return true: if process definition has ended
	 * @return false: if process definition hasn't ended 
	 */
	public boolean hasProcessInstanceEnded(final long processInstanceId);
	
	/**
	 * Cascade Drops all jBPM tables and sequences
	 */
	public void dropSchema();

	/**
	 * Setter JbpmTemplate object for spring
	 * @param jbpmTemplate
	 */
	@Required
	public void setJbpmTemplate(JbpmTemplate jbpmTemplate);

	/**
	 * This method gets list task instance from jBPM Database with concrete userId
	 * @param idUser: id of concrete user
	 * @return List<TaskInstance>: if user has task in process definitions
	 * @return list empty: if user hasn't task in process definitions
	 */
	public List<TaskInstance> getListTasksUser(final long userId);
	
	/**
	 * This method gets list task instance from jBPM Database with current node
	 * @param processInstanceId: id of process definition instance
	 * @return List<TaskInstance>: if process definition instance exist
	 * @return list empty: if process definition instance no exist
	 */
	public List<TaskInstance> getListTasksNode(final long processInstanceId);

	/**
	 * This meth0d ends a task instance with concrete taskId
	 * @param taskId : id of concrete task
	 * @exception: if taskId no exits 
	 */
	public void endTaskInstance(final long taskId);

	/**
	 * This method gets list name of workflows in jBPM database
	 * @return List<String> : contain list name of workflows deploy in jBPM database
	 * @return list empty : no has workflows deploy in jBPM database
	 */
	public List<String> getNameWorkflows();

	/**
	 * This method assigns an user into instance task in a process definition instance
	 * @param taskInstanceId: is id of a task instance
	 * @param userId: is id of a user need to assigns a task instance
	 * @exception: if task instance no exist
	 */
	public void assignUserToTaskIntance(final long taskInstanceId,
			final long userId);

	/**
	 * This method gets name of instance task with concrete TaskInstance
	 * @param taskInstance: is instance of concrete task
	 * @return String : is name of instance task if instance of task exist
	 * @return null: if instance of task no exist 
	 */
	public String getNameTaskIntance(final TaskInstance taskInstance);

	/**
	 * This method gets instance of task with id of concrete task
	 * @param taskid: id of concrete task
	 * @return TaskInstance : is instance of a concrete task if this task exist 
	 * @return null: if this task no exist 
	 */
	public TaskInstance getTaskInstance(final long taskid);

	/**
	 * This method sets description of task instance 
	 * @param description: is description need to set for concrete task 
	 * @param taskid: is of concrete task instance
	 * @exception: if task instance no exist
	 */
	public void setDesciptionTask(final String description, final long taskid);

	/**
	 * This method gets description with of task instance
	 * @param taskid: is of concrete task instance 
	 * @return String: is description of a task if task instance exist
	 * @return null: if task instance no exist
	 */
	public String getDesciptionTask(final long taskid);

	/**
	 * This method gets name of current node in process definition instance
	 * @param processInstanceId: id of process definition instance
	 * @return String: is name of node if process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public String getNodeName(final long processInstanceId);

	/**
	 * This method gets List instance of process definition of concrete user in jBPM database
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>: is list instance of process definitions
	 *         with concrete user if process definitions contain this user
	 * @return list empty: if process definitions doesn't contain this user         
	 */
	public List<ProcessInstance> getListProcessInstanceOfActor(final long userId);

	/**
	 * This method gets List instance of process definition of PooledActor from 
	 *         concrete user in this PooledActor from jBPM database
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>: list instance of process definition of
	 *         PooledActor contain concrete user
	 * @return list empty: if PooledActor doen't contain concrete user        
	 */
	public List<ProcessInstance> getListProcessInstanceOfPooledActor(
			final long userId);

	/**
	 * This method gets all ProcessInstance has contains user or group of this user
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>:  list process definition instance if this user 
	 *         exist in process definition instances
	 * @return empty: if this user no exist in process definition instances         
	 */
	public List<ProcessInstance> getListProcessInstanceOfActorOrPooledActor(
			final long userId);

	/**
	 * This method gets list task instance with a concrete PooledActor (a group user) 
	 * @param userIds: a group user id 
	 * @return List<TaskInstance>: is list task instance if PooledActor exist
	 *         in process definition instances
	 * @return null: if PooledActor no exist in process definition instances        
	 */
	public List<TaskInstance> getListTaskInstanceOfPooledActor(
			final List<String> userIds);

	/**
	 * This method assigns pooledActor(a group userId) to task instance
	 * @param userIds: a group user id
	 * @exception: if task instance no exist 
	 */
	public void assignPooledActorToTaskInstance(final long taskInstanceId,
			final String[] userIds);

	/**
	 * This method gets List name task instance contain a user 
	 * @param userId: id of user need to get name task instance
	 * @return List<String>: list name task instance if task instances contain 
	 *         this user
	 * @return list empty: if task instances no contain this user
	 */
	public List<String> getListNameTasksUser(final long userId);
	
	/**
	 * This method gets current node at position process definition instance stand
	 * @param processInstanceId: id of process definition instance
	 * @return Node: is node of a concrete workflow if process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public Node getNodeCurrent(final long processInstanceId);
	
	/**
	 * This methods gets id of a task instance in a process definition instance 
	 * @param taskInstanceId: is task instance in a process definition instance
	 * @return String: is id of user in task instance if task instance exist
	 * @return null: if task instance no exist
	 */
	public String getUserId(final long taskInstanceId);
	
	/**
	 * This method finds process definition with name process definition and version in jBPM database
	 * @param processName: is name of process definition 
	 * @param version: is version deploy of process definition in jBPM database
	 * @return ProcessDefinition: is process definition if name or version exist in jBPM database
	 * @return null:if name or version no exist in jBPM database
	 */
	public ProcessDefinition findProcessDefinitionWithNameAndVersion(final String processName,final int version);
	
	/**
	 * This method gets date begin start of a process definition instance
	 * @param processInstanceId: id of a process definition instance
	 * @return Date: is date start of a process definition instance  if 
	 *         process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public Date getStartDateProcessInstance(final long processInstanceId);
	
	/**
	 * This method gets date end of a process definition instance
	 * @param processInstanceId: id of a process definition instance
	 * @return Date: is end date  of a process definition instance  if 
	 *         process definition instance exist
	 * @return null: if process definition instance no exist or process 
	 *         definition instance doesn't end
	 */
	public Date getEndDateProcessInstance (final long processInstanceId);
	
	/**
	 * This method gets date begin start of task instance
	 * @param taskId: id of a task instance
	 * @return Date: is date start of task instance if task instance exist
	 * @return null: if task instance no exist 
	 */
	public Date getStartDateTask(final long taskId);
	
	/**
	 * This method gets date end of task instance
	 * @param taskId: id of a task instance
	 * @return Date: is date end of task instance if task instance exist
	 * @return null: if task instance no exist 
	 */
	public Date getEndDateTask(final long taskId);
	
	/**
	 * This method gets map of node with list task instance with concrete user  
	 * @param userId: id of concrete user
	 * @return Map<Node,List<TaskInstance>>: if process definition contain this user
	 * @return Map empty : if process definition doesn't contain this user 
	 */
	public Map<Node, List<TaskInstance>> getNodesAndNestedTaskByUserId(
			long userId);
	
	/**
	 * This method signal task instance with concrete transition
	 * @param taskId: id of task instance
	 * @param transition: name of path but task instance after end will go to
	 * @exception: if task instance no exist
	 */
	public void signalTask(final long taskId, final String transition);
	
	/**
	 * This method creates a process definition instance with name of process and version
	 * @param processName: name of process has deployed in jBPM database
	 * @param version: is version of process has deployed in jBPM database
	 * @return ProcessInstance: is process definition instance if process has 
	 *         deployed in jBPM database with name and version  
	 * @return null: if process hasn't deployed in jBPM database with name and version 
	 */
	public ProcessInstance createProcessInstanceHasVersion(final String processName, final int version);
	
	/**
	 * This method deploys process definition by xml inputstream.
	 * @param inputStream: is stream create from  xml definition file
	 * @return ProcessDefinition: is a process definition if deploy successful
	 * @return null: if process definition deploy unsuccessful
	 */
	public ProcessDefinition deployProcessDefinition(InputStream inputStream);
	
	/**
	 * This method deletes a process definition by given name and version.
	 * @param processName: is name of process definition
	 * @param version: is version of process definition
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#deleteWorkflow(java.lang.String, int)
	 * @exception: if process name and version doesn't find in jBPM database
	 */
	public void deleteProcessDefinitionhasVersion(final String processName,final int version) ;
	
	/**
	 * This method get PooledActor(a group user) of concrete task instance 
	 * @param taskInstanceId: is id of task instance 
	 * @return List<String>: is list id of user if task instance exist
	 * @return list empty: if task instance no exist
	 */
	public List<String> getPooledActor(final long taskInstanceId);
	
	/**
	 * This method gets Token from concrete task instance.
	 * @param taskInstanceId: id of task instance 
	 * @return Token: is token of TaskInstance if task instance exist.
	 * @return null: if task instance no exist
	 */
	public Token getTokenFromTaskInstance(final long taskInstanceId);
	
	/**
	 * This method gets process definition instance from concrete task instance.
	 * @param taskInstanceId: id of task instance 
	 * @return ProcessInstance: is processInstance contain TaskInstance if
	 *         task instance exist
	 * @return null: if task instance no exits        
	 */
	public ProcessInstance getProcessInstanceFromTaskInstance(final long taskInstanceId);
	
	/**
	 * This method gets process definition instance from concrete Token.
	 * @param tokenId: id of token to get process definition instance 
	 * @return ProcessInstance: is processInstance contain this token if 
	 *         this token exist
	 * @return null: if this token no exist          
	 */
	public ProcessInstance getProcessInstanceFromToken(final long tokenId);
	
	
	/**
	 * This method gets all node in a process definition has deployed in jBPM
	 *         database with name and version
	 * @param processName: name of process definition has deployed in jBPM database 
	 * @param version: version of process definition has deployed in jBPM database
	 * @return List<Node>: is list node of process definition if process definition 
	 *        finds in jBPM database with name and version
	 * @return null: if process definition does'n find in jBPM database with name and version        
	 */
	public List<Node> getListNode(final String processName, final int version);
	
	/**
	 * This method deletes a process definition instance 
	 * @param processInstanceId: id of process definition instance
	 * @exception if process definition instance no exist
	 */
	 public void deleteProcessInstance(final long processInstanceId);
	 
	 /**
	  * This method check current task instance has contain user ? 
	  * @param processInstanceId: id of process definition instance
	  * @param userId: id of user need to check in current task instances 
	  * @return true: if user id has in current task instances
	  * @return false:  if user id doesn't has in current task instances
	  */
	 public boolean checkUserInCurrentTasks(final long processInstanceId, final String userId);
	 
	 /**
	  * This method ends all current Task instances of process instance
	  * @param processInstanceId: id of process definition instance
	  * @exception: if process definition instance no exist
	  */
	 public void endAllCurrentTaskInstances(final long processInstanceId);
	 
	 /**
	  * This method get all node name in xml process definition file  
	  * @param processXmlResource: is path plus file name of process definition
	  * @return List<String>: is list node name in process definition if
	  *         xml process definition file parse successfully 
	  * @return list empty: if xml process definition file no parse successfully
	  */
	 public List<String> getListNodeName(String processXmlResource);
	 
	 /**
	  * This method get get all node name from process definition
	  * @param processDefinition: is process definition of process 
	  * @return List<String>: list node name if process definition isn't null
	  * @return list empty: if process definition is null
	  */
	 public List<String> getListNodeName(ProcessDefinition processDefinition);
	 
	 /**
	 * get main process path name of workflow  
	 * @param nameProcess
	 * @param version
	 * @param numberMain
	 * @return List<String>
	 *
	 */
	 public List<String[]> getNameTransitionMain(final String nameProcess, final int version, final int numberMain ) ;
	 
	 
	 /**
	 * get main process path name of workflow  sort
	 * @param nameProcess
	 * @param version
	 * @param numberMain
	 * @return List<String>
	 *
	 */
	 public List<String[]> getNameTransitionMainNode(final String nameProcess, final int version, final int numberMain );
	 
	 public List<ProcessInstance> getListProcessInstanceOfActor(final String userId);
	 
	 /**
	  * Get ProcessInstance list with user and process state list
	  * @param userId
	  * @param processState
	  * @return
	  * List<ProcessInstance>
	  * Jun 25, 2009
	  * com.sgs.jbpm.service
	  *
	  */
	 public List<ProcessInstance> getListProcessInstanceOfActorWithState(final long userId, final List<String> processState);
	 
	 /**
	  * gets processinstances of user had process
	  * @param userId
	  * @return
	  * List<Long>
	  * Aug 24, 2009
	  * com.sgs.jbpm.service
	  *
	  */
	 public List<ProcessInstance> getListProcessInstancesUserHadProcess(final long userId);
	 
	 /**
	  * gets processinstances of user had process with state process 
	  * @param userId
	  * @param processState
	  * @return
	  * List<ProcessInstance>
	  * Aug 24, 2009
	  * com.sgs.jbpm.service
	  *
	  */
	 public List<ProcessInstance> getListProcessInstanceOfActorHadProcessWithState(final long userId, final List<String> processState);
	 public List<ProcessInstance> getListProcessInstanceFromProcessDefinition(final long processDefinitionId);
}
