package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCAttachedFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFilePCCCAttachedFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFilePCCCAttachedFileServiceJSON
 *
 */
public class PmlFilePCCCAttachedFileJSONSerializer {
    public static JSONObject toJSONObject(PmlFilePCCCAttachedFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("attachedFileId", model.getAttachedFileId());
        jsonObj.put("filePcccId", model.getFilePcccId());
        jsonObj.put("objectType", model.getObjectType());
        jsonObj.put("attachedFileName", model.getAttachedFileName());
        jsonObj.put("path", model.getPath());

        Date dateCreated = model.getDateCreated();

        String dateCreatedJSON = StringPool.BLANK;

        if (dateCreated != null) {
            dateCreatedJSON = String.valueOf(dateCreated.getTime());
        }

        jsonObj.put("dateCreated", dateCreatedJSON);
        jsonObj.put("fileType", model.getFileType());
        jsonObj.put("title", model.getTitle());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCCAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCCAttachedFile[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFilePCCCAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
