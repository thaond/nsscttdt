package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordToJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordToServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordToServiceJSON
 *
 */
public class PmlEdmDocumentRecordToJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentRecordTo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentRecordToId", model.getDocumentRecordToId());

        Date dateCreate = model.getDateCreate();

        String dateCreateJSON = StringPool.BLANK;

        if (dateCreate != null) {
            dateCreateJSON = String.valueOf(dateCreate.getTime());
        }

        jsonObj.put("dateCreate", dateCreateJSON);
        jsonObj.put("currentRecord", model.getCurrentRecord());
        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("documentRecordTypeId", model.getDocumentRecordTypeId());
        jsonObj.put("yearInUse", model.getYearInUse());
        jsonObj.put("active", model.getActive());
        jsonObj.put("isAgency", model.getIsAgency());
        jsonObj.put("agencyId", model.getAgencyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentRecordTo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
