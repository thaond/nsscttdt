package com.nss.portlet.phone_book.util;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;
import org.apache.lucene.index.IndexWriter;

import com.liferay.portal.dao.shard.ShardUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.search.lucene.LuceneUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.comparator.PortletLuceneComparator;

public class ContactBookIndexUtil implements Runnable{
	public ContactBookIndexUtil (long companyId) {
		_companyId = companyId;
	}
	
	public void halt() {
	}

	public boolean isFinished() {
		return _finished;
	}

	public void run() {
		reIndex(PropsValues.INDEX_ON_STARTUP_DELAY);
	}
	
	public void reIndex(int deplay) {
		ShardUtil.pushCompanyService(_companyId);

		try {
			doReIndex(deplay);
		}
		finally {
			ShardUtil.popCompanyService();
		}
	}
	
	protected void doReIndex(int delay) {
		if (SearchEngineUtil.isIndexReadOnly()) {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Reindexing Lucene started");
		}

		if (delay < 0) {
			delay = 0;
		}

		try {
			if (delay > 0) {
				Thread.sleep(Time.SECOND * delay);
			}
		}
		catch (InterruptedException ie) {
		}

		StopWatch stopWatch1 = null;

		if (_log.isInfoEnabled()) {
			stopWatch1 = new StopWatch();

			stopWatch1.start();
		}

		LuceneUtil.delete(_companyId);

		try {
			IndexWriter writer = LuceneUtil.getWriter(_companyId, true);

			LuceneUtil.write(writer);
		}
		catch (IOException ioe) {
			_log.error(ioe.getMessage(), ioe);
		}

		String[] indexIds = new String[] {String.valueOf(_companyId)};

		try {
			List<Portlet> portlets = PortletLocalServiceUtil.getPortlets(
				_companyId);

			portlets = ListUtil.sort(portlets, new PortletLuceneComparator());

			for (Portlet portlet : portlets) {
				if (!portlet.isActive()) {
					continue;
				}

				Indexer indexer = portlet.getIndexerInstance();

				if (indexer == null) {
					continue;
				}

				String indexerClass = portlet.getIndexerClass();

				StopWatch stopWatch2 = null;

				if (_log.isInfoEnabled()) {
					stopWatch2 = new StopWatch();

					stopWatch2.start();
				}

				if (_log.isInfoEnabled()) {
					_log.info("Reindexing with " + indexerClass + " started");
				}

				indexer.reIndex(indexIds);

				if (_log.isInfoEnabled()) {
					_log.info(
						"Reindexing with " + indexerClass + " completed in " +
							(stopWatch2.getTime() / Time.SECOND) + " seconds");
				}
			}

			if (_log.isInfoEnabled()) {
				_log.info(
					"Reindexing Lucene completed in " +
						(stopWatch1.getTime() / Time.SECOND) + " seconds");
			}
		}
		catch (Exception e) {
			_log.error("Error encountered while reindexing", e);

			if (_log.isInfoEnabled()) {
				_log.info("Reindexing Lucene failed");
			}
		}

		_finished = true;
	}
	
	private static Log _log = LogFactoryUtil.getLog(ContactBookIndexUtil.class);
	private long _companyId;
	private boolean _finished;
}
