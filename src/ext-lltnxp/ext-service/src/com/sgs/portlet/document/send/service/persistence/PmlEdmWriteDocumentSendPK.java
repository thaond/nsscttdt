package com.sgs.portlet.document.send.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PmlEdmWriteDocumentSendPK implements Comparable<PmlEdmWriteDocumentSendPK>,
    Serializable {
    public long bookDocumentSendId;
    public long documentSendId;

    public PmlEdmWriteDocumentSendPK() {
    }

    public PmlEdmWriteDocumentSendPK(long bookDocumentSendId,
        long documentSendId) {
        this.bookDocumentSendId = bookDocumentSendId;
        this.documentSendId = documentSendId;
    }

    public long getBookDocumentSendId() {
        return bookDocumentSendId;
    }

    public void setBookDocumentSendId(long bookDocumentSendId) {
        this.bookDocumentSendId = bookDocumentSendId;
    }

    public long getDocumentSendId() {
        return documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        this.documentSendId = documentSendId;
    }

    public int compareTo(PmlEdmWriteDocumentSendPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (bookDocumentSendId < pk.bookDocumentSendId) {
            value = -1;
        } else if (bookDocumentSendId > pk.bookDocumentSendId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (documentSendId < pk.documentSendId) {
            value = -1;
        } else if (documentSendId > pk.documentSendId) {
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

        PmlEdmWriteDocumentSendPK pk = null;

        try {
            pk = (PmlEdmWriteDocumentSendPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((bookDocumentSendId == pk.bookDocumentSendId) &&
                (documentSendId == pk.documentSendId)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(bookDocumentSendId) +
        String.valueOf(documentSendId)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("bookDocumentSendId");
        sb.append(StringPool.EQUAL);
        sb.append(bookDocumentSendId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("documentSendId");
        sb.append(StringPool.EQUAL);
        sb.append(documentSendId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
