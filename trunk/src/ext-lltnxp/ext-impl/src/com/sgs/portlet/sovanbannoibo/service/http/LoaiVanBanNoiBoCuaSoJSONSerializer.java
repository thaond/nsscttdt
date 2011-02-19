package com.sgs.portlet.sovanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo;

import java.util.List;


/**
 * <a href="LoaiVanBanNoiBoCuaSoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.LoaiVanBanNoiBoCuaSoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.LoaiVanBanNoiBoCuaSoServiceJSON
 *
 */
public class LoaiVanBanNoiBoCuaSoJSONSerializer {
    public static JSONObject toJSONObject(LoaiVanBanNoiBoCuaSo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("loaiVanBanNoiBoId", model.getLoaiVanBanNoiBoId());
        jsonObj.put("kyHieuLoaiVanBanNoiBo", model.getKyHieuLoaiVanBanNoiBo());
        jsonObj.put("tenLoaiVanBanNoiBo", model.getTenLoaiVanBanNoiBo());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LoaiVanBanNoiBoCuaSo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
