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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.Map;

/**
 * <a href="ContentTransformerListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ContentTransformerListener extends TransformerListener {

	public String onXml(String s) {
		if (_log.isDebugEnabled()) {
			_log.debug("onXml");
		}

		s = replace(s);

		return s;
	}

	public String onScript(String s) {
		if (_log.isDebugEnabled()) {
			_log.debug("onScript");
		}

		return s;
	}

	public String onOutput(String s) {
		if (_log.isDebugEnabled()) {
			_log.debug("onOutput");
		}

		return s;
	}

	/**
	 * Fill one article with content from another approved article. See the
	 * article DOCUMENTATION-INSTALLATION-BORLAND for a sample use case.
	 *
	 * @param		xml the given string
	 * @return		the processed string
	 */
	protected String replace(String xml) {
		try {
			Document doc = SAXReaderUtil.read(xml);

			Element root = doc.getRootElement();

			replace(root);

			xml = JournalUtil.formatXML(doc);
		}
		catch (Exception e) {
			_log.warn(e.getMessage());
		}

		return xml;
	}

	protected void replace(Element root) throws Exception {
		Map<String, String> tokens = getTokens();

		long groupId = GetterUtil.getLong(tokens.get("group_id"));

		for (Element el : root.elements()) {
			Element dynamicContent = el.element("dynamic-content");

			if (dynamicContent != null) {
				String text = dynamicContent.getText();

				text = HtmlUtil.stripComments(text);
				text = HtmlUtil.stripHtml(text);
				text = text.trim();

				// [@articleId;elementName@]

				if (Validator.isNotNull(text) && text.length() >= 7 &&
					text.startsWith("[@") && text.endsWith("@]")) {

					text = text.substring(2, text.length() - 2);

					int pos = text.indexOf(";");

					if (pos != -1) {
						String articleId = text.substring(0, pos);
						String elementName =
							text.substring(pos + 1, text.length());

						JournalArticle article =
							JournalArticleLocalServiceUtil.getArticle(
								groupId, articleId);

						dynamicContent.clearContent();
						dynamicContent.addCDATA(
							_getDynamicContent(
								article.getContent(), elementName));
					}
				}

				// Make sure to point images to the full path

				else if ((text != null) &&
						 (text.startsWith("/image/journal/article?img_id"))) {

					dynamicContent.setText("@cdn_host@@root_path@" + text);
				}
			}

			replace(el);
		}
	}

	private String _getDynamicContent(String xml, String elementName) {
		String content = null;

		try {
			Document doc = SAXReaderUtil.read(xml);

			Element root = doc.getRootElement();

			for (Element el : root.elements()) {
				String elName = el.attributeValue("name", StringPool.BLANK);

				if (elName.equals(elementName)) {
					content = el.elementText("dynamic-content");

					break;
				}
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return GetterUtil.getString(content);
	}

	private static Log _log =
		LogFactoryUtil.getLog(ContentTransformerListener.class);

}