package com.sgs.portlet.document_manager.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document_manager.model.AttactFileDocument;

import java.util.List;


/**
 * <a href="AttactFileDocumentJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document_manager.service.http.AttactFileDocumentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.http.AttactFileDocumentServiceJSON
 *
 */
public class AttactFileDocumentJSONSerializer {
    public static JSONObject toJSONObject(AttactFileDocument model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("attactFileDocumentId", model.getAttactFileDocumentId());
        jsonObj.put("attactFileDocumentTitle",
            model.getAttactFileDocumentTitle());
        jsonObj.put("attactFileDocumentPath", model.getAttactFileDocumentPath());
        jsonObj.put("documentManagerId", model.getDocumentManagerId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document_manager.model.AttactFileDocument> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (AttactFileDocument model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
