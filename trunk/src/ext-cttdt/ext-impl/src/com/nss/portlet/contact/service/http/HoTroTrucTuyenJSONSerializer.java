package com.nss.portlet.contact.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.contact.model.HoTroTrucTuyen;

import java.util.Date;
import java.util.List;


/**
 * <a href="HoTroTrucTuyenJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.contact.service.http.HoTroTrucTuyenServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.contact.service.http.HoTroTrucTuyenServiceJSON
 *
 */
public class HoTroTrucTuyenJSONSerializer {
    public static JSONObject toJSONObject(HoTroTrucTuyen model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maHoTroTrucTuyen", model.getMaHoTroTrucTuyen());
        jsonObj.put("ten", model.getTen());
        jsonObj.put("link", model.getLink());
        jsonObj.put("imageUrl", model.getImageUrl());
        jsonObj.put("order", model.getOrder());
        jsonObj.put("active", model.getActive());
        jsonObj.put("description", model.getDescription());
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

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.contact.model.HoTroTrucTuyen[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (HoTroTrucTuyen model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.contact.model.HoTroTrucTuyen[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (HoTroTrucTuyen[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.contact.model.HoTroTrucTuyen> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (HoTroTrucTuyen model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
