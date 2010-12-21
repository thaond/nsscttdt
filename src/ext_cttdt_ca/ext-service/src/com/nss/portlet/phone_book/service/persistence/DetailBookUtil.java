package com.nss.portlet.phone_book.service.persistence;

public class DetailBookUtil {
    private static DetailBookPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.phone_book.model.DetailBook detailBook) {
        getPersistence().cacheResult(detailBook);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.phone_book.model.DetailBook> detailBooks) {
        getPersistence().cacheResult(detailBooks);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.phone_book.model.DetailBook create(
        long detailBookId) {
        return getPersistence().create(detailBookId);
    }

    public static com.nss.portlet.phone_book.model.DetailBook remove(
        long detailBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException {
        return getPersistence().remove(detailBookId);
    }

    public static com.nss.portlet.phone_book.model.DetailBook remove(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(detailBook);
    }

    /**
     * @deprecated Use <code>update(DetailBook detailBook, boolean merge)</code>.
     */
    public static com.nss.portlet.phone_book.model.DetailBook update(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(detailBook);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                detailBook the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when detailBook is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.phone_book.model.DetailBook update(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(detailBook, merge);
    }

    public static com.nss.portlet.phone_book.model.DetailBook updateImpl(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(detailBook, merge);
    }

    public static com.nss.portlet.phone_book.model.DetailBook findByPrimaryKey(
        long detailBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException {
        return getPersistence().findByPrimaryKey(detailBookId);
    }

    public static com.nss.portlet.phone_book.model.DetailBook fetchByPrimaryKey(
        long detailBookId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(detailBookId);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByCompanyid(
        long companyid) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByCompanyid(
        long companyid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid, start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByCompanyid(
        long companyid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid, start, end, obc);
    }

    public static com.nss.portlet.phone_book.model.DetailBook findByCompanyid_First(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException {
        return getPersistence().findByCompanyid_First(companyid, obc);
    }

    public static com.nss.portlet.phone_book.model.DetailBook findByCompanyid_Last(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException {
        return getPersistence().findByCompanyid_Last(companyid, obc);
    }

    public static com.nss.portlet.phone_book.model.DetailBook[] findByCompanyid_PrevAndNext(
        long detailBookId, long companyid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException {
        return getPersistence()
                   .findByCompanyid_PrevAndNext(detailBookId, companyid, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByCompanyid(long companyid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyid(companyid);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByCompanyid(long companyid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCompanyid(companyid);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static DetailBookPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DetailBookPersistence persistence) {
        _persistence = persistence;
    }
}
