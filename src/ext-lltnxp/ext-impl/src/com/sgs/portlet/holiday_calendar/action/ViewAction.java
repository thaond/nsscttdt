package com.sgs.portlet.holiday_calendar.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portal.util.ConstantsExt;
import com.ext.portlet.util.StringUtil;
import com.ibm.icu.text.SimpleDateFormat;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.util.DocumentConversionUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayImpl;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalServiceUtil;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil;
import com.sgs.portlet.pml_template.model.FileTemplate;
import com.sgs.portlet.pml_template.service.persistence.FileTemplateUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/holiday_calendar/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if (cmd.equals(Constants.ADD)) {
				addHolidayCalendar(req, res, redirect);
			} else if (cmd.equals(Constants.EDIT)) {
				editHolidayCalendar(req);
			} else if (cmd.equals(Constants.UPDATE)) {
				updateHolidayCalendar(req, res);
				sendRedirect(req, res, redirect);
			} else if (cmd.equals(Constants.DELETE)) {
				deleteHolidayCalendar(req);
			} else if (cmd.equals("EXPORT")) {
				exportFile(req,res);
			} else if (cmd.equals("CONVERT")) {
				convertFile(req,res);
			} else if (cmd.equals("SENDDELETE")) {
				sendDeleteFile(req);
			} else if (cmd.equals("DELETEATTACT")) {
				deleteAttactFile(req);
			}
		}
	}
	
	public void deleteAttactFile(ActionRequest req) {
		try {
			List<AttactFileHoliday> attactFileHolidays = AttactFileHolidayLocalServiceUtil.getAttactFileHolidaies(-1, -1);
			for(AttactFileHoliday attactFileHoliday : attactFileHolidays){
				if(attactFileHoliday.getHolidayCalendarId() == 0){
					AttactFileHolidayLocalServiceUtil.deleteAttactFileHoliday(attactFileHoliday);
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteAttactFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void sendDeleteFile(ActionRequest req) {
		long holidayCalendarId = ParamUtil.getLong(req, "holidayCalendarId");
		long attactFileHolidayId = ParamUtil.getLong(req, "attactFileHolidayId");
		try {
			AttactFileHoliday attactFileHoliday = AttactFileHolidayLocalServiceUtil.getAttactFileHoliday(attactFileHolidayId);
			String pathAttactFile = attactFileHoliday.getAttactFileHolidayPath();
			String pathFile = getServlet().getServletContext().getRealPath("/");
			String pathServer = pathFile + pathAttactFile;
			File file = new File(pathServer);
			file.delete();
			AttactFileHolidayLocalServiceUtil.deleteAttactFileHoliday(attactFileHoliday);
			
			HolidayCalendar holidayCalendar = HolidayCalendarLocalServiceUtil.getHolidayCalendar(holidayCalendarId);
			List<AttactFileHoliday> attactFileHolidays = HolidayCalendarLocalServiceUtil.getAttactFileHolidays(holidayCalendarId);
			req.setAttribute("holidayCalendar", holidayCalendar);
			req.setAttribute("attactFileHolidays", attactFileHolidays);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD sendDeleteFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void convertFile(ActionRequest req, ActionResponse res) {
		try {
			boolean previewExportFile = ParamUtil.getBoolean(req, "previewExportFile", false);
			boolean choiceTemplateExportFile = ParamUtil.getBoolean(req, "choiceTemplateExportFile", false);
			
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
			if (previewExportFile) {
				String targetExtension = ParamUtil.get(request, "targetExtension", "rtf");
				String content = ParamUtil.getString(req,"content"); 
				convertFileUpload(targetExtension, ConstantsExt.allowedExtensions, null, req, request, response, content, 0l);
			} else if (choiceTemplateExportFile) {
//				convertFileToHTML("doc", "html", ConstantsExt.allowedExtensions,	null, request, response, req);
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD convertFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void convertFileUpload(String targetExtension, String[] allowedextensions, String[] allowedExtensions,
			ActionRequest req, HttpServletRequest request, HttpServletResponse response, String content, long documentReceiptId) {
		
		String titleFileContent = ParamUtil.getString(req, "titleFileContent", "");
		InputStream is = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta content=\"");
			sb.append(ContentTypes.TEXT_HTML_UTF8);
			sb.append("\" http-equiv=\"content-type\" />");
			sb.append("<base href=\"");
			sb.append("\" />");
			sb.append("</head>");
			sb.append("<body>");
			sb.append(content);
			sb.append("</body>");
			sb.append("</html>");

			is = new ByteArrayInputStream(
				sb.toString().getBytes(StringPool.UTF8));
			
			String sourceExtension = "html";
			if(!targetExtension.equals("")){
				sourceExtension = targetExtension;
			}

			sb = new StringBuilder();

			sb.append(String.valueOf(documentReceiptId));
			sb.append(StringPool.PERIOD);
			sb.append(sourceExtension);

			if (Validator.isNotNull(targetExtension) &&
				ArrayUtil.contains(allowedExtensions, targetExtension)) {
				String id = String.valueOf(new Date().getTime() + documentReceiptId + targetExtension);		

				InputStream convertedIS = DocumentConversionUtil.convert(
					id, is, sourceExtension, targetExtension);
				if ((convertedIS != null) && (convertedIS != is)) {
					sb = new StringBuilder();
					sb.append(id);
					sb.append(StringPool.PERIOD);
					sb.append(targetExtension);
					is = convertedIS;
				}
			}

			String pathFile = getServlet().getServletContext().getRealPath("/") + "upload";
			if (!(new File(pathFile)).exists()) {
				(new File(pathFile)).mkdir();
			}
			
			titleFileContent= titleFileContent.replace(" ", "");
			String dateValue = com.sgs.portlet.holiday_calendar.uitl.Constants.getDateTime();
			String title = dateValue + titleFileContent;
			String pathFileUpload = pathFile + "/" + title + "." +sourceExtension;
			File destFile = new File(pathFileUpload);
			PrintWriter pw = new PrintWriter(destFile);
			
			char[] buffer = new char[1024];
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is, StringPool.UTF8));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				pw.write(buffer, 0, n);
			}
			pw.flush();
			
			AttactFileHoliday attactFileHoliday = new AttactFileHolidayImpl();
			long attactFileHolidayId = CounterLocalServiceUtil.increment();
			attactFileHoliday.setAttactFileHolidayId(attactFileHolidayId);
			
			long userId = PortalUtil.getUserId(req);
			User user = UserLocalServiceUtil.getUser(userId);
			String userName = user.getScreenName();
			attactFileHoliday.setAttactFileHolidayPath("/upload" + "/" + title + "." +sourceExtension);
			String fullTitle = titleFileContent + "_" + userName + "_" + dateValue;
			attactFileHoliday.setAttactFileHolidayTitle(fullTitle);
			AttactFileHolidayLocalServiceUtil.addAttactFileHoliday(attactFileHoliday);
			
			List<AttactFileHoliday> tempList = AttactFileHolidayLocalServiceUtil.getAttactFileHolidaies(-1, -1);
			List<AttactFileHoliday> attactFileHolidays = new ArrayList<AttactFileHoliday>();
			for(AttactFileHoliday afh : tempList){
				if(afh.getHolidayCalendarId() == 0){
					attactFileHolidays.add(afh);
				}
			}
			req.setAttribute("attactFileHolidays", attactFileHolidays);
		}
		catch (Exception e) {
			_log.error("ERROR IN METHOD convertFileUpload OF " + ViewAction.class + " " + e.getMessage());
		}
		finally {
			ServletResponseUtil.cleanUp(is);
		}
	}

	public void exportFile(ActionRequest req, ActionResponse res) {
		try {
			boolean previewExportFile = ParamUtil.getBoolean(req, "previewExportFile", false);
			boolean choiceTemplateExportFile = ParamUtil.getBoolean(req, "choiceTemplateExportFile", false);
			
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
			if (previewExportFile) {
				String targetExtension = ParamUtil.get(request, "targetExtension", "rtf");
				String content = ParamUtil.getString(req,"content"); 
				exportFile(targetExtension, ConstantsExt.allowedExtensions, null, request, response, content, 0l);
			} else if (choiceTemplateExportFile) {
				exportFileToHTML("doc", "html", ConstantsExt.allowedExtensions,	null, request, response, req);
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD exportFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void exportFile(String targetExtension, 	String[] allowedExtensions,
			ThemeDisplay themeDisplay, HttpServletRequest request,
			HttpServletResponse response, String content, long documentReceiptId) {
		InputStream is = null;

		try {
			StringBuilder sb = new StringBuilder();

			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta content=\"");
			sb.append(ContentTypes.TEXT_HTML_UTF8);
			sb.append("\" http-equiv=\"content-type\" />");
			sb.append("<base href=\"");
			sb.append("\" />");
			sb.append("</head>");
			sb.append("<body>");
			sb.append(content);
			sb.append("</body>");
			sb.append("</html>");

			is = new ByteArrayInputStream(
				sb.toString().getBytes(StringPool.UTF8));
			
			String sourceExtension = "html";
			if(!targetExtension.equals("")){
				sourceExtension = targetExtension;
			}

			sb = new StringBuilder();

			sb.append(String.valueOf(documentReceiptId));
			sb.append(StringPool.PERIOD);
			sb.append(sourceExtension);

			String fileName = sb.toString();

			if (Validator.isNotNull(targetExtension) &&
				ArrayUtil.contains(allowedExtensions, targetExtension)) {
				String id = String.valueOf(new Date().getTime() + documentReceiptId + targetExtension);		

				InputStream convertedIS = DocumentConversionUtil.convert(
					id, is, sourceExtension, targetExtension);
				if ((convertedIS != null) && (convertedIS != is)) {
					sb = new StringBuilder();
					sb.append(id);
					sb.append(StringPool.PERIOD);
					sb.append(targetExtension);

					fileName = sb.toString();

					is = convertedIS;
				}
			}

			String contentType = MimeTypesUtil.getContentType(fileName);

			ServletResponseUtil.sendFile(response, fileName, is, contentType);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			ServletResponseUtil.cleanUp(is);
		}
	}
	
	public void exportFileToHTML(String sourceExtension, String targetExtension, String[] allowedExtensions,
			ThemeDisplay themeDisplay, HttpServletRequest request,
			HttpServletResponse response, ActionRequest req) {
		long templateId = ParamUtil.getLong(req, "templateId", 0);
		List<FileTemplate> fileTemplates = null;
		try {
			fileTemplates = FileTemplateUtil.findByTemplateId(templateId);
		} catch (Exception e) {
			fileTemplates = new ArrayList<FileTemplate>();
		}

		if (!fileTemplates.isEmpty()) {
			File file = new File(request.getSession().getServletContext().getRealPath(fileTemplates.get(0).getDuongDan().substring(1,fileTemplates.get(0).getDuongDan().length())));
			InputStream is = null;
			 Writer sOut = new StringWriter();
			try {
				StringBuilder sb = new StringBuilder();
				is = new FileInputStream(file);
				sb = new StringBuilder();
				sb.append(file.getName());
				if (Validator.isNotNull(targetExtension) && ArrayUtil.contains(allowedExtensions, targetExtension)) {
					String id = String.valueOf(new Date().getTime() + targetExtension);
					InputStream convertedIS = DocumentConversionUtil.convert(id, is, sourceExtension, targetExtension);
					if ((convertedIS != null) && (convertedIS != is)) {
						sb = new StringBuilder();
						sb.append(id);
						sb.append(StringPool.PERIOD);
						sb.append(targetExtension);
						is = convertedIS;
					}
				}

				if (is != null) {
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(new InputStreamReader(is, StringPool.UTF8));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							sOut.write(buffer, 0, n);
						}
						sb = new StringBuilder();
						sb.append("<html>");
						sb.append("<head>");
						sb.append("<meta content=\"");
						sb.append(ContentTypes.TEXT_HTML_UTF8);
						sb.append("\" http-equiv=\"content-type\" />");
						sb.append("<base href=\"");
						sb.append("\" />");
						sb.append("</head>");
						sb.append("<body>");
						sb.append(sOut.toString());
						sb.append("</body>");
						sb.append("</html>");
						
						req.setAttribute("htmlToRTF", sb.toString());
					} finally {
						is.close();
						sOut.close();
					}
				}
			} catch (Exception e) {
				_log.error(e, e);
				_log.error(e.toString());
			} 
		}
	}

	public void addHolidayCalendar(ActionRequest req, ActionResponse res, String redirect) throws IOException {
		try{
		String holidayCalendarCode = ParamUtil.getString(req, "holidayCalendarCode");
		String holidayCalendarTitle = ParamUtil.getString(req, "holidayCalendarTitle");
		String holidayCalendarDateCreate = ParamUtil.getString(req, "holidayCalendarDateCreate");
		String attactFileHolidayIds = ParamUtil.getString(req, "attactFileHolidayIds", "");
		
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		boolean checkHolidayCalendarCode = false;
		List<HolidayCalendar> holidayCalendars = HolidayCalendarLocalServiceUtil.getHolidayCalendars(-1, -1);
		for(HolidayCalendar hc : holidayCalendars){
			if(hc.getHolidayCalendarCode().equals(holidayCalendarCode)){
				checkHolidayCalendarCode = true;
			}
		}
		if(!checkHolidayCalendarCode){
			long userId = PortalUtil.getUserId(req);
			long holidayCalendarId = CounterLocalServiceUtil.increment();
			HolidayCalendar holidayCalendar = HolidayCalendarLocalServiceUtil.createHolidayCalendar(holidayCalendarId);
			holidayCalendar.setHolidayCalendarCode(holidayCalendarCode);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateCreate = simpleDateFormat.parse(holidayCalendarDateCreate);
			Timestamp timeNow = new Timestamp(dateCreate.getTime());
			holidayCalendar.setHolidayCalendarDateCreate(timeNow);
			
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				String holidayCalendarTitles = "";
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					holidayCalendarTitles += titleFilesArr[i];
					uploadFile(req, holidayCalendar, userId, nameFieldRowArr[i], titleFilesArr[i]);
				}
				holidayCalendar.setHolidayCalendarTitle(holidayCalendarTitles);
			}
			
			StringTokenizer st = new StringTokenizer(attactFileHolidayIds,"_");
			while(st.hasMoreTokens()){
				long attactFileHolidayId = Long.parseLong(st.nextToken());
				AttactFileHoliday attactFileHoliday = AttactFileHolidayLocalServiceUtil.getAttactFileHoliday(attactFileHolidayId);
				attactFileHoliday.setHolidayCalendarId(holidayCalendarId);
				AttactFileHolidayLocalServiceUtil.updateAttactFileHoliday(attactFileHoliday);
			}
			
			HolidayCalendarLocalServiceUtil.addHolidayCalendar(holidayCalendar);
			List<AttactFileHoliday> attactFileHolidays = AttactFileHolidayLocalServiceUtil.getAttactFileHolidaies(-1, -1);
			for(AttactFileHoliday afh : attactFileHolidays){
				if(afh.getHolidayCalendarId() == 0){
					String pathAttactFile = afh.getAttactFileHolidayPath();
					String pathFile = getServlet().getServletContext().getRealPath("/");
					String pathServer = pathFile + pathAttactFile;
					File file = new File(pathServer);
					file.delete();
					AttactFileHolidayLocalServiceUtil.deleteAttactFileHoliday(afh);
				}
			}
			sendRedirect(req, res, redirect);
		}else{
			req.setAttribute("holidayCalendarCode", holidayCalendarCode);
			req.setAttribute("holidayCalendarTitle", holidayCalendarTitle);
			req.setAttribute("holidayCalendarDateCreate", holidayCalendarDateCreate);
			req.setAttribute("duplicate_holiday_calendar_code", "duplicate_holiday_calendar_code");
			req.setAttribute("tabAddHolidayCalendar","add_holiday_calendar");
		}
		}catch(Exception e){
			_log.error("ERROR IN METHOD addHolidayCalendar OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void uploadFile(ActionRequest req, HolidayCalendar holidayCalendar, long userId, String nameFieldUpload, String titleFile) throws IOException, SystemException, PortalException{
		try{
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File myFile = uploadRequest.getFile(nameFieldUpload);
		String fileNames = uploadRequest.getFileName(nameFieldUpload);
		String dateValue = com.sgs.portlet.document_manager.util.Constants.getDateTime();
		String fileName = dateValue + fileNames;		
		fileName= fileName.replace(" ", "");
		String pathFile = getServlet().getServletContext().getRealPath("/") + "upload";
		File destFile = new File(pathFile + "/" + fileName);
		if (!(new File(pathFile)).exists()) {
			(new File(pathFile)).mkdir();
		}
		FileUtils.copyFile(myFile, destFile);
		
		AttactFileHoliday attactFileHoliday = new AttactFileHolidayImpl();
		long attactFileHolidayId = CounterLocalServiceUtil.increment();
		attactFileHoliday.setAttactFileHolidayId(attactFileHolidayId);
		attactFileHoliday.setHolidayCalendarId(holidayCalendar.getHolidayCalendarId());
		
		User user = UserLocalServiceUtil.getUser(userId);
		String userName = user.getScreenName();
		attactFileHoliday.setAttactFileHolidayPath("/upload" + "/" + fileName);
		String fullTitle = titleFile + "_" + userName + "_" + dateValue;
		attactFileHoliday.setAttactFileHolidayTitle(fullTitle);
		
		AttactFileHolidayLocalServiceUtil.addAttactFileHoliday(attactFileHoliday);
		}catch(Exception e){
			_log.error("ERROR IN METHOD uploadFile OF addHolidayCalendar OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void editHolidayCalendar(ActionRequest req) {
		long holidayCalendarId = ParamUtil.getLong(req, "holidayCalendarId");
		try {
			HolidayCalendar holidayCalendar = HolidayCalendarLocalServiceUtil.getHolidayCalendar(holidayCalendarId);
			List<AttactFileHoliday> attactFileHolidays = HolidayCalendarLocalServiceUtil.getAttactFileHolidays(holidayCalendarId);
			req.setAttribute("holidayCalendar", holidayCalendar);
			req.setAttribute("attactFileHolidays", attactFileHolidays);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editHolidayCalendar OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void updateHolidayCalendar(ActionRequest req, ActionResponse res) {
		try{
			long holidayCalendarId = ParamUtil.getLong(req, "holidayCalendarId");
			String holidayCalendarTitle = ParamUtil.getString(req, "holidayCalendarTitle");
			String holidayCalendarDateCreate = ParamUtil.getString(req, "holidayCalendarDateCreate");
			
			String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
			nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
			String titleFiles  = ParamUtil.getString(req, "titleFiles");
			titleFiles = StringUtil.encodeHtml(titleFiles);
			
				long userId = PortalUtil.getUserId(req);
				HolidayCalendar holidayCalendar = HolidayCalendarLocalServiceUtil.getHolidayCalendar(holidayCalendarId);
				holidayCalendar.setHolidayCalendarTitle(holidayCalendarTitle);
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dateCreate = simpleDateFormat.parse(holidayCalendarDateCreate);
				Timestamp timeNow = new Timestamp(dateCreate.getTime());
				holidayCalendar.setHolidayCalendarDateCreate(timeNow);
				
				if (!"".equals(nameFieldRow)) {
					String [] nameFieldRowArr = nameFieldRow.split("_");
					String [] titleFilesArr = titleFiles.split("#");
					if (titleFilesArr.length == 0) {
						titleFilesArr = new String [nameFieldRowArr.length];
						for (int i = 0; i < nameFieldRowArr.length; i++) {
							titleFilesArr[i] = "";
						}
					}
					String holidayCalendarTitles = "";
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						holidayCalendarTitles += titleFilesArr[i];
						uploadFile(req, holidayCalendar, userId, nameFieldRowArr[i], titleFilesArr[i]);
					}
					holidayCalendar.setHolidayCalendarTitle(holidayCalendarTitles);
				}
				
				HolidayCalendarLocalServiceUtil.updateHolidayCalendar(holidayCalendar);
			}catch(Exception e){
				_log.error("ERROR IN METHOD updateHolidayCalendar OF " + ViewAction.class + " " + e.getMessage());
			}
	}

	public void deleteHolidayCalendar(ActionRequest req) {
		try {
			long holidayCalendarId = ParamUtil.getLong(req, "holidayCalendarId");
			List<AttactFileHoliday> attactFileHolidays = HolidayCalendarLocalServiceUtil.getAttactFileHolidays(holidayCalendarId);
			for(AttactFileHoliday attactFileHoliday : attactFileHolidays){
				String pathAttactFile = attactFileHoliday.getAttactFileHolidayPath();
				String pathFile = getServlet().getServletContext().getRealPath("/");
				String pathServer = pathFile + pathAttactFile;
				File file = new File(pathServer);
				file.delete();
				AttactFileHolidayLocalServiceUtil.deleteAttactFileHoliday(attactFileHoliday);
			}
				HolidayCalendarLocalServiceUtil.deleteHolidayCalendar(holidayCalendarId);
		} catch (Exception e) {
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		try {
			String dateFrom = ParamUtil.getString(req, "dateFrom");
			String dateTo = ParamUtil.getString(req, "dateTo");
			req.setAttribute("dateFrom", dateFrom);
			req.setAttribute("dateTo", dateTo);
		} catch (Exception e) {
			_log.error("ERROR IN RENDER OF " + ViewAction.class + " " + e.getMessage());
		}
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.holiday_calendar.view");
		}
	}
}
