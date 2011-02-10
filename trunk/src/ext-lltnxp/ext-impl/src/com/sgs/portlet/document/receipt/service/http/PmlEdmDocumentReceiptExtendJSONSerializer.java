package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptExtendJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptExtendServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptExtendServiceJSON
 *
 */
public class PmlEdmDocumentReceiptExtendJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentReceiptExtend model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentReceiptExtendId",
            model.getDocumentReceiptExtendId());
        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("documentReceiptLogId", model.getDocumentReceiptLogId());
        jsonObj.put("extendOrderNo", model.getExtendOrderNo());

        Date startProcessDate = model.getStartProcessDate();

        String startProcessDateJSON = StringPool.BLANK;

        if (startProcessDate != null) {
            startProcessDateJSON = String.valueOf(startProcessDate.getTime());
        }

        jsonObj.put("startProcessDate", startProcessDateJSON);
        jsonObj.put("numDayProcessBef", model.getNumDayProcessBef());

        Date limitDateBef = model.getLimitDateBef();

        String limitDateBefJSON = StringPool.BLANK;

        if (limitDateBef != null) {
            limitDateBefJSON = String.valueOf(limitDateBef.getTime());
        }

        jsonObj.put("limitDateBef", limitDateBefJSON);
        jsonObj.put("extendReason", model.getExtendReason());
        jsonObj.put("numDayProcessAft", model.getNumDayProcessAft());

        Date limitDateAft = model.getLimitDateAft();

        String limitDateAftJSON = StringPool.BLANK;

        if (limitDateAft != null) {
            limitDateAftJSON = String.valueOf(limitDateAft.getTime());
        }

        jsonObj.put("limitDateAft", limitDateAftJSON);
        jsonObj.put("leanOnLimitDate", model.getLeanOnLimitDate());
        jsonObj.put("extendUserId", model.getExtendUserId());
        jsonObj.put("extendDepartmentId", model.getExtendDepartmentId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentReceiptExtend model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
