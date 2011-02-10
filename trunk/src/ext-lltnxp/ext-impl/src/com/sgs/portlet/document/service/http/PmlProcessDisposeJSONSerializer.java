package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.model.PmlProcessDispose;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlProcessDisposeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlProcessDisposeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlProcessDisposeServiceJSON
 *
 */
public class PmlProcessDisposeJSONSerializer {
    public static JSONObject toJSONObject(PmlProcessDispose model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("processDisposeId", model.getProcessDisposeId());
        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("transition_", model.getTransition_());
        jsonObj.put("processer", model.getProcesser());

        Date dateProcess = model.getDateProcess();

        String dateProcessJSON = StringPool.BLANK;

        if (dateProcess != null) {
            dateProcessJSON = String.valueOf(dateProcess.getTime());
        }

        jsonObj.put("dateProcess", dateProcessJSON);
        jsonObj.put("processInfomation", model.getProcessInfomation());
        jsonObj.put("receiver", model.getReceiver());

        Date receiveDate = model.getReceiveDate();

        String receiveDateJSON = StringPool.BLANK;

        if (receiveDate != null) {
            receiveDateJSON = String.valueOf(receiveDate.getTime());
        }

        jsonObj.put("receiveDate", receiveDateJSON);
        jsonObj.put("stateProcessIdBefore", model.getStateProcessIdBefore());
        jsonObj.put("stateProcessIdAfter", model.getStateProcessIdAfter());

        Date expiredDate = model.getExpiredDate();

        String expiredDateJSON = StringPool.BLANK;

        if (expiredDate != null) {
            expiredDateJSON = String.valueOf(expiredDate.getTime());
        }

        jsonObj.put("expiredDate", expiredDateJSON);
        jsonObj.put("delegateUser", model.getDelegateUser());

        Date sendDate = model.getSendDate();

        String sendDateJSON = StringPool.BLANK;

        if (sendDate != null) {
            sendDateJSON = String.valueOf(sendDate.getTime());
        }

        jsonObj.put("sendDate", sendDateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlProcessDispose> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlProcessDispose model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
