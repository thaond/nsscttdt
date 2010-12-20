
package com.nss.portlet.journal.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.nss.portal.util.NSSHtmlUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.nss.workflow.JournalLiferayPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class DeleteJournalArticle extends JournalLiferayPortletAction {

	@Override
	public void processStrutsAction(
		ActionMapping arg0, ActionForm arg1, PortletConfig arg2,
		ActionRequest req, ActionResponse arg4)
		throws Exception {

		long groupId = ParamUtil.getLong(req, "groupId");
		String articleId = ParamUtil.getString(req, "articleId");
		double version = ParamUtil.getDouble(req, "version");

		JournalArticle article =
			JournalArticleLocalServiceUtil.getArticle(
				groupId, articleId, version);

		addWorkflowParameter(
			req, "articleIds", WorkflowParam.TRANSIENT,
			String.valueOf(article.getResourcePrimKey()));

		String content = article.getContent();
		List<String> imgs = NSSHtmlUtil.getAllImageLinks(content, null);
		for (String img : imgs) {
			if (!img.contains("/image/adv?img_id=")) {
				continue;
			}
			String temp = img.replace("/image/adv?img_id=", "");
			try {
				ImageLocalServiceUtil.deleteImage(Integer.parseInt(temp));
			}
			catch (Exception e) {
				System.out.println("error ImageLocalServiceUtil.deleteImage(Integer.parseInt(temp)); of method processStrutsAction of class DeleteJournalArticle");
			}

		}

		// delet article

		JournalArticleLocalServiceUtil.deleteJournalArticle(article);
		//

	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm arg1, PortletConfig arg2,
		RenderRequest arg3, RenderResponse arg4)
		throws Exception {

		return mapping.findForward("portlet.nss.journal.view");
	}

}
