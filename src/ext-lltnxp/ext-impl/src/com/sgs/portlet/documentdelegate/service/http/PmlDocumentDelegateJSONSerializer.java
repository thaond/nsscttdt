package com.sgs.portlet.documentdelegate.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentDelegateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.documentdelegate.service.http.PmlDocumentDelegateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.documentdelegate.service.http.PmlDocumentDelegateServiceJSON
 *
 */
public class PmlDocumentDelegateJSONSerializer {
    public static JSONObject toJSONObject(PmlDocumentDelegate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentDelegateId", model.getDocumentDelegateId());
        jsonObj.put("userDelegateId", model.getUserDelegateId());
        jsonObj.put("userIsDelegateId", model.getUserIsDelegateId());
        jsonObj.put("documentId", model.getDocumentId());

        Date fromtDate = model.getFromtDate();

        String fromtDateJSON = StringPool.BLANK;

        if (fromtDate != null) {
            fromtDateJSON = String.valueOf(fromtDate.getTime());
        }

        jsonObj.put("fromtDate", fromtDateJSON);

        Date toDate = model.getToDate();

        String toDateJSON = StringPool.BLANK;

        if (toDate != null) {
            toDateJSON = String.valueOf(toDate.getTime());
        }

        jsonObj.put("toDate", toDateJSON);

        Date cancelDate = model.getCancelDate();

        String cancelDateJSON = StringPool.BLANK;

        if (cancelDate != null) {
            cancelDateJSON = String.valueOf(cancelDate.getTime());
        }

        jsonObj.put("cancelDate", cancelDateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDocumentDelegate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
