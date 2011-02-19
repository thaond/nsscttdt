package com.sgs.portlet.vanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;

import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.VanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.VanBanNoiBoServiceJSON
 *
 */
public class VanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(VanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("vanBanNoiBoId", model.getVanBanNoiBoId());
        jsonObj.put("loaiVanBanNoiBo", model.getLoaiVanBanNoiBo());
        jsonObj.put("soVanBanNoiBo", model.getSoVanBanNoiBo());

        Date ngayTao = model.getNgayTao();

        String ngayTaoJSON = StringPool.BLANK;

        if (ngayTao != null) {
            ngayTaoJSON = String.valueOf(ngayTao.getTime());
        }

        jsonObj.put("ngayTao", ngayTaoJSON);

        Date ngayKy = model.getNgayKy();

        String ngayKyJSON = StringPool.BLANK;

        if (ngayKy != null) {
            ngayKyJSON = String.valueOf(ngayKy.getTime());
        }

        jsonObj.put("ngayKy", ngayKyJSON);
        jsonObj.put("trichYeu", model.getTrichYeu());
        jsonObj.put("nguoiKy", model.getNguoiKy());
        jsonObj.put("ghiChu", model.getGhiChu());
        jsonObj.put("soVaoSoVanBanNoiBo", model.getSoVaoSoVanBanNoiBo());
        jsonObj.put("soPhatSinhTheoNam", model.getSoPhatSinhTheoNam());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (VanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
