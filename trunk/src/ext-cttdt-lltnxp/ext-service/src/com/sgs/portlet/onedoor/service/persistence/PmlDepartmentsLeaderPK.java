package com.sgs.portlet.onedoor.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlDepartmentsLeaderPK implements Comparable<PmlDepartmentsLeaderPK>,
    Serializable {
    public String departmentsId;
    public long userId;

    public PmlDepartmentsLeaderPK() {
    }

    public PmlDepartmentsLeaderPK(String departmentsId, long userId) {
        this.departmentsId = departmentsId;
        this.userId = userId;
    }

    public String getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        this.departmentsId = departmentsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int compareTo(PmlDepartmentsLeaderPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        value = departmentsId.compareTo(pk.departmentsId);

        if (value != 0) {
            return value;
        }

        if (userId < pk.userId) {
            value = -1;
        } else if (userId > pk.userId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDepartmentsLeaderPK pk = null;

        try {
            pk = (PmlDepartmentsLeaderPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((departmentsId.equals(pk.departmentsId)) && (userId == pk.userId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(departmentsId) + String.valueOf(userId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("departmentsId");
        sb.append(StringPool.EQUAL);
        sb.append(departmentsId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("userId");
        sb.append(StringPool.EQUAL);
        sb.append(userId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
