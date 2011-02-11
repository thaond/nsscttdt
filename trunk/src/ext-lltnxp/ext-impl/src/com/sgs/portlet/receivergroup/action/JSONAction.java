/**
 * 
 */

package com.sgs.portlet.receivergroup.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.receivergroup.service.ReceiverLocalServiceUtil;
import com.sgs.portlet.receivergroup.util.ReceiverKeys;
import com.sgs.portlet.receivergroup.util.ReceiverSerializer;

/**
 * @author canhminh
 */
public class JSONAction extends com.liferay.portal.struts.JSONAction {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portal.struts.JSONAction#getJSON(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public String getJSON(
		ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2,
		HttpServletResponse arg3)
		throws Exception {

		// TODO Auto-generated method stub
		int type = ParamUtil.getInteger(arg2, ReceiverKeys.TYPE, 0);
		String term = DAOParamUtil.getLike(arg2, ReceiverKeys.TERM, "");

		switch (type) {
		case ReceiverKeys.PERSONAL:
			List<User> users =
				ReceiverLocalServiceUtil.findUsersByFullname_ScreenName(
					PortalUtil.getCompanyId(arg2), term);
			return ReceiverSerializer.getUserAutoCompleteData(users);
		case ReceiverKeys.DEPARTMENT:

			return JSONFactoryUtil.createJSONArray().toString();
		case ReceiverKeys.ORGANIZATION:
			List<PmlEdmIssuingPlace> issuingPlaces =
				PmlEdmIssuingPlaceLocalServiceUtil.findByKeywords2(term);
			return ReceiverSerializer.getAutoCompleteData(issuingPlaces);

		default:
			return JSONFactoryUtil.createJSONArray().toString();
		}
	}

}
