package com.sgs.portlet.signer.service.persistence;

public interface SignerFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByH_TEN_P(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByH_TEN_P(java.lang.String[] lastNames,
        java.lang.String[] firstNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByKeywordsAfterChecked(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByH_TEN_AFTER_CHECKED(java.lang.String lastName,
        java.lang.String firstName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByH_TEN_AFTER_CHECKED(java.lang.String[] lastNames,
        java.lang.String[] firstNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByH_TEN_P(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByH_TEN_P(
        java.lang.String[] lastNames, java.lang.String[] firstNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByKeywordsAfterChecked(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByH_TEN_AFTER_CHECKED(
        java.lang.String lastName, java.lang.String firstName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByH_TEN_AFTER_CHECKED(
        java.lang.String[] lastNames, java.lang.String[] firstNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int containSigner(long userId)
        throws com.liferay.portal.SystemException;
}
