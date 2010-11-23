package com.nss.portlet.van_ban_phap_quy.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;

import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanPhapQuyJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.van_ban_phap_quy.service.http.VanBanPhapQuyServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.http.VanBanPhapQuyServiceJSON
 *
 */
public class VanBanPhapQuyJSONSerializer {
    public static JSONObject toJSONObject(VanBanPhapQuy model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maVanBanPhapQuy", model.getMaVanBanPhapQuy());
        jsonObj.put("kyHieuVanBan", model.getKyHieuVanBan());
        jsonObj.put("maLoaiVanBan", model.getMaLoaiVanBan());
        jsonObj.put("maLinhVucVanBan", model.getMaLinhVucVanBan());
        jsonObj.put("tomTat", model.getTomTat());
        jsonObj.put("nguon", model.getNguon());
        jsonObj.put("noiDung", model.getNoiDung());

        Date ngayKy = model.getNgayKy();

        String ngayKyJSON = StringPool.BLANK;

        if (ngayKy != null) {
            ngayKyJSON = String.valueOf(ngayKy.getTime());
        }

        jsonObj.put("ngayKy", ngayKyJSON);

        Date ngayCoHieuLuc = model.getNgayCoHieuLuc();

        String ngayCoHieuLucJSON = StringPool.BLANK;

        if (ngayCoHieuLuc != null) {
            ngayCoHieuLucJSON = String.valueOf(ngayCoHieuLuc.getTime());
        }

        jsonObj.put("ngayCoHieuLuc", ngayCoHieuLucJSON);
        jsonObj.put("nguoiKy", model.getNguoiKy());

        Date ngayBanHanh = model.getNgayBanHanh();

        String ngayBanHanhJSON = StringPool.BLANK;

        if (ngayBanHanh != null) {
            ngayBanHanhJSON = String.valueOf(ngayBanHanh.getTime());
        }

        jsonObj.put("ngayBanHanh", ngayBanHanhJSON);

        Date ngayHetHieuLuc = model.getNgayHetHieuLuc();

        String ngayHetHieuLucJSON = StringPool.BLANK;

        if (ngayHetHieuLuc != null) {
            ngayHetHieuLucJSON = String.valueOf(ngayHetHieuLuc.getTime());
        }

        jsonObj.put("ngayHetHieuLuc", ngayHetHieuLucJSON);
        jsonObj.put("maCoQuanBanHanh", model.getMaCoQuanBanHanh());
        jsonObj.put("tag_", model.getTag_());
        jsonObj.put("companyid", model.getCompanyid());
        jsonObj.put("userid", model.getUserid());

        Date createdate = model.getCreatedate();

        String createdateJSON = StringPool.BLANK;

        if (createdate != null) {
            createdateJSON = String.valueOf(createdate.getTime());
        }

        jsonObj.put("createdate", createdateJSON);

        Date modifieddate = model.getModifieddate();

        String modifieddateJSON = StringPool.BLANK;

        if (modifieddate != null) {
            modifieddateJSON = String.valueOf(modifieddate.getTime());
        }

        jsonObj.put("modifieddate", modifieddateJSON);
        jsonObj.put("active", model.getActive());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (VanBanPhapQuy model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (VanBanPhapQuy[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (VanBanPhapQuy model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
