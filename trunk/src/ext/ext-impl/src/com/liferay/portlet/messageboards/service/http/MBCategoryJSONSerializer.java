package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.messageboards.model.MBCategory;

import java.util.Date;
import java.util.List;


/**
 * <a href="MBCategoryJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBCategoryServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBCategoryServiceJSON
 *
 */
public class MBCategoryJSONSerializer {
    public static JSONObject toJSONObject(MBCategory model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("uuid", model.getUuid());
        jsonObj.put("categoryId", model.getCategoryId());
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
        jsonObj.put("parentCategoryId", model.getParentCategoryId());
        jsonObj.put("name", model.getName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("threadCount", model.getThreadCount());
        jsonObj.put("messageCount", model.getMessageCount());

        Date lastPostDate = model.getLastPostDate();

        String lastPostDateJSON = StringPool.BLANK;

        if (lastPostDate != null) {
            lastPostDateJSON = String.valueOf(lastPostDate.getTime());
        }

        jsonObj.put("lastPostDate", lastPostDateJSON);
        jsonObj.put("image_liferay", model.getImage_liferay());
        jsonObj.put("orderNumber", model.getOrderNumber());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBCategory[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBCategory model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.liferay.portlet.messageboards.model.MBCategory[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBCategory[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.liferay.portlet.messageboards.model.MBCategory> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MBCategory model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
