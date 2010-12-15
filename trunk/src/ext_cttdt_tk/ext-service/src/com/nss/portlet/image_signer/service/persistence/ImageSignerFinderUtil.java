package com.nss.portlet.image_signer.service.persistence;

public class ImageSignerFinderUtil {
    private static ImageSignerFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_User_Image(java.lang.String firstnames,
        java.lang.String middlenames, java.lang.String lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_User_Image(firstnames, middlenames, lastnames,
            andOperator);
    }

    public static int count_User_Image(java.lang.String[] firstnames,
        java.lang.String[] middlenames, java.lang.String[] lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_User_Image(firstnames, middlenames, lastnames,
            andOperator);
    }

    public static java.util.List<com.liferay.portal.model.User> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> find_user_Image(
        java.lang.String firstnames, java.lang.String middlenames,
        java.lang.String lastnames, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_user_Image(firstnames, middlenames, lastnames, start,
            end, andOperator, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> find_user_Image(
        java.lang.String[] firstnames, java.lang.String[] middlenames,
        java.lang.String[] lastnames, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_user_Image(firstnames, middlenames, lastnames,
            andOperator, start, end, obc);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner getImageSignerByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().getImageSignerByUserId(userId, start, end);
    }

    public static ImageSignerFinder getFinder() {
        return _finder;
    }

    public void setFinder(ImageSignerFinder finder) {
        _finder = finder;
    }
}
