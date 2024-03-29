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

package com.nss.portlet.journal.util;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.ContentUtil;
import com.liferay.portal.util.PropsKeys;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.WebKeys;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.model.JournalStructure;
import com.nss.portlet.journal.model.JournalTemplate;
import com.nss.portlet.journal.model.impl.JournalStructureImpl;
import com.nss.portlet.journal.model.impl.JournalTemplateImpl;
import com.nss.portlet.journal.service.JournalArticleImageLocalServiceUtil;
import com.nss.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.nss.portlet.journal.util.comparator.ArticleCreateDateComparator;
import com.nss.portlet.journal.util.comparator.ArticleDisplayDateComparator;
import com.nss.portlet.journal.util.comparator.ArticleIDComparator;
import com.nss.portlet.journal.util.comparator.ArticleModifiedDateComparator;
import com.nss.portlet.journal.util.comparator.ArticleReviewDateComparator;
import com.nss.portlet.journal.util.comparator.ArticleTitleComparator;
import com.liferay.util.FiniteUniqueStack;
import com.liferay.util.LocalizationUtil;
import com.liferay.util.xml.XMLFormatter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

/**
 * <a href="JournalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 *
 */
public class JournalUtil {

	public static final int MAX_STACK_SIZE = 20;

	public static final String XML_INDENT = "  ";

	public static void addRecentArticle(
		PortletRequest portletRequest, JournalArticle article) {

		if (article != null) {
			Stack<JournalArticle> stack = getRecentArticles(portletRequest);

			stack.push(article);
		}
	}

	public static void addRecentStructure(
		PortletRequest portletRequest, JournalStructure structure) {

		if (structure != null) {
			Stack<JournalStructure> stack = getRecentStructures(portletRequest);

			stack.push(structure);
		}
	}

	public static void addRecentTemplate(
		PortletRequest portletRequest, JournalTemplate template) {

		if (template != null) {
			Stack<JournalTemplate> stack = getRecentTemplates(portletRequest);

			stack.push(template);
		}
	}

	public static void addReservedEl(
		Element root, Map<String, String> tokens, String name, double value) {

		addReservedEl(root, tokens, name, String.valueOf(value));
	}

	public static void addReservedEl(
		Element root, Map<String, String> tokens, String name, Date value) {

		addReservedEl(root, tokens, name, Time.getRFC822(value));
	}

	public static void addReservedEl(
		Element root, Map<String, String> tokens, String name, String value) {

		// XML

		if (root != null) {
			Element dynamicEl = SAXReaderUtil.createElement("dynamic-element");

			dynamicEl.add(
				SAXReaderUtil.createAttribute(dynamicEl, "name", name));
			dynamicEl.add(
				SAXReaderUtil.createAttribute(dynamicEl, "type", "text"));

			Element dynamicContent = SAXReaderUtil.createElement(
				"dynamic-content");

			//dynamicContent.setText("<![CDATA[" + value + "]]>");
			dynamicContent.setText(value);

			dynamicEl.add(dynamicContent);

			root.add(dynamicEl);
		}

		// Tokens

		tokens.put(
			StringUtil.replace(name, StringPool.DASH, StringPool.UNDERLINE),
			value);
	}

