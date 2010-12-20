
package com.nss.portlet.thong_ke_tin.util;

/**
 * 
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.tags.service.TagsVocabularyLocalServiceUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.thong_ke_tin.dto.JournalArticleCategoryReoportDTO;
import com.nss.portlet.thong_ke_tin.dto.JournalArticleUserReportDTO;
import com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalServiceUtil;

/**
 * @author Tu
 */
public class ReportUtil {

	public static List<JournalArticleUserReportDTO> getReportInfo(
		List<Long> userIds, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		List<JournalArticleUserReportDTO> result =
			new ArrayList<JournalArticleUserReportDTO>();
		JournalArticleUserReportDTO articleUserReportDTO = null;
		String articlesStr = "";
		String articleIdApproveds = "";
		String articleIdNotApproveds = "";
		for (long userId : userIds) {
			articleUserReportDTO = new JournalArticleUserReportDTO();
			articleUserReportDTO.setUserName(PortalUtil.getUserName(userId, ""));
			articleUserReportDTO.setUserId(userId);
			int countArticle =
				NSSTagsAssetLocalServiceUtil.countArticle(
					userId, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			int countArticleApproved =
				NSSTagsAssetLocalServiceUtil.countArticleApproved(
					userId, true, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			articleUserReportDTO.setCountArticle(countArticle);
			articleUserReportDTO.setCountArticleApproved(countArticleApproved);
			articleUserReportDTO.setCountArticleNotApproved(countArticle -
				countArticleApproved);
			articleUserReportDTO.setCountArticleImage(NSSTagsAssetLocalServiceUtil.countArticleImage(
				userId, createdateF, createdateT, approveddateF, approveddateT,
				displaydateF, displaydateT, expirationdateF, expirationdateT));
			List<JournalArticle> articles =
				NSSTagsAssetLocalServiceUtil.getArticle(
					userId, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			for (int i = 0; i < articles.size(); i++) {
				articlesStr += articles.get(i).getPrimaryKey() + ",";
				if (articles.get(i).getApproved()) {
					articleIdApproveds += articles.get(i).getPrimaryKey() + ",";
				}
				else {
					articleIdNotApproveds +=
						articles.get(i).getPrimaryKey() + ",";
				}
			}
			articleUserReportDTO.setArticleIds(articlesStr);
			articleUserReportDTO.setArticleIdApproveds(articleIdApproveds);
			articleUserReportDTO.setArticleIdNotApproveds(articleIdNotApproveds);
			articlesStr = "";
			articleIdApproveds = "";
			articleIdNotApproveds = "";
			result.add(articleUserReportDTO);
		}
		return result;
	}

	public static List<JournalArticleCategoryReoportDTO> getReportInfoByVocabulary(
		List<Long> vocaburaryId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws PortalException, SystemException {

		List<JournalArticleCategoryReoportDTO> result =
			new ArrayList<JournalArticleCategoryReoportDTO>();
		JournalArticleCategoryReoportDTO articleCategoryReoportDTO = null;
		String articlesStr = "";
		String articleIdApproveds = "";
		String articleIdNotApproveds = "";
		for (long voId : vocaburaryId) {
			articleCategoryReoportDTO = new JournalArticleCategoryReoportDTO();
			articleCategoryReoportDTO.setIdVo(voId);
			articleCategoryReoportDTO.setName(TagsVocabularyLocalServiceUtil.getVocabulary(
				voId).getName());
			int countArticle =
				NSSTagsAssetLocalServiceUtil.countArticleByVocabulary(
					voId, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			int countArticleApproved =
				NSSTagsAssetLocalServiceUtil.countArticleApprovedByVocabulary(
					voId, true, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			articleCategoryReoportDTO.setCountArticle(countArticle);
			articleCategoryReoportDTO.setCountArticleApproved(countArticleApproved);
			articleCategoryReoportDTO.setCountArticleNotApproved(countArticle -
				countArticleApproved);
			articleCategoryReoportDTO.setCountArticleImage(NSSTagsAssetLocalServiceUtil.countImageByVocabulary(
				voId, createdateF, createdateT, approveddateF, approveddateT,
				displaydateF, displaydateT, expirationdateF, expirationdateT));
			List<JournalArticle> articles =
				NSSTagsAssetLocalServiceUtil.getAllArticleByVocabulary(
					voId, createdateF, createdateT, approveddateF,
					approveddateT, displaydateF, displaydateT, expirationdateF,
					expirationdateT);
			for (int i = 0; i < articles.size(); i++) {
				articlesStr += articles.get(i).getPrimaryKey() + ",";
				if (articles.get(i).getApproved()) {
					articleIdApproveds += articles.get(i).getPrimaryKey() + ",";
				}
				else {
					articleIdNotApproveds +=
						articles.get(i).getPrimaryKey() + ",";
				}
			}
			articleCategoryReoportDTO.setArticleIds(articlesStr);
			articleCategoryReoportDTO.setArticleIdApproveds(articleIdApproveds);
			articleCategoryReoportDTO.setArticleIdNotApproveds(articleIdNotApproveds);
			articlesStr = "";
			articleIdApproveds = "";
			articleIdNotApproveds = "";
			result.add(articleCategoryReoportDTO);
		}
		return result;

	}
}
