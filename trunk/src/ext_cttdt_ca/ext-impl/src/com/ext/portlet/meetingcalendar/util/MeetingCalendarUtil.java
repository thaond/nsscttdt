/**
 * Copyright (c) 2000-2008 TruongSonSoft, Inc. All rights reserved.
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

package com.ext.portlet.meetingcalendar.util;

import com.ext.portlet.meetingcalendar.util.comparator.MeetingCalendarTimeComparator;
import com.ext.portlet.meetingcalendar.util.comparator.MeetingCalendarContentComparator;
import com.ext.portlet.meetingcalendar.util.comparator.MeetingCalendarSponsorComparator;
import com.ext.portlet.meetingcalendar.util.comparator.MeetingCalendarComponentComparator;
import com.ext.portlet.meetingcalendar.util.comparator.MeetingCalendarRoomComparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import java.util.Calendar;
import com.liferay.portal.kernel.util.StringPool;
/**
 *
 * @author Dao Duy Duong
 *
 */
public class MeetingCalendarUtil {
	public static OrderByComparator getArticleOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("startDate")) {
			orderByComparator = new MeetingCalendarTimeComparator(orderByAsc);
		}
		else if (orderByCol.equals("description")) {
			orderByComparator = new MeetingCalendarContentComparator(orderByAsc);
		}
		else if (orderByCol.equals("sponsor")) {
			orderByComparator = new MeetingCalendarSponsorComparator(orderByAsc);
		}
		else if (orderByCol.equals("component")) {
			orderByComparator = new MeetingCalendarComponentComparator(orderByAsc);
		}
		else if (orderByCol.equals("room")) {
			orderByComparator = new MeetingCalendarRoomComparator(orderByAsc);
		}

		return orderByComparator;
	}
	
	public static String toString(Calendar cal) {
		StringBuilder sb = new StringBuilder();

		sb.append(cal.get(Calendar.YEAR));
		sb.append(StringPool.PERIOD);
		sb.append(cal.get(Calendar.MONTH));
		sb.append(StringPool.PERIOD);
		sb.append(cal.get(Calendar.DATE));
		sb.append(StringPool.PERIOD);
		sb.append(cal.getTimeZone().getRawOffset());

		return sb.toString();
	}
}