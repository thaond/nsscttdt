package com.sgs.portlet.onedoor.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlAgencyLeaderPK implements Comparable<PmlAgencyLeaderPK>,
    Serializable {
    public String agencyId;
    public long userId;

    public PmlAgencyLeaderPK() {
    }

    public PmlAgencyLeaderPK(String agencyId, long userId) {
        this.agencyId = agencyId;
        this.userId = userId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int compareTo(PmlAgencyLeaderPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        value = agencyId.compareTo(pk.agencyId);

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

        PmlAgencyLeaderPK pk = null;

        try {
            pk = (PmlAgencyLeaderPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((agencyId.equals(pk.agencyId)) && (userId == pk.userId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(agencyId) + String.valueOf(userId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("agencyId");
        sb.append(StringPool.EQUAL);
        sb.append(agencyId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("userId");
        sb.append(StringPool.EQUAL);
        sb.append(userId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
