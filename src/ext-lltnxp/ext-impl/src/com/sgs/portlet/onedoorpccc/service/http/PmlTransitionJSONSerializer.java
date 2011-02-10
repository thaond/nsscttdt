package com.sgs.portlet.onedoorpccc.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoorpccc.model.PmlTransition;

import java.util.List;


/**
 * <a href="PmlTransitionJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlTransitionServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlTransitionServiceJSON
 *
 */
public class PmlTransitionJSONSerializer {
    public static JSONObject toJSONObject(PmlTransition model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("transitionId", model.getTransitionId());
        jsonObj.put("transitionName", model.getTransitionName());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("noTransition", model.getNoTransition());
        jsonObj.put("stateProcessCurrent", model.getStateProcessCurrent());
        jsonObj.put("stateProcessNext", model.getStateProcessNext());
        jsonObj.put("version_", model.getVersion_());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoorpccc.model.PmlTransition> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTransition model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
