package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptExtendFinderUtil {
    private static PmlEdmDocumentReceiptExtendFinder _finder;

    public static int getMaxOrderNoByDocumentReceiptId(long documentReceiptId)
        throws java.lang.Exception {
        return getFinder().getMaxOrderNoByDocumentReceiptId(documentReceiptId);
    }

    public static PmlEdmDocumentReceiptExtendFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentReceiptExtendFinder finder) {
        _finder = finder;
    }
}
