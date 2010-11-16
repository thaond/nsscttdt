package com.nss.portlet.qa_cau_hoi.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;

import java.util.Date;
import java.util.List;


/**
 * <a href="CauHoiQAJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_hoi.service.http.CauHoiQAServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.http.CauHoiQAServiceJSON
 *
 */
public class CauHoiQAJSONSerializer {
    public static JSONObject toJSONObject(CauHoiQA model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maCauHoiQA", model.getMaCauHoiQA());
        jsonObj.put("maChuDeCauHoi", model.getMaChuDeCauHoi());
        jsonObj.put("tieuDe", model.getTieuDe());
        jsonObj.put("tenNguoiHoi", model.getTenNguoiHoi());
        jsonObj.put("email", model.getEmail());
        jsonObj.put("noiDungHoi", model.getNoiDungHoi());

        Date createdate = model.getCreatedate();

        String createdateJSON = StringPool.BLANK;

        if (createdate != null) {
            createdateJSON = String.valueOf(createdate.getTime());
        }

        jsonObj.put("createdate", createdateJSON);

        Date publishdate = model.getPublishdate();

        String publishdateJSON = StringPool.BLANK;

        if (publishdate != null) {
            publishdateJSON = String.valueOf(publishdate.getTime());
        }

        jsonObj.put("publishdate", publishdateJSON);
        jsonObj.put("publish", model.getPublish());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauHoiQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauHoiQA[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauHoiQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
