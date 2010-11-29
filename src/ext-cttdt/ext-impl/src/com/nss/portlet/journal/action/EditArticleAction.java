/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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

package com.nss.portlet.journal.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyPair;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.ActionRequestImpl;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.journal.ArticleContentException;
import com.liferay.portlet.journal.ArticleDisplayDateException;
import com.liferay.portlet.journal.ArticleExpirationDateException;
import com.liferay.portlet.journal.ArticleIdException;
import com.liferay.portlet.journal.ArticleSmallImageNameException;
import com.liferay.portlet.journal.ArticleSmallImageSizeException;
import com.liferay.portlet.journal.ArticleTitleException;
import com.liferay.portlet.journal.ArticleTypeException;
import com.liferay.portlet.journal.DuplicateArticleIdException;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.NoSuchStructureException;
import com.liferay.portlet.journal.NoSuchTemplateException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.util.JournalUtil;
import com.liferay.portlet.tags.TagsEntryException;
import com.liferay.util.LocalizationUtil;
import com.nss.portal.util.NSSHtmlUtil;
import com.nss.portlet.digitalsignature.service.CertificateLocalServiceUtil;
import com.nss.portlet.digitalsignature.util.ArticleSignUtil;
import com.nss.portlet.digitalsignature.util.DigitalSignatureKeys;
import com.nss.portlet.journalworkflow.util.SAWWorkflowUtil;
import com.nss.workflow.JournalLiferayPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sun.saw.vo.BusinessProcessInstanceVO;
import com.sun.saw.vo.OutputVO;
import com.sun.saw.vo.TokenVO;

