package com.nss.portlet.phone_book.util;

import java.io.UnsupportedEncodingException;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.DocumentSummary;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.search.DetailBookDisplayTerms;
import com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil;

public class DetailBookIndexer implements Indexer{
	
	public static final String PORTLET_ID = "NSS_PHONE_BOOK";
	
	
	public static Document getDetailBook(long companyId, DetailBook detailBook) throws UnsupportedEncodingException {
		long detailBookId = detailBook.getDetailBookId();
		String detailBookCode = detailBook.getDetailBookCode().toLowerCase();
		String detailBookName = detailBook.getDetailBookName().toLowerCase();
		String detailDescription = detailBook.getDetailDescription().toLowerCase();
		String detailZip = detailBook.getZip();
		String detailInternal = detailBook.getInternal();
		String detailHome = detailBook.getHome();
		String detailMobile = detailBook.getMobile();
		String detailEmail = detailBook.getEmail();
		
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, detailBookId);
		
		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.ENTRY_CLASS_PK, detailBookId);
		doc.addKeyword(DetailBookDisplayTerms.CODE, detailBookCode);
		doc.addKeyword(DetailBookDisplayTerms.NAME, detailBookName);
		doc.addKeyword(DetailBookDisplayTerms.DESCRIPTION, detailDescription);
		doc.addKeyword(DetailBookDisplayTerms.ZIP, detailZip);
		doc.addKeyword(DetailBookDisplayTerms.INTERNAL, detailInternal);
		doc.addKeyword(DetailBookDisplayTerms.HOME, detailHome);
		doc.addKeyword(DetailBookDisplayTerms.MOBILE, detailMobile);
		doc.addKeyword(DetailBookDisplayTerms.EMAIL, detailEmail);
		
		return doc;
	}
	
	//nss-phone-book-index
	public static Document getDetailBookIndex(long companyId, DetailBook detailBook) throws UnsupportedEncodingException {
		long detailBookId = detailBook.getDetailBookId();
		String detailBookName = detailBook.getDetailBookName().toLowerCase();
		
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, detailBookId);
		
		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.ENTRY_CLASS_PK, detailBookId);
		doc.addKeyword(DetailBookDisplayTerms.NAME, detailBookName);
		
		return doc;
	}
	
	public static void updateDetailBook(long companyId, DetailBook detailBook) throws SearchException, UnsupportedEncodingException {
		Document doc = getDetailBook(companyId, detailBook);
		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}
	
	//nss-phone-book-index
	public static void updateDetailBookIndex(long companyId, DetailBook detailBook) throws SearchException, UnsupportedEncodingException {
		Document doc = getDetailBookIndex(companyId, detailBook);
		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}
	
	public static void deleteDetailBook(long companyId, DetailBook detailBook) throws SearchException, UnsupportedEncodingException {
		Document doc = getDetailBook(companyId, detailBook);
		SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));
	}
	
	//nss-phone-book-index
	public static void deleteDetailBookIndex(long companyId, DetailBook detailBook) throws SearchException, UnsupportedEncodingException {
		Document doc = getDetailBookIndex(companyId, detailBook);
		SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));
	}
	
	@Override
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	public DocumentSummary getDocumentSummary(Document arg0, PortletURL arg1) {
		return null;
	}

	@Override
	public void reIndex(String[] ids) throws SearchException {
		try {
			DetailBookLocalServiceUtil.reIndex(ids);
		} catch (Exception e) {
			throw new SearchException(e);
		}
		
	}

	@Override
	public void reIndex(String className, long classPK) throws SearchException {
		
	}
	private static final String[] _CLASS_NAMES = new String[] {
		DetailBook.class.getName()
	};
}
