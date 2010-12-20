package com.nss.portlet.permissonuserbyfile.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;

import java.util.List;


/**
 * <a href="PmlUserFileTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.permissonuserbyfile.service.http.PmlUserFileTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.permissonuserbyfile.service.http.PmlUserFileTypeServiceJSON
 *
 */
public class PmlUserFileTypeJSONSerializer {
    public static JSONObject toJSONObject(PmlUserFileType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUserFileType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUserFileType[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUserFileType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
