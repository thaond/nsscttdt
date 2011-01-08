package com.sgs.portlet.recievergroup.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.recievergroup.model.Reciever;

import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.recievergroup.service.http.RecieverServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.http.RecieverServiceJSON
 *
 */
public class RecieverJSONSerializer {
    public static JSONObject toJSONObject(Reciever model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("recieverId", model.getRecieverId());
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
        jsonObj.put("recieverUserId", model.getRecieverUserId());
        jsonObj.put("recieverUserName", model.getRecieverUserName());
        jsonObj.put("viewName", model.getViewName());
        jsonObj.put("recieverType", model.getRecieverType());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.recievergroup.model.Reciever> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Reciever model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
