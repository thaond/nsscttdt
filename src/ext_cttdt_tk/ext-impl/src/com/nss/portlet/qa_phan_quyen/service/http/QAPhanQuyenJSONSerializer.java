package com.nss.portlet.qa_phan_quyen.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;

import java.util.List;


/**
 * <a href="QAPhanQuyenJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_phan_quyen.service.http.QAPhanQuyenServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.service.http.QAPhanQuyenServiceJSON
 *
 */
public class QAPhanQuyenJSONSerializer {
    public static JSONObject toJSONObject(QAPhanQuyen model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maPhanQuyen", model.getMaPhanQuyen());
        jsonObj.put("maChuDeCauHoi", model.getMaChuDeCauHoi());
        jsonObj.put("maNguoiTraLoi", model.getMaNguoiTraLoi());
        jsonObj.put("quyenXem", model.getQuyenXem());
        jsonObj.put("quyenCapNhat", model.getQuyenCapNhat());
        jsonObj.put("quyenTraLoi", model.getQuyenTraLoi());
        jsonObj.put("quyenDuyet", model.getQuyenDuyet());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAPhanQuyen model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAPhanQuyen[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (QAPhanQuyen model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
