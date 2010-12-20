package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.onedoor.model.PmlTransition;

import java.util.List;


/**
 * <a href="PmlTransitionJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlTransitionServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlTransitionServiceJSON
 *
 */
public class PmlTransitionJSONSerializer {
    public static JSONObject toJSONObject(PmlTransition model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("transitionId", model.getTransitionId());
        jsonObj.put("transitionName", model.getTransitionName());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("noTransition", model.getNoTransition());
        jsonObj.put("stateProcessCurrent", model.getStateProcessCurrent());
        jsonObj.put("stateProcessNext", model.getStateProcessNext());
        jsonObj.put("version_", model.getVersion_());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlTransition[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTransition model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlTransition[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTransition[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlTransition> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTransition model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
