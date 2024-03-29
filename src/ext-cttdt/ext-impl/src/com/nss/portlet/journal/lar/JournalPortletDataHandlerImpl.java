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

package com.nss.portlet.journal.lar;

import com.liferay.portal.NoSuchImageException;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.lar.BasePortletDataHandler;
import com.liferay.portal.lar.PortletDataContext;
import com.liferay.portal.lar.PortletDataException;
import com.liferay.portal.lar.PortletDataHandlerBoolean;
import com.liferay.portal.lar.PortletDataHandlerControl;
import com.liferay.portal.lar.PortletDataHandlerKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.ImageUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.lar.DLPortletDataHandlerImpl;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileRank;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.imagegallery.lar.IGPortletDataHandlerImpl;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.model.JournalArticleImage;
import com.nss.portlet.journal.model.JournalFeed;
import com.nss.portlet.journal.model.JournalStructure;
import com.nss.portlet.journal.model.JournalTemplate;
import com.nss.portlet.journal.model.impl.JournalArticleImpl;
import com.nss.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.nss.portlet.journal.service.JournalFeedLocalServiceUtil;
import com.nss.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.nss.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.nss.portlet.journal.service.persistence.JournalArticleImageUtil;
import com.nss.portlet.journal.service.persistence.JournalArticleUtil;
import com.nss.portlet.journal.service.persistence.JournalFeedUtil;
import com.nss.portlet.journal.service.persistence.JournalStructureUtil;
import com.nss.portlet.journal.service.persistence.JournalTemplateUtil;

import java.io.File;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;

/**
 * <a href="JournalPortletDataHandlerImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * <p>
 * Provides the Journal portlet export and import functionality, which is to
 * clone all articles, structures, and templates associated with the layout's
 * group. Upon import, new instances of the corresponding articles, structures,
 * and templates are created or updated according to the DATA_MIRROW strategy
 * The author of the newly created objects are determined by the
 * JournalCreationStrategy class defined in <i>portal.properties</i>. That
 * strategy also allows the text of the journal article to be modified prior
 * to import.
 * </p>
 *
 * <p>
 * This <code>PortletDataHandler</code> differs from
 * <code>JournalContentPortletDataHandlerImpl</code> in that it exports all
 * articles owned by the group whether or not they are actually displayed in a
 * portlet in the layout set.
 * </p>
 *
 * @author Raymond Augé
 * @author Joel Kozikowski
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 * @author Karthik Sudarshan
 *
 * @see com.liferay.portal.lar.PortletDataHandler
 * @see com.nss.portlet.journal.lar.JournalContentPortletDataHandlerImpl
 * @see com.nss.portlet.journal.lar.JournalCreationStrategy
 *
 */
public class JournalPortletDataHandlerImpl extends BasePortletDataHandler {

	public static void exportArticle(
			PortletDataContext context, Element articlesEl, Element dlFoldersEl,
			Element dlFileEntriesEl, Element dlFileRanks, Element igFoldersEl,
			Element igImagesEl, JournalArticle article)
		throws PortalException, SystemException {

		if (!context.isWithinDateRange(article.getModifiedDate())) {
			return;
		}

		String path = getArticlePath(context, article);

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		// Clone this article to make sure changes to its content are never
		// persisted

		article = (JournalArticle)article.clone();

		Element articleEl = articlesEl.addElement("article");

		articleEl.addAttribute("path", path);

		Image smallImage = ImageUtil.fetchByPrimaryKey(
			article.getSmallImageId());

		if (article.isSmallImage() && (smallImage != null)) {
			String smallImagePath = getArticleSmallImagePath(context, article);

			articleEl.addAttribute("small-image-path", smallImagePath);

			article.setSmallImageType(smallImage.getType());

			context.addZipEntry(smallImagePath, smallImage.getTextObj());
		}

		if (context.getBooleanParameter(_NAMESPACE, "images")) {
			String imagePath = getArticleImagePath(context, article);

			articleEl.addAttribute("image-path", imagePath);

			List<JournalArticleImage> articleImages =
				JournalArticleImageUtil.findByG_A_V(
					article.getGroupId(), article.getArticleId(),
					article.getVersion());

			for (JournalArticleImage articleImage : articleImages) {
				try {
					Image image = ImageUtil.findByPrimaryKey(
						articleImage.getArticleImageId());

					String articleImagePath = getArticleImagePath(
						context, article, articleImage, image);

					if (!context.isPathNotProcessed(articleImagePath)) {
						continue;
					}

					context.addZipEntry(articleImagePath, image.getTextObj());
				}
				catch (NoSuchImageException nsie) {
				}
			}
		}

		if (context.getBooleanParameter(_NAMESPACE, "categories")) {
			context.addTagsCategories(
				JournalArticle.class, article.getResourcePrimKey());
		}

		if (context.getBooleanParameter(_NAMESPACE, "comments")) {
			context.addComments(
				JournalArticle.class, article.getResourcePrimKey());
		}

		if (context.getBooleanParameter(_NAMESPACE, "ratings")) {
			context.addRatingsEntries(
				JournalArticle.class, article.getResourcePrimKey());
		}

		if (context.getBooleanParameter(_NAMESPACE, "tags")) {
			context.addTagsEntries(
				JournalArticle.class, article.getResourcePrimKey());
		}

		if (context.getBooleanParameter(_NAMESPACE, "embedded-assets")) {
			String content = article.getContent();

			content = exportDLFileEntries(
				context, dlFoldersEl, dlFileEntriesEl, dlFileRanks,
				article.getGroupId(), content);
			content = exportIGImages(context, igFoldersEl, igImagesEl,
				article.getGroupId(), content);

			article.setContent(content);
		}

		article.setUserUuid(article.getUserUuid());
		article.setApprovedByUserUuid(article.getApprovedByUserUuid());

		context.addZipEntry(path, article);
	}

	public static void exportFeed(
			PortletDataContext context, Element feedsEl, JournalFeed feed)
		throws SystemException {

		if (!context.isWithinDateRange(feed.getModifiedDate())) {
			return;
		}

		String path = getFeedPath(context, feed);

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		Element feedEl = feedsEl.addElement("feed");

		feedEl.addAttribute("path", path);

		feed.setUserUuid(feed.getUserUuid());

		context.addZipEntry(path, feed);
	}

