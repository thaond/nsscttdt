package com.nss.portlet.partner.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.partner.model.Partner;

import java.util.Date;
import java.util.List;


/**
 * <a href="PartnerJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.partner.service.http.PartnerServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.service.http.PartnerServiceJSON
 *
 */
public class PartnerJSONSerializer {
    public static JSONObject toJSONObject(Partner model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maPartner", model.getMaPartner());
        jsonObj.put("tenPartner", model.getTenPartner());
        jsonObj.put("urlPartner", model.getUrlPartner());
        jsonObj.put("moTaPartner", model.getMoTaPartner());
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
        jsonObj.put("thuTuPartner", model.getThuTuPartner());
        jsonObj.put("target", model.getTarget());
        jsonObj.put("active", model.getActive());
        jsonObj.put("imageId_liferay", model.getImageId_liferay());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.partner.model.Partner[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Partner model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.partner.model.Partner[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Partner[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.partner.model.Partner> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Partner model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
