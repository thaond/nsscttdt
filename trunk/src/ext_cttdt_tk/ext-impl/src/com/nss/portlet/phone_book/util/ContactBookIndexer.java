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
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.search.ContactBookDisplayTerms;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil;

public class ContactBookIndexer implements Indexer{
	
	public static final String PORTLET_ID = "NSS_PHONE_BOOK";
	
	public static void updateContactBook(long companyId, ContactBook contactBook) throws SearchException, UnsupportedEncodingException {
		Document doc = getContactBook(companyId, contactBook);
		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}
	public static Document getContactBook(long companyId,
			ContactBook contactBook) throws UnsupportedEncodingException {
		long contactBookId = contactBook.getContactBookId();
		String contactBookCode = contactBook.getContactBookCode().toLowerCase();
		String contactBookName= contactBook.getContactBookName().toLowerCase();
		String contactDescription= contactBook.getContactDescription().toLowerCase();
		
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, contactBookId);
		
		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.ENTRY_CLASS_PK, contactBookId);
		doc.addKeyword(ContactBookDisplayTerms.CODE, contactBookCode);
		doc.addKeyword(ContactBookDisplayTerms.NAME, contactBookName);
		doc.addKeyword(ContactBookDisplayTerms.DESCRIPTION, contactDescription);
		
		return doc;
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
			VanBanPhapQuyLocalServiceUtil.reIndex(ids);
		} catch (Exception e) {
			throw new SearchException(e);
		}
		
	}

	@Override
	public void reIndex(String className, long classPK) throws SearchException {
		
	}
	private static final String[] _CLASS_NAMES = new String[] {
		ContactBook.class.getName()
	};
}
