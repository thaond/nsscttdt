package com.sgs.portlet.report_registry_work.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.report_registry_work.model.ResultProgram;

import java.util.List;


/**
 * <a href="ResultProgramJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.ResultProgramServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.ResultProgramServiceJSON
 *
 */
public class ResultProgramJSONSerializer {
    public static JSONObject toJSONObject(ResultProgram model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("resultProgramId", model.getResultProgramId());
        jsonObj.put("resultProgramTitle", model.getResultProgramTitle());
        jsonObj.put("resultProgramPath", model.getResultProgramPath());
        jsonObj.put("resultProgramCheck", model.getResultProgramCheck());
        jsonObj.put("reportRegistryId", model.getReportRegistryId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.report_registry_work.model.ResultProgram> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ResultProgram model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
