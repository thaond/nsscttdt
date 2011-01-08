package com.ext.portlet.processtype.service.http;

import com.ext.portlet.processtype.model.ProcessType;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;


/**
 * <a href="ProcessTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.processtype.service.http.ProcessTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.processtype.service.http.ProcessTypeServiceJSON
 *
 */
public class ProcessTypeJSONSerializer {
    public static JSONObject toJSONObject(ProcessType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("processTypeId", model.getProcessTypeId());
        jsonObj.put("name", model.getName());
        jsonObj.put("flagProcessType", model.getFlagProcessType());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.processtype.model.ProcessType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ProcessType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
