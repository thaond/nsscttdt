package com.sgs.portlet.doccumentprivate.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class DocumentPrivateDisplayTearms extends DisplayTerms {

	public static final String SO_CV_DEN = "socvden";
	public static final String TU_NGAY = "tungay";
	public static final String DEN_NGAY = "denngay";
	public static final String LIST_USERID = "listUserId";
	
	protected String tuNgay;
	protected String denNgay;
	protected String listUserId;
	/**
	 * 
	 */
	public DocumentPrivateDisplayTearms(RenderRequest req) {
		// TODO Auto-generated constructor stub
		super(req);
		
		tuNgay = ParamUtil.getString(req, TU_NGAY);
		denNgay = ParamUtil.getString(req, DEN_NGAY);
		listUserId = ParamUtil.getString(req, LIST_USERID);
		
	}


	public String getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}
	public String getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}


	public String getListUserId() {
		return listUserId;
	}


	public void setListUserId(String listUserId) {
		this.listUserId = listUserId;
	}


	
	
}

