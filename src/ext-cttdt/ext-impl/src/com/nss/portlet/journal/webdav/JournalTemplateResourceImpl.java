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

package com.nss.portlet.journal.webdav;

import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.webdav.BaseResourceImpl;
import com.liferay.portal.webdav.WebDAVException;
import com.nss.portlet.journal.model.JournalTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * <a href="JournalTemplateResourceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class JournalTemplateResourceImpl extends BaseResourceImpl {

	public JournalTemplateResourceImpl(
		JournalTemplate template, String parentPath, String name) {

		super(
			parentPath, name, template.getTemplateId(),
			template.getCreateDate(), template.getModifiedDate(),
			template.getXsl().length());

		setModel(template);
		setClassName(JournalTemplate.class.getName());
		setPrimaryKey(template.getPrimaryKey());

		_template = template;
	}

	public boolean isCollection() {
		return false;
	}

	public String getContentType() {
		return ContentTypes.TEXT_XML;
	}

	public InputStream getContentAsStream() throws WebDAVException {
		try {
			return new ByteArrayInputStream(
				_template.getXsl().getBytes(StringPool.UTF8));
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	private JournalTemplate _template;

}