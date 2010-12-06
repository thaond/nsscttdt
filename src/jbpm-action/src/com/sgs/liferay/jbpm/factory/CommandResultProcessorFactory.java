/**
 * 
 */
package com.sgs.liferay.jbpm.factory;

import com.sgs.liferay.jbpm.command.CommandResultProcessor;
import com.sgs.liferay.jbpm.command.WorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class CommandResultProcessorFactory {
	
	private static CommandResultProcessorFactory instance = null; 
	
	/**
	 * private default construtor 
	 */
	private CommandResultProcessorFactory() {}

	/**
	 * @return the instance
	 */
	public static CommandResultProcessorFactory getInstance() {
		
		if (instance == null) {
			instance = new CommandResultProcessorFactory();
		}
		
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public CommandResultProcessor createCommandResultProcessor(WorkflowCommand command) {
		String name = command.getClass().getName() + "ResultProcessor";
		CommandResultProcessor processor = null;
		
		try {
			processor = (CommandResultProcessor) Class.forName(name).newInstance();
		} catch (Exception e) {
		}
		
		return processor;
	}
}
