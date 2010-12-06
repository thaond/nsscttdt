/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.sgs.liferay.jbpm.handler;

import java.util.List;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.exe.Assignable;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.persistence.GroupUtil;

/**
 * <a href="IdentityAssignmentHandler.java.html"><b><i>View Source</i></b></a>
 *
 * @author hieuvh
 *
 */
public class IdentityAssignmentHandler implements AssignmentHandler {
	
	/**
	 * this method assign a user, a role, or community of liferay into swimlane of 
	 * jbpm. It maybe a actorId (for type  = user) or PooledActor
	 * (for role or community).  
	 */
	public void assign(
			Assignable assignable, ExecutionContext executionContext) {
		try {
			String actorId = (String) executionContext.getContextInstance().getVariable("actorId");
			assignable.setActorId(actorId);
			
			if ("user".equals(type)) {
				if (Validator.isNotNull(id)) {
					assignable.setActorId(id);
				}
				else {
					long userId = UserServiceUtil.getUserIdByEmailAddress(GetterUtil.getLong(companyId), name);

					assignable.setActorId("" + userId);
				}
			} else if ("community".equals(type)) {
				if (Validator.isNull(id)) {
					Group group = GroupServiceUtil.getGroup(
						GetterUtil.getLong(companyId), name);

					id = String.valueOf(group.getGroupId());
				}

				List<User> users = GroupUtil.getUsers(GetterUtil.getLong(id));

				String[] actorIds = new String[users.size()];

				for (int i = 0; i < users.size(); i++) {
					actorIds[i] = String.valueOf(users.get(i).getUserId());
				}

				assignable.setPooledActors(actorIds);
			}
			else if ("role".equals(type)) {
				System.out.println("------------------------------");
				if (Validator.isNull(id)) {
					Role role = RoleServiceUtil.getRole(
						GetterUtil.getLong(companyId), name);

					id = String.valueOf(role.getRoleId());
				}
				List<User> users = UserLocalServiceUtil.getRoleUsers(GetterUtil.getLong(id));
				String[] actorIds = new String[users.size()];

				for (int i = 0; i < users.size(); i++) {
					actorIds[i] = String.valueOf(users.get(i).getUserId());
				}

				assignable.setPooledActors(actorIds);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String type;
	protected String companyId;
	protected String id;
	protected String name;

}