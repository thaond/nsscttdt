package com.sgs.portlet.document.receipt.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletURL;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.DocumentSummary;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptDisplayTerms;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

/**
 * 
 * @author canhminh
 * 
 */
public class ReceiptIndexer implements com.liferay.portal.kernel.search.Indexer {

	public static final String PORTLET_ID = "SGS_PCCCDOCUMENTRECEIPTPROCESS";

	public static Document getDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt documentReceipt) throws SystemException, UnsupportedEncodingException {
		String[] soHSCV = null;
		List<PmlChiTietHSCV> chiTietHSCVs = PmlChiTietHSCVLocalServiceUtil
				.findByIdCongVanDen(documentReceipt.getDocumentReceiptId());
		if (chiTietHSCVs != null) {
			soHSCV = new String[chiTietHSCVs.size()];
			for (int i = 0; i < chiTietHSCVs.size(); i++) {
				soHSCV[i] = String.valueOf(chiTietHSCVs.get(i).getIdHoSoCongViec());
			}
		}
		/* xuancong close start Goi ham co them tham so generalorderno
		return getDocumentReceipt(companyId, documentReceipt
				.getDocumentReceiptId(),
				documentReceipt.getDocumentReference(), documentReceipt
						.getDocumentTypeId(), documentReceipt.getSigner(),
				documentReceipt.getNumberDocumentReceipt(), documentReceipt
						.getIssuingPlaceId(), documentReceipt.getDateArrive(),
				soHSCV, documentReceipt.getStatusId(), documentReceipt
						.getBriefContent(), documentReceipt.getActive());
		xuancong close end */
		String noiPhatHanh = documentReceipt.getIssuingPlaceOtherName();
		try {
			if (documentReceipt.getIssuingPlaceId().trim().length() > 0) {
				PmlEdmIssuingPlace placeItem = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(
						documentReceipt.getIssuingPlaceId());
				if (placeItem != null) {
					noiPhatHanh = placeItem.getIssuingPlaceName();
				} // end if
			} // end if
		} catch (Exception ex) {
			// Do nothing
		} // end catch
		
		return getDocumentReceipt(companyId, documentReceipt.getDocumentReceiptId(),
				documentReceipt.getDocumentReference(), documentReceipt.getDocumentTypeId(), 
				documentReceipt.getSigner(), documentReceipt.getNumberDocumentReceipt(), 
				noiPhatHanh, documentReceipt.getDateArrive(), soHSCV,  
				documentReceipt.getStatusId(), documentReceipt.getBriefContent(), 
				documentReceipt.getActive(), documentReceipt.getGeneralOrderNo());
	}

	public static Document getDocumentReceipt(long companyId,
			long documentReceiptId, String documentReference,
			long documentType, String signer, String numberDocumentReceipt,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active) throws UnsupportedEncodingException {
		
		documentReference = (documentReference.toLowerCase());
		signer = signer.toLowerCase();
		numberDocumentReceipt = numberDocumentReceipt.toLowerCase();
		briefContent = briefContent.toLowerCase();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, documentReceiptId);

		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);

		doc.addKeyword(Field.ENTRY_CLASS_PK, documentReceiptId);

		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, documentReference);
		
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.LOAI_CV, documentType);
		
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, signer);
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY_ORDER, signer);
		
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, numberDocumentReceipt);
		
		//xuancong close doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
		
		doc.addKeyword("ngayDen", issuingDate != null ? dateFormat.format(issuingDate) : "");
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV, soHSCV);
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI, status);
		doc.addKeyword("active", active);
		
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, briefContent);

		return doc;
	}

	public static Document getDocumentReceipt(long companyId,
			long documentReceiptId, String documentReference,
			long documentType, String signer, String numberDocumentReceipt,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active, 
			long generalOrderNo) throws UnsupportedEncodingException {
		
		documentReference = (documentReference.toLowerCase());
		signer = signer.toLowerCase();
		numberDocumentReceipt = numberDocumentReceipt.toLowerCase();
		briefContent = briefContent.toLowerCase();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, documentReceiptId);

		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);

		doc.addKeyword(Field.ENTRY_CLASS_PK, documentReceiptId);

		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, documentReference);
		
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.LOAI_CV, documentType);
		
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, signer);
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY_ORDER, signer);
		
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, numberDocumentReceipt);
		
		//xuancong close doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
		
		doc.addKeyword("ngayDen", issuingDate != null ? dateFormat.format(issuingDate) : "");
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV, soHSCV);
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI, status);
		doc.addKeyword("active", active);
		
		doc.addText(PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, briefContent);
		// xuancong add Them truong generalorderno de sap xep
		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.GENERALORDERNO, generalOrderNo);

		return doc;
	}
	
	public static void addDocumentReceipt(long companyId,
			long documentReceiptId, String numberDocumentReceipt,
			long documentType, String signer, String numberDocumentReceipt2,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active)
			throws SearchException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceiptId,
				numberDocumentReceipt, documentType, signer,
				numberDocumentReceipt2, issuingPlaceId, issuingDate, soHSCV,
				status, briefContent, active);

		SearchEngineUtil.addDocument(companyId, doc);
	}

	public static void addDocumentReceipt(long companyId,
			long documentReceiptId, String numberDocumentReceipt,
			long documentType, String signer, String numberDocumentReceipt2,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active, long generalorderno)
			throws SearchException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceiptId,
				numberDocumentReceipt, documentType, signer,
				numberDocumentReceipt2, issuingPlaceId, issuingDate, soHSCV,
				status, briefContent, active, generalorderno);

		SearchEngineUtil.addDocument(companyId, doc);
	}

	public static void addDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt documentReceipt) throws SearchException,
			SystemException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceipt);

		SearchEngineUtil.addDocument(companyId, doc);
	}

	public static void updateDocumentReceipt(long companyId,
			long documentReceiptId, String numberDocumentReceipt,
			long documentType, String signer, String numberDocumentReceipt2,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active)
			throws SearchException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceiptId,
				numberDocumentReceipt, documentType, signer,
				numberDocumentReceipt2, issuingPlaceId, issuingDate, soHSCV,
				status, briefContent, active);

		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}

	public static void updateDocumentReceipt(long companyId,
			long documentReceiptId, String numberDocumentReceipt,
			long documentType, String signer, String numberDocumentReceipt2,
			String issuingPlaceId, Date issuingDate, String[] soHSCV,
			long status, String briefContent, String active, long generalorderno)
			throws SearchException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceiptId,
				numberDocumentReceipt, documentType, signer,
				numberDocumentReceipt2, issuingPlaceId, issuingDate, soHSCV,
				status, briefContent, active, generalorderno);

		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}

	public static void updateDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt documentReceipt) throws SearchException,
			SystemException, UnsupportedEncodingException {
		Document doc = getDocumentReceipt(companyId, documentReceipt);

		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}

	public static String getDocumentReceiptUID(long documentReceiptId) {
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, documentReceiptId);

		return doc.get(Field.UID);
	}

	public static void deleteDocumentReceipt(long companyId,
			long documentReceiptId) throws SearchException {
		SearchEngineUtil.deleteDocument(companyId,
				getDocumentReceiptUID(documentReceiptId));
	}

	//xuancong close @Override
	public DocumentSummary getDocumentSummary(Document doc, PortletURL url) {
		return new DocumentSummary(doc
				.get(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO), doc
				.get(PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU), url);
	}

	//xuancong close @Override
	public void reIndex(String[] ids) throws SearchException {
		try {
			PmlEdmDocumentReceiptLocalServiceUtil.reIndex(ids);
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

	public static void deletePortletDocuments(long companyId) throws SearchException {
		SearchEngineUtil.deletePortletDocuments(companyId, PORTLET_ID);
	}

}
