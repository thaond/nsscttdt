package com.nss.portlet.qa_chu_de.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil;
import com.nss.portlet.qa_chu_de.QAChuDeCauHoiCanNotDeleteException;
import com.nss.portlet.qa_chu_de.QAChuDeCauHoiTenChuDeException;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.base.QAChuDeCauHoiLocalServiceBaseImpl;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil;

public class QAChuDeCauHoiLocalServiceImpl
    extends QAChuDeCauHoiLocalServiceBaseImpl {
	public int countChuDeCauHoi(String tenChuDeCauHoi, boolean andOperator) throws SystemException {
		return qaChuDeCauHoiFinder.countChuDeCauHoi(tenChuDeCauHoi, andOperator);
	}
	public List<QAChuDeCauHoi> findChuDeCauHoi(String tenChuDeCauHoi, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return qaChuDeCauHoiFinder.findChuDeCauHoi(tenChuDeCauHoi, andOperator, start, end, obc);
	}
	
	protected void validate(String tenChuDeCauHoi)
	throws PortalException, SystemException {
	
		// Check tenDoQuanTrong
		if (Validator.isNull(tenChuDeCauHoi)){
			throw new QAChuDeCauHoiTenChuDeException();
		}
	}
	
	protected void validateDeleteChuDe(int phanQuyenListSize, int cauHoiQAListSize)
	throws PortalException, SystemException {
		
		if (phanQuyenListSize > 0){
			throw new QAChuDeCauHoiCanNotDeleteException();
		}
		if (cauHoiQAListSize > 0){
			throw new QAChuDeCauHoiCanNotDeleteException();
		}
	}
	
	public void deleteQAChuDeCauHoi(long maChuDeCauHoi) throws PortalException, SystemException {
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		List<CauHoiQA> cauHoiQAList = new ArrayList<CauHoiQA>();
		try {
			qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi(maChuDeCauHoi);
		} catch (Exception e) {
			qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		}
		try {
			cauHoiQAList = CauHoiQALocalServiceUtil.findByMaChuDeCauHoi(maChuDeCauHoi);
		} catch (Exception e) {
			cauHoiQAList = new ArrayList<CauHoiQA>();
		}
		validateDeleteChuDe(qAPhanQuyenList.size(), cauHoiQAList.size());
		qaChuDeCauHoiPersistence.remove(maChuDeCauHoi);
	}
	
	public QAChuDeCauHoi addQAChuDeCauHoi(String tenChuDeCauHoi) throws PortalException, SystemException {
		validate(tenChuDeCauHoi);
		long maChuDeCauHoi = CounterLocalServiceUtil.increment();
		QAChuDeCauHoi chuDeCauHoi = qaChuDeCauHoiPersistence.create(maChuDeCauHoi);
		chuDeCauHoi.setMaChuDeCauHoi(maChuDeCauHoi);
		chuDeCauHoi.setTenChuDeCauHoi(tenChuDeCauHoi);
		chuDeCauHoi.setActive(1);
		chuDeCauHoi = qaChuDeCauHoiPersistence.update(chuDeCauHoi, false);
		return chuDeCauHoi;
	}
	
	public QAChuDeCauHoi updateQAChuDeCauHoi(long maChuDeCauHoi, String tenChuDeCauHoi) throws PortalException, SystemException {
		validate(tenChuDeCauHoi);
		QAChuDeCauHoi chuDeCauHoi = qaChuDeCauHoiPersistence.findByPrimaryKey(maChuDeCauHoi);
		chuDeCauHoi.setTenChuDeCauHoi(tenChuDeCauHoi);
		chuDeCauHoi = qaChuDeCauHoiPersistence.update(chuDeCauHoi, false);
		return chuDeCauHoi;
	}
}
