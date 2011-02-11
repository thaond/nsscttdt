package com.sgs.portlet.document.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlStateDepartmentPK implements Comparable<PmlStateDepartmentPK>,
    Serializable {
    public String departmentId;
    public long stateWfId;

    public PmlStateDepartmentPK() {
    }

    public PmlStateDepartmentPK(String departmentId, long stateWfId) {
        this.departmentId = departmentId;
        this.stateWfId = stateWfId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public long getStateWfId() {
        return stateWfId;
    }

    public void setStateWfId(long stateWfId) {
        this.stateWfId = stateWfId;
    }

    public int compareTo(PmlStateDepartmentPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        value = departmentId.compareTo(pk.departmentId);

        if (value != 0) {
            return value;
        }

        if (stateWfId < pk.stateWfId) {
            value = -1;
        } else if (stateWfId > pk.stateWfId) {
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

        PmlStateDepartmentPK pk = null;

        try {
            pk = (PmlStateDepartmentPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((departmentId.equals(pk.departmentId)) &&
                (stateWfId == pk.stateWfId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(departmentId) + String.valueOf(stateWfId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("departmentId");
        sb.append(StringPool.EQUAL);
        sb.append(departmentId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("stateWfId");
        sb.append(StringPool.EQUAL);
        sb.append(stateWfId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
