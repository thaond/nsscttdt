package com.nss.portlet.chat.service.persistence;

public interface StatusFinder {
    public java.util.List<Object[]> findByModifiedDate(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object[]> findBySocialRelationType(long userId,
        int type, long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object[]> findByUsersGroups(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;
}
