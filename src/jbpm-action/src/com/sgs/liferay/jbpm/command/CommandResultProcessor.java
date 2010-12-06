/**
 * 
 */
package com.sgs.liferay.jbpm.command;

/**
 * process Result of command.
 * @author hieuvh
 *
 */
public interface CommandResultProcessor {
	void processResult(Object commandResult);
}
