package com.nss.portlet.generatetemplateid.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.generatetemplateid.model.IdTemplate;

import java.util.List;


/**
 * <a href="IdTemplateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.generatetemplateid.service.http.IdTemplateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.generatetemplateid.service.http.IdTemplateServiceJSON
 *
 */
public class IdTemplateJSONSerializer {
    public static JSONObject toJSONObject(IdTemplate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("templateId", model.getTemplateId());
        jsonObj.put("format", model.getFormat());
        jsonObj.put("startNumber", model.getStartNumber());
        jsonObj.put("len", model.getLen());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.generatetemplateid.model.IdTemplate[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (IdTemplate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.generatetemplateid.model.IdTemplate[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (IdTemplate[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.generatetemplateid.model.IdTemplate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (IdTemplate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
