package com.ext.portlet.saveprocesstype.service.persistence;

public interface SaveProcessTypeFinder {
    public java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception;
}
