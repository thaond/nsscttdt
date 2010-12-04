package com.nss.portlet.delegate.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.delegate.model.PmlDelegate;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDelegateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.delegate.service.http.PmlDelegateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.delegate.service.http.PmlDelegateServiceJSON
 *
 */
public class PmlDelegateJSONSerializer {
    public static JSONObject toJSONObject(PmlDelegate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("delegateId", model.getDelegateId());
        jsonObj.put("assigner", model.getAssigner());
        jsonObj.put("receiver", model.getReceiver());

        Date startDate = model.getStartDate();

        String startDateJSON = StringPool.BLANK;

        if (startDate != null) {
            startDateJSON = String.valueOf(startDate.getTime());
        }

        jsonObj.put("startDate", startDateJSON);

        Date endDate = model.getEndDate();

        String endDateJSON = StringPool.BLANK;

        if (endDate != null) {
            endDateJSON = String.valueOf(endDate.getTime());
        }

        jsonObj.put("endDate", endDateJSON);

        Date cancelDate = model.getCancelDate();

        String cancelDateJSON = StringPool.BLANK;

        if (cancelDate != null) {
            cancelDateJSON = String.valueOf(cancelDate.getTime());
        }

        jsonObj.put("cancelDate", cancelDateJSON);
        jsonObj.put("cancelDelegate", model.getCancelDelegate());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.delegate.model.PmlDelegate[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDelegate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.delegate.model.PmlDelegate[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDelegate[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.delegate.model.PmlDelegate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDelegate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
