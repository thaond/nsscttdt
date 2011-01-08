package com.sgs.portlet.pml_ho_so_cong_viec.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecHanXuLyException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecNgayMoHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecReferenceException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecSoHieuHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecTieuDeException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecUserIdException;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.base.PmlHoSoCongViecLocalServiceBaseImpl;

/**
 * <a href="PmlHoSoCongViecLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecLocalServiceImpl
    extends PmlHoSoCongViecLocalServiceBaseImpl {

	public int searchCount(String keywords)
	throws SystemException {
		
		return pmlHoSoCongViecFinder.countByKeywords(keywords);
	}
	
	public int searchCount(
			String soHieuHSCV, String tieuDe, Date ngayMoHSCV, String idLinhVuc, 
			String vanDeLienQuan, long idDoQuanTrong, long idTrangThaiHSCV, 
			String tomTatNoiDung, String hoatDong, boolean andOperator)
		throws SystemException {

		return pmlHoSoCongViecFinder.countByS_T_N_I_V_I_I_T_H(
				soHieuHSCV, tieuDe, ngayMoHSCV, idLinhVuc, vanDeLienQuan, 
				idDoQuanTrong, idTrangThaiHSCV, tomTatNoiDung, hoatDong, andOperator);
	}

	public List<PmlHoSoCongViec> search(String keywords, 
			int start, int end, OrderByComparator obc) 
	throws SystemException {
		
		return pmlHoSoCongViecFinder.findByKeywords(
				keywords, start, end, obc);
	}
	
	public List<PmlHoSoCongViec> search(
			String soHieuHSCV, String tieuDe, Date ngayMoHSCV, String idLinhVuc, 
			String vanDeLienQuan, long idDoQuanTrong, long idTrangThaiHSCV, 
			String tomTatNoiDung, String hoatDong, boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		return pmlHoSoCongViecFinder.findByS_T_N_I_V_I_I_T_H(
				soHieuHSCV, tieuDe, ngayMoHSCV, idLinhVuc, vanDeLienQuan, idDoQuanTrong,
				idTrangThaiHSCV, tomTatNoiDung, hoatDong, andOperator, start, end, obc);
	}
	
	public PmlHoSoCongViec getPmlHoSoCongViec(long idHoSoCongViec) 
	throws PortalException, SystemException {
		
		try {
			return pmlHoSoCongViecPersistence.findByPrimaryKey(idHoSoCongViec);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public PmlHoSoCongViec addPmlHoSoCongViec(
			long userId, long idHSCVCha, String soHieuHSCV, String tieuDe, 
			int ngayMoHSCVMonth, int ngayMoHSCVDay, int ngayMoHSCVYear, 
			int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,  
			String idLinhVuc, String vanDeLienQuan, long idDoQuanTrong, 
			long idTinhChat, long idTrangThaiHSCV , String tomTatNoiDung, 
			String hoatDong)
		throws PortalException, SystemException {

		// Parse date from inputted values
		Date ngayMoHSCV = PortalUtil.getDate(ngayMoHSCVMonth, ngayMoHSCVDay, ngayMoHSCVYear, new PmlHoSoCongViecNgayMoHSCVException());
		Date hanXuLy = PortalUtil.getDate(hanXuLyMonth, hanXuLyDay, hanXuLyYear, new PmlHoSoCongViecHanXuLyException());
		
		// Check inputted value
		validate(userId, soHieuHSCV, tieuDe, ngayMoHSCV, hanXuLy);

		User user = userPersistence.findByPrimaryKey(userId);
		
		long idHoSoCongViec = counterLocalService.increment();
		
		PmlHoSoCongViec pmlHoSoCongViec = pmlHoSoCongViecPersistence.create(idHoSoCongViec);

		// Set properties value
		pmlHoSoCongViec.setUserId(user.getUserId());
		pmlHoSoCongViec.setIdHSCVCha(idHSCVCha);
		pmlHoSoCongViec.setUserName(user.getLastName().concat(" ") + user.getMiddleName().concat(" ") + user.getFirstName());
		pmlHoSoCongViec.setSoHieuHSCV(soHieuHSCV);
		pmlHoSoCongViec.setTieuDe(tieuDe);
		pmlHoSoCongViec.setNgayMoHSCV(ngayMoHSCV);
		pmlHoSoCongViec.setHanXuLy(hanXuLy);
		pmlHoSoCongViec.setIdLinhVuc(idLinhVuc);
		pmlHoSoCongViec.setVanDeLienQuan(vanDeLienQuan);
		pmlHoSoCongViec.setIdDoQuanTrong(idDoQuanTrong);
		pmlHoSoCongViec.setIdTinhChat(idTinhChat);
		pmlHoSoCongViec.setIdTrangThaiHSCV(idTrangThaiHSCV);
		pmlHoSoCongViec.setTomTatNoiDung(tomTatNoiDung);
		pmlHoSoCongViec.setHoatDong(hoatDong);
		
		pmlHoSoCongViecPersistence.update(pmlHoSoCongViec, false);

		return pmlHoSoCongViec;
	}
	
	protected void validate(
			long userId, String soHieuHSCV, String tieuDe, Date ngayMoHSCV, 
			Date hanXuLy)
		throws PortalException, SystemException {
		
		// Check userId
		try {
			userPersistence.findByPrimaryKey(userId);
		}
		catch (Exception ex) {
			throw new PmlHoSoCongViecUserIdException();
		}
		// Check soHieuHSCV
		if (Validator.isNull(soHieuHSCV)){
			throw new PmlHoSoCongViecSoHieuHSCVException();
		}
		else {
			soHieuHSCV = soHieuHSCV.trim();
			List<PmlHoSoCongViec> pmlHSCVSearches = pmlHoSoCongViecPersistence.findBySoHieuHSCV(soHieuHSCV);
			if (pmlHSCVSearches != null && pmlHSCVSearches.size() > 0) {
				throw new PmlHoSoCongViecSoHieuHSCVException();
			}
		}
		// Check tieuDe
		if (Validator.isNull(tieuDe)) {
			throw new PmlHoSoCongViecTieuDeException();
		}
		// Check hanXuLy
		if (Validator.isNotNull(ngayMoHSCV) && Validator.isNotNull(hanXuLy) && !hanXuLy.after(ngayMoHSCV)){
			throw new PmlHoSoCongViecHanXuLyException();
		}
	}

	protected void validate(
			long userId, String soHieuHSCV, String tieuDe, Date ngayMoHSCV, 
			Date hanXuLy, long idHoSoCongViec)
		throws PortalException, SystemException {
		
		// Check userId
		try {
			userPersistence.findByPrimaryKey(userId);
		}
		catch (Exception ex) {
			throw new PmlHoSoCongViecUserIdException();
		}
		// Check soHieuHSCV
		if (Validator.isNull(soHieuHSCV)){
			throw new PmlHoSoCongViecSoHieuHSCVException();
		}
		else {
			soHieuHSCV = soHieuHSCV.trim();
			int countSame = countByI_S(idHoSoCongViec, soHieuHSCV);
			if (countSame > 0) {
				throw new PmlHoSoCongViecSoHieuHSCVException();
			}
		}
		// Check tieuDe
		if (Validator.isNull(tieuDe)) {
			throw new PmlHoSoCongViecTieuDeException();
		}
		// Check hanXuLy
		if (Validator.isNotNull(ngayMoHSCV) && Validator.isNotNull(hanXuLy) && !hanXuLy.after(ngayMoHSCV)){
			throw new PmlHoSoCongViecHanXuLyException();
		}
	}

	public PmlHoSoCongViec updatePmlHoSoCongViec(
			long idHoSoCongViec, long userId, long idHSCVCha, String soHieuHSCV, String tieuDe, 
			int ngayMoHSCVMonth, int ngayMoHSCVDay, int ngayMoHSCVYear, 
			int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,  
			String idLinhVuc, String vanDeLienQuan, long idDoQuanTrong, 
			long idTinhChat, long idTrangThaiHSCV , String tomTatNoiDung, 
			String hoatDong)
		throws PortalException, SystemException {

		// Parse date from inputted values
		Date ngayMoHSCV = PortalUtil.getDate(ngayMoHSCVMonth, ngayMoHSCVDay, ngayMoHSCVYear, new PmlHoSoCongViecNgayMoHSCVException());
		Date hanXuLy = PortalUtil.getDate(hanXuLyMonth, hanXuLyDay, hanXuLyYear, new PmlHoSoCongViecHanXuLyException());

		// Checking inputted values
		validate(userId, soHieuHSCV, tieuDe, ngayMoHSCV, hanXuLy, idHoSoCongViec);

		User user = userPersistence.findByPrimaryKey(userId);
		
		PmlHoSoCongViec oldPmlHoSoCongViec = pmlHoSoCongViecPersistence.findByPrimaryKey(idHoSoCongViec);

		// Updated properties
		oldPmlHoSoCongViec.setUserId(user.getUserId());
		oldPmlHoSoCongViec.setUserName(user.getLastName().concat(" ") + user.getMiddleName().concat(" ") + user.getFirstName());
		oldPmlHoSoCongViec.setIdHSCVCha(idHSCVCha);
		oldPmlHoSoCongViec.setSoHieuHSCV(soHieuHSCV);
		oldPmlHoSoCongViec.setTieuDe(tieuDe);
		oldPmlHoSoCongViec.setNgayMoHSCV(ngayMoHSCV);
		oldPmlHoSoCongViec.setHanXuLy(hanXuLy);
		oldPmlHoSoCongViec.setIdLinhVuc(idLinhVuc);
		oldPmlHoSoCongViec.setVanDeLienQuan(vanDeLienQuan);
		oldPmlHoSoCongViec.setIdDoQuanTrong(idDoQuanTrong);
		oldPmlHoSoCongViec.setIdTinhChat(idTinhChat);
		oldPmlHoSoCongViec.setIdTrangThaiHSCV(idTrangThaiHSCV);
		oldPmlHoSoCongViec.setTomTatNoiDung(tomTatNoiDung);
		oldPmlHoSoCongViec.setHoatDong(hoatDong);
		
		pmlHoSoCongViecPersistence.update(oldPmlHoSoCongViec, false);

		return oldPmlHoSoCongViec;
	}

	public int countByI_S (
			long idHoSoCongViec, String soHieuHSCV)
	throws SystemException, PortalException {
		
		return pmlHoSoCongViecFinder.countByI_S(idHoSoCongViec, soHieuHSCV);
	}
	
	public List<PmlHoSoCongViec> getAll() 
	throws PortalException, SystemException {
	
		try {
			return pmlHoSoCongViecPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public List<User> getAllUsers() 
	throws SystemException {
		
		try {
			return userPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public List<PmlHoSoCongViec> getByIdHSCVCha(
			long idHSCVCha) 
	throws SystemException {
		
		try {
			return pmlHoSoCongViecPersistence.findByIdHSCVCha(idHSCVCha);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public void deletePmlHoSoCongViec(
			long delPmlHSCVId) 
	throws SystemException, PortalException {
		
		if (delPmlHSCVId <= 0) return;
		
		// Kiem tra co chi tiet
		List<PmlChiTietHSCV> pmlChiTietHSCVs = null;
		try {
			pmlChiTietHSCVs = PmlChiTietHSCVLocalServiceUtil.getByIdHoSoCongViec(delPmlHSCVId);
		}
		catch (Exception ex) {
			// Do nothing
		}
		if (pmlChiTietHSCVs != null && pmlChiTietHSCVs.size() > 0) {
			throw new PmlHoSoCongViecReferenceException();
		}
		// Kiem tra quan he cha con trong bang
		List<PmlHoSoCongViec> pmlHoSoCongViecs = null;
		try {
			pmlHoSoCongViecs = getByIdHSCVCha(delPmlHSCVId);
		}
		catch (Exception ex) {
			// Do nothing
		}
		
		if (pmlHoSoCongViecs != null && pmlHoSoCongViecs.size() > 0) {
			throw new PmlHoSoCongViecReferenceException();
		}
		// Delete item
		pmlHoSoCongViecPersistence.remove(delPmlHSCVId);
	}

	public void expirePmlHoSoCongViec(
			long expPmlHSCVId) 
	throws SystemException, PortalException {
		
		PmlHoSoCongViec expItem = pmlHoSoCongViecPersistence.findByPrimaryKey(expPmlHSCVId);
		
		String oldHoatDong = expItem.getHoatDong();
		if (oldHoatDong.equals("1")) {
			oldHoatDong = "0";
		}
		else {
			oldHoatDong = "1";
		}
		
		expItem.setHoatDong(oldHoatDong);
		pmlHoSoCongViecPersistence.update(expItem, false);
	}

	public List<PmlHoSoCongViec> findByIdTinhChat(long idTinhChat) 
	throws PortalException, SystemException {
	
		try {
			return pmlHoSoCongViecPersistence.findByIdTinhChat(idTinhChat);
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	public List<PmlHoSoCongViec> findByIdDoQuanTrong(long idDoQuanTrong) 
	throws PortalException, SystemException {
	
		try {
			return pmlHoSoCongViecPersistence.findByIdDoQuanTrong(idDoQuanTrong);
		}
		catch(Exception ex) {
			return null;
		}
	}
	public List<PmlHoSoCongViec> findByIdTrangThaiHSCV(long idTrangThaiHSCV) 
	throws PortalException, SystemException {
	
		try {
			return pmlHoSoCongViecPersistence.findByIdTrangThaiHSCV(idTrangThaiHSCV);
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	public int findByHSCVIdTrangThaiHSCV(String idTrangThaiHSCV) throws SystemException{
		int count = 0;
		try {
			//return pmlHoSoCongViecFinder.countByID_T_C(idTrangThaiHSCV);
			String[] idTrangThaiHSCVList = idTrangThaiHSCV.split(",");
			
			if (idTrangThaiHSCVList.length >0) {
				long [] idTrangThaiHSCVs = new long[idTrangThaiHSCVList.length];
				// chuyen mang String sang mang long de goi ham tim id_tinh_chat
				for (int i = 0; i < idTrangThaiHSCVs.length; i++){
					
					idTrangThaiHSCVs[i] = Long.valueOf(idTrangThaiHSCVList[i]);
					
				}
				
				 count =  pmlHoSoCongViecFinder.countByID_T_T_HSCV(idTrangThaiHSCVs);
				return count;
			}			
			
		} catch(Exception ex){
			return 0;
		}
		if (count != 0)
			return count;
		else 
			return count;
	}
	
	public int findByHSCVIdTinhChat(String idTinhChat) throws SystemException{
		int count = 0;
		try {
			//return pmlHoSoCongViecFinder.countByID_T_C(idTinhChat);
			String[] idTinhChatList = idTinhChat.split(",");
			
			if (idTinhChatList.length >0) {
				long [] idTinhChats = new long[idTinhChatList.length];
				// chuyen mang String sang mang long de goi ham tim id_tinh_chat
				for (int i = 0; i < idTinhChats.length; i++){
					
					idTinhChats[i] = Long.valueOf(idTinhChatList[i]);
					
				}
				
				 count =  pmlHoSoCongViecFinder.countByID_T_C(idTinhChats);
				return count;
			}			
			
		} catch(Exception ex){
			return 0;
		}
		if (count != 0)
			return count;
		else 
			return count;
	}
	
	public int findByHSCVIdDoQuanTrong(String idDoQuanTrong) throws SystemException{
		int count = 0;
		try {
			//return pmlHoSoCongViecFinder.countByID_T_C(idDoQuanTrong);
			String[] idDoQuanTrongList = idDoQuanTrong.split(",");
			
			if (idDoQuanTrongList.length >0) {
				long [] idDoQuanTrongs = new long[idDoQuanTrongList.length];
				// chuyen mang String sang mang long de goi ham tim id_tinh_chat
				for (int i = 0; i < idDoQuanTrongs.length; i++){
					
					idDoQuanTrongs[i] = Long.valueOf(idDoQuanTrongList[i]);
					
				}
				
				 count =  pmlHoSoCongViecFinder.countByID_D_Q_T(idDoQuanTrongs);
				return count;
			}			
			
		} catch(Exception ex){
			return 0;
		}
		if (count != 0)
			return count;
		else 
			return count;
	}
}
