package com.nss.portlet.qa_chu_de.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;

import java.util.List;


/**
 * <a href="QAChuDeCauHoiJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_chu_de.service.http.QAChuDeCauHoiServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.service.http.QAChuDeCauHoiServiceJSON
 *
 */
public class QAChuDeCauHoiJSONSerializer {
    public static JSONObject toJSONObject(QAChuDeCauHoi model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maChuDeCauHoi", model.getMaChuDeCauHoi());
        jsonObj.put("tenChuDeCauHoi", model.getTenChuDeCauHoi());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAChuDeCauHoi model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAChuDeCauHoi[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAChuDeCauHoi model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
