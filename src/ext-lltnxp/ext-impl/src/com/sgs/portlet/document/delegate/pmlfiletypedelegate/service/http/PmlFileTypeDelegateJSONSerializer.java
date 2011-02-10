package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;

import java.util.List;


/**
 * <a href="PmlFileTypeDelegateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.http.PmlFileTypeDelegateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.http.PmlFileTypeDelegateServiceJSON
 *
 */
public class PmlFileTypeDelegateJSONSerializer {
    public static JSONObject toJSONObject(PmlFileTypeDelegate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileTypeDelegateId", model.getFileTypeDelegateId());
        jsonObj.put("fileTypeId", model.getFileTypeId());
        jsonObj.put("delegateId", model.getDelegateId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileTypeDelegate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
