
package com.nss.portlet.journal.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyPair;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.digitalsignature.service.CertificateLocalServiceUtil;
import com.nss.portlet.digitalsignature.util.ArticleSignUtil;
import com.nss.portlet.digitalsignature.util.DigitalSignatureKeys;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.service.JournalArticleServiceUtil;
import com.nss.workflow.JournalLiferayPortletAction;
import com.nss.workflow.JournalLiferayWorkflowService;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class ApproveJournalArticle extends JournalLiferayPortletAction {

	protected void approveArticle(ActionRequest actionRequest)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		String articleId = ParamUtil.getString(actionRequest, "articleId");
		double version = ParamUtil.getDouble(actionRequest, "version");

		String articleURL = ParamUtil.getString(actionRequest, "articleURL");

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);

		JournalArticle article =
			JournalArticleServiceUtil.approveArticle(
				groupId, articleId, version, articleURL, serviceContext);
		/**
		 * ky o day-- cong viec ky: kiem tra ky chua neu chua ky thi ky tiep tuc
		 * kiem tra co certificate chua neu chua thi tao neu co roi thi dung no
		 * de ky neu ky roi phai thong bao cho nguoi dung biet va khong dc ky
		 * lai
		 */
		// kiem tra nguoi dung co check chon ky k?
		User user = PortalUtil.getUser(actionRequest);

		boolean signArticle =
			ParamUtil.getBoolean(actionRequest, "signArticle");

		int checkSign = ArticleSignUtil.veriSign(article.getPrimaryKey());
		System.out.println("thong tin ky : " + signArticle + " checkSign: " +
			checkSign);
		if (signArticle && (checkSign == 0)) {
			// lay keyPair de co privateKey va publicKey de ky
			KeyPair keyPair = getKeyPair("D://keypair.txt");
			// kiem tra co certificate chua neu chua co dung ham
			// updateCertificate de tao
			try {
				CertificateLocalServiceUtil.getCertificate(user.getUserId());
			}
			catch (Exception e) {
				// tao certificate
				CertificateLocalServiceUtil.updateCertificate(
					user.getUserId(), DigitalSignatureKeys.SHA1WITHRSA,
					keyPair.getPrivate(), keyPair.getPublic(),
					"CN=Duke, OU=JavaSoft, O=Sun Microsystems, C=US",
					"CN=Duke, OU=JavaSoft, O=Sun Microsystems, C=US", null,
					null, user.getEmailAddress());
			}
			// ky len bai viet
			ArticleSignUtil.sign(
				user.getUserId(), article.getPrimaryKey(), keyPair.getPrivate());
		}
	}

	public KeyPair getKeyPair(String fileName) {

		try {
			ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream(fileName));
			KeyPair keyPair = (KeyPair) ois.readObject();
			ois.close();
			return keyPair;
		}
		catch (FileNotFoundException e) {
			System.out.println("Error FileNotFoundException of Method getKeyPair of Class EditArticleAction : " +
				e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error IOException of Method getKeyPair of Class EditArticleAction : " +
				e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error ClassNotFoundException of Method getKeyPair of Class EditArticleAction : " +
				e.getMessage());
		}
		return null;
	}

	@Override
	public void processStrutsAction(
		ActionMapping arg0, ActionForm arg1, PortletConfig arg2,
		ActionRequest actionRequest, ActionResponse arg4)
		throws Exception {

		String resourcePrimey =
			ParamUtil.getString(actionRequest, "resourcePrimey");

		String processInformation =
			ParamUtil.getString(actionRequest, "processInformation");

		addWorkflowParameter(
			actionRequest, "userId", WorkflowParam.TRANSIENT,
			String.valueOf(PortalUtil.getUserId(actionRequest)));

		addWorkflowParameter(
			actionRequest, "resourcePrimey", WorkflowParam.TRANSIENT,
			resourcePrimey);

		addWorkflowParameter(
			actionRequest, "processInformation", WorkflowParam.TRANSIENT,
			processInformation);

		String userIds = ParamUtil.getString(actionRequest, "userIds");

		addWorkflowParameter(
			actionRequest, "userIds", WorkflowParam.TRANSIENT, userIds);

		addWorkflowParameter(
			actionRequest, "userIdProcess", WorkflowParam.TRANSIENT,
			String.valueOf(PortalUtil.getUserId(actionRequest)));

		approveArticle(actionRequest);
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm arg1, PortletConfig arg2,
		RenderRequest req, RenderResponse arg4)
		throws Exception {

		long groupId = ParamUtil.getLong(req, "groupId");
		String articleId = ParamUtil.getString(req, "articleId");
		double version = ParamUtil.getDouble(req, "version");

		String articleURL = ParamUtil.getString(req, "articleURL");

		long taskId = ParamUtil.getLong(req, "wf_taskId");
		List<User> users =
			((JournalLiferayWorkflowService) getLiferayWorkflowService()).getListUsers(taskId);
		req.setAttribute("users", users);
		req.setAttribute("groupId", groupId);
		req.setAttribute("articleId", articleId);
		req.setAttribute("version", version);
		req.setAttribute("articleURL", articleURL);

		return mapping.findForward("portlet.nss.journal.approvejournalarticle");
	}

}
