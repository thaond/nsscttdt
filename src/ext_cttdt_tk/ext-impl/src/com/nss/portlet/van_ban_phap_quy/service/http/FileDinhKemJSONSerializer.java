package com.nss.portlet.van_ban_phap_quy.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;

import java.util.List;


/**
 * <a href="FileDinhKemJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.van_ban_phap_quy.service.http.FileDinhKemServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.http.FileDinhKemServiceJSON
 *
 */
public class FileDinhKemJSONSerializer {
    public static JSONObject toJSONObject(FileDinhKem model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maFileDinhKem", model.getMaFileDinhKem());
        jsonObj.put("maVanBanPhapQuy", model.getMaVanBanPhapQuy());
        jsonObj.put("tenFile", model.getTenFile());
        jsonObj.put("moTa", model.getMoTa());
        jsonObj.put("kichThuoc", model.getKichThuoc());
        jsonObj.put("duongDan", model.getDuongDan());
        jsonObj.put("phienBan", model.getPhienBan());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKem model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKem[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKem model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
