package com.nss.portlet.linh_vuc_van_ban.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;

import java.util.Date;
import java.util.List;


/**
 * <a href="LinhVucVanBanJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.linh_vuc_van_ban.service.http.LinhVucVanBanServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.service.http.LinhVucVanBanServiceJSON
 *
 */
public class LinhVucVanBanJSONSerializer {
    public static JSONObject toJSONObject(LinhVucVanBan model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maLinhVucVanBan", model.getMaLinhVucVanBan());
        jsonObj.put("tenLinhVucVanBan", model.getTenLinhVucVanBan());
        jsonObj.put("parentid", model.getParentid());
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
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LinhVucVanBan model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LinhVucVanBan[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LinhVucVanBan model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
