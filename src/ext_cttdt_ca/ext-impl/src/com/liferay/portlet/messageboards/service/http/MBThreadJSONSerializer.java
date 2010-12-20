package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.messageboards.model.MBThread;

import java.util.Date;
import java.util.List;


/**
 * <a href="MBThreadJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBThreadServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBThreadServiceJSON
 *
 */
public class MBThreadJSONSerializer {
    public static JSONObject toJSONObject(MBThread model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("threadId", model.getThreadId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("categoryId", model.getCategoryId());
        jsonObj.put("rootMessageId", model.getRootMessageId());
        jsonObj.put("messageCount", model.getMessageCount());
        jsonObj.put("viewCount", model.getViewCount());
        jsonObj.put("lastPostByUserId", model.getLastPostByUserId());

        Date lastPostDate = model.getLastPostDate();

        String lastPostDateJSON = StringPool.BLANK;

        if (lastPostDate != null) {
            lastPostDateJSON = String.valueOf(lastPostDate.getTime());
        }

        jsonObj.put("lastPostDate", lastPostDateJSON);
        jsonObj.put("priority", model.getPriority());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBThread[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBThread model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBThread[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBThread[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.liferay.portlet.messageboards.model.MBThread> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBThread model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
