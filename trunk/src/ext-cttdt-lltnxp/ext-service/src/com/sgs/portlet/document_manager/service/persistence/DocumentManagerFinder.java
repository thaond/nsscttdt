package com.sgs.portlet.document_manager.service.persistence;

public interface DocumentManagerFinder {
    public int count_document_manager(java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_document_manager(java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
