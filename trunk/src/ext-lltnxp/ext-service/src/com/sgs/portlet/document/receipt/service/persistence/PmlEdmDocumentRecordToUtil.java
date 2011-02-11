package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentRecordToUtil {
    private static PmlEdmDocumentRecordToPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo create(
        long documentRecordToId) {
        return getPersistence().create(documentRecordToId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo remove(
        long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().remove(documentRecordToId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentRecordTo);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRecordTo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordTo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordTo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRecordTo, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentRecordTo, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByPrimaryKey(
        long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByPrimaryKey(documentRecordToId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByPrimaryKey(
        long documentRecordToId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentRecordToId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDateCreate_First(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByDateCreate_First(dateCreate, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDateCreate_Last(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByDateCreate_Last(dateCreate, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDateCreate_PrevAndNext(
        long documentRecordToId, java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDateCreate_PrevAndNext(documentRecordToId,
            dateCreate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord) throws com.liferay.portal.SystemException {
        return getPersistence().findByCurrentRecord(currentRecord);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCurrentRecord(currentRecord, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCurrentRecord(currentRecord, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByCurrentRecord_First(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByCurrentRecord_First(currentRecord, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByCurrentRecord_Last(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByCurrentRecord_Last(currentRecord, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByCurrentRecord_PrevAndNext(
        long documentRecordToId, long currentRecord,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByCurrentRecord_PrevAndNext(documentRecordToId,
            currentRecord, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartmentsId_PrevAndNext(
        long documentRecordToId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(documentRecordToId,
            departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordTypeId_First(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordTypeId_Last(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDocumentRecordTypeId_PrevAndNext(
        long documentRecordToId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordTypeId_PrevAndNext(documentRecordToId,
            documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse) throws com.liferay.portal.SystemException {
        return getPersistence().findByYearInUse(yearInUse);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYearInUse(yearInUse, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYearInUse(yearInUse, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_First(
        java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByYearInUse_First(yearInUse, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_Last(
        java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByYearInUse_Last(yearInUse, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_PrevAndNext(documentRecordToId, yearInUse,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByAgencyId_First(agencyId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence().findByAgencyId_Last(agencyId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgencyId_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgencyId_PrevAndNext(documentRecordToId, agencyId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocYear_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocYear_First(yearInUse, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocYear_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocYear_Last(yearInUse, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartDocYear_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocYear_PrevAndNext(documentRecordToId,
            yearInUse, departmentsId, documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocAgency_First(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocAgency_First(agencyId, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocAgency_Last(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocAgency_Last(agencyId, departmentsId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartDocAgency_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDepartDocAgency_PrevAndNext(documentRecordToId,
            agencyId, departmentsId, documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_First(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo_First(agencyId,
            yearInUse, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_Last(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo_Last(agencyId,
            yearInUse, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgencyId_Year_DocumentRecordTo_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        java.lang.String yearInUse, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgencyId_Year_DocumentRecordTo_PrevAndNext(documentRecordToId,
            agencyId, yearInUse, documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgency_DocumentType(agencyId, documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgency_DocumentType(agencyId, documentRecordTypeId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAgency_DocumentType(agencyId, documentRecordTypeId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgency_DocumentType_First(
        java.lang.String agencyId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgency_DocumentType_First(agencyId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgency_DocumentType_Last(
        java.lang.String agencyId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgency_DocumentType_Last(agencyId,
            documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgency_DocumentType_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByAgency_DocumentType_PrevAndNext(documentRecordToId,
            agencyId, documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
            agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYearInUse_AgencyId(yearInUse, agencyId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_AgencyId(yearInUse, agencyId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_AgencyId(yearInUse, agencyId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_AgencyId_First(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_AgencyId_First(yearInUse, agencyId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_AgencyId_Last(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_AgencyId_Last(yearInUse, agencyId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_AgencyId_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_AgencyId_PrevAndNext(documentRecordToId,
            yearInUse, agencyId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId(yearInUse, departmentsId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_First(yearInUse,
            departmentsId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_Last(yearInUse,
            departmentsId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_DepartmentsId_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        return getPersistence()
                   .findByYearInUse_DepartmentsId_PrevAndNext(documentRecordToId,
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreate(dateCreate);
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

    public static void removeByYearInUse(java.lang.String yearInUse)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByYearInUse(yearInUse);
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

    public static void removeByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId);
    }

    public static void removeByAgency_DocumentType(java.lang.String agencyId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByAgency_DocumentType(agencyId, documentRecordTypeId);
    }

    public static void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
        getPersistence()
            .removeByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
            departmentsId);
    }

    public static void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException {
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

    public static int countByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreate(dateCreate);
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

    public static int countByYearInUse(java.lang.String yearInUse)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByYearInUse(yearInUse);
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

    public static int countByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId);
    }

    public static int countByAgency_DocumentType(java.lang.String agencyId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByAgency_DocumentType(agencyId, documentRecordTypeId);
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

    public static PmlEdmDocumentRecordToPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentRecordToPersistence persistence) {
        _persistence = persistence;
    }
}
