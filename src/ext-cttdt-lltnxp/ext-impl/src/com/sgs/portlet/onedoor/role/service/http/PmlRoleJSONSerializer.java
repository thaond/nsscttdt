package com.sgs.portlet.onedoor.role.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoor.role.model.PmlRole;

import java.util.List;


/**
 * <a href="PmlRoleJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.role.service.http.PmlRoleServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.role.service.http.PmlRoleServiceJSON
 *
 */
public class PmlRoleJSONSerializer {
    public static JSONObject toJSONObject(PmlRole model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("roleId", model.getRoleId());
        jsonObj.put("roleCode", model.getRoleCode());
        jsonObj.put("roleName", model.getRoleName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.role.model.PmlRole> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlRole model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
