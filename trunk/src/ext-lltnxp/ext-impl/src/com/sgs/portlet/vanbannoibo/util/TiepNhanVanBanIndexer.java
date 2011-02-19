package com.sgs.portlet.vanbannoibo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.DocumentSummary;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchException;
import com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptDisplayTerms;
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;

public class TiepNhanVanBanIndexer implements Indexer{
	
	public static final String PORTLET_ID = "SGS_VANBANNOIBO";
	
	
	
	public DocumentSummary getDocumentSummary(Document arg0, PortletURL arg1) {
		return null;
	}

	public void reIndex(String[] arg0) throws SearchException {
		
		
	}

	public static void updateDocumentReceipt(long companyId, VanBanNoiBo vanBanNoiBo) {
		
	}

	public static Document getVanBanNoiBo(long companyId, VanBanNoiBo vanBanNoiBo) {
		return getDocumentReceipt(companyId, vanBanNoiBo.getVanBanNoiBoId(),
				vanBanNoiBo.getLoaiVanBanNoiBo(), vanBanNoiBo.getNgayTao(), vanBanNoiBo.getNgayKy(),
				vanBanNoiBo.getTrichYeu(), vanBanNoiBo.getNguoiKy(), vanBanNoiBo.getGhiChu(),
				vanBanNoiBo.getSoVaoSoVanBanNoiBo(), vanBanNoiBo.getSoPhatSinhTheoNam());
	}

	private static Document getDocumentReceipt(long companyId,
			long vanBanNoiBoId, long loaiVanBanNoiBo, Date ngayTao,
			Date ngayKy, String trichYeu, long nguoiKy, String ghiChu,
			String soVanBanNoiBo, int soPhatSinhTheoNam) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, vanBanNoiBoId);

		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);

		doc.addKeyword(Field.ENTRY_CLASS_PK, vanBanNoiBoId);

//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, documentReference);
//		
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.LOAI_CV, documentType);
//		
//		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, signer);
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY_ORDER, signer);
//		
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, numberDocumentReceipt);
//		
//		//xuancong close doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
//		doc.addText(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, issuingPlaceId);
//		
//		doc.addKeyword("ngayDen", issuingDate != null ? dateFormat.format(issuingDate) : "");
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV, soHSCV);
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI, status);
//		doc.addKeyword("active", active);
//		
//		doc.addText(PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, briefContent);
//		// xuancong add Them truong generalorderno de sap xep
//		doc.addKeyword(PmlEdmDocumentReceiptDisplayTerms.GENERALORDERNO, generalOrderNo);

		return doc;
	}

	public static void deleteVanBanNoiBo(long companyId, long vanBanNoiBoId) {
		// TODO Auto-generated method stub
		
	}
}
