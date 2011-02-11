package com.sgs.portlet.pml_ho_so_cong_viec.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHoSoCongViecJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlHoSoCongViecServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlHoSoCongViecServiceJSON
 *
 */
public class PmlHoSoCongViecJSONSerializer {
    public static JSONObject toJSONObject(PmlHoSoCongViec model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("idHoSoCongViec", model.getIdHoSoCongViec());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("userName", model.getUserName());
        jsonObj.put("idHSCVCha", model.getIdHSCVCha());
        jsonObj.put("soHieuHSCV", model.getSoHieuHSCV());
        jsonObj.put("tieuDe", model.getTieuDe());

        Date ngayMoHSCV = model.getNgayMoHSCV();

        String ngayMoHSCVJSON = StringPool.BLANK;

        if (ngayMoHSCV != null) {
            ngayMoHSCVJSON = String.valueOf(ngayMoHSCV.getTime());
        }

        jsonObj.put("ngayMoHSCV", ngayMoHSCVJSON);

        Date hanXuLy = model.getHanXuLy();

        String hanXuLyJSON = StringPool.BLANK;

        if (hanXuLy != null) {
            hanXuLyJSON = String.valueOf(hanXuLy.getTime());
        }

        jsonObj.put("hanXuLy", hanXuLyJSON);
        jsonObj.put("idLinhVuc", model.getIdLinhVuc());
        jsonObj.put("vanDeLienQuan", model.getVanDeLienQuan());
        jsonObj.put("idDoQuanTrong", model.getIdDoQuanTrong());
        jsonObj.put("idTinhChat", model.getIdTinhChat());
        jsonObj.put("idTrangThaiHSCV", model.getIdTrangThaiHSCV());
        jsonObj.put("tomTatNoiDung", model.getTomTatNoiDung());
        jsonObj.put("hoatDong", model.getHoatDong());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlHoSoCongViec model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