/**
 * <a href="EditArticleAction.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
//public class EditArticleAction extends PortletAction {
public class EditArticleAction extends JournalLiferayPortletAction {

	public static final String VERSION_SEPARATOR = "_version_";

	protected void approveArticle(ActionRequest actionRequest)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		String articleId = ParamUtil.getString(actionRequest, "articleId");
		double version = ParamUtil.getDouble(actionRequest, "version");

		String articleURL = ParamUtil.getString(actionRequest, "articleURL");

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);

		JournalArticleServiceUtil.approveArticle(
			groupId, articleId, version, articleURL, serviceContext);
	}

	protected void deleteArticles(ActionRequest actionRequest)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		String[] deleteArticleIds =
			StringUtil.split(ParamUtil.getString(
				actionRequest, "deleteArticleIds"));

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);

		for (int i = 0; i < deleteArticleIds.length; i++) {
			int pos = deleteArticleIds[i].lastIndexOf(VERSION_SEPARATOR);

			String articleId = deleteArticleIds[i].substring(0, pos);
			double version =
				GetterUtil.getDouble(deleteArticleIds[i].substring(pos +
					VERSION_SEPARATOR.length()));

			String articleURL =
				ParamUtil.getString(actionRequest, "articleURL");
			// Tu update 20101124
			JournalArticle article =
				JournalArticleServiceUtil.getArticle(
					groupId, articleId, version);
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
					System.out.println("error ImageLocalServiceUtil.deleteImage(Integer.parseInt(temp)); of method deleteArticles(ActionRequest actionRequest) of class EditArticleAction");
				}

			}
			JournalArticleServiceUtil.deleteArticle(
				groupId, articleId, version, articleURL, serviceContext);

			JournalUtil.removeRecentArticle(actionRequest, deleteArticleIds[i]);
		}
	}

	protected void expireArticles(ActionRequest actionRequest)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		String[] expireArticleIds =
			StringUtil.split(ParamUtil.getString(
				actionRequest, "expireArticleIds"));

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);

		for (int i = 0; i < expireArticleIds.length; i++) {
			int pos = expireArticleIds[i].lastIndexOf(VERSION_SEPARATOR);

			String articleId = expireArticleIds[i].substring(0, pos);
			double version =
				GetterUtil.getDouble(expireArticleIds[i].substring(pos +
					VERSION_SEPARATOR.length()));

			String articleURL =
				ParamUtil.getString(actionRequest, "articleURL");

			JournalArticleServiceUtil.expireArticle(
				groupId, articleId, version, articleURL, serviceContext);
		}
	}

	protected Map<String, byte[]> getImages(UploadPortletRequest uploadRequest)
		throws Exception {

		Map<String, byte[]> images = new HashMap<String, byte[]>();

		String imagePrefix = "structure_image_";

		Enumeration<String> enu = uploadRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();

			if (name.startsWith(imagePrefix)) {
				File file = uploadRequest.getFile(name);
				byte[] bytes = FileUtil.getBytes(file);

				if ((bytes != null) && (bytes.length > 0)) {
					name = name.substring(imagePrefix.length(), name.length());

					images.put(name, bytes);
				}
			}
		}

		return images;
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

	protected String getSaveAndContinueRedirect(
		PortletConfig portletConfig, ActionRequest actionRequest,
		JournalArticle article, String redirect)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String originalRedirect =
			ParamUtil.getString(actionRequest, "originalRedirect");
		// Canh edit
		long bpid = ParamUtil.getLong(actionRequest, "workflow", 0);
		long instanceId = ParamUtil.getLong(actionRequest, "instanceId", 0);
		String workflowAction =
			ParamUtil.getString(actionRequest, "workflowAction", "");
		// end of canh

		PortletURLImpl portletURL =
			new PortletURLImpl(
				(ActionRequestImpl) actionRequest,
				portletConfig.getPortletName(), themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);

		portletURL.setParameter("struts_action", "/nss/journal/edit_article");
		portletURL.setParameter(Constants.CMD, Constants.UPDATE, false);
		portletURL.setParameter("redirect", redirect, false);
		portletURL.setParameter("originalRedirect", originalRedirect, false);
		portletURL.setParameter(
			"groupId", String.valueOf(article.getGroupId()), false);
		portletURL.setParameter("articleId", article.getArticleId(), false);
		portletURL.setParameter(
			"version", String.valueOf(article.getVersion()), false);
		// Canh edit
		portletURL.setParameter("workflow", String.valueOf(bpid), false);
		portletURL.setParameter("instanceId", String.valueOf(instanceId), false);
		portletURL.setParameter(
			"workflowAction", String.valueOf(workflowAction), false);
		// end of Canh

		return portletURL.toString();
	}

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		JournalArticle article = null;

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				article = updateArticle(actionRequest);
				addWorkflowParameter(actionRequest, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(actionRequest));
				addWorkflowParameter(actionRequest, "resourcePrimey", WorkflowParam.TRANSIENT, "" + article.getResourcePrimKey());
			}
			else if (cmd.equals(Constants.APPROVE)) {
				approveArticle(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteArticles(actionRequest);
			}
			else if (cmd.equals(Constants.EXPIRE)) {
				expireArticles(actionRequest);
			}
			else if (cmd.equals("removeArticlesLocale")) {
				removeArticlesLocale(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect =
					ParamUtil.getString(actionRequest, "redirect");

				if (article != null) {
					boolean saveAndContinue =
						ParamUtil.getBoolean(actionRequest, "saveAndContinue");

					if (saveAndContinue) {
						redirect =
							getSaveAndContinueRedirect(
								portletConfig, actionRequest, article, redirect);
					}
				}

				sendRedirect(actionRequest, actionResponse, redirect);
			}
			
			
		}
		catch (Exception e) {
			if ((e instanceof NoSuchArticleException) ||
				(e instanceof NoSuchStructureException) ||
				(e instanceof NoSuchTemplateException) ||
				(e instanceof PrincipalException)) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.nss.journal.error");
			}
			else if ((e instanceof ArticleContentException) ||
				(e instanceof ArticleDisplayDateException) ||
				(e instanceof ArticleExpirationDateException) ||
				(e instanceof ArticleIdException) ||
				(e instanceof ArticleSmallImageNameException) ||
				(e instanceof ArticleSmallImageSizeException) ||
				(e instanceof ArticleTitleException) ||
				(e instanceof ArticleTypeException) ||
				(e instanceof DuplicateArticleIdException)) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof TagsEntryException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}
	}

	protected void removeArticlesLocale(ActionRequest actionRequest)
		throws Exception {

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		String[] removeArticleLocaleIds =
			StringUtil.split(ParamUtil.getString(
				actionRequest, "deleteArticleIds"));

		for (int i = 0; i < removeArticleLocaleIds.length; i++) {
			int pos = removeArticleLocaleIds[i].lastIndexOf(VERSION_SEPARATOR);

			String articleId = removeArticleLocaleIds[i].substring(0, pos);
			double version =
				GetterUtil.getDouble(removeArticleLocaleIds[i].substring(pos +
					VERSION_SEPARATOR.length()));
			String languageId =
				ParamUtil.getString(actionRequest, "languageId");

			JournalArticleServiceUtil.removeArticleLocale(
				groupId, articleId, version, languageId);
		}
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

			if (!cmd.equals(Constants.ADD)) {
				ActionUtil.getArticle(renderRequest);
			}
		}
		catch (NoSuchArticleException nsse) {

			// Let this slide because the user can manually input a article id
			// for a new article that does not yet exist.

		}
		catch (Exception e) {
			if (// e instanceof NoSuchArticleException ||
			e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.nss.journal.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.nss.journal.edit_article"));
	}

	protected JournalArticle updateArticle(ActionRequest actionRequest)
		throws Exception {

		UploadPortletRequest uploadRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);

		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);

		long groupId = ParamUtil.getLong(uploadRequest, "groupId");

		String articleId = ParamUtil.getString(uploadRequest, "articleId");
		boolean autoArticleId =
			ParamUtil.getBoolean(uploadRequest, "autoArticleId");

		double version = ParamUtil.getDouble(uploadRequest, "version");
		boolean incrementVersion =
			ParamUtil.getBoolean(uploadRequest, "incrementVersion");

		String title = ParamUtil.getString(uploadRequest, "title");
		String description = ParamUtil.getString(uploadRequest, "description");
		String content = ParamUtil.getString(uploadRequest, "content");
		// Tu edit 20101122
		// lay ra danh sach String
		List<String> listImage = NSSHtmlUtil.getAllImageLinks(content, null);
		for (String img : listImage) {
			if (img.indexOf("://") < 0) { // kiem tra co phai la anh tren mang
											// k?
				continue;
			}
			long imageUpload = 0;
			try {
				imageUpload = CounterLocalServiceUtil.increment();
			}
			catch (Exception e1) {
				System.out.println("error CounterLocalServiceUtil.increment(); of updateArticle " +
					e1.getMessage());
			}
			try {
				URLConnection cn = new URL(img).openConnection();
				cn.connect();
				InputStream stream = cn.getInputStream();
				HttpServletRequest request =
					PortalUtil.getHttpServletRequest(actionRequest);
				ThemeDisplay themeDisplay =
					(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				Image image =
					ImageLocalServiceUtil.updateImage(imageUpload, stream);
				content =
					content.replaceAll(img, themeDisplay.getPathImage() +
						"/adv?img_id=" + image.getPrimaryKey());

			}
			catch (Exception e) {
				System.out.println("error URLConnection of updateArticle " +
					e.getMessage());
			}
		}
		// end Tu edit
		String type = ParamUtil.getString(uploadRequest, "type");
		String structureId = ParamUtil.getString(uploadRequest, "structureId");
		String templateId = ParamUtil.getString(uploadRequest, "templateId");

		String lastLanguageId =
			ParamUtil.getString(uploadRequest, "lastLanguageId");
		String defaultLanguageId =
			ParamUtil.getString(uploadRequest, "defaultLanguageId");

		int displayDateMonth =
			ParamUtil.getInteger(uploadRequest, "displayDateMonth");
		int displayDateDay =
			ParamUtil.getInteger(uploadRequest, "displayDateDay");
		int displayDateYear =
			ParamUtil.getInteger(uploadRequest, "displayDateYear");
		int displayDateHour =
			ParamUtil.getInteger(uploadRequest, "displayDateHour");
		int displayDateMinute =
			ParamUtil.getInteger(uploadRequest, "displayDateMinute");
		int displayDateAmPm =
			ParamUtil.getInteger(uploadRequest, "displayDateAmPm");

		if (displayDateAmPm == Calendar.PM) {
			displayDateHour += 12;
		}

		int expirationDateMonth =
			ParamUtil.getInteger(uploadRequest, "expirationDateMonth");
		int expirationDateDay =
			ParamUtil.getInteger(uploadRequest, "expirationDateDay");
		int expirationDateYear =
			ParamUtil.getInteger(uploadRequest, "expirationDateYear");
		int expirationDateHour =
			ParamUtil.getInteger(uploadRequest, "expirationDateHour");
		int expirationDateMinute =
			ParamUtil.getInteger(uploadRequest, "expirationDateMinute");
		int expirationDateAmPm =
			ParamUtil.getInteger(uploadRequest, "expirationDateAmPm");
		boolean neverExpire =
			ParamUtil.getBoolean(uploadRequest, "neverExpire");

		if (expirationDateAmPm == Calendar.PM) {
			expirationDateHour += 12;
		}

		int reviewDateMonth =
			ParamUtil.getInteger(uploadRequest, "reviewDateMonth");
		int reviewDateDay =
			ParamUtil.getInteger(uploadRequest, "reviewDateDay");
		int reviewDateYear =
			ParamUtil.getInteger(uploadRequest, "reviewDateYear");
		int reviewDateHour =
			ParamUtil.getInteger(uploadRequest, "reviewDateHour");
		int reviewDateMinute =
			ParamUtil.getInteger(uploadRequest, "reviewDateMinute");
		int reviewDateAmPm =
			ParamUtil.getInteger(uploadRequest, "reviewDateAmPm");
		boolean neverReview =
			ParamUtil.getBoolean(uploadRequest, "neverReview");

		if (reviewDateAmPm == Calendar.PM) {
			reviewDateHour += 12;
		}

		boolean indexable = ParamUtil.getBoolean(uploadRequest, "indexable");

		boolean smallImage = ParamUtil.getBoolean(uploadRequest, "smallImage");

		String smallImageURL =
			ParamUtil.getString(uploadRequest, "smallImageURL");
		File smallFile = uploadRequest.getFile("smallFile");

		Map<String, byte[]> images = getImages(uploadRequest);

		String articleURL = ParamUtil.getString(uploadRequest, "articleURL");

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);

		JournalArticle article = null;

		if (cmd.equals(Constants.ADD)) {
			if (Validator.isNull(structureId)) {
				content =
					LocalizationUtil.updateLocalization(
						StringPool.BLANK, "static-content", content,
						lastLanguageId, defaultLanguageId, true);
			}

			// Add article

			article =
				JournalArticleServiceUtil.addArticle(
					groupId, articleId, autoArticleId, title, description,
					content, type, structureId, templateId, displayDateMonth,
					displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, expirationDateMonth, expirationDateDay,
					expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth,
					reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, indexable, smallImage,
					smallImageURL, smallFile, images, articleURL,
					serviceContext);

			AssetPublisherUtil.addAndStoreSelection(
				actionRequest, JournalArticle.class.getName(),
				article.getResourcePrimKey(), -1);
		}
		else {

			// Merge current content with new content

			JournalArticle curArticle =
				JournalArticleServiceUtil.getArticle(
					groupId, articleId, version);

			if (Validator.isNull(structureId)) {
				if (!curArticle.isTemplateDriven()) {
					content =
						LocalizationUtil.updateLocalization(
							curArticle.getContent(), "static-content", content,
							lastLanguageId, defaultLanguageId, true);
				}
			}
			else {
				if (curArticle.isTemplateDriven()) {
					JournalStructure structure =
						JournalStructureLocalServiceUtil.getStructure(
							groupId, structureId);

					content =
						JournalUtil.mergeArticleContent(
							curArticle.getContent(), content);
					content =
						JournalUtil.removeOldContent(
							content, structure.getMergedXsd());
				}
			}

			// Update article

			article =
				JournalArticleServiceUtil.updateArticle(
					groupId, articleId, version, incrementVersion, title,
					description, content, type, structureId, templateId,
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, expirationDateMonth,
					expirationDateDay, expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth,
					reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, indexable, smallImage,
					smallImageURL, smallFile, images, articleURL,
					serviceContext);
		}

		boolean approve = ParamUtil.getBoolean(uploadRequest, "approve");

		if (approve) {

			article =
				JournalArticleServiceUtil.approveArticle(
					article.getGroupId(), article.getArticleId(),
					article.getVersion(), articleURL, serviceContext);

		}

		// Recent articles

		JournalUtil.addRecentArticle(actionRequest, article);

		// Journal content

		String portletResource =
			ParamUtil.getString(uploadRequest, "portletResource");
		System.out.println("portlet Resource: " + portletResource);
		if (Validator.isNotNull(portletResource)) {
			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					uploadRequest, portletResource);

			preferences.setValue(
				"group-id", String.valueOf(article.getGroupId()));
			preferences.setValue("article-id", article.getArticleId());

			preferences.store();

			updateContentSearch(
				actionRequest, portletResource, article.getArticleId());
		}

		// PHAN EDIT
		long bpid = ParamUtil.getLong(uploadRequest, "workflow");
		long instanceId = ParamUtil.getLong(uploadRequest, "instanceId");
		String workflowAction =
			ParamUtil.getString(uploadRequest, "workflowAction");
		User user = PortalUtil.getUser(uploadRequest);
		if (((bpid > 0) || (instanceId > 0)) && approve) {
			SAWWorkflowUtil.deleteInstanceArticle(
				instanceId, user.getUserId(), article.getId());
		}

		if ((bpid > 0) && !article.isApproved()) {
			OutputVO outputVO = new OutputVO();
			outputVO =
				SAWWorkflowUtil.startBusinessProcess(
					bpid, article.getId(), user.getUserId());
			BusinessProcessInstanceVO businessProcessInstanceVO =
				new BusinessProcessInstanceVO();
			businessProcessInstanceVO =
				outputVO.getBusinessProcessInstanceVOList().get(0);
			TokenVO tokenVO = businessProcessInstanceVO.getToken();
			System.out.println(tokenVO.getNode().getName());
			if (workflowAction.equals("accept")) {
				SAWWorkflowUtil.checkoutTasks(
					Long.valueOf(businessProcessInstanceVO.getId()),
					user.getUserId(), tokenVO.getNode().getName());
				SAWWorkflowUtil.completeTasks(
					Long.valueOf(businessProcessInstanceVO.getId()),
					user.getUserId(), tokenVO.getNode().getName());
			}
		}
		else if (instanceId > 0) {
			if (workflowAction.equals("accept")) {
				SAWWorkflowUtil.checkoutTasks(instanceId, user.getUserId());
				SAWWorkflowUtil.completeTasks(instanceId, user.getUserId());
			}
			else if (workflowAction.equals("reject")) {
				SAWWorkflowUtil.goBack(
					instanceId, user.getUserId(), article.getId());
			}
		}
		// Tu Add 20101122
		if (approve) {
			/**
			 * ky o day-- cong viec ky: kiem tra ky chua neu chua ky thi ky tiep
			 * tuc kiem tra co certificate chua neu chua thi tao neu co roi thi
			 * dung no de ky neu ky roi phai thong bao cho nguoi dung biet va
			 * khong dc ky lai
			 */
			// kiem tra nguoi dung co check chon ky k?
			boolean signArticle =
				ParamUtil.getBoolean(uploadRequest, "signArticle");

			if (signArticle) {
				// lay keyPair de co privateKey va publicKey de ky
				KeyPair keyPair = getKeyPair("G://keypair.txt");
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
					user.getUserId(), article.getPrimaryKey(),
					keyPair.getPrivate());
			}
		}
		// end Tu add
		return article;
	}

	protected void updateContentSearch(
		ActionRequest actionRequest, String portletResource, String articleId)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		JournalContentSearchLocalServiceUtil.updateContentSearch(
			layout.getGroupId(), layout.isPrivateLayout(),
			layout.getLayoutId(), portletResource, articleId);
	}


	

}
