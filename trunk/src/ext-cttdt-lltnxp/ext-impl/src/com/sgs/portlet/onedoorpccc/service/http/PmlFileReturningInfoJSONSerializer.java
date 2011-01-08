package com.sgs.portlet.onedoorpccc.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFileReturningInfoJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlFileReturningInfoServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlFileReturningInfoServiceJSON
 *
 */
public class PmlFileReturningInfoJSONSerializer {
    public static JSONObject toJSONObject(PmlFileReturningInfo model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileReturningInfoId", model.getFileReturningInfoId());
        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("fileSender", model.getFileSender());
        jsonObj.put("licenseNumber", model.getLicenseNumber());

        Date issuingDateLicense = model.getIssuingDateLicense();

        String issuingDateLicenseJSON = StringPool.BLANK;

        if (issuingDateLicense != null) {
            issuingDateLicenseJSON = String.valueOf(issuingDateLicense.getTime());
        }

        jsonObj.put("issuingDateLicense", issuingDateLicenseJSON);

        Date receiveLicenseDate = model.getReceiveLicenseDate();

        String receiveLicenseDateJSON = StringPool.BLANK;

        if (receiveLicenseDate != null) {
            receiveLicenseDateJSON = String.valueOf(receiveLicenseDate.getTime());
        }

        jsonObj.put("receiveLicenseDate", receiveLicenseDateJSON);
        jsonObj.put("documentNumber", model.getDocumentNumber());
        jsonObj.put("billNumber", model.getBillNumber());
        jsonObj.put("numberMoney", model.getNumberMoney());
        jsonObj.put("note", model.getNote());
        jsonObj.put("conclude", model.getConclude());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileReturningInfo model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
