package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.model.PmlDocumentReceiptWF;

import java.util.List;


/**
 * <a href="PmlDocumentReceiptWFJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentReceiptWFServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentReceiptWFServiceJSON
 *
 */
public class PmlDocumentReceiptWFJSONSerializer {
    public static JSONObject toJSONObject(PmlDocumentReceiptWF model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("processId", model.getProcessId());
        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("isMain", model.getIsMain());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDocumentReceiptWF model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
