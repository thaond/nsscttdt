package com.sgs.portlet.pml_trang_thai_hscv.service.impl;

import java.util.Date;
import java.util.List;

import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil;
import com.sgs.portlet.pml_trang_thai_hscv.PmlTrangThaiHSCVCanNotDeleteException;
import com.sgs.portlet.pml_trang_thai_hscv.PmlTrangThaiHSCVTenTrangThaiHSCVException;

import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.service.base.PmlTrangThaiHSCVLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;


public class PmlTrangThaiHSCVLocalServiceImpl extends PmlTrangThaiHSCVLocalServiceBaseImpl {
	public PmlTrangThaiHSCV getPmlTrangThaiHSCV(long idTrangThaiHSCV)
	throws PortalException, SystemException {
		
		return pmlTrangThaiHSCVPersistence.findByPrimaryKey(idTrangThaiHSCV);
	}
	public int searchCount(boolean andOperator)
		throws SystemException {

		return pmlTrangThaiHSCVFinder.countByC_G(andOperator);
	}
	public List<PmlTrangThaiHSCV> search(boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		return pmlTrangThaiHSCVFinder.findByC_G(andOperator, 
				start, end, obc);
	}
	
	public PmlTrangThaiHSCV addPmlTrangThaiHSCV( String tenTrangThaiHSCV)
		throws PortalException, SystemException {

		// Check inputted value
		validate(tenTrangThaiHSCV);

		long idTrangThaiHSCV = counterLocalService.increment();
		
		PmlTrangThaiHSCV pmlTrangThaiHSCV = pmlTrangThaiHSCVPersistence.create(idTrangThaiHSCV);

		// Set properties value
		pmlTrangThaiHSCV.setTenTrangThaiHSCV(tenTrangThaiHSCV);
		
		pmlTrangThaiHSCVPersistence.update(pmlTrangThaiHSCV, false);

		return pmlTrangThaiHSCV;
	}
	
	protected void validate(String tenTrangThaiHSCV)
		throws PortalException, SystemException {
		
		// Check tenTrangThaiHSCV
		if (Validator.isNull(tenTrangThaiHSCV)){
			throw new PmlTrangThaiHSCVTenTrangThaiHSCVException();
		}
	}

	protected void validatePmlTrangThaiHSCV(int idTrangThaiHSCV)
	throws PortalException, SystemException {
	
	// Check idTrangThaiHSCV
		if (idTrangThaiHSCV != 0){
			throw new PmlTrangThaiHSCVCanNotDeleteException();
		}
	}
	
	public PmlTrangThaiHSCV updatePmlTrangThaiHSCV( long idTrangThaiHSCV, 
			String tenTrangThaiHSCV)
		throws PortalException, SystemException {

		// Checking inputted values
		validate(tenTrangThaiHSCV);

		PmlTrangThaiHSCV oldPmlTrangThaiHSCV = pmlTrangThaiHSCVPersistence.findByPrimaryKey(idTrangThaiHSCV);

		// Updated properties
		oldPmlTrangThaiHSCV.setTenTrangThaiHSCV(tenTrangThaiHSCV);
		
		pmlTrangThaiHSCVPersistence.update(oldPmlTrangThaiHSCV, false);

		return oldPmlTrangThaiHSCV;
	}
	
	public List<PmlTrangThaiHSCV> getAll() 
	throws SystemException, PortalException {
		
		try {
			return pmlTrangThaiHSCVPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public void removePmlTrangThaiHSCV(String idTrangThaiHSCV) 
	throws PortalException, SystemException{
		int pmlIdTrangThaiHSCV = PmlHoSoCongViecLocalServiceUtil.findByHSCVIdTrangThaiHSCV(idTrangThaiHSCV);
		validatePmlTrangThaiHSCV(pmlIdTrangThaiHSCV);
		
		String[] idTrangThaiHSCVList = idTrangThaiHSCV.split(",");
		
		if (idTrangThaiHSCVList.length >0) {
			long [] idTrangThaiHSCVs = new long[idTrangThaiHSCVList.length];
			// chuyen mang String sang mang long de goi ham tim id_trang_thai_hscv
			for (int i = 0; i < idTrangThaiHSCVs.length; i++){
				
				idTrangThaiHSCVs[i] = Long.valueOf(idTrangThaiHSCVList[i]);
				
				pmlTrangThaiHSCVPersistence.remove(idTrangThaiHSCVs[i]);
			}
			
		}	
	}
}
