package com.nss.portlet.co_quan_ban_hanh.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;

import java.util.Date;
import java.util.List;


/**
 * <a href="CoQuanBanHanhJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.co_quan_ban_hanh.service.http.CoQuanBanHanhServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.service.http.CoQuanBanHanhServiceJSON
 *
 */
public class CoQuanBanHanhJSONSerializer {
    public static JSONObject toJSONObject(CoQuanBanHanh model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maCoQuanBanHanh", model.getMaCoQuanBanHanh());
        jsonObj.put("tenCoQuanBanHanh", model.getTenCoQuanBanHanh());
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
        jsonObj.put("active", model.getActive());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CoQuanBanHanh model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CoQuanBanHanh[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CoQuanBanHanh model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
