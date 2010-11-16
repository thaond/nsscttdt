package com.nss.portlet.qa_cau_hoi.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;

import java.util.List;


/**
 * <a href="FileDinhKemQAJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_hoi.service.http.FileDinhKemQAServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.http.FileDinhKemQAServiceJSON
 *
 */
public class FileDinhKemQAJSONSerializer {
    public static JSONObject toJSONObject(FileDinhKemQA model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maFileDinhKemQA", model.getMaFileDinhKemQA());
        jsonObj.put("maCauHoi", model.getMaCauHoi());
        jsonObj.put("maCauTraLoi", model.getMaCauTraLoi());
        jsonObj.put("tenFile", model.getTenFile());
        jsonObj.put("kichThuoc", model.getKichThuoc());
        jsonObj.put("duongDan", model.getDuongDan());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemQA[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
