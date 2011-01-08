package com.sgs.portlet.generatetemplateid.service.persistence;

public interface IdGeneratedFinder {
    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end) throws com.liferay.portal.SystemException;
}
