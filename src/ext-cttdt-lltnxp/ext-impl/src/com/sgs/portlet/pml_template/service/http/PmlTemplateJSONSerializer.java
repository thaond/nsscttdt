package com.sgs.portlet.pml_template.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.pml_template.model.PmlTemplate;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlTemplateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_template.service.http.PmlTemplateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.http.PmlTemplateServiceJSON
 *
 */
public class PmlTemplateJSONSerializer {
    public static JSONObject toJSONObject(PmlTemplate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("templateId", model.getTemplateId());
        jsonObj.put("templateCode", model.getTemplateCode());
        jsonObj.put("templateName", model.getTemplateName());
        jsonObj.put("numberOfDocument", model.getNumberOfDocument());

        Date publishDate = model.getPublishDate();

        String publishDateJSON = StringPool.BLANK;

        if (publishDate != null) {
            publishDateJSON = String.valueOf(publishDate.getTime());
        }

        jsonObj.put("publishDate", publishDateJSON);
        jsonObj.put("departmentId", model.getDepartmentId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_template.model.PmlTemplate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlTemplate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
