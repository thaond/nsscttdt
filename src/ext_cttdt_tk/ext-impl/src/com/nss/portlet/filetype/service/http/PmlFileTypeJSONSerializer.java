package com.nss.portlet.filetype.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.filetype.model.PmlFileType;

import java.util.List;


/**
 * <a href="PmlFileTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.filetype.service.http.PmlFileTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.http.PmlFileTypeServiceJSON
 *
 */
public class PmlFileTypeJSONSerializer {
    public static JSONObject toJSONObject(PmlFileType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("fileTypeCode", model.getFileTypeCode());
        jsonObj.put("fileTypeName", model.getFileTypeName());
        jsonObj.put("fieldId", model.getFieldId());
        jsonObj.put("templateId", model.getTemplateId());
        jsonObj.put("processTime", model.getProcessTime());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());
        jsonObj.put("currentReceiptNumber", model.getCurrentReceiptNumber());
        jsonObj.put("receiptTemplate", model.getReceiptTemplate());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.filetype.model.PmlFileType[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.filetype.model.PmlFileType[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileType[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.filetype.model.PmlFileType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
