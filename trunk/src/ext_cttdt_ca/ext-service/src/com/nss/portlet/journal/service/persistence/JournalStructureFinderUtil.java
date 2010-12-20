package com.nss.portlet.journal.service.persistence;

public class JournalStructureFinderUtil {
    private static JournalStructureFinder _finder;

    public static int countByKeywords(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(companyId, groupId, keywords);
    }

    public static int countByC_G_S_N_D(long companyId, long groupId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_S_N_D(companyId, groupId, structureId, name,
            description, andOperator);
    }

    public static int countByC_G_S_N_D(long companyId, long groupId,
        java.lang.String[] structureIds, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_S_N_D(companyId, groupId, structureIds, names,
            descriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByKeywords(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByKeywords(companyId, groupId, keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
        long companyId, long groupId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_S_N_D(companyId, groupId, structureId, name,
            description, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByC_G_S_N_D(
        long companyId, long groupId, java.lang.String[] structureIds,
        java.lang.String[] names, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_S_N_D(companyId, groupId, structureIds, names,
            descriptions, andOperator, start, end, obc);
    }

    public static JournalStructureFinder getFinder() {
        return _finder;
    }

    public void setFinder(JournalStructureFinder finder) {
        _finder = finder;
    }
}
