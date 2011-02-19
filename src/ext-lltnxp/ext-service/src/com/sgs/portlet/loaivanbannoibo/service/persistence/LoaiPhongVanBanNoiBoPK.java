package com.sgs.portlet.loaivanbannoibo.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class LoaiPhongVanBanNoiBoPK implements Comparable<LoaiPhongVanBanNoiBoPK>,
    Serializable {
    public long loaiVanBanNoiBoId;
    public long phongVanBanNoiBoId;

    public LoaiPhongVanBanNoiBoPK() {
    }

    public LoaiPhongVanBanNoiBoPK(long loaiVanBanNoiBoId,
        long phongVanBanNoiBoId) {
        this.loaiVanBanNoiBoId = loaiVanBanNoiBoId;
        this.phongVanBanNoiBoId = phongVanBanNoiBoId;
    }

    public long getLoaiVanBanNoiBoId() {
        return loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        this.loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }

    public long getPhongVanBanNoiBoId() {
        return phongVanBanNoiBoId;
    }

    public void setPhongVanBanNoiBoId(long phongVanBanNoiBoId) {
        this.phongVanBanNoiBoId = phongVanBanNoiBoId;
    }

    public int compareTo(LoaiPhongVanBanNoiBoPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

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

        LoaiPhongVanBanNoiBoPK pk = null;

        try {
            pk = (LoaiPhongVanBanNoiBoPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((loaiVanBanNoiBoId == pk.loaiVanBanNoiBoId) &&
                (phongVanBanNoiBoId == pk.phongVanBanNoiBoId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(loaiVanBanNoiBoId) +
        String.valueOf(phongVanBanNoiBoId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("loaiVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(loaiVanBanNoiBoId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("phongVanBanNoiBoId");
        sb.append(StringPool.EQUAL);
        sb.append(phongVanBanNoiBoId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
