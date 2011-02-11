package com.sgs.portlet.signer.service.persistence;

public class SignerFinderUtil {
    private static SignerFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByH_TEN_P(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByH_TEN_P(lastName, firstName, andOperator);
    }

    public static int countByH_TEN_P(java.lang.String[] lastNames,
        java.lang.String[] firstNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByH_TEN_P(lastNames, firstNames, andOperator);
    }

    public static int countByKeywordsAfterChecked(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywordsAfterChecked(keywords);
    }

    public static int countByH_TEN_AFTER_CHECKED(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByH_TEN_AFTER_CHECKED(lastName, firstName, andOperator);
    }

    public static int countByH_TEN_AFTER_CHECKED(java.lang.String[] lastNames,
        java.lang.String[] firstNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByH_TEN_AFTER_CHECKED(lastNames, firstNames,
            andOperator);
    }

    public static java.util.List<com.liferay.portal.model.User> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> findByH_TEN_P(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByH_TEN_P(lastName, firstName, andOperator, start, end,
            obc);
    }

    public static java.util.List<com.liferay.portal.model.User> findByH_TEN_P(
        java.lang.String[] lastNames, java.lang.String[] firstNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByH_TEN_P(lastNames, firstNames, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> findByKeywordsAfterChecked(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywordsAfterChecked(keywords, start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> findByH_TEN_AFTER_CHECKED(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByH_TEN_AFTER_CHECKED(lastName, firstName, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> findByH_TEN_AFTER_CHECKED(
        java.lang.String[] lastNames, java.lang.String[] firstNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByH_TEN_AFTER_CHECKED(lastNames, firstNames,
            andOperator, start, end, obc);
    }

    public static int containSigner(long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().containSigner(userId);
    }

    public static SignerFinder getFinder() {
        return _finder;
    }

    public void setFinder(SignerFinder finder) {
        _finder = finder;
    }
}
