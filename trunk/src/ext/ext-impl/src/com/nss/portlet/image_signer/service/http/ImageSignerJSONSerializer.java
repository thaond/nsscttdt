package com.nss.portlet.image_signer.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.image_signer.model.ImageSigner;

import java.util.List;


/**
 * <a href="ImageSignerJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.image_signer.service.http.ImageSignerServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.image_signer.service.http.ImageSignerServiceJSON
 *
 */
public class ImageSignerJSONSerializer {
    public static JSONObject toJSONObject(ImageSigner model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("imageSignerId", model.getImageSignerId());
        jsonObj.put("imagePath", model.getImagePath());
        jsonObj.put("imageExtend", model.getImageExtend());
        jsonObj.put("imageSize", model.getImageSize());
        jsonObj.put("userId", model.getUserId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.image_signer.model.ImageSigner[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ImageSigner model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.image_signer.model.ImageSigner[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ImageSigner[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.image_signer.model.ImageSigner> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ImageSigner model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
