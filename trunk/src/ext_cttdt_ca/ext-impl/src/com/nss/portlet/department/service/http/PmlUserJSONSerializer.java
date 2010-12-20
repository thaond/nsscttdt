package com.nss.portlet.department.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.department.model.PmlUser;

import java.util.List;


/**
 * <a href="PmlUserJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.department.service.http.PmlUserServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.service.http.PmlUserServiceJSON
 *
 */
public class PmlUserJSONSerializer {
    public static JSONObject toJSONObject(PmlUser model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("positionId", model.getPositionId());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.department.model.PmlUser[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUser model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.department.model.PmlUser[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUser[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.department.model.PmlUser> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUser model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
