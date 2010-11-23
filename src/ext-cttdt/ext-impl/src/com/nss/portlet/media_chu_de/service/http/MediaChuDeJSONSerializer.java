package com.nss.portlet.media_chu_de.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.media_chu_de.model.MediaChuDe;

import java.util.List;


/**
 * <a href="MediaChuDeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.media_chu_de.service.http.MediaChuDeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_chu_de.service.http.MediaChuDeServiceJSON
 *
 */
public class MediaChuDeJSONSerializer {
    public static JSONObject toJSONObject(MediaChuDe model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maMediaChuDe", model.getMaMediaChuDe());
        jsonObj.put("tenMediaChuDe", model.getTenMediaChuDe());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.media_chu_de.model.MediaChuDe[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaChuDe model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.media_chu_de.model.MediaChuDe[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaChuDe[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.media_chu_de.model.MediaChuDe> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaChuDe model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
