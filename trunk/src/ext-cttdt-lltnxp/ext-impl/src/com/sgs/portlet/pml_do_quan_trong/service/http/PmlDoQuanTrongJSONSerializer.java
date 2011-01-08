package com.sgs.portlet.pml_do_quan_trong.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;

import java.util.List;


/**
 * <a href="PmlDoQuanTrongJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_do_quan_trong.service.http.PmlDoQuanTrongServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.service.http.PmlDoQuanTrongServiceJSON
 *
 */
public class PmlDoQuanTrongJSONSerializer {
    public static JSONObject toJSONObject(PmlDoQuanTrong model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("idDoQuanTrong", model.getIdDoQuanTrong());
        jsonObj.put("tenDoQuanTrong", model.getTenDoQuanTrong());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDoQuanTrong model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
