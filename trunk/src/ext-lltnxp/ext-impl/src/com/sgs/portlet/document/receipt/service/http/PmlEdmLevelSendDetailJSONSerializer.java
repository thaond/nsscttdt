package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;

import java.util.List;


/**
 * <a href="PmlEdmLevelSendDetailJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmLevelSendDetailServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmLevelSendDetailServiceJSON
 *
 */
public class PmlEdmLevelSendDetailJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmLevelSendDetail model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("levelSendId", model.getLevelSendId());
        jsonObj.put("issuingPlaceId", model.getIssuingPlaceId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmLevelSendDetail model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
