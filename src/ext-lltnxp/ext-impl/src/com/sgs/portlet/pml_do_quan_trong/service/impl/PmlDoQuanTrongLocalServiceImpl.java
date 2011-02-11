package com.sgs.portlet.pml_do_quan_trong.service.impl;

import java.util.Date;
import java.util.List;

import com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongTenDoQuanTrongException;

import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.service.base.PmlDoQuanTrongLocalServiceBaseImpl;
import com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongCanNotDeleteException;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;


public class PmlDoQuanTrongLocalServiceImpl extends PmlDoQuanTrongLocalServiceBaseImpl {
	public PmlDoQuanTrong getPmlDoQuanTrong(long idDoQuanTrong)
	throws PortalException, SystemException {
		
		return pmlDoQuanTrongPersistence.findByPrimaryKey(idDoQuanTrong);
	}
	public int searchCount(boolean andOperator)
		throws SystemException {

		return pmlDoQuanTrongFinder.countByC_G(andOperator);
	}
	public List<PmlDoQuanTrong> search(boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		return pmlDoQuanTrongFinder.findByC_G(andOperator, 
				start, end, obc);
	}
	
	public PmlDoQuanTrong addPmlDoQuanTrong( String tenDoQuanTrong)
		throws PortalException, SystemException {

		// Check inputted value
		validate(tenDoQuanTrong);

		long idDoQuanTrong = counterLocalService.increment();
		
		PmlDoQuanTrong pmlDoQuanTrong = pmlDoQuanTrongPersistence.create(idDoQuanTrong);

		// Set properties value
		pmlDoQuanTrong.setTenDoQuanTrong(tenDoQuanTrong);
		
		pmlDoQuanTrongPersistence.update(pmlDoQuanTrong, false);

		return pmlDoQuanTrong;
	}
	
	protected void validate(String tenDoQuanTrong)
		throws PortalException, SystemException {
		
		// Check tenDoQuanTrong
		if (Validator.isNull(tenDoQuanTrong)){
			throw new PmlDoQuanTrongTenDoQuanTrongException();
		}
	}
	protected void validatePmlDoQuanTrong(int idDoQuanTrong)
	throws PortalException, SystemException {
	
		// Check idDoQuanTrong
		if (idDoQuanTrong != 0){
			throw new PmlDoQuanTrongCanNotDeleteException();
		}
	}

	public PmlDoQuanTrong updatePmlDoQuanTrong( long idDoQuanTrong, 
			String tenDoQuanTrong)
		throws PortalException, SystemException {

		// Checking inputted values
		validate(tenDoQuanTrong);

		PmlDoQuanTrong oldPmlDoQuanTrong = pmlDoQuanTrongPersistence.findByPrimaryKey(idDoQuanTrong);

		// Updated properties
		oldPmlDoQuanTrong.setTenDoQuanTrong(tenDoQuanTrong);
		
		pmlDoQuanTrongPersistence.update(oldPmlDoQuanTrong, false);

		return oldPmlDoQuanTrong;
	}
	
	public List<PmlDoQuanTrong> getAll() 
	throws SystemException, PortalException {
		
		try {
			return pmlDoQuanTrongPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public void removePmlDoQuanTrong(String idDoQuanTrong) 
	throws PortalException, SystemException{
		int pmlIdDoQuanTrong = PmlHoSoCongViecLocalServiceUtil.findByHSCVIdDoQuanTrong(idDoQuanTrong);
		validatePmlDoQuanTrong(pmlIdDoQuanTrong);
		
		String[] idDoQuanTrongList = idDoQuanTrong.split(",");
		
		if (idDoQuanTrongList.length >0) {
			long [] idDoQuanTrongs = new long[idDoQuanTrongList.length];
			// chuyen mang String sang mang long de goi ham tim id_do_quan_trong
			for (int i = 0; i < idDoQuanTrongs.length; i++){
				
				idDoQuanTrongs[i] = Long.valueOf(idDoQuanTrongList[i]);
				
				pmlDoQuanTrongPersistence.remove(idDoQuanTrongs[i]);
			}
			
		}	
	}
}
