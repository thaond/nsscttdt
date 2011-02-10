package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;

import java.util.List;


/**
 * <a href="PmlEdmPrivilegeLevelJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmPrivilegeLevelServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmPrivilegeLevelServiceJSON
 *
 */
public class PmlEdmPrivilegeLevelJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmPrivilegeLevel model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("privilegeLevelId", model.getPrivilegeLevelId());
        jsonObj.put("privilegeLevelName", model.getPrivilegeLevelName());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmPrivilegeLevel model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
