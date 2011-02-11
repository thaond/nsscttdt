package com.sgs.portlet.country.pmluserfiletype.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlUserFileTypePK implements Comparable<PmlUserFileTypePK>,
    Serializable {
    public long userId;
    public String fileTypeId;

    public PmlUserFileTypePK() {
    }

    public PmlUserFileTypePK(long userId, String fileTypeId) {
        this.userId = userId;
        this.fileTypeId = fileTypeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public int compareTo(PmlUserFileTypePK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

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

        value = fileTypeId.compareTo(pk.fileTypeId);

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlUserFileTypePK pk = null;

        try {
            pk = (PmlUserFileTypePK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((userId == pk.userId) && (fileTypeId.equals(pk.fileTypeId))) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(userId) + String.valueOf(fileTypeId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("userId");
        sb.append(StringPool.EQUAL);
        sb.append(userId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("fileTypeId");
        sb.append(StringPool.EQUAL);
        sb.append(fileTypeId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
