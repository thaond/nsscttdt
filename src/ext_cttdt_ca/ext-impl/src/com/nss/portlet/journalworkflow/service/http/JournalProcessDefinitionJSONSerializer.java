package com.nss.portlet.journalworkflow.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;

import java.util.List;


/**
 * <a href="JournalProcessDefinitionJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journalworkflow.service.http.JournalProcessDefinitionServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.http.JournalProcessDefinitionServiceJSON
 *
 */
public class JournalProcessDefinitionJSONSerializer {
    public static JSONObject toJSONObject(JournalProcessDefinition model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("journalProcessDefinitionId",
            model.getJournalProcessDefinitionId());
        jsonObj.put("name", model.getName());
        jsonObj.put("version", model.getVersion());
        jsonObj.put("content", model.getContent());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (JournalProcessDefinition model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (JournalProcessDefinition[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (JournalProcessDefinition model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
