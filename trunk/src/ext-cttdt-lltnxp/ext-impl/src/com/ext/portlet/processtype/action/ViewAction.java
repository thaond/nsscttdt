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

package com.ext.portlet.processtype.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.model.impl.ProcessTypeImpl;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.processtype.service.persistence.ProcessTypeUtil;
import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;


/**
 * <a href="ViewAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author Minh Quan
 *
 */

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, "cmd","view");
		if (Validator.isNotNull(cmd)) {
			if ("update".equals(cmd)){
				updateProcessType(req);
			} else {
				addProcessType(req,res);
			}
		}
		
	}
	
	private void updateProcessType(ActionRequest req) {
		long processTypeId = ParamUtil.getLong(req, "processTypeId");
		String processTypeName = ParamUtil.getString(req, "processTypeName_".concat(String.valueOf(processTypeId)));
		int hiddenProcessTypeFlag = ParamUtil.getInteger(req, "hiddenProcessTypeFlag_".concat(String.valueOf(processTypeId)));
		
		ProcessType processType = null;
		try {
			processType = ProcessTypeLocalServiceUtil.getProcessType(processTypeId);
			processType.setName(processTypeName);
			processType.setFlagProcessType(hiddenProcessTypeFlag);
			ProcessTypeLocalServiceUtil.updateProcessType(processType);
			req.setAttribute("flagUpdate", true);
		} catch (Exception e) {
			req.setAttribute("flagUpdate", false);
			_log.error(e.getMessage());
		}
	}

	private void addProcessType(ActionRequest req, ActionResponse res) {
		
		try {
			ProcessType processType = new ProcessTypeImpl();
			//set id
			int id = (int)CounterServiceUtil.increment();
			processType.setProcessTypeId(id);
			//set flag
			int flag_tmp=ParamUtil.getInteger(req, "ptflag");
			int flag = 1;
			if(flag_tmp==0) processType.setFlagProcessType(flag);
			else processType.setFlagProcessType(flag_tmp);
			//set name
			String processname = ParamUtil.getString(req, "ptname");
			processname = StringUtil.encodeHtml(processname);
			processType.setName(processname);
			
			ProcessTypeLocalServiceUtil.addProcessType(processType);
			//res.sendRedirect(req.getParameter("redirect"));
			req.setAttribute("flag", true);
		} catch (Exception e) {
			req.setAttribute("flag", false);
		}
	
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
		PortletConfig config, RenderRequest req, RenderResponse res)
		throws Exception {
		
		
		List<ProcessType> listprocesstype= ProcessTypeUtil.findAll();
		
		req.setAttribute("listprocesstype",listprocesstype);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
		
			return mapping.findForward("portlet.ext.processtype.view");
		}			
	}

	

}