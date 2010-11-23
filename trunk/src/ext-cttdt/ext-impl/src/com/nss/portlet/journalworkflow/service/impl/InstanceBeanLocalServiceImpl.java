package com.nss.portlet.journalworkflow.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.nss.portlet.journalworkflow.service.base.InstanceBeanLocalServiceBaseImpl;
import com.nss.portlet.journalworkflow.model.InstanceBean;


public class InstanceBeanLocalServiceImpl
    extends InstanceBeanLocalServiceBaseImpl {
	
	public long getInstanceId(JournalArticle article) {
		try {
			List<InstanceBean> instanceBeans = instanceBeanPersistence.findByArticleId(article.getId(), false);
			if (instanceBeans.size() > 0) {
				return instanceBeans.get(0).getProcessInstanceId();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<InstanceBean> findByStatus_Finish(String status, boolean finish) {
		List<InstanceBean> instanceBeans = new ArrayList<InstanceBean>();
		try {
			instanceBeans = instanceBeanPersistence.findByStatus_Finish(status, finish);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return instanceBeans;
	}
	
	
	
}
