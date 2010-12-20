package com.nss.portlet.chat.service.persistence;

public interface EntryFinder {
    public java.util.List<com.nss.portlet.chat.model.Entry> findByEmptyContent(
        long fromUserId, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByNew(
        long userId, long createDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByOld(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException;
}
