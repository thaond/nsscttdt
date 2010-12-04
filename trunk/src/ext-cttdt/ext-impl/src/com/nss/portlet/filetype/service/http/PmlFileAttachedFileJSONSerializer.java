package com.nss.portlet.filetype.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.filetype.model.PmlFileAttachedFile;

import java.util.List;


/**
 * <a href="PmlFileAttachedFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.filetype.service.http.PmlFileAttachedFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.http.PmlFileAttachedFileServiceJSON
 *
 */
public class PmlFileAttachedFileJSONSerializer {
    public static JSONObject toJSONObject(PmlFileAttachedFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileAttachedFileId", model.getFileAttachedFileId());
        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("original", model.getOriginal());
        jsonObj.put("copy_", model.getCopy_());
        jsonObj.put("attachedFileId", model.getAttachedFileId());
        jsonObj.put("attachedFileName", model.getAttachedFileName());
        jsonObj.put("note", model.getNote());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.filetype.model.PmlFileAttachedFile[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.filetype.model.PmlFileAttachedFile[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileAttachedFile[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.filetype.model.PmlFileAttachedFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
