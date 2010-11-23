package com.nss.portlet.qa_cau_tra_loi.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;

import java.util.Date;
import java.util.List;


/**
 * <a href="CauTraLoiQAJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_tra_loi.service.http.CauTraLoiQAServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.service.http.CauTraLoiQAServiceJSON
 *
 */
public class CauTraLoiQAJSONSerializer {
    public static JSONObject toJSONObject(CauTraLoiQA model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maCauTraLoiQA", model.getMaCauTraLoiQA());
        jsonObj.put("maCauHoiQA", model.getMaCauHoiQA());
        jsonObj.put("maNguoiTraLoi", model.getMaNguoiTraLoi());
        jsonObj.put("noiDungTraLoi", model.getNoiDungTraLoi());

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
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauTraLoiQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauTraLoiQA[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CauTraLoiQA model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
