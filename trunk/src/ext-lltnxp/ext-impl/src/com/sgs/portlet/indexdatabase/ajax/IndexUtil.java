package com.sgs.portlet.indexdatabase.ajax;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Time;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.util.ReceiptIndexer;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.util.SendIndexer;


public class IndexUtil {	

	public boolean reIndexDocumentReceipts(long companyId){
		try {
			ReceiptIndexer.deletePortletDocuments(companyId);
			List<PmlEdmDocumentReceipt> documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			PmlEdmDocumentReceipt documentReceipt;
			
			for (int i = 0; i < documentReceipts.size(); i++) {
				documentReceipt = documentReceipts.get(i);
				ReceiptIndexer.addDocumentReceipt(companyId, documentReceipt);
			}
			
			if ("file".equals(PropsUtil.get("lucene.store.type"))) {
				StringBuilder builder = new StringBuilder();
				builder.append(PropsUtil.get("lucene.dir"));
				builder.append(companyId);
				builder.append("/");
				builder.append("write.lock");
				File file = new File(builder.toString());
				boolean flagNoExistBefore = file.exists();
				boolean flagNoExistAfter = false;
					
				if (!flagNoExistBefore) {
					for (;;){
						flagNoExistBefore = file.exists();
						if (flagNoExistBefore) {						
							break;
						}
					}
				}
					
				flagNoExistAfter = flagNoExistBefore;
				while (flagNoExistAfter) {
					flagNoExistAfter = file.exists();
					if (!flagNoExistAfter) {
						try {
							Thread.sleep(Time.SECOND * 10);
							
							flagNoExistAfter = file.exists();
							if (!flagNoExistAfter) {								
								break;
							}
						}
						catch (InterruptedException ie) {
						}
						
					}
				}
			}
			
			return true;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean reIndexDocumentSends(long companyId) {
		try {
			SendIndexer.deletePortletDocuments(companyId);
			List<PmlEdmDocumentSend> documentSends = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSends(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			PmlEdmDocumentSend documentSend;
			for (int i = 0; i < documentSends.size(); i++) {
				documentSend = documentSends.get(i);
				if (documentSend.getIssuingDate() == null) continue;
				SendIndexer.addDocumentSend(companyId, documentSend);
			}
			
			if ("file".equals(PropsUtil.get("lucene.store.type"))) {
				StringBuilder builder = new StringBuilder();
				builder.append(PropsUtil.get("lucene.dir"));
				builder.append(companyId);
				builder.append("/");
				builder.append("write.lock");
				File file = new File(builder.toString());
				boolean flagNoExistBefore = file.exists();
				boolean flagNoExistAfter = false;
					
				if (!flagNoExistBefore) {
					for (;;){
						flagNoExistBefore = file.exists();
						if (flagNoExistBefore) {		
							break;
						}
					}
				}
					
				flagNoExistAfter = flagNoExistBefore;
				while (flagNoExistAfter) {
					flagNoExistAfter = file.exists();
					if (!flagNoExistAfter) {
						try {
							Thread.sleep(Time.SECOND * 10);
							
							flagNoExistAfter = file.exists();
							if (!flagNoExistAfter) {
								break;
							}
						}
						catch (InterruptedException ie) {
						}
					}
				}
			}
			return true;
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {				
			e.printStackTrace();
		}
		return false;
	}

	
	
}
