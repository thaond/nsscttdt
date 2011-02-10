package com.sgs.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoor.model.PmlTeam;

import java.util.List;


/**
 * <a href="PmlTeamJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlTeamServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlTeamServiceJSON
 *
 */
public class PmlTeamJSONSerializer {
    public static JSONObject toJSONObject(PmlTeam model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("teamId", model.getTeamId());
        jsonObj.put("departmentId", model.getDepartmentId());
        jsonObj.put("teamName", model.getTeamName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("organizationId", model.getOrganizationId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("specialTeam", model.getSpecialTeam());
        jsonObj.put("teamCode", model.getTeamCode());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.model.PmlTeam> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTeam model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
