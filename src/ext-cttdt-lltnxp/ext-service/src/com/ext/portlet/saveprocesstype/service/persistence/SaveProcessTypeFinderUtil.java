package com.ext.portlet.saveprocesstype.service.persistence;

public class SaveProcessTypeFinderUtil {
    private static SaveProcessTypeFinder _finder;

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception {
        return getFinder().getListProcessType(documentReceiptId);
    }

    public static SaveProcessTypeFinder getFinder() {
        return _finder;
    }

    public void setFinder(SaveProcessTypeFinder finder) {
        _finder = finder;
    }
}
