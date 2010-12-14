package com.nss.portlet.phone_book.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.phone_book.model.DetailBook;

import java.util.List;


/**
 * <a href="DetailBookJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.phone_book.service.http.DetailBookServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.http.DetailBookServiceJSON
 *
 */
public class DetailBookJSONSerializer {
    public static JSONObject toJSONObject(DetailBook model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("detailBookId", model.getDetailBookId());
        jsonObj.put("detailBookCode", model.getDetailBookCode());
        jsonObj.put("detailBookName", model.getDetailBookName());
        jsonObj.put("detailDescription", model.getDetailDescription());
        jsonObj.put("detailActive", model.getDetailActive());
        jsonObj.put("zip", model.getZip());
        jsonObj.put("internal", model.getInternal());
        jsonObj.put("home", model.getHome());
        jsonObj.put("mobile", model.getMobile());
        jsonObj.put("contactBookId", model.getContactBookId());
        jsonObj.put("companyid", model.getCompanyid());
        jsonObj.put("userid", model.getUserid());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.phone_book.model.DetailBook[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (DetailBook model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.phone_book.model.DetailBook[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (DetailBook[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.phone_book.model.DetailBook> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (DetailBook model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
