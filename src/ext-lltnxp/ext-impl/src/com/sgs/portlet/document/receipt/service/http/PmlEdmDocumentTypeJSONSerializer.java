package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;

import java.util.List;


/**
 * <a href="PmlEdmDocumentTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentTypeServiceJSON
 *
 */
public class PmlEdmDocumentTypeJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentTypeId", model.getDocumentTypeId());
        jsonObj.put("documentTypeName", model.getDocumentTypeName());
        jsonObj.put("documentSymbol", model.getDocumentSymbol());
        jsonObj.put("documentRecordTypeId", model.getDocumentRecordTypeId());
        jsonObj.put("sendReceiptDistinction", model.getSendReceiptDistinction());
        jsonObj.put("HaveDepartExtends", model.getHaveDepartExtends());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
