package com.sgs.portlet.document.receipt.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlEdmLevelSendDetailPK implements Comparable<PmlEdmLevelSendDetailPK>,
    Serializable {
    public int levelSendId;
    public String issuingPlaceId;

    public PmlEdmLevelSendDetailPK() {
    }

    public PmlEdmLevelSendDetailPK(int levelSendId, String issuingPlaceId) {
        this.levelSendId = levelSendId;
        this.issuingPlaceId = issuingPlaceId;
    }

    public int getLevelSendId() {
        return levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        this.levelSendId = levelSendId;
    }

    public String getIssuingPlaceId() {
        return issuingPlaceId;
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        this.issuingPlaceId = issuingPlaceId;
    }

    public int compareTo(PmlEdmLevelSendDetailPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (levelSendId < pk.levelSendId) {
            value = -1;
        } else if (levelSendId > pk.levelSendId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = issuingPlaceId.compareTo(pk.issuingPlaceId);

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmLevelSendDetailPK pk = null;

        try {
            pk = (PmlEdmLevelSendDetailPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((levelSendId == pk.levelSendId) &&
                (issuingPlaceId.equals(pk.issuingPlaceId))) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(levelSendId) + String.valueOf(issuingPlaceId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("levelSendId");
        sb.append(StringPool.EQUAL);
        sb.append(levelSendId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("issuingPlaceId");
        sb.append(StringPool.EQUAL);
        sb.append(issuingPlaceId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
