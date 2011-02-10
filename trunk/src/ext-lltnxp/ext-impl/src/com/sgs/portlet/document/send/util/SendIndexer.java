
package com.sgs.portlet.document.send.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletURL;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.DocumentSummary;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendDisplayTerms;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

/**
 * @author canhminh
 */
public class SendIndexer implements Indexer {

	public static final String PORTLET_ID = "SGS_PCCCDOCUMENTSENDPROCESS";

	public static void addDocumentSend(
		long companyId, PmlEdmDocumentSend documentSend)
		throws SearchException, UnsupportedEncodingException {

		Document doc = getSendDocument(companyId, documentSend);

		SearchEngineUtil.addDocument(companyId, doc);
	}

	public static void addDocumetSend(
		long companyId, long documentSendId, String soPhatHanh,
		long documentTypeId, String[] traLoiCongVanSo, String phongSoanThao,
		String receivingPlace, String signer, Date issuingDate, String[] hscvs,
		String briefContent, String active, long numOfDocRef, long editorId,
		boolean numOfDirector)
		throws SearchException, UnsupportedEncodingException {

		Document doc =
			getSendDocument(
				companyId, documentSendId, soPhatHanh, documentTypeId,
				traLoiCongVanSo, phongSoanThao, receivingPlace, signer,
				issuingDate, hscvs, briefContent, active, numOfDocRef,
				editorId, numOfDirector);

		SearchEngineUtil.addDocument(companyId, doc);
	}

	public static void updateDocumentSend(
		long companyId, PmlEdmDocumentSend documentSend)
		throws SearchException, UnsupportedEncodingException {

		Document doc = getSendDocument(companyId, documentSend);

		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}

	public static void updateDocumentSend(
		long companyId, long documentSendId, String soPhatHanh,
		long documentTypeId, String[] traLoiCongVanSo, String phongSoanThao,
		String receivingPlace, String signer, Date issuingDate, String[] hscvs,
		String briefContent, String active, long numOfDocRef, long editorId,
		boolean numOfDirector)
		throws SearchException, UnsupportedEncodingException {

		Document doc =
			getSendDocument(
				companyId, documentSendId, soPhatHanh, documentTypeId,
				traLoiCongVanSo, phongSoanThao, receivingPlace, signer,
				issuingDate, hscvs, briefContent, active, numOfDocRef,
				editorId, numOfDirector);

		if (doc != null) {
			SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
		}
	}

