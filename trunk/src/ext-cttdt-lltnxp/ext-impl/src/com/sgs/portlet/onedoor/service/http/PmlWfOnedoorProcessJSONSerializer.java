package com.sgs.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess;

import java.util.List;


/**
 * <a href="PmlWfOnedoorProcessJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlWfOnedoorProcessServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlWfOnedoorProcessServiceJSON
 *
 */
public class PmlWfOnedoorProcessJSONSerializer {
    public static JSONObject toJSONObject(PmlWfOnedoorProcess model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileId", model.getFileId());
        jsonObj.put("processId", model.getProcessId());
        jsonObj.put("nodeId", model.getNodeId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlWfOnedoorProcess model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
