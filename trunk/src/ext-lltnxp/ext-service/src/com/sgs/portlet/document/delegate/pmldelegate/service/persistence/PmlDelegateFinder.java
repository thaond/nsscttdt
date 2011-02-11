package com.sgs.portlet.document.delegate.pmldelegate.service.persistence;

public interface PmlDelegateFinder {
    public java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findAllDelegate(
        int start, int end) throws com.liferay.portal.SystemException;

    public int countAllDelegate() throws com.liferay.portal.SystemException;
}
