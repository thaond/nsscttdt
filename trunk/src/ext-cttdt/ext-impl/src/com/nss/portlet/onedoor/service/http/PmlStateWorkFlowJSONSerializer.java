package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.onedoor.model.PmlStateWorkFlow;

import java.util.List;


/**
 * <a href="PmlStateWorkFlowJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlStateWorkFlowServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlStateWorkFlowServiceJSON
 *
 */
public class PmlStateWorkFlowJSONSerializer {
    public static JSONObject toJSONObject(PmlStateWorkFlow model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("stateWfId", model.getStateWfId());
        jsonObj.put("workflow", model.getWorkflow());
        jsonObj.put("stateProcessId", model.getStateProcessId());
        jsonObj.put("solvingTime", model.getSolvingTime());
        jsonObj.put("version_", model.getVersion_());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateWorkFlow model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateWorkFlow[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateWorkFlow model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
