
package com.nss.portlet.thong_ke_tin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.dao.orm.hibernate.DynamicQueryImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.portlet.tags.model.TagsAsset;
import com.liferay.portlet.tags.model.TagsVocabulary;
import com.liferay.portlet.tags.service.TagsVocabularyLocalServiceUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil;
import com.nss.portlet.thong_ke_tin.dto.JournalArticleCategoryReoportDTO;
import com.nss.portlet.thong_ke_tin.dto.JournalArticleUserReportDTO;
import com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalServiceUtil;
import com.nss.portlet.thong_ke_tin.util.ReportUtil;
import com.nss.workflow.JournalLiferayWorkflowService;

public class ViewAction extends PortletAction {

	private static void createCell(
		String value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorder(
		int value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorder(
		String value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorderColor1(
		String value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex(
			HSSFColor.ORANGE.index, (byte) 0, (byte) 176, (byte) 240);
		cellStyle.setFillForegroundColor(HSSFColor.ORANGE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorderColor2(
		int value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex(
			HSSFColor.BLUE_GREY.index, (byte) 255, (byte) 255, (byte) 0);
		cellStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorderColor2(
		String value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex(
			HSSFColor.AQUA.index, (byte) 255, (byte) 255, (byte) 0);
		cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorderColor3(
		String value, HSSFWorkbook wb, HSSFRow row, int column, HSSFFont font,
		short align, short valign) {

		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex(
			HSSFColor.BROWN.index, (byte) 146, (byte) 208, (byte) 80);
		cellStyle.setFillForegroundColor(HSSFColor.BROWN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private static void createCellBorderLink(
		String value, String url, HSSFWorkbook wb, HSSFRow row, int column,
		HSSFFont font, short align, short valign) {

		HSSFHyperlink hyperlink = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
		hyperlink.setAddress(url);
		HSSFCell cell = row.createCell(column);
		HSSFRichTextString richText = new HSSFRichTextString(value);
		cell.setCellValue(richText);
		cell.setHyperlink(hyperlink);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		font.setUnderline(HSSFFont.U_SINGLE);
		font.setColor(HSSFColor.BLUE.index);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	public static long getPortletId(String portletId) {

		PortletPreferences prfs = null;
		try {
			DetachedCriteria dCriteria =
				DetachedCriteria.forClass(PortletPreferences.class);
			dCriteria.add(Restrictions.eq("portletId", portletId));
			DynamicQuery dynamicQuery = new DynamicQueryImpl(dCriteria);

			List list =
				PortletPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);

			if (!list.isEmpty()) {
				prfs = (PortletPreferences) list.get(0);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return prfs.getPlid();
	}

	private final String PORTLETNAME = "NSS_ASSET_PUBLISHER_INSTANCE_8Dkf";

	public Date createDate(String date) {

		String[] data = date.split("/");
		try {
			int day = Integer.parseInt(data[0]);
			int month = Integer.parseInt(data[1]);
			int year = Integer.parseInt(data[2]);
			return new Date(year - 1900, month - 1, day);
		}
		catch (Exception e) {

		}
		return null;
	}

	public List<JournalArticleCategoryReoportDTO> getListJournalArticleCategoryReoportDTO(
		String categoryNames, String select_category, Date date_create_f,
		Date date_create_t, Date date_approved_f, Date date_approved_t,
		Date date_display_f, Date date_display_t, Date date_expiration_f,
		Date date_expiration_t)
		throws SystemException, PortalException {

		List<TagsVocabulary> vocabularies =
			TagsVocabularyLocalServiceUtil.getTagsVocabularies(-1, -1);
		List<Long> allVocabulary = new ArrayList<Long>();

		for (int i = 0; i < vocabularies.size(); i++) {
			if (!vocabularies.get(i).getFolksonomy()) {
				if ("".equals(categoryNames) || "all".equals(select_category)) {
					allVocabulary.add(vocabularies.get(i).getVocabularyId());
				}
				else {
					if (categoryNames.contains(vocabularies.get(i).getName())) {
						allVocabulary.add(vocabularies.get(i).getVocabularyId());
					}
				}

			}
		}
		return ReportUtil.getReportInfoByVocabulary(
			allVocabulary, date_create_f, date_create_t, date_approved_f,
			date_approved_t, date_display_f, date_display_t, date_expiration_f,
			date_expiration_t);
	}

	public List<JournalArticleUserReportDTO> getListJournalArticleUserReportDTO(
		String userIds, String select_user, Date date_create_f,
		Date date_create_t, Date date_approved_f, Date date_approved_t,
		Date date_display_f, Date date_display_t, Date date_expiration_f,
		Date date_expiration_t)
		throws SystemException {

		List<Long> listUserId = new ArrayList<Long>();
		List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
		for (int i = 0; i < users.size(); i++) {
			if ("".equals(userIds) || "all".equals(select_user)) {
				listUserId.add(users.get(i).getUserId());
			}
			else {
				if (userIds.contains(users.get(i).getScreenName())) {
					listUserId.add(users.get(i).getUserId());
				}
			}

		}
		return ReportUtil.getReportInfo(
			listUserId, date_create_f, date_create_t, date_approved_f,
			date_approved_t, date_display_f, date_display_t, date_expiration_f,
			date_expiration_t);
	}

	public String getURL(ActionRequest req, JournalArticle journalArticle)
		throws SystemException, PortalException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		TagsAsset asset =
			NSSTagsAssetLocalServiceUtil.getTagsAsset(
				journalArticle.getUserId(),
				String.valueOf(journalArticle.getResourcePrimKey())).get(0);
		long plid = getPortletId(PORTLETNAME);
		PortletURL viewFullContentURL =
			new PortletURLImpl(
				request, PORTLETNAME, plid, PortletRequest.RENDER_PHASE);
		viewFullContentURL.setParameter(
			"struts_action", "/nss/asset_publisher/view_content");
		viewFullContentURL.setParameter(
			"assetId", String.valueOf(asset.getAssetId()));
		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JournalArticleResource articleResource =
			JournalArticleResourceLocalServiceUtil.getArticleResource(journalArticle.getResourcePrimKey());
		String languageId = LanguageUtil.getLanguageId(request);
		JournalArticleDisplay articleDisplay =
			JournalContentUtil.getDisplay(
				articleResource.getGroupId(), articleResource.getArticleId(),
				null, null, languageId, themeDisplay);
		if (articleDisplay != null) {
			viewFullContentURL.setParameter(
				"urlTitle", articleDisplay.getUrlTitle());
			viewFullContentURL.setParameter(
				"type", AssetPublisherUtil.TYPE_CONTENT);
		}
		return viewFullContentURL.toString();
	}

	public void printReport(
		ActionRequest req, ActionResponse res, String date_from, String date_to) {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFFont font = wb.createFont();
		HSSFFont font1 = wb.createFont();
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFFont font2 = wb.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font2.setFontHeight((short) (300));
		HSSFFont font3 = wb.createFont();
		font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font3.setFontHeight((short) (300));
		font3.setItalic(true);
		font3.setUnderline(HSSFFont.U_SINGLE);
		HSSFFont font4 = wb.createFont();
		HSSFSheet sheet1 = wb.createSheet();
		sheet1.setColumnWidth(1, 72 * 256);
		sheet1.setColumnWidth(5, 17 * 256);
		sheet1.setColumnWidth(6, 20 * 256);
		sheet1.setColumnWidth(7, 20 * 256);

		HSSFRow row = sheet1.createRow(1);
		Locale locale = req.getLocale();

		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		createCell(
			LanguageUtil.get(locale, "uybannhandanquan"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 4, 6));
		createCell(
			LanguageUtil.get(locale, "conghoaxahoichunghiavietnam"), wb, row,
			4, font1, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(2);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		createCell(
			LanguageUtil.get(locale, "vanphonghdndvubnd"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 4, 6));
		createCell(
			LanguageUtil.get(locale, "daplaptudohanhphuc"), wb, row, 4, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(5);
		sheet1.addMergedRegion(new CellRangeAddress(5, 5, 0, 7));
		createCell(
			LanguageUtil.get(locale, "banthongkechitiet") + " " + date_from +
				" " + LanguageUtil.get(locale, "den") + " " + date_to, wb, row,
			0, font2, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(8);

		sheet1.addMergedRegion(new CellRangeAddress(8, 9, 0, 0));
		createCellBorderColor1(
			LanguageUtil.get(locale, "stt"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(8, 9, 1, 1));
		createCellBorderColor1(
			LanguageUtil.get(locale, "noidungtin"), wb, row, 1, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(8, 8, 2, 4));

		createCellBorderColor1(
			LanguageUtil.get(locale, "theloai"), wb, row, 2, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor1(
			"", wb, row, 3, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor1(
			"", wb, row, 4, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(8, 9, 5, 5));
		createCellBorderColor1(
			LanguageUtil.get(locale, "trangthai"), wb, row, 5, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(8, 9, 6, 6));
		createCellBorderColor1(
			LanguageUtil.get(locale, "tacgia"), wb, row, 6, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(8, 9, 7, 7));
		createCellBorderColor1(
			LanguageUtil.get(locale, "ngayduatin"), wb, row, 7, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(9);
		createCellBorderColor1(
			"", wb, row, 0, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			"", wb, row, 5, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			"", wb, row, 6, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			"", wb, row, 7, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "tin"), wb, row, 2, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "bai"), wb, row, 3, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "anh"), wb, row, 4, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		// noi dung hien thi
		String articleId = ParamUtil.getString(req, "articleIds");
		String[] articleIds = articleId.split(",");
		int stt = 1;
		int index = 10;
		int totalBai = 0;
		int totalTin = 0;
		int totalAnh = 0;
		JournalArticle journalArticle = null;
		WorkflowJournalArticle workflowJournalArticle = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String status = "";
		for (String id : articleIds) {
			row = sheet1.createRow(index);
			createCellBorder(
				stt, wb, row, 0, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			try {
				journalArticle =
					JournalArticleLocalServiceUtil.getArticle(Long.parseLong(id));
				workflowJournalArticle =
					WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(journalArticle.getResourcePrimKey());
				if (journalArticle.getApproved()) {

					createCellBorderLink(
						journalArticle.getTitle(), getURL(req, journalArticle),
						wb, row, 1, font4, HSSFCellStyle.ALIGN_LEFT,
						HSSFCellStyle.VERTICAL_CENTER);
				}
				else {
					createCellBorder(
						journalArticle.getTitle(), wb, row, 1, font,
						HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.VERTICAL_CENTER);
				}

			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			String type_ = workflowJournalArticle.getType_();
			if (type_.equals(JournalLiferayWorkflowService.NEWS)) {
				createCellBorder(
					1, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				createCellBorder(
					"", wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				totalTin++;
			}
			else if (type_.equals(JournalLiferayWorkflowService.ARTICLES)) {
				createCellBorder(
					"", wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				createCellBorder(
					1, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				totalBai++;
			}

			totalAnh += workflowJournalArticle.getCountImageOfArticle();
			createCellBorder(
				workflowJournalArticle.getCountImageOfArticle(), wb, row, 4,
				font, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			if (journalArticle.isExpired()) {
				status = "expired";
			}
			else if (journalArticle.isApproved()) {
				status = "approved";
			}
			else {
				status = "not-approved";
			}
			createCellBorder(
				LanguageUtil.get(locale, status), wb, row, 5, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorder(
				journalArticle.getUserName(), wb, row, 6, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dateFormat.format(journalArticle.getDisplayDate()), wb, row, 7,
				font, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			stt++;
			index++;
		}
		row = sheet1.createRow(index);
		sheet1.addMergedRegion(new CellRangeAddress(index, index, 0, 1));
		createCellBorderColor2(
			LanguageUtil.get(locale, "tong"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalBai, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalAnh, wb, row, 4, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(index + 2);

		createCellBorderColor3(
			LanguageUtil.get(locale, "ghichu"), wb, row, 1, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor3(
			LanguageUtil.get(locale, "soluong"), wb, row, 2, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(index + 3);
		createCellBorder(
			LanguageUtil.get(locale, "tinbandangky"), wb, row, 1, font,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorder(
			totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(index + 4);
		createCellBorder(
			LanguageUtil.get(locale, "baibandangky"), wb, row, 1, font,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorder(
			totalBai, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(index + 5);
		createCellBorder(
			LanguageUtil.get(locale, "anhbandangky"), wb, row, 1, font,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorder(
			totalAnh, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(index + 7);
		sheet1.addMergedRegion(new CellRangeAddress(index + 7, index + 7, 0, 6));
		createCell(
			LanguageUtil.get(locale, "chanhvanphong"), wb, row, 0, font3,
			HSSFCellStyle.ALIGN_RIGHT, HSSFCellStyle.VERTICAL_CENTER);
		try {
			File file = new File("tk-tin.xls");
			HttpServletResponse response =
				PortalUtil.getHttpServletResponse(res);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
			InputStream in = new FileInputStream(file);
			ServletResponseUtil.sendFile(
				response, "tk-tin.xls", in, "application/vnd.ms-excel");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printReportCategory(
		ActionRequest req, ActionResponse res,
		List<JournalArticleCategoryReoportDTO> listCategory, String date_from,
		String date_to) {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFFont font = wb.createFont();
		HSSFFont font1 = wb.createFont();
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFFont font2 = wb.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font2.setFontHeight((short) (300));
		HSSFFont font3 = wb.createFont();
		font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font3.setFontHeight((short) (300));
		font3.setItalic(true);
		font3.setUnderline(HSSFFont.U_SINGLE);
		HSSFFont font4 = wb.createFont();
		HSSFSheet sheet1 = wb.createSheet();
		sheet1.setColumnWidth(1, 72 * 256);
		sheet1.setColumnWidth(5, 17 * 256);
		sheet1.setColumnWidth(6, 20 * 256);
		sheet1.setColumnWidth(7, 20 * 256);
		sheet1.setColumnWidth(2, 17 * 256);
		sheet1.setColumnWidth(3, 17 * 256);
		sheet1.setColumnWidth(4, 17 * 256);
		HSSFRow row = sheet1.createRow(1);
		Locale locale = req.getLocale();
		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		createCell(
			LanguageUtil.get(locale, "uybannhandanquan"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 4, 6));
		createCell(
			LanguageUtil.get(locale, "conghoaxahoichunghiavietnam"), wb, row,
			4, font1, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(2);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		createCell(
			LanguageUtil.get(locale, "vanphonghdndvubnd"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 4, 6));
		createCell(
			LanguageUtil.get(locale, "daplaptudohanhphuc"), wb, row, 4, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(5);
		sheet1.addMergedRegion(new CellRangeAddress(5, 5, 0, 7));
		createCell(
			LanguageUtil.get(locale, "banthongkechitiet") + " " + date_from +
				" " + LanguageUtil.get(locale, "den") + " " + date_to, wb, row,
			0, font2, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(8);

		createCellBorderColor1(
			LanguageUtil.get(locale, "stt"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-loai-tin"), wb, row, 1, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-viet"), wb, row, 2, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-da-duyet"), wb, row, 3, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-chua-duyet"), wb, row, 4,
			font1, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-so-anh"), wb, row, 5, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		int index = 9;
		int stt = 1;
		String articleId = "";
		int total = 0;
		int totalArticleApproved = 0;
		int totalArticleNotApproved = 0;
		int totalArticleImg = 0;
		for (JournalArticleCategoryReoportDTO dto : listCategory) {
			total += dto.getCountArticle();
			totalArticleApproved += dto.getCountArticleApproved();
			totalArticleNotApproved += dto.getCountArticleNotApproved();
			totalArticleImg += dto.getCountArticleImage();
			row = sheet1.createRow(index);
			createCellBorder(
				stt, wb, row, 0, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getName(), wb, row, 1, font, HSSFCellStyle.ALIGN_LEFT,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticle(), wb, row, 2, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleApproved(), wb, row, 3, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleNotApproved(), wb, row, 4, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleImage(), wb, row, 5, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			articleId += dto.getArticleIds();
			index++;
			stt++;
		}
		row = sheet1.createRow(index);
		sheet1.addMergedRegion(new CellRangeAddress(index, index, 0, 1));
		createCellBorderColor2(
			LanguageUtil.get(locale, "tong"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			total, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleApproved, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleNotApproved, wb, row, 4, font,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleImg, wb, row, 5, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		if (total > 0) {
			index += 4;

			row = sheet1.createRow(++index);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 0, 0));
			createCellBorderColor1(
				LanguageUtil.get(locale, "stt"), wb, row, 0, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 1, 1));
			createCellBorderColor1(
				LanguageUtil.get(locale, "noidungtin"), wb, row, 1, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index, 2, 4));

			createCellBorderColor1(
				LanguageUtil.get(locale, "theloai"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor1(
				"", wb, row, 3, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor1(
				"", wb, row, 4, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 5, 5));
			createCellBorderColor1(
				LanguageUtil.get(locale, "trangthai"), wb, row, 5, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 6, 6));
			createCellBorderColor1(
				LanguageUtil.get(locale, "tacgia"), wb, row, 6, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 7, 7));
			createCellBorderColor1(
				LanguageUtil.get(locale, "ngayduatin"), wb, row, 7, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(++index);
			createCellBorderColor1(
				"", wb, row, 0, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 5, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 6, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 7, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "tin"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "bai"), wb, row, 3, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "anh"), wb, row, 4, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			// noi dung hien thi
			String[] articleIds = articleId.split(",");
			stt = 1;
			int totalBai = 0;
			int totalTin = 0;
			int totalAnh = 0;
			JournalArticle journalArticle = null;
			WorkflowJournalArticle workflowJournalArticle = null;
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String status = "";
			for (String id : articleIds) {
				row = sheet1.createRow(++index);
				createCellBorder(
					stt, wb, row, 0, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				try {
					journalArticle =
						JournalArticleLocalServiceUtil.getArticle(Long.parseLong(id));
					workflowJournalArticle =
						WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(journalArticle.getResourcePrimKey());
					if (journalArticle.getApproved()) {
						createCellBorderLink(
							journalArticle.getTitle(),
							getURL(req, journalArticle), wb, row, 1, font4,
							HSSFCellStyle.ALIGN_LEFT,
							HSSFCellStyle.VERTICAL_CENTER);
					}
					else {
						createCellBorder(
							journalArticle.getTitle(), wb, row, 1, font,
							HSSFCellStyle.ALIGN_LEFT,
							HSSFCellStyle.VERTICAL_CENTER);
					}

				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
				String type_ = workflowJournalArticle.getType_();
				if (type_.equals(JournalLiferayWorkflowService.NEWS)) {
					createCellBorder(
						1, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					createCellBorder(
						"", wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					totalTin++;
				}
				else if (type_.equals(JournalLiferayWorkflowService.ARTICLES)) {
					createCellBorder(
						"", wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					createCellBorder(
						1, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					totalBai++;
				}

				totalAnh += workflowJournalArticle.getCountImageOfArticle();
				createCellBorder(
					workflowJournalArticle.getCountImageOfArticle(), wb, row,
					4, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);

				if (journalArticle.isExpired()) {
					status = "expired";
				}
				else if (journalArticle.isApproved()) {
					status = "approved";
				}
				else {
					status = "not-approved";
				}
				createCellBorder(
					LanguageUtil.get(locale, status), wb, row, 5, font,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

				createCellBorder(
					journalArticle.getUserName(), wb, row, 6, font,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
				createCellBorder(
					dateFormat.format(journalArticle.getDisplayDate()), wb,
					row, 7, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				stt++;
			}

			row = sheet1.createRow(++index);
			sheet1.addMergedRegion(new CellRangeAddress(index, index, 0, 1));
			createCellBorderColor2(
				LanguageUtil.get(locale, "tong"), wb, row, 0, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalBai, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalAnh, wb, row, 4, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 2);

			createCellBorderColor3(
				LanguageUtil.get(locale, "ghichu"), wb, row, 1, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor3(
				LanguageUtil.get(locale, "soluong"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 3);
			createCellBorder(
				LanguageUtil.get(locale, "tinbandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 4);
			createCellBorder(
				LanguageUtil.get(locale, "baibandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalBai, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 5);
			createCellBorder(
				LanguageUtil.get(locale, "anhbandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalAnh, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
		}
		row = sheet1.createRow(index + 7);
		sheet1.addMergedRegion(new CellRangeAddress(index + 7, index + 7, 0, 6));
		createCell(
			LanguageUtil.get(locale, "chanhvanphong"), wb, row, 0, font3,
			HSSFCellStyle.ALIGN_RIGHT, HSSFCellStyle.VERTICAL_CENTER);

		try {
			File file = new File("tk-tin-category.xls");
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
			InputStream in = new FileInputStream(file);
			HttpServletResponse response =
				PortalUtil.getHttpServletResponse(res);
			ServletResponseUtil.sendFile(
				response, "tk-tin-category.xls", in, "application/vnd.ms-excel");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printReportUser(
		ActionRequest req, ActionResponse res,
		List<JournalArticleUserReportDTO> listUsers, String date_from,
		String date_to) {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFFont font = wb.createFont();
		HSSFFont font1 = wb.createFont();
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFFont font2 = wb.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font2.setFontHeight((short) (300));
		HSSFFont font3 = wb.createFont();
		font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font3.setFontHeight((short) (300));
		font3.setItalic(true);
		font3.setUnderline(HSSFFont.U_SINGLE);
		HSSFFont font4 = wb.createFont();
		HSSFSheet sheet1 = wb.createSheet();
		sheet1.setColumnWidth(1, 72 * 256);
		sheet1.setColumnWidth(5, 17 * 256);
		sheet1.setColumnWidth(6, 20 * 256);
		sheet1.setColumnWidth(7, 20 * 256);
		sheet1.setColumnWidth(2, 17 * 256);
		sheet1.setColumnWidth(3, 17 * 256);
		sheet1.setColumnWidth(4, 17 * 256);
		HSSFRow row = sheet1.createRow(1);
		Locale locale = req.getLocale();
		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		createCell(
			LanguageUtil.get(locale, "uybannhandanquan"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 4, 6));
		createCell(
			LanguageUtil.get(locale, "conghoaxahoichunghiavietnam"), wb, row,
			4, font1, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(2);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		createCell(
			LanguageUtil.get(locale, "vanphonghdndvubnd"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 4, 6));
		createCell(
			LanguageUtil.get(locale, "daplaptudohanhphuc"), wb, row, 4, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(5);
		sheet1.addMergedRegion(new CellRangeAddress(5, 5, 0, 7));
		createCell(
			LanguageUtil.get(locale, "banthongkechitiet") + " " + date_from +
				" " + LanguageUtil.get(locale, "den") + " " + date_to, wb, row,
			0, font2, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		row = sheet1.createRow(8);

		createCellBorderColor1(
			LanguageUtil.get(locale, "stt"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "author"), wb, row, 1, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-viet"), wb, row, 2, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-da-duyet"), wb, row, 3, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-bai-chua-duyet"), wb, row, 4,
			font1, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		createCellBorderColor1(
			LanguageUtil.get(locale, "nss-tk-so-anh"), wb, row, 5, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

		int index = 9;
		int stt = 1;
		String articleId = "";
		int total = 0;
		int totalArticleApproved = 0;
		int totalArticleNotApproved = 0;
		int totalArticleImg = 0;
		for (JournalArticleUserReportDTO dto : listUsers) {
			total += dto.getCountArticle();
			totalArticleApproved += dto.getCountArticleApproved();
			totalArticleNotApproved += dto.getCountArticleNotApproved();
			totalArticleImg += dto.getCountArticleImage();
			row = sheet1.createRow(index);
			createCellBorder(
				stt, wb, row, 0, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getUserName(), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticle(), wb, row, 2, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleApproved(), wb, row, 3, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleNotApproved(), wb, row, 4, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				dto.getCountArticleImage(), wb, row, 5, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			articleId += dto.getArticleIds();
			index++;
			stt++;
		}
		row = sheet1.createRow(index);
		sheet1.addMergedRegion(new CellRangeAddress(index, index, 0, 1));
		createCellBorderColor2(
			LanguageUtil.get(locale, "tong"), wb, row, 0, font1,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			total, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleApproved, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleNotApproved, wb, row, 4, font,
			HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		createCellBorderColor2(
			totalArticleImg, wb, row, 5, font, HSSFCellStyle.ALIGN_CENTER,
			HSSFCellStyle.VERTICAL_CENTER);

		index += 4;
		if (total > 0) {
			row = sheet1.createRow(++index);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 0, 0));
			createCellBorderColor1(
				LanguageUtil.get(locale, "stt"), wb, row, 0, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 1, 1));
			createCellBorderColor1(
				LanguageUtil.get(locale, "noidungtin"), wb, row, 1, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index, 2, 4));

			createCellBorderColor1(
				LanguageUtil.get(locale, "theloai"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor1(
				"", wb, row, 3, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor1(
				"", wb, row, 4, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 5, 5));
			createCellBorderColor1(
				LanguageUtil.get(locale, "trangthai"), wb, row, 5, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 6, 6));
			createCellBorderColor1(
				LanguageUtil.get(locale, "tacgia"), wb, row, 6, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			sheet1.addMergedRegion(new CellRangeAddress(index, index + 1, 7, 7));
			createCellBorderColor1(
				LanguageUtil.get(locale, "ngayduatin"), wb, row, 7, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(++index);
			createCellBorderColor1(
				"", wb, row, 0, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 5, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 6, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				"", wb, row, 7, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "tin"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "bai"), wb, row, 3, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor1(
				LanguageUtil.get(locale, "anh"), wb, row, 4, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			// noi dung hien thi
			String[] articleIds = articleId.split(",");
			stt = 1;
			int totalBai = 0;
			int totalTin = 0;
			int totalAnh = 0;
			JournalArticle journalArticle = null;
			WorkflowJournalArticle workflowJournalArticle = null;
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String status = "";
			for (String id : articleIds) {
				row = sheet1.createRow(++index);
				createCellBorder(
					stt, wb, row, 0, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				try {
					journalArticle =
						JournalArticleLocalServiceUtil.getArticle(Long.parseLong(id));
					workflowJournalArticle =
						WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(journalArticle.getResourcePrimKey());
					if (journalArticle.getApproved()) {
						createCellBorderLink(
							journalArticle.getTitle(),
							getURL(req, journalArticle), wb, row, 1, font4,
							HSSFCellStyle.ALIGN_LEFT,
							HSSFCellStyle.VERTICAL_CENTER);
					}
					else {
						createCellBorder(
							journalArticle.getTitle(), wb, row, 1, font,
							HSSFCellStyle.ALIGN_LEFT,
							HSSFCellStyle.VERTICAL_CENTER);
					}

				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
				String type_ = workflowJournalArticle.getType_();
				if (type_.equals(JournalLiferayWorkflowService.NEWS)) {
					createCellBorder(
						1, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					createCellBorder(
						"", wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					totalTin++;
				}
				else if (type_.equals(JournalLiferayWorkflowService.ARTICLES)) {
					createCellBorder(
						"", wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					createCellBorder(
						1, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
						HSSFCellStyle.VERTICAL_CENTER);
					totalBai++;
				}

				totalAnh += workflowJournalArticle.getCountImageOfArticle();
				createCellBorder(
					workflowJournalArticle.getCountImageOfArticle(), wb, row,
					4, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);

				if (journalArticle.isExpired()) {
					status = "expired";
				}
				else if (journalArticle.isApproved()) {
					status = "approved";
				}
				else {
					status = "not-approved";
				}
				createCellBorder(
					LanguageUtil.get(locale, status), wb, row, 5, font,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

				createCellBorder(
					journalArticle.getUserName(), wb, row, 6, font,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
				createCellBorder(
					dateFormat.format(journalArticle.getDisplayDate()), wb,
					row, 7, font, HSSFCellStyle.ALIGN_CENTER,
					HSSFCellStyle.VERTICAL_CENTER);
				stt++;
			}

			row = sheet1.createRow(++index);
			sheet1.addMergedRegion(new CellRangeAddress(index, index, 0, 1));
			createCellBorderColor2(
				LanguageUtil.get(locale, "tong"), wb, row, 0, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				"", wb, row, 1, font1, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalBai, wb, row, 3, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
			createCellBorderColor2(
				totalAnh, wb, row, 4, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 2);

			createCellBorderColor3(
				LanguageUtil.get(locale, "ghichu"), wb, row, 1, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			createCellBorderColor3(
				LanguageUtil.get(locale, "soluong"), wb, row, 2, font1,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 3);
			createCellBorder(
				LanguageUtil.get(locale, "tinbandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalTin, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 4);
			createCellBorder(
				LanguageUtil.get(locale, "baibandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalBai, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);

			row = sheet1.createRow(index + 5);
			createCellBorder(
				LanguageUtil.get(locale, "anhbandangky"), wb, row, 1, font,
				HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
			createCellBorder(
				totalAnh, wb, row, 2, font, HSSFCellStyle.ALIGN_CENTER,
				HSSFCellStyle.VERTICAL_CENTER);
		}
		row = sheet1.createRow(index + 7);
		sheet1.addMergedRegion(new CellRangeAddress(index + 7, index + 7, 0, 6));
		createCell(
			LanguageUtil.get(locale, "chanhvanphong"), wb, row, 0, font3,
			HSSFCellStyle.ALIGN_RIGHT, HSSFCellStyle.VERTICAL_CENTER);

		try {
			File file = new File("tk-tin-user.xls");
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
			InputStream in = new FileInputStream(file);
			HttpServletResponse response =
				PortalUtil.getHttpServletResponse(res);
			ServletResponseUtil.sendFile(
				response, "tk-tin-user.xls", in, "application/vnd.ms-excel");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		String date_from = ParamUtil.getString(req, "date_from");
		String date_to = ParamUtil.getString(req, "date_to");
		String report = ParamUtil.getString(req, "report");
		String select_user = ParamUtil.getString(req, "select_user");
		String date_create_f = ParamUtil.getString(req, "date_create_f");
		String date_create_t = ParamUtil.getString(req, "date_create_t");
		String date_display_f = ParamUtil.getString(req, "date_display_f");
		String date_display_t = ParamUtil.getString(req, "date_display_t");
		String date_approved_f = ParamUtil.getString(req, "date_approved_f");
		String date_approved_t = ParamUtil.getString(req, "date_approved_t");
		String date_expiration_f =
			ParamUtil.getString(req, "date_expiration_f");
		String date_expiration_t =
			ParamUtil.getString(req, "date_expiration_t");
		String userIds = ParamUtil.getString(req, "userIds");
		String select_category = ParamUtil.getString(req, "select_category");
		String categoryNames = ParamUtil.getString(req, "categoryNames");

		if ("reportDetails".equals(report)) {
			printReport(req, res, date_from, date_to);
		}
		else if ("reportUser".equals(report)) {
			List<JournalArticleUserReportDTO> listUsers =
				getListJournalArticleUserReportDTO(
					userIds, select_user, createDate(date_create_f),
					createDate(date_create_t), createDate(date_approved_f),
					createDate(date_approved_t), createDate(date_display_f),
					createDate(date_display_t), createDate(date_expiration_f),
					createDate(date_expiration_t));
			printReportUser(req, res, listUsers, date_from, date_to);
		}
		else if ("reportCategory".equals(report)) {
			List<JournalArticleCategoryReoportDTO> listCategory =
				getListJournalArticleCategoryReoportDTO(
					categoryNames, select_category, createDate(date_create_f),
					createDate(date_create_t), createDate(date_approved_f),
					createDate(date_approved_t), createDate(date_display_f),
					createDate(date_display_t), createDate(date_expiration_f),
					createDate(date_expiration_t));
			printReportCategory(req, res, listCategory, date_from, date_to);
		}
	}

	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		String cmd = ParamUtil.getString(req, Constants.CMD);
		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			if ("detailArticle".equals(cmd)) {
				return mapping.findForward("portlet.nss.thong_ke_tin.details");
			}
			else if (cmd.equals("edit_aticle")) {
				return mapping.findForward("portlet.nss.thong_ke_tin.edit_article");
			}
			return mapping.findForward("portlet.nss.thong_ke_tin.view");
		}
	}

}
