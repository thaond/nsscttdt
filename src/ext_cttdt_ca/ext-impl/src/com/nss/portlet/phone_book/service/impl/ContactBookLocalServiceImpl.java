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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.journal.util.Indexer;
import com.nss.portlet.phone_book.NoSuchContactBookException;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.search.ContactBookDisplayTerms;
import com.nss.portlet.phone_book.service.base.ContactBookLocalServiceBaseImpl;
import com.nss.portlet.phone_book.util.ContactBookIndexer;

public class ContactBookLocalServiceImpl extends ContactBookLocalServiceBaseImpl {
	
	public int countByKeyword(String keywords) throws SystemException{
		return contactBookFinder.countByKeywords(keywords);
	}
	
	public List<ContactBook> findByKeyword(String keywords, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return contactBookFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public int countContactBook(String contactBookCodes, String contactBookNames, String contactBookDescriptions, boolean andOperator) throws SystemException{
		return contactBookFinder.count_Contact_Book(contactBookCodes, contactBookNames, contactBookDescriptions, andOperator);
	}
	
	public List<ContactBook> findContactBook(String contactBookCodes, String contactBookNames, String contactBookDescriptions, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return contactBookFinder.find_contact_book(contactBookCodes, contactBookNames, contactBookDescriptions, start, end, andOperator, obc);
	}
	
	public List<DetailBook> getDetailBooks(long contactBookId) throws SystemException{
		return contactBookPersistence.getDetailBooks(contactBookId);
	}

	public void reIndex(String[] ids) throws SystemException {
		if (SearchEngineUtil.isIndexReadOnly()) {
			return;
		}
		long companyId = GetterUtil.getLong(ids[0]);
		try {
			reIndexContactBook(companyId);
		} catch (SystemException se) {
			throw se;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected void reIndexContactBook(long companyId) throws SystemException {
		int count = contactBookPersistence.countByCompanyid(companyId);
		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;
			reIndexContactBook(companyId, start, end);
		}
	}

	protected void reIndexContactBook(long companyId, int start, int end)
			throws SystemException {

		List<ContactBook> contactBooks = contactBookPersistence.findByCompanyid(companyId, start, end);
		for (ContactBook contactBook : contactBooks) {
			try {
				ContactBookIndexer.updateContactBook(companyId, contactBook);
			} catch (SearchException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void reIndex(long companyId, ContactBook contactBook) throws SearchException {
		try {
			ContactBookIndexer.updateContactBook(companyId, contactBook);
		} catch (UnsupportedEncodingException e) {
			throw new SearchException(e);
		}
	}

	public Hits search(long companyId, String contactBookCode,
			String contactBookName, String contactDescription,
			String sortField, int sortType, boolean reverse, int start, int end)
			throws SystemException {
		try {
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID, ContactBookIndexer.PORTLET_ID);

			BooleanQuery contactBookCodeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery contactBookNameQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery contactDescriptionQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(contactBookCode)) {
				contactBookCodeQuery.addTerm(ContactBookDisplayTerms.CODE,contactBookCode);
				booleanQueries.add(contactBookCodeQuery);
			}

			if (Validator.isNotNull(contactBookName)) {
				contactBookNameQuery.addTerm(ContactBookDisplayTerms.NAME,contactBookName);
				booleanQueries.add(contactBookNameQuery);
			}

			if (Validator.isNotNull(contactDescription)) {
				contactDescriptionQuery.addTerm(ContactBookDisplayTerms.DESCRIPTION,
								contactDescription);
				booleanQueries.add(contactDescriptionQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			
			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			sort = new Sort(sortField, sortType, reverse);
			Hits hits = SearchEngineUtil.search(companyId, fullQuery, sort, start,end);
			return hits;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public Hits search(long companyId, String keywords, String sortField,
			int sortType, boolean reverse, int start, int end)
			throws SystemException {
		try {
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);

			if (Validator.isNotNull(ContactBookIndexer.PORTLET_ID)) {
				contextQuery.addRequiredTerm(Field.PORTLET_ID,ContactBookIndexer.PORTLET_ID);
			}
			
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create();

			if (Validator.isNotNull(keywords)) {
				searchQuery.addTerm(Field.TITLE, keywords);
				searchQuery.addTerm("contactBookCode", keywords + "*");
				searchQuery.addTerm("contactBookName", keywords + "*");
				searchQuery.addTerm("contactDescription", keywords + "*");
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			if (searchQuery.clauses().size() > 0) {
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			}

			Sort sort;
			sort = new Sort(sortField, sortType, reverse);
			Hits hits = SearchEngineUtil.search(companyId, fullQuery, sort, start,end);
			return hits;
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	public ContactBook addContactBook(long companyId, ContactBook contactBook) throws SystemException, SearchException {
		contactBook.setNew(true);
		contactBookPersistence.update(contactBook, false);
		reIndex(companyId, contactBook);
		return contactBook;
	}
	
	@Override
	public ContactBook addContactBook(ContactBook contactBook) throws SystemException {
		throw new SystemException(
		"Please use method: addContactBook(long companyId, ContactBook contactBook)");
	}
	
	public ContactBook updateContactBook(long companyId, ContactBook contactBook) throws SystemException, SearchException {
		contactBookPersistence.update(contactBook, false);
		reIndex(companyId, contactBook);
		return contactBook;
	}
	
	@Override
	public ContactBook updateContactBook(ContactBook contactBook) throws SystemException {
		throw new SystemException(
		"Please use method: updateContactBook(long companyId, ContactBook contactBook)");
	}
	public void deleteContactBook(long companyId, long contactBookId) throws SystemException, SearchException, NoSuchContactBookException {
		ContactBook contactBook = contactBookPersistence.findByPrimaryKey(contactBookId);
		deleteContactBook(companyId, contactBook);
		
	}
	
	public void deleteContactBook(long companyId, ContactBook contactBook) throws SystemException, SearchException {
		contactBookPersistence.remove(contactBook);
		try {
			ContactBookIndexer.deleteContactBook(companyId, contactBook);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteContactBook(long contactBookId) throws SystemException {
		throw new SystemException(
		"Please use method: deleteContactBook(long companyId, long contactBookId)");
	}
	
	@Override
	public void deleteContactBook(ContactBook contactBook) throws SystemException {
		throw new SystemException(
		"Please use method: deleteContactBook(long companyId, ContactBook contactBook)");
	}
}
