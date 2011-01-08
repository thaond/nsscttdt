package com.sgs.portlet.report_registry_work.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.report_registry_work.model.ReportRegistry;

import java.util.Date;
import java.util.List;


/**
 * <a href="ReportRegistryJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.ReportRegistryServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.ReportRegistryServiceJSON
 *
 */
public class ReportRegistryJSONSerializer {
    public static JSONObject toJSONObject(ReportRegistry model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("reportRegistryId", model.getReportRegistryId());
        jsonObj.put("reportRegistryCode", model.getReportRegistryCode());
        jsonObj.put("departmentName", model.getDepartmentName());
        jsonObj.put("resultWork", model.getResultWork());
        jsonObj.put("programWork", model.getProgramWork());

        Date reportDate = model.getReportDate();

        String reportDateJSON = StringPool.BLANK;

        if (reportDate != null) {
            reportDateJSON = String.valueOf(reportDate.getTime());
        }

        jsonObj.put("reportDate", reportDateJSON);
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.report_registry_work.model.ReportRegistry> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ReportRegistry model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
