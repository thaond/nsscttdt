package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.model.PmlMainSupport;

import java.util.List;


/**
 * <a href="PmlMainSupportJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlMainSupportServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlMainSupportServiceJSON
 *
 */
public class PmlMainSupportJSONSerializer {
    public static JSONObject toJSONObject(PmlMainSupport model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("processId", model.getProcessId());
        jsonObj.put("processId_Main", model.getProcessId_Main());
        jsonObj.put("type_", model.getType_());
        jsonObj.put("supportInfomation", model.getSupportInfomation());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlMainSupport> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlMainSupport model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
