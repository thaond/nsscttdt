package com.sgs.portlet.document.receipt.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ext.portlet.util.Constants;
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
import com.liferay.portal.model.User;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptDisplayTerms;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentReceiptLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.util.ReceiptIndexer;
import com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;

/**
 * @author lethanhtung
 * @author DienNH
 * @author XUAN CONG
 */
public class PmlEdmDocumentReceiptLocalServiceImpl extends
		PmlEdmDocumentReceiptLocalServiceBaseImpl {

	/**
	 * Lay tat ca user sap xep theo alphabe
	 * 
	 * @return
	 * @throws SystemException
	 */
	public List<User> getSortedListUser() throws SystemException {

		try {
			return pmlEdmDocumentReceiptFinder.getSortedListUser();
		} // end try
		catch (Exception ex) {
			return null;
		} // end catch
	}

	/**
	 * this method get a list of PmlEdmIssuingPlace by a list of
	 * PmlEdmDocumentReceipt
	 * 
	 * @param listDocumentReceipt
	 * @return a list of PmlEdmIssuingPlace object
	 */
	public List<PmlEdmIssuingPlace> getListIssuingPlace(
			List<PmlEdmDocumentReceipt> listDocumentReceipt) {

		List<PmlEdmIssuingPlace> retValue = new ArrayList<PmlEdmIssuingPlace>();
		PmlEdmIssuingPlace pmlEdmIssuingPlace = null;

		for (PmlEdmDocumentReceipt item : listDocumentReceipt) {
			String issuingPlaceId = item.getIssuingPlaceId();
			try {
				pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil
						.findByPrimaryKey(issuingPlaceId);
				retValue.add(pmlEdmIssuingPlace);
			} catch (NoSuchPmlEdmIssuingPlaceException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}

		return retValue;
	}

	/**
	 * @param issuingPlaceId
	 * @return
	 */
	private PmlEdmDocumentReceipt getDocumentReceipt(String issuingPlaceId) {

		PmlEdmDocumentReceipt retValue = null;

		try {
			retValue = PmlEdmDocumentReceiptUtil.findByIssuingPlaceId(
					issuingPlaceId).get(0);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by input params
	 * 
	 * @param list
	 *            : list of PmlEdmDocumentReceipt object
	 * @param briefContent
	 *            : ná»™i dung trĂ­ch yáº¿u
	 * @param signer
	 *            : ngá»«Æ¡i kĂ½
	 * @param dateArrive
	 *            : ngĂ y Ä‘áº¿n
	 * @param documentReference
	 *            : sá»‘ hiá»‡u cĂ´ng vÄƒn
	 * @param issuingPlace
	 *            : nÆ¡i phĂ¡t hĂ nh
	 * @param status
	 *            : tĂ¬nh tráº¡ng
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filter(List<PmlEdmDocumentReceipt> list,
			String briefContent, String signer, Date dateArrive,
			String documentReference, String issuingPlace, String status) {

		List<PmlEdmDocumentReceipt> retValue = filterByBriefContent(list,
				briefContent);
		retValue = filterBySigner(retValue, signer);
		retValue = filterByDateArrive(retValue, dateArrive);
		retValue = filterByDocumentReference(retValue, documentReference);
		retValue = filterByIssuingPlace(retValue, issuingPlace);
		retValue = filterByStatus(retValue, status);

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by status
	 * 
	 * @param list
	 * @param status
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterByStatus(
			List<PmlEdmDocumentReceipt> list, String status) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;

		if ((list == null) || (status == null) || status.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentReceipt item : list) {
			if (item.getStatus() != null) {
				if (item.getStatus().toUpperCase()
						.indexOf(status.toUpperCase()) != -1) {
					pmlEdmDocumentReceipt = item;
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}
		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by issuingPlace
	 * 
	 * @param list
	 * @param issuingPlace
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterByIssuingPlace(
			List<PmlEdmDocumentReceipt> list, String issuingPlace) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
		List<PmlEdmIssuingPlace> listIssuingPlace = getListIssuingPlace(list);

		if ((list == null) || (issuingPlace == null)
				|| issuingPlace.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmIssuingPlace item : listIssuingPlace) {
			if (item.getIssuingPlaceName() != null) {
				String issuingPlaceName = item.getIssuingPlaceName();
				String issuingPlaceId = item.getIssuingPlaceId();
				pmlEdmDocumentReceipt = getDocumentReceipt(issuingPlaceId);

				if (issuingPlaceName.toUpperCase().indexOf(
						issuingPlace.toUpperCase()) != -1) {
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by documentReference
	 * 
	 * @param list
	 * @param documentReference
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterByDocumentReference(
			List<PmlEdmDocumentReceipt> list, String documentReference) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;

		if ((list == null) || (documentReference == null)
				|| documentReference.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentReceipt item : list) {
			if (item.getDocumentReference() != null) {
				if (item.getDocumentReference().toUpperCase()
						.indexOf(documentReference.toUpperCase()) != -1) {
					pmlEdmDocumentReceipt = item;
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by dateArrive
	 * 
	 * @param list
	 * @param dateArrive
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterByDateArrive(
			List<PmlEdmDocumentReceipt> list, Date dateArrive) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
		if ((list == null) || (dateArrive == null)
				|| dateArrive.toString().equals("")) {
			return list;
		}
		for (PmlEdmDocumentReceipt item : list) {
			if (item.getDateArrive() != null) {
				if (item.getDateArrive().equals(dateArrive)) {
					pmlEdmDocumentReceipt = item;
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}
		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by signer
	 * 
	 * @param list
	 * @param signer
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterBySigner(
			List<PmlEdmDocumentReceipt> list, String signer) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;

		if ((list == null) || (signer == null) || signer.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentReceipt item : list) {
			if (item.getSigner() != null) {
				if (item.getSigner().toUpperCase()
						.indexOf(signer.toUpperCase()) != -1) {
					pmlEdmDocumentReceipt = item;
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}

		return retValue;
	}

	/**
	 * this method filter a list PmlEdmDocumentReceipt by briefContent
	 * 
	 * @param list
	 * @param briefContent
	 * @return a list of PmlEdmDocumentReceipt object
	 */
	public List<PmlEdmDocumentReceipt> filterByBriefContent(
			List<PmlEdmDocumentReceipt> list, String briefContent) {

		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;

		if ((list == null) || (briefContent == null)
				|| briefContent.equalsIgnoreCase("")) {
			return list;
		}

		for (PmlEdmDocumentReceipt item : list) {
			if (item.getBriefContent() != null) {
				if (item.getBriefContent().toUpperCase()
						.indexOf(briefContent.toUpperCase()) != -1) {
					pmlEdmDocumentReceipt = item;
					retValue.add(pmlEdmDocumentReceipt);
				}
			}
		}

		return retValue;
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soCVDen, String capGui)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soCVDen, capGui);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			int start, int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soCVDen, capGui, start, end, obc);
	}

	public int countByS_L_N_S_N_T_D_D_S_T(String soCVDen, String soVaoSo,
			String tuNgay, String denNgay, long soHSCV, long loaiCV,
			String noiPhatHanh, long trangThai, String nguoiKy, String trichYeu)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countByS_L_N_S_N_T_D_D_S_T(soCVDen,
				soVaoSo, tuNgay, denNgay, soHSCV, loaiCV, noiPhatHanh,
				trangThai, nguoiKy, trichYeu);
	}

	public List<PmlEdmDocumentReceipt> findByS_L_N_S_N_T_D_D_S_T(
			String soCVDen, String soVaoSo, String tuNgay, String denNgay,
			long soHSCV, long loaiCV, String noiPhatHanh, long trangThai,
			String nguoiKy, String trichYeu, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.findByS_L_N_S_N_T_D_D_S_T(soCVDen,
				soVaoSo, tuNgay, denNgay, soHSCV, loaiCV, noiPhatHanh,
				trangThai, nguoiKy, trichYeu, start, end, obc);
	}

	/**
	 * CHUYEN VIEN
	 */

	// ton dau ky
	public int countTonDauKyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTonDauKyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listTonDauKyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTonDauKyChuyenVien_CVDen(userId,
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countNhanTrongKyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listNhanTrongKyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listNhanTrongKyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// chua nhan
	public int countChuaNhanChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countChuaNhanChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listChuaNhanChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listChuaNhanChuyenVien_CVDen(userId,
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// nhan trong thang
	public int countNhanTrongThangChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, Date fromDate,
			Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countNhanTrongThangChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listNhanTrongThangChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listNhanTrongThangChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, fromDate, toDate,
				start, end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countDungHanDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDaXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countDungHanDangXuLyChuyenVien_CVDen(userId,
						documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
						toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDangXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDangXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDangXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDangXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDangXuLyChuyenVien_CVDen(
				userId, documentRecordTypeId, capGui, loaiVB, doMat, fromDate,
				toDate, start, end, obc);
	}

	/**
	 * PHONG BAN
	 */
	// ton dau ky
	public int countTonDauKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTonDauKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTonDauKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTonDauKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countNhanTrongKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listNhanTrongKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listNhanTrongKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// chua nhan trong ky
	public int countChuaNhanTrongKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countChuaNhanTrongKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listChuaNhanTrongKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listChuaNhanTrongKyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countDungHanDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDaXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countDungHanDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDangXuLyPhongBan_CVDen(
				departmentId, documentRecordTypeId, capGui, loaiVB, doMat,
				fromDate, toDate, start, end, obc);
	}

	/**
	 * TOAN CO QUAN
	 */

	// ton dau ky
	public int countTonDauKySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countTonDauKySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTonDauKySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTonDauKySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// nhan trong ky
	public int countNhanTrongKySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countNhanTrongKySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listNhanTrongKySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listNhanTrongKySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// da giai quyet dung han
	public int countDungHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countDungHanDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// da giai quyet tre han
	public int countTreHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// tong da giai quyet
	public int countTongDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDaXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// dang giai quyet dung han
	public int countDungHanDangXuLySo_CVDen(int documentRecordTypeId,
			int capGui, int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countDungHanDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listDungHanDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listDungHanDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// dang giai quyet tre han
	public int countTreHanDangXuLySo_CVDen(int documentRecordTypeId,
			int capGui, int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countTreHanDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTreHanDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTreHanDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	// tong dang giai quyet
	public int countTongDangXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countTongDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
	}

	public List<PmlEdmDocumentReceipt> listTongDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.listTongDangXuLySo_CVDen(
				documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
				start, end, obc);
	}

	/**
	 * author: Hai Trieu ham goi tinh tong so ngay nghi trong finderimpl
	 * 
	 * @param String
	 *            format date dd/MM/yyyy
	 * @return int
	 */
	public int totalDateOff(String dateNow, String dateCalen)
			throws SystemException {

		return pmlEdmDocumentReceiptFinder.countBy_Date_N_C(dateNow, dateCalen);
	}

	/**
	 * author: Hai Trieu Ham cong 1 so ngay vao ngay theo dinh dang dd/MM/yyyy
	 * 
	 * @param String
	 *            format date dd/MM/yyyy
	 * @param int numDate
	 * @return String Date Format dd/MM/yyyy
	 */
	public String addDateNum(String dateInput, int numDate)
			throws SystemException {

		// return pmlEdmDocumentReceiptFinder.countBy_Date_N_C(dateNow,
		// dateCalen);
		String dateReturn = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String d = dateInput.substring(0, 2);
			int dN = Integer.valueOf(d);
			String m = dateInput.substring(3, 5);
			int mN = Integer.valueOf(m);
			if (mN > 1) {
				mN = mN - 1;
			}
			String y = dateInput.substring(6, 10);
			int yN = Integer.valueOf(y);
			Calendar cal = Calendar.getInstance();
			cal.set(yN, mN, dN);
			cal.add(Calendar.DAY_OF_YEAR, numDate);
			dateReturn = sdf.format(cal.getTime());
		} catch (Exception e) {

		}
		return dateReturn;
	}

	public int getGeneralNumberDocumentReceipt(String ddmmyyyyReceiveDate)
			throws SystemException {

		try {
			return pmlEdmDocumentReceiptFinder
					.getGeneralNumberDocumentReceipt(ddmmyyyyReceiveDate);
		} catch (Exception ex) {
			return -1;
		}
	}

	/**
	 * So luong cong van den can xu ly cua nguoi dung
	 * 
	 * @author XUAN CONG
	 * @param userId
	 *            Ma so nguoi dung
	 * @return So luong cong van den can xu ly cua nguoi dung
	 * @throws SystemException
	 */
	public int countDocRecNeedProcess(long userId) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countDocRecNeedProcess(userId);
	}

	// minh update 25/11/2009
	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soCVDen, String capGui) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DangXuLy(userIds,
						statusId, soCVDen, capGui);
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soCVDen, String capGui, String cachThucXuLy)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DangXuLy(userIds,
						statusId, soCVDen, capGui, cachThucXuLy);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			int start, int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DangXuLy(userIds, statusId,
						soCVDen, capGui, start, end, obc);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			String cachThucXuLy, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DangXuLy(userIds, statusId,
						soCVDen, capGui, cachThucXuLy, start, end, obc);
	}

	public int countByDocumentReceipt_Users(List<Long> userIds, String capGui,
			String loaisocongvan) throws Exception {

		return pmlEdmDocumentReceiptFinder.countByDocumentReceipt_Users(
				userIds, capGui, loaisocongvan);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
			List<Long> userIds, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.findByDocumentReceipt_Users(userIds,
				capGui, loaisocongvan, start, end, obc);
	}

	// end

	/**
	 * So luong cong van den da xu ly cua user theo trang thai
	 * 
	 * @author DienNH
	 */
	public int countByDocumentReceipt_Users_Status_DaXuLy(List<Long> userIds,
			long statusId, int year, String soCVDen, String capGui)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DaXuLy(userIds, statusId,
						year, soCVDen, capGui);
	}

	/**
	 * Danh sach cong van den da xu ly cua user theo trang thai
	 * 
	 * @author DienNH
	 */
	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DaXuLy(userIds, statusId,
						year, soCVDen, capGui, start, end, obc);
	}

	/**
	 * So luong cong van den da xu ly tre han cua user theo trang thai
	 * 
	 * @author DienNH
	 */
	public int countByDocumentReceipt_Users_Status_DaXuLy_TreHan(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
						statusId, year, soCVDen, capGui);
	}

	/**
	 * Danh sach cong van den da xu ly tre han cua user theo trang thai
	 * 
	 * @author DienNH
	 */
	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy_TreHan(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
						statusId, year, soCVDen, capGui, start, end, obc);
	}

	/**
	 * Lay ma so lon nhat tu bang pml_edm_documentreceipt
	 */
	public long getMaxDocumentReceiptId() throws SystemException {

		try {
			return pmlEdmDocumentReceiptFinder.getMaxDocumentReceiptId();
		} catch (Exception ex) {
			return 0;
		}
	}

	// Canh update
	public void reIndex(long companyId, PmlEdmDocumentReceipt documentReceipt)
			throws SearchException, SystemException {

		try {
			ReceiptIndexer.updateDocumentReceipt(companyId, documentReceipt);
		} catch (UnsupportedEncodingException e) {
			throw new SearchException(e);
		}
	}

	public PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
			throws SystemException, SearchException {

		pmlEdmDocumentReceipt.setNew(true);
		pmlEdmDocumentReceiptPersistence.update(pmlEdmDocumentReceipt, false);

		// re index
		reIndex(companyId, pmlEdmDocumentReceipt);

		return pmlEdmDocumentReceipt;
	}

	public PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
			throws SystemException, SearchException {

		pmlEdmDocumentReceiptPersistence.update(pmlEdmDocumentReceipt, true);

		// re index
		reIndex(companyId, pmlEdmDocumentReceipt);

		return pmlEdmDocumentReceipt;
	}

	public void deletePmlEdmDocumentReceipt(long companyId,
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
			throws SystemException, SearchException {

		pmlEdmDocumentReceiptPersistence.remove(pmlEdmDocumentReceipt);

		// re index
		reIndex(companyId, pmlEdmDocumentReceipt);
	}

	public void deletePmlEdmDocumentReceipt(long companyId,
			long documentReceiptId) throws PortalException, SystemException {

		pmlEdmDocumentReceiptPersistence.remove(documentReceiptId);

		// delete index
		ReceiptIndexer.deleteDocumentReceipt(companyId, documentReceiptId);
	}

	@Override
	public void deletePmlEdmDocumentReceipt(long documentReceiptId)
			throws PortalException, SystemException {

		throw new SystemException(
				"Please use method: deletePmlEdmDocumentReceipt(long companyId, long documentReceiptId)");
	}

	@Override
	public void deletePmlEdmDocumentReceipt(
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws SystemException {

		throw new SystemException(
				"Please use method: deletePmlEdmDocumentReceipt(long companyId, PmlEdmDocumentReceipt pmlEdmDocumentReceipt)");
	}

	public PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(long companyId,
			String documentReference, String numberLocalDocumentReceipt,
			String issuingPlaceId, Date issuingDate, String signer,
			Date dateArrive, int processTime, boolean isPublic,
			int levelSendId, long documentTypeId, String confidentialLevelId,
			String privilegeLevelId, String briefContent)
			throws SystemException, SearchException {

		// create document
		long documentReceiptId = CounterLocalServiceUtil.increment();
		PmlEdmDocumentReceipt documentReceipt = pmlEdmDocumentReceiptPersistence
				.create(documentReceiptId);

		documentReceipt.setDocumentReceiptId(documentReceiptId);
		documentReceipt.setDocumentReference(documentReference);
		documentReceipt
				.setNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
		documentReceipt.setIssuingPlaceId(issuingPlaceId);
		documentReceipt.setIssuingDate(issuingDate);
		documentReceipt.setSigner(signer);
		documentReceipt.setDateArrive(dateArrive);
		documentReceipt.setProcessTime(processTime);
		documentReceipt.setIsPublic(isPublic ? "1" : "0");
		documentReceipt.setLevelSendId(levelSendId);
		documentReceipt.setDocumentTypeId(documentTypeId);
		documentReceipt.setConfidentialLevelId(confidentialLevelId);
		documentReceipt.setPrivilegeLevelId(privilegeLevelId);
		documentReceipt.setBriefContent(briefContent);
		documentReceipt.setActive(Constants.ACTIVE);
		// update document
		documentReceipt.setNew(true);
		pmlEdmDocumentReceiptPersistence.update(documentReceipt, false);
		// index
		reIndex(companyId, documentReceipt);

		return documentReceipt;
	}

	@Override
	public PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws SystemException {

		throw new SystemException(
				"Please use method: addPmlEdmDocumentReceipt(long companyId, PmlEdmDocumentReceipt pmlEdmDocumentReceipt)");
	}

	public PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(long companyId,
			long documentReceiptId, String documentReference,
			String numberLocalDocumentReceipt, String issuingPlaceId,
			Date issuingDate, String signer, Date dateArrive, int processTime,
			boolean isPublic, int levelSendId, long documentTypeId,
			String confidentialLevelId, String privilegeLevelId,
			String briefContent) throws NoSuchPmlEdmDocumentReceiptException,
			SystemException, SearchException {

		PmlEdmDocumentReceipt documentReceipt = pmlEdmDocumentReceiptPersistence
				.findByPrimaryKey(documentReceiptId);

		documentReceipt.setDocumentReceiptId(documentReceiptId);
		documentReceipt.setDocumentReference(documentReference);
		documentReceipt
				.setNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
		documentReceipt.setIssuingPlaceId(issuingPlaceId);
		documentReceipt.setIssuingDate(issuingDate);
		documentReceipt.setSigner(signer);
		documentReceipt.setDateArrive(dateArrive);
		documentReceipt.setProcessTime(processTime);
		documentReceipt.setIsPublic(isPublic ? "1" : "0");
		documentReceipt.setLevelSendId(levelSendId);
		documentReceipt.setDocumentTypeId(documentTypeId);
		documentReceipt.setConfidentialLevelId(confidentialLevelId);
		documentReceipt.setPrivilegeLevelId(privilegeLevelId);
		documentReceipt.setBriefContent(briefContent);
		documentReceipt.setActive(Constants.ACTIVE);
		// update document
		pmlEdmDocumentReceiptPersistence.update(documentReceipt, true);
		// index
		reIndex(companyId, documentReceipt);

		return documentReceipt;
	}

	public void reIndex(String[] ids) throws SystemException, SearchException {

		long companyId = GetterUtil.getLong(ids[0]);

		for (PmlEdmDocumentReceipt documentReceipt : pmlEdmDocumentReceiptPersistence
				.findAll()) {
			// Canh update 20110117
			try {
				com.liferay.portal.kernel.search.Document doc = ReceiptIndexer
						.getDocumentReceipt(companyId, documentReceipt);
				SearchEngineUtil.addDocument(companyId, doc);
			} catch (Exception e) {
				_log.error(
						"Reindexing " + documentReceipt.getDocumentReceiptId(),
						e);
			}
			// reIndex(companyId, documentReceipt);
			// End of Canh 20110117
		}
	}

	public Hits search(long companyId, String soCVDen, String soVaoSo,
			Date tuNgay, Date denNgay, long soHSCV, long loaiCV,
			String noiPhatHanh, long trangThai, String nguoiKy,
			String trichYeu, String active, int start, int end)
			throws SystemException {

		return search(companyId, soCVDen, soVaoSo, tuNgay, denNgay, soHSCV,
				loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu, active,
				"ngayDen", Sort.LONG_TYPE, start, end);

	}

	public Hits search(long companyId, String soCVDen, String soVaoSo,
			Date tuNgay, Date denNgay, long soHSCV, long loaiCV,
			String noiPhatHanh, long trangThai, String nguoiKy,
			String trichYeu, String active, String sortField, int sortType,
			int start, int end) throws SystemException {

		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		StringBuilder sb = new StringBuilder();

		sb.append("[");
		sb.append(tuNgay != null ? df.format(tuNgay) : "");
		sb.append(" TO ");
		sb.append(denNgay != null ? df.format(denNgay) : "");
		sb.append("]");

		try {
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();

			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					ReceiptIndexer.PORTLET_ID);

			BooleanQuery soCVDenQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soVaoSoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery ngayDenQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trangThaiQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> searchQuerys = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soCVDen)) {
				soCVDenQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, soCVDen);
				searchQuerys.add(soCVDenQuery);
			}
			if (Validator.isNotNull(soVaoSo)) {
				soVaoSoQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, soVaoSo);
				searchQuerys.add(soVaoSoQuery);
			}
			if (sb.length() > 6) {
				ngayDenQuery.addTerm("ngayDen", sb.toString());
				searchQuerys.add(ngayDenQuery);
			}
			if (soHSCV > 0) {
				soHSCVQuery.addTerm(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV,
						soHSCV);
				searchQuerys.add(soHSCVQuery);
			}
			if (loaiCV > 0) {
				loaiCVQuery.addTerm(PmlEdmDocumentReceiptDisplayTerms.LOAI_CV,
						loaiCV);
				searchQuerys.add(loaiCVQuery);
			}
			if (Validator.isNotNull(noiPhatHanh)) {
				noiPhatHanhQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH,
						noiPhatHanh);
				searchQuerys.add(noiPhatHanhQuery);
			}
			if (trangThai > 0) {
				trangThaiQuery
						.addTerm(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI,
								trangThai);
				searchQuerys.add(trangThaiQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, nguoiKy);
				searchQuerys.add(nguoiKyQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, trichYeu);
				searchQuerys.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				searchQuerys.add(activeQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < searchQuerys.size(); i++) {
				fullQuery.add(searchQuerys.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			if (sortField.equals("ngayDen")) {
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

	public Hits search(long companyId, String soCVDen, String soVaoSo,
			Date tuNgay, Date denNgay, long soHSCV, long loaiCV,
			String noiPhatHanh, long trangThai, String nguoiKy,
			String trichYeu, String active, String sortField, int sortType,
			boolean reverse, int start, int end) throws SystemException {

		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		StringBuilder sb = new StringBuilder();

		sb.append("[");
		sb.append(tuNgay != null ? df.format(tuNgay) : "");
		sb.append(" TO ");
		sb.append(denNgay != null ? df.format(denNgay) : "");
		sb.append("]");

		try {
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();

			contextQuery.addRequiredTerm(Field.PORTLET_ID,
					ReceiptIndexer.PORTLET_ID);

			BooleanQuery soCVDenQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soVaoSoQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery ngayDenQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery soHSCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiCVQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery noiPhatHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trangThaiQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery trichYeuQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery activeQuery = BooleanQueryFactoryUtil.create();

			List<BooleanQuery> searchQuerys = new ArrayList<BooleanQuery>();

			if (Validator.isNotNull(soCVDen)) {
				soCVDenQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, soCVDen);
				searchQuerys.add(soCVDenQuery);
			}
			if (Validator.isNotNull(soVaoSo)) {
				soVaoSoQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, soVaoSo);
				searchQuerys.add(soVaoSoQuery);
			}
			if (sb.length() > 6) {
				ngayDenQuery.addTerm("ngayDen", sb.toString());
				searchQuerys.add(ngayDenQuery);
			}
			if (soHSCV > 0) {
				soHSCVQuery.addTerm(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV,
						soHSCV);
				searchQuerys.add(soHSCVQuery);
			}
			if (loaiCV > 0) { // doi loai van ban thanh So van ban
				loaiCVQuery.addTerm(PmlEdmDocumentReceiptDisplayTerms.SOVANBAN,
						loaiCV);
				searchQuerys.add(loaiCVQuery);
			}
			if (Validator.isNotNull(noiPhatHanh)) {
				noiPhatHanhQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH,
						noiPhatHanh);
				searchQuerys.add(noiPhatHanhQuery);
			}
			if (trangThai > 0) {
				trangThaiQuery
						.addTerm(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI,
								trangThai);
				searchQuerys.add(trangThaiQuery);
			}
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, nguoiKy);
				searchQuerys.add(nguoiKyQuery);
			}
			if (Validator.isNotNull(trichYeu)) {
				trichYeuQuery.addTerm(
						PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, trichYeu);
				searchQuerys.add(trichYeuQuery);
			}
			if (Validator.isNotNull(active)) {
				activeQuery.addTerm("active", active);
				searchQuerys.add(activeQuery);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			for (int i = 0; i < searchQuerys.size(); i++) {
				fullQuery.add(searchQuerys.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;
			// Neu sap xep theo sovaoso thi doi qua sap xep thep generalorderno
			if (sortField
					.equalsIgnoreCase(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO)) {
				sort = new Sort(
						PmlEdmDocumentReceiptDisplayTerms.GENERALORDERNO,
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

	public int countByDocrefIssyearArrYear(String docRef, int issuingYear,
			boolean findIssuingYear, int arriveYear, boolean findArriveYear)
			throws SystemException {

		return pmlEdmDocumentReceiptFinder.countByDocrefIssyearArrYear(docRef,
				issuingYear, findIssuingYear, arriveYear, findArriveYear);
	}

	// yenlt update cvden da xu ly 08/04/2010
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(long userId,
			String year, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyChung(userId,
				year, capGui, loaisocongvan, start, end, obc);
	}

	public int countListCVDenDaXuLyChung(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyChung(userId,
				year, capGui, loaisocongvan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(long userId,
			String year, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyTuXuLy(userId,
				year, capGui, loaisocongvan, start, end, obc);
	}

	public int countListCVDenDaXuLyTuXuLy(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyTuXuLy(userId,
				year, capGui, loaisocongvan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
			long userId, String year, String capGui, String loaisocongvan,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyChung_treHan(
				userId, year, capGui, loaisocongvan, start, end, obc);
	}

	public int countListCVDenDaXuLyChung_treHan(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyChung_treHan(
				userId, year, capGui, loaisocongvan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
			long userId, String year, String capGui, String loaisocongvan,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyTuXuLy_treHan(
				userId, year, capGui, loaisocongvan, start, end, obc);
	}

	public int countListCVDenDaXuLyTuXuLy_treHan(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyTuXuLy_treHan(
				userId, year, capGui, loaisocongvan);
	}

	// end 08/04/2010

	public int countByN_D_I_L_I_P_D_D_D_B(String soNoiBo, String soHieuGoc,
			int ngayPHDay, int ngayPHMonth, int ngayPHYear, long capGui,
			String noiPhatHanh, String uuTien, int ngayDenDay,
			int ngayDenMonth, int ngayDenYear, long loaiVB, String phongBan,
			String trichYeu) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countByN_D_I_L_I_P_D_D_D_B(soNoiBo,
				soHieuGoc, ngayPHDay, ngayPHMonth, ngayPHYear, capGui,
				noiPhatHanh, uuTien, ngayDenDay, ngayDenMonth, ngayDenYear,
				loaiVB, phongBan, trichYeu);
	}

	public List<PmlEdmDocumentReceipt> findByN_D_I_L_I_P_D_D_D_B(
			String soNoiBo, String soHieuGoc, int ngayPHDay, int ngayPHMonth,
			int ngayPHYear, long capGui, String noiPhatHanh, String uuTien,
			int ngayDenDay, int ngayDenMonth, int ngayDenYear, long loaiVB,
			String phongBan, String trichYeu, int start, int end,
			OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.findByN_D_I_L_I_P_D_D_D_B(soNoiBo,
				soHieuGoc, ngayPHDay, ngayPHMonth, ngayPHYear, capGui,
				noiPhatHanh, uuTien, ngayDenDay, ngayDenMonth, ngayDenYear,
				loaiVB, phongBan, trichYeu, start, end, obc);
	}

	// yenlt 14/10/2010
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(long userId,
			String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyChung(userId,
				soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh,
				trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
	}

	public int countListCVDenDaXuLyChung(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyChung(userId,
				soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh,
				trichYeu, tuNgay, denNgay, ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(long userId,
			String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyTuXuLy(userId,
				soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh,
				trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
	}

	public int countListCVDenDaXuLyTuXuLy(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyTuXuLy(userId,
				soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh,
				trichYeu, tuNgay, denNgay, ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
			long userId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyChung_treHan(
				userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end,
				obc);
	}

	public int countListCVDenDaXuLyChung_treHan(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyChung_treHan(
				userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
			long userId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {

		return pmlEdmDocumentReceiptFinder.getListCVDenDaXuLyTuXuLy_treHan(
				userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end,
				obc);
	}

	public int countListCVDenDaXuLyTuXuLy_treHan(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countListCVDenDaXuLyTuXuLy_treHan(
				userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DangXuLy(userIds, statusId,
						soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
						noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan,
						start, end, obc);
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DangXuLy(userIds,
						statusId, soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay,
						ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay,
						ngayHetHan, start, end, obc);
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws Exception {

		return pmlEdmDocumentReceiptFinder
				.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay,
						ngayHetHan);
	}

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
			List<Long> userIds, String soVBDen, String soHieuGoc,
			int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.findByDocumentReceipt_Users(userIds,
				soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh,
				trichYeu, tuNgay, denNgay, start, end, obc);
	}

	public int countByDocumentReceipt_Users(List<Long> userIds, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay)
			throws Exception {

		return pmlEdmDocumentReceiptFinder.countByDocumentReceipt_Users(
				userIds, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay);
	}

	// end yenlt 14/10/2010

	/**
	 * phmphuc them cac phuong thuc lay ds log tuong tu nhu receipt muc dich lay
	 * noi dung yeu cau xu ly cho tung receipt 12/11/2010
	 */
	// chuyen vien dang xu ly
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceiptLog_Users_Status_DangXuLy(userIds,
						statusId, soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay,
						ngayHetHan, start, end, obc);
	}

	// chuyen vien xu ly tre han
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {

		return pmlEdmDocumentReceiptFinder
				.findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(userIds,
						statusId, soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay,
						ngayHetHan, start, end, obc);
	}

	// truong hop xu ly thay
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users(
			List<Long> userIds, String soVBDen, String soHieuGoc,
			int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end,
			OrderByComparator obc) throws Exception {

		return pmlEdmDocumentReceiptFinder.findByDocumentReceiptLog_Users(
				userIds, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
				noiBanHanh, trichYeu, tuNgay, denNgay, start, end, obc);
	}

	// end phmphuc add 12/11/2010

	/**
	 * phmphuc add Lien ket van ban
	 */
	/**
	 * Lay danh sach ma so van ban den theo so den, so noi bo, ngay den, noi
	 * phat hanh, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soVBDen
	 *            So van ban den (So hieu goc)
	 * @param soNoiBo
	 *            So noi bo
	 * @param tuNgay
	 *            Ngay den tu ngay
	 * @param denNgay
	 *            Ngay den den ngay
	 * @param noiPhatHanh
	 *            Noi phat hanh
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
	public List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(long companyId,
			String soVBDen, String soNoiBo, Date tuNgay, Date denNgay,
			String noiPhatHanh, String trichYeu, List<Long> notInDocIdRelation,
			String sortField, int sortType, boolean reverse)
			throws SystemException {

		List<Long> retVal = new ArrayList<Long>();
		try {
			long soHSCV = 0;
			long loaiVB = 0;
			long trangThai = 0;
			String nguoiKy = "";
			String active = "";
			int start = QueryUtil.ALL_POS;
			int end = QueryUtil.ALL_POS;
			Hits hits = search(companyId, soVBDen, soNoiBo, tuNgay, denNgay,
					soHSCV, loaiVB, noiPhatHanh, trangThai, nguoiKy, trichYeu,
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
					.println("Co loi trong ham searchBySD_SNB_ND_NPH_TY_noRelation cua file PmlEdmDocumentReceiptLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	/**
	 * Lay so luong ma so van ban den theo so den, so noi bo, ngay den, noi phat
	 * hanh, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soVBDen
	 *            So van ban den (So hieu goc)
	 * @param soNoiBo
	 *            So noi bo
	 * @param tuNgay
	 *            Ngay den tu ngay
	 * @param denNgay
	 *            Ngay den den ngay
	 * @param noiPhatHanh
	 *            Noi phat hanh
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @param notInDocIdRelation
	 *            Danh sach ma so van ban khong lay ve trong ket qua tra ve
	 * @return
	 * @throws SystemException
	 */
	public int countBySD_SNB_ND_NPH_TY_noRelation(long companyId,
			String soVBDen, String soNoiBo, Date tuNgay, Date denNgay,
			String noiPhatHanh, String trichYeu, List<Long> notInDocIdRelation)
			throws SystemException {

		int retVal = 0;
		try {
			String sortField = "";
			int sortType = Sort.STRING_TYPE;
			boolean reverse = false;
			List<Long> lstRes = searchBySD_SNB_ND_NPH_TY_noRelation(companyId,
					soVBDen, soNoiBo, tuNgay, denNgay, noiPhatHanh, trichYeu,
					notInDocIdRelation, sortField, sortType, reverse);
			if (!lstRes.isEmpty()) {
				// Tra ve so luong mau tin
				retVal = lstRes.size();
			}
		}

		catch (Exception ex) {
			System.out
					.println("Co loi trong ham countBySD_SNB_ND_NPH_TY_noRelation cua file PmlEdmDocumentReceiptLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	/**
	 * Lay danh sach ma so van ban den theo so den, so noi bo, ngay den, noi
	 * phat hanh, trich yeu
	 * 
	 * @param companyId
	 *            Dung de tim theo lucene
	 * @param soVBDen
	 *            So van ban den (So hieu goc)
	 * @param soNoiBo
	 *            So noi bo
	 * @param tuNgay
	 *            Ngay den tu ngay
	 * @param denNgay
	 *            Ngay den den ngay
	 * @param noiPhatHanh
	 *            Noi phat hanh
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
	public List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(long companyId,
			String soVBDen, String soNoiBo, Date tuNgay, Date denNgay,
			String noiPhatHanh, String trichYeu, List<Long> notInDocIdRelation,
			String sortField, int sortType, boolean reverse, int start, int end)
			throws SystemException {

		List<Long> retVal = new ArrayList<Long>();
		try {
			List<Long> lstRes = searchBySD_SNB_ND_NPH_TY_noRelation(companyId,
					soVBDen, soNoiBo, tuNgay, denNgay, noiPhatHanh, trichYeu,
					notInDocIdRelation, sortField, sortType, reverse);

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
					.println("Co loi trong ham searchBySD_SNB_ND_NPH_TY_noRelation cua file PmlEdmDocumentReceiptLocalServiceImpl.java.");
			ex.printStackTrace();
		}
		return retVal;
	}

	// end phmphuc add lien ket van ban

	// vu update 26122010
	//
	public List<PmlEdmDocumentReceipt> findBy_isPublic_mainDepartmentProcessId_Date(
			String isPublic, String mainDepartmentProcessId, String tuNgay,
			String denNgay, String listUserId, int start, int end,
			OrderByComparator order) throws SystemException {

		return pmlEdmDocumentReceiptFinder
				.findBy_isPublic_mainDepartmentProcessId_Date(isPublic,
						mainDepartmentProcessId, tuNgay, denNgay, listUserId,
						start, end, order);
	}

	public int countBy_isPublic_mainDepartmentProcessId_Date(String isPublic,
			String mainDepartmentProcessId, String tuNgay, String denNgay,
			String listUserId) throws SystemException {

		return pmlEdmDocumentReceiptFinder
				.countBy_isPublic_mainDepartmentProcessId_Date(isPublic,
						mainDepartmentProcessId, tuNgay, denNgay, listUserId);
	}

	// end

	// ham kiem tra so den theo so theo nam co ton tai trong csdl chua
	public int countByNumberDocumentReceipt(String numberDocumentReceipt,
			int issuingYear, long documentReceiptId) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countByNumberDocumentReceipt(
				numberDocumentReceipt, issuingYear, documentReceiptId);
	}

	// ham kiem tra so hieu trung cho edit
	public int countByDocumentReference(String documentReference,
			int issuingYear, long documentReceiptId) throws SystemException {

		return pmlEdmDocumentReceiptFinder.countByDocumentReference(
				documentReference, issuingYear, documentReceiptId);
	}

	private static Log _log = LogFactory
			.getLog(PmlEdmDocumentReceiptLocalServiceImpl.class);

	public PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(long companyId,
			String documentReference, String numberLocalDocumentReceipt,
			String issuingPlaceId, Date issuingDate, String signer,
			Date dateArrive, int processTime, boolean isPublic,
			int levelSendId, long documentTypeId, String confidentialLevelId,
			String privilegeLevelId, String briefContent, boolean IsVbqppl,
			String fieldId) throws SystemException, SearchException {

		// TODO Auto-generated method stub
		return null;
	}

	public PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(long companyId,
			long documentReceiptId, String documentReference,
			String numberLocalDocumentReceipt, String issuingPlaceId,
			Date issuingDate, String signer, Date dateArrive, int processTime,
			boolean isPublic, int levelSendId, long documentTypeId,
			String confidentialLevelId, String privilegeLevelId,
			String briefContent, boolean IsVbqppl, String fieldId)
			throws SystemException, SearchException,
			NoSuchPmlEdmDocumentReceiptException {

		// TODO Auto-generated method stub
		return null;
	}

	// TriLTM : Phương thức để đếm và lấy danh sách công văn đến thu thập cho hồ
	// sơ công việc
	public int countBy_R_B_F_T(String documentReference, String briefContent,
			Date fromDate, Date toDate, boolean andOperator) {
		return pmlEdmDocumentReceiptFinder.countBy_R_B_F_T(documentReference,
				briefContent, fromDate, toDate, andOperator);
	}

	public List<PmlEdmDocumentReceipt> findBy_R_B_F_T(String documentReference,
			String briefContent, Date fromDate, Date toDate,
			boolean andOperator, int start, int end, OrderByComparator obc)
			throws SystemException {
		return pmlEdmDocumentReceiptFinder.findBy_R_B_F_T(documentReference,
				briefContent, fromDate, toDate, andOperator, start, end, obc);
	}
}
