package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.model.PmlEdmDocumentRelation;

import java.util.List;


/**
 * <a href="PmlEdmDocumentRelationJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlEdmDocumentRelationServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlEdmDocumentRelationServiceJSON
 *
 */
public class PmlEdmDocumentRelationJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentRelation model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentRelationId", model.getDocumentRelationId());
        jsonObj.put("docLeftId", model.getDocLeftId());
        jsonObj.put("docRightId", model.getDocRightId());
        jsonObj.put("leftIsReceipt", model.getLeftIsReceipt());
        jsonObj.put("rightIsReceipt", model.getRightIsReceipt());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentRelation model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
