/**
 * 
 */

package com.sgs.portlet.recievergroup.action;

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
import com.sgs.portlet.recievergroup.service.RecieverLocalServiceUtil;
import com.sgs.portlet.recievergroup.util.RecieverKeys;
import com.sgs.portlet.recievergroup.util.RecieverSerializer;

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
		int type = ParamUtil.getInteger(arg2, RecieverKeys.TYPE, 0);
		String term = DAOParamUtil.getLike(arg2, RecieverKeys.TERM, "");

		switch (type) {
		case RecieverKeys.PORSONAL:
			List<User> users =
				RecieverLocalServiceUtil.findUsersByFullname_ScreenName(
					PortalUtil.getCompanyId(arg2), term);
			return RecieverSerializer.getUserAutoCompleteData(users);
		case RecieverKeys.DEPARTMENT:

			return JSONFactoryUtil.createJSONArray().toString();
		case RecieverKeys.ORGANIZATION:
			List<PmlEdmIssuingPlace> issuingPlaces =
				PmlEdmIssuingPlaceLocalServiceUtil.findByKeywords2(term);
			return RecieverSerializer.getAutoCompleteData(issuingPlaces);

		default:
			return JSONFactoryUtil.createJSONArray().toString();
		}
	}

}
