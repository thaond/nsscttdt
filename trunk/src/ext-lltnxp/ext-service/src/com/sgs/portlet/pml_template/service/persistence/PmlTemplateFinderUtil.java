package com.sgs.portlet.pml_template.service.persistence;

public class PmlTemplateFinderUtil {
    private static PmlTemplateFinder _finder;

    public static int countPmlTemplate(java.lang.String type,
        java.lang.String valueType) throws com.liferay.portal.SystemException {
        return getFinder().countPmlTemplate(type, valueType);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findPmlTemplate(
        java.lang.String type, java.lang.String valueType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findPmlTemplate(type, valueType, start, end, obc);
    }

    public static PmlTemplateFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlTemplateFinder finder) {
        _finder = finder;
    }
}
