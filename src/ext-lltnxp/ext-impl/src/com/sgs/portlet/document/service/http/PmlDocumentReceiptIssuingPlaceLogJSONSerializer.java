package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentReceiptIssuingPlaceLogServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentReceiptIssuingPlaceLogServiceJSON
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogJSONSerializer {
    public static JSONObject toJSONObject(
        PmlDocumentReceiptIssuingPlaceLog model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentReceiptIssuingPlaceLogId",
            model.getDocumentReceiptIssuingPlaceLogId());
        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("processor", model.getProcessor());
        jsonObj.put("directProcessorId", model.getDirectProcessorId());

        Date dateProcess = model.getDateProcess();

        String dateProcessJSON = StringPool.BLANK;

        if (dateProcess != null) {
            dateProcessJSON = String.valueOf(dateProcess.getTime());
        }

        jsonObj.put("dateProcess", dateProcessJSON);
        jsonObj.put("processInfomation", model.getProcessInfomation());
        jsonObj.put("receiver", model.getReceiver());
        jsonObj.put("type_", model.getType_());
        jsonObj.put("step", model.getStep());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDocumentReceiptIssuingPlaceLog model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
