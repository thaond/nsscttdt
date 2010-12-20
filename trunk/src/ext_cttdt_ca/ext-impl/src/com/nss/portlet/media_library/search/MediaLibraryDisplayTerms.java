package com.nss.portlet.media_library.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class MediaLibraryDisplayTerms extends DisplayTerms {
	public static final String TIEU_DE_MEDIA_LIBRARY = "tieuDeMediaLibrary";
	public static final String TEN_MEDIA_LIBRARY = "tenMediaLibrary";
	public static final String MA_MEDIA_CHU_DE = "maMediaChuDe";
	
	protected String tieuDeMediaLibrary;
	protected String tenMediaLibrary;
	protected long maMediaChuDe;
	
	public MediaLibraryDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tieuDeMediaLibrary = ParamUtil.getString(portletRequest, TIEU_DE_MEDIA_LIBRARY);
		tenMediaLibrary = ParamUtil.getString(portletRequest, TEN_MEDIA_LIBRARY);
		maMediaChuDe = ParamUtil.getLong(portletRequest, MA_MEDIA_CHU_DE, 0);
	}

	public String getTenMediaLibrary() {
		return tenMediaLibrary;
	}

	public void setTenMediaLibrary(String tenMediaLibrary) {
		this.tenMediaLibrary = tenMediaLibrary;
	}

	public long getMaMediaChuDe() {
		return maMediaChuDe;
	}

	public void setMaMediaChuDe(long maMediaChuDe) {
		this.maMediaChuDe = maMediaChuDe;
	}

	public String getTieuDeMediaLibrary() {
		return tieuDeMediaLibrary;
	}

	public void setTieuDeMediaLibrary(String tieuDeMediaLibrary) {
		this.tieuDeMediaLibrary = tieuDeMediaLibrary;
	}

}
