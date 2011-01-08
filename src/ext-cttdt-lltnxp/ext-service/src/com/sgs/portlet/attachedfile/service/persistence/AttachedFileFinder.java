package com.sgs.portlet.attachedfile.service.persistence;

public interface AttachedFileFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA(java.lang.String code, java.lang.String name,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByTEN_MA(java.lang.String[] codes,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> findTEN_MA(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> findTEN_MA(
        java.lang.String[] codes, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