	public static void deleteDocumentSend(
		long companyId, PmlEdmDocumentSend documentSend)
		throws SearchException, UnsupportedEncodingException {

		Document doc = getSendDocument(companyId, documentSend);

		if (doc != null) {
			SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));
		}
	}

	public static void deleteDocument(
		long companyId, long documentSendId, String soPhatHanh,
		long documentTypeId, String[] traLoiCongVanSo, String phongSoanThao,
		String receivingPlace, String signer, Date issuingDate, String[] hscvs,
		String briefContent, String active, long numOfDocRef, long editorId,
		boolean numOfDirector)
		throws SearchException, UnsupportedEncodingException {

		Document doc =
			getSendDocument(
				companyId, documentSendId, soPhatHanh, documentTypeId,
				traLoiCongVanSo, phongSoanThao, receivingPlace, signer,
				issuingDate, hscvs, briefContent, active, numOfDocRef,
				editorId, numOfDirector);

		SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));
	}

	public static Document getSendDocument(
		long companyId, PmlEdmDocumentSend documentSend)
		throws UnsupportedEncodingException {

		String[] traLoiCongVanSo = null;
		String phongSoanThao = null;
		String[] hscvs = null;
		try {
			List<PmlEdmAnswerDetail> answerDetails =
				PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSend.getDocumentSendId());
			if ((answerDetails != null) && (answerDetails.size() > 0)) {
				traLoiCongVanSo = new String[answerDetails.size()];
				for (int i = 0; i < answerDetails.size(); i++) {
					traLoiCongVanSo[i] = String.valueOf(answerDetails.get(i));
				}
			}
			PmlUser pmlUser =
				PmlUserLocalServiceUtil.getPmlUser(documentSend.getEditorId());
			phongSoanThao = pmlUser.getDepartmentsId();

			List<PmlChiTietHSCV> chiTietHSCVs =
				PmlChiTietHSCVUtil.findByIdCongVanDi(documentSend.getDocumentSendId());
			if (chiTietHSCVs != null) {
				hscvs = new String[chiTietHSCVs.size()];
				for (int i = 0; i < chiTietHSCVs.size(); i++) {
					hscvs[i] =
						String.valueOf(chiTietHSCVs.get(i).getIdHoSoCongViec());
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		/*
		 * xuancong close start, thay bang goi ham co them tham so numofdocref
		 * return getSendDocument(companyId, documentSend.getDocumentSendId(),
		 * documentSend.getDocumentReference(),
		 * documentSend.getDocumentTypeId(), traLoiCongVanSo, phongSoanThao,
		 * documentSend.getReceivingPlace(), documentSend.getSignerName(),
		 * documentSend.getIssuingDate(), hscvs, documentSend.getBriefContent(),
		 * documentSend.getActive()); xuancong close end
		 */
		return getSendDocument(
			companyId, documentSend.getDocumentSendId(),
			documentSend.getDocumentReference(),
			documentSend.getDocumentTypeId(), traLoiCongVanSo, phongSoanThao,
			documentSend.getReceivingPlace(), documentSend.getSignerName(),
			documentSend.getIssuingDate(), hscvs,
			documentSend.getBriefContent(), documentSend.getActive(),
			documentSend.getNumOfDocRef(), documentSend.getEditorId(),
			documentSend.getNumOfDirector());
	}

	/*
	 * xuancong close start khong su dung ham nay nua public static Document
	 * getSendDocument(long companyId, long documentSendId, String soPhatHanh,
	 * long documentTypeId, String[] traLoiCongVanSo, String phongSoanThao,
	 * String receivingPlace, String signer, Date issuingDate, String[] hscvs,
	 * String briefContent, String active) throws UnsupportedEncodingException {
	 * soPhatHanh = soPhatHanh.toLowerCase(); phongSoanThao =
	 * phongSoanThao.toLowerCase(); receivingPlace =
	 * receivingPlace.toLowerCase(); briefContent = briefContent.toLowerCase();
	 * signer = signer.toLowerCase(); DateFormat dateFormat = new
	 * SimpleDateFormat("yyyyMMdd"); Document doc = new DocumentImpl();
	 * doc.addUID(PORTLET_ID, documentSendId); doc.addKeyword(Field.COMPANY_ID,
	 * companyId); doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
	 * doc.addKeyword(Field.ENTRY_CLASS_PK, documentSendId);
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH, soPhatHanh);
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN,
	 * documentTypeId);
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO,
	 * traLoiCongVanSo);
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO,
	 * phongSoanThao); doc.addText(PmlEdmDocumentSendDisplayTerms.NOI_NHAN,
	 * receivingPlace); //xuancong close dung Text thay cho Keyword
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
	 * signer.replace(" ", ""));
	 * doc.addText(PmlEdmDocumentSendDisplayTerms.NGUOI_KY, signer);
	 * doc.addKeyword("ngayPhatHanh", issuingDate != null?
	 * dateFormat.format(issuingDate) : "");
	 * doc.addKeyword(PmlEdmDocumentSendDisplayTerms.SO_HSCV, hscvs);
	 * doc.addKeyword("active", active);
	 * doc.addText(PmlEdmDocumentSendDisplayTerms.TRICH_YEU, briefContent);
	 * return doc; } xuancong close end
	 */

	public static Document getSendDocument(
		long companyId, long documentSendId, String soPhatHanh,
		long documentTypeId, String[] traLoiCongVanSo, String phongSoanThao,
		String receivingPlace, String signer, Date issuingDate, String[] hscvs,
		String briefContent, String active, long numOfDocRef,
		long nguoiSoanThao, boolean numOfDirector)
		throws UnsupportedEncodingException {

		soPhatHanh = soPhatHanh.toLowerCase();
		phongSoanThao = phongSoanThao.toLowerCase();
		receivingPlace = receivingPlace.toLowerCase();
		briefContent = briefContent.toLowerCase();
		signer = signer.toLowerCase();

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, documentSendId);

		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);

		doc.addKeyword(Field.ENTRY_CLASS_PK, documentSendId);

		doc.addKeyword(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH, soPhatHanh);
		doc.addKeyword(
			PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN, documentTypeId);
		doc.addKeyword(
			PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO, traLoiCongVanSo);
		doc.addKeyword(
			PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO, phongSoanThao);
		doc.addText(PmlEdmDocumentSendDisplayTerms.NOI_NHAN, receivingPlace);
		// xuancong close dung Text thay cho Keyword
		// doc.addKeyword(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
		// signer.replace(" ", ""));
		doc.addText(PmlEdmDocumentSendDisplayTerms.NGUOI_KY, signer);
		doc.addKeyword(
			"ngayPhatHanh",
			issuingDate != null ? dateFormat.format(issuingDate) : "");
		doc.addKeyword(PmlEdmDocumentSendDisplayTerms.SO_HSCV, hscvs);
		doc.addKeyword("active", active);
		doc.addText(PmlEdmDocumentSendDisplayTerms.TRICH_YEU, briefContent);
		doc.addKeyword(PmlEdmDocumentSendDisplayTerms.NUMOFDOCREF, numOfDocRef);
		doc.addKeyword(
			PmlEdmDocumentSendDisplayTerms.NGUOI_SOAN_THAO, nguoiSoanThao);
		doc.addKeyword(
			PmlEdmDocumentSendDisplayTerms.NUMOFDIRECTOR,
			String.valueOf(numOfDirector));

		return doc;
	}

	// xuancong close @Override
	public DocumentSummary getDocumentSummary(Document arg0, PortletURL arg1) {

		return null;
	}

	// xuancong close @Override
	public void reIndex(String[] ids)
		throws SearchException {

		// Canh update 20110117
		try {
			PmlEdmDocumentSendLocalServiceUtil.reIndex(ids);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		// End of Canh update 20110117
	}

	public static void deletePortletDocuments(long companyId)
		throws SearchException {

		SearchEngineUtil.deletePortletDocuments(companyId, PORTLET_ID);
	}
}
