package com.nss.portlet.journal.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nss.workflow.JournalLiferayPortletAction;

public class TransitionReviewJournalArticle extends JournalLiferayPortletAction{

	@Override
	public void processStrutsAction(ActionMapping arg0, ActionForm arg1,
			PortletConfig arg2, ActionRequest arg3, ActionResponse arg4)
	throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm arg1,
			PortletConfig arg2, RenderRequest arg3, RenderResponse arg4)
	throws Exception {
		// TODO Auto-generated method stub
		return mapping.findForward("portlet.nss.journal.transitionreviewjournalarticle");
	}
	
}
