package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptServiceJSON
 *
 */
public class PmlEdmDocumentReceiptJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmDocumentReceipt model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("documentReceiptId", model.getDocumentReceiptId());
        jsonObj.put("levelSendId", model.getLevelSendId());
        jsonObj.put("documentTypeId", model.getDocumentTypeId());
        jsonObj.put("documentReference", model.getDocumentReference());
        jsonObj.put("issuingPlaceId", model.getIssuingPlaceId());

        Date issuingDate = model.getIssuingDate();

        String issuingDateJSON = StringPool.BLANK;

        if (issuingDate != null) {
            issuingDateJSON = String.valueOf(issuingDate.getTime());
        }

        jsonObj.put("issuingDate", issuingDateJSON);

        Date dateArrive = model.getDateArrive();

        String dateArriveJSON = StringPool.BLANK;

        if (dateArrive != null) {
            dateArriveJSON = String.valueOf(dateArrive.getTime());
        }

        jsonObj.put("dateArrive", dateArriveJSON);
        jsonObj.put("signer", model.getSigner());
        jsonObj.put("privilegeLevelId", model.getPrivilegeLevelId());
        jsonObj.put("confidentialLevelId", model.getConfidentialLevelId());
        jsonObj.put("opinion", model.getOpinion());
        jsonObj.put("briefContent", model.getBriefContent());
        jsonObj.put("isPublic", model.getIsPublic());
        jsonObj.put("numberDocumentReceipt", model.getNumberDocumentReceipt());
        jsonObj.put("processTime", model.getProcessTime());
        jsonObj.put("status", model.getStatus());
        jsonObj.put("active", model.getActive());
        jsonObj.put("numberLocalDocumentReceipt",
            model.getNumberLocalDocumentReceipt());
        jsonObj.put("issuingPlaceOtherName", model.getIssuingPlaceOtherName());
        jsonObj.put("documentType", model.getDocumentType());

        Date dateButPhe = model.getDateButPhe();

        String dateButPheJSON = StringPool.BLANK;

        if (dateButPhe != null) {
            dateButPheJSON = String.valueOf(dateButPhe.getTime());
        }

        jsonObj.put("dateButPhe", dateButPheJSON);

        Date dateHoanThanh = model.getDateHoanThanh();

        String dateHoanThanhJSON = StringPool.BLANK;

        if (dateHoanThanh != null) {
            dateHoanThanhJSON = String.valueOf(dateHoanThanh.getTime());
        }

        jsonObj.put("dateHoanThanh", dateHoanThanhJSON);
        jsonObj.put("statusId", model.getStatusId());
        jsonObj.put("thoigiannhancvden", model.getThoigiannhancvden());
        jsonObj.put("socongvandiphucdap", model.getSocongvandiphucdap());
        jsonObj.put("generalOrderNo", model.getGeneralOrderNo());
        jsonObj.put("mainDepartmentProcessId",
            model.getMainDepartmentProcessId());
        jsonObj.put("mainUserProcessId", model.getMainUserProcessId());
        jsonObj.put("orgExternalId", model.getOrgExternalId());
        jsonObj.put("docReceiptTempId", model.getDocReceiptTempId());
        jsonObj.put("documentRecordTypeId", model.getDocumentRecordTypeId());
        jsonObj.put("donViSaoY", model.getDonViSaoY());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmDocumentReceipt model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
