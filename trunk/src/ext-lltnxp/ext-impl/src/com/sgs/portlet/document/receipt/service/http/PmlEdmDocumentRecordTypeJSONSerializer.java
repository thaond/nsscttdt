package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;

import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordTypeServiceJSON
 *
 */
public class PmlEdmDocumentRecordTypeJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentRecordType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentRecordTypeId", model.getDocumentRecordTypeId());
        jsonObj.put("documentRecordTypeName", model.getDocumentRecordTypeName());
        jsonObj.put("documentRecordTypeCode", model.getDocumentRecordTypeCode());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentRecordType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
