package com.sgs.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;

import java.util.List;


/**
 * <a href="PmlDepartmentsLeaderJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlDepartmentsLeaderServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlDepartmentsLeaderServiceJSON
 *
 */
public class PmlDepartmentsLeaderJSONSerializer {
    public static JSONObject toJSONObject(PmlDepartmentsLeader model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("clericalId", model.getClericalId());
        jsonObj.put("main", model.getMain());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDepartmentsLeader model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
