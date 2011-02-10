package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmProcessDocumentReceiptDetailServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmProcessDocumentReceiptDetailServiceJSON
 *
 */
public class PmlEdmProcessDocumentReceiptDetailJSONSerializer {
    public static JSONObject toJSONObject(
        PmlEdmProcessDocumentReceiptDetail model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("id", model.getId());
        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("note", model.getNote());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);

        Date dateUpdate = model.getDateUpdate();

        String dateUpdateJSON = StringPool.BLANK;

        if (dateUpdate != null) {
            dateUpdateJSON = String.valueOf(dateUpdate.getTime());
        }

        jsonObj.put("dateUpdate", dateUpdateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmProcessDocumentReceiptDetail model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
