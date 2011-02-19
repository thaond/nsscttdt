package com.sgs.portlet.sovanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo;

import java.util.List;


/**
 * <a href="SoPhongVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.SoPhongVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.SoPhongVanBanNoiBoServiceJSON
 *
 */
public class SoPhongVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(SoPhongVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("soVanBanNoiBoId", model.getSoVanBanNoiBoId());
        jsonObj.put("phongVanBanNoiBoId", model.getPhongVanBanNoiBoId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (SoPhongVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
