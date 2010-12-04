package com.nss.portlet.documentfield.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.documentfield.model.PmlField;

import java.util.List;


/**
 * <a href="PmlFieldJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.documentfield.service.http.PmlFieldServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.documentfield.service.http.PmlFieldServiceJSON
 *
 */
public class PmlFieldJSONSerializer {
    public static JSONObject toJSONObject(PmlField model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fieldId", model.getFieldId());
        jsonObj.put("fieldCode", model.getFieldCode());
        jsonObj.put("fieldName", model.getFieldName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());
        jsonObj.put("departmentsId", model.getDepartmentsId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.documentfield.model.PmlField[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlField model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.documentfield.model.PmlField[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlField[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.documentfield.model.PmlField> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlField model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
