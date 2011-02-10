package com.sgs.portlet.document.send.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.send.model.PmlEdmCadre;

import java.util.List;


/**
 * <a href="PmlEdmCadreJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmCadreServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmCadreServiceJSON
 *
 */
public class PmlEdmCadreJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmCadre model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("positionId", model.getPositionId());
        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("handPhone", model.getHandPhone());
        jsonObj.put("note", model.getNote());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.send.model.PmlEdmCadre> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmCadre model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
