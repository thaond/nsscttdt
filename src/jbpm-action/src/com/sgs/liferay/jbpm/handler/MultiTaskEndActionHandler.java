/**
 * 
 */
package com.sgs.liferay.jbpm.handler;

import java.util.Iterator;
import java.util.Vector;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

/**
 * @author hieuvh
 * 
 */
public class MultiTaskEndActionHandler implements ActionHandler {

	/** 
	 * cancel any taskinstance in same node when current task end.
	 * @param cxt ExecutionContext
	 * @throws Exception if any wrong
	 * @see org.jbpm.graph.def.ActionHandler#execute(org.jbpm.graph.exe.ExecutionContext)
	 */
	public void execute(ExecutionContext cxt) throws Exception {
		TaskInstance taskIns = cxt.getTaskInstance();
		Long id = new Long(taskIns.getId());
		
		Vector vector = new Vector(); 
		vector.addAll(cxt.getTaskMgmtInstance().getTaskInstances());
		
		// Cancel all task when a task complete
		for (Iterator iterator = vector.iterator(); iterator.hasNext();) {
			TaskInstance task = (TaskInstance) iterator.next();
	
			if (task.getId() == id) {
				continue;
			}
			
			if (task.getEnd() != null) {
				continue;
			}
			
			
			task.setSignalling(false);
			task.cancel();
		}
	}

}
