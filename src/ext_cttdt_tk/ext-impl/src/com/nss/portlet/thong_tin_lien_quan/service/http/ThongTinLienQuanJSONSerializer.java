package com.nss.portlet.thong_tin_lien_quan.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;

import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinLienQuanJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thong_tin_lien_quan.service.http.ThongTinLienQuanServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.service.http.ThongTinLienQuanServiceJSON
 *
 */
public class ThongTinLienQuanJSONSerializer {
    public static JSONObject toJSONObject(ThongTinLienQuan model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maThongTinLienQuan", model.getMaThongTinLienQuan());
        jsonObj.put("tenThongTinLienQuan", model.getTenThongTinLienQuan());
        jsonObj.put("urlWebsite", model.getUrlWebsite());
        jsonObj.put("moTaThongTinLienQuan", model.getMoTaThongTinLienQuan());
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
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinLienQuan model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinLienQuan[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThongTinLienQuan model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
