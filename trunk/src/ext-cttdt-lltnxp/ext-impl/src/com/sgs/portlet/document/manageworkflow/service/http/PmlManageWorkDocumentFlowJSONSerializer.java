package com.sgs.portlet.document.manageworkflow.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlManageWorkDocumentFlowJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.manageworkflow.service.http.PmlManageWorkDocumentFlowServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.service.http.PmlManageWorkDocumentFlowServiceJSON
 *
 */
public class PmlManageWorkDocumentFlowJSONSerializer {
    public static JSONObject toJSONObject(PmlManageWorkDocumentFlow model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("manageDocumentWorkFlowId",
            model.getManageDocumentWorkFlowId());
        jsonObj.put("workFlowName", model.getWorkFlowName());
        jsonObj.put("version", model.getVersion());
        jsonObj.put("type", model.getType());
        jsonObj.put("description", model.getDescription());

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
        List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlManageWorkDocumentFlow model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
