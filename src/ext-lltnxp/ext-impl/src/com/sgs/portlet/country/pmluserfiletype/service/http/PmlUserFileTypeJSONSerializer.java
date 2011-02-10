package com.sgs.portlet.country.pmluserfiletype.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType;

import java.util.List;


/**
 * <a href="PmlUserFileTypeJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.country.pmluserfiletype.service.http.PmlUserFileTypeServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.pmluserfiletype.service.http.PmlUserFileTypeServiceJSON
 *
 */
public class PmlUserFileTypeJSONSerializer {
    public static JSONObject toJSONObject(PmlUserFileType model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUserFileType model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
