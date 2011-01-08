package com.sgs.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.onedoor.model.PmlWorkflow;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlWorkflowJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlWorkflowServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlWorkflowServiceJSON
 *
 */
public class PmlWorkflowJSONSerializer {
    public static JSONObject toJSONObject(PmlWorkflow model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("workflowId", model.getWorkflowId());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("workflow", model.getWorkflow());
        jsonObj.put("version_", model.getVersion_());

        Date startDate = model.getStartDate();

        String startDateJSON = StringPool.BLANK;

        if (startDate != null) {
            startDateJSON = String.valueOf(startDate.getTime());
        }

        jsonObj.put("startDate", startDateJSON);

        Date endDate = model.getEndDate();

        String endDateJSON = StringPool.BLANK;

        if (endDate != null) {
            endDateJSON = String.valueOf(endDate.getTime());
        }

        jsonObj.put("endDate", endDateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.model.PmlWorkflow> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlWorkflow model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
