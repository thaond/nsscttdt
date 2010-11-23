package com.nss.portlet.qa_phan_quyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.service.base.QAPhanQuyenLocalServiceBaseImpl;


public class QAPhanQuyenLocalServiceImpl extends QAPhanQuyenLocalServiceBaseImpl {
	public List<QAPhanQuyen> findByMaChuDeCauHoi(long maChuDeCauHoi) {
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		try {
			qAPhanQuyenList = qaPhanQuyenPersistence.findBymaChuDeCauHoi(maChuDeCauHoi);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return qAPhanQuyenList;
	}
	public QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi, long maNguoiTraLoi) {
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		QAPhanQuyen phanQuyen = null;
		try {
			qAPhanQuyenList = qaPhanQuyenPersistence.findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi, maNguoiTraLoi);
		} catch (SystemException e) {
			qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		}
		if (null != qAPhanQuyenList && qAPhanQuyenList.size() > 0) {
			phanQuyen = qAPhanQuyenList.get(0);
		}
		return phanQuyen;
	}
	
	public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi) {
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		try {
			qAPhanQuyenList = qaPhanQuyenPersistence.findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, true);
		} catch (SystemException e) {
			qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		}
		return qAPhanQuyenList;
	}
}
