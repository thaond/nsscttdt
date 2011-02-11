package com.sgs.portlet.pml_edm_docconfuser.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;

import java.util.List;


/**
 * <a href="PmlEdmDocConfUserJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.http.PmlEdmDocConfUserServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_edm_docconfuser.service.http.PmlEdmDocConfUserServiceJSON
 *
 */
public class PmlEdmDocConfUserJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocConfUser model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("dcuId", model.getDcuId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("viewAllDoc", model.getViewAllDoc());
        jsonObj.put("viewDepDoc", model.getViewDepDoc());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocConfUser model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
