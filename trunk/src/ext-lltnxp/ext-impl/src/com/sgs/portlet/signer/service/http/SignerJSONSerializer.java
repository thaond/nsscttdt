package com.sgs.portlet.signer.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.signer.model.Signer;

import java.util.List;


/**
 * <a href="SignerJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.signer.service.http.SignerServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.service.http.SignerServiceJSON
 *
 */
public class SignerJSONSerializer {
    public static JSONObject toJSONObject(Signer model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("signerId", model.getSignerId());
        jsonObj.put("userId", model.getUserId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.signer.model.Signer> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Signer model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
