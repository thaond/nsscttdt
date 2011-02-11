package com.sgs.portlet.pml_template.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_template.model.FileTemplate;

import java.util.List;


/**
 * <a href="FileTemplateJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_template.service.http.FileTemplateServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.http.FileTemplateServiceJSON
 *
 */
public class FileTemplateJSONSerializer {
    public static JSONObject toJSONObject(FileTemplate model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileTemplateId", model.getFileTemplateId());
        jsonObj.put("templateId", model.getTemplateId());
        jsonObj.put("tenFile", model.getTenFile());
        jsonObj.put("kichThuoc", model.getKichThuoc());
        jsonObj.put("duongDan", model.getDuongDan());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pml_template.model.FileTemplate> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (FileTemplate model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
