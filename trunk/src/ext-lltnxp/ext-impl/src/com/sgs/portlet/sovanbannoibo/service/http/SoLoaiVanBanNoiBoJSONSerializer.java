package com.sgs.portlet.sovanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo;

import java.util.List;


/**
 * <a href="SoLoaiVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.SoLoaiVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.SoLoaiVanBanNoiBoServiceJSON
 *
 */
public class SoLoaiVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(SoLoaiVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("soVanBanNoiBoId", model.getSoVanBanNoiBoId());
        jsonObj.put("loaiVanBanNoiBoId", model.getLoaiVanBanNoiBoId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (SoLoaiVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
