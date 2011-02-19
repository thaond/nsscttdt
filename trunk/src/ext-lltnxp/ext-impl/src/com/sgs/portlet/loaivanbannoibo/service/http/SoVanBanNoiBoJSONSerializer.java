package com.sgs.portlet.loaivanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo;

import java.util.Date;
import java.util.List;


/**
 * <a href="SoVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.loaivanbannoibo.service.http.SoVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.http.SoVanBanNoiBoServiceJSON
 *
 */
public class SoVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(SoVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("soVanBanNoiBoId", model.getSoVanBanNoiBoId());
        jsonObj.put("maSoVanBanNoiBo", model.getMaSoVanBanNoiBo());
        jsonObj.put("tenSoVanBanNoiBo", model.getTenSoVanBanNoiBo());

        Date ngayTao = model.getNgayTao();

        String ngayTaoJSON = StringPool.BLANK;

        if (ngayTao != null) {
            ngayTaoJSON = String.valueOf(ngayTao.getTime());
        }

        jsonObj.put("ngayTao", ngayTaoJSON);
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (SoVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
