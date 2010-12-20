package com.nss.portlet.media_library.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.service.base.MediaLibraryLocalServiceBaseImpl;


public class MediaLibraryLocalServiceImpl
    extends MediaLibraryLocalServiceBaseImpl {
	public int searchCount(String keywords) throws SystemException{
		return mediaLibraryFinder.countByKeywords(keywords);
	}
	
	public List<MediaLibrary> findMediaLibrary(String tieuDeMediaLibrary, String tenMediaLibrary, long maMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return mediaLibraryFinder.findMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary, maMediaChuDe, andOperator, start, end, obc);
	}
	
	public List<MediaLibrary> search(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return mediaLibraryFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public int countMediaLibrary(String tieuDeMediaLibrary,String tenMediaLibrary, long maMediaChuDe, boolean andOperator) throws SystemException {
		return mediaLibraryFinder.countMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary, maMediaChuDe, andOperator);
	}
	
	public List<MediaLibrary> findByMaMediaChuDe_Active(long maMediaChuDe, boolean active) {
		List<MediaLibrary> mediaLibraryList = new ArrayList<MediaLibrary>();
		try {
			mediaLibraryList = mediaLibraryPersistence.findByMaMediaChuDe_Active(maMediaChuDe, active);
		} catch (Exception e) {
			mediaLibraryList = new ArrayList<MediaLibrary>();
		}
		return mediaLibraryList;
	}
	
	public List<MediaLibrary> findByActive(boolean active) {
		List<MediaLibrary> mediaLibraryList = new ArrayList<MediaLibrary>();
		try {
			mediaLibraryList = mediaLibraryPersistence.findByActive(active);
		} catch (Exception e) {
			mediaLibraryList = new ArrayList<MediaLibrary>();
		}
		return mediaLibraryList;
	}
}
