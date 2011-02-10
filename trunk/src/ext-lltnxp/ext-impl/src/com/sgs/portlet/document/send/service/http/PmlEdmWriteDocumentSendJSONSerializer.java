package com.sgs.portlet.document.send.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmWriteDocumentSendJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmWriteDocumentSendServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmWriteDocumentSendServiceJSON
 *
 */
public class PmlEdmWriteDocumentSendJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmWriteDocumentSend model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("bookDocumentSendId", model.getBookDocumentSendId());
        jsonObj.put("documentSendId", model.getDocumentSendId());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);
        jsonObj.put("soCongVanDiPhongHienTai",
            model.getSoCongVanDiPhongHienTai());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmWriteDocumentSend model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
