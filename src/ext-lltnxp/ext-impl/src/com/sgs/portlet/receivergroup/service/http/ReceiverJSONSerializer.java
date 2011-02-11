package com.sgs.portlet.receivergroup.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.receivergroup.model.Receiver;

import java.util.Date;
import java.util.List;


/**
 * <a href="ReceiverJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.receivergroup.service.http.ReceiverServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverServiceJSON
 *
 */
public class ReceiverJSONSerializer {
    public static JSONObject toJSONObject(Receiver model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("receiverId", model.getReceiverId());
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
        jsonObj.put("receiverUserId", model.getReceiverUserId());
        jsonObj.put("receiverUserName", model.getReceiverUserName());
        jsonObj.put("viewName", model.getViewName());
        jsonObj.put("receiverType", model.getReceiverType());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.receivergroup.model.Receiver> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Receiver model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
