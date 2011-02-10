package com.sgs.portlet.issuingplace.util;

import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil;

public class LevelSendChecker extends RowChecker{
	private String issuingPlaceId;
	public LevelSendChecker(RenderResponse renderResponse) {
		super(renderResponse);
		
	}
	public LevelSendChecker(RenderResponse renderResponse, String issuingPlaceId) {
		super(renderResponse);
		this.issuingPlaceId = issuingPlaceId;
	}
	
	public boolean isChecked(Object obj) {
		PmlEdmLevelSend levelSend = (PmlEdmLevelSend)obj;
		try {
			return PmlEdmLevelSendDetailLocalServiceUtil.hasLevelSend(levelSend.getLevelSendId(),this.issuingPlaceId);
		}
		catch (Exception e) {
			_log.error(e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LevelSendChecker.class);
}
