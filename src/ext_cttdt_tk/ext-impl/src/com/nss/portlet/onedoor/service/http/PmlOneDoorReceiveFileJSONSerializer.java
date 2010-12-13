package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlOneDoorReceiveFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlOneDoorReceiveFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlOneDoorReceiveFileServiceJSON
 *
 */
public class PmlOneDoorReceiveFileJSONSerializer {
    public static JSONObject toJSONObject(PmlOneDoorReceiveFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("cityId", model.getCityId());
        jsonObj.put("districtId", model.getDistrictId());
        jsonObj.put("wardsId", model.getWardsId());
        jsonObj.put("streetId", model.getStreetId());

        Date exactReturningDate = model.getExactReturningDate();

        String exactReturningDateJSON = StringPool.BLANK;

        if (exactReturningDate != null) {
            exactReturningDateJSON = String.valueOf(exactReturningDate.getTime());
        }

        jsonObj.put("exactReturningDate", exactReturningDateJSON);
        jsonObj.put("receiverId", model.getReceiverId());

        Date validDate = model.getValidDate();

        String validDateJSON = StringPool.BLANK;

        if (validDate != null) {
            validDateJSON = String.valueOf(validDate.getTime());
        }

        jsonObj.put("validDate", validDateJSON);

        Date expectedReturningDate = model.getExpectedReturningDate();

        String expectedReturningDateJSON = StringPool.BLANK;

        if (expectedReturningDate != null) {
            expectedReturningDateJSON = String.valueOf(expectedReturningDate.getTime());
        }

        jsonObj.put("expectedReturningDate", expectedReturningDateJSON);

        Date applicationDate = model.getApplicationDate();

        String applicationDateJSON = StringPool.BLANK;

        if (applicationDate != null) {
            applicationDateJSON = String.valueOf(applicationDate.getTime());
        }

        jsonObj.put("applicationDate", applicationDateJSON);
        jsonObj.put("otherContent", model.getOtherContent());
        jsonObj.put("briefContent", model.getBriefContent());
        jsonObj.put("applicantName", model.getApplicantName());
        jsonObj.put("organization", model.getOrganization());
        jsonObj.put("authorisedLetter", model.getAuthorisedLetter());
        jsonObj.put("idNumber", model.getIdNumber());

        Date issuingDate = model.getIssuingDate();

        String issuingDateJSON = StringPool.BLANK;

        if (issuingDate != null) {
            issuingDateJSON = String.valueOf(issuingDate.getTime());
        }

        jsonObj.put("issuingDate", issuingDateJSON);
        jsonObj.put("issuingPlace", model.getIssuingPlace());
        jsonObj.put("telephone", model.getTelephone());
        jsonObj.put("gender", model.getGender());
        jsonObj.put("streetNumber", model.getStreetNumber());
        jsonObj.put("permanentAddress", model.getPermanentAddress());
        jsonObj.put("contactInfomation", model.getContactInfomation());
        jsonObj.put("oldNumberReceipt", model.getOldNumberReceipt());
        jsonObj.put("numberReceipt", model.getNumberReceipt());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("fieldId", model.getFieldId());
        jsonObj.put("solvingTime", model.getSolvingTime());
        jsonObj.put("amendedContent", model.getAmendedContent());

        Date landCheckingDate = model.getLandCheckingDate();

        String landCheckingDateJSON = StringPool.BLANK;

        if (landCheckingDate != null) {
            landCheckingDateJSON = String.valueOf(landCheckingDate.getTime());
        }

        jsonObj.put("landCheckingDate", landCheckingDateJSON);
        jsonObj.put("decisionNotice", model.getDecisionNotice());
        jsonObj.put("receiver", model.getReceiver());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);

        Date lastUpdate = model.getLastUpdate();

        String lastUpdateJSON = StringPool.BLANK;

        if (lastUpdate != null) {
            lastUpdateJSON = String.valueOf(lastUpdate.getTime());
        }

        jsonObj.put("lastUpdate", lastUpdateJSON);
        jsonObj.put("lastTestProcessInfo", model.getLastTestProcessInfo());
        jsonObj.put("active", model.getActive());
        jsonObj.put("generalorderno", model.getGeneralorderno());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlOneDoorReceiveFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlOneDoorReceiveFile[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlOneDoorReceiveFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
