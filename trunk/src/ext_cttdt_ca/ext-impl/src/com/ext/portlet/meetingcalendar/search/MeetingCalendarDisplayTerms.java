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

package com.ext.portlet.meetingcalendar.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

/**
 * <a href="ArticleDisplayTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class MeetingCalendarDisplayTerms extends DisplayTerms {

	public static final String START_DATE_GT = "startDateGT";

	public static final String START_DATE_LT = "startDateLT";
	
	public static final String DESCRIPTION = "description";

	public static final String SPONSOR = "sponsor";

	public static final String COMPONENT = "component";

	public MeetingCalendarDisplayTerms(RenderRequest req) {
		super(req);
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		description = ParamUtil.getString(req, DESCRIPTION);
		sponsor = ParamUtil.getString(req, SPONSOR);
		component = ParamUtil.getString(req, COMPONENT);
		
		String s=null;
		s=ParamUtil.getString(req, START_DATE_GT);
		if(s.equals("")||s==null)
			startDateGT = null;
		else 
			startDateGT=ParamUtil.getDate(req, START_DATE_GT,f);
		
		s=ParamUtil.getString(req, START_DATE_LT);
		if(s.equals("")||s==null)
			startDateLT = null;
		else 
			startDateLT = ParamUtil.getDate(req, START_DATE_LT,f);
		
	}

	public Date getStartDateGT() {
		return startDateGT;
	}
	
	public String getStringStartDate_GT()
	{
		if (startDateGT==null)
		{
			return "";
		}
		else
		{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.format(startDateGT);
		}
	}
	
	public Date getStartDateLT() {
		return startDateLT;
	}
	
	public String getStringStartDate_LT()
	{
		if (startDateLT==null)
		{
			return "";
		}
		else
		{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.format(startDateLT);
		}
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSponsor() {
		return sponsor;
	}
	
	public String getComponent() {
		return component;
	}

	protected Date startDateGT=null;
	protected Date startDateLT=null;
	protected String description=null;
	protected String sponsor=null;
	protected String component=null;
	
}