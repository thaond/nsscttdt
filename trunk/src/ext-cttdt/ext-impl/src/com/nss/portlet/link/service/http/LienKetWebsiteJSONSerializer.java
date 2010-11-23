package com.nss.portlet.link.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.link.model.LienKetWebsite;

import java.util.Date;
import java.util.List;


/**
 * <a href="LienKetWebsiteJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.link.service.http.LienKetWebsiteServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.http.LienKetWebsiteServiceJSON
 *
 */
public class LienKetWebsiteJSONSerializer {
    public static JSONObject toJSONObject(LienKetWebsite model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maWebsite", model.getMaWebsite());
        jsonObj.put("tenWebsite", model.getTenWebsite());
        jsonObj.put("urlWebsite", model.getUrlWebsite());
        jsonObj.put("moTaWebsite", model.getMoTaWebsite());
        jsonObj.put("loaiWebsite", model.getLoaiWebsite());
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
        jsonObj.put("thuTuWebsite", model.getThuTuWebsite());
        jsonObj.put("target", model.getTarget());
        jsonObj.put("imageId_liferay", model.getImageId_liferay());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.link.model.LienKetWebsite[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LienKetWebsite model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.link.model.LienKetWebsite[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LienKetWebsite[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.link.model.LienKetWebsite> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LienKetWebsite model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
