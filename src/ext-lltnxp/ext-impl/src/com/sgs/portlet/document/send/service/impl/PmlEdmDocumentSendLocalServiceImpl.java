package com.sgs.portlet.document.send.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendDisplayTerms;
import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.base.PmlEdmDocumentSendLocalServiceBaseImpl;
import com.sgs.portlet.document.send.util.SendIndexer;

/**
 * @author lethanhtung
 */
public class PmlEdmDocumentSendLocalServiceImpl extends
		PmlEdmDocumentSendLocalServiceBaseImpl {

	/**
	 * this method filter a list PmlEdmDocumentSend by input params
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param briefContent
	 *            : nội dung trích yếu
	 * @param signer
	 *            : ngừơi ký
	 * @param issuingDate
	 *            : ngày phát hành
	 * @param documentReference
	 *            : số hiệu công văn
	 * @param receivingPlace
	 *            : nơi gửi (cơ quan tiếp nhận)
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filter(List<PmlEdmDocumentSend> list,
			String briefContent, long signer, Date issuingDate,
			String documentReference, String receivingPlace) {

		List<PmlEdmDocumentSend> retValue = filterByBriefContent(list,
				briefContent);
		retValue = filterBySigner(retValue, signer);
		retValue = filterByIssuingDate(retValue, issuingDate);
		retValue = filterByDocumentReference(retValue, documentReference);
		retValue = filterByIssuingPlace(retValue, receivingPlace);

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by input params
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param briefContent
	 *            : nội dung trích yếu
	 * @param issuingDate
	 *            : ngày phát hành
	 * @param documentReference
	 *            : số hiệu công văn
	 * @param receivingPlace
	 *            : nơi gửi (cơ quan tiếp nhận)
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filter(List<PmlEdmDocumentSend> list,
			String briefContent, Date issuingDate, String documentReference,
			String receivingPlace) {

		List<PmlEdmDocumentSend> retValue = filterByBriefContent(list,
				briefContent);
		retValue = filterByIssuingDate(retValue, issuingDate);
		retValue = filterByDocumentReference(retValue, documentReference);
		retValue = filterByIssuingPlace(retValue, receivingPlace);

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by receivingPlace
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param receivingPlace
	 *            : nơi gửi (cơ quan tiếp nhận)
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filterByIssuingPlace(
			List<PmlEdmDocumentSend> list, String receivingPlace) {

		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;

		if ((list == null) || (receivingPlace == null)
				|| receivingPlace.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentSend item : list) {
			if (item.getReceivingPlace() != null) {
				if (item.getReceivingPlace().toUpperCase()
						.indexOf(receivingPlace.toUpperCase()) != -1) {
					pmlEdmDocumentSend = item;
					retValue.add(pmlEdmDocumentSend);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by documentReference
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param documentReference
	 *            : số hiệu công văn
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filterByDocumentReference(
			List<PmlEdmDocumentSend> list, String documentReference) {

		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;

		if ((list == null) || (documentReference == null)
				|| documentReference.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentSend item : list) {
			if (item.getDocumentReference() != null) {
				if (item.getDocumentReference().toUpperCase()
						.indexOf(documentReference.toUpperCase()) != -1) {
					pmlEdmDocumentSend = item;
					retValue.add(pmlEdmDocumentSend);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by issuingDate
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param issuingDate
	 *            : ngày phát hành
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filterByIssuingDate(
			List<PmlEdmDocumentSend> list, Date issuingDate) {

		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;
		if ((list == null) || (issuingDate == null)
				|| issuingDate.toString().equals("")) {
			return list;
		}
		for (PmlEdmDocumentSend item : list) {
			if (item.getIssuingDate() != null) {
				if (item.getIssuingDate().equals(issuingDate)) {
					pmlEdmDocumentSend = item;
					retValue.add(pmlEdmDocumentSend);
				}
			}
		}
		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by signer
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param signer
	 *            : ngừơi ký
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filterBySigner(
			List<PmlEdmDocumentSend> list, long signer) {

		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;

		if ((list == null) || String.valueOf(signer).equals("")) {
			return list;
		}

		for (PmlEdmDocumentSend item : list) {
			if (item != null) {
				if (item.getSignerId() == signer) {
					pmlEdmDocumentSend = item;
					retValue.add(pmlEdmDocumentSend);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentSend by briefContent
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentSend
	 * @param briefContent
	 *            : nội dung trích yếu
	 * @return list of PmlEdmDocumentSend object
	 */
	public List<PmlEdmDocumentSend> filterByBriefContent(
			List<PmlEdmDocumentSend> list, String briefContent) {

		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;

		if ((list == null) || (briefContent == null)
				|| briefContent.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentSend item : list) {
			if (item.getBriefContent() != null) {
				if (briefContent.toUpperCase().indexOf(
						item.getBriefContent().toUpperCase()) != -1) {
					pmlEdmDocumentSend = item;
					retValue.add(pmlEdmDocumentSend);
				}
			}
		}

		return retValue;
	}

	public int countByS_L_T_P_N_N_TN_DN_S_T(String soPhatHanh,
			long loaiCongVan, String traLoiCongVanSo, String phongSoanThao,
			String noiNhan, long nguoiKy, String tuNgay, String denNgay,
			long soHSCV, String trichYeu) throws SystemException {

		return pmlEdmDocumentSendFinder.countByS_L_T_P_N_N_TN_DN_S_T(
				soPhatHanh, loaiCongVan, traLoiCongVanSo, phongSoanThao,
				noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu);
	}

	public List<PmlEdmDocumentSend> findByS_L_T_P_N_N_TN_DN_S_T(
			String soPhatHanh, long loaiCongVan, String traLoiCongVanSo,
			String phongSoanThao, String noiNhan, long nguoiKy, String tuNgay,
			String denNgay, long soHSCV, String trichYeu, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.findByS_L_T_P_N_N_TN_DN_S_T(soPhatHanh,
				loaiCongVan, traLoiCongVanSo, phongSoanThao, noiNhan, nguoiKy,
				tuNgay, denNgay, soHSCV, trichYeu, start, end, obc);
	}

	/**
	 * So luong cong van di can xu ly cua nguoi dung
	 * 
	 * @author XUAN CONG
	 * @param userId
	 *            Ma so nguoi dung
	 * @return So luong cong van di can xu ly cua nguoi dung
	 * @throws SystemException
	 */
	public int countDocSendNeedProcess(long userId) throws SystemException {

		return pmlEdmDocumentSendFinder.countDocSendNeedProcess(userId);
	}

	// minh update 25/11/2009
	public int countByDocumentSend_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soCVDen, String capGui) throws Exception {

		return pmlEdmDocumentSendFinder
				.countByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
						soCVDen, capGui);
	}

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			int start, int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
						soCVDen, capGui, start, end, obc);
	}

	/**
	 * @author DienNH
	 * @update 01/12/2009
	 */
	public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String loaisocongvan,
			String capGui) throws Exception {

		return pmlEdmDocumentSendFinder
				.countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
						statusId, loaisocongvan, capGui);
	}

	/**
	 * @author DienNH
	 * @update 01/12/2009
	 */
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String loaisocongvan,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
						statusId, loaisocongvan, capGui, start, end, obc);
	}

	public int countByDocumentSend_Users(List<Long> userIds,
			String loaisocongvan) throws Exception {

		return pmlEdmDocumentSendFinder.countByDocumentSend_Users(userIds,
				loaisocongvan);
	}

	public List<PmlEdmDocumentSend> findByDocumentSend_Users(
			List<Long> userIds, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.findByDocumentSend_Users(userIds,
				loaisocongvan, start, end, obc);
	}

	// xuancong close @Override
	public int countDocumentType(int documentTypeId, String departmentsId)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countDocumentType(documentTypeId,
				departmentsId);
	}

	// end
	/**
	 * Lay ma so lon nhat trong bang pml_edm_documentsend
	 */
	public long getMaxDocumentSendId() throws SystemException {

		try {
			return pmlEdmDocumentSendFinder.getMaxDocumentSendId();
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * Lay ma so tham chieu lon nhat cua van ban di theo loai va theo nam
	 * 
	 * @param docTypeId
	 *            : ma loai van ban di
	 * @param issuingYear
	 *            : nam phat hanh
	 * @return
	 * @throws SystemException
	 */
	public long getMaxDocRefByTypeYear(long docTypeId, int issuingYear)
			throws SystemException {

		try {
			return pmlEdmDocumentSendFinder.getMaxDocRefByTypeYear(docTypeId,
					issuingYear);
		} catch (Exception ex) {
			return 0;
		} // end catch
	}

	// Canh update
	public void reIndext(long companyId, PmlEdmDocumentSend documentSend)
			throws SearchException {

		try {
			SendIndexer.updateDocumentSend(companyId, documentSend);
		} catch (UnsupportedEncodingException e) {
			throw new SearchException(e);
		}
	}

	// Canh update 20110117
	public void reIndex(String[] ids) throws SystemException, SearchException {

		long companyId = GetterUtil.getLong(ids[0]);

		for (PmlEdmDocumentSend documentSend : pmlEdmDocumentSendPersistence
				.findAll()) {
			try {
				com.liferay.portal.kernel.search.Document doc = SendIndexer
						.getSendDocument(companyId, documentSend);
				SearchEngineUtil.addDocument(companyId, doc);
			} catch (Exception e) {
				_log.error("Reindexing " + documentSend.getDocumentSendId(), e);
			}
		}
	}// End of Canh 20110117

	public PmlEdmDocumentSend addPmlEdmDocumentSend(long companyId,
			String briefContent, String documentReference,
			String receivingPlace, long editorId, long documentTypeId,
			String privilegeLevelId, String confidentialLevelId,
			Date dateCreated, boolean isLocal) throws SystemException,
			SearchException {

		long documentSendId;
		// create
		documentSendId = CounterLocalServiceUtil.increment();
		PmlEdmDocumentSend documentSend = pmlEdmDocumentSendPersistence
				.create(documentSendId);

		documentSend.setDocumentSendId(documentSendId);
		documentSend.setBriefContent(briefContent);
		documentSend.setDocumentReference(documentReference);
		documentSend.setReceivingPlace(receivingPlace);
		documentSend.setIssuingDate(new Timestamp(new Date().getTime()));
		documentSend.setEditorId(editorId);
		documentSend.setDocumentTypeId(documentTypeId);
		documentSend.setPrivilegeLevelId(privilegeLevelId);
		documentSend.setConfidentialLevelId(confidentialLevelId);
		documentSend.setDateCreated(dateCreated);
		documentSend.setIsLocal(isLocal);
		documentSend.setNew(true);
		pmlEdmDocumentSendPersistence.update(documentSend, false);

		// index
		if (documentSend.getIssuingDate() != null) {
			reIndext(companyId, documentSend);
		}

		return documentSend;
	}

	public PmlEdmDocumentSend addPmlEdmDocumentSend(long companyId,
			PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException,
			SearchException {

		pmlEdmDocumentSend.setNew(true);
		pmlEdmDocumentSendPersistence.update(pmlEdmDocumentSend, false);

		if (pmlEdmDocumentSend.getIssuingDate() != null) {
			reIndext(companyId, pmlEdmDocumentSend);
		}
		return pmlEdmDocumentSend;
	}

	@Override
	public PmlEdmDocumentSend addPmlEdmDocumentSend(
			PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException {

		throw new SystemException(
				"Please use method: addPmlEdmDocumentSend(long companyId, PmlEdmDocumentSend pmlEdmDocumentSend)");
	}

	public PmlEdmDocumentSend updatePmlEdmDocumentSend(long companyId,
			long documentSendId, String briefContent, String documentReference,
			String receivingPlace, long editorId, long documentTypeId,
			String privilegeLevelId, String confidentialLevelId,
			Date dateCreated, boolean isLocal) throws SystemException,
			NoSuchPmlEdmDocumentSendException, SearchException {

		// update
		PmlEdmDocumentSend documentSend = pmlEdmDocumentSendPersistence
				.findByPrimaryKey(documentSendId);

		documentSend.setDocumentSendId(documentSendId);
		documentSend.setBriefContent(briefContent);
		documentSend.setDocumentReference(documentReference);
		documentSend.setReceivingPlace(receivingPlace);
		documentSend.setIssuingDate(new Timestamp(new Date().getTime()));
		documentSend.setEditorId(editorId);
		documentSend.setDocumentTypeId(documentTypeId);
		documentSend.setPrivilegeLevelId(privilegeLevelId);
		documentSend.setConfidentialLevelId(confidentialLevelId);
		documentSend.setDateCreated(dateCreated);
		documentSend.setIsLocal(isLocal);
		pmlEdmDocumentSendPersistence.update(documentSend, true);

		// reindex
		if (documentSend.getIssuingDate() != null) {
			reIndext(companyId, documentSend);
		}

		return documentSend;
	}

	public PmlEdmDocumentSend updatePmlEdmDocumentSend(long companyId,
			PmlEdmDocumentSend documentSend) throws SystemException,
			SearchException {

		pmlEdmDocumentSendPersistence.update(documentSend, true);

		// reindex
		if (documentSend.getIssuingDate() != null) {
			reIndext(companyId, documentSend);
		}

		return documentSend;
	}

	public void deletePmlEdmDocumentSend(long companyId, long documentSendId)
			throws NoSuchPmlEdmDocumentSendException, SystemException,
			SearchException {

		PmlEdmDocumentSend documentSend = pmlEdmDocumentSendPersistence
				.findByPrimaryKey(documentSendId);

		deletePmlEdmDocumentSend(companyId, documentSend);
	}

	public void deletePmlEdmDocumentSend(long companyId,
			PmlEdmDocumentSend pmlEdmDocumentSend) throws SearchException,
			SystemException {

		pmlEdmDocumentSendPersistence.remove(pmlEdmDocumentSend);

		// remove index
		try {
			SendIndexer.deleteDocumentSend(companyId, pmlEdmDocumentSend);
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public PmlEdmDocumentSend updatePmlEdmDocumentSend(
			PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException {

		throw new SystemException(
				"Please use method: updatePmlEdmDocumentSend(long companyId, PmlEdmDocumentSend pmlEdmDocumentSend)");
	}

	@Override
	public void deletePmlEdmDocumentSend(long documentSendId)
			throws PortalException, SystemException {

		throw new SystemException(
				"Please use method: deletePmlEdmDocumentSend(long companyId, long documentSendId)");
	}

	@Override
	public void deletePmlEdmDocumentSend(PmlEdmDocumentSend pmlEdmDocumentSend)
			throws SystemException {

		throw new SystemException(
				"Please use method: deletePmlEdmDocumentSend(long companyId, PmlEdmDocumentSend pmlEdmDocumentSend)");
	}

	public Hits search(long companyId, String soPhatHanh, long loaiCongVan,
			String traLoiCongVanSo, String phongSoanThao, String noiNhan,
			String nguoiKy, Date tuNgay, Date denNgay, long soHSCV,
			String trichYeu, String active, long nguoiSoanThao, int start,
			int end) throws SystemException {

		return search(companyId, soPhatHanh, loaiCongVan, traLoiCongVanSo,
				phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay, soHSCV,
				trichYeu, active, nguoiSoanThao, "ngayPhatHanh",
				Sort.LONG_TYPE, start, end);
	}

	public Hits search(long companyId, String soPhatHanh, long loaiCongVan,
			String traLoiCongVanSo, String phongSoanThao, String noiNhan,
			String nguoiKy, Date tuNgay, Date denNgay, long soHSCV,
			String trichYeu, String active, long nguoiSoanThao,
			String sortField, int sortType, int start, int end)
			throws SystemException {

		try {

			DateFormat df = new SimpleDateFormat("yyyyMMdd");

			StringBuilder sb = new StringBuilder();

			String tuNgayStr = tuNgay != null ? df.format(tuNgay) : "";
			String denNgayStr = denNgay != null ? df.format(denNgay) : "";

			if (!tuNgayStr.equals(denNgayStr)) {
				sb.append("[");
				sb.append(tuNgayStr);
				sb.append(" TO ");
				sb.append(denNgayStr);
				sb.append("]");
			} else {
				sb.append(tuNgayStr);
			}

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					SendIndexer.PORTLET_ID);

			BooleanQuery soPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCongVanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery traLoiCongVanSoQuery = BooleanQueryFactoryUtil
					.create();
			BooleanQuery phongSoanThaoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiNhanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery rangeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiSoanThaoQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soPhatHanh)) {
				soPhatHanhQuery
						.addTerm(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH,
								soPhatHanh);
				booleanQueries.add(soPhatHanhQuery);
			}
			if (loaiCongVan > 0) {
				loaiCongVanQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN,
						loaiCongVan);
				booleanQueries.add(loaiCongVanQuery);
			}
			if (Validator.isNotNull(traLoiCongVanSo)) {
				traLoiCongVanSoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO,
						traLoiCongVanSo);
				booleanQueries.add(traLoiCongVanSoQuery);
			}
			if (Validator.isNotNull(phongSoanThao)) {
				phongSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO,
						phongSoanThao);
				booleanQueries.add(phongSoanThaoQuery);
			}
			if (Validator.isNotNull(noiNhan)) {
				noiNhanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NOI_NHAN,
						noiNhan);
				booleanQueries.add(noiNhanQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
						nguoiKy.replace(" ", ""));
				booleanQueries.add(nguoiKyQuery);
			}
			if (sb.length() > 6) {
				rangeQuery.addTerm("ngayPhatHanh", sb.toString());
				booleanQueries.add(rangeQuery);
			}
			if (Validator.isNotNull(soHSCV)) {
				soHSCVQuery.addTerm(PmlEdmDocumentSendDisplayTerms.SO_HSCV,
						soHSCV);
				booleanQueries.add(soHSCVQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(PmlEdmDocumentSendDisplayTerms.TRICH_YEU,
						trichYeu);
				booleanQueries.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				booleanQueries.add(activeQuery);
			}
			if (nguoiSoanThao > 0) {
				nguoiSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.NGUOI_SOAN_THAO,
						nguoiSoanThao);
				booleanQueries.add(nguoiSoanThaoQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			if (sortField.equals("ngayPhatHanh")) {
				sort = new Sort(sortField, sortType, true);
			} else {
				sort = new Sort(sortField, sortType, false);
			}

			return SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	// end of Canh

	public Hits search(long companyId, String soPhatHanh, long loaiCongVan,
			String traLoiCongVanSo, String phongSoanThao, String noiNhan,
			String nguoiKy, Date tuNgay, Date denNgay, long soHSCV,
			String trichYeu, String active, long nguoiSoanThao,
			String sortField, int sortType, boolean reverse, int start, int end)
			throws SystemException {

		try {

			DateFormat df = new SimpleDateFormat("yyyyMMdd");

			StringBuilder sb = new StringBuilder();

			String tuNgayStr = tuNgay != null ? df.format(tuNgay) : "";
			String denNgayStr = denNgay != null ? df.format(denNgay) : "";

			if (!tuNgayStr.equals(denNgayStr)) {
				sb.append("[");
				sb.append(tuNgayStr);
				sb.append(" TO ");
				sb.append(denNgayStr);
				sb.append("]");
			} else {
				sb.append(tuNgayStr);
			}

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					SendIndexer.PORTLET_ID);

			BooleanQuery soPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCongVanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery traLoiCongVanSoQuery = BooleanQueryFactoryUtil
					.create();
			BooleanQuery phongSoanThaoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiNhanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery rangeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiSoanThaoQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soPhatHanh)) {
				soPhatHanhQuery
						.addTerm(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH,
								soPhatHanh);
				booleanQueries.add(soPhatHanhQuery);
			}
			if (loaiCongVan > 0) {
				loaiCongVanQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN,
						loaiCongVan);
				booleanQueries.add(loaiCongVanQuery);
			}
			if (Validator.isNotNull(traLoiCongVanSo)) {
				traLoiCongVanSoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO,
						traLoiCongVanSo);
				booleanQueries.add(traLoiCongVanSoQuery);
			}
			if (Validator.isNotNull(phongSoanThao)) {
				phongSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO,
						phongSoanThao);
				booleanQueries.add(phongSoanThaoQuery);
			}
			if (Validator.isNotNull(noiNhan)) {
				noiNhanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NOI_NHAN,
						noiNhan);
				booleanQueries.add(noiNhanQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
						nguoiKy.replace(" ", ""));
				booleanQueries.add(nguoiKyQuery);
			}
			if (sb.length() > 6) {
				rangeQuery.addTerm("ngayPhatHanh", sb.toString());
				booleanQueries.add(rangeQuery);
			}
			if (Validator.isNotNull(soHSCV)) {
				soHSCVQuery.addTerm(PmlEdmDocumentSendDisplayTerms.SO_HSCV,
						soHSCV);
				booleanQueries.add(soHSCVQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(PmlEdmDocumentSendDisplayTerms.TRICH_YEU,
						trichYeu);
				booleanQueries.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				booleanQueries.add(activeQuery);
			}
			if (nguoiSoanThao > 0) {
				nguoiSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.NGUOI_SOAN_THAO,
						nguoiSoanThao);
				booleanQueries.add(nguoiSoanThaoQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			// Doi sort theo sophathanh thanh sort theo numofdocref
			if (sortField.equals(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH)) {
				sort = new Sort(PmlEdmDocumentSendDisplayTerms.NUMOFDOCREF,
						Sort.LONG_TYPE, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}

			return SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public Hits search(long companyId, String soPhatHanh, long loaiCongVan,
			String traLoiCongVanSo, String phongSoanThao, String noiNhan,
			String nguoiKy, Date tuNgay, Date denNgay, long soHSCV,
			String trichYeu, String active, String sortField, int sortType,
			boolean reverse, int start, int end) throws SystemException {

		try {

			DateFormat df = new SimpleDateFormat("yyyyMMdd");

			StringBuilder sb = new StringBuilder();

			String tuNgayStr = tuNgay != null ? df.format(tuNgay) : "";
			String denNgayStr = denNgay != null ? df.format(denNgay) : "";

			if (!tuNgayStr.equals(denNgayStr)) {
				sb.append("[");
				sb.append(tuNgayStr);
				sb.append(" TO ");
				sb.append(denNgayStr);
				sb.append("]");
			} else {
				sb.append(tuNgayStr);
			}

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					SendIndexer.PORTLET_ID);

			BooleanQuery soPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCongVanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery traLoiCongVanSoQuery = BooleanQueryFactoryUtil
					.create();
			BooleanQuery phongSoanThaoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiNhanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery rangeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soPhatHanh)) {
				soPhatHanhQuery
						.addTerm(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH,
								soPhatHanh);
				booleanQueries.add(soPhatHanhQuery);
			}
			if (loaiCongVan > 0) {
				loaiCongVanQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN,
						loaiCongVan);
				booleanQueries.add(loaiCongVanQuery);
			}
			if (Validator.isNotNull(traLoiCongVanSo)) {
				traLoiCongVanSoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO,
						traLoiCongVanSo);
				booleanQueries.add(traLoiCongVanSoQuery);
			}
			if (Validator.isNotNull(phongSoanThao)) {
				phongSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO,
						phongSoanThao);
				booleanQueries.add(phongSoanThaoQuery);
			}
			if (Validator.isNotNull(noiNhan)) {
				noiNhanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NOI_NHAN,
						noiNhan);
				booleanQueries.add(noiNhanQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
						nguoiKy.replace(" ", ""));
				booleanQueries.add(nguoiKyQuery);
			}
			if (sb.length() > 6) {
				rangeQuery.addTerm("ngayPhatHanh", sb.toString());
				booleanQueries.add(rangeQuery);
			}
			if (Validator.isNotNull(soHSCV)) {
				soHSCVQuery.addTerm(PmlEdmDocumentSendDisplayTerms.SO_HSCV,
						soHSCV);
				booleanQueries.add(soHSCVQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(PmlEdmDocumentSendDisplayTerms.TRICH_YEU,
						trichYeu);
				booleanQueries.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				booleanQueries.add(activeQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			// Doi sort theo sophathanh thanh sort theo numofdocref
			if (sortField.equals(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH)) {
				sort = new Sort(PmlEdmDocumentSendDisplayTerms.NUMOFDOCREF,
						Sort.LONG_TYPE, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}

			return SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	/**
	 * CHUYEN VIEN
	 */

	// ton dau ky
	public int countTonDauKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTonDauKyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTonDauKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTonDauKyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countNhanTrongKyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listNhanTrongKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listNhanTrongKyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// chua nhan
	public int countChuaNhanChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countChuaNhanChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listChuaNhanChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listChuaNhanChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// nhan trong thang
	public int countNhanTrongThangChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentSendFinder.countNhanTrongThangChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listNhanTrongThangChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listNhanTrongThangChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, fromDate, toDate, start,
				end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDaXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDaXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDaXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDaXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDaXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDaXuLyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDaXuLyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTongDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTongDaXuLyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDangXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDangXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDangXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDangXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDangXuLyChuyenVien_CVDi(
				userId, documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTongDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTongDangXuLyChuyenVien_CVDi(userId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	/**
	 * PHONG BAN
	 */

	// ton dau ky
	public int countTonDauKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTonDauKyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listTonDauKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTonDauKyPhongBan_CVDi(departmentId,
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countNhanTrongKyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listNhanTrongKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listNhanTrongKyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// nhan trong ky
	public int countChuaNhanTrongKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countChuaNhanTrongKyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listChuaNhanTrongKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listChuaNhanTrongKyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listTongDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTongDaXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentSend> listTongDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.listTongDangXuLyPhongBan_CVDi(
				departmentId, documentRecordTypeId, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	/**
	 * TOAN CO QUAN
	 */

	// ton dau ky
	public int countTonDauKySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTonDauKySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTonDauKySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTonDauKySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countNhanTrongKySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listNhanTrongKySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listNhanTrongKySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTongDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTongDaXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLySo_CVDi(int documentRecordTypeId,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentSendFinder.countDungHanDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listDungHanDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listDungHanDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTreHanDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTreHanDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTreHanDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentSendFinder.countTongDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentSend> listTongDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.listTongDangXuLySo_CVDi(
				documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start,
				end, obc);
	}

	/**
	 * @author phmphuc 02/04/2010 portlet congvandidahoanthanh lay danh sach
	 *         cong van di da hoan thanh theo tung loai so cong van
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSend(
			int loaiSoCongVan, String fromDate, String toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.getListPmlEdmDocumentSend(
				loaiSoCongVan, fromDate, toDate, start, end, obc);
	}

	// cho search container
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendByLoaiSoCV(
			String loaiSoCongVan, String fromDate, String toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder.getListPmlEdmDocumentSendByLoaiSoCV(
				loaiSoCongVan, fromDate, toDate, start, end, obc);
	}

	public int countListPmlEdmDocumentSendByLoaiSoCV(String loaiSoCongVan,
			String fromDate, String toDate) throws SystemException {

		return pmlEdmDocumentSendFinder.countListPmlEdmDocumentSendByLoaiSoCV(
				loaiSoCongVan, fromDate, toDate);
	}

	/**
	 * yenlt 09/04/2010 CV DI DA XU LY
	 */
	public int countListCVDiDaXuLyTuXuLy(long userId, String year,
			String loaisocongvan) throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy(userId, year,
				loaisocongvan);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy(userId, year,
				loaisocongvan, start, end, obc);
	}

	public int countListCVDiDaXuLyChung(long userId, String year,
			String loaisocongvan) throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung(userId, year,
				loaisocongvan);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung(userId, year,
				loaisocongvan, start, end, obc);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung_treHan(userId,
				year, loaisocongvan, start, end, obc);
	}

	public int countListCVDiDaXuLyChung_treHan(long userId, String year,
			String loaisocongvan) throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung_treHan(userId,
				year, loaisocongvan);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy_treHan(userId,
				year, loaisocongvan, start, end, obc);
	}

	public int countListCVDiDaXuLyTuXuLy_treHan(long userId, String year,
			String loaisocongvan) throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy_treHan(
				userId, year, loaisocongvan);
	}

	public int countByD_I_D_R_D_S_E_B(String soPH, int ngayPHMonth,
			int ngayPHYear, String phongST, String noiNhan, long loaiVB,
			String tenNguoiKy, long nguoiST, String trichYeu)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countByD_I_D_R_D_S_E_B(soPH,
				ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy,
				nguoiST, trichYeu);
	}

	public List<PmlEdmDocumentSend> findByD_I_D_R_D_S_E_B(String soPH,
			int ngayPHMonth, int ngayPHYear, String phongST, String noiNhan,
			long loaiVB, String tenNguoiKy, long nguoiST, String trichYeu,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.findByD_I_D_R_D_S_E_B(soPH,
				ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy,
				nguoiST, trichYeu, start, end, obc);
	};

	// YENLT 19-06-2010
	// delete cv di bi loi va chua phat hanh.
	public int countByKeywords(String keywords) throws SystemException {

		return pmlEdmDocumentSendFinder.countByKeywords(keywords);
	}

	public int countByLOAIVB_NGUOIKY(long loaiVB, String nguoiKy,
			boolean andOperator) throws SystemException {

		return pmlEdmDocumentSendFinder.countByLOAIVB_NGUOIKY(loaiVB, nguoiKy,
				andOperator);
	}

	public List<PmlEdmDocumentSend> findByKeywords(String keywords, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.findByKeywords(keywords, start, end,
				obc);
	}

	public List<PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(long loaiVB,
			String nguoiKy, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.findByLOAIVB_NGUOIKY(loaiVB, nguoiKy,
				andOperator, start, end, obc);
	}

	// end yenlt 19-06-2010

	/**
	 * yenlt 20101023 == TIM THEO SEARCH FORM CONG VAN DI DA XU LY
	 * 
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung(userId, loaiVB,
				soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
				denNgay, start, end, obc);
	}

	public int countListCVDiDaXuLyChung(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung(userId,
				loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
				tuNgay, denNgay);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy(userId, loaiVB,
				soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
				denNgay, start, end, obc);
	}

	public int countListCVDiDaXuLyTuXuLy(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy(userId,
				loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
				tuNgay, denNgay);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung_treHan(userId,
				loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
				tuNgay, denNgay, start, end, obc);
	}

	public int countListCVDiDaXuLyChung_treHan(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung_treHan(userId,
				loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
				tuNgay, denNgay);
	}

	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy_treHan(userId,
				loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
				tuNgay, denNgay, start, end, obc);
	}

	public int countListCVDiDaXuLyTuXuLy_treHan(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy_treHan(
				userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
				coQuanNhan, tuNgay, denNgay);
	}

	public int countByDocumentSend_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, long loaiVB, String soKyHieu, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay) throws Exception {

		return pmlEdmDocumentSendFinder
				.countByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
						loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
						coQuanNhan, tuNgay, denNgay);
	}

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
						loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
						coQuanNhan, tuNgay, denNgay, start, end, obc);
	}

	public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {

		return pmlEdmDocumentSendFinder
				.countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
						statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy,
						trichYeu, coQuanNhan, tuNgay, denNgay);
	}

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
						statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy,
						trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}

	/**
	 * YENLT UPDATE XU LY THAY 20101028
	 */
	public List<PmlEdmDocumentSend> findByDocumentSend_Users(
			List<Long> userIds, long loaiVB, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.findByDocumentSend_Users(userIds,
				loaiVB, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
				denNgay, start, end, obc);
	}

	public int countByDocumentSend_Users(List<Long> userIds, long loaiVB,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {

		return pmlEdmDocumentSendFinder.countByDocumentSend_Users(userIds,
				loaiVB, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
				denNgay);
	}

	/**
	 * phmphuc them cac phuong thuc lay ds log tuong tu nhu documentsend muc
	 * dich lay noi dung yeu cau xu ly cho tung documentsend 12/11/2010
	 */
	// chuyen vien dang xu ly
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSendLog_Users_Status_DangXuLy(userIds, statusId,
						soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
						coQuanNhan, tuNgay, denNgay, start, end, obc);
	}

	// chuyen vien xu ly tre han
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentSendFinder
				.findByDocumentSendLog_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy,
						trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}

	// van thu xu ly thay
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users(
			List<Long> userIds, long loaiVB, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentSendFinder.findByDocumentSendLog_Users(userIds,
				loaiVB, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
				denNgay, start, end, obc);
	}

	/**
	 * Lien ket van ban
	 */
	/**
	 * Lay danh sach ma so van ban di theo so phat hanh, phong soan thao, noi
	 * nhan, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soPH
	 *            So van ban di phat hanh
	 * @param phongST
	 *            Ten phong soan thao
	 * @param noiNhan
	 *            Noi nhan van ban
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @param notInDocIdRelation
	 *            Danh sach ma so van ban khong lay ve trong ket qua tra ve
	 * @param sortField
	 *            Sap xep theo ten truong
	 * @param sortType
	 *            Kieu sap xep
	 * @param reverse
	 *            Dao nguoc hay khong
	 * @return
	 * @throws SystemException
	 */
	public List<Long> searchBySPH_PST_NN_TY_noRelation(long companyId,
			String soPH, String phongST, String noiNhan, String trichYeu,
			List<Long> notInDocIdRelation, String sortField, int sortType,
			boolean reverse) throws SystemException {

		List<Long> retVal = new ArrayList<Long>();
		try {
			long loaiVB = 0;
			String traLoiVB = "";
			String nguoiKy = "";
			Date tuNgay = null;
			Date denNgay = null;
			long soHSCV = 0;
			String active = "";
			int start = QueryUtil.ALL_POS;
			int end = QueryUtil.ALL_POS;
			Hits hits = search(companyId, soPH, loaiVB, traLoiVB, phongST,
					noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu,
					active, sortField, sortType, reverse, start, end);

			if (hits.getLength() > 0) {
				// Duyet hits va xuat ma so ra danh sach
				for (int idxH = 0; idxH < hits.getLength(); idxH++) {
					Document docItem = hits.doc(idxH);
					long docId = GetterUtil.getLong(docItem
							.get(Field.ENTRY_CLASS_PK));
					if (!retVal.contains(docId)) {
						retVal.add(docId);
					}
				}
			}

			if (!notInDocIdRelation.isEmpty()) {
				// Duyet danh sach ma so khong tra ve de remove khoi danh sach
				// tra ve
				for (int idxDIR = 0; idxDIR < notInDocIdRelation.size(); idxDIR++) {
					if (retVal.contains(notInDocIdRelation.get(idxDIR))) {
						retVal.remove(retVal.indexOf(notInDocIdRelation
								.get(idxDIR)));
					}
				}
			}
		} catch (Exception ex) {
			System.out
					.println("Co loi trong ham searchBySPH_PST_NN_TY_noRelation cua file PmlEdmDocumentSendLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	/**
	 * Lay so luong ma so van ban di theo so phat hanh, phong soan thao, noi
	 * nhan, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soPH
	 *            So van ban di phat hanh
	 * @param phongST
	 *            Ten phong soan thao
	 * @param noiNhan
	 *            Noi nhan van ban
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @param notInDocIdRelation
	 *            Danh sach ma so van ban khong lay ve trong ket qua tra ve
	 * @return
	 * @throws SystemException
	 */
	public int countBySPH_PST_NN_TY_noRelation(long companyId, String soPH,
			String phongST, String noiNhan, String trichYeu,
			List<Long> notInDocIdRelation) throws SystemException {

		int retVal = 0;
		try {
			String sortField = "";
			int sortType = Sort.STRING_TYPE;
			boolean reverse = false;
			List<Long> lstRes = searchBySPH_PST_NN_TY_noRelation(companyId,
					soPH, phongST, noiNhan, trichYeu, notInDocIdRelation,
					sortField, sortType, reverse);
			if (!lstRes.isEmpty()) {
				// Tra ve so luong mau tin
				retVal = lstRes.size();
			}
		} catch (Exception ex) {
			System.out
					.println("Co loi trong ham countBySPH_PST_NN_TY_noRelation cua file PmlEdmDocumentSendLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	/**
	 * Lay danh sach ma so van ban di theo so phat hanh, phong soan thao, noi
	 * nhan, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soPH
	 *            So van ban di phat hanh
	 * @param phongST
	 *            Ten phong soan thao
	 * @param noiNhan
	 *            Noi nhan van ban
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @param notInDocIdRelation
	 *            Danh sach ma so van ban khong lay ve trong ket qua tra ve
	 * @param sortField
	 *            Sap xep theo ten truong
	 * @param sortType
	 *            Kieu sap xep
	 * @param reverse
	 *            Dao nguoc hay khong
	 * @param start
	 *            Vi tri bat dau danh sach con
	 * @param end
	 *            Vi tri ket thuc danh sach con
	 * @return
	 * @throws SystemException
	 */
	public List<Long> searchBySPH_PST_NN_TY_noRelation(long companyId,
			String soPH, String phongST, String noiNhan, String trichYeu,
			List<Long> notInDocIdRelation, String sortField, int sortType,
			boolean reverse, int start, int end) throws SystemException {

		List<Long> retVal = new ArrayList<Long>();
		try {
			List<Long> lstRes = searchBySPH_PST_NN_TY_noRelation(companyId,
					soPH, phongST, noiNhan, trichYeu, notInDocIdRelation,
					sortField, sortType, reverse);
			if (!lstRes.isEmpty()) {
				int limitUp = end;
				if (end >= lstRes.size()) {
					limitUp = lstRes.size();
				}
				// Lay ra danh sach tu vi tri start den vi tri limitUp
				for (int idxR = start; idxR < limitUp; idxR++) {
					retVal.add(lstRes.get(idxR));
				}
			}
		} catch (Exception ex) {
			System.out
					.println("Co loi trong ham searchBySPH_PST_NN_TY_noRelation cua file PmlEdmDocumentSendLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	// end lien ket van ban

	// phmphuc update 27/12/2010 - lay so phat hanh vb di co kem theo so giam
	// doc hoac so phong ban
	public long getSoPhatHanhVBDi(long docTypeId, int issuingYear,
			boolean numOfDirector) throws SystemException {

		try {
			return pmlEdmDocumentSendFinder.getSoPhatHanhVBDi(docTypeId,
					issuingYear, numOfDirector);
		} catch (Exception ex) {
			return 0;
		} // end catch
	}

	// phmphuc update 27/12/2010 - cau sql cho phan Tim kiem VB di
	public Hits timKiemVBDi(long companyId, int numOfDirector,
			String soPhatHanh, long soVanBan, String traLoiCongVanSo,
			String phongSoanThao, String noiNhan, String nguoiKy, Date tuNgay,
			Date denNgay, long soHSCV, String trichYeu, String active,
			long nguoiSoanThao, String sortField, int sortType,
			boolean reverse, int start, int end) throws SystemException {

		try {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");

			StringBuilder sb = new StringBuilder();

			String tuNgayStr = tuNgay != null ? df.format(tuNgay) : "";
			String denNgayStr = denNgay != null ? df.format(denNgay) : "";

			if (!tuNgayStr.equals(denNgayStr)) {
				sb.append("[");
				sb.append(tuNgayStr);
				sb.append(" TO ");
				sb.append(denNgayStr);
				sb.append("]");
			} else {
				sb.append(tuNgayStr);
			}

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					SendIndexer.PORTLET_ID);

			BooleanQuery soPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCongVanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery traLoiCongVanSoQuery = BooleanQueryFactoryUtil
					.create();
			BooleanQuery phongSoanThaoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiNhanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery rangeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiSoanThaoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery numOfDirectorQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soPhatHanh)) {
				soPhatHanhQuery
						.addTerm(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH,
								soPhatHanh);
				booleanQueries.add(soPhatHanhQuery);
			}
			if (soVanBan > 0) {
//				loaiCongVanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN, loaiCongVan);
				loaiCongVanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.SOVANBAN, soVanBan);
				booleanQueries.add(loaiCongVanQuery);
			}
			if (Validator.isNotNull(traLoiCongVanSo)) {
				traLoiCongVanSoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO,
						traLoiCongVanSo);
				booleanQueries.add(traLoiCongVanSoQuery);
			}
			if (Validator.isNotNull(phongSoanThao)) {
				phongSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO,
						phongSoanThao);
				booleanQueries.add(phongSoanThaoQuery);
			}
			if (Validator.isNotNull(noiNhan)) {
				noiNhanQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NOI_NHAN,
						noiNhan);
				booleanQueries.add(noiNhanQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(PmlEdmDocumentSendDisplayTerms.NGUOI_KY,
						nguoiKy.replace(" ", ""));
				booleanQueries.add(nguoiKyQuery);
			}
			if (sb.length() > 6) {
				rangeQuery.addTerm("ngayPhatHanh", sb.toString());
				booleanQueries.add(rangeQuery);
			}
			if (Validator.isNotNull(soHSCV)) {
				soHSCVQuery.addTerm(PmlEdmDocumentSendDisplayTerms.SO_HSCV,
						soHSCV);
				booleanQueries.add(soHSCVQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(PmlEdmDocumentSendDisplayTerms.TRICH_YEU,
						trichYeu);
				booleanQueries.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				booleanQueries.add(activeQuery);
			}
			if (nguoiSoanThao > 0) {
				nguoiSoanThaoQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.NGUOI_SOAN_THAO,
						nguoiSoanThao);
				booleanQueries.add(nguoiSoanThaoQuery);
			}
			switch (numOfDirector) {
			case (1):
				numOfDirectorQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.NUMOFDIRECTOR, "true");
				booleanQueries.add(numOfDirectorQuery);
				break;
			case (2):
				numOfDirectorQuery.addTerm(
						PmlEdmDocumentSendDisplayTerms.NUMOFDIRECTOR, "false");
				booleanQueries.add(numOfDirectorQuery);
				break;
			default:
				break;
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			// Doi sort theo sophathanh thanh sort theo numofdocref
			if (sortField.equals(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH)) {
				sort = new Sort(PmlEdmDocumentSendDisplayTerms.NUMOFDOCREF,
						Sort.LONG_TYPE, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}

			return SearchEngineUtil.search(companyId, fullQuery, sort, start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	// end phmphuc 27/12/2010

	/**
	 * phmphuc update - 06/01/2011 So van ban di cua phong
	 */
	public int countByVBDi_SoVBDiCuaPhong(String soPH, int ngayPHMonth,
			int ngayPHYear, String phongST, String noiNhan, long loaiVB,
			String tenNguoiKy, long nguoiST, String trichYeu, String vanBanPH)
			throws SystemException {

		return pmlEdmDocumentSendFinder.countByVBDi_SoVBDiCuaPhong(soPH,
				ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy,
				nguoiST, trichYeu, vanBanPH);
	}

	public List<PmlEdmDocumentSend> findByVBDi_SoVBDiCuaPhong(String soPH,
			int ngayPHMonth, int ngayPHYear, String phongST, String noiNhan,
			long loaiVB, String tenNguoiKy, long nguoiST, String trichYeu,
			String vanBanPH, int start, int end, OrderByComparator obc)
			throws SystemException {

		return pmlEdmDocumentSendFinder.findByVBDi_SoVBDiCuaPhong(soPH,
				ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy,
				nguoiST, trichYeu, vanBanPH, start, end, obc);
	}

	// end phmphuc 06/01/2010

	// phmphuc add 07/01/2011 - ham kiem tra so va ky hieu cho vb phat hanh theo
	// nam co ton tai trong csdl chua
	public int kiemTraSoVaKyHieuVBPhatHanh(String soVBPhatHanh,
			int issuingYear, long documentSendId) throws SystemException {

		return pmlEdmDocumentSendFinder.kiemTraSoVaKyHieuVBPhatHanh(
				soVBPhatHanh, issuingYear, documentSendId);
	}

	// end phmphuc 07/01/2010

	// By TriLTM
	public List<PmlEdmDocumentSend> findBy_R_B_F_T(String documentReference,
			String briefContent, Date fromDate, Date toDate,
			boolean andOperator, int start, int end, OrderByComparator obc)
			throws SystemException {
		return pmlEdmDocumentSendFinder.findBy_R_B_F_T(documentReference,
				briefContent, fromDate, toDate, andOperator, start, end, obc);
	}

	public int countBy_R_B_F_T(String documentReference, String briefContent,
			Date fromDate, Date toDate, boolean andOperator) {
		return pmlEdmDocumentSendFinder.countBy_R_B_F_T(documentReference,
				briefContent, fromDate, toDate, andOperator);
	}

	// End By TriLTM

	private static Log _log = LogFactory
			.getLog(PmlEdmDocumentSendLocalServiceImpl.class);
	
	/* phmphuc add methods replace Loai Van Ban by So Van Ban 16/02/2011 */
	public int countByDocumentSend_Users_Status_DangXuLy1(List<Long> userIds,
			long statusId, long soVanBan, String soKyHieu, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay) throws Exception {
		
		return pmlEdmDocumentSendFinder.countByDocumentSend_Users_Status_DangXuLy1(userIds,
				statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
		
		return pmlEdmDocumentSendFinder.findByDocumentSend_Users_Status_DangXuLy1(userIds,
				statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public int countByDocumentSend_Users_Status_DangXuLy_TreHan1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {
		
		return pmlEdmDocumentSendFinder.countByDocumentSend_Users_Status_DangXuLy_TreHan1(userIds,
				statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
		
		return pmlEdmDocumentSendFinder.findByDocumentSend_Users_Status_DangXuLy_TreHan1(userIds,
				statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung1(userId,	soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public int countListCVDiDaXuLyChung1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
		
		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public int countListCVDiDaXuLyTuXuLy1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
		
		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyChung_treHan1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public int countListCVDiDaXuLyChung_treHan1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
		
		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyChung_treHan1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		return pmlEdmDocumentSendFinder.getListCVDiDaXuLyTuXuLy_treHan1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
	}
	
	public int countListCVDiDaXuLyTuXuLy_treHan1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
		
		return pmlEdmDocumentSendFinder.countListCVDiDaXuLyTuXuLy_treHan1(userId, soVanBan, soKyHieu, 
				donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
	}
	/* end phmphuc update 16/02/2011 */
}