	public static void addAllReservedEls(
		Element root, Map<String, String> tokens, JournalArticle article) {

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_ID,
			article.getArticleId());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_VERSION,
			article.getVersion());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_TITLE,
			article.getTitle());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_DESCRIPTION,
			article.getDescription());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_TYPE,
			article.getType());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_CREATE_DATE,
			article.getCreateDate());

		JournalUtil.addReservedEl(
			root, tokens,
			JournalStructureImpl.RESERVED_ARTICLE_MODIFIED_DATE,
			article.getModifiedDate());

		if (article.getDisplayDate() != null) {
			JournalUtil.addReservedEl(
				root, tokens,
				JournalStructureImpl.RESERVED_ARTICLE_DISPLAY_DATE,
				article.getDisplayDate());
		}

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_SMALL_IMAGE_URL,
			article.getSmallImageURL());

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_AUTHOR_ID,
			String.valueOf(article.getUserId()));

		String userName = StringPool.BLANK;
		String userEmailAddress = StringPool.BLANK;
		String userComments = StringPool.BLANK;
		String userJobTitle = StringPool.BLANK;

		User user = null;

		try {
			user = UserLocalServiceUtil.getUserById(article.getUserId());

			userName = user.getFullName();
			userEmailAddress = user.getEmailAddress();
			userComments = user.getComments();

			Contact contact = user.getContact();

			if (contact != null) {
				userJobTitle = contact.getJobTitle();
			}
		}
		catch (PortalException pe) {
		}
		catch (SystemException se) {
		}

		JournalUtil.addReservedEl(
			root, tokens, JournalStructureImpl.RESERVED_ARTICLE_AUTHOR_NAME,
			userName);

		JournalUtil.addReservedEl(
			root, tokens,
			JournalStructureImpl.RESERVED_ARTICLE_AUTHOR_EMAIL_ADDRESS,
			userEmailAddress);

		JournalUtil.addReservedEl(
			root, tokens,
			JournalStructureImpl.RESERVED_ARTICLE_AUTHOR_COMMENTS,
			userComments);

		JournalUtil.addReservedEl(
			root, tokens,
			JournalStructureImpl.RESERVED_ARTICLE_AUTHOR_JOB_TITLE,
			userJobTitle);
	}

	public static String formatVM(String vm) {
		return vm;
	}

	public static String formatXML(String xml)
		throws org.dom4j.DocumentException, IOException {

		// This is only supposed to format your xml, however, it will also
		// unwantingly change &#169; and other characters like it into their
		// respective readable versions

		xml = StringUtil.replace(xml, "&#", "[$SPECIAL_CHARACTER$]");

		xml = XMLFormatter.toString(xml, XML_INDENT);

		xml = StringUtil.replace(xml, "[$SPECIAL_CHARACTER$]", "&#");

		return xml;
	}

	public static String formatXML(Document doc) throws IOException {
		return doc.formattedString(XML_INDENT);
	}

	public static OrderByComparator getArticleOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("create-date")) {
			orderByComparator = new ArticleCreateDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("display-date")) {
			orderByComparator = new ArticleDisplayDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("id")) {
			orderByComparator = new ArticleIDComparator(orderByAsc);
		}
		else if (orderByCol.equals("modified-date")) {
			orderByComparator = new ArticleModifiedDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("review-date")) {
			orderByComparator = new ArticleReviewDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("title")) {
			orderByComparator = new ArticleTitleComparator(orderByAsc);
		}
		else if (orderByCol.equals("version")) {
			orderByComparator = new ArticleModifiedDateComparator(orderByAsc);
		}

		return orderByComparator;
	}

	public static String getEmailFromAddress(PortletPreferences preferences) {
		String emailFromAddress = PropsUtil.get(
			PropsKeys.JOURNAL_EMAIL_FROM_ADDRESS);

		return preferences.getValue("email-from-address", emailFromAddress);
	}

	public static String getEmailFromName(PortletPreferences preferences) {
		String emailFromName = PropsUtil.get(
			PropsKeys.JOURNAL_EMAIL_FROM_NAME);

		return preferences.getValue("email-from-name", emailFromName);
	}

	public static boolean getEmailArticleApprovalDeniedEnabled(
		PortletPreferences preferences) {

		String emailArticleApprovalDeniedEnabled = preferences.getValue(
			"email-article-approval-denied-enabled", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalDeniedEnabled)) {
			return GetterUtil.getBoolean(emailArticleApprovalDeniedEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_DENIED_ENABLED));
		}
	}

	public static String getEmailArticleApprovalDeniedBody(
		PortletPreferences preferences) {

		String emailArticleApprovalDeniedBody = preferences.getValue(
			"email-article-approval-denied-body", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalDeniedBody)) {
			return emailArticleApprovalDeniedBody;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_DENIED_BODY));
		}
	}

	public static String getEmailArticleApprovalDeniedSubject(
		PortletPreferences preferences) {

		String emailArticleApprovalDeniedSubject = preferences.getValue(
			"email-article-approval-denied-subject", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalDeniedSubject)) {
			return emailArticleApprovalDeniedSubject;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_DENIED_SUBJECT));
		}
	}

	public static boolean getEmailArticleApprovalGrantedEnabled(
		PortletPreferences preferences) {

		String emailArticleApprovalGrantedEnabled = preferences.getValue(
			"email-article-approval-granted-enabled", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalGrantedEnabled)) {
			return GetterUtil.getBoolean(emailArticleApprovalGrantedEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_GRANTED_ENABLED));
		}
	}

	public static String getEmailArticleApprovalGrantedBody(
		PortletPreferences preferences) {

		String emailArticleApprovalGrantedBody = preferences.getValue(
			"email-article-approval-granted-body", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalGrantedBody)) {
			return emailArticleApprovalGrantedBody;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_GRANTED_BODY));
		}
	}

	public static String getEmailArticleApprovalGrantedSubject(
		PortletPreferences preferences) {

		String emailArticleApprovalGrantedSubject = preferences.getValue(
			"email-article-approval-granted-subject", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalGrantedSubject)) {
			return emailArticleApprovalGrantedSubject;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_GRANTED_SUBJECT));
		}
	}

	public static boolean getEmailArticleApprovalRequestedEnabled(
		PortletPreferences preferences) {

		String emailArticleApprovalRequestedEnabled = preferences.getValue(
			"email-article-approval-requested-enabled", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalRequestedEnabled)) {
			return GetterUtil.getBoolean(emailArticleApprovalRequestedEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_REQUESTED_ENABLED));
		}
	}

	public static String getEmailArticleApprovalRequestedBody(
		PortletPreferences preferences) {

		String emailArticleApprovalRequestedBody = preferences.getValue(
			"email-article-approval-requested-body", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalRequestedBody)) {
			return emailArticleApprovalRequestedBody;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_REQUESTED_BODY));
		}
	}

	public static String getEmailArticleApprovalRequestedSubject(
		PortletPreferences preferences) {

		String emailArticleApprovalRequestedSubject = preferences.getValue(
			"email-article-approval-requested-subject", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleApprovalRequestedSubject)) {
			return emailArticleApprovalRequestedSubject;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_APPROVAL_REQUESTED_SUBJECT));
		}
	}

	public static boolean getEmailArticleReviewEnabled(
		PortletPreferences preferences) {

		String emailArticleReviewEnabled = preferences.getValue(
			"email-article-review-enabled", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleReviewEnabled)) {
			return GetterUtil.getBoolean(emailArticleReviewEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_REVIEW_ENABLED));
		}
	}

	public static String getEmailArticleReviewBody(
		PortletPreferences preferences) {

		String emailArticleReviewBody = preferences.getValue(
			"email-article-review-body", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleReviewBody)) {
			return emailArticleReviewBody;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_REVIEW_BODY));
		}
	}

	public static String getEmailArticleReviewSubject(
		PortletPreferences preferences) {

		String emailArticleReviewSubject = preferences.getValue(
			"email-article-review-subject", StringPool.BLANK);

		if (Validator.isNotNull(emailArticleReviewSubject)) {
			return emailArticleReviewSubject;
		}
		else {
			return ContentUtil.get(PropsUtil.get(
				PropsKeys.JOURNAL_EMAIL_ARTICLE_REVIEW_SUBJECT));
		}
	}

	public static Stack<JournalArticle> getRecentArticles(
		PortletRequest portletRequest) {

		PortletSession portletSession = portletRequest.getPortletSession();

		Stack<JournalArticle> recentArticles =
			(Stack<JournalArticle>)portletSession.getAttribute(
				WebKeys.JOURNAL_RECENT_ARTICLES);

		if (recentArticles == null) {
			recentArticles = new FiniteUniqueStack<JournalArticle>(
				MAX_STACK_SIZE);

			portletSession.setAttribute(
				WebKeys.JOURNAL_RECENT_ARTICLES, recentArticles);
		}

		return recentArticles;
	}

	public static Stack<JournalStructure> getRecentStructures(
		PortletRequest portletRequest) {

		PortletSession portletSession = portletRequest.getPortletSession();

		Stack<JournalStructure> recentStructures =
			(Stack<JournalStructure>)portletSession.getAttribute(
				WebKeys.JOURNAL_RECENT_STRUCTURES);

		if (recentStructures == null) {
			recentStructures = new FiniteUniqueStack<JournalStructure>(
				MAX_STACK_SIZE);

			portletSession.setAttribute(
				WebKeys.JOURNAL_RECENT_STRUCTURES, recentStructures);
		}

		return recentStructures;
	}

	public static Stack<JournalTemplate> getRecentTemplates(
		PortletRequest portletRequest) {

		PortletSession portletSession = portletRequest.getPortletSession();

		Stack<JournalTemplate> recentTemplates =
			(Stack<JournalTemplate>)portletSession.getAttribute(
				WebKeys.JOURNAL_RECENT_TEMPLATES);

		if (recentTemplates == null) {
			recentTemplates = new FiniteUniqueStack<JournalTemplate>(
				MAX_STACK_SIZE);

			portletSession.setAttribute(
				WebKeys.JOURNAL_RECENT_TEMPLATES, recentTemplates);
		}

		return recentTemplates;
	}

	public static String getTemplateScript(
			long groupId, String templateId, Map<String, String> tokens,
			String languageId)
		throws PortalException, SystemException {

		return getTemplateScript(groupId, templateId, tokens, languageId, true);
	}

	public static String getTemplateScript(
			long groupId, String templateId, Map<String, String> tokens,
			String languageId, boolean transform)
		throws PortalException, SystemException {

		JournalTemplate template = JournalTemplateLocalServiceUtil.getTemplate(
			groupId, templateId);

		return getTemplateScript(template, tokens, languageId, transform);
	}

	public static String getTemplateScript(
		JournalTemplate template, Map<String, String> tokens, String languageId,
		boolean transform) {

		String script = template.getXsl();

		if (transform) {

			// Listeners

			String[] listeners =
				PropsUtil.getArray(PropsKeys.NSS_JOURNAL_TRANSFORMER_LISTENER);

			for (int i = 0; i < listeners.length; i++) {
				TransformerListener listener = null;

				try {
					listener =
						(TransformerListener)Class.forName(
							listeners[i]).newInstance();

					listener.setTemplateDriven(true);
					listener.setLanguageId(languageId);
					listener.setTokens(tokens);
				}
				catch (Exception e) {
					_log.error(e, e);
				}

				// Modify transform script

				if (listener != null) {
					script = listener.onScript(script);
				}
			}
		}

		return script;
	}

	public static Map<String, String> getTokens(
		long groupId, ThemeDisplay themeDisplay) {

		return getTokens(groupId, themeDisplay, null);
	}

	public static Map<String, String> getTokens(
		long groupId, ThemeDisplay themeDisplay, String xmlRequest) {

		Map<String, String> tokens = new HashMap<String, String>();

		if (themeDisplay != null) {
			_populateTokens(tokens, groupId, themeDisplay);
		}
		else if (Validator.isNotNull(xmlRequest)) {
			try {
				_populateTokens(tokens, groupId, xmlRequest);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}

		return tokens;
	}

	public static String mergeArticleContent(
		String curContent, String newContent) {

		try {
			Document curDocument = SAXReaderUtil.read(curContent);
			Document newDocument = SAXReaderUtil.read(newContent);

			Element curRoot = curDocument.getRootElement();
			Element newRoot = newDocument.getRootElement();

			curRoot.addAttribute(
				"default-locale",
				newRoot.attributeValue("default-locale"));
			curRoot.addAttribute(
				"available-locales",
				newRoot.attributeValue("available-locales"));

			_mergeArticleContentUpdate(
				curDocument, newRoot,
				LocaleUtil.toLanguageId(LocaleUtil.getDefault()));
			_mergeArticleContentDelete(curRoot, newDocument);

			curContent = JournalUtil.formatXML(curDocument);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return curContent;
	}

	public static String removeArticleLocale(
		String content, String languageId) {

		try {
			Document doc = SAXReaderUtil.read(content);

			Element root = doc.getRootElement();

			String availableLocales = root.attributeValue("available-locales");

			if (availableLocales == null) {
				return content;
			}

			availableLocales = StringUtil.remove(availableLocales, languageId);

			if (availableLocales.endsWith(",")) {
				availableLocales = availableLocales.substring(
					0, availableLocales.length() - 1);
			}

			root.addAttribute("available-locales", availableLocales);

			removeArticleLocale(root, languageId);

			content = formatXML(doc);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return content;
	}

	public static void removeArticleLocale(Element el, String languageId)
		throws PortalException, SystemException {

		for (Element dynamicEl : el.elements("dynamic-element")) {
			for (Element dynamicContentEl :
					dynamicEl.elements("dynamic-content")) {

				String curLanguageId = GetterUtil.getString(
					dynamicContentEl.attributeValue("language-id"));

				if (curLanguageId.equals(languageId)) {
					long id = GetterUtil.getLong(
						dynamicContentEl.attributeValue("id"));

					if (id > 0) {
						ImageLocalServiceUtil.deleteImage(id);
					}

					dynamicContentEl.detach();
				}
			}

			removeArticleLocale(dynamicEl, languageId);
		}
	}

	public static String removeOldContent(String content, String xsd) {
		try {
			Document contentDoc = SAXReaderUtil.read(content);
			Document xsdDoc = SAXReaderUtil.read(xsd);

			Element contentRoot = contentDoc.getRootElement();

			Stack<String> path = new Stack<String>();

			path.push(contentRoot.getName());

			_removeOldContent(path, contentRoot, xsdDoc);

			content = formatXML(contentDoc);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return content;
	}

	public static void removeRecentArticle(
		PortletRequest portletRequest, String articleId) {

		Stack<JournalArticle> stack = getRecentArticles(portletRequest);

		Iterator<JournalArticle> itr = stack.iterator();

		while (itr.hasNext()) {
			JournalArticle journalArticle = itr.next();

			if (journalArticle.getArticleId().equals(articleId)) {
				itr.remove();

				break;
			}
		}
	}

	public static void removeRecentStructure(
		PortletRequest portletRequest, String structureId) {

		Stack<JournalStructure> stack = getRecentStructures(portletRequest);

		Iterator<JournalStructure> itr = stack.iterator();

		while (itr.hasNext()) {
			JournalStructure journalStructure = itr.next();

			if (journalStructure.getStructureId().equals(structureId)) {
				itr.remove();

				break;
			}
		}
	}

	public static void removeRecentTemplate(
		PortletRequest portletRequest, String templateId) {

		Stack<JournalTemplate> stack = getRecentTemplates(portletRequest);

		Iterator<JournalTemplate> itr = stack.iterator();

		while (itr.hasNext()) {
			JournalTemplate journalTemplate = itr.next();

			if (journalTemplate.getTemplateId().equals(templateId)) {
				itr.remove();

				break;
			}
		}
	}

	public static String transform(
			Map<String, String> tokens, String viewMode, String languageId,
			String xml, String script, String langType)
		throws Exception {

		// Setup Listeners

		if (_log.isDebugEnabled()) {
			_log.debug("Language " + languageId);
		}

		if (Validator.isNull(viewMode)) {
			viewMode = Constants.VIEW;
		}

		if (_logTokens.isDebugEnabled()) {
			String tokensString = PropertiesUtil.list(tokens);

			_logTokens.debug(tokensString);
		}

		if (_logTransformBefore.isDebugEnabled()) {
			_logTransformBefore.debug(xml);
		}

		List<TransformerListener> listenersList =
			new ArrayList<TransformerListener>();

		String[] listeners = PropsUtil.getArray(
			PropsKeys.NSS_JOURNAL_TRANSFORMER_LISTENER);

		for (int i = 0; i < listeners.length; i++) {
			TransformerListener listener = null;

			try {
				if (_log.isDebugEnabled()) {
					_log.debug("Instantiate listener " + listeners[i]);
				}

				boolean templateDriven = Validator.isNotNull(langType);

				listener = (TransformerListener)Class.forName(
					listeners[i]).newInstance();

				listener.setTemplateDriven(templateDriven);
				listener.setLanguageId(languageId);
				listener.setTokens(tokens);

				listenersList.add(listener);
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			// Modify XML

			if (_logXmlBeforeListener.isDebugEnabled()) {
				_logXmlBeforeListener.debug(xml);
			}

			if (listener != null) {
				xml = listener.onXml(xml);

				if (_logXmlAfterListener.isDebugEnabled()) {
					_logXmlAfterListener.debug(xml);
				}
			}

			// Modify script

			if (_logScriptBeforeListener.isDebugEnabled()) {
				_logScriptBeforeListener.debug(script);
			}

			if (listener != null) {
				script = listener.onScript(script);

				if (_logScriptAfterListener.isDebugEnabled()) {
					_logScriptAfterListener.debug(script);
				}
			}
		}

		// Transform

		String output = null;

		if (Validator.isNull(langType)) {
			output = LocalizationUtil.getLocalization(xml, languageId);
		}
		else if (langType.equals(JournalTemplateImpl.LANG_TYPE_VM)) {
			output = JournalVmUtil.transform(
				tokens, viewMode, languageId, xml, script);
		}
		else if (langType.equals(JournalTemplateImpl.LANG_TYPE_XSL)) {
			output = JournalXslUtil.transform(
				tokens, viewMode, languageId, xml, script);
		}

		// Postprocess output

		for (int i = 0; i < listenersList.size(); i++) {
			TransformerListener listener = listenersList.get(i);

			// Modify output

			if (_logOutputBeforeListener.isDebugEnabled()) {
				_logOutputBeforeListener.debug(output);
			}

			output = listener.onOutput(output);

			if (_logOutputAfterListener.isDebugEnabled()) {
				_logOutputAfterListener.debug(output);
			}
		}

		if (_logTransfromAfter.isDebugEnabled()) {
			_logTransfromAfter.debug(output);
		}

		return output;
	}

	private static Element _getElementByInstanceId(
		Document document, String instanceId) {

		XPath xPathSelector = SAXReaderUtil.createXPath(
			"//dynamic-element[@instance-id='" + instanceId + "']");

		List<Node> nodes = xPathSelector.selectNodes(document);

		if (nodes.size() == 1) {
			return (Element)nodes.get(0);
		}
		else {
			return null;
		}
	}

	private static void _mergeArticleContentDelete(
			Element curParentElement, Document newDocument)
		throws Exception {

		List<Element> curElements = curParentElement.elements(
			"dynamic-element");

		for (int i = 0; i < curElements.size(); i++) {
			Element curElement = curElements.get(i);

			_mergeArticleContentDelete(curElement, newDocument);

			String instanceId = curElement.attributeValue("instance-id");

			Element newElement = _getElementByInstanceId(
				newDocument, instanceId);

			if (newElement == null) {
				curElement.detach();

				String type = curElement.attributeValue("type");

				if (type.equals("image")) {
					_mergeArticleContentDeleteImages(
						curElement.elements("dynamic-content"));
				}
			}
		}
	}

	private static void _mergeArticleContentDeleteImages(List<Element> elements)
		throws Exception {

		for (Element element : elements) {
			long articleImageId = GetterUtil.getLong(
				element.attributeValue("id"));

			JournalArticleImageLocalServiceUtil.deleteArticleImage(
				articleImageId);
		}
	}

	private static void _mergeArticleContentUpdate(
			Document curDocument, Element newParentElement,
			String defaultLocale)
		throws Exception {

		List<Element> newElements = newParentElement.elements(
			"dynamic-element");

		for (int i = 0; i < newElements.size(); i++) {
			Element newElement = newElements.get(i);

			_mergeArticleContentUpdate(
				curDocument, newParentElement, newElement, i, defaultLocale);
		}
	}

	private static void _mergeArticleContentUpdate(
			Document curDocument, Element newParentElement, Element newElement,
			int pos, String defaultLocale)
		throws Exception {

		_mergeArticleContentUpdate(curDocument, newElement, defaultLocale);

		String instanceId = newElement.attributeValue("instance-id");

		Element curElement = _getElementByInstanceId(curDocument, instanceId);

		if (curElement != null) {
			_mergeArticleContentUpdate(curElement, newElement, defaultLocale);
		}
		else {
			String parentInstanceId = newParentElement.attributeValue(
				"instance-id");

			if (Validator.isNull(parentInstanceId)) {
				Element curRoot = curDocument.getRootElement();

				List<Element> curRootElements = curRoot.elements();

				curRootElements.add(pos, newElement.createCopy());
			}
			else {
				Element curParentElement = _getElementByInstanceId(
					curDocument, parentInstanceId);

				if (curParentElement != null) {
					List<Element> curParentElements =
						curParentElement.elements();

					curParentElements.add(pos, newElement.createCopy());
				}
			}
		}
	}

	private static void _mergeArticleContentUpdate(
		Element curElement, Element newElement, String defaultLocale) {

		Element newContentElement = newElement.elements(
			"dynamic-content").get(0);

		String newLanguageId = newContentElement.attributeValue("language-id");
		String newValue = newContentElement.getText();

		List<Element> curContentElements = curElement.elements(
			"dynamic-content");

		if (Validator.isNull(newLanguageId)) {
			for (Element curContentElement : curContentElements) {
				curContentElement.detach();
			}

			Element curContentElement = SAXReaderUtil.createElement(
				"dynamic-content");

			curContentElement.addCDATA(newValue);

			curElement.add(curContentElement);
		}
		else {
			boolean alreadyExists = false;

			for (Element curContentElement : curContentElements) {
				String curLanguageId = curContentElement.attributeValue(
					"language-id");

				if (newLanguageId.equals(curLanguageId)) {
					alreadyExists = true;

					curContentElement.clearContent();
					curContentElement.addCDATA(newValue);

					break;
				}
			}

			if (!alreadyExists) {
				Element curContentElement = curContentElements.get(0);

				String curLanguageId = curContentElement.attributeValue(
					"language-id");

				if (Validator.isNull(curLanguageId)) {
					curContentElement.detach();
				}

				curElement.add(newContentElement.createCopy());
			}
		}
	}

	private static void _populateTokens(
			Map<String, String> tokens, long groupId, String xmlRequest)
		throws Exception {

		Document request = SAXReaderUtil.read(xmlRequest);

		Element root = request.getRootElement();

		Element themeDisplayEl = root.element("theme-display");

		Layout layout = LayoutLocalServiceUtil.getLayout(
			GetterUtil.getLong(themeDisplayEl.elementText("plid")));

		Group group = layout.getGroup();

		String friendlyUrlCurrent = null;

		if (layout.isPublicLayout()) {
			friendlyUrlCurrent = themeDisplayEl.elementText(
				"path-friendly-url-public");
		}
		else if (group.isUserGroup()) {
			friendlyUrlCurrent = themeDisplayEl.elementText(
				"path-friendly-url-private-user");
		}
		else {
			friendlyUrlCurrent = themeDisplayEl.elementText(
				"path-friendly-url-private-group");
		}

		tokens.put("cdn_host", themeDisplayEl.elementText("cdn-host"));
		tokens.put("company_id", themeDisplayEl.elementText("company-id"));
		tokens.put("group_friendly_url", group.getFriendlyURL());
		tokens.put("group_id", String.valueOf(groupId));
		tokens.put("image_path", themeDisplayEl.elementText("path-image"));
		tokens.put("friendly_url_current", friendlyUrlCurrent);
		tokens.put(
			"friendly_url_private_group",
			themeDisplayEl.elementText("path-friendly-url-private-group"));
		tokens.put(
			"friendly_url_private_user",
			themeDisplayEl.elementText("path-friendly-url-private-user"));
		tokens.put(
			"friendly_url_public",
			themeDisplayEl.elementText("path-friendly-url-public"));
		tokens.put("main_path", themeDisplayEl.elementText("path-main"));
		tokens.put("portal_ctx", themeDisplayEl.elementText("path-context"));
		tokens.put(
			"portal_url",
			HttpUtil.removeProtocol(themeDisplayEl.elementText("url-portal")));
		tokens.put("root_path", themeDisplayEl.elementText("path-context"));
		tokens.put(
			"theme_image_path",
			themeDisplayEl.elementText("path-theme-images"));

		// Deprecated tokens

		tokens.put(
			"friendly_url",
			themeDisplayEl.elementText("path-friendly-url-public"));
		tokens.put(
			"friendly_url_private",
			themeDisplayEl.elementText("path-friendly-url-private-group"));
		tokens.put(
			"page_url", themeDisplayEl.elementText("path-friendly-url-public"));
	}

	private static void _populateTokens(
		Map<String, String> tokens, long groupId, ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		Group group = layout.getGroup();

		String friendlyUrlCurrent = null;

		if (layout.isPublicLayout()) {
			friendlyUrlCurrent = themeDisplay.getPathFriendlyURLPublic();
		}
		else if (group.isUserGroup()) {
			friendlyUrlCurrent = themeDisplay.getPathFriendlyURLPrivateUser();
		}
		else {
			friendlyUrlCurrent = themeDisplay.getPathFriendlyURLPrivateGroup();
		}

		tokens.put("cdn_host", themeDisplay.getCDNHost());
		tokens.put("company_id", String.valueOf(themeDisplay.getCompanyId()));
		tokens.put("group_friendly_url", group.getFriendlyURL());
		tokens.put("group_id", String.valueOf(groupId));
		tokens.put("image_path", themeDisplay.getPathImage());
		tokens.put("friendly_url_current", friendlyUrlCurrent);
		tokens.put(
			"friendly_url_private_group",
			themeDisplay.getPathFriendlyURLPrivateGroup());
		tokens.put(
			"friendly_url_private_user",
			themeDisplay.getPathFriendlyURLPrivateUser());
		tokens.put(
			"friendly_url_public", themeDisplay.getPathFriendlyURLPublic());
		tokens.put("main_path", themeDisplay.getPathMain());
		tokens.put("portal_ctx", themeDisplay.getPathContext());
		tokens.put(
			"portal_url", HttpUtil.removeProtocol(themeDisplay.getURLPortal()));
		tokens.put("root_path", themeDisplay.getPathContext());
		tokens.put("theme_image_path", themeDisplay.getPathThemeImages());

		// Deprecated tokens

		tokens.put("friendly_url", themeDisplay.getPathFriendlyURLPublic());
		tokens.put(
			"friendly_url_private",
			themeDisplay.getPathFriendlyURLPrivateGroup());
		tokens.put("page_url", themeDisplay.getPathFriendlyURLPublic());
	}

	private static void _removeOldContent(
			Stack<String> path, Element contentEl, Document xsdDoc)
		throws SystemException {

		String elPath = "";

		for (int i = 0; i < path.size(); i++) {
			elPath += "/" + path.elementAt(i);
		}

		for (int i = 0; i < contentEl.nodeCount(); i++) {
			Node contentNode = contentEl.node(i);

			if (contentNode instanceof Element) {
				_removeOldContent(path, (Element)contentNode, xsdDoc, elPath);
			}
		}
	}

	private static void _removeOldContent(
			Stack<String> path, Element contentEl, Document xsdDoc,
			String elPath)
		throws SystemException {

		String name = contentEl.attributeValue("name");

		if (Validator.isNull(name)) {
			return;
		}

		String localPath = "dynamic-element[@name='" + name + "']";

		String fullPath = elPath + "/" + localPath;

		XPath xPathSelector = SAXReaderUtil.createXPath(fullPath);

		List<Node> curNodes = xPathSelector.selectNodes(xsdDoc);

		if (curNodes.size() == 0) {
			contentEl.detach();
		}

		path.push(localPath);

		_removeOldContent(path, contentEl, xsdDoc);

		path.pop();
	}

	private static Log _log = LogFactoryUtil.getLog(JournalUtil.class);

	private static Log _logOutputAfterListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".OutputAfterListener");

	private static Log _logOutputBeforeListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".OutputBeforeListener");

	private static Log _logScriptAfterListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".ScriptAfterListener");

	private static Log _logScriptBeforeListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".ScriptBeforeListener");

	private static Log _logTransfromAfter = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".TransformAfter");

	private static Log _logTransformBefore = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".BeforeTransform");

	private static Log _logTokens = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".Tokens");

	private static Log _logXmlAfterListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".XmlAfterListener");

	private static Log _logXmlBeforeListener = LogFactoryUtil.getLog(
		JournalUtil.class.getName() + ".XmlBeforeListener");

}