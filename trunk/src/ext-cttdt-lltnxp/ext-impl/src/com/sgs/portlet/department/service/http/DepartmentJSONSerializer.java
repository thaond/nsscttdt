package com.sgs.portlet.department.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.department.model.Department;

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
 * <code>com.sgs.portlet.department.service.http.DepartmentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.http.DepartmentServiceJSON
 *
 */
public class DepartmentJSONSerializer {
    public static JSONObject toJSONObject(Department model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("departmentsParentId", model.getDepartmentsParentId());
        jsonObj.put("departmentsCode", model.getDepartmentsCode());
        jsonObj.put("departmentsName", model.getDepartmentsName());
        jsonObj.put("abbreviateName", model.getAbbreviateName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());
        jsonObj.put("agencyId", model.getAgencyId());
        jsonObj.put("roleId", model.getRoleId());
        jsonObj.put("hasTeam", model.getHasTeam());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.department.model.Department> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Department model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
