package com.sgs.portlet.document.send.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;

import java.util.List;


/**
 * <a href="PmlEdmAnswerDetailJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmAnswerDetailServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmAnswerDetailServiceJSON
 *
 */
public class PmlEdmAnswerDetailJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmAnswerDetail model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("documentSendId", model.getDocumentSendId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmAnswerDetail model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
