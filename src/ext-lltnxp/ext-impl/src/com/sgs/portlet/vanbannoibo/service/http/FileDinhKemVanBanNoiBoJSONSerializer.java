package com.sgs.portlet.vanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;

import java.util.Date;
import java.util.List;


/**
 * <a href="FileDinhKemVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.FileDinhKemVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.FileDinhKemVanBanNoiBoServiceJSON
 *
 */
public class FileDinhKemVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(FileDinhKemVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileDinhKemVanBanNoiBoId",
            model.getFileDinhKemVanBanNoiBoId());
        jsonObj.put("tenFileFull", model.getTenFileFull());
        jsonObj.put("tenFile", model.getTenFile());
        jsonObj.put("duongDanFile", model.getDuongDanFile());
        jsonObj.put("tieuDe", model.getTieuDe());

        Date ngayTao = model.getNgayTao();

        String ngayTaoJSON = StringPool.BLANK;

        if (ngayTao != null) {
            ngayTaoJSON = String.valueOf(ngayTao.getTime());
        }

        jsonObj.put("ngayTao", ngayTaoJSON);
        jsonObj.put("loaiFile", model.getLoaiFile());
        jsonObj.put("mucDichFile", model.getMucDichFile());
        jsonObj.put("vanBanNoiBoId", model.getVanBanNoiBoId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileDinhKemVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
