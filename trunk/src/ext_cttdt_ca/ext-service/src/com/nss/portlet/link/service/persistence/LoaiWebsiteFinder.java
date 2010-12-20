package com.nss.portlet.link.service.persistence;

public interface LoaiWebsiteFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MOTA(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByTEN_MOTA(java.lang.String[] names,
        java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findTEN_MOTA(
        java.lang.String[] names, java.lang.String[] des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
