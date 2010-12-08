package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;

import java.util.List;


/**
 * <a href="PmlFileStatusStateProcessJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFileStatusStateProcessServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFileStatusStateProcessServiceJSON
 *
 */
public class PmlFileStatusStateProcessJSONSerializer {
    public static JSONObject toJSONObject(PmlFileStatusStateProcess model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("id", model.getId());
        jsonObj.put("fileStatusId", model.getFileStatusId());
        jsonObj.put("stateProcessId", model.getStateProcessId());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatusStateProcess model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatusStateProcess[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatusStateProcess model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
