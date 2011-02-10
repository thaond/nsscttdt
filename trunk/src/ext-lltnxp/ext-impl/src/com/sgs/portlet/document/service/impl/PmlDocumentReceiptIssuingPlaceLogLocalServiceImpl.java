
package com.sgs.portlet.document.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog;
import com.sgs.portlet.document.service.base.PmlDocumentReceiptIssuingPlaceLogLocalServiceBaseImpl;

public class PmlDocumentReceiptIssuingPlaceLogLocalServiceImpl
	extends PmlDocumentReceiptIssuingPlaceLogLocalServiceBaseImpl {

	public PmlDocumentReceiptIssuingPlaceLog addPmlDocumentReceiptIssuingPlaceLog(
		long documentReceiptId, Date dateProcess, long processor,
		long directProcessorId, String processInfomation, String receiver,
		int step)
		throws SystemException {

		PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog =
			pmlDocumentReceiptIssuingPlaceLogPersistence.create(CounterLocalServiceUtil.increment(PmlDocumentReceiptIssuingPlaceLog.class.getName()));
		pmlDocumentReceiptIssuingPlaceLog.setDocumentReceiptId(documentReceiptId);
		pmlDocumentReceiptIssuingPlaceLog.setDateProcess(dateProcess);
		pmlDocumentReceiptIssuingPlaceLog.setProcessor(processor);
		pmlDocumentReceiptIssuingPlaceLog.setDirectProcessorId(directProcessorId);
		pmlDocumentReceiptIssuingPlaceLog.setProcessInfomation(processInfomation);
		pmlDocumentReceiptIssuingPlaceLog.setReceiver(receiver);
		pmlDocumentReceiptIssuingPlaceLog.setStep(step);

		return pmlDocumentReceiptIssuingPlaceLogPersistence.update(
			pmlDocumentReceiptIssuingPlaceLog, false);
	}
}
