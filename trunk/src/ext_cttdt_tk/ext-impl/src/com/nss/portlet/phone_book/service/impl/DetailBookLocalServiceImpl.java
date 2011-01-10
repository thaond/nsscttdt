package com.nss.portlet.phone_book.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.journal.util.Indexer;
import com.nss.portlet.phone_book.NoSuchDetailBookException;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.search.DetailBookDisplayTerms;
import com.nss.portlet.phone_book.service.base.DetailBookLocalServiceBaseImpl;
import com.nss.portlet.phone_book.util.DetailBookIndexer;


public class DetailBookLocalServiceImpl extends DetailBookLocalServiceBaseImpl {

	public void reIndex(String[] ids) throws SystemException {
		if (SearchEngineUtil.isIndexReadOnly()) {
			return;
		}

		long companyId = GetterUtil.getLong(ids[0]);

		try {
			reIndexDetailBook(companyId);
		} catch (SystemException se) {
			throw se;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected void reIndexDetailBook(long companyId) throws SystemException {
		int count = detailBookPersistence.countByCompanyid(companyId);
		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reIndexDetailBook(companyId, start, end);
		}
	}

	protected void reIndexDetailBook(long companyId, int start, int end)
			throws SystemException {

		List<DetailBook> detailBooks = detailBookPersistence
				.findByCompanyid(companyId, start, end);
		for (DetailBook detailBook : detailBooks) {
			try {
				DetailBookIndexer.updateDetailBook(companyId, detailBook);
			} catch (SearchException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void reIndex(long companyId, DetailBook detailBook) throws SearchException {
		try {
			DetailBookIndexer.updateDetailBook(companyId, detailBook);
		} catch (UnsupportedEncodingException e) {
			throw new SearchException(e);
		}
	}

	public Hits search(long companyId, long contactBookId, String detailBookCode,
			String detailBookName, String detailDescription, String zip, String internal, String home, String mobile,
			String sortField, int sortType, boolean reverse, int start, int end)
			throws SystemException {
		try {
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.PORTLET_ID,DetailBookIndexer.PORTLET_ID);

			BooleanQuery detailBookCodeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery detailBookNameQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery detailDescriptionQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery zipQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery internalQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery homeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery mobileQuery = BooleanQueryFactoryUtil.create();
			
			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(detailBookCode)) {
				detailBookCodeQuery.addTerm(DetailBookDisplayTerms.CODE,
						detailBookCode);
				booleanQueries.add(detailBookCodeQuery);
			}

			if (Validator.isNotNull(detailBookName)) {
				detailBookNameQuery.addTerm(DetailBookDisplayTerms.NAME,
						detailBookName);
				booleanQueries.add(detailBookNameQuery);
			}

			if (Validator.isNotNull(detailDescription)) {
				detailDescriptionQuery
						.addTerm(DetailBookDisplayTerms.DESCRIPTION,
								detailDescription);
				booleanQueries.add(detailDescriptionQuery);
			}
			
			if (Validator.isNotNull(zip)) {
				zipQuery.addTerm(DetailBookDisplayTerms.ZIP,zip);
				booleanQueries.add(zipQuery);
			}
			
			if (Validator.isNotNull(internal)) {
				internalQuery.addTerm(DetailBookDisplayTerms.INTERNAL,internal);
				booleanQueries.add(internalQuery);
			}
			
			if (Validator.isNotNull(home)) {
				homeQuery.addTerm(DetailBookDisplayTerms.HOME,home);
				booleanQueries.add(homeQuery);
			}
			
			if (Validator.isNotNull(mobile)) {
				mobileQuery.addTerm(DetailBookDisplayTerms.MOBILE,mobile);
				booleanQueries.add(mobileQuery);
			}
			
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			sort = new Sort(sortField, sortType, reverse);
			Hits hits = SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
			return hits;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public Hits search(long companyId, long contactBookId, String keywords, String sortField,
			int sortType, boolean reverse, int start, int end)
			throws SystemException {
		try {

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);

			if (Validator.isNotNull(DetailBookIndexer.PORTLET_ID)) {
				contextQuery.addRequiredTerm(Field.PORTLET_ID,DetailBookIndexer.PORTLET_ID);
			}
			
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create();

			if (Validator.isNotNull(keywords)) {
				searchQuery.addTerm("detailBookCode", keywords + "*");
				searchQuery.addTerm("detailBookName", keywords + "*");
				searchQuery.addTerm("detailDescription", keywords + "*");
				searchQuery.addTerm("zip", keywords + "*");
				searchQuery.addTerm("internal", keywords + "*");
				searchQuery.addTerm("home", keywords + "*");
				searchQuery.addTerm("mobile", keywords + "*");
			}
			
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			if (searchQuery.clauses().size() > 0) {
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			}

			Sort sort;
			sort = new Sort(sortField, sortType, reverse);
			Hits hits = SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
			return hits;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	public DetailBook addDetailBook(long companyId, DetailBook detailBook) throws SystemException, SearchException {
		detailBook.setNew(true);
		detailBookPersistence.update(detailBook, false);
		reIndex(companyId, detailBook);
		return detailBook;
	}
	
	@Override
	public DetailBook addDetailBook(DetailBook detailBook) throws SystemException {
		throw new SystemException(
		"Please use method: addDetailBook(long companyId, DetailBook detailBook)");
	}
	
	public DetailBook updateDetailBook(long companyId, DetailBook detailBook) throws SystemException, SearchException {
		detailBookPersistence.update(detailBook, false);
		reIndex(companyId, detailBook);
		return detailBook;
	}
	
	@Override
	public DetailBook updateDetailBook(DetailBook detailBook) throws SystemException {
		throw new SystemException(
		"Please use method: updateDetailBook(long companyId, DetailBook detailBook)");
	}
	public void deleteDetailBook(long companyId, long detailBookId) throws SystemException, SearchException, NoSuchDetailBookException {
		DetailBook detailBook = detailBookPersistence.findByPrimaryKey(detailBookId);
		deleteDetailBook(companyId, detailBook);
	}
	
	public void deleteDetailBook(long companyId, DetailBook detailBook) throws SystemException, SearchException {
		detailBookPersistence.remove(detailBook);
		try {
			DetailBookIndexer.deleteDetailBook(companyId, detailBook);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDetailBook(long detailBookId) throws SystemException {
		throw new SystemException(
		"Please use method: deleteDetailBook(long companyId, long detailBookId)");
	}
	
	@Override
	public void deleteDetailBook(DetailBook detailBook) throws SystemException {
		throw new SystemException(
		"Please use method: deleteDetailBook(long companyId, detailBook detailBook)");
	}
}