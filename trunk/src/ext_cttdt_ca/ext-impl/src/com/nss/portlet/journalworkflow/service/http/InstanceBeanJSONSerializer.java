package com.nss.portlet.journalworkflow.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.journalworkflow.model.InstanceBean;

import java.util.List;


/**
 * <a href="InstanceBeanJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journalworkflow.service.http.InstanceBeanServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.http.InstanceBeanServiceJSON
 *
 */
public class InstanceBeanJSONSerializer {
    public static JSONObject toJSONObject(InstanceBean model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("processInstanceId", model.getProcessInstanceId());
        jsonObj.put("businessProcessId", model.getBusinessProcessId());
        jsonObj.put("articleId", model.getArticleId());
        jsonObj.put("categoryId", model.getCategoryId());
        jsonObj.put("previousNode", model.getPreviousNode());
        jsonObj.put("status", model.getStatus());
        jsonObj.put("createUserId", model.getCreateUserId());
        jsonObj.put("finish", model.getFinish());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.journalworkflow.model.InstanceBean[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (InstanceBean model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.journalworkflow.model.InstanceBean[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (InstanceBean[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.journalworkflow.model.InstanceBean> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (InstanceBean model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
