package com.nss.portlet.journal.service.persistence;

public interface JournalTemplateFinder {
    public int countByKeywords(long companyId, long groupId,
        java.lang.String keywords, java.lang.String structureId,
        java.lang.String structureIdComparator)
        throws com.liferay.portal.SystemException;

    public int countByC_G_T_S_N_D(long companyId, long groupId,
        java.lang.String templateId, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByC_G_T_S_N_D(long companyId, long groupId,
        java.lang.String[] templateIds, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByKeywords(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.String structureId, java.lang.String structureIdComparator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
        long companyId, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
        long companyId, long groupId, java.lang.String[] templateIds,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String[] names, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
