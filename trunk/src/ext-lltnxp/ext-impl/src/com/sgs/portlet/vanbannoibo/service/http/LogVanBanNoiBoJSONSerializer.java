package com.sgs.portlet.vanbannoibo.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo;

import java.util.Date;
import java.util.List;


/**
 * <a href="LogVanBanNoiBoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.LogVanBanNoiBoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.LogVanBanNoiBoServiceJSON
 *
 */
public class LogVanBanNoiBoJSONSerializer {
    public static JSONObject toJSONObject(LogVanBanNoiBo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("logVanBanNoiBoId", model.getLogVanBanNoiBoId());
        jsonObj.put("buocLuanChuyen", model.getBuocLuanChuyen());
        jsonObj.put("nguoiXuLy", model.getNguoiXuLy());

        Date ngayXuLy = model.getNgayXuLy();

        String ngayXuLyJSON = StringPool.BLANK;

        if (ngayXuLy != null) {
            ngayXuLyJSON = String.valueOf(ngayXuLy.getTime());
        }

        jsonObj.put("ngayXuLy", ngayXuLyJSON);
        jsonObj.put("nguoiNhan", model.getNguoiNhan());

        Date ngayNhan = model.getNgayNhan();

        String ngayNhanJSON = StringPool.BLANK;

        if (ngayNhan != null) {
            ngayNhanJSON = String.valueOf(ngayNhan.getTime());
        }

        jsonObj.put("ngayNhan", ngayNhanJSON);
        jsonObj.put("trangThaiTruoc", model.getTrangThaiTruoc());
        jsonObj.put("trangThaiSau", model.getTrangThaiSau());

        Date ngayGui = model.getNgayGui();

        String ngayGuiJSON = StringPool.BLANK;

        if (ngayGui != null) {
            ngayGuiJSON = String.valueOf(ngayGui.getTime());
        }

        jsonObj.put("ngayGui", ngayGuiJSON);
        jsonObj.put("phongXuLyChinh", model.getPhongXuLyChinh());
        jsonObj.put("nguoiXuLyChinh", model.getNguoiXuLyChinh());
        jsonObj.put("loaiQuyTrinh", model.getLoaiQuyTrinh());

        Date ngayHetHan = model.getNgayHetHan();

        String ngayHetHanJSON = StringPool.BLANK;

        if (ngayHetHan != null) {
            ngayHetHanJSON = String.valueOf(ngayHetHan.getTime());
        }

        jsonObj.put("ngayHetHan", ngayHetHanJSON);
        jsonObj.put("soNgayXuLy", model.getSoNgayXuLy());
        jsonObj.put("processInstanceId", model.getProcessInstanceId());
        jsonObj.put("thongTinXuLy", model.getThongTinXuLy());
        jsonObj.put("step", model.getStep());
        jsonObj.put("nguoiXuLyTrucTiep", model.getNguoiXuLyTrucTiep());
        jsonObj.put("phongXuLy", model.getPhongXuLy());
        jsonObj.put("phongNhan", model.getPhongNhan());
        jsonObj.put("vanBanHoanThanhHayChua", model.getVanBanHoanThanhHayChua());
        jsonObj.put("vanBanNoiBoId", model.getVanBanNoiBoId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (LogVanBanNoiBo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
