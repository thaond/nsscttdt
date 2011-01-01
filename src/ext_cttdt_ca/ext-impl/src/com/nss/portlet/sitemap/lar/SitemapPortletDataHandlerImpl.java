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

package com.nss.portlet.sitemap.lar;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.lar.BasePortletDataHandler;
import com.liferay.portal.lar.PortletDataContext;
import com.liferay.portal.lar.PortletDataException;
import com.liferay.portal.lar.PortletDataHandlerControl;

import javax.portlet.PortletPreferences;

/**
 * <a href="SitemapPortletDataHandlerImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Bruno Farache
 *
 */
public class SitemapPortletDataHandlerImpl extends BasePortletDataHandler {

	public PortletPreferences deleteData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences)
		throws PortletDataException {

		try {
			preferences.setValue("root-layout-id", StringPool.BLANK);
			preferences.setValue("display-depth", StringPool.BLANK);
			preferences.setValue("include-root-in-tree", StringPool.BLANK);
			preferences.setValue("show-current-page", StringPool.BLANK);
			preferences.setValue("use-html-title", StringPool.BLANK);
			preferences.setValue("show-hidden-pages", StringPool.BLANK);

			return preferences;
		}
		catch (Exception e) {
			throw new PortletDataException(e);
		}
	}

	public String exportData(
		PortletDataContext context, String portletId,
		PortletPreferences preferences) {

		return StringPool.BLANK;
	}

	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[0];
	}

	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[0];
	}

	public PortletPreferences importData(
		PortletDataContext context, String portletId,
		PortletPreferences preferences, String data) {

		return preferences;
	}

	public boolean isPublishToLiveByDefault() {
		return _PUBLISH_TO_LIVE_BY_DEFAULT;
	}

	private static final boolean _PUBLISH_TO_LIVE_BY_DEFAULT = true;

}