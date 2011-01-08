package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;

import java.util.List;


/**
 * <a href="PmlEdmConfidentialLevelJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmConfidentialLevelServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmConfidentialLevelServiceJSON
 *
 */
public class PmlEdmConfidentialLevelJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmConfidentialLevel model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("confidentialLevelId", model.getConfidentialLevelId());
        jsonObj.put("confidentialLevelName", model.getConfidentialLevelName());
        jsonObj.put("limitViewDetail", model.getLimitViewDetail());
        jsonObj.put("haveProcess", model.getHaveProcess());
        jsonObj.put("confidentialLevelSymbol",
            model.getConfidentialLevelSymbol());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmConfidentialLevel model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
