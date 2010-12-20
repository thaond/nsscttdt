package com.nss.portlet.phone_book.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface DetailBookPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.phone_book.model.DetailBook detailBook);

    public void cacheResult(
        java.util.List<com.nss.portlet.phone_book.model.DetailBook> detailBooks);

    public void clearCache();

    public com.nss.portlet.phone_book.model.DetailBook create(long detailBookId);

    public com.nss.portlet.phone_book.model.DetailBook remove(long detailBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException;

    public com.nss.portlet.phone_book.model.DetailBook remove(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(DetailBook detailBook, boolean merge)</code>.
     */
    public com.nss.portlet.phone_book.model.DetailBook update(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.phone_book.model.DetailBook update(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook updateImpl(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook findByPrimaryKey(
        long detailBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchDetailBookException;

    public com.nss.portlet.phone_book.model.DetailBook fetchByPrimaryKey(
        long detailBookId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
