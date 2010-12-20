package com.nss.portlet.journalworkflow.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portlet.tags.model.TagsEntry;
import com.liferay.portlet.tags.service.persistence.TagsEntryUtil;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.service.base.JournalProcessDefinitionLocalServiceBaseImpl;


public class JournalProcessDefinitionLocalServiceImpl
    extends JournalProcessDefinitionLocalServiceBaseImpl {
	
	public JournalProcessDefinition addJPD(JournalProcessDefinition jPD) {
		try {
			return journalProcessDefinitionPersistence.updateImpl(jPD, false);
		} catch (SystemException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TagsEntry> getListTagsEntry (long vocabularyId) {
		List<TagsEntry> res = new ArrayList<TagsEntry>();
		try {
			res = TagsEntryUtil.findByVocabularyId(vocabularyId);
			return res;
		} catch (Exception e) {
			return res;
		}
	}
}
