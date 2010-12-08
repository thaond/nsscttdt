package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.onedoor.model.PmlFilePCCC;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFilePCCCServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFilePCCCServiceJSON
 *
 */
public class PmlFilePCCCJSONSerializer {
    public static JSONObject toJSONObject(PmlFilePCCC model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("fileName", model.getFileName());
        jsonObj.put("applicantRepresentation",
            model.getApplicantRepresentation());
        jsonObj.put("applicantTelephone", model.getApplicantTelephone());
        jsonObj.put("receiverRepresentation", model.getReceiverRepresentation());
        jsonObj.put("receiverTelephone", model.getReceiverTelephone());
        jsonObj.put("projectName", model.getProjectName());
        jsonObj.put("applicantCategory", model.getApplicantCategory());
        jsonObj.put("addressBuilder", model.getAddressBuilder());
        jsonObj.put("investor", model.getInvestor());
        jsonObj.put("designCop", model.getDesignCop());
        jsonObj.put("fileNumber", model.getFileNumber());

        Date inputDataDate = model.getInputDataDate();

        String inputDataDateJSON = StringPool.BLANK;

        if (inputDataDate != null) {
            inputDataDateJSON = String.valueOf(inputDataDate.getTime());
        }

        jsonObj.put("inputDataDate", inputDataDateJSON);
        jsonObj.put("noteInformationManagement",
            model.getNoteInformationManagement());
        jsonObj.put("totalHour", model.getTotalHour());
        jsonObj.put("totalDate", model.getTotalDate());
        jsonObj.put("conclusion", model.getConclusion());
        jsonObj.put("receiveOfUnit", model.getReceiveOfUnit());
        jsonObj.put("applicantTime", model.getApplicantTime());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFilePCCC[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCC model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFilePCCC[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCC[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlFilePCCC> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCC model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
