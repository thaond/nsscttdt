package com.nss.portlet.digitalsignature.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.digitalsignature.model.Certificate;

import java.util.List;


/**
 * <a href="CertificateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.digitalsignature.service.http.CertificateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.http.CertificateServiceJSON
 *
 */
public class CertificateJSONSerializer {
    public static JSONObject toJSONObject(Certificate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("x509Certificate", model.getX509Certificate());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.digitalsignature.model.Certificate[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Certificate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.digitalsignature.model.Certificate[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Certificate[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.digitalsignature.model.Certificate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Certificate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
