package com.nss.portlet.image_signer.service.persistence;

public interface ImageSignerFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_User_Image(java.lang.String firstnames,
        java.lang.String middlenames, java.lang.String lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int count_User_Image(java.lang.String[] firstnames,
        java.lang.String[] middlenames, java.lang.String[] lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> find_user_Image(
        java.lang.String firstnames, java.lang.String middlenames,
        java.lang.String lastnames, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> find_user_Image(
        java.lang.String[] firstnames, java.lang.String[] middlenames,
        java.lang.String[] lastnames, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner getImageSignerByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;
}
