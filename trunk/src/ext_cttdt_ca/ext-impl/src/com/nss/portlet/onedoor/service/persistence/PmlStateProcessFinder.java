package com.nss.portlet.onedoor.service.persistence;

public interface PmlStateProcessFinder {
    public java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception;
}
