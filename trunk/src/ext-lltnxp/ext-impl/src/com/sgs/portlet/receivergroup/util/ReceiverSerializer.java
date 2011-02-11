/**
 * 
 */

package com.sgs.portlet.receivergroup.util;

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;

/**
 * @author canhminh
 */
public class ReceiverSerializer {

	public static String getAutoCompleteData(
		List<PmlEdmIssuingPlace> issuingPlaces) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (PmlEdmIssuingPlace issuingPlace : issuingPlaces) {
			jsonArray.put(toAutoCompleteObject(issuingPlace));
		}
		return jsonArray.toString();
	}

	/**
	 * @param user
	 * @return
	 */
	public static String getFullName(User user) {

		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(user.getScreenName());
		sb.append(" - ");
		sb.append(user.getLastName());
		sb.append(" ");
		sb.append(user.getMiddleName());
		sb.append(" ");
		sb.append(user.getFirstName());
		return sb.toString();
	}

	public static String getUserAutoCompleteData(List<User> users) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (User user : users) {
			jsonArray.put(toAutoCompleteObject(user));
		}
		return jsonArray.toString();
	}

	/**
	 * @param issuingPlace
	 * @return
	 */
	private static JSONObject toAutoCompleteObject(
		PmlEdmIssuingPlace issuingPlace) {

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("label", issuingPlace.getIssuingPlaceId() + " - " +
			issuingPlace.getIssuingPlaceName());
		jsonObj.put("value", issuingPlace.getIssuingPlaceId());
		return jsonObj;
	}

	/**
	 * @param user
	 * @return
	 */
	private static JSONObject toAutoCompleteObject(User user) {

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("label", getFullName(user));
		jsonObj.put("value", user.getUserId());
		return jsonObj;
	}

}
