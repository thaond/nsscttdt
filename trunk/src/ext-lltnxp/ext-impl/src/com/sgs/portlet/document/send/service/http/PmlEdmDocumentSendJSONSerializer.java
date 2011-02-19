package com.sgs.portlet.document.send.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentSendJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmDocumentSendServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmDocumentSendServiceJSON
 *
 */
public class PmlEdmDocumentSendJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentSend model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentSendId", model.getDocumentSendId());
        jsonObj.put("briefContent", model.getBriefContent());
        jsonObj.put("documentReference", model.getDocumentReference());
        jsonObj.put("receivingPlace", model.getReceivingPlace());

        Date issuingDate = model.getIssuingDate();

        String issuingDateJSON = StringPool.BLANK;

        if (issuingDate != null) {
            issuingDateJSON = String.valueOf(issuingDate.getTime());
        }

        jsonObj.put("issuingDate", issuingDateJSON);
        jsonObj.put("opinion", model.getOpinion());
        jsonObj.put("editorId", model.getEditorId());
        jsonObj.put("signerId", model.getSignerId());
        jsonObj.put("documentTypeId", model.getDocumentTypeId());
        jsonObj.put("privilegeLevelId", model.getPrivilegeLevelId());
        jsonObj.put("confidentialLevelId", model.getConfidentialLevelId());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);
        jsonObj.put("isLocal", model.getIsLocal());
        jsonObj.put("active", model.getActive());

        Date sendDate = model.getSendDate();

        String sendDateJSON = StringPool.BLANK;

        if (sendDate != null) {
            sendDateJSON = String.valueOf(sendDate.getTime());
        }

        jsonObj.put("sendDate", sendDateJSON);
        jsonObj.put("signerName", model.getSignerName());
        jsonObj.put("position", model.getPosition());
        jsonObj.put("numberPage", model.getNumberPage());
        jsonObj.put("numberPublish", model.getNumberPublish());
        jsonObj.put("documentSendCode", model.getDocumentSendCode());
        jsonObj.put("statusId", model.getStatusId());
        jsonObj.put("iscongvanphucdap", model.getIscongvanphucdap());
        jsonObj.put("numOfDocRef", model.getNumOfDocRef());
        jsonObj.put("isPublish", model.getIsPublish());
        jsonObj.put("orgExternalId", model.getOrgExternalId());
        jsonObj.put("numOfDirector", model.getNumOfDirector());
        jsonObj.put("documentRecordTypeId", model.getDocumentRecordTypeId());
        jsonObj.put("isDocOfDepartment", model.getIsDocOfDepartment());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentSend model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
