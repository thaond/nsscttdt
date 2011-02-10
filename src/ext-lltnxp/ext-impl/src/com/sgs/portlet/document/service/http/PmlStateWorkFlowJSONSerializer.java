package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.model.PmlStateWorkFlow;

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
 * <code>com.sgs.portlet.document.service.http.PmlStateWorkFlowServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlStateWorkFlowServiceJSON
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
        List<com.sgs.portlet.document.model.PmlStateWorkFlow> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateWorkFlow model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
