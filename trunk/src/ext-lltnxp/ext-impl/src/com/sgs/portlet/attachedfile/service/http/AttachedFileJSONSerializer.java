package com.sgs.portlet.attachedfile.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.attachedfile.model.AttachedFile;

import java.util.List;


/**
 * <a href="AttachedFileJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.attachedfile.service.http.AttachedFileServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.attachedfile.service.http.AttachedFileServiceJSON
 *
 */
public class AttachedFileJSONSerializer {
    public static JSONObject toJSONObject(AttachedFile model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("attachedFileId", model.getAttachedFileId());
        jsonObj.put("attachedFileCode", model.getAttachedFileCode());
        jsonObj.put("attachedFileName", model.getAttachedFileName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.attachedfile.model.AttachedFile> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (AttachedFile model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