	public static String exportDLFileEntries(
		PortletDataContext context, Element foldersEl, Element fileEntriesEl,
		Element fileRanks, long entityGroupId, String content) {

		StringBuilder sb = new StringBuilder(content);

		int beginPos = content.length();

		while (true) {
			beginPos = content.lastIndexOf("/get_file?", beginPos);

			if (beginPos == -1) {
				return sb.toString();
			}

			int endPos1 = content.indexOf(StringPool.APOSTROPHE, beginPos);
			int endPos2 = content.indexOf(StringPool.CLOSE_BRACKET, beginPos);
			int endPos3 = content.indexOf(StringPool.LESS_THAN, beginPos);
			int endPos4 = content.indexOf(StringPool.QUOTE, beginPos);
			int endPos5 = content.indexOf(StringPool.SPACE, beginPos);

			int endPos = endPos1;

			if ((endPos == -1) || ((endPos2 != -1) && (endPos2 < endPos))) {
				endPos = endPos2;
			}

			if ((endPos == -1) || ((endPos3 != -1) && (endPos3 < endPos))) {
				endPos = endPos3;
			}

			if ((endPos == -1) || ((endPos4 != -1) && (endPos4 < endPos))) {
				endPos = endPos4;
			}

			if ((endPos == -1) || ((endPos5 != -1) && (endPos5 < endPos))) {
				endPos = endPos5;
			}

			if ((beginPos == -1) || (endPos == -1)) {
				break;
			}

			try {
				String oldParameters = content.substring(beginPos, endPos);

				oldParameters = oldParameters.substring(
					oldParameters.indexOf(StringPool.QUESTION) + 1);

				while (oldParameters.contains(StringPool.AMPERSAND_ENCODED)) {
					oldParameters = oldParameters.replace(
						StringPool.AMPERSAND_ENCODED, StringPool.AMPERSAND);
				}

				Map<String, String> map = MapUtil.toLinkedHashMap(
					oldParameters.split(StringPool.AMPERSAND),
					StringPool.EQUAL);

				DLFileEntry fileEntry = null;

				if (map.containsKey("uuid")) {
					String uuid = map.get("uuid");

					String groupIdString = map.get("groupId");

					long groupId = GetterUtil.getLong(groupIdString);

					if (groupIdString.equals("@group_id@")) {
						groupId = entityGroupId;
					}

					fileEntry = DLFileEntryLocalServiceUtil.
						getFileEntryByUuidAndGroupId(uuid, groupId);
				}
				else if (map.containsKey("folderId")) {
					long folderId = GetterUtil.getLong(map.get("folderId"));
					String name = map.get("name");

					fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
						folderId, name);
				}

				if (fileEntry == null) {
					continue;
				}

				DLPortletDataHandlerImpl.exportFileEntry(
					context, foldersEl, fileEntriesEl, fileRanks, fileEntry);

				String newParameters =
					"/get_file?uuid=" + fileEntry.getUuid() +
						"&amp;groupId=@group_id@";

				sb.replace(beginPos, endPos, newParameters);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e);
				}
			}

			beginPos--;
		}

		return sb.toString();
	}

	public static String exportIGImages(
		PortletDataContext context, Element foldersEl, Element imagesEl,
		long entityGroupId, String content) {

		StringBuilder sb = new StringBuilder(content);

		int beginPos = content.length();

		while (true) {
			beginPos = content.lastIndexOf("/image_gallery?", beginPos);

			if (beginPos == -1) {
				return sb.toString();
			}

			int endPos1 = content.indexOf(StringPool.APOSTROPHE, beginPos);
			int endPos2 = content.indexOf(StringPool.CLOSE_BRACKET, beginPos);
			int endPos3 = content.indexOf(StringPool.LESS_THAN, beginPos);
			int endPos4 = content.indexOf(StringPool.QUOTE, beginPos);
			int endPos5 = content.indexOf(StringPool.SPACE, beginPos);

			int endPos = endPos1;

			if ((endPos == -1) || ((endPos2 != -1) && (endPos2 < endPos))) {
				endPos = endPos2;
			}

			if ((endPos == -1) || ((endPos3 != -1) && (endPos3 < endPos))) {
				endPos = endPos3;
			}

			if ((endPos == -1) || ((endPos4 != -1) && (endPos4 < endPos))) {
				endPos = endPos4;
			}

			if ((endPos == -1) || ((endPos5 != -1) && (endPos5 < endPos))) {
				endPos = endPos5;
			}

			if ((beginPos == -1) || (endPos == -1)) {
				break;
			}

			try {
				String oldParameters = content.substring(beginPos, endPos);

				oldParameters = oldParameters.substring(
					oldParameters.indexOf(StringPool.QUESTION) + 1);

				while (oldParameters.contains(StringPool.AMPERSAND_ENCODED)) {
					oldParameters = oldParameters.replace(
						StringPool.AMPERSAND_ENCODED, StringPool.AMPERSAND);
				}

				Map<String, String> map = MapUtil.toLinkedHashMap(
					oldParameters.split(StringPool.AMPERSAND),
					StringPool.EQUAL);

				IGImage image = null;

				if (map.containsKey("uuid")) {
					String uuid = map.get("uuid");

					String groupIdString = map.get("groupId");

					long groupId = GetterUtil.getLong(groupIdString);

					if (groupIdString.equals("@group_id@")) {
						groupId = entityGroupId;
					}

					image = IGImageLocalServiceUtil.getImageByUuidAndGroupId(
						uuid, groupId);
				}
				else if (map.containsKey("image_id") ||
						 map.containsKey("img_id") ||
						 map.containsKey("i_id")) {

					long imageId = GetterUtil.getLong(map.get("image_id"));

					if (imageId <= 0) {
						imageId = GetterUtil.getLong(map.get("img_id"));

						if (imageId <= 0) {
							imageId = GetterUtil.getLong(map.get("i_id"));
						}
					}

					try {
						image = IGImageLocalServiceUtil.getImageByLargeImageId(
							imageId);
					}
					catch (Exception e) {
						image = IGImageLocalServiceUtil.getImageBySmallImageId(
							imageId);
					}
				}

				if (image == null) {
					continue;
				}

				IGPortletDataHandlerImpl.exportImage(
					context, foldersEl, imagesEl, image);

				String timestamp = map.get("t");

				if (timestamp == null) {
					timestamp =	String.valueOf(System.currentTimeMillis());
				}

				String newParameters =
					"/image_gallery?uuid=" + image.getUuid() +
						"&amp;groupId=@group_id@&amp;t=" + timestamp;

				sb.replace(beginPos, endPos, newParameters);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e);
				}
			}

			beginPos--;
		}

		return sb.toString();
	}

	public static void exportStructure(
			PortletDataContext context, Element structuresEl,
			JournalStructure structure)
		throws SystemException {

		if (!context.isWithinDateRange(structure.getModifiedDate())) {
			return;
		}

		String path = getStructurePath(context, structure);

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		Element structureEl = structuresEl.addElement("structure");

		structureEl.addAttribute("path", path);

		structure.setUserUuid(structure.getUserUuid());

		context.addZipEntry(path, structure);
	}

	public static void exportTemplate(
			PortletDataContext context, Element templatesEl,
			Element dlFoldersEl, Element dlFileEntriesEl, Element dlFileRanks,
			Element igFoldersEl, Element igImagesEl, JournalTemplate template)
		throws PortalException, SystemException {

		if (!context.isWithinDateRange(template.getModifiedDate())) {
			return;
		}

		String path = getTemplatePath(context, template);

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		// Clone this template to make sure changes to its content are never
		// persisted

		template = (JournalTemplate)template.clone();

		Element templateEl = templatesEl.addElement("template");

		templateEl.addAttribute("path", path);

		if (template.isSmallImage()) {
			String smallImagePath = getTemplateSmallImagePath(
				context, template);

			templateEl.addAttribute("small-image-path", smallImagePath);

			Image smallImage = ImageUtil.fetchByPrimaryKey(
				template.getSmallImageId());

			template.setSmallImageType(smallImage.getType());

			context.addZipEntry(smallImagePath, smallImage.getTextObj());
		}

		if (context.getBooleanParameter(_NAMESPACE, "embedded-assets")) {
			String content = template.getXsl();

			content = exportDLFileEntries(
				context, dlFoldersEl, dlFileEntriesEl, dlFileRanks,
				template.getGroupId(), content);
			content = exportIGImages(
				context, igFoldersEl, igImagesEl, template.getGroupId(),
				content);

			content = StringUtil.replace(
				content, StringPool.AMPERSAND_ENCODED, StringPool.AMPERSAND);

			template.setXsl(content);
		}

		template.setUserUuid(template.getUserUuid());

		context.addZipEntry(path, template);
	}

	public static void importArticle(
			PortletDataContext context, Map<String, String> structureIds,
			Map<String, String> templateIds, Map<String, String> articleIds,
			Element articleEl)
		throws Exception {

		String path = articleEl.attributeValue("path");

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		JournalArticle article = (JournalArticle)context.getZipEntryAsObject(
			path);

		long userId = context.getUserId(article.getUserUuid());

		User user = UserLocalServiceUtil.getUser(userId);

		long groupId = context.getGroupId();

		String articleId = article.getArticleId();
		boolean autoArticleId = false;

		if ((Validator.isNumber(articleId)) ||
			(JournalArticleUtil.fetchByG_A_V(
				groupId, articleId,
					JournalArticleImpl.DEFAULT_VERSION) != null)) {

			autoArticleId = true;
		}

		String newArticleId = articleIds.get(articleId);

		if (Validator.isNotNull(newArticleId)) {

			// A sibling of a different version was already assigned a new
			// article id

			articleId = newArticleId;
			autoArticleId = false;
		}

		boolean incrementVersion = false;

		String parentStructureId = MapUtil.getString(
			structureIds, article.getStructureId(), article.getStructureId());
		String parentTemplateId = MapUtil.getString(
			templateIds, article.getTemplateId(), article.getTemplateId());

		Date displayDate = article.getDisplayDate();

		int displayDateMonth = 0;
		int displayDateDay = 0;
		int displayDateYear = 0;
		int displayDateHour = 0;
		int displayDateMinute = 0;

		if (displayDate != null) {
			Calendar displayCal = CalendarFactoryUtil.getCalendar(
				user.getTimeZone());

			displayCal.setTime(displayDate);

			displayDateMonth = displayCal.get(Calendar.MONTH);
			displayDateDay = displayCal.get(Calendar.DATE);
			displayDateYear = displayCal.get(Calendar.YEAR);
			displayDateHour = displayCal.get(Calendar.HOUR);
			displayDateMinute = displayCal.get(Calendar.MINUTE);

			if (displayCal.get(Calendar.AM_PM) == Calendar.PM) {
				displayDateHour += 12;
			}
		}

		Date expirationDate = article.getExpirationDate();

		int expirationDateMonth = 0;
		int expirationDateDay = 0;
		int expirationDateYear = 0;
		int expirationDateHour = 0;
		int expirationDateMinute = 0;
		boolean neverExpire = true;

		if (expirationDate != null) {
			Calendar expirationCal = CalendarFactoryUtil.getCalendar(
				user.getTimeZone());

			expirationCal.setTime(expirationDate);

			expirationDateMonth = expirationCal.get(Calendar.MONTH);
			expirationDateDay = expirationCal.get(Calendar.DATE);
			expirationDateYear = expirationCal.get(Calendar.YEAR);
			expirationDateHour = expirationCal.get(Calendar.HOUR);
			expirationDateMinute = expirationCal.get(Calendar.MINUTE);
			neverExpire = false;

			if (expirationCal.get(Calendar.AM_PM) == Calendar.PM) {
				expirationDateHour += 12;
			}
		}

		Date reviewDate = article.getReviewDate();

		int reviewDateMonth = 0;
		int reviewDateDay = 0;
		int reviewDateYear = 0;
		int reviewDateHour = 0;
		int reviewDateMinute = 0;
		boolean neverReview = true;

		if (reviewDate != null) {
			Calendar reviewCal = CalendarFactoryUtil.getCalendar(
				user.getTimeZone());

			reviewCal.setTime(reviewDate);

			reviewDateMonth = reviewCal.get(Calendar.MONTH);
			reviewDateDay = reviewCal.get(Calendar.DATE);
			reviewDateYear = reviewCal.get(Calendar.YEAR);
			reviewDateHour = reviewCal.get(Calendar.HOUR);
			reviewDateMinute = reviewCal.get(Calendar.MINUTE);
			neverReview = false;

			if (reviewCal.get(Calendar.AM_PM) == Calendar.PM) {
				reviewDateHour += 12;
			}
		}

		File smallFile = null;

		String smallImagePath = articleEl.attributeValue("small-image-path");

		if (article.isSmallImage() && Validator.isNotNull(smallImagePath)) {
			byte[] bytes = context.getZipEntryAsByteArray(smallImagePath);

			smallFile = File.createTempFile(
				String.valueOf(article.getSmallImageId()),
				StringPool.PERIOD + article.getSmallImageType());

			FileUtil.write(smallFile, bytes);
		}

		Map<String, byte[]> images = new HashMap<String, byte[]>();

		if (context.getBooleanParameter(_NAMESPACE, "images")) {
			String imagePath = articleEl.attributeValue("image-path");

			List<ObjectValuePair<String, byte[]>> imageFiles =
				context.getZipFolderEntries(imagePath);

			if (imageFiles != null) {
				for (ObjectValuePair<String, byte[]> imageFile : imageFiles) {
					String fileName = imageFile.getKey();

					if (fileName.endsWith(".xml")) {
						continue;
					}

					int pos = fileName.lastIndexOf(StringPool.PERIOD);

					if (pos != -1) {
						fileName = fileName.substring(0, pos);
					}

					images.put(fileName, imageFile.getValue());
				}
			}
		}

		String articleURL = null;

		String[] tagsCategories = null;
		String[] tagsEntries = null;

		if (context.getBooleanParameter(_NAMESPACE, "categories")) {
			tagsCategories = context.getTagsCategories(
				JournalArticle.class, article.getResourcePrimKey());
		}

		if (context.getBooleanParameter(_NAMESPACE, "tags")) {
			tagsEntries = context.getTagsEntries(
				JournalArticle.class, article.getResourcePrimKey());
		}

		JournalCreationStrategy creationStrategy =
			JournalCreationStrategyFactory.getInstance();

		long authorId = creationStrategy.getAuthorUserId(context, article);

		if (authorId != JournalCreationStrategy.USE_DEFAULT_USER_ID_STRATEGY) {
			userId = authorId;
		}

		String newContent = creationStrategy.getTransformedContent(
			context, article);

		if (newContent != JournalCreationStrategy.ARTICLE_CONTENT_UNCHANGED) {
			article.setContent(newContent);
		}

		boolean addCommunityPermissions =
			creationStrategy.addCommunityPermissions(context, article);
		boolean addGuestPermissions = creationStrategy.addGuestPermissions(
			context, article);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(addCommunityPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);
		serviceContext.setTagsCategories(tagsCategories);
		serviceContext.setTagsEntries(tagsEntries);

		JournalArticle existingArticle = null;

		if (Validator.isNotNull(article.getStructureId())) {
			JournalStructure structure = JournalStructureUtil.fetchByG_S(
				context.getGroupId(), article.getStructureId());

			if (structure == null) {
				String structurePath = getImportStructurePath(
					context, article.getStructureId());

				importStructure(context, structureIds, structurePath);
			}
		}

		if (Validator.isNotNull(article.getTemplateId())) {
			JournalTemplate template = JournalTemplateUtil.fetchByG_T(
				context.getGroupId(), article.getTemplateId());

			if (template == null) {
				String templatePath = getImportTemplatePath(
					context, article.getTemplateId());

				String templateSmallImagePath = getImportTemplateSmallImagePath(
					context, article.getTemplateId());

				importTemplate(
					context, structureIds, templateIds, templateSmallImagePath,
					templatePath);
			}
		}

		if (context.getDataStrategy().equals(
				PortletDataHandlerKeys.DATA_STRATEGY_MIRROR)) {

			existingArticle = JournalArticleUtil.fetchByUUID_G(
				article.getUuid(), groupId);

			if (existingArticle == null) {
				existingArticle = JournalArticleLocalServiceUtil.addArticle(
					article.getUuid(), userId, groupId, articleId,
					autoArticleId, article.getVersion(), article.getTitle(),
					article.getDescription(), article.getContent(),
					article.getType(), parentStructureId, parentTemplateId,
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, expirationDateMonth,
					expirationDateDay, expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth,
					reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, article.getIndexable(),
					article.getSmallImage(), article.getSmallImageURL(),
					smallFile, images, articleURL, serviceContext);
			}
			else {
				existingArticle = JournalArticleLocalServiceUtil.updateArticle(
					userId, existingArticle.getGroupId(),
					existingArticle.getArticleId(),
					existingArticle.getVersion(), incrementVersion,
					article.getTitle(), article.getDescription(),
					article.getContent(), article.getType(),
					existingArticle.getStructureId(),
					existingArticle.getTemplateId(), displayDateMonth,
					displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, expirationDateMonth, expirationDateDay,
					expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth,
					reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, article.getIndexable(),
					article.getSmallImage(), article.getSmallImageURL(),
					smallFile, images, articleURL, serviceContext);
			}
		}
		else {
			existingArticle = JournalArticleLocalServiceUtil.addArticle(
				userId, groupId, articleId, autoArticleId, article.getVersion(),
				article.getTitle(), article.getDescription(),
				article.getContent(), article.getType(), parentStructureId,
				parentTemplateId, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire,
				reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour,
				reviewDateMinute, neverReview, article.getIndexable(),
				article.getSmallImage(), article.getSmallImageURL(), smallFile,
				images, articleURL, serviceContext);
		}

		long strategyApprovalUserId = creationStrategy.getApprovalUserId(
			context, article);

		if ((strategyApprovalUserId !=
				JournalCreationStrategy.USE_DEFAULT_USER_ID_STRATEGY) ||
			(article.isApproved() && !existingArticle.isApproved())) {

			long approvedByUserId = strategyApprovalUserId;

			if (approvedByUserId == 0) {
				approvedByUserId = context.getUserId(
					article.getApprovedByUserUuid());
			}

			JournalArticleLocalServiceUtil.approveArticle(
				approvedByUserId, groupId, existingArticle.getArticleId(),
				existingArticle.getVersion(), articleURL, serviceContext);
		}

		if (context.getBooleanParameter(_NAMESPACE, "comments")) {
			context.importComments(
				JournalArticle.class, article.getResourcePrimKey(),
				existingArticle.getResourcePrimKey(), groupId);
		}

		if (context.getBooleanParameter(_NAMESPACE, "ratings")) {
			context.importRatingsEntries(
				JournalArticle.class, article.getResourcePrimKey(),
				existingArticle.getResourcePrimKey());
		}

		articleIds.put(articleId, existingArticle.getArticleId());

		if (!articleId.equals(existingArticle.getArticleId())) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"An article with the ID " + articleId + " already " +
						"exists. The new generated ID is " +
							existingArticle.getArticleId());
			}
		}
	}

	public static void importFeed(
			PortletDataContext context, Map<String, String> structureIds,
			Map<String, String> templateIds, Map<String, String> feedIds,
			Element feedEl)
		throws Exception {

		String path = feedEl.attributeValue("path");

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		JournalFeed feed = (JournalFeed)context.getZipEntryAsObject(path);

		long userId = context.getUserId(feed.getUserUuid());
		long groupId = context.getGroupId();

		String feedId = feed.getFeedId();
		boolean autoFeedId = false;

		if ((Validator.isNumber(feedId)) ||
			(JournalFeedUtil.fetchByG_F(groupId, feedId) != null)) {

			autoFeedId = true;
		}

		String parentStructureId = MapUtil.getString(
			structureIds, feed.getStructureId(), feed.getStructureId());
		String parentTemplateId = MapUtil.getString(
			templateIds, feed.getTemplateId(), feed.getTemplateId());
		String parentRenderTemplateId = MapUtil.getString(
			templateIds, feed.getRendererTemplateId(),
			feed.getRendererTemplateId());

		JournalCreationStrategy creationStrategy =
			JournalCreationStrategyFactory.getInstance();

		long authorId = creationStrategy.getAuthorUserId(context, feed);

		if (authorId != JournalCreationStrategy.USE_DEFAULT_USER_ID_STRATEGY) {
			userId = authorId;
		}

		boolean addCommunityPermissions =
			creationStrategy.addCommunityPermissions(context, feed);
		boolean addGuestPermissions = creationStrategy.addGuestPermissions(
			context, feed);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(addCommunityPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);

		JournalFeed existingFeed = null;

		if (context.getDataStrategy().equals(
				PortletDataHandlerKeys.DATA_STRATEGY_MIRROR)) {

			existingFeed = JournalFeedUtil.fetchByUUID_G(
				feed.getUuid(), groupId);

			if (existingFeed == null) {
				existingFeed = JournalFeedLocalServiceUtil.addFeed(
					feed.getUuid(), userId, groupId, feedId, autoFeedId,
					feed.getName(), feed.getDescription(), feed.getType(),
					parentStructureId, parentTemplateId, parentRenderTemplateId,
					feed.getDelta(), feed.getOrderByCol(),
					feed.getOrderByType(), feed.getTargetLayoutFriendlyUrl(),
					feed.getTargetPortletId(), feed.getContentField(),
					feed.getFeedType(), feed.getFeedVersion(),
					serviceContext);
			}
			else {
				existingFeed = JournalFeedLocalServiceUtil.updateFeed(
					existingFeed.getGroupId(), existingFeed.getFeedId(),
					feed.getName(), feed.getDescription(), feed.getType(),
					parentStructureId, parentTemplateId, parentRenderTemplateId,
					feed.getDelta(), feed.getOrderByCol(),
					feed.getOrderByType(), feed.getTargetLayoutFriendlyUrl(),
					feed.getTargetPortletId(), feed.getContentField(),
					feed.getFeedType(), feed.getFeedVersion(), serviceContext);
			}
		}
		else {
			existingFeed = JournalFeedLocalServiceUtil.addFeed(
				userId, groupId, feedId, autoFeedId, feed.getName(),
				feed.getDescription(), feed.getType(), parentStructureId,
				parentTemplateId, parentRenderTemplateId, feed.getDelta(),
				feed.getOrderByCol(), feed.getOrderByType(),
				feed.getTargetLayoutFriendlyUrl(), feed.getTargetPortletId(),
				feed.getContentField(), feed.getFeedType(),
				feed.getFeedVersion(), serviceContext);
		}

		feedIds.put(feedId, existingFeed.getFeedId());

		if (!feedId.equals(existingFeed.getStructureId())) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"A feed with the ID " + feedId + " already " +
						"exists. The new generated ID is " +
							existingFeed.getFeedId());
			}
		}
	}

	public static void importStructure(
			PortletDataContext context, Map<String, String> structureIds,
			Element structureEl)
		throws Exception {

		String path = structureEl.attributeValue("path");

		importStructure(context, structureIds, path);
	}

	protected static void importStructure(
			PortletDataContext context, Map<String, String> structureIds,
			String path)
		throws Exception {

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		JournalStructure structure =
			(JournalStructure)context.getZipEntryAsObject(path);

		long userId = context.getUserId(structure.getUserUuid());
		long groupId = context.getGroupId();

		String structureId = structure.getStructureId();
		boolean autoStructureId = false;

		if ((Validator.isNumber(structureId)) ||
			(JournalStructureUtil.fetchByG_S(groupId, structureId) != null)) {

			autoStructureId = true;
		}

		JournalCreationStrategy creationStrategy =
			JournalCreationStrategyFactory.getInstance();

		long authorId = creationStrategy.getAuthorUserId(context, structure);

		if (authorId != JournalCreationStrategy.USE_DEFAULT_USER_ID_STRATEGY) {
			userId = authorId;
		}

		boolean addCommunityPermissions =
			creationStrategy.addCommunityPermissions(context, structure);
		boolean addGuestPermissions = creationStrategy.addGuestPermissions(
			context, structure);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(addCommunityPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);

		JournalStructure existingStructure = null;

		if (context.getDataStrategy().equals(
				PortletDataHandlerKeys.DATA_STRATEGY_MIRROR)) {

			existingStructure = JournalStructureUtil.fetchByUUID_G(
				structure.getUuid(), groupId);

			if (existingStructure == null) {
				existingStructure =
					JournalStructureLocalServiceUtil.addStructure(
						structure.getUuid(), userId, groupId, structureId,
						autoStructureId, structure.getParentStructureId(),
						structure.getName(), structure.getDescription(),
						structure.getXsd(), serviceContext);
			}
			else {
				existingStructure =
					JournalStructureLocalServiceUtil.updateStructure(
						existingStructure.getGroupId(),
						existingStructure.getStructureId(),
						structure.getParentStructureId(), structure.getName(),
						structure.getDescription(), structure.getXsd(),
						serviceContext);
			}
		}
		else {
			existingStructure = JournalStructureLocalServiceUtil.addStructure(
				userId, groupId, structureId, autoStructureId,
				structure.getParentStructureId(), structure.getName(),
				structure.getDescription(), structure.getXsd(), serviceContext);
		}

		structureIds.put(structureId, existingStructure.getStructureId());

		if (!structureId.equals(existingStructure.getStructureId())) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"A structure with the ID " + structureId + " already " +
						"exists. The new generated ID is " +
							existingStructure.getStructureId());
			}
		}
	}

	public static void importTemplate(
			PortletDataContext context, Map<String, String> structureIds,
			Map<String, String> templateIds, Element templateEl)
		throws Exception {

		String path = templateEl.attributeValue("path");

		importTemplate(
			context, structureIds, templateIds,
			templateEl.attributeValue("small-image-path"), path);
	}

	protected static void importTemplate(
			PortletDataContext context, Map<String, String> structureIds,
			Map<String, String> templateIds, String smallImagePath, String path)
		throws Exception {

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		JournalTemplate template = (JournalTemplate)context.getZipEntryAsObject(
			path);

		long userId = context.getUserId(template.getUserUuid());
		long groupId = context.getGroupId();

		String templateId = template.getTemplateId();
		boolean autoTemplateId = false;

		if ((Validator.isNumber(templateId)) ||
			(JournalTemplateUtil.fetchByG_T(groupId, templateId) != null)) {

			autoTemplateId = true;
		}

		String parentStructureId = MapUtil.getString(
			structureIds, template.getStructureId(), template.getStructureId());

		boolean formatXsl = false;

		JournalCreationStrategy creationStrategy =
			JournalCreationStrategyFactory.getInstance();

		long authorId = creationStrategy.getAuthorUserId(context, template);

		if (authorId != JournalCreationStrategy.USE_DEFAULT_USER_ID_STRATEGY) {
			userId = authorId;
		}

		boolean addCommunityPermissions =
			creationStrategy.addCommunityPermissions(context, template);
		boolean addGuestPermissions = creationStrategy.addGuestPermissions(
			context, template);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(addCommunityPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);

		File smallFile = null;

		if (template.isSmallImage() && Validator.isNotNull(smallImagePath)) {
			if (smallImagePath.endsWith(StringPool.PERIOD)) {
				smallImagePath += template.getSmallImageType();
			}

			byte[] bytes = context.getZipEntryAsByteArray(smallImagePath);

			if (bytes != null) {
				smallFile = File.createTempFile(
					String.valueOf(template.getSmallImageId()),
					StringPool.PERIOD + template.getSmallImageType());

				FileUtil.write(smallFile, bytes);
			}
		}

		JournalTemplate existingTemplate = null;

		if (context.getDataStrategy().equals(
				PortletDataHandlerKeys.DATA_STRATEGY_MIRROR)) {

			existingTemplate = JournalTemplateUtil.fetchByUUID_G(
				template.getUuid(), groupId);

			if (existingTemplate == null) {
				existingTemplate = JournalTemplateLocalServiceUtil.addTemplate(
					template.getUuid(), userId, groupId, templateId,
					autoTemplateId, parentStructureId, template.getName(),
					template.getDescription(), template.getXsl(), formatXsl,
					template.getLangType(), template.getCacheable(),
					template.isSmallImage(), template.getSmallImageURL(),
					smallFile, serviceContext);
			}
			else {
				existingTemplate =
					JournalTemplateLocalServiceUtil.updateTemplate(
						existingTemplate.getGroupId(),
						existingTemplate.getTemplateId(),
						existingTemplate.getStructureId(), template.getName(),
						template.getDescription(), template.getXsl(), formatXsl,
						template.getLangType(), template.getCacheable(),
						template.isSmallImage(), template.getSmallImageURL(),
						smallFile, serviceContext);
			}
		}
		else {
			existingTemplate = JournalTemplateLocalServiceUtil.addTemplate(
				userId, groupId, templateId, autoTemplateId, parentStructureId,
				template.getName(), template.getDescription(),
				template.getXsl(), formatXsl, template.getLangType(),
				template.getCacheable(), template.isSmallImage(),
				template.getSmallImageURL(), smallFile, serviceContext);
		}

		templateIds.put(templateId, existingTemplate.getTemplateId());

		if (!templateId.equals(existingTemplate.getTemplateId())) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"A template with the ID " + templateId + " already " +
						"exists. The new generated ID is " +
							existingTemplate.getTemplateId());
			}
		}
	}

	public PortletPreferences deleteData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences)
		throws PortletDataException {

		try {
			if (!context.addPrimaryKey(
					JournalPortletDataHandlerImpl.class, "deleteData")) {

				JournalArticleLocalServiceUtil.deleteArticles(
					context.getGroupId());

				JournalTemplateLocalServiceUtil.deleteTemplates(
					context.getGroupId());

				JournalStructureLocalServiceUtil.deleteStructures(
					context.getGroupId());
			}

			return preferences;
		}
		catch (Exception e) {
			throw new PortletDataException(e);
		}
	}

	public String exportData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences)
		throws PortletDataException {

		try {
			Document doc = SAXReaderUtil.createDocument();

			Element root = doc.addElement("journal-data");

			root.addAttribute("group-id", String.valueOf(context.getGroupId()));

			Element structuresEl = root.addElement("structures");

			List<JournalStructure> structures =
				JournalStructureUtil.findByGroupId(context.getGroupId());

			for (JournalStructure structure : structures) {
				exportStructure(context, structuresEl, structure);
			}

			Element templatesEl = root.addElement("templates");
			Element dlFoldersEl = root.addElement("dl-folders");
			Element dlFilesEl = root.addElement("dl-file-entries");
			Element dlFileRanksEl = root.addElement("dl-file-ranks");
			Element igFoldersEl = root.addElement("ig-folders");
			Element igImagesEl = root.addElement("ig-images");

			List<JournalTemplate> templates = JournalTemplateUtil.findByGroupId(
				context.getGroupId());

			for (JournalTemplate template : templates) {
				exportTemplate(
					context, templatesEl, dlFoldersEl, dlFilesEl, dlFileRanksEl,
					igFoldersEl, igImagesEl, template);
			}

			Element feedsEl = root.addElement("feeds");

			List<JournalFeed> feeds = JournalFeedUtil.findByGroupId(
				context.getGroupId());

			for (JournalFeed feed : feeds) {
				if (context.isWithinDateRange(feed.getModifiedDate())) {
					exportFeed(context, feedsEl, feed);
				}
			}

			Element articlesEl = root.addElement("articles");

			if (context.getBooleanParameter(_NAMESPACE, "articles")) {
				List<JournalArticle> articles =
					JournalArticleUtil.findByGroupId(context.getGroupId());

				for (JournalArticle article : articles) {
					if (context.isWithinDateRange(article.getModifiedDate())) {
						exportArticle(
							context, articlesEl, dlFoldersEl, dlFilesEl,
							dlFileRanksEl, igFoldersEl, igImagesEl, article);
					}
				}
			}

			return doc.formattedString();
		}
		catch (Exception e) {
			throw new PortletDataException(e);
		}
	}

	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[] {
			_articles, _structuresTemplatesAndFeeds, _embeddedAssets, _images,
			_categories, _comments, _ratings, _tags
		};
	}

	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[] {
			_articles, _structuresTemplatesAndFeeds, _images, _categories,
			_comments, _ratings, _tags
		};
	}

	public PortletPreferences importData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences, String data)
		throws PortletDataException {

		try {
			Document doc = SAXReaderUtil.read(data);

			Element root = doc.getRootElement();

			List<Element> structureEls = root.element("structures").elements(
				"structure");

			Map<String, String> structureIds =
				(Map<String, String>)context.getNewPrimaryKeysMap(
					JournalStructure.class);

			for (Element structureEl : structureEls) {
				importStructure(context, structureIds, structureEl);
			}

			List<Element> templateEls = root.element("templates").elements(
				"template");

			Map<String, String> templateIds =
				(Map<String, String>)context.getNewPrimaryKeysMap(
					JournalTemplate.class);

			for (Element templateEl : templateEls) {
				importTemplate(context, structureIds, templateIds, templateEl);
			}

			List<Element> feedEls = root.element("feeds").elements("feed");

			Map<String, String> feedIds =
				(Map<String, String>)context.getNewPrimaryKeysMap(
					JournalFeed.class);

			for (Element feedEl : feedEls) {
				importFeed(context, structureIds, templateIds, feedIds, feedEl);
			}

			if (context.getBooleanParameter(_NAMESPACE, "articles")) {
				List<Element> articleEls = root.element("articles").elements(
					"article");

				Map<String, String> articleIds =
					(Map<String, String>)context.getNewPrimaryKeysMap(
						JournalArticle.class);

				for (Element articleEl : articleEls) {
					importArticle(
						context, structureIds, templateIds, articleIds,
						articleEl);
				}
			}

			List<Element> dlFolderEls = root.element("dl-folders").elements(
				"folder");

			Map<Long, Long> dlFolderPKs =
				(Map<Long, Long>)context.getNewPrimaryKeysMap(DLFolder.class);

			for (Element folderEl : dlFolderEls) {
				String path = folderEl.attributeValue("path");

				if (!context.isPathNotProcessed(path)) {
					continue;
				}

				DLFolder folder = (DLFolder)context.getZipEntryAsObject(path);

				DLPortletDataHandlerImpl.importFolder(
					context, dlFolderPKs, folder);
			}

			List<Element> fileEntryEls = root.element(
				"dl-file-entries").elements("file-entry");

			Map<String, String> fileEntryNames =
				(Map<String, String>)context.getNewPrimaryKeysMap(
					DLFileEntry.class);

			for (Element fileEntryEl : fileEntryEls) {
				String path = fileEntryEl.attributeValue("path");

				if (!context.isPathNotProcessed(path)) {
					continue;
				}

				DLFileEntry fileEntry =
					(DLFileEntry)context.getZipEntryAsObject(path);

				String binPath = fileEntryEl.attributeValue("bin-path");

				DLPortletDataHandlerImpl.importFileEntry(
					context, dlFolderPKs, fileEntryNames, fileEntry, binPath);
			}

			List<Element> fileRankEls = root.element("dl-file-ranks").elements(
				"file-rank");

			for (Element fileRankEl : fileRankEls) {
				String path = fileRankEl.attributeValue("path");

				if (!context.isPathNotProcessed(path)) {
					continue;
				}

				DLFileRank fileRank = (DLFileRank)context.getZipEntryAsObject(
					path);

				DLPortletDataHandlerImpl.importFileRank(
					context, dlFolderPKs, fileEntryNames, fileRank);
			}

			List<Element> igFolderEls = root.element("ig-folders").elements(
				"folder");

			Map<Long, Long> igFolderPKs =
				(Map<Long, Long>)context.getNewPrimaryKeysMap(IGFolder.class);

			for (Element folderEl : igFolderEls) {
				String path = folderEl.attributeValue("path");

				if (!context.isPathNotProcessed(path)) {
					continue;
				}

				IGFolder folder = (IGFolder)context.getZipEntryAsObject(path);

				IGPortletDataHandlerImpl.importFolder(
					context, igFolderPKs, folder);
			}

			List<Element> imageEls = root.element("ig-images").elements(
				"image");

			for (Element imageEl : imageEls) {
				String path = imageEl.attributeValue("path");

				if (!context.isPathNotProcessed(path)) {
					continue;
				}

				IGImage image = (IGImage)context.getZipEntryAsObject(path);

				String binPath = imageEl.attributeValue("bin-path");

				IGPortletDataHandlerImpl.importImage(
					context, igFolderPKs, image, binPath);
			}

			return preferences;
		}
		catch (Exception e) {
			throw new PortletDataException(e);
		}
	}

	public boolean isAlwaysExportable() {
		return _ALWAYS_EXPORTABLE;
	}

	public boolean isPublishToLiveByDefault() {
		return PropsValues.JOURNAL_PUBLISH_TO_LIVE_BY_DEFAULT;
	}

	protected static String getArticlePath(
		PortletDataContext context, JournalArticle article) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/articles/");
		sb.append(article.getArticleId());
		sb.append(StringPool.SLASH);
		sb.append(article.getVersion());
		sb.append(StringPool.SLASH);
		sb.append(article.getArticleId());
		sb.append(".xml");

		return sb.toString();
	}

	protected static String getArticleImagePath(
		PortletDataContext context, JournalArticle article) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/articles/");
		sb.append(article.getArticleId());
		sb.append(StringPool.SLASH);
		sb.append(article.getVersion());
		sb.append(StringPool.SLASH);

		return sb.toString();
	}

	protected static String getArticleImagePath(
		PortletDataContext context, JournalArticle article,
		JournalArticleImage articleImage, Image image) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/articles/");
		sb.append(article.getArticleId());
		sb.append(StringPool.SLASH);
		sb.append(article.getVersion());
		sb.append(StringPool.SLASH);
		sb.append(articleImage.getElInstanceId());
		sb.append(StringPool.UNDERLINE);
		sb.append(articleImage.getElName());

		if (Validator.isNotNull(articleImage.getLanguageId())) {
			sb.append(StringPool.UNDERLINE);
			sb.append(articleImage.getLanguageId());
		}

		sb.append(StringPool.PERIOD);
		sb.append(image.getType());

		return sb.toString();
	}

	protected static String getArticleSmallImagePath(
			PortletDataContext context, JournalArticle article)
		throws PortalException, SystemException {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/articles/");
		sb.append(article.getArticleId());
		sb.append("/thumbnail");
		sb.append(StringPool.PERIOD);
		sb.append(article.getSmallImageType());

		return sb.toString();
	}

	protected static String getFeedPath(
		PortletDataContext context, JournalFeed feed) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/feeds/");
		sb.append(feed.getFeedId());
		sb.append(".xml");

		return sb.toString();
	}

	protected static String getImportStructurePath(
		PortletDataContext context, String structureId) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getSourcePortletPath(PortletKeys.JOURNAL));
		sb.append("/structures/");
		sb.append(structureId);
		sb.append(".xml");

		return sb.toString();
	}

	protected static String getImportTemplatePath(
		PortletDataContext context, String templateId) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getSourcePortletPath(PortletKeys.JOURNAL));
		sb.append("/templates/");
		sb.append(templateId);
		sb.append(".xml");

		return sb.toString();
	}

	protected static String getImportTemplateSmallImagePath(
		PortletDataContext context, String templateId) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getSourcePortletPath(PortletKeys.JOURNAL));
		sb.append("/templates/thumbnail-");
		sb.append(templateId);
		sb.append(StringPool.PERIOD);

		return sb.toString();
	}

	protected static String getTemplatePath(
		PortletDataContext context, JournalTemplate template) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/templates/");
		sb.append(template.getTemplateId());
		sb.append(".xml");

		return sb.toString();
	}

	protected static String getTemplateSmallImagePath(
			PortletDataContext context, JournalTemplate template)
		throws PortalException, SystemException {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/templates/thumbnail-");
		sb.append(template.getTemplateId());
		sb.append(StringPool.PERIOD);
		sb.append(template.getSmallImageType());

		return sb.toString();
	}

	protected static String getStructurePath(
		PortletDataContext context, JournalStructure structure) {

		StringBuilder sb = new StringBuilder();

		sb.append(context.getPortletPath(PortletKeys.JOURNAL));
		sb.append("/structures/");
		sb.append(structure.getStructureId());
		sb.append(".xml");

		return sb.toString();
	}

	private static final boolean _ALWAYS_EXPORTABLE = true;

	private static final String _NAMESPACE = "journal";

	private static final PortletDataHandlerBoolean _embeddedAssets =
		new PortletDataHandlerBoolean(_NAMESPACE, "embedded-assets");

	private static final PortletDataHandlerBoolean _images =
		new PortletDataHandlerBoolean(_NAMESPACE, "images");

	private static final PortletDataHandlerBoolean _categories =
		new PortletDataHandlerBoolean(_NAMESPACE, "categories");

	private static final PortletDataHandlerBoolean _comments =
		new PortletDataHandlerBoolean(_NAMESPACE, "comments");

	private static final PortletDataHandlerBoolean _ratings =
		new PortletDataHandlerBoolean(_NAMESPACE, "ratings");

	private static final PortletDataHandlerBoolean _tags =
		new PortletDataHandlerBoolean(_NAMESPACE, "tags");

	private static final PortletDataHandlerBoolean _articles =
		new PortletDataHandlerBoolean(_NAMESPACE, "articles", true, false,
		new PortletDataHandlerControl[] {_images, _comments, _ratings, _tags});

	private static final PortletDataHandlerBoolean
		_structuresTemplatesAndFeeds = new PortletDataHandlerBoolean(
			_NAMESPACE, "structures-templates-and-feeds", true, true);

	private static Log _log =
		LogFactoryUtil.getLog(JournalPortletDataHandlerImpl.class);

}