package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.messageboards.model.MBMessageFlag;

import java.util.Date;
import java.util.List;


/**
 * <a href="MBMessageFlagJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBMessageFlagServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBMessageFlagServiceJSON
 *
 */
public class MBMessageFlagJSONSerializer {
    public static JSONObject toJSONObject(MBMessageFlag model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("messageFlagId", model.getMessageFlagId());
        jsonObj.put("userId", model.getUserId());

        Date modifiedDate = model.getModifiedDate();

        String modifiedDateJSON = StringPool.BLANK;

        if (modifiedDate != null) {
            modifiedDateJSON = String.valueOf(modifiedDate.getTime());
        }

        jsonObj.put("modifiedDate", modifiedDateJSON);
        jsonObj.put("threadId", model.getThreadId());
        jsonObj.put("messageId", model.getMessageId());
        jsonObj.put("flag", model.getFlag());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBMessageFlag[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessageFlag model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBMessageFlag[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessageFlag[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.liferay.portlet.messageboards.model.MBMessageFlag> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessageFlag model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}