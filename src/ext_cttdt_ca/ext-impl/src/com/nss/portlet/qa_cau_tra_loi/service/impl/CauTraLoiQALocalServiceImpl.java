package com.nss.portlet.qa_cau_tra_loi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.service.base.CauTraLoiQALocalServiceBaseImpl;


public class CauTraLoiQALocalServiceImpl extends CauTraLoiQALocalServiceBaseImpl {
	public List<CauTraLoiQA> findByMaCauHoi(long maCauHoi) {
		List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		try {
			cauTraLoiQAList = cauTraLoiQAPersistence.findByMaCauHoiQA(maCauHoi);
		} catch (SystemException e) {
			cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		}
		return cauTraLoiQAList;
	}
	
	public List<CauTraLoiQA> findByMaCauHoi_Publish(long maCauHoi) {
		List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		try {
			cauTraLoiQAList = cauTraLoiQAPersistence.findByMaCauHoiQA_Publish(maCauHoi, true);
		} catch (SystemException e) {
			cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
		}
		return cauTraLoiQAList;
	}
}
