package com.sgs.portlet.document_manager.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document_manager.model.DocumentManager;

import java.util.Date;
import java.util.List;


/**
 * <a href="DocumentManagerJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document_manager.service.http.DocumentManagerServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.http.DocumentManagerServiceJSON
 *
 */
public class DocumentManagerJSONSerializer {
    public static JSONObject toJSONObject(DocumentManager model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentManagerId", model.getDocumentManagerId());
        jsonObj.put("documentManagerCode", model.getDocumentManagerCode());
        jsonObj.put("documentManagerCategory",
            model.getDocumentManagerCategory());
        jsonObj.put("documentManagerStyle", model.getDocumentManagerStyle());
        jsonObj.put("documentManagerDescription",
            model.getDocumentManagerDescription());

        Date documentManagerDateCreate = model.getDocumentManagerDateCreate();

        String documentManagerDateCreateJSON = StringPool.BLANK;

        if (documentManagerDateCreate != null) {
            documentManagerDateCreateJSON = String.valueOf(documentManagerDateCreate.getTime());
        }

        jsonObj.put("documentManagerDateCreate", documentManagerDateCreateJSON);
        jsonObj.put("documentManagerTitle", model.getDocumentManagerTitle());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document_manager.model.DocumentManager> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (DocumentManager model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
