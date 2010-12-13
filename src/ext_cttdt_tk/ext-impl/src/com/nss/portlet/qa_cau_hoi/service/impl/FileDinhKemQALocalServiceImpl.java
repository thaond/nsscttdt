package com.nss.portlet.qa_cau_hoi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;
import com.nss.portlet.qa_cau_hoi.service.base.FileDinhKemQALocalServiceBaseImpl;


public class FileDinhKemQALocalServiceImpl
    extends FileDinhKemQALocalServiceBaseImpl {
	public FileDinhKemQA findByMaCauHoi(long maCauHoi) {
		 List<FileDinhKemQA> fileList = new ArrayList<FileDinhKemQA>();
		 FileDinhKemQA file = null;
		try {
			fileList = fileDinhKemQAPersistence.findByMaCauHoi(maCauHoi);
		} catch (SystemException e) {
			fileList = new ArrayList<FileDinhKemQA>();
		}
		if (fileList.size() > 0) {
			file = fileList.get(0);
		}
		return file;
	}
	
	public FileDinhKemQA findByMaCauTraLoi(long maCauTraLoi) {
		List<FileDinhKemQA> fileList = new ArrayList<FileDinhKemQA>();
		FileDinhKemQA file = null;
		try {
			fileList = fileDinhKemQAPersistence.findByMaCauTraLoi(maCauTraLoi);
		} catch (SystemException e) {
			fileList = new ArrayList<FileDinhKemQA>();
		}
		if (fileList.size() > 0) {
			file = fileList.get(0);
		}
		return file;
	}
}
