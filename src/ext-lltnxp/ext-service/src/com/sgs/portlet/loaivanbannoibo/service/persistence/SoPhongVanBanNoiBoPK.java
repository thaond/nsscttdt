package com.sgs.portlet.loaivanbannoibo.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class SoPhongVanBanNoiBoPK implements Comparable<SoPhongVanBanNoiBoPK>,
    Serializable {
    public long soVanBanNoiBoId;
    public long phongVanBanNoiBoId;

    public SoPhongVanBanNoiBoPK() {
    }

    public SoPhongVanBanNoiBoPK(long soVanBanNoiBoId, long phongVanBanNoiBoId) {
        this.soVanBanNoiBoId = soVanBanNoiBoId;
        this.phongVanBanNoiBoId = phongVanBanNoiBoId;
    }

    public long getSoVanBanNoiBoId() {
        return soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        this.soVanBanNoiBoId = soVanBanNoiBoId;
    }

    public long getPhongVanBanNoiBoId() {
        return phongVanBanNoiBoId;
    }

    public void setPhongVanBanNoiBoId(long phongVanBanNoiBoId) {
        this.phongVanBanNoiBoId = phongVanBanNoiBoId;
    }

    public int compareTo(SoPhongVanBanNoiBoPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (soVanBanNoiBoId < pk.soVanBanNoiBoId) {
            value = -1;
        } else if (soVanBanNoiBoId > pk.soVanBanNoiBoId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (phongVanBanNoiBoId < pk.phongVanBanNoiBoId) {
            value = -1;
        } else if (phongVanBanNoiBoId > pk.phongVanBanNoiBoId) {
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

        SoPhongVanBanNoiBoPK pk = null;

        try {
            pk = (SoPhongVanBanNoiBoPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((soVanBanNoiBoId == pk.soVanBanNoiBoId) &&
                (phongVanBanNoiBoId == pk.phongVanBanNoiBoId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(soVanBanNoiBoId) +
        String.valueOf(phongVanBanNoiBoId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("soVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(soVanBanNoiBoId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("phongVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(phongVanBanNoiBoId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
