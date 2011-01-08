package com.sgs.portlet.organizationexternal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.organizationexternal.model.OrganizationExternal;

import java.util.List;


/**
 * <a href="OrganizationExternalJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.organizationexternal.service.http.OrganizationExternalServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.service.http.OrganizationExternalServiceJSON
 *
 */
public class OrganizationExternalJSONSerializer {
    public static JSONObject toJSONObject(OrganizationExternal model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("orgExternalId", model.getOrgExternalId());
        jsonObj.put("orgExternalCode", model.getOrgExternalCode());
        jsonObj.put("orgExternalName", model.getOrgExternalName());
        jsonObj.put("isOwnerOrg", model.getIsOwnerOrg());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (OrganizationExternal model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
