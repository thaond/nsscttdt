package com.sgs.portlet.sovanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo;

import java.util.List;


/**
 * <a href="LoaiPhongVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.LoaiPhongVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.LoaiPhongVanBanNoiBoServiceJSON
 *
 */
public class LoaiPhongVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(LoaiPhongVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("loaiVanBanNoiBoId", model.getLoaiVanBanNoiBoId());
        jsonObj.put("phongVanBanNoiBoId", model.getPhongVanBanNoiBoId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LoaiPhongVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
