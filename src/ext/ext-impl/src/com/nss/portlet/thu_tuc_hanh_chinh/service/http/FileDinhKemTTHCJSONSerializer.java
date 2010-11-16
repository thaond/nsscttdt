package com.nss.portlet.thu_tuc_hanh_chinh.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;

import java.util.List;


/**
 * <a href="FileDinhKemTTHCJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.http.FileDinhKemTTHCServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.http.FileDinhKemTTHCServiceJSON
 *
 */
public class FileDinhKemTTHCJSONSerializer {
    public static JSONObject toJSONObject(FileDinhKemTTHC model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maFileDinhKemTTHC", model.getMaFileDinhKemTTHC());
        jsonObj.put("maThuTucHanhChinh", model.getMaThuTucHanhChinh());
        jsonObj.put("tenFile", model.getTenFile());
        jsonObj.put("moTa", model.getMoTa());
        jsonObj.put("kichThuoc", model.getKichThuoc());
        jsonObj.put("duongDan", model.getDuongDan());
        jsonObj.put("phienBan", model.getPhienBan());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemTTHC model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemTTHC[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemTTHC model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
