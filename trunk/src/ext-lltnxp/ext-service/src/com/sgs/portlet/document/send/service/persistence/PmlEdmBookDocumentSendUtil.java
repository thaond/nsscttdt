package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmBookDocumentSendUtil {
    private static PmlEdmBookDocumentSendPersistence _persistence;

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend create(
        long bookDocumentSendId) {
        return getPersistence().create(bookDocumentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend remove(
        long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().remove(bookDocumentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmBookDocumentSend);
    }

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentSend pmlEdmBookDocumentSend, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmBookDocumentSend);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmBookDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmBookDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmBookDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmBookDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByPrimaryKey(
        long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByPrimaryKey(bookDocumentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByPrimaryKey(
        long bookDocumentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(bookDocumentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDateCreated_PrevAndNext(
        long bookDocumentSendId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(bookDocumentSendId,
            dateCreated, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord) throws com.liferay.portal.SystemException {
        return getPersistence().findByCurrentRecord(currentRecord);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCurrentRecord(currentRecord, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCurrentRecord(currentRecord, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByCurrentRecord_First(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByCurrentRecord_First(currentRecord, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByCurrentRecord_Last(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByCurrentRecord_Last(currentRecord, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByCurrentRecord_PrevAndNext(
        long bookDocumentSendId, long currentRecord,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByCurrentRecord_PrevAndNext(bookDocumentSendId,
            currentRecord, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartmentsId_PrevAndNext(
        long bookDocumentSendId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(bookDocumentSendId,
            departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start,
            end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDocumentRecordTypeId_First(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDocumentRecordTypeId_Last(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDocumentRecordTypeId_PrevAndNext(bookDocumentSendId,
            documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByAgencyId_First(agencyId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence().findByAgencyId_Last(agencyId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByAgencyId_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByAgencyId_PrevAndNext(bookDocumentSendId, agencyId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocYear_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocYear_First(yearInUse, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocYear_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocYear_Last(yearInUse, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartDocYear_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocYear_PrevAndNext(bookDocumentSendId,
            yearInUse, departmentsId, documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocAgency_First(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocAgency_First(agencyId, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocAgency_Last(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocAgency_Last(agencyId, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartDocAgency_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDepartDocAgency_PrevAndNext(bookDocumentSendId,
            agencyId, departmentsId, documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_First(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId_First(agencyId,
            yearInUse, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_Last(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId_Last(agencyId,
            yearInUse, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByAgencyId_YearInUse_DocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        java.lang.String yearInUse, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByAgencyId_YearInUse_DocumentRecordTypeId_PrevAndNext(bookDocumentSendId,
            agencyId, yearInUse, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYearInUse_AgencyId(yearInUse, agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_AgencyId(yearInUse, agencyId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_AgencyId(yearInUse, agencyId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_AgencyId_First(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_AgencyId_First(yearInUse, agencyId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_AgencyId_Last(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_AgencyId_Last(yearInUse, agencyId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByYearInUse_AgencyId_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_AgencyId_PrevAndNext(bookDocumentSendId,
            yearInUse, agencyId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_First(yearInUse,
            departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_Last(yearInUse,
            departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByYearInUse_DepartmentsId_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_PrevAndNext(bookDocumentSendId,
            yearInUse, departmentsId, obc);
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

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreated(dateCreated);
    }

    public static void removeByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCurrentRecord(currentRecord);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static void removeByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAgencyId(agencyId);
    }

    public static void removeByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static void removeByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId);
    }

    public static void removeByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId);
    }

    public static void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        getPersistence()
            .removeByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException {
        getPersistence()
            .removeByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static void removeByYearInUse_AgencyId(java.lang.String yearInUse,
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        getPersistence().removeByYearInUse_AgencyId(yearInUse, agencyId);
    }

    public static void removeByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByYearInUse_DepartmentsId(yearInUse, departmentsId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreated(dateCreated);
    }

    public static int countByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCurrentRecord(currentRecord);
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static int countByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAgencyId(agencyId);
    }

    public static int countByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static int countByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId);
    }

    public static int countByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId);
    }

    public static int countByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static int countByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static int countByYearInUse_AgencyId(java.lang.String yearInUse,
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().countByYearInUse_AgencyId(yearInUse, agencyId);
    }

    public static int countByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByYearInUse_DepartmentsId(yearInUse, departmentsId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlEdmBookDocumentSendPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmBookDocumentSendPersistence persistence) {
        _persistence = persistence;
    }
}
