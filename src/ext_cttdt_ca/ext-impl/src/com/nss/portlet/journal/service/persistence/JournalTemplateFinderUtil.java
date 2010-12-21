package com.nss.portlet.journal.service.persistence;

public class JournalTemplateFinderUtil {
    private static JournalTemplateFinder _finder;

    public static int countByKeywords(long companyId, long groupId,
        java.lang.String keywords, java.lang.String structureId,
        java.lang.String structureIdComparator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByKeywords(companyId, groupId, keywords, structureId,
            structureIdComparator);
    }

    public static int countByC_G_T_S_N_D(long companyId, long groupId,
        java.lang.String templateId, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_T_S_N_D(companyId, groupId, templateId,
            structureId, structureIdComparator, name, description, andOperator);
    }

    public static int countByC_G_T_S_N_D(long companyId, long groupId,
        java.lang.String[] templateIds, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_T_S_N_D(companyId, groupId, templateIds,
            structureId, structureIdComparator, names, descriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByKeywords(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.String structureId, java.lang.String structureIdComparator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByKeywords(companyId, groupId, keywords, structureId,
            structureIdComparator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
        long companyId, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_T_S_N_D(companyId, groupId, templateId,
            structureId, structureIdComparator, name, description, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
        long companyId, long groupId, java.lang.String[] templateIds,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String[] names, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_T_S_N_D(companyId, groupId, templateIds,
            structureId, structureIdComparator, names, descriptions,
            andOperator, start, end, obc);
    }

    public static JournalTemplateFinder getFinder() {
        return _finder;
    }

    public void setFinder(JournalTemplateFinder finder) {
        _finder = finder;
    }
}
