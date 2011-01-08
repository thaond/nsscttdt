package com.sgs.portlet.pml_ho_so_cong_viec.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;

import java.util.List;


/**
 * <a href="PmlChiTietHSCVJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlChiTietHSCVServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlChiTietHSCVServiceJSON
 *
 */
public class PmlChiTietHSCVJSONSerializer {
    public static JSONObject toJSONObject(PmlChiTietHSCV model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("idChiTietHSCV", model.getIdChiTietHSCV());
        jsonObj.put("idHoSoCongViec", model.getIdHoSoCongViec());
        jsonObj.put("idCongVanDen", model.getIdCongVanDen());
        jsonObj.put("idCongVanDi", model.getIdCongVanDi());
        jsonObj.put("diDen", model.getDiDen());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlChiTietHSCV model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
