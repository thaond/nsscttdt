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

package com.nss.portlet.journal.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import javax.portlet.PortletRequest;

/**
 * <a href="TemplateDisplayTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class TemplateDisplayTerms extends DisplayTerms {

	public static final String GROUP_ID = "groupId";

	public static final String TEMPLATE_ID = "searchTemplateId";

	public static final String STRUCTURE_ID = "structureId";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	public TemplateDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		groupId = ParamUtil.getLong(
			portletRequest, GROUP_ID, themeDisplay.getScopeGroupId());
		templateId = ParamUtil.getString(portletRequest, TEMPLATE_ID);
		structureId = ParamUtil.getString(portletRequest, STRUCTURE_ID);
		name = ParamUtil.getString(portletRequest, NAME);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
	}

	public long getGroupId() {
		return groupId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public String getStructureId() {
		return structureId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	protected long groupId;
	protected String templateId;
	protected String structureId;
	protected String name;
	protected String description;

}