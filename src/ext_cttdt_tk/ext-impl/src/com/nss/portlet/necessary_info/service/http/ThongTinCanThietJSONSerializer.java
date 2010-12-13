package com.nss.portlet.necessary_info.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.necessary_info.model.ThongTinCanThiet;

import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinCanThietJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.necessary_info.service.http.ThongTinCanThietServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.service.http.ThongTinCanThietServiceJSON
 *
 */
public class ThongTinCanThietJSONSerializer {
    public static JSONObject toJSONObject(ThongTinCanThiet model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maThongTinCanThiet", model.getMaThongTinCanThiet());
        jsonObj.put("tenThongTinCanThiet", model.getTenThongTinCanThiet());
        jsonObj.put("urlWebsite", model.getUrlWebsite());
        jsonObj.put("moTaThongTinCanThiet", model.getMoTaThongTinCanThiet());
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
        jsonObj.put("thuTuThongTin", model.getThuTuThongTin());
        jsonObj.put("target", model.getTarget());
        jsonObj.put("imageId_liferay", model.getImageId_liferay());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinCanThiet model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinCanThiet[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinCanThiet model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
