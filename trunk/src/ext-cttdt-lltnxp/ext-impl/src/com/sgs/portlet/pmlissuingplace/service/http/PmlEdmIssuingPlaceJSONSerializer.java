package com.sgs.portlet.pmlissuingplace.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;

import java.util.List;


/**
 * <a href="PmlEdmIssuingPlaceJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmlissuingplace.service.http.PmlEdmIssuingPlaceServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlissuingplace.service.http.PmlEdmIssuingPlaceServiceJSON
 *
 */
public class PmlEdmIssuingPlaceJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmIssuingPlace model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("issuingPlaceId", model.getIssuingPlaceId());
        jsonObj.put("issuingPlaceName", model.getIssuingPlaceName());
        jsonObj.put("tablePhone", model.getTablePhone());
        jsonObj.put("handPhone", model.getHandPhone());
        jsonObj.put("email", model.getEmail());
        jsonObj.put("address", model.getAddress());
        jsonObj.put("active", model.getActive());
        jsonObj.put("note", model.getNote());
        jsonObj.put("issuingPlaceCode", model.getIssuingPlaceCode());
        jsonObj.put("signer", model.getSigner());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmIssuingPlace model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
