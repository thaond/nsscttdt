package com.nss.portlet.generatetemplateid.service.persistence;

public interface IdTemplateFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByMA_MOTA(java.lang.String format, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByMA_MOTA(java.lang.String[] formats,
        java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByMA_MOTA(
        java.lang.String format, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByMA_MOTA(
        java.lang.String[] formats, java.lang.String[] des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
