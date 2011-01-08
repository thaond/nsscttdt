package com.sgs.portlet.recievergroup.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.recievergroup.model.RecieverGroup;

import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverGroupJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.recievergroup.service.http.RecieverGroupServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.http.RecieverGroupServiceJSON
 *
 */
public class RecieverGroupJSONSerializer {
    public static JSONObject toJSONObject(RecieverGroup model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("recieverGroupId", model.getRecieverGroupId());
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
        jsonObj.put("recieverGroupName", model.getRecieverGroupName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("type", model.getType());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.recievergroup.model.RecieverGroup> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (RecieverGroup model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
