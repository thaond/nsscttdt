package com.sgs.portlet.onedoorpccc.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoorpccc.model.PmlTeamLeader;

import java.util.List;


/**
 * <a href="PmlTeamLeaderJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlTeamLeaderServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlTeamLeaderServiceJSON
 *
 */
public class PmlTeamLeaderJSONSerializer {
    public static JSONObject toJSONObject(PmlTeamLeader model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("teamId", model.getTeamId());
        jsonObj.put("userId", model.getUserId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTeamLeader model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
