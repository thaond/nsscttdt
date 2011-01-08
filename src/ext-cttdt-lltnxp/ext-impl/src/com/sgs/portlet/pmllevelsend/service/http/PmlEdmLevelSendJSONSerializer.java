package com.sgs.portlet.pmllevelsend.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;

import java.util.List;


/**
 * <a href="PmlEdmLevelSendJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmllevelsend.service.http.PmlEdmLevelSendServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmllevelsend.service.http.PmlEdmLevelSendServiceJSON
 *
 */
public class PmlEdmLevelSendJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmLevelSend model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("levelSendId", model.getLevelSendId());
        jsonObj.put("levelSendName", model.getLevelSendName());
        jsonObj.put("levelSendCode", model.getLevelSendCode());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmLevelSend model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
