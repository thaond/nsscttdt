package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.messageboards.model.MBMessage;

import java.util.Date;
import java.util.List;


/**
 * <a href="MBMessageJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBMessageServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBMessageServiceJSON
 *
 */
public class MBMessageJSONSerializer {
    public static JSONObject toJSONObject(MBMessage model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("uuid", model.getUuid());
        jsonObj.put("messageId", model.getMessageId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("userName", model.getUserName());

        Date createDate = model.getCreateDate();

        String createDateJSON = StringPool.BLANK;

        if (createDate != null) {
            createDateJSON = String.valueOf(createDate.getTime());
        }

        jsonObj.put("createDate", createDateJSON);

        Date modifiedDate = model.getModifiedDate();

        String modifiedDateJSON = StringPool.BLANK;

        if (modifiedDate != null) {
            modifiedDateJSON = String.valueOf(modifiedDate.getTime());
        }

        jsonObj.put("modifiedDate", modifiedDateJSON);
        jsonObj.put("classNameId", model.getClassNameId());
        jsonObj.put("classPK", model.getClassPK());
        jsonObj.put("categoryId", model.getCategoryId());
        jsonObj.put("threadId", model.getThreadId());
        jsonObj.put("parentMessageId", model.getParentMessageId());
        jsonObj.put("subject", model.getSubject());
        jsonObj.put("body", model.getBody());
        jsonObj.put("attachments", model.getAttachments());
        jsonObj.put("anonymous", model.getAnonymous());
        jsonObj.put("priority", model.getPriority());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBMessage[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessage model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBMessage[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessage[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.liferay.portlet.messageboards.model.MBMessage> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBMessage model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
