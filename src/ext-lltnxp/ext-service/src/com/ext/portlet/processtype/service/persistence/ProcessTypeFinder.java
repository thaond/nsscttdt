package com.ext.portlet.processtype.service.persistence;

public interface ProcessTypeFinder {
    public java.util.List<com.ext.portlet.processtype.model.ProcessType> getListProcessType(
        long documentReceiptId) throws java.lang.Exception;
}
