package com.sgs.jbpm.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.db.GraphSession;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springmodules.workflow.jbpm31.JbpmCallback;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

/**
 * This class implement methods (API) support 
 *         for access data in data in jBPM database 
 * @author minhnv
 *
 */
public class JbpmServiceImpl implements JbpmService {
	
	private final static Logger log = Logger.getLogger(JbpmServiceImpl.class);

	protected JbpmConfiguration jbpmConfiguration;
	protected HibernateTemplate hibernateTemplate ;
	protected JbpmTemplate jbpmTemplate;
	
	/**
	 * This method use to parse  definition xml file become ProcessDefinition object 
	 * @param processXmlResource: path to process definition xml file 
	 * @return ProcessDefinition: if parsed from process definition xml successfully 
	 * @return null: if parsed from definition file unsuccessfully and
	 *         throw exception
	 */
	public ProcessDefinition parseXMLResource(String processXmlResource) {
		ProcessDefinition processDefinition = null;
		
		try {
			processDefinition = ProcessDefinition
					.parseXmlResource(processXmlResource);
		} catch (Exception e) {
			log.error("*****  ERROR: Can't Parse File Definition xml  *****");
		}
		
		return processDefinition;
	}

	/**
	 * This method Deploys a process definition into jBPM database from xml file name
	 * @param processXmlResource: path to process definition xml file
	 * if deploy no success will throw exception
	 */
	public void deployProcessDefinition(String processXmlResource) {
		
		final ProcessDefinition processDefinition = ProcessDefinition
				.parseXmlResource(processXmlResource);

		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					if (processDefinition != null) {
						context.deployProcessDefinition(processDefinition);
					}
				} catch (Exception e) {
					log.error("*****  ERROR: Can't Deploy File Definition xml Into Jbpm database *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}
	
	/**
	 * This method deploys process definition by xml inputstream.
	 * @param inputStream: is stream create from  xml definition file
	 * @return ProcessDefinition: is a process definition if deploy successful
	 * @return null: if process definition deploy unsuccessful
	 */
	public ProcessDefinition deployProcessDefinition(final InputStream inputStream) {		
		
		return (ProcessDefinition) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
			ProcessDefinition processDefinition = ProcessDefinition
				.parseXmlInputStream(inputStream);
				try {
					if (processDefinition != null) {
						context.deployProcessDefinition(processDefinition);
					}
				} catch (Exception e) {
					log.error("*****  ERROR: Can't Deploy File Definition xml With Inputstream Into Jbpm database *****");
					e.printStackTrace();
				}
				
				return processDefinition;
			}
		});
	}

	/**
	 * This method deploys the given ProcessDefinition to the jBPM database
	 * @param processDefinition: is object support in jBPM
	 * if deploy no success will throw exception
	 */
	public void deployProcessDefinition(final ProcessDefinition processDefinition) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
			
				try {
					context.deployProcessDefinition(processDefinition);
				} catch (Exception e) {
					log.error("*****  ERROR: Can't Deploy ProcessDefinition Into Jbpm database *****");
					e.printStackTrace();
				}
	
				return null;
			}
		});
	}

	/**
	 * This method finds the latest definition of a process in jBPM database
	 * @param processName: is process definition xml file name 
	 * @return latest ProcessDefinition if has in jBPM database
	 * @return null if no has in jBPM database and throw exception
	 */
	public ProcessDefinition findLatestProcessDefinition(
			final String processName) {
		
		return (ProcessDefinition) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				ProcessDefinition processDefinition = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					
					processDefinition = graphSession.findLatestProcessDefinition(processName);
					if(processDefinition != null) {
						Hibernate.initialize(processDefinition.getNodes());
					}
				} catch (Exception e) {
					log.error("***** ERROR: No Have ProcessDefinition In JBPM Database *****");
					e.printStackTrace();
				}
				return processDefinition;
			}
		});
	}

	/**
	 * This method creates an instance of the latest process definition for the given
	 *         process name. The returned process instance is left in the start state.
	 * @param processName: name of process definition 
	 * @return ProcessInstance: is new instance of process definition
	 *		   if process definition has deployed
	 * @return null if process definition hasn't deployed and throw exception 	 			 		
	 */
	public ProcessInstance createProcessInstance(final String processName) {
		return (ProcessInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = null;
				try {
					GraphSession graphSession = context.getGraphSession();
					
					ProcessDefinition processDefinition = graphSession
							.findLatestProcessDefinition(processName);
					processInstance = new ProcessInstance(processDefinition);
					Hibernate.initialize(processInstance.getRootToken());					
					Hibernate.initialize(processDefinition.getNodes());
					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Create Instance Of ProcessDefinition In JBPM Database *****");
					e.printStackTrace();
				}
				return processInstance;
			}
		});
	}
	
	

	/**
	 * This method sets a (name, value) pair into concrete process definition  
	 * @param processInstanceId: id of a instance process definition
	 * @param name: name of variable want save
	 * @param value: value of variable want save with concrete name
	 * @exception if no has concrete process instance
	 */
	public void setContext(final long processInstanceId, final String name,
			final Object value) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					GraphSession graphSession = context.getGraphSession();
					
					ProcessInstance processInstance = graphSession
							.getProcessInstance(processInstanceId);
					
					processInstance.getContextInstance().setVariable(name, value);
					
					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR:Can't Save Variable In JBPM Database *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

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
			final String name) {
		
		return this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				Object object = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
		
					ProcessInstance processInstance = graphSession
							.getProcessInstance(processInstanceId);
					
					ContextInstance ctx = processInstance.getContextInstance();
					
					object = ctx.getVariable(name);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get Value Of Variable In JBPM Database *****");
					e.printStackTrace();
				}
				
				return object;
			}
		});
	}

	/**
	 * this method find all instance task in a instance of process definition
	 * @param processInstanceId: id of a instance process definition
	 * @return Collection: a collection of taskInstances with instance of process definition
	 *         if a instance of process definition exist
	 * @return null: if a instance of process definition no exist and
	 * 		   throw exception	      
	 */
	@SuppressWarnings("unchecked")
	public Collection findTaskInstances(final long processInstanceId) {

		return (Collection) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				Collection taskInstances = null;
			
				try {
					GraphSession graphSession = context.getGraphSession();
					ProcessInstance processInstance = graphSession
							.getProcessInstance(processInstanceId);
				
					taskInstances = processInstance.getTaskMgmtInstance()
							.getTaskInstances();
					Hibernate.initialize(taskInstances);
					
					for (Object taskInstanceObj : taskInstances) {
						TaskInstance taskInstance = (TaskInstance) taskInstanceObj;
						Hibernate.initialize(taskInstance);
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find A Collection TaskInstance From JBPM Database *****");
					e.printStackTrace();
				}
				
				return taskInstances;
			}
		});
	}

	/**
	 * This method instructs the main path of execution to continue by taking the default
	 *         transition on the current node.
	 * @param processInstanceId: id of a instance process definition
	 * @exception: if a instance of process definition no exist
	 */
	public void signalProcessInstance(final long processInstanceId) {
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					GraphSession graphSession = context.getGraphSession();

					ProcessInstance processInstance = graphSession
							.getProcessInstance(processInstanceId);
					processInstance.signal();

					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Signal with This processInstanceId  *****");
					e.printStackTrace();
				}
			
				return null;
			}
		});
	}

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
			final String tokenName) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				try {
					GraphSession graphSession = context.getGraphSession();
				
					ProcessInstance signalProcessInstance = graphSession
							.getProcessInstance(processInstance.getId());
					
					Token token = signalProcessInstance.getRootToken()
							.findToken(tokenName);
					
					if (token == null) {
						throw new JbpmException(
								"token '" + tokenName + "'"
								+ " was not found in this processInstance (id="
								+ processInstance.getId() + ")");
					}

					token.signal();
					context.save(signalProcessInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find Token [ " + tokenName
							+ "] with This ProcessInstance [ "
							+ processInstance.getId() + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

	/**
	 * This method retrieves an instance of a jBPM process definition in database
	 * @param processInstanceId:internal database Id of instance
	 * @return ProcessInstance: process definition instance from database if this instance has exist
	 * @return null: if process definition instance no exist
	 */
	public ProcessInstance getProcessInstance(final long processInstanceId) {

		return (ProcessInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
			
				ProcessInstance processInstance = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					processInstance = graphSession
							.getProcessInstance(processInstanceId);
					
					if (processInstance != null) {
						
						Hibernate.initialize(processInstance);
						Hibernate.initialize(processInstance.getRootToken());
						Hibernate.initialize(processInstance.findAllTokens());
						Hibernate.initialize(processInstance.getInstances());
					
						for (Object tokenObj : processInstance.findAllTokens()) {
							Token token = (Token) tokenObj;
							Hibernate.initialize(token);
							Hibernate.initialize(token.getChildren());
						}
						
						for (Object nodeObj : processInstance
								.getProcessDefinition().getNodes()) {
							Node node = (Node) nodeObj;
							Hibernate.initialize(node.getLeavingTransitions());
						}
						
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find ProcessInstance With id [ "
									+ processInstanceId + " ] *****");
					e.printStackTrace();
				}				
				return processInstance;
			}
		});
	}
	
	/**
	 * This method end an instance of a jBPM process definition in database
	 * @param processInstanceId:internal database Id of instance
	 * @return true: process definition instance from database has ended
	 * @return false: if process definition instance  didn't has ended
	 */
	public boolean endProcessInstance(final long processInstanceId) {

		return (Boolean) this.jbpmTemplate.execute(new JbpmCallback() {
			
			public Object doInJbpm(JbpmContext context) {
				boolean result = false;
				ProcessInstance processInstance = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					processInstance = graphSession
							.getProcessInstance(processInstanceId);
		
					if (processInstance != null) {
						
						Hibernate.initialize(processInstance);
						Hibernate.initialize(processInstance.getRootToken());
						Hibernate.initialize(processInstance.findAllTokens());
						Hibernate.initialize(processInstance.getInstances());
					
						for (Object tokenObj : processInstance.findAllTokens()) {
							Token token = (Token) tokenObj;
							Hibernate.initialize(token);
							Hibernate.initialize(token.getChildren());
						}
						
						for (Object nodeObj : processInstance
								.getProcessDefinition().getNodes()) {
							Node node = (Node) nodeObj;
							Hibernate.initialize(node.getLeavingTransitions());
						}
						
						processInstance.end();
						result = processInstance.hasEnded();	 
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't End ProcessInstance With id [ "
									+ processInstanceId + " ] *****");
					e.printStackTrace();
				}				
				return result;
			}
		});
	}
	
	/**
	 * This method deletes the latest definition of a process from the jBPM database
	 * @param processName: name of process definition
	 * @exception: if name of process definition no has in database
	 */
	public void deleteLatestProcessDefinition(final String processName) {

		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					// First get ProcessDefnition out of database
					GraphSession graphSession = context.getGraphSession();
					ProcessDefinition processDefinition = graphSession
							.findLatestProcessDefinition(processName);

					// Make sure it was found and then delete it
					if (processDefinition != null) {
						graphSession.deleteProcessDefinition(processDefinition);
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Delete ProcessDefinition With Name [ "
									+ processName + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}
	
	/**
	 * This method deletes a process definition by given name and version.
	 * @param processName: is name of process definition
	 * @param version: is version of process definition
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#deleteWorkflow(java.lang.String, int)
	 * @exception: if process name and version doesn't find in jBPM database
	 */
	public void deleteProcessDefinitionhasVersion(final String processName,final int version) {

		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				try {
					// First get ProcessDefnition out of database
					GraphSession graphSession = context.getGraphSession();
					ProcessDefinition processDefinition = graphSession
							.findProcessDefinition(processName,version);

					// Make sure it was found and then delete it
					if (processDefinition != null) {
						graphSession.deleteProcessDefinition(processDefinition);
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Delete ProcessDefinition With Name [ "
							+ processName + " ] And Version ["+ version +" ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

	/**
	 * This is deletes the latest definition of a process from the jBPM database
	 * @param processdefinitionId: id of process definition instance
	 * @exception: if id of process definition instance no has in database
	 */
	public void deleteProcessDefinition(final long processdefinitionId) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				try {
					// First get ProcessDefnition out of database
					GraphSession graphSession = context.getGraphSession();
					graphSession.deleteProcessDefinition(processdefinitionId);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Delete ProcessDefinition With Id [ "
							+ processdefinitionId + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

	/**
	 * this method check a process definition has ended ? 
	 * @param processInstanceId: id of process definition instance
	 * @return true: if process definition has ended
	 * @return false: if process definition hasn't ended 
	 */
	public boolean hasProcessInstanceEnded(final long processInstanceId) {
		
		return (Boolean) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				ProcessInstance initializedProcessInstance = null;
				boolean result = false;
				
				try {
					initializedProcessInstance = getProcessInstance(processInstanceId);
					if (initializedProcessInstance != null) {
						result = initializedProcessInstance.hasEnded();
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find Instance Of ProcessDefinition With Id [ "
							+ processInstanceId + " ] *****");
					e.printStackTrace();
				}
				
				return result;
			}
		});
	}

	/**
	 * Cascade Drops all jBPM tables and sequences
	 */
	public void dropSchema() {
		this.jbpmTemplate.getJbpmConfiguration().dropSchema();
	}

	/**
	 * Setter JbpmTemplate object for spring
	 * @param jbpmTemplate
	 */
	@Required
	public void setJbpmTemplate(JbpmTemplate jbpmTemplate) {
		this.jbpmTemplate = jbpmTemplate;
	}
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * This method gets list task instance from jBPM Database with concrete userId
	 * @param idUser: id of concrete user
	 * @return List<TaskInstance>: if user has task in process definitions
	 * @return list empty: if user hasn't task in process definitions
	 */
	@SuppressWarnings("unchecked")
	public List<TaskInstance> getListTasksUser(final long userId) {

		return (List<TaskInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
					List<TaskInstance> listTasks = new ArrayList<TaskInstance>();

					try {
						listTasks = context.getTaskList("" + userId);
						
						Hibernate.initialize(listTasks);
					} catch (Exception e) {
						log.error("***** ERROR: Can't Find List Task  Of User With userId [ "
								+ userId + " ] *****");
						e.printStackTrace();
					}
					
					return listTasks;
				}
			});
	}

	/**
	 * This method gets list task instance from jBPM Database with current node
	 * @param processInstanceId: id of process definition instance
	 * @return List<TaskInstance>: if process definition instance exist
	 * @return list empty: if process definition instance no exist
	 */
	@SuppressWarnings("unchecked")
	public List<TaskInstance> getListTasksNode(final long processInstanceId) {
		
		return (List<TaskInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();

				try {
					GraphSession graphSession = context.getGraphSession();

					ProcessInstance processInstance = graphSession
							.getProcessInstance(processInstanceId);
					
					Hibernate.initialize(processInstance.getRootToken());

					ExecutionContext cxt = new ExecutionContext(processInstance.getRootToken());
					listTaskInstance.addAll(processInstance.getTaskMgmtInstance().getSignallingTasks(cxt));
					
					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find List Task  Of a Node With processInstanceId [ "
							+ processInstanceId + " ] *****");
					e.printStackTrace();
				}
				
				return listTaskInstance;
			}
		});
	}

	/**
	 * This method ends a task instance with concrete taskId
	 * @param taskId : id of concrete task
	 * @exception: if taskId no exits 
	 */
	public void endTaskInstance(final long taskId) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					
					TaskInstance taskInstance = context.getTaskInstance(taskId);
					
					try {
						taskInstance.start();
					} catch (Exception e) {}
					
					Token token = taskInstance.getToken();

					Hibernate.initialize(token);
					ProcessInstance processInstance = token.getProcessInstance();

					Hibernate.initialize(processInstance);
					taskInstance.end();
					
					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't end Task With taskId [ "
							+ taskId + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

	/**
	 * This method gets list name of workflows in jBPM database
	 * @return List<String> : contain list name of workflows deploy in jBPM database
	 * @return list empty : no has workflows deploy in jBPM database
	 */
	@SuppressWarnings("unchecked")
	public List<String> getNameWorkflows() {
		
		return (List<String>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<String> listWorkflow = new ArrayList<String>();
				
				try {
					List<ProcessDefinition> listProcessDefinition = context
							.getGraphSession().findLatestProcessDefinitions();
				
					if (listProcessDefinition != null
							&& !listProcessDefinition.isEmpty()) {
				
						for (ProcessDefinition pd : listProcessDefinition) {
							listWorkflow.add(pd.getName());
						}
						
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find List Name Workflow In JBPM Database *****");
					e.printStackTrace();
				}
				
				return listWorkflow;
			}
		});
	}

	/**
	 * This method assigns an user into instance task in a process definition instance
	 * @param taskInstanceId: is id of a task instance
	 * @param userId: is id of a user need to assigns a task instance
	 * @exception: if task instance no exist
	 */
	public void assignUserToTaskIntance(final long taskInstanceId,
			final long userId) {
		
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					TaskInstance taskInstance = context
							.getTaskInstance(taskInstanceId);
					Hibernate.initialize(taskInstance);
					
					if (taskInstance != null) {
						taskInstance.setActorId("" + userId);
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't assign userId [ " + userId
							+ " ] To Task with taskInstanceId ["
							+ taskInstanceId + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}

	/**
	 * This method gets name of instance task with concrete TaskInstance
	 * @param taskInstance: is instance of concrete task
	 * @return String : is name of instance task if instance of task exist
	 * @return null: if instance of task no exist 
	 */
	public String getNameTaskIntance(final TaskInstance taskInstance) {

		return (String) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext arg0) {
		
				String taskName = null;
				
				try {
				
					if (taskInstance != null) {
						taskName = taskInstance.getName();
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get Name Of TaskInstance *****");
					e.printStackTrace();
				}
				
				return taskName;
			}
		});
	}

	/**
	 * This method gets instance of task with id of concrete task
	 * @param taskid: id of concrete task
	 * @return TaskInstance : is instance of a concrete task if this task exist 
	 * @return null: if this task no exist 
	 */
	public TaskInstance getTaskInstance(final long taskid) {
		
		return (TaskInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				TaskInstance taskInstance = null;
				
				try {
					taskInstance = context.getTaskInstance(taskid);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get TaskInstance With TaskId[ "
							+ taskid + " ] In JBPM Database *****");
					e.printStackTrace();
				}
				
				return taskInstance;
			}
		});
	}

	/**
	 * This method sets description of task instance 
	 * @param description: is description need to set for concrete task 
	 * @param taskid: is of concrete task instance
	 * @exception: if task instance no exist
	 */
	public void setDesciptionTask(final String description, final long taskid) {
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					context.getTaskInstance(taskid).setDescription(description);
					context.save(context.getTaskInstance(taskid));
				} catch (Exception e) {
					log.error("***** ERROR: Can't Set Desciption Of A Task With TaskId [ "
							+ taskid + " ] *****");
					e.printStackTrace();
				}
				
				return null;
			}

		});
	}

	/**
	 * This method gets description with of task instance
	 * @param taskid: is of concrete task instance 
	 * @return String: is description of a task if task instance exist
	 * @return null: if task instance no exist
	 */
	public String getDesciptionTask(final long taskid) {
		
		return (String) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
	
				String des = null;
				
				try {
					des = context.getTaskInstance(taskid).getDescription();
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get Desciption Of A Task With TaskId [ "
							+ taskid + " ] *****");
					e.printStackTrace();
				}
				
				return des;
			}
		});
	}

	/**
	 * This method gets name of current node in process definition instance
	 * @param processInstanceId: id of process definition instance
	 * @return String: is name of node if process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public String getNodeName(final long processInstanceId) {
		
		return (String) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				String nameNode = "";
				
				try {
//					if (!hasProcessInstanceEnded(processInstanceId)) {
						ProcessInstance processInstance = getProcessInstance(processInstanceId);
						nameNode = processInstance.getRootToken().getNode().getName();
//					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get Name Of A Node With ProcessInstanceId [ "
							+ processInstanceId + " ] *****");
					e.printStackTrace();
				}
				
				return nameNode;
			}
		});
	}

	/**
	 * This method gets current node at position process definition instance stand
	 * @param processInstanceId: id of process definition instance
	 * @return Node: is node of a concrete workflow if process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public Node getNodeCurrent(final long processInstanceId) {		
		return (Node) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {				
				Node node = null;				
				try {
					ProcessInstance processInstance = getProcessInstance(processInstanceId);
					node = processInstance.getRootToken().getNode();
				} catch (Exception e) {
					log.error("***** ERROR: Can't Get A Node With ProcessInstanceId [ "
							+ processInstanceId + " ] *****");
					e.printStackTrace();
				}
				
				return node;
			}
		});
	}

	/**
	 * This method gets List instance of process definition of concrete user in jBPM database
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>: is list instance of process definitions
	 *         with concrete user if process definitions contain this user
	 * @return list empty: if process definitions doesn't contain this user         
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceOfActor(final long userId) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();
				
				try {
					List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();
					ProcessInstance processInstance = null;
					
					listTaskInstance = context.getTaskList("" + userId);
					Hibernate.initialize(listTaskInstance);
					
					for (TaskInstance taskInstance : listTaskInstance) {
						if (taskInstance != null) {
							
							Hibernate.initialize(taskInstance);
							processInstance = taskInstance
									.getContextInstance()
									.getProcessInstance();
							Hibernate.initialize(processInstance);
							
							if (!(listProcessInstance
									.contains(processInstance))) {
								listProcessInstance
										.add(processInstance);
							}
							
						}
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Have List ProcessInstance Of A User *****");
					e.printStackTrace();
				}
				
				return listProcessInstance;
			}
		});
	}
	
	
@SuppressWarnings("unchecked")
public List<ProcessInstance> getListProcessInstanceOfActor(final String userId) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();
				
				try {
					List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();
					ProcessInstance processInstance = null;
					
					listTaskInstance = context.getTaskList(userId);
					Hibernate.initialize(listTaskInstance);
					
					for (TaskInstance taskInstance : listTaskInstance) {
						if (taskInstance != null) {
							
							Hibernate.initialize(taskInstance);
							processInstance = taskInstance
									.getContextInstance()
									.getProcessInstance();
							Hibernate.initialize(processInstance);
							
							if (!(listProcessInstance
									.contains(processInstance))) {
								listProcessInstance
										.add(processInstance);
							}
							
						}
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Have List ProcessInstance Of A User *****");
					e.printStackTrace();
				}
				
				return listProcessInstance;
			}
		});
	}
	/**
	 * This method gets List instance of process definition of PooledActor from 
	 *         concrete user in this PooledActor from jBPM database
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>: list instance of process definition of
	 *         PooledActor contain concrete user
	 * @return list empty: if PooledActor doen't contain concrete user        
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceOfPooledActor(
			final long userId) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();

				try {
					List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();
					ProcessInstance processInstance = null;
				
					listTaskInstance = context.getTaskMgmtSession()
							.findPooledTaskInstances("" + userId);
					Hibernate.initialize(listTaskInstance);
					
					for (TaskInstance taskInstance : listTaskInstance) {
						if (taskInstance != null) {
					
							Hibernate.initialize(taskInstance);
							processInstance = taskInstance
									.getContextInstance()
									.getProcessInstance();
							Hibernate.initialize(processInstance);

							if (!(listProcessInstance
									.contains(processInstance))) {
								listProcessInstance
										.add(processInstance);
							}
							
						}
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Have List ProcessInstance Of Pooled Actor With Concrete User *****");
					e.printStackTrace();
				}
				
				return listProcessInstance;
			}
		});
	}

	/**
	 * This method gets all ProcessInstance has contains user or group of this user
	 * @param userId: id of concrete user
	 * @return List<ProcessInstance>:  list process definition instance if this user 
	 *         exist in process definition instances
	 * @return empty: if this user no exist in process definition instances         
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceOfActorOrPooledActor(
			final long userId) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();
				listProcessInstance.addAll(getListProcessInstanceOfActor(userId));
				listProcessInstance.addAll(getListProcessInstanceOfPooledActor(userId));
				
				return listProcessInstance;
			}
		});
	}

	/**
	 * This method gets list task instance with a concrete PooledActor (a group user) 
	 * @param userIds: a group user id 
	 * @return List<TaskInstance>: is list task instance if PooledActor exist
	 *         in process definition instances
	 * @return null: if PooledActor no exist in process definition instances        
	 */
	@SuppressWarnings("unchecked")
	public List<TaskInstance> getListTaskInstanceOfPooledActor(
			final List<String> userIds) {

		return (List<TaskInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				
				List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();
				
				try {
					listTaskInstance = context.getGroupTaskList(userIds);
					Hibernate.initialize(listTaskInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find List TaskInstance Of a PooledActor *****");
					e.printStackTrace();
				}
				
				return listTaskInstance;
			}

		});
	}

	/**
	 * This method assigns pooledActor(a group userId) to task instance
	 * @param userIds: a group user id
	 * @exception: if task instance no exist 
	 */
	public void assignPooledActorToTaskInstance(final long taskInstanceId,
			final String[] userIds) {

		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {

				try {
					TaskInstance taskInstance = context
							.getTaskInstance(taskInstanceId);
					Hibernate.initialize(taskInstance);
					
					if (taskInstance != null) {
						taskInstance.setPooledActors(userIds);
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't set PooledActor To A Instance Of Task *****");
					e.printStackTrace();
				}
				
				return null;
			}

		});
	}

	/**
	 * get jbpmTemplate object
	 * @return a jbpmTemplate object
	 */
	public JbpmTemplate getJbpmTemplate() {
		return jbpmTemplate;
	}

	/**
	 * This method gets List name task instance contain a user 
	 * @param userId: id of user need to get name task instance
	 * @return List<String>: list name task instance if task instances contain 
	 *         this user
	 * @return list empty: if task instances no contain this user
	 */
	@SuppressWarnings("unchecked")
	public List<String> getListNameTasksUser(final long userId) {
		return (List<String>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<String> listNameTasks = new ArrayList<String>();
				
				try {
					List<TaskInstance> listTasks = context.getTaskList("" + userId);
					Hibernate.initialize(listTasks);
					
					for (TaskInstance taskInstance : listTasks) {
						if (taskInstance != null) {
							listNameTasks.add(taskInstance.getName());
						}
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find List Name Task  Of User With userId [ "
							+ userId + " ] *****");
					e.printStackTrace();
				}
				
				return listNameTasks;
			}
		});
	}

	/**
	 * This methods gets id of a task instance in a process definition instance 
	 * @param taskInstanceId: is task instance in a process definition instance
	 * @return String: is id of user in task instance if task instance exist
	 * @return null: if task instance no exist
	 */
	public String getUserId(final long taskInstanceId) {
		return (String) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {

				String userId = null;
				
				try {
					TaskInstance taskInstance = context
							.getTaskInstance(taskInstanceId);
					Hibernate.initialize(taskInstance);
				
					if (taskInstance != null) {
						userId = taskInstance.getActorId();
					}
					
				} catch (Exception e) {
					log.error("***** ERROR: No Can't get UserId With Instance Of Task Have Id ["
							+ taskInstanceId + "] *****");
					e.printStackTrace();
				}
				
				return userId;
			}
		});
	}

	/**
	 * This method finds process definition with name process definition and version in jBPM database
	 * @param processName: is name of process definition 
	 * @param version: is version deploy of process definition in jBPM database
	 * @return ProcessDefinition: is process definition if name or version exist in jBPM database
	 * @return null:if name or version no exist in jBPM database
	 */
	public ProcessDefinition findProcessDefinitionWithNameAndVersion(
			final String processName, final int version) {
	
		return (ProcessDefinition) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {

				ProcessDefinition processDefinition = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					processDefinition = graphSession.findProcessDefinition(processName, version);
					Hibernate.initialize(processDefinition.getNodes());
				} catch (Exception e) {
					log.error("***** ERROR: Can't Find ProcessDefinition In JBPM Database With Name ProcessDefinition [ "
							+ processName
							+ "], Vesion ["
							+ version + "] *****");
					e.printStackTrace();
				}
				
				return processDefinition;
			}
		});
	}

	/**
	 * This method gets date begin start of a process definition instance
	 * @param processInstanceId: id of a process definition instance
	 * @return Date: is date start of a process definition instance  if 
	 *         process definition instance exist
	 * @return null: if process definition instance no exist
	 */
	public Date getStartDateProcessInstance(final long processInstanceId) {
		ProcessInstance processInstance = this.getProcessInstance(processInstanceId);
		Date date = null;
		try{
			if (processInstance != null) {
				date = processInstance.getStart();
			} 
		}catch (Exception e) {
			log.error("***** ERROR: No Can't get Start Date Of Insatance ProcessDefinition With Id [ "
					+ processInstanceId + " ] *****");
			e.printStackTrace();
		}
		
		return date;
	}

	/**
	 * This method gets date begin start of task instance
	 * @param taskId: id of a task instance
	 * @return Date: is date start of task instance if task instance exist
	 * @return null: if task instance no exist 
	 */
	public Date getStartDateTask(final long taskId) {
		
		TaskInstance taskInstance = this.getTaskInstance(taskId);
		Date date = null;
		try{
			if (taskInstance != null) {
				date = taskInstance.getStart();
			}
		}catch (Exception e) {
			log.error("***** ERROR: No Can't get Start Date Of Insatance Task With Id [ "
					+ taskId + " ] *****");
			e.printStackTrace();
		}
		
		return date;
	}

	/**
	 * This method gets date end of task instance
	 * @param taskId: id of a task instance
	 * @return Date: is date end of task instance if task instance exist
	 * @return null: if task instance no exist 
	 */
	public Date getEndDateTask(final long taskId) {
		
		TaskInstance taskInstance = this.getTaskInstance(taskId);
		Date date = null;
		try{
		if (taskInstance != null) {
			date = taskInstance.getEnd();
		} 
		}catch (Exception e) {
			log.error("***** ERROR: No Can't get End Date Of Insatance Task With Id [ "
					+ taskId + " ] *****");
			e.printStackTrace();
		}
		
		return date;
	}

	/**
	 * This method gets map of node with list task instance with concrete user  
	 * @param userId: id of concrete user
	 * @return Map<Node,List<TaskInstance>>: if process definition contain this user
	 * @return Map empty : if process definition doesn't contain this user 
	 */
	public Map<Node, List<TaskInstance>> getNodesAndNestedTaskByUserId(
			final long userId) {

		List<TaskInstance> taskList = this.getListTasksUser(userId);
		Map<Node, List<TaskInstance>> map = new HashMap<Node, List<TaskInstance>>();

		for (Iterator<TaskInstance> iterator = taskList.iterator()
				;iterator.hasNext();) {
			
			TaskInstance taskInstance = iterator.next();
			Node node = taskInstance.getToken().getNode();
			
			if (map.containsKey(node)) {
			
				if (taskInstance != null) {
					map.get(node).add(taskInstance);
				}
				
			} else {
				List<TaskInstance> list = new ArrayList<TaskInstance>();
				
				if (taskInstance != null) {
					list.add(taskInstance);
				}
				
				map.put(node, list);
			}
			
		}

		return map;
	}

	/**
	 * This method signal task instance with concrete transition
	 * @param taskId: id of task instance
	 * @param transition: name of path but task instance after end will go to
	 * @exception: if task instance no exist
	 */
	public void signalTask(final long taskId, final String transition) {
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				try {
					TaskInstance taskInstance = context.getTaskInstance(taskId);
					Hibernate.initialize(taskInstance);
					
					try {
						taskInstance.start();
					} catch (Exception e) {}
					
					taskInstance.end(transition);
				} catch (Exception e) {
					log.error("***** ERROR: No Can't Signal A Node After Instance of Task End With [ "+taskId+ " ]*****");
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	
	/**
	 * This method creates a process definition instance with name of process and version
	 * @param processName: name of process has deployed in jBPM database
	 * @param version: is version of process has deployed in jBPM database
	 * @return ProcessInstance: is process definition instance if process has 
	 *         deployed in jBPM database with name and version  
	 * @return null: if process hasn't deployed in jBPM database with name and version 
	 */
	public ProcessInstance createProcessInstanceHasVersion(final String processName, final int version) {
		return (ProcessInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				ProcessInstance processInstance = null;
	
				try {
					GraphSession graphSession = context.getGraphSession();
					ProcessDefinition processDefinition = graphSession
							.findProcessDefinition(processName, version);
				
					processInstance = new ProcessInstance(processDefinition);
					Hibernate.initialize(processInstance.getRootToken());
					Hibernate.initialize(processDefinition.getNodes());
					
					context.save(processInstance);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Create Instance Of ProcessDefinition  Has Version In JBPM Database *****");
					e.printStackTrace();
				}
				
				return processInstance;
			}
		});
	}
	
	/**
	 * This method get PooledActor(a group user) of concrete task instance 
	 * @param taskInstanceId: is id of task instance 
	 * @return List<String>: is list id of user if task instance exist
	 * @return list empty: if task instance no exist
	 */
	@SuppressWarnings("unchecked")
	public List<String> getPooledActor(final long taskInstanceId) {

		return (List<String>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {
		
				List<String> listUserId = new ArrayList<String>();
				
				try {
					TaskInstance taskInstance = context
							.getTaskInstance(taskInstanceId);
					Hibernate.initialize(taskInstance);
					
					if (taskInstance != null) {
						Set set = taskInstance.getPooledActors();

						for (Iterator iterator = set.iterator(); iterator.hasNext();) {
							PooledActor actor = (PooledActor) iterator.next();
							listUserId.add(actor.getActorId());
						}

					}
				} catch (Exception e) {
					log.error("***** ERROR: No Can't get Pooled Actor With Instance Of Task Have Id ["
							+ taskInstanceId + "] *****");
					e.printStackTrace();
				}
				
				return listUserId;
			}
		});
	}

	/**
	 * This method gets process definition instance from concrete task instance.
	 * @param taskInstanceId: id of task instance 
	 * @return ProcessInstance: is processInstance contain TaskInstance if
	 *         task instance exist
	 * @return null: if task instance no exits        
	 */
	public ProcessInstance getProcessInstanceFromTaskInstance(
			final long taskInstanceId) {
		return (ProcessInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {

				ProcessInstance processInstance = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					TaskInstance task = context.getTaskInstance(taskInstanceId);
				
					Hibernate.initialize(task);
					Hibernate.initialize(task.getToken());
					Hibernate.initialize(task.getToken().getProcessInstance());
					
					if (task == null) {
						return null;
					}
					
					processInstance = task.getToken().getProcessInstance();
				} catch (Exception e) {
					log.info("***** INFO: Can't FIND PROCESS INSTANCE *****");
					e.printStackTrace();
				}
			
				return processInstance;
			}
		});
	}

	/**
	 * This method gets process definition instance from concrete Token.
	 * @param tokenId: id of token to get process definition instance 
	 * @return ProcessInstance: is processInstance contain this token if 
	 *         this token exist
	 * @return null: if this token no exist          
	 */
	public ProcessInstance getProcessInstanceFromToken(final long tokenId) {
		
		return (ProcessInstance) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
		
				ProcessInstance processInstance = null;
				
				try {
					GraphSession graphSession = context.getGraphSession();
					Token token = context.getToken(tokenId);
					Hibernate.initialize(token);
					Hibernate.initialize(token.getProcessInstance());
				
					if (token == null) {
						return null;
					}
					
					processInstance = token.getProcessInstance();
					
				} catch (Exception e) {
					log.info("***** INFO: Can't FIND PROCESS INSTANCE *****");
					e.printStackTrace();
				}
				
				return processInstance;
			}
		});
	}

	/**
	 * This method gets Token from concrete task instance.
	 * @param taskInstanceId: id of task instance 
	 * @return Token: is token of TaskInstance if task instance exist.
	 * @return null: if task instance no exist
	 */
	public Token getTokenFromTaskInstance(final long taskInstanceId) {
		return (Token) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				Token token = null;
				
				try {
					TaskInstance task = context.getTaskInstance(taskInstanceId);
					
					Hibernate.initialize(task);
					Hibernate.initialize(task.getToken());
				
					if (task == null) {
						return null;
					}
					
					token = task.getToken();
				} catch (Exception e) {
					log.info("***** INFO: Can't FIND PROCESS INSTANCE *****");
					e.printStackTrace();
				}
				
				return token;
			}
		});
	}
	
	/**
	 * This method gets all node in a process definition has deployed in jBPM
	 *         database with name and version
	 * @param processName: name of process definition has deployed in jBPM database 
	 * @param version: version of process definition has deployed in jBPM database
	 * @return List<Node>: is list node of process definition if process definition 
	 *        finds in jBPM database with name and version
	 * @return null: if process definition does'n find in jBPM database with name and version        
	 */
	@SuppressWarnings("unchecked")
	public List<Node> getListNode(final String processName, final int version) {		
	
		return (List<Node>)this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				List<Node> listNodes = new ArrayList<Node>();
			try{
				GraphSession graphSession = context.getGraphSession();
				ProcessDefinition processDefinition = graphSession
						.findProcessDefinition(processName, version);				
				Hibernate.initialize(processDefinition.getNodes());
				listNodes = processDefinition.getNodes();
			} catch (Exception e) {
				log.error("*****ERROR: No Can't Get List Node From Process Name ["+ processName+ "] And Version ["+ version +"] *****");
				e.printStackTrace();
			}
				return listNodes;
			}
			
		});
		
	}
	
	/**
	 * This method deletes a process definition instance 
	 * @param processInstanceId: id of process definition instance
	 * @exception if process definition instance no exist
	 */
	public void deleteProcessInstance( final long processInstanceId) {
		this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				try {
					GraphSession graphSession = context.getGraphSession();					
					graphSession.deleteProcessInstance(processInstanceId);
				} catch (Exception e) {
					log.error("***** ERROR: Can't Delete Instance Of ProcessDefinition In JBPM Database *****");
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	
	/**
	  * This method check current task instance has contain user ? 
	  * @param processInstanceId: id of process definition instance
	  * @param userId: id of user need to check in current task instances 
	  * @return true: if user id has in current task instances
	  * @return false:  if user id doesn't has in current task instances
	  */
	public boolean checkUserInCurrentTasks(final long processInstanceId, final String userId) {
		return (Boolean) this.jbpmTemplate.execute(new JbpmCallback() {
			
			public Object doInJbpm(JbpmContext context) throws JbpmException {					
				try {
					ProcessInstance processInstance = context.getProcessInstance(processInstanceId);
				
					Hibernate.initialize(processInstance);
					Token token = processInstance.getRootToken();
					ExecutionContext executionContext = new ExecutionContext(token);
					Collection<TaskInstance> taskCollection = processInstance.getTaskMgmtInstance().getSignallingTasks(executionContext);
					if (taskCollection != null) {
						Iterator<TaskInstance> iterator = taskCollection.iterator();
						while( iterator.hasNext()) {
							TaskInstance taskInstance = iterator.next();
							if(taskInstance != null && userId.equals(taskInstance.getActorId())){
								return true;
							}
						}
					}
					
				} catch (Exception e) {
					log.error("*****ERROR: No Check User In Current Tasks");
					e.printStackTrace();
				}
				return false;
			}
			
		});
	}

	/**
	  * This method ends all current Task instances of process instance
	  * @param processInstanceId: id of process definition instance
	  * @exception: if process definition instance no exist
	  */
	public void endAllCurrentTaskInstances(final long processInstanceId) {
		this.jbpmTemplate.execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext arg0) throws JbpmException {
				try {
					ProcessInstance processInstance = getProcessInstance(processInstanceId);
					if (processInstance != null) {
						Token token = processInstance.getRootToken();
						ExecutionContext executionContext = new ExecutionContext(token);
						Collection<TaskInstance> taskCollection = processInstance.getTaskMgmtInstance().getSignallingTasks(executionContext);
						
						for (Iterator iterator = taskCollection.iterator(); iterator
								.hasNext();) {
							TaskInstance taskInstance = (TaskInstance) iterator
									.next();
							
							if (taskInstance != null) {
								if (taskInstance.isStartTaskInstance()) {
									taskInstance.end();
								}
								else {
									try {
										taskInstance.start();
									} catch (Exception e) {}
									
									taskInstance.end();
								}
								
							}
							
						}
					}
				} catch (Exception e) {
					log.error("*****ERROR: In endAllCurrentTaskInstances ****");
					e.printStackTrace();
				}
				return null;
			}
			
		});
		
	}
	
	/**
	 * This method gets date end of a process definition instance
	 * @param processInstanceId: id of a process definition instance
	 * @return Date: is end date  of a process definition instance  if 
	 *         process definition instance exist
	 * @return null: if process definition instance no exist or process 
	 *         definition instance doesn't end
	 */
	public Date getEndDateProcessInstance (final long processInstanceId) {
		return (Date)this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext arg0) throws JbpmException {
				ProcessInstance processInstance = getProcessInstance(processInstanceId);
				Date date = null;
				try {
					if (processInstance != null) {
						date = processInstance.getEnd();
					}
					
				} catch (Exception e) {
					log.error("*****ERROR: No Get End date Of ProcessInstance *****");
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	/**
	  * This method get all node name in xml process definition file  
	  * @param processXmlResource: is path plus file name of process definition
	  * @return List<String>: is list node name in process definition if
	  *         xml process definition file parse successfully 
	  * @return list empty: if xml process definition file no parse successfully
	  */
	public List<String> getListNodeName(String processXmlResource) {
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource(processXmlResource);
		List<String> resultList = new ArrayList<String>();
		if (processDefinition != null){
			List<Node> nodeList = processDefinition.getNodes();
			if (nodeList != null) {
				for (Node node : nodeList) {
					resultList.add(node.getName());
				}
			}
		}
		return resultList;
	}
	
	/**
	  * This method get get all node name from process definition
	  * @param processDefinition: is process definition of process 
	  * @return List<String>: list node name if process definition isn't null
	  * @return list empty: if process definition is null
	  */
	public List<String> getListNodeName(ProcessDefinition processDefinition) {
		List<String> resultList = new ArrayList<String>();
		if (processDefinition != null){
			List<Node> nodeList = processDefinition.getNodes();
			if (nodeList != null) {
				for (Node node : nodeList) {
					resultList.add(node.getName());
				}
			}
		}
		return resultList;
	}
	
	/**
	 * get main process path name of workflow no sort 
	 * @param nameProcess
	 * @param version
	 * @param numberMain
	 * @return List<String>
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> getNameTransitionMain(final String nameProcess, final int version, final int numberMain ) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) {				
				ProcessDefinition processDefinition = findProcessDefinitionWithNameAndVersion(nameProcess,version);
				List<Transition> listTemp = new ArrayList<Transition>();
				List<String[]> listRes = new ArrayList<String[]>();
				String [] arr= null; 
				try {
				listTemp =session.createQuery("From Transition").list();
					for (Transition transition : listTemp) {
						if (transition.getProcessDefinition().getId() == processDefinition.getId()) {
							if (transition.getName().contains(numberMain + "")) {
								arr = new String [3];
								arr[0] = transition.getName();
								arr[1] = transition.getFrom().getName();
								arr[2] = transition.getTo().getName();
								listRes.add(arr);
								arr = null; 
							}
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				return listRes;
			}
			
		});
	}
	
	/**
	 * get main process path name of workflow no sort
	 * @param nameProcess
	 * @param version
	 * @param numberMain
	 * @return List<String[]>
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> getNameTransitionMainNode(final String nameProcess, final int version, final int numberMain ) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) {				
				ProcessDefinition processDefinition = findProcessDefinitionWithNameAndVersion(nameProcess,version);
				List<Node> listTemp = new ArrayList<Node>();
				List<Node> listNodeSort = new ArrayList<Node>();
				List<String[]> listRes = new ArrayList<String[]>();
				String [] arr= null; 
				Node nodeBegin = null;
				try {
				listTemp =session.createQuery("From Node").list();
				
				for (Node node : listTemp) {
					if("start".equalsIgnoreCase(node.getName()) && node.getProcessDefinition().getId() == processDefinition.getId()) {
						nodeBegin = node;
						listNodeSort.add(nodeBegin);
						listTemp.remove(node);
						break;
					}
				}
				
				List<Transition> transitionList = nodeBegin.getLeavingTransitionsList();			
				
				for (int i = 0; i < listTemp.size(); i++) {
					if (listTemp.get(i).getProcessDefinition().getId() == processDefinition.getId()) {
					for (Transition transition : transitionList) {
						if (transition.getName().contains(numberMain + "")) {
							arr = new String [3];
							arr[0] = transition.getName();
							arr[1] = transition.getFrom().getName();
							arr[2] = transition.getTo().getName();
							listRes.add(arr);
							arr = null;
							Node node =transition.getTo();
							transitionList = node.getLeavingTransitions();
						}
						
						}
					}
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
				return listRes;
			}
			
		});
	}
	
	
	/**
	 * Get ProcessInstance with concrete user and process state list 
	 * @param userId
	 * @param processState
	 * @return List<ProcessInstance>
	 *
	 */
	
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceOfActorWithState(final long userId, final List<String> processState) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();
				
				try {
					List<TaskInstance> listTaskInstance = new ArrayList<TaskInstance>();
					ProcessInstance processInstance = null;
					
					listTaskInstance = context.getTaskList("" + userId);
					Hibernate.initialize(listTaskInstance);
					
					for (TaskInstance taskInstance : listTaskInstance) {
						if (taskInstance != null) {
							//initial objects have relative with TaskInstance
							Hibernate.initialize(taskInstance);
							Hibernate.initialize(taskInstance.getTask());
							Task task  = taskInstance.getTask();
							Hibernate.initialize(task.getTaskNode());
							TaskNode taskNode = task.getTaskNode();
							
							//check TaskInstance has in Process sate list
							for (String state : processState) {
								if (taskNode.getName().contains(state)) {
									processInstance = taskInstance.getContextInstance().getProcessInstance();
									Hibernate.initialize(processInstance);
							
									if (!(listProcessInstance.contains(processInstance))) {
										listProcessInstance.add(processInstance);
									}
								}
							}
						}
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Have List ProcessInstance Of A User and Process State List *****");
					e.printStackTrace();
				}
				
				return listProcessInstance;
			}
		});
	}
	
	
	/**
	 * gets processinstances of user had process
	 * @param userId
	 * @return List<TaskInstance>
	 * Aug 24, 2009
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstancesUserHadProcess(final long userId) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public List<ProcessInstance> doInHibernate(Session session){
				
				List<ProcessInstance> listProcessInstances = new ArrayList<ProcessInstance>();	
				try{
					String sql = "select pi "+
				    "from TaskInstance as ti, ProcessInstance as pi "+
				    "where ti.actorId = '" +String.valueOf(userId) +"' "+
				    "and ti.isSuspended != true "+
				    "and ti.isOpen != true "+
				    "and ti.isCancelled != true " +
				    "and ti.token.processInstance = pi.id";				
					listProcessInstances = session.createQuery(sql).list();
				} catch (Exception e) {
					log.error("***** ERROR: Can't get List ProcessInstance Of A User Had Process  *****");
					e.printStackTrace();
				}
				return listProcessInstances;
			}
			
		});
	}
	
	
	
	/**
	 * Get ProcessInstance with concrete user and process state list 
	 * @param userId
	 * @param processState
	 * @return List<ProcessInstance>
	 *
	 */
	
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceOfActorHadProcessWithState(final long userId, final List<String> processState) {
		
		return (List<ProcessInstance>) this.jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				
				List<ProcessInstance> listProcessInstance = new ArrayList<ProcessInstance>();
				
				try {
					List<ProcessInstance> listProcessInstanceTemp = getListProcessInstancesUserHadProcess(userId); 
					
					for (ProcessInstance pi : listProcessInstanceTemp) {
						if (pi != null) {
							//initial objects have relative with ProcessInstance
							Hibernate.initialize(pi);							
							String nodeName = getNodeName(pi.getId());							
							
							for (String state : processState) {
								if (nodeName.contains(state)) {
									
									if (!(listProcessInstance.contains(pi))) {
										listProcessInstance.add(pi);
									}
								}
							}
						}
					}
				} catch (Exception e) {
					log.error("***** ERROR: Can't Have List ProcessInstance Of A User Had Process and Process State List *****");
					e.printStackTrace();
				}
				
				return listProcessInstance;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcessInstance> getListProcessInstanceFromProcessDefinition(final long processDefinitionId) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public List<ProcessInstance> doInHibernate(Session session){
				
				List<ProcessInstance> listProcessInstances = new ArrayList<ProcessInstance>();	
				try{
					String sql = "select pi "+
				    "from ProcessInstance as pi "+
				    "where pi.processDefinition = " + processDefinitionId;
					listProcessInstances = session.createQuery(sql).list();
				} catch (Exception e) {
					log.error("***** ERROR: Can't get List ProcessInstance Of A Process definitionId  *****");
					e.printStackTrace();
				}
				return listProcessInstances;
			}
			
		});
	}
	
}