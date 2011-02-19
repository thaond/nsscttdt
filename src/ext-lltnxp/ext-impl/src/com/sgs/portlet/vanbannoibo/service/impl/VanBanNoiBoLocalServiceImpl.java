package com.sgs.portlet.vanbannoibo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.vanbannoibo.service.base.VanBanNoiBoLocalServiceBaseImpl;
import com.sgs.portlet.vanbannoibo.util.TiepNhanVanBanIndexer;


public class VanBanNoiBoLocalServiceImpl extends VanBanNoiBoLocalServiceBaseImpl {
	
	private static Log _log = LogFactory.getLog(VanBanNoiBoLocalServiceImpl.class);
	
	public List<VanBanNoiBo> getVanBanNoiBoByYear(int year) throws SystemException{
		List<VanBanNoiBo> vanBanNoiBos = new ArrayList<VanBanNoiBo>();
		List<VanBanNoiBo> vanBanNoiBoAll = VanBanNoiBoLocalServiceUtil.getVanBanNoiBos(-1, -1);
		for(VanBanNoiBo vanBanNoiBo : vanBanNoiBoAll){
			if(vanBanNoiBo.getSoPhatSinhTheoNam() == year){
				vanBanNoiBos.add(vanBanNoiBo);
			}
		}
		return vanBanNoiBos;
	}
	
	public List<FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(long idVanBanNoiBo) throws SystemException{
		return vanBanNoiBoPersistence.getFileDinhKemVanBanNoiBos(idVanBanNoiBo);
	}
	
	public void reIndex(long companyId, VanBanNoiBo vanBanNoiBo) throws SearchException, SystemException {
		try {
			TiepNhanVanBanIndexer.updateDocumentReceipt(companyId, vanBanNoiBo);
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}
	
	public VanBanNoiBo addVanBanNoiBo(long companyId, VanBanNoiBo vanBanNoiBo) throws SystemException, SearchException {
		vanBanNoiBo.setNew(true);
		vanBanNoiBoPersistence.update(vanBanNoiBo, false);
		// re index
		reIndex(companyId, vanBanNoiBo);
		return vanBanNoiBo;
	}
	
	public VanBanNoiBo updateVanBanNoiBo(long companyId, VanBanNoiBo vanBanNoiBo) throws SystemException, SearchException {
		vanBanNoiBoPersistence.update(vanBanNoiBo, true);
		// re index
		reIndex(companyId, vanBanNoiBo);
		return vanBanNoiBo;
	}
	
	public void deleteVanBanNoiBo(long companyId, VanBanNoiBo vanBanNoiBo) throws SystemException, SearchException {
		vanBanNoiBoPersistence.remove(vanBanNoiBo);
		// re index
		reIndex(companyId, vanBanNoiBo);
	}
	
	public void deleteVanBanNoiBo(long companyId, long vanBanNoiBoId) throws PortalException, SystemException {
		vanBanNoiBoPersistence.remove(vanBanNoiBoId);
		// delete index
		TiepNhanVanBanIndexer.deleteVanBanNoiBo(companyId, vanBanNoiBoId);
	}
	
	@Override
	public void deleteVanBanNoiBo(long vanBanNoiBoId) throws PortalException, SystemException {
		throw new SystemException("Please use method: deleteVanBanNoiBo(long companyId, long vanBanNoiBoId)");
	}

	@Override
	public void deleteVanBanNoiBo(VanBanNoiBo vanBanNoiBo) throws SystemException {
		throw new SystemException("Please use method: deleteVanBanNoiBo(long companyId, VanBanNoiBo vanBanNoiBo)");
	}
	
	public void reIndex(String[] ids) throws SystemException, SearchException {

		long companyId = GetterUtil.getLong(ids[0]);
		List<VanBanNoiBo> vanBanNoiBos = vanBanNoiBoPersistence.findAll();
		for (VanBanNoiBo vanBanNoiBo : vanBanNoiBos) {
			try {
				com.liferay.portal.kernel.search.Document doc = TiepNhanVanBanIndexer.getVanBanNoiBo(companyId, vanBanNoiBo);
				SearchEngineUtil.addDocument(companyId, doc);
			} catch (Exception e) {
				_log.error("Reindexing " + vanBanNoiBo.getVanBanNoiBoId(), e);
			}
		}
	}
}
