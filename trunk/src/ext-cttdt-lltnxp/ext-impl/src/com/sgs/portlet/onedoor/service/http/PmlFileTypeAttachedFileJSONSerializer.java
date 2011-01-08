package com.sgs.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;

import java.util.List;


/**
 * <a href="PmlFileTypeAttachedFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlFileTypeAttachedFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlFileTypeAttachedFileServiceJSON
 *
 */
public class PmlFileTypeAttachedFileJSONSerializer {
    public static JSONObject toJSONObject(PmlFileTypeAttachedFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("filetypeAttachedFileId", model.getFiletypeAttachedFileId());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("original", model.getOriginal());
        jsonObj.put("copy_", model.getCopy_());
        jsonObj.put("attachedFileId", model.getAttachedFileId());
        jsonObj.put("attachedFileName", model.getAttachedFileName());
        jsonObj.put("note", model.getNote());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileTypeAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
