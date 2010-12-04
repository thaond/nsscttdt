package com.nss.portlet.journal.service.persistence;

public interface JournalStructureFinder {
    public int countByKeywords(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException;

    public int countByC_G_S_N_D(long companyId, long groupId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByC_G_S_N_D(long companyId, long groupId,
        java.lang.String[] structureIds, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByKeywords(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
        long companyId, long groupId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
        long companyId, long groupId, java.lang.String[] structureIds,
        java.lang.String[] names, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
