package com.sgs.portlet.sovanbannoibo.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class SoLoaiVanBanNoiBoPK implements Comparable<SoLoaiVanBanNoiBoPK>,
    Serializable {
    public long soVanBanNoiBoId;
    public long loaiVanBanNoiBoId;

    public SoLoaiVanBanNoiBoPK() {
    }

    public SoLoaiVanBanNoiBoPK(long soVanBanNoiBoId, long loaiVanBanNoiBoId) {
        this.soVanBanNoiBoId = soVanBanNoiBoId;
        this.loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }

    public long getSoVanBanNoiBoId() {
        return soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        this.soVanBanNoiBoId = soVanBanNoiBoId;
    }

    public long getLoaiVanBanNoiBoId() {
        return loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        this.loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }

    public int compareTo(SoLoaiVanBanNoiBoPK pk) {
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

        if (loaiVanBanNoiBoId < pk.loaiVanBanNoiBoId) {
            value = -1;
        } else if (loaiVanBanNoiBoId > pk.loaiVanBanNoiBoId) {
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

        SoLoaiVanBanNoiBoPK pk = null;

        try {
            pk = (SoLoaiVanBanNoiBoPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((soVanBanNoiBoId == pk.soVanBanNoiBoId) &&
                (loaiVanBanNoiBoId == pk.loaiVanBanNoiBoId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(soVanBanNoiBoId) +
        String.valueOf(loaiVanBanNoiBoId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("soVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(soVanBanNoiBoId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("loaiVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(loaiVanBanNoiBoId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
