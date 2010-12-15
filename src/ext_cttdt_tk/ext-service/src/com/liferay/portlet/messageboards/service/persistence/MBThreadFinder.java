package com.liferay.portlet.messageboards.service.persistence;

public interface MBThreadFinder {
    public int countByS_G_U(long groupId, long userId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByS_G_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.SystemException;
}
