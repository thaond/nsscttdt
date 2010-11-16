package com.nss.portlet.digitalsignature.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.digitalsignature.model.Signature;

import java.util.Date;
import java.util.List;


/**
 * <a href="SignatureJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.digitalsignature.service.http.SignatureServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.http.SignatureServiceJSON
 *
 */
public class SignatureJSONSerializer {
    public static JSONObject toJSONObject(Signature model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("signatureId", model.getSignatureId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("userName", model.getUserName());

        Date createDate = model.getCreateDate();

        String createDateJSON = StringPool.BLANK;

        if (createDate != null) {
            createDateJSON = String.valueOf(createDate.getTime());
        }

        jsonObj.put("createDate", createDateJSON);
        jsonObj.put("articleId", model.getArticleId());
        jsonObj.put("signData", model.getSignData());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.digitalsignature.model.Signature[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Signature model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.digitalsignature.model.Signature[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Signature[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.digitalsignature.model.Signature> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Signature model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
