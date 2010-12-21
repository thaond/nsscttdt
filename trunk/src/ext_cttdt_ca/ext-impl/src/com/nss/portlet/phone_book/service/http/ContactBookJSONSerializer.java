package com.nss.portlet.phone_book.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.phone_book.model.ContactBook;

import java.util.List;


/**
 * <a href="ContactBookJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.phone_book.service.http.ContactBookServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.http.ContactBookServiceJSON
 *
 */
public class ContactBookJSONSerializer {
    public static JSONObject toJSONObject(ContactBook model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("contactBookId", model.getContactBookId());
        jsonObj.put("contactBookCode", model.getContactBookCode());
        jsonObj.put("contactBookName", model.getContactBookName());
        jsonObj.put("contactDescription", model.getContactDescription());
        jsonObj.put("contactActive", model.getContactActive());
        jsonObj.put("companyid", model.getCompanyid());
        jsonObj.put("userid", model.getUserid());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.phone_book.model.ContactBook[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ContactBook model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.phone_book.model.ContactBook[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ContactBook[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.phone_book.model.ContactBook> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (ContactBook model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
