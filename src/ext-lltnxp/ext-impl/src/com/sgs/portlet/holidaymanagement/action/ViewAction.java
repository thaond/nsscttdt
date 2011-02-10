package com.sgs.portlet.holidaymanagement.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.holiday.model.PmlHoliday;
import com.sgs.portlet.holiday.model.impl.PmlHolidayImpl;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.holiday.service.persistence.PmlHolidayUtil;

public class ViewAction extends PortletAction {
	// Yenlt update 05/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			String action = ParamUtil.getString(req, Constants.ACTION, "");
			if (Constants.DELETE.equals(action)) {
				deleteHoliday(req);
			}
			if (Constants.ADD.equals(action)) {
				addHoliday(req);
			}
			if (Constants.UPDATE.equals(action)) {
				updateHoliday(req);
			}
			if (Validator.isNotNull(action)) {
				String holidayURL = ParamUtil.getString(req, "holidayURL");
				sendRedirect(req, res, holidayURL);
			}
	}
	
	private void updateHoliday(ActionRequest req) throws Exception {
		long holidayId = ParamUtil.getLong(req, "holidayId", 0);
		PmlHoliday holiday = PmlHolidayLocalServiceUtil.getPmlHoliday(holidayId);
		
		if ("Holiday".equals(holiday.getHoliday_type())) {
			String holidayValue = ParamUtil.getString(req, "holidayValue", "");
			holiday.setHoliday_value(holidayValue);
		}
		else {
			String holidayType = ParamUtil.getString(req, "holidayType", "");
			holiday.setHoliday_type(holidayType);
		}
		
		PmlHolidayLocalServiceUtil.updatePmlHoliday(holiday);
	}

	private void addHoliday(ActionRequest req) throws Exception {
		String mondayValue = ParamUtil.getString(req, "monday", "");
		String tuesdayValue = ParamUtil.getString(req, "tuesday", "");
		String wednesdayValue = ParamUtil.getString(req, "wednesday", "");
		String thursdayValue = ParamUtil.getString(req, "thursday", "");
		String fridayValue = ParamUtil.getString(req, "friday", "");
		String saturdayValue = ParamUtil.getString(req, "saturday", "");
		String sundayValue = ParamUtil.getString(req, "sunday", "");
		
		addHolidayHelp(mondayValue);
		addHolidayHelp(tuesdayValue);
		addHolidayHelp(wednesdayValue);
		addHolidayHelp(thursdayValue);
		addHolidayHelp(fridayValue);
		addHolidayHelp(saturdayValue);
		addHolidayHelp(sundayValue);
		
		// Them ngay nghi le neu co
		String ngayNghiLe = ParamUtil.getString(req, "arr_ngaynghile", "");
		
		if (!ngayNghiLe.equals("")) {
			String[] arrNgayNghiLe = ngayNghiLe.split("_");
			int size = arrNgayNghiLe.length;
			
			for (int i = 1; i < size; i ++) {
				String holidayValue = ParamUtil.getString(req, arrNgayNghiLe[i]);
				PmlHoliday holiday = new PmlHolidayImpl();
				
				if (!"".equals(holidayValue)) {
					holiday.setHolidayId(CounterLocalServiceUtil.increment());
					holiday.setHoliday_type("Holiday");
					holiday.setHoliday_value(ParamUtil.getString(req, arrNgayNghiLe[i]));
				
					PmlHolidayLocalServiceUtil.updatePmlHoliday(holiday);
				}
			}
		}
	}

	private void addHolidayHelp(String dayValue) throws Exception {
		if (!"".equals(dayValue)) {
			String [] dayValueArray = dayValue.split("/");
			
			PmlHoliday holiday = new PmlHolidayImpl();
			
			long holidayId = CounterLocalServiceUtil.increment();
			String holidayType = dayValueArray[0];
			String holidayValue = dayValueArray[1];
			
			holiday.setHolidayId(holidayId);
			holiday.setHoliday_type(holidayType);
			holiday.setHoliday_value(holidayValue);
			
			PmlHolidayLocalServiceUtil.updatePmlHoliday(holiday);
		}
		
	}
//yenlt update 05/04/2010
	private void deleteHoliday(ActionRequest req){
		long holidayId = ParamUtil.getLong(req, "holidayId", 0);
		PmlHoliday holiday = null;
		try {
			holiday = PmlHolidayLocalServiceUtil.getPmlHoliday(holidayId);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		if (null != holiday) {
			try {
				PmlHolidayLocalServiceUtil.deletePmlHoliday(holidayId);
				req.setAttribute("flag", true);
			} catch (Exception e) {
				req.setAttribute("flag", false);
			}
		}
		
	}
//end
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
				String cmd = ParamUtil.getString(req, Constants.CMD, "");
				if (Constants.EDIT.equals(cmd)) {
					editHoliday(req);
				}
				List<PmlHoliday> listHoliday = PmlHolidayUtil.findAll();
				req.setAttribute("listHoliday", listHoliday);
				return mapping.findForward("portlet.sgs.holidaymanagement.view");
	}

	private void editHoliday(RenderRequest req) throws Exception {
		long holidayId = ParamUtil.getLong(req, "holidayId", 0);
		PmlHoliday holiday = PmlHolidayLocalServiceUtil.getPmlHoliday(holidayId);
		
		req.setAttribute("holiday", holiday);
		
	}
	
}
