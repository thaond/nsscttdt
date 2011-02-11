package com.sgs.portlet.receivergroup.service.persistence;

public interface ReceiverFinder {
    public java.util.List<com.liferay.portal.model.User> findUserByFullName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException;
}
