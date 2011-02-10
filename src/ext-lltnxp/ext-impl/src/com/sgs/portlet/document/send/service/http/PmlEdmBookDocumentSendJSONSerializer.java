package com.sgs.portlet.document.send.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentSendJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmBookDocumentSendServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmBookDocumentSendServiceJSON
 *
 */
public class PmlEdmBookDocumentSendJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmBookDocumentSend model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("bookDocumentSendId", model.getBookDocumentSendId());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);
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
        List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmBookDocumentSend model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
