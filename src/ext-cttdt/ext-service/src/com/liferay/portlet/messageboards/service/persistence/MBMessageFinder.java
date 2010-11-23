package com.liferay.portlet.messageboards.service.persistence;

public interface MBMessageFinder {
    public int countByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException;

    public int countByG_U_A(long groupId, long userId, boolean anonymous)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> findByNoAssets()
        throws com.liferay.portal.SystemException;

    public java.util.List<Long> findByG_U(long groupId, long userId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<Long> findByG_U_A(long groupId, long userId,
        boolean anonymous, int start, int end)
        throws com.liferay.portal.SystemException;
}
