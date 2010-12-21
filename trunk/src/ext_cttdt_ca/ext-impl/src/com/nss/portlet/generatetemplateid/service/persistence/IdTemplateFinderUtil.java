package com.nss.portlet.generatetemplateid.service.persistence;

public class IdTemplateFinderUtil {
    private static IdTemplateFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByMA_MOTA(java.lang.String format,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByMA_MOTA(format, des, andOperator);
    }

    public static int countByMA_MOTA(java.lang.String[] formats,
        java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByMA_MOTA(formats, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByMA_MOTA(
        java.lang.String format, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByMA_MOTA(format, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByMA_MOTA(
        java.lang.String[] formats, java.lang.String[] des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByMA_MOTA(formats, des, andOperator, start, end, obc);
    }

    public static IdTemplateFinder getFinder() {
        return _finder;
    }

    public void setFinder(IdTemplateFinder finder) {
        _finder = finder;
    }
}
