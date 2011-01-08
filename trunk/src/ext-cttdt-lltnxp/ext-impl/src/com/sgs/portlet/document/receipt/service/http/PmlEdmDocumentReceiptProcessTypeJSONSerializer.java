package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptProcessTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptProcessTypeServiceJSON
 *
 */
public class PmlEdmDocumentReceiptProcessTypeJSONSerializer {
    public static JSONObject toJSONObject(
        PmlEdmDocumentReceiptProcessType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("docReceiptProcessTypeId",
            model.getDocReceiptProcessTypeId());
        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("documentReceiptLogId", model.getDocumentReceiptLogId());
        jsonObj.put("processTypeOrderNo", model.getProcessTypeOrderNo());

        Date dateEdit = model.getDateEdit();

        String dateEditJSON = StringPool.BLANK;

        if (dateEdit != null) {
            dateEditJSON = String.valueOf(dateEdit.getTime());
        }

        jsonObj.put("dateEdit", dateEditJSON);
        jsonObj.put("processTypeIdBefore", model.getProcessTypeIdBefore());
        jsonObj.put("processTypeIdAfter", model.getProcessTypeIdAfter());
        jsonObj.put("processTypeReason", model.getProcessTypeReason());
        jsonObj.put("processerId", model.getProcesserId());
        jsonObj.put("departmentId", model.getDepartmentId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentReceiptProcessType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
