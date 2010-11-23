package com.nss.portlet.thu_tuc_hanh_chinh.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;

import java.util.Date;
import java.util.List;


/**
 * <a href="ThuTucHanhChinhJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.http.ThuTucHanhChinhServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.http.ThuTucHanhChinhServiceJSON
 *
 */
public class ThuTucHanhChinhJSONSerializer {
    public static JSONObject toJSONObject(ThuTucHanhChinh model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maThuTucHanhChinh", model.getMaThuTucHanhChinh());
        jsonObj.put("tenThuTucHanhChinh", model.getTenThuTucHanhChinh());
        jsonObj.put("diaChiLienHe", model.getDiaChiLienHe());
        jsonObj.put("maLinhVucThuTucHanhChinh",
            model.getMaLinhVucThuTucHanhChinh());
        jsonObj.put("maDonViThuTucHanhChinh", model.getMaDonViThuTucHanhChinh());
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
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThuTucHanhChinh model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThuTucHanhChinh[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ThuTucHanhChinh model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
