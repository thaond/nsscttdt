package com.sgs.portlet.onedoorpccc.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoorpccc.model.PmlPaintDocument;

import java.util.List;


/**
 * <a href="PmlPaintDocumentJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlPaintDocumentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlPaintDocumentServiceJSON
 *
 */
public class PmlPaintDocumentJSONSerializer {
    public static JSONObject toJSONObject(PmlPaintDocument model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("paintDocumentId", model.getPaintDocumentId());
        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("paintDocumentName", model.getPaintDocumentName());
        jsonObj.put("quantity", model.getQuantity());
        jsonObj.put("note", model.getNote());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlPaintDocument model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
