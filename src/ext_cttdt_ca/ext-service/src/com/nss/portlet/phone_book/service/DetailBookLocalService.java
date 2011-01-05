package com.nss.portlet.phone_book.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="DetailBookLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.phone_book.service.impl.DetailBookLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DetailBookLocalService {
    public com.nss.portlet.phone_book.model.DetailBook addDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook createDetailBook(
        long detailBookId);

    public void deleteDetailBook(long detailBookId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.phone_book.model.DetailBook getDetailBook(
        long detailBookId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDetailBooksCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook updateDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook updateDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException;

    public int countByKeyword(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByKeyword(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDetailBook(java.lang.String detailBookCodes,
        java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findDetailBook(
        java.lang.String detailBookCodes, java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(long companyId,
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndexIndex(long companyId,
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long detailBookId, java.lang.String detailBookCode,
        java.lang.String detailBookName, java.lang.String detailDescription,
        java.lang.String zip, java.lang.String internal, java.lang.String home,
        java.lang.String mobile, java.lang.String email,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long detailBookId, java.lang.String keywords,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits searchIndex(long companyId,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.DetailBook addDetailBook(
        long companyId, com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.nss.portlet.phone_book.model.DetailBook addDetailBookIndex(
        long companyId, com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.nss.portlet.phone_book.model.DetailBook updateDetailBook(
        long companyId, com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.nss.portlet.phone_book.model.DetailBook updateDetailBookIndex(
        long companyId, com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deleteDetailBook(long companyId, long detailBookId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.phone_book.NoSuchDetailBookException;

    public void deleteDetailBook(long companyId,
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deleteDetailBookIndex(long companyId, long detailBookId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.phone_book.NoSuchDetailBookException;

    public void deleteDetailBookIndex(long companyId,
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;
}
