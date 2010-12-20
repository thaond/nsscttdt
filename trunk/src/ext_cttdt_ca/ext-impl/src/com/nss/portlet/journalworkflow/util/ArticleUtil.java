package com.nss.portlet.journalworkflow.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.tags.model.TagsEntry;
import com.liferay.portlet.tags.service.TagsEntryLocalServiceUtil;
import com.nss.portlet.journalworkflow.model.InstanceBean;

public class ArticleUtil {
	public static List<TagsEntry> getCategoryOfArticle(long articleId) {
		JournalArticle journalArticle;
		List<TagsEntry> entries = new ArrayList<TagsEntry>();
		List<TagsEntry> result = new ArrayList<TagsEntry>();
		try {
			journalArticle = JournalArticleLocalServiceUtil.getArticle(articleId);
			entries = new ArrayList<TagsEntry>(TagsEntryLocalServiceUtil.getEntries(JournalArticle.class.getName(), journalArticle.getResourcePrimKey(), false));
			TagsEntry entry;
			for (int i = 0; i < entries.size(); i++) {
				entry = entries.get(i);
				if (entry.getParentName() == null || entry.getParentName().equals("")) {
					result.add(entry);
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<JournalArticle> getArticles(int start, int end, List<InstanceBean> instanceBeans) {
		
		List<InstanceBean> subInstanceBeans =  new ArrayList<InstanceBean>();
		if (instanceBeans.size() > end) {
			subInstanceBeans = instanceBeans.subList(start, end);
		} else {
			if (instanceBeans .size() > start) {
				subInstanceBeans = instanceBeans.subList(start, instanceBeans.size());
			}
		}
		List<JournalArticle> result = new ArrayList<JournalArticle>();
		for (InstanceBean instanceBean : subInstanceBeans) {
			try {
				result.add(JournalArticleLocalServiceUtil.getArticle(instanceBean.getArticleId()));
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
