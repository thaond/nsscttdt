package com.ext.portlet.saveprocesstype.service.http;

import com.ext.portlet.saveprocesstype.model.SaveProcessType;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;


/**
 * <a href="SaveProcessTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.saveprocesstype.service.http.SaveProcessTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.saveprocesstype.service.http.SaveProcessTypeServiceJSON
 *
 */
public class SaveProcessTypeJSONSerializer {
    public static JSONObject toJSONObject(SaveProcessType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("sptId", model.getSptId());
        jsonObj.put("docId", model.getDocId());
        jsonObj.put("flagProcessType", model.getFlagProcessType());
        jsonObj.put("flag", model.getFlag());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.saveprocesstype.model.SaveProcessType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (SaveProcessType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
