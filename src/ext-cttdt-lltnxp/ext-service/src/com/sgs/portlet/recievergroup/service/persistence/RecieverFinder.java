package com.sgs.portlet.recievergroup.service.persistence;

public interface RecieverFinder {
    public java.util.List<com.liferay.portal.model.User> findUserByFullName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException;
}
