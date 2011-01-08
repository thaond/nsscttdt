package com.sgs.portlet.generatetemplateid.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.generatetemplateid.model.IdGenerated;

import java.util.List;


/**
 * <a href="IdGeneratedJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.generatetemplateid.service.http.IdGeneratedServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.http.IdGeneratedServiceJSON
 *
 */
public class IdGeneratedJSONSerializer {
    public static JSONObject toJSONObject(IdGenerated model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("id", model.getId());
        jsonObj.put("year", model.getYear());
        jsonObj.put("curValue", model.getCurValue());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.generatetemplateid.model.IdGenerated> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (IdGenerated model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
