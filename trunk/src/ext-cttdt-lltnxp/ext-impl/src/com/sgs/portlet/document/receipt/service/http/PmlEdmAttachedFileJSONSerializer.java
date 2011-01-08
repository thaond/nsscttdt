package com.sgs.portlet.document.receipt.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmAttachedFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmAttachedFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmAttachedFileServiceJSON
 *
 */
public class PmlEdmAttachedFileJSONSerializer {
    public static JSONObject toJSONObject(PmlEdmAttachedFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("attachedFileId", model.getAttachedFileId());
        jsonObj.put("objectContentId", model.getObjectContentId());
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
        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("title", model.getTitle());
        jsonObj.put("displayOrHidden", model.getDisplayOrHidden());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlEdmAttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
