package com.sgs.portlet.document.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.model.PmlDocumentSendLog;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentSendLogJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentSendLogServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentSendLogServiceJSON
 *
 */
public class PmlDocumentSendLogJSONSerializer {
    public static JSONObject toJSONObject(PmlDocumentSendLog model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentSendLogId", model.getDocumentSendLogId());
        jsonObj.put("documentSendId", model.getDocumentSendId());
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
        jsonObj.put("numDateProcess", model.getNumDateProcess());
        jsonObj.put("processInstanceId", model.getProcessInstanceId());
        jsonObj.put("type_", model.getType_());

        Date sendDateBefore = model.getSendDateBefore();

        String sendDateBeforeJSON = StringPool.BLANK;

        if (sendDateBefore != null) {
            sendDateBeforeJSON = String.valueOf(sendDateBefore.getTime());
        }

        jsonObj.put("sendDateBefore", sendDateBeforeJSON);
        jsonObj.put("departmentReceiveId", model.getDepartmentReceiveId());
        jsonObj.put("departmentProcessId", model.getDepartmentProcessId());

        Date dateProcessTime = model.getDateProcessTime();

        String dateProcessTimeJSON = StringPool.BLANK;

        if (dateProcessTime != null) {
            dateProcessTimeJSON = String.valueOf(dateProcessTime.getTime());
        }

        jsonObj.put("dateProcessTime", dateProcessTimeJSON);

        Date receiveDateTime = model.getReceiveDateTime();

        String receiveDateTimeJSON = StringPool.BLANK;

        if (receiveDateTime != null) {
            receiveDateTimeJSON = String.valueOf(receiveDateTime.getTime());
        }

        jsonObj.put("receiveDateTime", receiveDateTimeJSON);
        jsonObj.put("directProcesserId", model.getDirectProcesserId());
        jsonObj.put("step", model.getStep());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.model.PmlDocumentSendLog> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlDocumentSendLog model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
