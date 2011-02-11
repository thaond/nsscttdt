package com.sgs.portlet.pmluser.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.pmluser.model.PmlUser;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlUserJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmluser.service.http.PmlUserServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmluser.service.http.PmlUserServiceJSON
 *
 */
public class PmlUserJSONSerializer {
    public static JSONObject toJSONObject(PmlUser model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("userId", model.getUserId());
        jsonObj.put("positionId", model.getPositionId());
        jsonObj.put("departmentsId", model.getDepartmentsId());
        jsonObj.put("roleId", model.getRoleId());
        jsonObj.put("handPhone", model.getHandPhone());
        jsonObj.put("note", model.getNote());
        jsonObj.put("teamId", model.getTeamId());
        jsonObj.put("active", model.getActive());
        jsonObj.put("screenName", model.getScreenName());
        jsonObj.put("firstName", model.getFirstName());
        jsonObj.put("middleName", model.getMiddleName());
        jsonObj.put("lastName", model.getLastName());
        jsonObj.put("male", model.getMale());

        Date birthday = model.getBirthday();

        String birthdayJSON = StringPool.BLANK;

        if (birthday != null) {
            birthdayJSON = String.valueOf(birthday.getTime());
        }

        jsonObj.put("birthday", birthdayJSON);
        jsonObj.put("isLeaderMetting", model.getIsLeaderMetting());
        jsonObj.put("isVanThuPhong", model.getIsVanThuPhong());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pmluser.model.PmlUser> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlUser model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
