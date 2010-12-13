package com.nss.portlet.media_chu_de.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException;
import com.nss.portlet.media_chu_de.MediaChuDeTenChuDeException;
import com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.service.base.MediaChuDeLocalServiceBaseImpl;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil;


public class MediaChuDeLocalServiceImpl extends MediaChuDeLocalServiceBaseImpl {
	public List<MediaChuDe> findMediaChuDe(String tenMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return mediaChuDeFinder.findMediaChuDe(tenMediaChuDe, andOperator, start, end, obc);
	}
	public int countMediaChuDe(String tenMediaChuDe, boolean andOperator) throws SystemException {
		return mediaChuDeFinder.countMediaChuDe(tenMediaChuDe, andOperator);
	}
	
	protected void validate(String tenMediaChuDe)
	throws PortalException, SystemException {
		if (Validator.isNull(tenMediaChuDe)){
			throw new MediaChuDeTenChuDeException();
		}
	}
	
	protected void validateDeleteMediaChuDe(int mediaLibrarySize) throws MediaChuDeCanNotDeleteException {
		if (mediaLibrarySize > 0) {
			throw new MediaChuDeCanNotDeleteException();
		}
	}
	
	public void deleteMediaChuDe(long maMediaChuDe) throws MediaChuDeCanNotDeleteException, NoSuchMediaChuDeException, SystemException {
		List<MediaLibrary> mediaLibraryList = new ArrayList<MediaLibrary>();
		try {
			mediaLibraryList = MediaLibraryLocalServiceUtil.findByMaMediaChuDe_Active(maMediaChuDe, true);
		} catch (Exception e) {
			mediaLibraryList = new ArrayList<MediaLibrary>();
		}
		validateDeleteMediaChuDe(mediaLibraryList.size());
		mediaChuDePersistence.remove(maMediaChuDe);
	}
	
	public MediaChuDe addMediaChuDe(String tenMediaChuDe) throws PortalException, SystemException {
		validate(tenMediaChuDe);
		long maMediaChuDe = CounterLocalServiceUtil.increment();
		MediaChuDe mediaChuDe = mediaChuDePersistence.create(maMediaChuDe);
		mediaChuDe.setMaMediaChuDe(maMediaChuDe);
		mediaChuDe.setTenMediaChuDe(tenMediaChuDe);
		mediaChuDe.setActive(true);
		mediaChuDe = mediaChuDePersistence.update(mediaChuDe, false);
		return mediaChuDe;
	}
	
	public MediaChuDe updateMediaChuDe(long maMediaChuDe, String tenMediaChuDe) throws PortalException, SystemException {
		validate(tenMediaChuDe);
		MediaChuDe mediaChuDe = mediaChuDePersistence.findByPrimaryKey(maMediaChuDe);
		mediaChuDe.setTenMediaChuDe(tenMediaChuDe);
		mediaChuDe = mediaChuDePersistence.update(mediaChuDe, false);
		return mediaChuDe;
	}
	
	public List<MediaChuDe> findByActive(boolean active) {
		List<MediaChuDe> mediaChuDeList = new ArrayList<MediaChuDe>();
		try {
			mediaChuDeList = mediaChuDePersistence.findByActive(active);
		} catch (Exception e) {
			mediaChuDeList = new ArrayList<MediaChuDe>();
		}
		return mediaChuDeList;
		
	}
}
