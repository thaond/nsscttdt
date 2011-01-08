package com.sgs.portlet.pml_tinh_chat.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;

import java.util.List;


/**
 * <a href="PmlTinhChatJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceJSON
 *
 */
public class PmlTinhChatJSONSerializer {
    public static JSONObject toJSONObject(PmlTinhChat model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("idTinhChat", model.getIdTinhChat());
        jsonObj.put("tenTinhChat", model.getTenTinhChat());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTinhChat model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
