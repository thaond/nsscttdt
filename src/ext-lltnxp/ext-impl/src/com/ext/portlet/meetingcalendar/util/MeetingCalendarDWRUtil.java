/**
 * 
 */
package com.ext.portlet.meetingcalendar.util;

import java.util.ArrayList;
import java.util.List;

import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight;
import com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightImpl;
import com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author WIN7
 *
 */
public class MeetingCalendarDWRUtil {
	private static Log _log = LogFactoryUtil.getLog(MeetingCalendarDWRUtil.class);
	public static void saveScreenCalendarHeigth(long heigth) {
		List<PmlScreenCalendarHeight> pmlScreenCalendarHeightList = null;
		try {
			pmlScreenCalendarHeightList = PmlScreenCalendarHeightLocalServiceUtil.getPmlScreenCalendarHeights(-1, -1);
		} catch (SystemException e) {
			_log.error("ERROR  get list PmlScreenCalendarHeight in method saveScreenCalendarHeigth "+ e.getMessage());
			pmlScreenCalendarHeightList = new ArrayList<PmlScreenCalendarHeight>();
		}
		
		PmlScreenCalendarHeight pmlScreeSalendarHeigth = null;
		if (pmlScreenCalendarHeightList.size() > 0) {
			for (int i = 0; i < pmlScreenCalendarHeightList.size(); i++) {
				pmlScreeSalendarHeigth = pmlScreenCalendarHeightList.get(i);
				try {
					PmlScreenCalendarHeightLocalServiceUtil.deletePmlScreenCalendarHeight(pmlScreeSalendarHeigth.getScreenCalendarHeightId());
				} catch (PortalException e) {
					_log.error("ERROR remove  PmlScreenCalendarHeight in method saveScreenCalendarHeigth "+ e.getMessage());
				} catch (SystemException e) {
					_log.error("ERROR remove  PmlScreenCalendarHeight in method saveScreenCalendarHeigth "+ e.getMessage());
				}
			}
		}
			
		pmlScreeSalendarHeigth = new PmlScreenCalendarHeightImpl();
		pmlScreeSalendarHeigth.setScreenCalendarHeightId(heigth);
		try {
			PmlScreenCalendarHeightLocalServiceUtil.updatePmlScreenCalendarHeight(pmlScreeSalendarHeigth);
		} catch (SystemException e) {
			_log.error("ERROR in method saveScreenCalendarHeigth "+ e.getMessage());
		}
	}
	
	public static long getScreenCalendarHeigth() {
		try {
			PmlScreenCalendarHeight pmlScreenCalendarHeight = PmlScreenCalendarHeightLocalServiceUtil.getPmlScreenCalendarHeights(-1,-1).get(0);
			return pmlScreenCalendarHeight.getScreenCalendarHeightId();
		} catch (Exception e) {
			return 0;
		}
	}
}
