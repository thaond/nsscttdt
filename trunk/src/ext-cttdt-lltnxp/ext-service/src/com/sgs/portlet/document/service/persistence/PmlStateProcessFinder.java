package com.sgs.portlet.document.service.persistence;

public interface PmlStateProcessFinder {
    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception;
}
