package com.sgs.portlet.signer.search;

import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.sgs.portlet.signer.service.SignerLocalServiceUtil;

public class SignerChecker extends RowChecker{

	public SignerChecker(RenderResponse renderResponse) {
		super(renderResponse);
		
	}
	/**
	 * @method isChecked	
	 * @param obj
	 * @return boolean
	 * kiem tra pml_signer co chua doi tuong signer voi userId nhap vao khong
	 */
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return SignerLocalServiceUtil.hasSigner(
				 user.getUserId());
		}
		catch (Exception e) {
			_log.error(e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SignerChecker.class);
}
