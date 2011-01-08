package com.ext.portlet.processtype.service.persistence;

public class ProcessTypeFinderUtil {
    private static ProcessTypeFinder _finder;

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception {
        return getFinder().getListProcessType(documentReceiptId);
    }

    public static ProcessTypeFinder getFinder() {
        return _finder;
    }

    public void setFinder(ProcessTypeFinder finder) {
        _finder = finder;
    }
}
