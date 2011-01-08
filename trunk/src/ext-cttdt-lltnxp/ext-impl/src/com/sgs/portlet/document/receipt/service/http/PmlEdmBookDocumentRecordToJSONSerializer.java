package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentRecordToJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmBookDocumentRecordToServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmBookDocumentRecordToServiceJSON
 *
 */
public class PmlEdmBookDocumentRecordToJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmBookDocumentRecordTo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("documentRecordToId", model.getDocumentRecordToId());

        Date dateCreate = model.getDateCreate();

        String dateCreateJSON = StringPool.BLANK;

        if (dateCreate != null) {
            dateCreateJSON = String.valueOf(dateCreate.getTime());
        }

        jsonObj.put("dateCreate", dateCreateJSON);

        Date dateComplete = model.getDateComplete();

        String dateCompleteJSON = StringPool.BLANK;

        if (dateComplete != null) {
            dateCompleteJSON = String.valueOf(dateComplete.getTime());
        }

        jsonObj.put("dateComplete", dateCompleteJSON);
        jsonObj.put("soCongVanDenPhongHienTai",
            model.getSoCongVanDenPhongHienTai());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmBookDocumentRecordTo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
