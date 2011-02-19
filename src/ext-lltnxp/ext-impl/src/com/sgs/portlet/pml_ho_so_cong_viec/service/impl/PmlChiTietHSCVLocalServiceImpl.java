package com.sgs.portlet.pml_ho_so_cong_viec.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.service.base.PmlChiTietHSCVLocalServiceBaseImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;

public class PmlChiTietHSCVLocalServiceImpl extends
		PmlChiTietHSCVLocalServiceBaseImpl {

	public List<PmlChiTietHSCV> getByIdHoSoCongViec(long idHoSoCongViec)
			throws SystemException {

		try {
			return pmlChiTietHSCVPersistence
					.findByIdHoSoCongViec(idHoSoCongViec);
		} catch (Exception ex) {
			return null;
		}
	}

	public int countByIdHoSoCongViec(long idHoSoCongViec)
			throws SystemException {

		try {
			return pmlChiTietHSCVPersistence
					.countByIdHoSoCongViec(idHoSoCongViec);
		} catch (Exception ex) {
			return 0;
		}
	}

	public int searchChiTietHSCVCVDENCount(long idHoSoCongViec,
			boolean andOperator) throws SystemException {

		return pmlChiTietHSCVFinder.countByCVDen(idHoSoCongViec, andOperator);
	}

	public List<PmlEdmDocumentReceipt> findChiTietHSCVCVDEN(
			long idHoSoCongViec, int start, int end, OrderByComparator obc)
			throws SystemException {

		return pmlChiTietHSCVFinder
				.findByCVDen(idHoSoCongViec, start, end, obc);
	}

	public List<PmlEdmAttachedFile> findByDocumentReceiptId(
			String idDocumentReceipt) throws SystemException {
		try {
			// return pmlHoSoCongViecFinder.countByID_T_C(idTrangThaiHSCV);
			String[] idDocumentReceiptList = idDocumentReceipt.split(",");

			if (idDocumentReceiptList.length > 0) {
				long[] idDocumentReceipts = new long[idDocumentReceiptList.length];
				// chuyen mang String sang mang long de goi ham tim file
				// attached cong van den
				for (int i = 0; i < idDocumentReceipts.length; i++) {

					idDocumentReceipts[i] = Long
							.valueOf(idDocumentReceiptList[i]);
				}
				// return
				// PmlEdmDocumentReceiptLocalServiceUtil.findIdDocumentReceipt(idDocumentReceipts);
				return pmlChiTietHSCVFinder
						.findBy_F_ATT_CVDEN(idDocumentReceipts);
			}

		} catch (Exception ex) {

		}
		return null;

	}

	public void removeChiTietHSCVCVDen(long idHoSoCongViec, long idCongVanDen)
			throws PortalException, SystemException {

		PmlChiTietHSCV pmlChiTietHSCV = pmlChiTietHSCVPersistence.findByH_DEN(
				idHoSoCongViec, idCongVanDen);

		long idChiTietHSCV = pmlChiTietHSCV.getIdChiTietHSCV();

		pmlChiTietHSCVPersistence.remove(idChiTietHSCV);

	}

	// //////////////////////////////////////
	public int searchChiTietHSCVCVDICount(long idHoSoCongViec,
			boolean andOperator) throws SystemException {

		return pmlChiTietHSCVFinder.countByCVDi(idHoSoCongViec, andOperator);
	}

	public List<PmlEdmDocumentSend> findChiTietHSCVCVDI(long idHoSoCongViec,
			int start, int end, OrderByComparator obc) throws SystemException {

		return pmlChiTietHSCVFinder.findByCVDi(idHoSoCongViec, start, end, obc);
	}

	public List<PmlEdmAttachedFile> findByDocumentReceiptId_Di(
			String idDocumentReceipt) throws SystemException {
		try {
			// return pmlHoSoCongViecFinder.countByID_T_C(idTrangThaiHSCV);
			String[] idDocumentReceiptList = idDocumentReceipt.split(",");

			if (idDocumentReceiptList.length > 0) {
				long[] idDocumentReceipts = new long[idDocumentReceiptList.length];
				// chuyen mang String sang mang long de goi ham tim file
				// attached cong van di
				for (int i = 0; i < idDocumentReceipts.length; i++) {

					idDocumentReceipts[i] = Long
							.valueOf(idDocumentReceiptList[i]);
				}
				// return
				// PmlEdmDocumentReceiptLocalServiceUtil.findIdDocumentReceipt(idDocumentReceipts);
				return pmlChiTietHSCVFinder
						.findBy_F_ATT_CVDI(idDocumentReceipts);
			}

		} catch (Exception ex) {

		}
		return null;

	}

	public void removeChiTietHSCVCVDi(long idHoSoCongViec, long idCongVanDi)
			throws PortalException, SystemException {

		PmlChiTietHSCV pmlChiTietHSCV = pmlChiTietHSCVPersistence.findByH_DI(
				idHoSoCongViec, idCongVanDi);

		long idChiTietHSCV = pmlChiTietHSCV.getIdChiTietHSCV();

		pmlChiTietHSCVPersistence.remove(idChiTietHSCV);

	}

	/**
	 * Lay cong van di dua vao ngay tao
	 * 
	 * @param idDocumentSend
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmWriteDocumentSend> findByDateCreateDocumentSend(
			String idDocumentSend) throws SystemException {
		try {
			String[] idDocumentSendList = idDocumentSend.split(",");

			if (idDocumentSendList.length > 0) {
				long[] idDocumentSends = new long[idDocumentSendList.length];
				// chuyen mang String sang mang long de goi ham tim Ngay tao
				// cong van di
				for (int i = 0; i < idDocumentSends.length; i++) {

					idDocumentSends[i] = Long.valueOf(idDocumentSendList[i]);
				}
				// return
				// PmlEdmDocumentReceiptLocalServiceUtil.findIdDocumentReceipt(idDocumentReceipts);
				return pmlChiTietHSCVFinder
						.findBy_CreateDateDocSend(idDocumentSends);
			}

		} catch (Exception ex) {

		}
		return null;
	}

	// Canh update
	public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen,
			int start, int end, OrderByComparator obc) throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDen(idCongVanDen,
				start, end, obc);
	}

	public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen,
			int start, int end) throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDen(idCongVanDen,
				start, end);
	}

	public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen)
			throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDen(idCongVanDen);
	}

	public int countByIdCongVanDen(long idCongVanDen, int start, int end,
			OrderByComparator obc) throws SystemException {
		return pmlChiTietHSCVPersistence.countByIdCongVanDen(idCongVanDen);
	}

	public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi, int start,
			int end, OrderByComparator obc) throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDi(idCongVanDi, start,
				end, obc);
	}

	public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi, int start,
			int end) throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDi(idCongVanDi, start,
				end);
	}

	public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi)
			throws SystemException {
		return pmlChiTietHSCVPersistence.findByIdCongVanDi(idCongVanDi);
	}

	public int countByIdCongVanDi(long idCongVanDi) throws SystemException {
		return pmlChiTietHSCVPersistence.countByIdCongVanDi(idCongVanDi);
	}

	// end of Canh

	/**
	 * Xoa chi tiet ho so cong viec dua vao ma so van ban den
	 */
	public int deletePmlChiTietHSCVByCVDenId(long docRecId) {
		int retVal = 0;

		try {
			if (docRecId > 0) {
				List<PmlChiTietHSCV> chiTietHSCVs = PmlChiTietHSCVUtil
						.findByIdCongVanDen(docRecId);
				for (PmlChiTietHSCV ctItem : chiTietHSCVs) {
					// Xoa chi tiet
					PmlChiTietHSCVUtil.remove(ctItem);
					// Tang so luong bi xoa
					retVal++;
				} // end for
			} // end if
		} // end try
		catch (Exception ex) {
			System.out
					.println("Co loi khi xoa chi tiet hscv theo ma so van ban den.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}

	/**
	 * Xoa chi tiet ho so cong viec dua vao ma so van ban di
	 */
	public int deletePmlChiTietHSCVByCVDiId(long docSendId) {
		int retVal = 0;

		try {
			if (docSendId > 0) {
				List<PmlChiTietHSCV> chiTietHSCVs = PmlChiTietHSCVUtil
						.findByIdCongVanDi(docSendId);
				for (PmlChiTietHSCV ctItem : chiTietHSCVs) {
					// Xoa chi tiet
					PmlChiTietHSCVUtil.remove(ctItem);
					// Tang so luong bi xoa
					retVal++;
				} // end for
			} // end if
		} // end try
		catch (Exception ex) {
			System.out
					.println("Co loi khi xoa chi tiet hscv theo ma so van ban di.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}

	// TriLTM
	public PmlChiTietHSCV findBy_IdHSCV_CVDen(long hoSoCongViecId,
			long documentReceiptId) throws SystemException {
		return pmlChiTietHSCVPersistence.fetchByH_DEN(hoSoCongViecId,
				documentReceiptId);
	}

	public PmlChiTietHSCV findBy_IdHSCV_CVDi(long hoSoCongViecId,
			long documentSendId) throws NoSuchPmlChiTietHSCVException,
			SystemException {
		return pmlChiTietHSCVPersistence.fetchByH_DI(hoSoCongViecId,
				documentSendId);
	}
}