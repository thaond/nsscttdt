package com.sgs.portlet.report_registry_work.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.report_registry_work.model.Department;

import java.util.List;


/**
 * <a href="DepartmentJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.DepartmentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.DepartmentServiceJSON
 *
 */
public class DepartmentJSONSerializer {
    public static JSONObject toJSONObject(Department model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("departmentId", model.getDepartmentId());
        jsonObj.put("departmentCode", model.getDepartmentCode());
        jsonObj.put("departmentName", model.getDepartmentName());
        jsonObj.put("departmentDescription", model.getDepartmentDescription());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.report_registry_work.model.Department> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Department model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
