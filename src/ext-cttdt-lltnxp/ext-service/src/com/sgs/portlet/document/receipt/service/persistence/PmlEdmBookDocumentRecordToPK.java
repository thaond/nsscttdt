package com.sgs.portlet.document.receipt.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlEdmBookDocumentRecordToPK implements Comparable<PmlEdmBookDocumentRecordToPK>,
    Serializable {
    public long documentReceiptId;
    public long documentRecordToId;

    public PmlEdmBookDocumentRecordToPK() {
    }

    public PmlEdmBookDocumentRecordToPK(long documentReceiptId,
        long documentRecordToId) {
        this.documentReceiptId = documentReceiptId;
        this.documentRecordToId = documentRecordToId;
    }

    public long getDocumentReceiptId() {
        return documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        this.documentReceiptId = documentReceiptId;
    }

    public long getDocumentRecordToId() {
        return documentRecordToId;
    }

    public void setDocumentRecordToId(long documentRecordToId) {
        this.documentRecordToId = documentRecordToId;
    }

    public int compareTo(PmlEdmBookDocumentRecordToPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (documentReceiptId < pk.documentReceiptId) {
            value = -1;
        } else if (documentReceiptId > pk.documentReceiptId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (documentRecordToId < pk.documentRecordToId) {
            value = -1;
        } else if (documentRecordToId > pk.documentRecordToId) {
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

        PmlEdmBookDocumentRecordToPK pk = null;

        try {
            pk = (PmlEdmBookDocumentRecordToPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((documentReceiptId == pk.documentReceiptId) &&
                (documentRecordToId == pk.documentRecordToId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(documentReceiptId) +
        String.valueOf(documentRecordToId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("documentReceiptId");
        sb.append(StringPool.EQUAL);
        sb.append(documentReceiptId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("documentRecordToId");
        sb.append(StringPool.EQUAL);
        sb.append(documentRecordToId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
