package com.nss.portlet.adv.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.adv.model.QuangCao;

import java.util.Date;
import java.util.List;


/**
 * <a href="QuangCaoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.adv.service.http.QuangCaoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.service.http.QuangCaoServiceJSON
 *
 */
public class QuangCaoJSONSerializer {
    public static JSONObject toJSONObject(QuangCao model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maQuangCao", model.getMaQuangCao());
        jsonObj.put("tenQuangCao", model.getTenQuangCao());
        jsonObj.put("urlWebsite", model.getUrlWebsite());
        jsonObj.put("moTaQuangCao", model.getMoTaQuangCao());
        jsonObj.put("companyid", model.getCompanyid());
        jsonObj.put("userid", model.getUserid());

        Date createdate = model.getCreatedate();

        String createdateJSON = StringPool.BLANK;

        if (createdate != null) {
            createdateJSON = String.valueOf(createdate.getTime());
        }

        jsonObj.put("createdate", createdateJSON);

        Date modifieddate = model.getModifieddate();

        String modifieddateJSON = StringPool.BLANK;

        if (modifieddate != null) {
            modifieddateJSON = String.valueOf(modifieddate.getTime());
        }

        jsonObj.put("modifieddate", modifieddateJSON);
        jsonObj.put("thuTuQuangCao", model.getThuTuQuangCao());
        jsonObj.put("target", model.getTarget());
        jsonObj.put("imageId_liferay", model.getImageId_liferay());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.adv.model.QuangCao[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QuangCao model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.adv.model.QuangCao[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QuangCao[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.adv.model.QuangCao> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QuangCao model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
