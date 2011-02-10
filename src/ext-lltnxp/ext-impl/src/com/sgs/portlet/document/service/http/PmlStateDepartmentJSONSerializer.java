package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.model.PmlStateDepartment;

import java.util.List;


/**
 * <a href="PmlStateDepartmentJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlStateDepartmentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlStateDepartmentServiceJSON
 *
 */
public class PmlStateDepartmentJSONSerializer {
    public static JSONObject toJSONObject(PmlStateDepartment model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("departmentId", model.getDepartmentId());
        jsonObj.put("stateWfId", model.getStateWfId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlStateDepartment> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateDepartment model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
