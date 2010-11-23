package com.nss.portlet.co_quan_ban_hanh.service.persistence;

public interface CoQuanBanHanhFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MOTA(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByTEN_MOTA(java.lang.String[] names,
        java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findTEN_MOTA(
        java.lang.String[] names, java.lang.String[] des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
