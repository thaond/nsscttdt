package com.sgs.portlet.pml_trang_thai_hscv.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;

import java.util.List;


/**
 * <a href="PmlTrangThaiHSCVJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.http.PmlTrangThaiHSCVServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.http.PmlTrangThaiHSCVServiceJSON
 *
 */
public class PmlTrangThaiHSCVJSONSerializer {
    public static JSONObject toJSONObject(PmlTrangThaiHSCV model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("idTrangThaiHSCV", model.getIdTrangThaiHSCV());
        jsonObj.put("tenTrangThaiHSCV", model.getTenTrangThaiHSCV());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTrangThaiHSCV model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
