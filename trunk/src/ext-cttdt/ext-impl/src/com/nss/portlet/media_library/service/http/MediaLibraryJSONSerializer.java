package com.nss.portlet.media_library.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.media_library.model.MediaLibrary;

import java.util.Date;
import java.util.List;


/**
 * <a href="MediaLibraryJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.media_library.service.http.MediaLibraryServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_library.service.http.MediaLibraryServiceJSON
 *
 */
public class MediaLibraryJSONSerializer {
    public static JSONObject toJSONObject(MediaLibrary model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("maMediaLibrary", model.getMaMediaLibrary());
        jsonObj.put("maMediaChuDe", model.getMaMediaChuDe());
        jsonObj.put("tieuDeMediaLibrary", model.getTieuDeMediaLibrary());
        jsonObj.put("tenMediaLibrary", model.getTenMediaLibrary());
        jsonObj.put("kichThuoc", model.getKichThuoc());
        jsonObj.put("duongDan", model.getDuongDan());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("luotXem", model.getLuotXem());

        Date createdate = model.getCreatedate();

        String createdateJSON = StringPool.BLANK;

        if (createdate != null) {
            createdateJSON = String.valueOf(createdate.getTime());
        }

        jsonObj.put("createdate", createdateJSON);

        Date modifieddate = model.getModifieddate();

        String modifieddateJSON = StringPool.BLANK;

        if (modifieddate != null) {
            modifieddateJSON = String.valueOf(modifieddate.getTime());
        }

        jsonObj.put("modifieddate", modifieddateJSON);
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.media_library.model.MediaLibrary[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaLibrary model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.media_library.model.MediaLibrary[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaLibrary[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.media_library.model.MediaLibrary> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MediaLibrary model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
